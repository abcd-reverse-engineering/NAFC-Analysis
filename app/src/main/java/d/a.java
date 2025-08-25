package d;

import android.text.TextUtils;
import bean.SurveyH5Bean;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import util.p1;
import util.y1;

/* compiled from: AppHiConfig.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f13515a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f13516b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f13517c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f13518d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f13519e = null;

    /* renamed from: f, reason: collision with root package name */
    public static String f13520f = null;

    /* renamed from: g, reason: collision with root package name */
    public static String f13521g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f13522h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f13523i = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f13524j = null;

    /* renamed from: k, reason: collision with root package name */
    public static final int f13525k = -1;

    /* renamed from: l, reason: collision with root package name */
    public static final int f13526l = 1;

    /* renamed from: m, reason: collision with root package name */
    public static final int f13527m = 2;
    public static final int n = 3;
    public static final int o = 4;
    public static final int p = 5;
    public static final int q = 6;
    public static final int r = 7;
    public static final int s = 8;
    public static final int t = 9;
    public static final int u = 1;

    public static void a() {
        f13517c = y1.A(com.hicorenational.antifraud.a.f5938g);
    }

    public static void b() {
        f13518d = y1.A(com.hicorenational.antifraud.a.f5939h);
    }

    public static String c() {
        RegionMudelBean regionMudelBeanJ = j();
        if (regionMudelBeanJ != null) {
            f13522h = regionMudelBeanJ.getLocalApi();
        } else {
            f13522h = f13517c;
        }
        return f13522h;
    }

    public static String d() {
        RegionMudelBean regionMudelBeanJ = j();
        if (regionMudelBeanJ != null) {
            f13523i = regionMudelBeanJ.getLocalApi();
        } else {
            f13523i = f13519e;
        }
        return f13523i;
    }

    public static void e() {
        f13515a = y1.A(com.hicorenational.antifraud.a.f5943l);
    }

    public static void f() {
        f13516b = y1.A(com.hicorenational.antifraud.a.f5944m);
    }

    public static void g() {
        f13520f = y1.A(com.hicorenational.antifraud.a.f5942k);
        f13521g = f13520f;
    }

    public static void h() {
        f13519e = y1.A(com.hicorenational.antifraud.a.f5940i);
    }

    public static String i() {
        return y1.A("https://fzapp.gjfzpt.cn");
    }

    public static RegionMudelBean j() {
        RegionMudelBean regionMudelBean = (RegionMudelBean) p1.a(LocalModuelConfig.LASTCONFIG, RegionMudelBean.class);
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getLocalApi())) {
            return null;
        }
        return regionMudelBean;
    }

    public static boolean k() {
        return j() != null;
    }

    public static void l() {
        e();
        f();
        a();
        h();
        b();
        g();
        c();
        d();
    }

    public static long m() {
        return System.currentTimeMillis() / 3000;
    }

    public static String a(int i2) {
        String str;
        switch (i2) {
            case 1:
                str = "users";
                break;
            case 2:
                str = SurveyH5Bean.SMS;
                break;
            case 3:
                str = "realname";
                break;
            case 4:
                str = "newxcapi";
                break;
            case 5:
                str = "casereport";
                break;
            case 6:
                str = "earlywarning";
                break;
            case 7:
                str = "riskverify";
                break;
            case 8:
                str = "basicapi";
                break;
            case 9:
                str = "feedback";
                break;
            default:
                str = "";
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + "/";
    }

    public static String b(String str) {
        Integer num;
        RegionMudelBean regionMudelBeanJ = j();
        return (regionMudelBeanJ == null || regionMudelBeanJ.getModles() == null || (num = regionMudelBeanJ.getModles().get(str)) == null) ? "" : num.toString();
    }

    private static String a(int i2, String str) {
        String strC;
        String strA;
        if (i2 == 4) {
            strC = d();
        } else {
            strC = c();
        }
        if (j() != null) {
            strA = a(i2);
            if (!TextUtils.isEmpty(strA)) {
                str = a(str);
            }
        } else {
            strA = "";
        }
        return strC + strA + str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 2
            r2 = 1
            switch(r0) {
                case 49: goto L1e;
                case 50: goto L14;
                case 51: goto La;
                default: goto L9;
            }
        L9:
            goto L28
        La:
            java.lang.String r0 = "3"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L28
            r3 = 2
            goto L29
        L14:
            java.lang.String r0 = "2"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L28
            r3 = 1
            goto L29
        L1e:
            java.lang.String r0 = "1"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L28
            r3 = 0
            goto L29
        L28:
            r3 = -1
        L29:
            if (r3 == 0) goto L42
            if (r3 == r2) goto L3d
            if (r3 == r1) goto L30
            goto L46
        L30:
            bean.module.RegionMudelBean r3 = j()
            if (r3 == 0) goto L46
            java.lang.String r3 = r3.getIndividuaApi()
            d.a.f13524j = r3
            goto L46
        L3d:
            java.lang.String r3 = d.a.f13516b
            d.a.f13524j = r3
            goto L46
        L42:
            java.lang.String r3 = d.a.f13522h
            d.a.f13524j = r3
        L46:
            java.lang.String r3 = d.a.f13524j
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.c(java.lang.String):java.lang.String");
    }

    public static String a(String str, int i2, String str2) {
        String localApi;
        if (TextUtils.isEmpty(str)) {
            return a(i2, str2);
        }
        String strB = b(str);
        RegionMudelBean regionMudelBeanJ = j();
        String strA = "";
        if (regionMudelBeanJ != null && (TextUtils.isEmpty(strB) || !TextUtils.equals(strB, "0"))) {
            localApi = regionMudelBeanJ.getLocalApi();
            strA = a(i2);
            if (!TextUtils.isEmpty(strA)) {
                str2 = a(str2);
            }
        } else {
            localApi = i2 == 4 ? f13519e : f13517c;
        }
        return localApi + strA + str2;
    }

    public static String a(String str, String str2) {
        String localApi;
        RegionMudelBean regionMudelBeanJ = j();
        if (regionMudelBeanJ != null) {
            if (regionMudelBeanJ.getModles() != null) {
                Integer num = regionMudelBeanJ.getModles().get(str);
                if (num != null && TextUtils.equals(num.toString(), "0")) {
                    localApi = f13516b;
                } else {
                    localApi = regionMudelBeanJ.getLocalApi();
                }
            } else {
                localApi = "";
            }
        } else {
            localApi = f13516b;
        }
        return localApi + str2;
    }

    private static String a(String str) {
        if (str.toLowerCase().contains(e.b.M.toLowerCase())) {
            return e.b.N;
        }
        if (str.toLowerCase().contains(e.b.C.toLowerCase())) {
            return e.b.D;
        }
        return str.toLowerCase().contains(e.b.M0.toLowerCase()) ? e.b.N0 : str;
    }
}
