package c.b.c.y.a;

/* compiled from: WifiParsedResult.java */
/* loaded from: classes.dex */
public final class j0 extends q {

    /* renamed from: b, reason: collision with root package name */
    private final String f2962b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2963c;

    /* renamed from: d, reason: collision with root package name */
    private final String f2964d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f2965e;

    public j0(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    @Override // c.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(80);
        q.a(this.f2962b, sb);
        q.a(this.f2963c, sb);
        q.a(this.f2964d, sb);
        q.a(Boolean.toString(this.f2965e), sb);
        return sb.toString();
    }

    public String c() {
        return this.f2963c;
    }

    public String d() {
        return this.f2964d;
    }

    public String e() {
        return this.f2962b;
    }

    public boolean f() {
        return this.f2965e;
    }

    public j0(String str, String str2, String str3, boolean z) {
        super(r.WIFI);
        this.f2962b = str2;
        this.f2963c = str;
        this.f2964d = str3;
        this.f2965e = z;
    }
}
