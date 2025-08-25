package c.b.c.y.a;

import java.util.Map;

/* compiled from: ExpandedProductParsedResult.java */
/* loaded from: classes.dex */
public final class k extends q {
    public static final String q = "KG";
    public static final String r = "LB";

    /* renamed from: b, reason: collision with root package name */
    private final String f2966b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2967c;

    /* renamed from: d, reason: collision with root package name */
    private final String f2968d;

    /* renamed from: e, reason: collision with root package name */
    private final String f2969e;

    /* renamed from: f, reason: collision with root package name */
    private final String f2970f;

    /* renamed from: g, reason: collision with root package name */
    private final String f2971g;

    /* renamed from: h, reason: collision with root package name */
    private final String f2972h;

    /* renamed from: i, reason: collision with root package name */
    private final String f2973i;

    /* renamed from: j, reason: collision with root package name */
    private final String f2974j;

    /* renamed from: k, reason: collision with root package name */
    private final String f2975k;

    /* renamed from: l, reason: collision with root package name */
    private final String f2976l;

    /* renamed from: m, reason: collision with root package name */
    private final String f2977m;
    private final String n;
    private final String o;
    private final Map<String, String> p;

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(r.PRODUCT);
        this.f2966b = str;
        this.f2967c = str2;
        this.f2968d = str3;
        this.f2969e = str4;
        this.f2970f = str5;
        this.f2971g = str6;
        this.f2972h = str7;
        this.f2973i = str8;
        this.f2974j = str9;
        this.f2975k = str10;
        this.f2976l = str11;
        this.f2977m = str12;
        this.n = str13;
        this.o = str14;
        this.p = map;
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public String c() {
        return this.f2972h;
    }

    public String d() {
        return this.f2973i;
    }

    public String e() {
        return this.f2969e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return a(this.f2967c, kVar.f2967c) && a(this.f2968d, kVar.f2968d) && a(this.f2969e, kVar.f2969e) && a(this.f2970f, kVar.f2970f) && a(this.f2972h, kVar.f2972h) && a(this.f2973i, kVar.f2973i) && a(this.f2974j, kVar.f2974j) && a(this.f2975k, kVar.f2975k) && a(this.f2976l, kVar.f2976l) && a(this.f2977m, kVar.f2977m) && a(this.n, kVar.n) && a(this.o, kVar.o) && a(this.p, kVar.p);
    }

    public String f() {
        return this.f2971g;
    }

    public String g() {
        return this.f2977m;
    }

    public String h() {
        return this.o;
    }

    public int hashCode() {
        return ((((((((((((a(this.f2967c) ^ 0) ^ a(this.f2968d)) ^ a(this.f2969e)) ^ a(this.f2970f)) ^ a(this.f2972h)) ^ a(this.f2973i)) ^ a(this.f2974j)) ^ a(this.f2975k)) ^ a(this.f2976l)) ^ a(this.f2977m)) ^ a(this.n)) ^ a(this.o)) ^ a(this.p);
    }

    public String i() {
        return this.n;
    }

    public String j() {
        return this.f2967c;
    }

    public String k() {
        return this.f2970f;
    }

    public String l() {
        return this.f2966b;
    }

    public String m() {
        return this.f2968d;
    }

    public Map<String, String> n() {
        return this.p;
    }

    public String o() {
        return this.f2974j;
    }

    public String p() {
        return this.f2976l;
    }

    public String q() {
        return this.f2975k;
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // c.b.c.y.a.q
    public String a() {
        return String.valueOf(this.f2966b);
    }
}
