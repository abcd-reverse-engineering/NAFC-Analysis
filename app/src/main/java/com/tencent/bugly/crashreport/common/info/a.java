package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a {
    private static a ap;
    public boolean H;
    public SharedPreferences P;
    private final Context Q;
    private String R;
    private String S;

    /* renamed from: b, reason: collision with root package name */
    public final String f8975b;

    /* renamed from: d, reason: collision with root package name */
    public String f8977d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8978e;

    /* renamed from: f, reason: collision with root package name */
    public String f8979f;

    /* renamed from: g, reason: collision with root package name */
    public String f8980g;

    /* renamed from: l, reason: collision with root package name */
    public final String f8985l;

    /* renamed from: m, reason: collision with root package name */
    public final String f8986m;
    public final String n;
    public int q;
    public String r;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8981h = true;

    /* renamed from: i, reason: collision with root package name */
    public final String f8982i = "com.tencent.bugly";

    /* renamed from: j, reason: collision with root package name */
    public String f8983j = "3.1.7(1.4.5)";

    /* renamed from: k, reason: collision with root package name */
    public final String f8984k = "";
    private String T = "unknown";
    private String U = "unknown";
    private String V = "";
    public long o = 0;
    private String W = null;
    private String X = null;
    private String Y = null;
    private String Z = null;
    private long aa = -1;
    private long ab = -1;
    private long ac = -1;
    private String ad = null;
    private String ae = null;
    private Map<String, PlugInBean> af = null;
    private boolean ag = true;
    private String ah = null;
    public String p = null;
    private String ai = null;
    public String s = null;
    private Boolean aj = null;
    private String ak = null;
    private String al = null;
    private String am = null;
    public String t = null;
    public String u = null;
    private Map<String, PlugInBean> an = null;
    private Map<String, PlugInBean> ao = null;
    public List<String> v = null;
    private int aq = -1;
    private int ar = -1;
    private Map<String, String> as = new HashMap();
    private Map<String, String> at = new HashMap();
    private Map<String, String> au = new HashMap();
    private boolean av = true;
    public String w = "unknown";
    public long x = 0;
    public long y = 0;
    public long z = 0;
    public long A = 0;
    public boolean B = false;
    public String C = null;
    public String D = null;
    public String E = null;
    public String F = "";
    public boolean G = false;
    public Boolean I = null;
    public Boolean J = null;
    public HashMap<String, String> K = new HashMap<>();
    private String aw = null;
    private String ax = null;
    private String ay = null;
    private String az = null;
    private String aA = null;
    public boolean L = true;
    public List<String> M = new ArrayList();
    public boolean N = false;
    public com.tencent.bugly.crashreport.a O = null;
    private final Object aB = new Object();
    private final Object aC = new Object();
    private final Object aD = new Object();
    private final Object aE = new Object();
    private final Object aF = new Object();
    private final Object aG = new Object();
    private final Object aH = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final long f8974a = System.currentTimeMillis();

    /* renamed from: c, reason: collision with root package name */
    public final byte f8976c = 1;

    private a(Context context) {
        this.r = null;
        this.H = false;
        this.Q = aq.a(context);
        b(context);
        this.f8977d = AppInfo.a(context);
        this.f8978e = AppInfo.a(context, Process.myPid());
        this.f8985l = b.m();
        this.f8986m = b.a();
        this.r = AppInfo.c(context);
        this.n = "Android " + b.b() + ",level " + b.c();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8986m);
        sb.append(";");
        sb.append(this.n);
        this.f8975b = sb.toString();
        c(context);
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.H = true;
                an.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f8759c) {
                th.printStackTrace();
            }
        }
        this.P = aq.a("BUGLY_COMMON_VALUES", context);
        an.c("com info create end", new Object[0]);
    }

    private void b(Context context) {
        PackageInfo packageInfoB = AppInfo.b(context);
        if (packageInfoB == null) {
            return;
        }
        try {
            this.p = packageInfoB.versionName;
            this.C = this.p;
            this.D = Integer.toString(packageInfoB.versionCode);
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private void c(Context context) {
        Map<String, String> mapD = AppInfo.d(context);
        if (mapD == null) {
            return;
        }
        try {
            this.v = AppInfo.a(mapD);
            String str = mapD.get("BUGLY_APPID");
            if (str != null) {
                this.ai = str;
                c("APP_ID", this.ai);
            }
            String str2 = mapD.get("BUGLY_APP_VERSION");
            if (str2 != null) {
                this.p = str2;
            }
            String str3 = mapD.get("BUGLY_APP_CHANNEL");
            if (str3 != null) {
                this.s = str3;
            }
            String str4 = mapD.get("BUGLY_ENABLE_DEBUG");
            if (str4 != null) {
                this.B = str4.equalsIgnoreCase(a.a.u.a.f1253j);
            }
            String str5 = mapD.get("com.tencent.rdm.uuid");
            if (str5 != null) {
                this.E = str5;
            }
            String str6 = mapD.get("BUGLY_APP_BUILD_NO");
            if (!TextUtils.isEmpty(str6)) {
                this.q = Integer.parseInt(str6);
            }
            String str7 = mapD.get("BUGLY_AREA");
            if (str7 != null) {
                this.F = str7;
            }
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public String A() {
        if (this.am == null) {
            this.am = "" + b.d();
            an.a("Hardware serial number: %s", this.am);
        }
        return this.am;
    }

    public Map<String, String> B() {
        synchronized (this.aD) {
            if (this.as.size() <= 0) {
                return null;
            }
            return new HashMap(this.as);
        }
    }

    public void C() {
        synchronized (this.aD) {
            this.as.clear();
        }
    }

    public int D() {
        int size;
        synchronized (this.aD) {
            size = this.as.size();
        }
        return size;
    }

    public Set<String> E() {
        Set<String> setKeySet;
        synchronized (this.aD) {
            setKeySet = this.as.keySet();
        }
        return setKeySet;
    }

    public Map<String, String> F() {
        synchronized (this.aH) {
            if (this.at.size() <= 0) {
                return null;
            }
            return new HashMap(this.at);
        }
    }

    public Map<String, String> G() {
        synchronized (this.aE) {
            if (this.au.size() <= 0) {
                return null;
            }
            return new HashMap(this.au);
        }
    }

    public int H() {
        int i2;
        synchronized (this.aF) {
            i2 = this.aq;
        }
        return i2;
    }

    public int I() {
        return this.ar;
    }

    public synchronized Map<String, PlugInBean> J() {
        Map<String, PlugInBean> map;
        map = this.an;
        if (this.ao != null) {
            map.putAll(this.ao);
        }
        return map;
    }

    public int K() {
        return b.c();
    }

    public String L() {
        if (this.aw == null) {
            this.aw = b.o();
        }
        return this.aw;
    }

    public String M() {
        if (this.ax == null) {
            this.ax = b.i(this.Q);
        }
        return this.ax;
    }

    public String N() {
        if (this.ay == null) {
            this.ay = b.j(this.Q);
        }
        return this.ay;
    }

    public String O() {
        return b.k(this.Q);
    }

    public String P() {
        if (this.az == null) {
            this.az = b.l(this.Q);
        }
        return this.az;
    }

    public long Q() {
        return b.m(this.Q);
    }

    public boolean R() {
        if (this.I == null) {
            this.I = Boolean.valueOf(b.n(this.Q));
            an.a("Is it a virtual machine? " + this.I, new Object[0]);
        }
        return this.I.booleanValue();
    }

    public boolean S() {
        if (this.J == null) {
            this.J = Boolean.valueOf(b.p(this.Q));
            an.a("Does it has hook frame? " + this.J, new Object[0]);
        }
        return this.J.booleanValue();
    }

    public String T() {
        if (this.f8980g == null) {
            this.f8980g = AppInfo.g(this.Q);
            an.a("Beacon channel " + this.f8980g, new Object[0]);
        }
        return this.f8980g;
    }

    public boolean a() {
        return this.av;
    }

    public void d() {
        synchronized (this.aB) {
            this.R = UUID.randomUUID().toString();
        }
    }

    public String e() {
        String str;
        synchronized (this.aB) {
            if (this.R == null) {
                d();
            }
            str = this.R;
        }
        return str;
    }

    public String f() {
        return !aq.a(this.f8979f) ? this.f8979f : this.ai;
    }

    public String g() {
        String str;
        synchronized (this.aG) {
            str = this.T;
        }
        return str;
    }

    public String h() {
        String str = this.S;
        if (str != null) {
            return str;
        }
        this.S = n();
        return this.S;
    }

    public synchronized String i() {
        return this.U;
    }

    public synchronized String j() {
        return this.V;
    }

    public String k() {
        if (!this.ag) {
            return "";
        }
        if (this.W == null) {
            this.W = b.a(this.Q);
        }
        return this.W;
    }

    public String l() {
        if (!this.ag) {
            return "";
        }
        String str = this.X;
        if (str == null || !str.contains(Constants.COLON_SEPARATOR)) {
            this.X = b.d(this.Q);
        }
        return this.X;
    }

    public String m() {
        if (!this.ag) {
            return "";
        }
        if (this.Y == null) {
            this.Y = b.b(this.Q);
        }
        return this.Y;
    }

    public String n() {
        if (!this.ag) {
            return "";
        }
        if (this.Z == null) {
            this.Z = b.c(this.Q);
        }
        return this.Z;
    }

    public long o() {
        if (this.aa <= 0) {
            this.aa = b.f();
        }
        return this.aa;
    }

    public long p() {
        if (this.ab <= 0) {
            this.ab = b.h();
        }
        return this.ab;
    }

    public long q() {
        if (this.ac <= 0) {
            this.ac = b.j();
        }
        return this.ac;
    }

    public String r() {
        if (this.ad == null) {
            this.ad = b.a(this.Q, true);
        }
        return this.ad;
    }

    public String s() {
        if (this.ae == null) {
            this.ae = b.h(this.Q);
        }
        return this.ae;
    }

    public String t() {
        try {
            Map<String, ?> all = this.Q.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.aC) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.K.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            an.a(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            an.a(th2);
        }
        if (this.K.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.K.entrySet()) {
            sb.append("[");
            sb.append(entry2.getKey());
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(entry2.getValue());
            sb.append("] ");
        }
        c("SDK_INFO", sb.toString());
        return sb.toString();
    }

    public String u() {
        if (this.aA == null) {
            this.aA = AppInfo.e(this.Q);
        }
        return this.aA;
    }

    public synchronized Map<String, PlugInBean> v() {
        if (this.af != null && this.af.size() > 0) {
            HashMap map = new HashMap(this.af.size());
            map.putAll(this.af);
            return map;
        }
        return null;
    }

    public String w() {
        if (this.ah == null) {
            this.ah = b.l();
        }
        return this.ah;
    }

    public Boolean x() {
        if (this.aj == null) {
            this.aj = Boolean.valueOf(b.n());
        }
        return this.aj;
    }

    public String y() {
        if (this.ak == null) {
            this.ak = "" + b.g(this.Q);
            an.a("ROM ID: %s", this.ak);
        }
        return this.ak;
    }

    public String z() {
        if (this.al == null) {
            this.al = "" + b.e(this.Q);
            an.a("SIM serial number: %s", this.al);
        }
        return this.al;
    }

    public void a(boolean z) {
        this.av = z;
        com.tencent.bugly.crashreport.a aVar = this.O;
        if (aVar != null) {
            aVar.setNativeIsAppForeground(z);
        }
    }

    public synchronized void d(String str) {
        this.U = "" + str;
    }

    public String f(String str) {
        String strRemove;
        if (aq.a(str)) {
            an.d("key should not be empty %s", "" + str);
            return null;
        }
        synchronized (this.aD) {
            strRemove = this.as.remove(str);
        }
        return strRemove;
    }

    public String g(String str) {
        String str2;
        if (aq.a(str)) {
            an.d("key should not be empty %s", "" + str);
            return null;
        }
        synchronized (this.aD) {
            str2 = this.as.get(str);
        }
        return str2;
    }

    public static synchronized a a(Context context) {
        if (ap == null) {
            ap = new a(context);
        }
        return ap;
    }

    public synchronized void e(String str) {
        this.V = "" + str;
    }

    public static synchronized a b() {
        return ap;
    }

    public void a(String str) {
        this.ai = str;
        c("APP_ID", str);
    }

    public void b(String str) {
        synchronized (this.aG) {
            if (str == null) {
                str = "10000";
            }
            this.T = "" + str;
        }
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.aC) {
            this.K.put(str, str2);
        }
    }

    public void b(boolean z) {
        this.ag = z;
    }

    public void b(String str, String str2) {
        if (!aq.a(str) && !aq.a(str2)) {
            synchronized (this.aD) {
                this.as.put(str, str2);
            }
            return;
        }
        an.d("key&value should not be empty %s %s", "" + str, "" + str2);
    }

    public void a(int i2) {
        synchronized (this.aF) {
            int i3 = this.aq;
            if (i3 != i2) {
                this.aq = i2;
                an.a("user scene tag %d changed to tag %d", Integer.valueOf(i3), Integer.valueOf(this.aq));
            }
        }
    }

    public void b(int i2) {
        int i3 = this.ar;
        if (i3 != i2) {
            this.ar = i2;
            an.a("server scene tag %d changed to tag %d", Integer.valueOf(i3), Integer.valueOf(this.ar));
        }
    }

    public String c() {
        return this.f8983j;
    }

    public void c(String str) {
        this.S = str;
        synchronized (this.aH) {
            this.at.put("E8", str);
        }
    }

    public void c(String str, String str2) {
        if (!aq.a(str) && !aq.a(str2)) {
            synchronized (this.aE) {
                this.au.put(str, str2);
            }
            return;
        }
        an.d("server key&value should not be empty %s %s", "" + str, "" + str2);
    }
}
