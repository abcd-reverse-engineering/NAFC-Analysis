package c.b.c.d0.a0.g.e;

/* compiled from: AI013x0x1xDecoder.java */
/* loaded from: classes.dex */
final class e extends i {

    /* renamed from: f, reason: collision with root package name */
    private static final int f2492f = 8;

    /* renamed from: g, reason: collision with root package name */
    private static final int f2493g = 20;

    /* renamed from: h, reason: collision with root package name */
    private static final int f2494h = 16;

    /* renamed from: d, reason: collision with root package name */
    private final String f2495d;

    /* renamed from: e, reason: collision with root package name */
    private final String f2496e;

    e(c.b.c.z.a aVar, String str, String str2) {
        super(aVar);
        this.f2495d = str2;
        this.f2496e = str;
    }

    @Override // c.b.c.d0.a0.g.e.i
    protected int a(int i2) {
        return i2 % 100000;
    }

    @Override // c.b.c.d0.a0.g.e.i
    protected void b(StringBuilder sb, int i2) {
        sb.append('(');
        sb.append(this.f2496e);
        sb.append(i2 / 100000);
        sb.append(')');
    }

    @Override // c.b.c.d0.a0.g.e.j
    public String c() throws c.b.c.m {
        if (b().c() != 84) {
            throw c.b.c.m.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        a(sb, 8);
        b(sb, 48, 20);
        c(sb, 68);
        return sb.toString();
    }

    private void c(StringBuilder sb, int i2) {
        int iA = a().a(i2, 16);
        if (iA == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f2495d);
        sb.append(')');
        int i3 = iA % 32;
        int i4 = iA / 32;
        int i5 = (i4 % 12) + 1;
        int i6 = i4 / 12;
        if (i6 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i6);
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i3 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i3);
    }
}
