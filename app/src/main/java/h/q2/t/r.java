package h.q2.t;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* loaded from: classes2.dex */
public final class r extends y0<char[]> {

    /* renamed from: d, reason: collision with root package name */
    private final char[] f16438d;

    public r(int i2) {
        super(i2);
        this.f16438d = new char[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.q2.t.y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@i.c.a.d char[] cArr) {
        i0.f(cArr, "$this$getSize");
        return cArr.length;
    }

    @i.c.a.d
    public final char[] c() {
        return a(this.f16438d, new char[b()]);
    }

    public final void a(char c2) {
        char[] cArr = this.f16438d;
        int iA = a();
        a(iA + 1);
        cArr[iA] = c2;
    }
}
