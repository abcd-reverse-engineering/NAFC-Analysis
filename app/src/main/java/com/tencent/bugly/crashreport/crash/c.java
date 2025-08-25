package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Build;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f9080a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f9081b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f9082c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f9083d = true;

    /* renamed from: e, reason: collision with root package name */
    public static int f9084e = 20480;

    /* renamed from: f, reason: collision with root package name */
    public static int f9085f = 20480;

    /* renamed from: g, reason: collision with root package name */
    public static long f9086g = 604800000;

    /* renamed from: h, reason: collision with root package name */
    public static String f9087h = null;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f9088i = false;

    /* renamed from: j, reason: collision with root package name */
    public static String f9089j = null;

    /* renamed from: k, reason: collision with root package name */
    public static int f9090k = 5000;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f9091l = true;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f9092m = false;
    public static String n;
    public static String o;
    private static c v;
    private int A = 31;
    private boolean B = false;
    public final b p;
    public final com.tencent.bugly.crashreport.common.strategy.a q;
    public final am r;
    public BuglyStrategy.a s;
    public f t;
    private final Context u;
    private final e w;
    private final NativeCrashHandler x;
    private final com.tencent.bugly.crashreport.crash.anr.b y;
    private Boolean z;

    protected c(int i2, Context context, am amVar, boolean z, BuglyStrategy.a aVar, f fVar, String str) {
        f9080a = i2;
        Context contextA = aq.a(context);
        this.u = contextA;
        this.q = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.r = amVar;
        this.s = aVar;
        this.t = fVar;
        ak akVarA = ak.a();
        ae aeVarA = ae.a();
        this.p = new b(i2, contextA, akVarA, aeVarA, this.q, aVar, fVar);
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(contextA);
        this.w = new e(contextA, this.p, this.q, aVarA);
        this.x = NativeCrashHandler.getInstance(contextA, aVarA, this.p, this.q, amVar, z, str);
        aVarA.O = this.x;
        this.y = new com.tencent.bugly.crashreport.crash.anr.b(contextA, this.q, aVarA, amVar, aeVarA, this.p, aVar);
    }

    public synchronized void c() {
        f();
        h();
        i();
    }

    public synchronized void d() {
        e();
        g();
        j();
    }

    public void e() {
        this.w.b();
    }

    public void f() {
        this.w.a();
    }

    public void g() {
        this.x.setUserOpened(false);
    }

    public void h() {
        this.x.setUserOpened(true);
    }

    public void i() {
        if (Build.VERSION.SDK_INT <= 19) {
            this.y.b(true);
        } else {
            this.y.h();
        }
    }

    public void j() {
        if (Build.VERSION.SDK_INT < 19) {
            this.y.b(false);
        } else {
            this.y.i();
        }
    }

    public synchronized void k() {
        this.y.g();
    }

    public boolean l() {
        return this.y.a();
    }

    public void m() {
        this.x.checkUploadRecordCrash();
    }

    public void n() {
        if (com.tencent.bugly.crashreport.common.info.a.b().f8978e.equals(AppInfo.a(this.u))) {
            this.x.removeEmptyNativeRecordFiles();
        }
    }

    public boolean o() {
        return this.B;
    }

    public boolean p() {
        return (this.A & 16) > 0;
    }

    public boolean q() {
        return (this.A & 8) > 0;
    }

    public boolean r() {
        return (this.A & 4) > 0;
    }

    public boolean s() {
        return (this.A & 2) > 0;
    }

    public boolean t() {
        return (this.A & 1) > 0;
    }

    public static synchronized c a(int i2, Context context, boolean z, BuglyStrategy.a aVar, f fVar, String str) {
        if (v == null) {
            v = new c(i2, context, am.a(), z, aVar, fVar, str);
        }
        return v;
    }

    public boolean b() {
        Boolean bool = this.z;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.b().f8978e;
        List<ag> listA = ae.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (listA == null || listA.size() <= 0) {
            this.z = false;
            return false;
        }
        for (ag agVar : listA) {
            if (str.equals(agVar.f9205c)) {
                this.z = true;
                arrayList.add(agVar);
            }
        }
        if (arrayList.size() > 0) {
            ae.a().a(arrayList);
        }
        return true;
    }

    public static synchronized c a() {
        return v;
    }

    public void a(StrategyBean strategyBean) {
        this.w.a(strategyBean);
        this.x.onStrategyChanged(strategyBean);
        this.y.a(strategyBean);
        a(3000L);
    }

    public synchronized void a(boolean z, boolean z2, boolean z3) {
        this.x.testNativeCrash(z, z2, z3);
    }

    public void a(final Thread thread, final Throwable th, final boolean z, final String str, final byte[] bArr, final boolean z2) {
        this.r.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    an.c("post a throwable %b", Boolean.valueOf(z));
                    c.this.w.b(thread, th, false, str, bArr);
                    if (z2) {
                        an.a("clear user datas", new Object[0]);
                        com.tencent.bugly.crashreport.common.info.a.a(c.this.u).C();
                    }
                } catch (Throwable th2) {
                    if (!an.b(th2)) {
                        th2.printStackTrace();
                    }
                    an.e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public void a(CrashDetailBean crashDetailBean) {
        this.p.e(crashDetailBean);
    }

    public void a(long j2) {
        am.a().a(new Thread() { // from class: com.tencent.bugly.crashreport.crash.c.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                List<CrashDetailBean> list;
                if (aq.a(c.this.u, "local_crash_lock", com.heytap.mcssdk.constant.a.q)) {
                    List<CrashDetailBean> listA = c.this.p.a();
                    if (listA != null && listA.size() > 0) {
                        an.c("Size of crash list: %s", Integer.valueOf(listA.size()));
                        int size = listA.size();
                        if (size > 20) {
                            ArrayList arrayList = new ArrayList();
                            Collections.sort(listA);
                            for (int i2 = 0; i2 < 20; i2++) {
                                arrayList.add(listA.get((size - 1) - i2));
                            }
                            list = arrayList;
                        } else {
                            list = listA;
                        }
                        c.this.p.a(list, 0L, false, false, false);
                    }
                    aq.c(c.this.u, "local_crash_lock");
                }
            }
        }, j2);
    }

    public void a(int i2) {
        this.A = i2;
    }

    public void a(boolean z) {
        this.B = z;
    }
}
