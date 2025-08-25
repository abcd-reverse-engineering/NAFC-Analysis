package h.u2;

/* compiled from: XorWowRandom.kt */
/* loaded from: classes2.dex */
public final class i extends f {

    /* renamed from: d, reason: collision with root package name */
    private int f16501d;

    /* renamed from: e, reason: collision with root package name */
    private int f16502e;

    /* renamed from: f, reason: collision with root package name */
    private int f16503f;

    /* renamed from: g, reason: collision with root package name */
    private int f16504g;

    /* renamed from: h, reason: collision with root package name */
    private int f16505h;

    /* renamed from: i, reason: collision with root package name */
    private int f16506i;

    public i(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f16501d = i2;
        this.f16502e = i3;
        this.f16503f = i4;
        this.f16504g = i5;
        this.f16505h = i6;
        this.f16506i = i7;
        if (!(((((this.f16501d | this.f16502e) | this.f16503f) | this.f16504g) | this.f16505h) != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i8 = 0; i8 < 64; i8++) {
            d();
        }
    }

    @Override // h.u2.f
    public int a(int i2) {
        return g.b(d(), i2);
    }

    @Override // h.u2.f
    public int d() {
        int i2 = this.f16501d;
        int i3 = i2 ^ (i2 >>> 2);
        this.f16501d = this.f16502e;
        this.f16502e = this.f16503f;
        this.f16503f = this.f16504g;
        int i4 = this.f16505h;
        this.f16504g = i4;
        int i5 = ((i3 ^ (i3 << 1)) ^ i4) ^ (i4 << 4);
        this.f16505h = i5;
        this.f16506i += 362437;
        return i5 + this.f16506i;
    }

    public i(int i2, int i3) {
        this(i2, i3, 0, 0, ~i2, (i2 << 10) ^ (i3 >>> 4));
    }
}
