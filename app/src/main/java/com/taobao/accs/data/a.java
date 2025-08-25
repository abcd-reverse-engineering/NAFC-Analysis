package com.taobao.accs.data;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.cw;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a {
    public static final int SPLITTED_DATA_INDEX = 17;
    public static final int SPLITTED_DATA_MD5 = 18;
    public static final int SPLITTED_DATA_NUMS = 16;
    public static final int SPLITTED_TIME_OUT = 15;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f8440a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private String f8441b;

    /* renamed from: c, reason: collision with root package name */
    private int f8442c;

    /* renamed from: d, reason: collision with root package name */
    private String f8443d;

    /* renamed from: e, reason: collision with root package name */
    private long f8444e;

    /* renamed from: g, reason: collision with root package name */
    private ScheduledFuture<?> f8446g;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f8445f = 0;

    /* renamed from: h, reason: collision with root package name */
    private Map<Integer, byte[]> f8447h = new TreeMap(new b(this));

    public a(String str, int i2, String str2) {
        this.f8441b = str;
        this.f8442c = i2;
        this.f8443d = str2;
    }

    public void a(long j2) {
        if (j2 <= 0) {
            j2 = 30000;
        }
        this.f8446g = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new c(this), j2, TimeUnit.MILLISECONDS);
    }

    public byte[] a(int i2, int i3, byte[] bArr) {
        long jCurrentTimeMillis;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("AssembleMessage", "putBurst", Constants.KEY_DATA_ID, this.f8441b, "index", Integer.valueOf(i2));
        }
        if (i3 != this.f8442c) {
            ALog.e("AssembleMessage", "putBurst fail as burstNums not match", new Object[0]);
            return null;
        }
        if (i2 >= 0 && i2 < i3) {
            synchronized (this) {
                if (this.f8445f != 0) {
                    ALog.e("AssembleMessage", "putBurst fail", NotificationCompat.CATEGORY_STATUS, Integer.valueOf(this.f8445f));
                } else {
                    if (this.f8447h.get(Integer.valueOf(i2)) != null) {
                        ALog.e("AssembleMessage", "putBurst fail as exist old", new Object[0]);
                        return null;
                    }
                    if (this.f8447h.isEmpty()) {
                        this.f8444e = System.currentTimeMillis();
                    }
                    this.f8447h.put(Integer.valueOf(i2), bArr);
                    if (this.f8447h.size() == this.f8442c) {
                        byte[] bArr2 = null;
                        for (byte[] bArr3 : this.f8447h.values()) {
                            if (bArr2 == null) {
                                bArr2 = bArr3;
                            } else {
                                byte[] bArr4 = new byte[bArr2.length + bArr3.length];
                                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
                                System.arraycopy(bArr3, 0, bArr4, bArr2.length, bArr3.length);
                                bArr2 = bArr4;
                            }
                        }
                        if (!TextUtils.isEmpty(this.f8443d)) {
                            String str = new String(a(org.android.agoo.common.a.a(bArr2)));
                            if (!this.f8443d.equals(str)) {
                                ALog.w("AssembleMessage", "putBurst fail", Constants.KEY_DATA_ID, this.f8441b, "dataMd5", this.f8443d, "finalDataMd5", str);
                                this.f8445f = 3;
                                bArr2 = null;
                            }
                        }
                        long length = 0;
                        if (bArr2 != null) {
                            length = bArr2.length;
                            jCurrentTimeMillis = System.currentTimeMillis() - this.f8444e;
                            this.f8445f = 2;
                            ALog.i("AssembleMessage", "putBurst completed", Constants.KEY_DATA_ID, this.f8441b, "length", Long.valueOf(length), "cost", Long.valueOf(jCurrentTimeMillis));
                        } else {
                            jCurrentTimeMillis = 0;
                        }
                        AssembleMonitor assembleMonitor = new AssembleMonitor(this.f8441b, String.valueOf(this.f8445f));
                        assembleMonitor.assembleLength = length;
                        assembleMonitor.assembleTimes = jCurrentTimeMillis;
                        AppMonitor.getInstance().commitStat(assembleMonitor);
                        this.f8447h.clear();
                        if (this.f8446g != null) {
                            this.f8446g.cancel(false);
                        }
                        return bArr2;
                    }
                }
                return null;
            }
        }
        ALog.e("AssembleMessage", "putBurst fail as burstIndex invalid", new Object[0]);
        return null;
    }

    private static char[] a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            char[] cArr2 = f8440a;
            cArr[i2] = cArr2[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & cw.f10303m];
        }
        return cArr;
    }
}
