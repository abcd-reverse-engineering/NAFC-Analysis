package c.b.c.e0.g;

/* compiled from: BarcodeRow.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2705a;

    /* renamed from: b, reason: collision with root package name */
    private int f2706b = 0;

    b(int i2) {
        this.f2705a = new byte[i2];
    }

    void a(int i2, byte b2) {
        this.f2705a[i2] = b2;
    }

    void a(int i2, boolean z) {
        this.f2705a[i2] = z ? (byte) 1 : (byte) 0;
    }

    void a(boolean z, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f2706b;
            this.f2706b = i4 + 1;
            a(i4, z);
        }
    }

    byte[] a(int i2) {
        byte[] bArr = new byte[this.f2705a.length * i2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr[i3] = this.f2705a[i3 / i2];
        }
        return bArr;
    }
}
