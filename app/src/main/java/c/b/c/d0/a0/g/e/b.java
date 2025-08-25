package c.b.c.d0.a0.g.e;

/* compiled from: AI01320xDecoder.java */
/* loaded from: classes.dex */
final class b extends f {
    b(c.b.c.z.a aVar) {
        super(aVar);
    }

    @Override // c.b.c.d0.a0.g.e.i
    protected int a(int i2) {
        return i2 < 10000 ? i2 : i2 - 10000;
    }

    @Override // c.b.c.d0.a0.g.e.i
    protected void b(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
