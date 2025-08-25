package c.b.c.x.f;

import h.z2.h0;

/* compiled from: SimpleToken.java */
/* loaded from: classes.dex */
final class e extends g {

    /* renamed from: c, reason: collision with root package name */
    private final short f2896c;

    /* renamed from: d, reason: collision with root package name */
    private final short f2897d;

    e(g gVar, int i2, int i3) {
        super(gVar);
        this.f2896c = (short) i2;
        this.f2897d = (short) i3;
    }

    @Override // c.b.c.x.f.g
    void a(c.b.c.z.a aVar, byte[] bArr) {
        aVar.a(this.f2896c, this.f2897d);
    }

    public String toString() {
        short s = this.f2896c;
        short s2 = this.f2897d;
        return h0.f16707d + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.f2897d)).substring(1) + h0.f16708e;
    }
}
