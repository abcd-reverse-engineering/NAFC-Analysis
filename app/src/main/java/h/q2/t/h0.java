package h.q2.t;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* loaded from: classes2.dex */
public final class h0 extends y0<int[]> {

    /* renamed from: d, reason: collision with root package name */
    private final int[] f16389d;

    public h0(int i2) {
        super(i2);
        this.f16389d = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.q2.t.y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@i.c.a.d int[] iArr) {
        i0.f(iArr, "$this$getSize");
        return iArr.length;
    }

    @i.c.a.d
    public final int[] c() {
        return a(this.f16389d, new int[b()]);
    }

    public final void b(int i2) {
        int[] iArr = this.f16389d;
        int iA = a();
        a(iA + 1);
        iArr[iA] = i2;
    }
}
