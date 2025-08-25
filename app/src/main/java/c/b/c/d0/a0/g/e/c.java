package c.b.c.d0.a0.g.e;

/* compiled from: AI01392xDecoder.java */
/* loaded from: classes.dex */
final class c extends h {

    /* renamed from: d, reason: collision with root package name */
    private static final int f2487d = 8;

    /* renamed from: e, reason: collision with root package name */
    private static final int f2488e = 2;

    c(c.b.c.z.a aVar) {
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
        sb.append("(392");
        sb.append(iA);
        sb.append(')');
        sb.append(a().a(50, (String) null).b());
        return sb.toString();
    }
}
