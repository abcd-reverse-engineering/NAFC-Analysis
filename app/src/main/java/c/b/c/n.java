package c.b.c;

import androidx.core.view.ViewCompat;
import h.f1;

/* compiled from: PlanarYUVLuminanceSource.java */
/* loaded from: classes.dex */
public final class n extends j {

    /* renamed from: h, reason: collision with root package name */
    private static final int f2832h = 2;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f2833c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2834d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2835e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2836f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2837g;

    public n(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i6, i7);
        if (i4 + i6 > i2 || i5 + i7 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f2833c = bArr;
        this.f2834d = i2;
        this.f2835e = i3;
        this.f2836f = i4;
        this.f2837g = i5;
        if (z) {
            a(i6, i7);
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
        System.arraycopy(this.f2833c, ((i2 + this.f2837g) * this.f2834d) + this.f2836f, bArr, 0, iC);
        return bArr;
    }

    @Override // c.b.c.j
    public byte[] b() {
        int iC = c();
        int iA = a();
        if (iC == this.f2834d && iA == this.f2835e) {
            return this.f2833c;
        }
        int i2 = iC * iA;
        byte[] bArr = new byte[i2];
        int i3 = this.f2837g;
        int i4 = this.f2834d;
        int i5 = (i3 * i4) + this.f2836f;
        if (iC == i4) {
            System.arraycopy(this.f2833c, i5, bArr, 0, i2);
            return bArr;
        }
        byte[] bArr2 = this.f2833c;
        for (int i6 = 0; i6 < iA; i6++) {
            System.arraycopy(bArr2, i5, bArr, i6 * iC, iC);
            i5 += this.f2834d;
        }
        return bArr;
    }

    @Override // c.b.c.j
    public boolean e() {
        return true;
    }

    public int i() {
        return a() / 2;
    }

    public int j() {
        return c() / 2;
    }

    public int[] k() {
        int iC = c() / 2;
        int iA = a() / 2;
        int[] iArr = new int[iC * iA];
        byte[] bArr = this.f2833c;
        int i2 = (this.f2837g * this.f2834d) + this.f2836f;
        for (int i3 = 0; i3 < iA; i3++) {
            int i4 = i3 * iC;
            for (int i5 = 0; i5 < iC; i5++) {
                iArr[i4 + i5] = ((bArr[(i5 * 2) + i2] & f1.f16099c) * 65793) | ViewCompat.MEASURED_STATE_MASK;
            }
            i2 += this.f2834d * 2;
        }
        return iArr;
    }

    @Override // c.b.c.j
    public j a(int i2, int i3, int i4, int i5) {
        return new n(this.f2833c, this.f2834d, this.f2835e, this.f2836f + i2, this.f2837g + i3, i4, i5, false);
    }

    private void a(int i2, int i3) {
        byte[] bArr = this.f2833c;
        int i4 = (this.f2837g * this.f2834d) + this.f2836f;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (i2 / 2) + i4;
            int i7 = (i4 + i2) - 1;
            int i8 = i4;
            while (i8 < i6) {
                byte b2 = bArr[i8];
                bArr[i8] = bArr[i7];
                bArr[i7] = b2;
                i8++;
                i7--;
            }
            i5++;
            i4 += this.f2834d;
        }
    }
}
