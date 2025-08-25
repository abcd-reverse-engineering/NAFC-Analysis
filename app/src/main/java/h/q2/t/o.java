package h.q2.t;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* loaded from: classes2.dex */
public final class o extends y0<byte[]> {

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f16419d;

    public o(int i2) {
        super(i2);
        this.f16419d = new byte[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.q2.t.y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@i.c.a.d byte[] bArr) {
        i0.f(bArr, "$this$getSize");
        return bArr.length;
    }

    @i.c.a.d
    public final byte[] c() {
        return a(this.f16419d, new byte[b()]);
    }

    public final void a(byte b2) {
        byte[] bArr = this.f16419d;
        int iA = a();
        a(iA + 1);
        bArr[iA] = b2;
    }
}
