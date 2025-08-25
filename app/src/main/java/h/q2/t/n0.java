package h.q2.t;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* loaded from: classes2.dex */
public final class n0 extends y0<long[]> {

    /* renamed from: d, reason: collision with root package name */
    private final long[] f16418d;

    public n0(int i2) {
        super(i2);
        this.f16418d = new long[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.q2.t.y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@i.c.a.d long[] jArr) {
        i0.f(jArr, "$this$getSize");
        return jArr.length;
    }

    @i.c.a.d
    public final long[] c() {
        return a(this.f16418d, new long[b()]);
    }

    public final void a(long j2) {
        long[] jArr = this.f16418d;
        int iA = a();
        a(iA + 1);
        jArr[iA] = j2;
    }
}
