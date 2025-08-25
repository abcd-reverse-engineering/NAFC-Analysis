package h.q2.t;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* loaded from: classes2.dex */
public final class k1 extends y0<short[]> {

    /* renamed from: d, reason: collision with root package name */
    private final short[] f16403d;

    public k1(int i2) {
        super(i2);
        this.f16403d = new short[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.q2.t.y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@i.c.a.d short[] sArr) {
        i0.f(sArr, "$this$getSize");
        return sArr.length;
    }

    @i.c.a.d
    public final short[] c() {
        return a(this.f16403d, new short[b()]);
    }

    public final void a(short s) {
        short[] sArr = this.f16403d;
        int iA = a();
        a(iA + 1);
        sArr[iA] = s;
    }
}
