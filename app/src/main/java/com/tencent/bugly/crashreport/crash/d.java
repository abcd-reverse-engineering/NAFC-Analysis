package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f9101a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.strategy.a f9102b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.info.a f9103c;

    /* renamed from: d, reason: collision with root package name */
    private b f9104d;

    /* renamed from: e, reason: collision with root package name */
    private Context f9105e;

    private d(Context context) {
        c cVarA = c.a();
        if (cVarA == null) {
            return;
        }
        this.f9102b = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f9103c = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f9104d = cVarA.p;
        this.f9105e = context;
        am.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        an.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.proguard.o");
            this.f9103c.getClass();
            aq.a(cls, "sdkPackageName", "com.tencent.bugly", (Object) null);
            an.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            an.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        String str4;
        Thread threadCurrentThread = thread == null ? Thread.currentThread() : thread;
        if (i2 == 4) {
            str4 = "Unity";
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else {
            if (i2 != 8) {
                an.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i2));
                return;
            }
            str4 = "H5";
        }
        String str5 = str4;
        an.e("[ExtraCrashManager] %s Crash Happen", str5);
        try {
            if (!this.f9102b.b()) {
                an.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean strategyBeanC = this.f9102b.c();
            if (!strategyBeanC.f8998g && this.f9102b.b()) {
                an.e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                b.a(str5, aq.a(), this.f9103c.f8978e, threadCurrentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                an.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i2 != 4) {
                if (i2 == 5 || i2 == 6) {
                    if (!strategyBeanC.f9003l) {
                        an.e("[ExtraCrashManager] %s report is disabled.", str5);
                        an.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                        return;
                    }
                } else if (i2 == 8 && !strategyBeanC.f9004m) {
                    an.e("[ExtraCrashManager] %s report is disabled.", str5);
                    an.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            }
            CrashDetailBean crashDetailBeanB = b(threadCurrentThread, i2 == 8 ? 5 : i2, str, str2, str3, map);
            if (crashDetailBeanB == null) {
                an.e("[ExtraCrashManager] Failed to package crash data.", new Object[0]);
                an.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            b.a(str5, aq.a(), this.f9103c.f8978e, threadCurrentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBeanB);
            if (!this.f9104d.a(crashDetailBeanB)) {
                this.f9104d.a(crashDetailBeanB, 3000L, false);
            }
            an.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                an.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                an.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    public static d a(Context context) {
        if (f9101a == null) {
            f9101a = new d(context);
        }
        return f9101a;
    }

    public static void a(final Thread thread, final int i2, final String str, final String str2, final String str3, final Map<String, String> map) {
        am.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.f9101a == null) {
                        an.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        d.f9101a.c(thread, i2, str, str2, str3, map);
                    }
                } catch (Throwable th) {
                    if (!an.b(th)) {
                        th.printStackTrace();
                    }
                    an.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }

    private CrashDetailBean b(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.i();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.k();
        crashDetailBean.F = this.f9103c.p();
        crashDetailBean.G = this.f9103c.o();
        crashDetailBean.H = this.f9103c.q();
        crashDetailBean.w = aq.a(this.f9105e, c.f9084e, c.f9087h);
        crashDetailBean.f9023b = i2;
        crashDetailBean.f9026e = this.f9103c.h();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f9103c;
        crashDetailBean.f9027f = aVar.p;
        crashDetailBean.f9028g = aVar.w();
        crashDetailBean.f9034m = this.f9103c.g();
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        sb.append("");
        sb.append(str);
        crashDetailBean.n = sb.toString();
        crashDetailBean.o = "" + str2;
        if (str3 != null) {
            String[] strArrSplit = str3.split("\n");
            if (strArrSplit.length > 0) {
                str4 = strArrSplit[0];
            }
        } else {
            str3 = "";
        }
        crashDetailBean.p = str4;
        crashDetailBean.q = str3;
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = aq.b(crashDetailBean.q.getBytes());
        crashDetailBean.z = aq.a(c.f9085f, false);
        crashDetailBean.A = this.f9103c.f8978e;
        crashDetailBean.B = thread.getName() + "(" + thread.getId() + ")";
        crashDetailBean.I = this.f9103c.y();
        crashDetailBean.f9029h = this.f9103c.v();
        com.tencent.bugly.crashreport.common.info.a aVar2 = this.f9103c;
        crashDetailBean.N = aVar2.f8974a;
        crashDetailBean.O = aVar2.a();
        crashDetailBean.Q = this.f9103c.H();
        crashDetailBean.R = this.f9103c.I();
        crashDetailBean.S = this.f9103c.B();
        crashDetailBean.T = this.f9103c.G();
        if (!c.a().o()) {
            this.f9104d.c(crashDetailBean);
        }
        crashDetailBean.y = ap.a();
        if (crashDetailBean.P == null) {
            crashDetailBean.P = new LinkedHashMap();
        }
        if (map != null) {
            crashDetailBean.P.putAll(map);
        }
        return crashDetailBean;
    }
}
