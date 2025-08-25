package c.b.c;

import h.f1;

/* compiled from: InvertedLuminanceSource.java */
/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: c, reason: collision with root package name */
    private final j f2825c;

    public i(j jVar) {
        super(jVar.c(), jVar.a());
        this.f2825c = jVar;
    }

    @Override // c.b.c.j
    public byte[] a(int i2, byte[] bArr) {
        byte[] bArrA = this.f2825c.a(i2, bArr);
        int iC = c();
        for (int i3 = 0; i3 < iC; i3++) {
            bArrA[i3] = (byte) (255 - (bArrA[i3] & f1.f16099c));
        }
        return bArrA;
    }

    @Override // c.b.c.j
    public byte[] b() {
        byte[] bArrB = this.f2825c.b();
        int iC = c() * a();
        byte[] bArr = new byte[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            bArr[i2] = (byte) (255 - (bArrB[i2] & f1.f16099c));
        }
        return bArr;
    }

    @Override // c.b.c.j
    public j d() {
        return this.f2825c;
    }

    @Override // c.b.c.j
    public boolean e() {
        return this.f2825c.e();
    }

    @Override // c.b.c.j
    public boolean f() {
        return this.f2825c.f();
    }

    @Override // c.b.c.j
    public j g() {
        return new i(this.f2825c.g());
    }

    @Override // c.b.c.j
    public j h() {
        return new i(this.f2825c.h());
    }

    @Override // c.b.c.j
    public j a(int i2, int i3, int i4, int i5) {
        return new i(this.f2825c.a(i2, i3, i4, i5));
    }
}
