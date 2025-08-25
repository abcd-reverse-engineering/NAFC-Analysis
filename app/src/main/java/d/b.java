package d;

import android.text.TextUtils;
import bean.PolicBean;
import util.p1;

/* compiled from: CaseHelper.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13528a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f13529b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f13530c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f13531d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f13532e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f13533f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static final int f13534g = 6;

    /* renamed from: h, reason: collision with root package name */
    public static final int f13535h = 7;

    /* renamed from: i, reason: collision with root package name */
    public static final int f13536i = 127;

    public static void a(PolicBean policBean) {
        p1.a(p1.f20901k, policBean);
    }

    public static String b() {
        PolicBean policBeanA = a();
        return (policBeanA == null || TextUtils.isEmpty(policBeanA.getTelNumber())) ? "" : policBeanA.getTelNumber();
    }

    public static String c() {
        PolicBean policBeanA = a();
        return (policBeanA == null || TextUtils.isEmpty(policBeanA.getPoliceToken())) ? "" : policBeanA.getPoliceToken();
    }

    public static boolean d() {
        return a() != null;
    }

    public static void e() {
        a(null);
    }

    public static PolicBean a() {
        return (PolicBean) p1.a(p1.f20901k, PolicBean.class);
    }
}
