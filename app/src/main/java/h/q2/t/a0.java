package h.q2.t;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* loaded from: classes2.dex */
public final class a0 extends y0<float[]> {

    /* renamed from: d, reason: collision with root package name */
    private final float[] f16371d;

    public a0(int i2) {
        super(i2);
        this.f16371d = new float[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.q2.t.y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@i.c.a.d float[] fArr) {
        i0.f(fArr, "$this$getSize");
        return fArr.length;
    }

    @i.c.a.d
    public final float[] c() {
        return a(this.f16371d, new float[b()]);
    }

    public final void a(float f2) {
        float[] fArr = this.f16371d;
        int iA = a();
        a(iA + 1);
        fArr[iA] = f2;
    }
}
