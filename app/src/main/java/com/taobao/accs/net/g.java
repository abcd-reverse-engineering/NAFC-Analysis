package com.taobao.accs.net;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.internal.AccsJobService;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: b, reason: collision with root package name */
    protected static volatile g f8521b;

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f8522c = {SubsamplingScaleImageView.ORIENTATION_270, 360, 480};

    /* renamed from: a, reason: collision with root package name */
    protected Context f8523a;

    /* renamed from: d, reason: collision with root package name */
    private int f8524d;

    /* renamed from: e, reason: collision with root package name */
    private long f8525e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8526f = false;

    /* renamed from: g, reason: collision with root package name */
    private int[] f8527g = {0, 0, 0};

    /* renamed from: h, reason: collision with root package name */
    private boolean f8528h;

    protected g(Context context) {
        this.f8528h = true;
        try {
            this.f8523a = context;
            this.f8524d = 0;
            this.f8525e = System.currentTimeMillis();
            this.f8528h = com.taobao.accs.utl.t.a();
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "HeartbeatManager", th, new Object[0]);
        }
    }

    public static g a(Context context) {
        if (f8521b == null) {
            synchronized (g.class) {
                if (f8521b == null) {
                    if (GlobalConfig.isJobHeartbeatEnable() && Build.VERSION.SDK_INT >= 21 && b(context)) {
                        ALog.i("HeartbeatManager", "hb use job", new Object[0]);
                        f8521b = new f(context);
                    } else {
                        ALog.i("HeartbeatManager", "hb use alarm", new Object[0]);
                        f8521b = new e(context);
                    }
                }
            }
        }
        return f8521b;
    }

    private static boolean b(Context context) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), AccsJobService.class.getName()), 0);
            if (serviceInfo != null) {
                return serviceInfo.isEnabled();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    protected abstract void a(int i2);

    public void c() {
        this.f8525e = -1L;
        if (this.f8526f) {
            int[] iArr = this.f8527g;
            int i2 = this.f8524d;
            iArr[i2] = iArr[i2] + 1;
        }
        int i3 = this.f8524d;
        this.f8524d = i3 > 0 ? i3 - 1 : 0;
        ALog.d("HeartbeatManager", "onNetworkTimeout", new Object[0]);
    }

    public void d() {
        this.f8525e = -1L;
        ALog.d("HeartbeatManager", "onNetworkFail", new Object[0]);
    }

    public void e() {
        ALog.d("HeartbeatManager", "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.f8525e <= 7199000) {
            this.f8526f = false;
            this.f8527g[this.f8524d] = 0;
            return;
        }
        int i2 = this.f8524d;
        if (i2 >= f8522c.length - 1 || this.f8527g[i2] > 2) {
            return;
        }
        ALog.d("HeartbeatManager", "upgrade", new Object[0]);
        this.f8524d++;
        this.f8526f = true;
        this.f8525e = System.currentTimeMillis();
    }

    public void f() {
        this.f8524d = 0;
        this.f8525e = System.currentTimeMillis();
        ALog.d("HeartbeatManager", "resetLevel", new Object[0]);
    }

    public int b() {
        int i2 = this.f8528h ? f8522c[this.f8524d] : SubsamplingScaleImageView.ORIENTATION_270;
        this.f8528h = com.taobao.accs.utl.t.a();
        return i2;
    }

    public synchronized void a() {
        try {
            if (this.f8525e < 0) {
                this.f8525e = System.currentTimeMillis();
            }
            int iB = b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("HeartbeatManager", "set " + iB, new Object[0]);
            }
            a(iB);
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "set", th, new Object[0]);
        }
    }
}
