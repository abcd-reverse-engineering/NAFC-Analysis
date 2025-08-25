package c.b.c.y.a;

/* compiled from: EmailAddressParsedResult.java */
/* loaded from: classes.dex */
public final class h extends q {

    /* renamed from: b, reason: collision with root package name */
    private final String[] f2944b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f2945c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f2946d;

    /* renamed from: e, reason: collision with root package name */
    private final String f2947e;

    /* renamed from: f, reason: collision with root package name */
    private final String f2948f;

    h(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    @Override // c.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        q.a(this.f2944b, sb);
        q.a(this.f2945c, sb);
        q.a(this.f2946d, sb);
        q.a(this.f2947e, sb);
        q.a(this.f2948f, sb);
        return sb.toString();
    }

    public String[] c() {
        return this.f2946d;
    }

    public String d() {
        return this.f2948f;
    }

    public String[] e() {
        return this.f2945c;
    }

    @Deprecated
    public String f() {
        String[] strArr = this.f2944b;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    @Deprecated
    public String g() {
        return "mailto:";
    }

    public String h() {
        return this.f2947e;
    }

    public String[] i() {
        return this.f2944b;
    }

    h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(r.EMAIL_ADDRESS);
        this.f2944b = strArr;
        this.f2945c = strArr2;
        this.f2946d = strArr3;
        this.f2947e = str;
        this.f2948f = str2;
    }
}
