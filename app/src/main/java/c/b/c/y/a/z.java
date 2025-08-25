package c.b.c.y.a;

/* compiled from: TelParsedResult.java */
/* loaded from: classes.dex */
public final class z extends q {

    /* renamed from: b, reason: collision with root package name */
    private final String f2997b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2998c;

    /* renamed from: d, reason: collision with root package name */
    private final String f2999d;

    public z(String str, String str2, String str3) {
        super(r.TEL);
        this.f2997b = str;
        this.f2998c = str2;
        this.f2999d = str3;
    }

    @Override // c.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        q.a(this.f2997b, sb);
        q.a(this.f2999d, sb);
        return sb.toString();
    }

    public String c() {
        return this.f2997b;
    }

    public String d() {
        return this.f2998c;
    }

    public String e() {
        return this.f2999d;
    }
}
