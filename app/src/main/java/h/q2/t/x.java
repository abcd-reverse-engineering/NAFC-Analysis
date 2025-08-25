package h.q2.t;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* loaded from: classes2.dex */
public final class x extends y0<double[]> {

    /* renamed from: d, reason: collision with root package name */
    private final double[] f16454d;

    public x(int i2) {
        super(i2);
        this.f16454d = new double[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.q2.t.y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@i.c.a.d double[] dArr) {
        i0.f(dArr, "$this$getSize");
        return dArr.length;
    }

    @i.c.a.d
    public final double[] c() {
        return a(this.f16454d, new double[b()]);
    }

    public final void a(double d2) {
        double[] dArr = this.f16454d;
        int iA = a();
        a(iA + 1);
        dArr[iA] = d2;
    }
}
