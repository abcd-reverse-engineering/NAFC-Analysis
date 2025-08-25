package h.q2.t;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* loaded from: classes2.dex */
public final class m extends y0<boolean[]> {

    /* renamed from: d, reason: collision with root package name */
    private final boolean[] f16406d;

    public m(int i2) {
        super(i2);
        this.f16406d = new boolean[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.q2.t.y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@i.c.a.d boolean[] zArr) {
        i0.f(zArr, "$this$getSize");
        return zArr.length;
    }

    @i.c.a.d
    public final boolean[] c() {
        return a(this.f16406d, new boolean[b()]);
    }

    public final void a(boolean z) {
        boolean[] zArr = this.f16406d;
        int iA = a();
        a(iA + 1);
        zArr[iA] = z;
    }
}
