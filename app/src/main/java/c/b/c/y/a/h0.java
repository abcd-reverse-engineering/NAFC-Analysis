package c.b.c.y.a;

/* compiled from: VINParsedResult.java */
/* loaded from: classes.dex */
public final class h0 extends q {

    /* renamed from: b, reason: collision with root package name */
    private final String f2949b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2950c;

    /* renamed from: d, reason: collision with root package name */
    private final String f2951d;

    /* renamed from: e, reason: collision with root package name */
    private final String f2952e;

    /* renamed from: f, reason: collision with root package name */
    private final String f2953f;

    /* renamed from: g, reason: collision with root package name */
    private final String f2954g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2955h;

    /* renamed from: i, reason: collision with root package name */
    private final char f2956i;

    /* renamed from: j, reason: collision with root package name */
    private final String f2957j;

    public h0(String str, String str2, String str3, String str4, String str5, String str6, int i2, char c2, String str7) {
        super(r.VIN);
        this.f2949b = str;
        this.f2950c = str2;
        this.f2951d = str3;
        this.f2952e = str4;
        this.f2953f = str5;
        this.f2954g = str6;
        this.f2955h = i2;
        this.f2956i = c2;
        this.f2957j = str7;
    }

    @Override // c.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.f2950c);
        sb.append(' ');
        sb.append(this.f2951d);
        sb.append(' ');
        sb.append(this.f2952e);
        sb.append('\n');
        String str = this.f2953f;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.f2955h);
        sb.append(' ');
        sb.append(this.f2956i);
        sb.append(' ');
        sb.append(this.f2957j);
        sb.append('\n');
        return sb.toString();
    }

    public String c() {
        return this.f2953f;
    }

    public int d() {
        return this.f2955h;
    }

    public char e() {
        return this.f2956i;
    }

    public String f() {
        return this.f2957j;
    }

    public String g() {
        return this.f2949b;
    }

    public String h() {
        return this.f2954g;
    }

    public String i() {
        return this.f2951d;
    }

    public String j() {
        return this.f2952e;
    }

    public String k() {
        return this.f2950c;
    }
}
