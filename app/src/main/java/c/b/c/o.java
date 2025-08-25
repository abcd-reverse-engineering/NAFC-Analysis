package c.b.c;

/* compiled from: RGBLuminanceSource.java */
/* loaded from: classes.dex */
public final class o extends j {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f2838c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2839d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2840e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2841f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2842g;

    public o(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.f2839d = i2;
        this.f2840e = i3;
        this.f2841f = 0;
        this.f2842g = 0;
        this.f2838c = new byte[i2 * i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * i2;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i5 + i6;
                int i8 = iArr[i7];
                int i9 = (i8 >> 16) & 255;
                int i10 = (i8 >> 8) & 255;
                int i11 = i8 & 255;
                if (i9 == i10 && i10 == i11) {
                    this.f2838c[i7] = (byte) i9;
                } else {
                    this.f2838c[i7] = (byte) (((i9 + (i10 * 2)) + i11) / 4);
                }
            }
        }
    }

    @Override // c.b.c.j
    public byte[] a(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i2);
        }
        int iC = c();
        if (bArr == null || bArr.length < iC) {
            bArr = new byte[iC];
        }
        System.arraycopy(this.f2838c, ((i2 + this.f2842g) * this.f2839d) + this.f2841f, bArr, 0, iC);
        return bArr;
    }

    @Override // c.b.c.j
    public byte[] b() {
        int iC = c();
        int iA = a();
        if (iC == this.f2839d && iA == this.f2840e) {
            return this.f2838c;
        }
        int i2 = iC * iA;
        byte[] bArr = new byte[i2];
        int i3 = this.f2842g;
        int i4 = this.f2839d;
        int i5 = (i3 * i4) + this.f2841f;
        if (iC == i4) {
            System.arraycopy(this.f2838c, i5, bArr, 0, i2);
            return bArr;
        }
        byte[] bArr2 = this.f2838c;
        for (int i6 = 0; i6 < iA; i6++) {
            System.arraycopy(bArr2, i5, bArr, i6 * iC, iC);
            i5 += this.f2839d;
        }
        return bArr;
    }

    @Override // c.b.c.j
    public boolean e() {
        return true;
    }

    @Override // c.b.c.j
    public j a(int i2, int i3, int i4, int i5) {
        return new o(this.f2838c, this.f2839d, this.f2840e, this.f2841f + i2, this.f2842g + i3, i4, i5);
    }

    private o(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        if (i6 + i4 <= i2 && i7 + i5 <= i3) {
            this.f2838c = bArr;
            this.f2839d = i2;
            this.f2840e = i3;
            this.f2841f = i4;
            this.f2842g = i5;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
