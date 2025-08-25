package c.b.c.y.a;

/* compiled from: GeoParsedResult.java */
/* loaded from: classes.dex */
public final class m extends q {

    /* renamed from: b, reason: collision with root package name */
    private final double f2978b;

    /* renamed from: c, reason: collision with root package name */
    private final double f2979c;

    /* renamed from: d, reason: collision with root package name */
    private final double f2980d;

    /* renamed from: e, reason: collision with root package name */
    private final String f2981e;

    m(double d2, double d3, double d4, String str) {
        super(r.GEO);
        this.f2978b = d2;
        this.f2979c = d3;
        this.f2980d = d4;
        this.f2981e = str;
    }

    @Override // c.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f2978b);
        sb.append(", ");
        sb.append(this.f2979c);
        if (this.f2980d > 0.0d) {
            sb.append(", ");
            sb.append(this.f2980d);
            sb.append('m');
        }
        if (this.f2981e != null) {
            sb.append(" (");
            sb.append(this.f2981e);
            sb.append(')');
        }
        return sb.toString();
    }

    public double c() {
        return this.f2980d;
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.f2978b);
        sb.append(',');
        sb.append(this.f2979c);
        if (this.f2980d > 0.0d) {
            sb.append(',');
            sb.append(this.f2980d);
        }
        if (this.f2981e != null) {
            sb.append('?');
            sb.append(this.f2981e);
        }
        return sb.toString();
    }

    public double e() {
        return this.f2978b;
    }

    public double f() {
        return this.f2979c;
    }

    public String g() {
        return this.f2981e;
    }
}
