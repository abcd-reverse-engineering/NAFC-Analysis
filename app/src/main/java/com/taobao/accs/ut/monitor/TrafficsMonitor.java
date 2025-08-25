package com.taobao.accs.ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TrafficsMonitor {

    /* renamed from: d, reason: collision with root package name */
    private Context f8624d;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, List<a>> f8621a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f8622b = new HashMap<String, String>() { // from class: com.taobao.accs.ut.monitor.TrafficsMonitor.1
        {
            put("im", "512");
            put("motu", "513");
            put("acds", "514");
            put(GlobalClientInfo.AGOO_SERVICE_ID, "515");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "515");
            put("agooTokenReport", "515");
            put("accsSelf", Constants.DEFAULT_UIN);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private int f8623c = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f8625e = "";

    /* compiled from: Taobao */
    @Monitor(module = "NetworkSDK", monitorPoint = "TrafficStats")
    public static class StatTrafficMonitor extends BaseMonitor {

        @Dimension
        public String bizId;

        @Dimension
        public String date;

        @Dimension
        public String host;

        @Dimension
        public boolean isBackground;

        @Dimension
        public String serviceId;

        @Measure
        public long size;
    }

    public TrafficsMonitor(Context context) {
        this.f8624d = context;
    }

    private void b() {
        String str;
        boolean z;
        synchronized (this.f8621a) {
            String strA = UtilityImpl.a(System.currentTimeMillis());
            if (TextUtils.isEmpty(this.f8625e) || this.f8625e.equals(strA)) {
                str = strA;
                z = false;
            } else {
                str = this.f8625e;
                z = true;
            }
            Iterator<String> it = this.f8621a.keySet().iterator();
            while (it.hasNext()) {
                for (a aVar : this.f8621a.get(it.next())) {
                    if (aVar != null) {
                        com.taobao.accs.b.a.a(this.f8624d).a(aVar.f8631e, aVar.f8629c, this.f8622b.get(aVar.f8629c), aVar.f8630d, aVar.f8632f, str);
                    }
                }
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("TrafficsMonitor", "savetoDay:" + str + " saveTraffics" + this.f8621a.toString(), new Object[0]);
            }
            if (z) {
                this.f8621a.clear();
                c();
            } else if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("TrafficsMonitor", "no need commit lastsaveDay:" + this.f8625e + " currday:" + strA, new Object[0]);
            }
            this.f8625e = strA;
            this.f8623c = 0;
        }
    }

    private void c() {
        List<a> listA = com.taobao.accs.b.a.a(this.f8624d).a(false);
        if (listA == null) {
            return;
        }
        try {
            for (a aVar : listA) {
                if (aVar != null) {
                    StatTrafficMonitor statTrafficMonitor = new StatTrafficMonitor();
                    statTrafficMonitor.bizId = aVar.f8628b;
                    statTrafficMonitor.date = aVar.f8627a;
                    statTrafficMonitor.host = aVar.f8631e;
                    statTrafficMonitor.isBackground = aVar.f8630d;
                    statTrafficMonitor.size = aVar.f8632f;
                    AppMonitor.getInstance().commitStat(statTrafficMonitor);
                }
            }
            com.taobao.accs.b.a.a(this.f8624d).a();
        } catch (Throwable th) {
            ALog.e("", th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    public void a(a aVar) {
        boolean z;
        if (aVar == null || aVar.f8631e == null || aVar.f8632f <= 0) {
            return;
        }
        aVar.f8629c = TextUtils.isEmpty(aVar.f8629c) ? "accsSelf" : aVar.f8629c;
        synchronized (this.f8621a) {
            String str = this.f8622b.get(aVar.f8629c);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            aVar.f8628b = str;
            ALog.isPrintLog(ALog.Level.D);
            List<a> arrayList = this.f8621a.get(str);
            if (arrayList != null) {
                Iterator<a> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    a next = it.next();
                    if (next.f8630d == aVar.f8630d && next.f8631e != null && next.f8631e.equals(aVar.f8631e)) {
                        next.f8632f += aVar.f8632f;
                        z = false;
                        break;
                    }
                }
                if (z) {
                    arrayList.add(aVar);
                }
            } else {
                arrayList = new ArrayList<>();
                arrayList.add(aVar);
            }
            this.f8621a.put(str, arrayList);
            this.f8623c++;
            if (this.f8623c >= 10) {
                b();
            }
        }
    }

    /* compiled from: Taobao */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f8627a;

        /* renamed from: b, reason: collision with root package name */
        String f8628b;

        /* renamed from: c, reason: collision with root package name */
        String f8629c;

        /* renamed from: d, reason: collision with root package name */
        boolean f8630d;

        /* renamed from: e, reason: collision with root package name */
        String f8631e;

        /* renamed from: f, reason: collision with root package name */
        long f8632f;

        public a(String str, boolean z, String str2, long j2) {
            this.f8629c = str;
            this.f8630d = z;
            this.f8631e = str2;
            this.f8632f = j2;
        }

        public String toString() {
            return "date:" + this.f8627a + c.c.a.b.a.a.f3100g + "bizId:" + this.f8628b + c.c.a.b.a.a.f3100g + "serviceId:" + this.f8629c + c.c.a.b.a.a.f3100g + "host:" + this.f8631e + c.c.a.b.a.a.f3100g + "isBackground:" + this.f8630d + c.c.a.b.a.a.f3100g + "size:" + this.f8632f;
        }

        public a(String str, String str2, String str3, boolean z, String str4, long j2) {
            this.f8627a = str;
            this.f8628b = str2;
            this.f8629c = str3;
            this.f8630d = z;
            this.f8631e = str4;
            this.f8632f = j2;
        }
    }

    public void a() {
        try {
            synchronized (this.f8621a) {
                this.f8621a.clear();
            }
            List<a> listA = com.taobao.accs.b.a.a(this.f8624d).a(true);
            if (listA == null) {
                return;
            }
            Iterator<a> it = listA.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } catch (Exception e2) {
            ALog.w("TrafficsMonitor", e2.toString(), new Object[0]);
        }
    }
}
