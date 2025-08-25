package c.b.c.d0.a0.g.e;

/* compiled from: AI01393xDecoder.java */
/* loaded from: classes.dex */
final class d extends h {

    /* renamed from: d, reason: collision with root package name */
    private static final int f2489d = 8;

    /* renamed from: e, reason: collision with root package name */
    private static final int f2490e = 2;

    /* renamed from: f, reason: collision with root package name */
    private static final int f2491f = 10;

    d(c.b.c.z.a aVar) {
        super(aVar);
    }

    @Override // c.b.c.d0.a0.g.e.j
    public String c() throws c.b.c.h, c.b.c.m {
        if (b().c() < 48) {
            throw c.b.c.m.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        a(sb, 8);
        int iA = a().a(48, 2);
        sb.append("(393");
        sb.append(iA);
        sb.append(')');
        int iA2 = a().a(50, 10);
        if (iA2 / 100 == 0) {
            sb.append('0');
        }
        if (iA2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iA2);
        sb.append(a().a(60, (String) null).b());
        return sb.toString();
    }
}
