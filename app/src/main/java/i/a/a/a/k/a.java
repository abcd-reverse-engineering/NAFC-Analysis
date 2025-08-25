package i.a.a.a.k;

import com.umeng.analytics.pro.cw;
import okio.Utf8;

/* compiled from: Base32.java */
/* loaded from: classes2.dex */
public class a extends g {
    private static final byte[] A = {cw.f10301k, 10};
    private static final byte[] B = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, cw.f10301k, cw.f10302l, cw.f10303m, cw.n, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final byte[] C = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] D = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, cw.f10301k, cw.f10302l, cw.f10303m, cw.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    private static final byte[] E = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final int F = 31;
    private static final int x = 5;
    private static final int y = 8;
    private static final int z = 5;
    private long r;
    private final int s;
    private final byte[] t;
    private final int u;
    private final byte[] v;
    private final byte[] w;

    public a() {
        this(false);
    }

    @Override // i.a.a.a.k.g
    void a(byte[] bArr, int i2, int i3) {
        byte b2;
        if (this.f16746i) {
        }
        if (i3 < 0) {
            this.f16746i = true;
        }
        int i4 = 0;
        int i5 = i2;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int i6 = i5 + 1;
            byte b3 = bArr[i5];
            if (b3 == 61) {
                this.f16746i = true;
                break;
            }
            a(this.s);
            if (b3 >= 0) {
                byte[] bArr2 = this.t;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.f16748k = (this.f16748k + 1) % 8;
                    this.r = (this.r << 5) + b2;
                    if (this.f16748k == 0) {
                        byte[] bArr3 = this.f16743f;
                        int i7 = this.f16744g;
                        this.f16744g = i7 + 1;
                        long j2 = this.r;
                        bArr3[i7] = (byte) ((j2 >> 32) & 255);
                        int i8 = this.f16744g;
                        this.f16744g = i8 + 1;
                        bArr3[i8] = (byte) ((j2 >> 24) & 255);
                        int i9 = this.f16744g;
                        this.f16744g = i9 + 1;
                        bArr3[i9] = (byte) ((j2 >> 16) & 255);
                        int i10 = this.f16744g;
                        this.f16744g = i10 + 1;
                        bArr3[i10] = (byte) ((j2 >> 8) & 255);
                        int i11 = this.f16744g;
                        this.f16744g = i11 + 1;
                        bArr3[i11] = (byte) (j2 & 255);
                    }
                }
            }
            i4++;
            i5 = i6;
        }
        if (!this.f16746i || this.f16748k < 2) {
            return;
        }
        a(this.s);
        switch (this.f16748k) {
            case 2:
                byte[] bArr4 = this.f16743f;
                int i12 = this.f16744g;
                this.f16744g = i12 + 1;
                bArr4[i12] = (byte) ((this.r >> 2) & 255);
                break;
            case 3:
                byte[] bArr5 = this.f16743f;
                int i13 = this.f16744g;
                this.f16744g = i13 + 1;
                bArr5[i13] = (byte) ((this.r >> 7) & 255);
                break;
            case 4:
                this.r >>= 4;
                byte[] bArr6 = this.f16743f;
                int i14 = this.f16744g;
                this.f16744g = i14 + 1;
                long j3 = this.r;
                bArr6[i14] = (byte) ((j3 >> 8) & 255);
                int i15 = this.f16744g;
                this.f16744g = i15 + 1;
                bArr6[i15] = (byte) (j3 & 255);
                break;
            case 5:
                this.r >>= 1;
                byte[] bArr7 = this.f16743f;
                int i16 = this.f16744g;
                this.f16744g = i16 + 1;
                long j4 = this.r;
                bArr7[i16] = (byte) ((j4 >> 16) & 255);
                int i17 = this.f16744g;
                this.f16744g = i17 + 1;
                bArr7[i17] = (byte) ((j4 >> 8) & 255);
                int i18 = this.f16744g;
                this.f16744g = i18 + 1;
                bArr7[i18] = (byte) (j4 & 255);
                break;
            case 6:
                this.r >>= 6;
                byte[] bArr8 = this.f16743f;
                int i19 = this.f16744g;
                this.f16744g = i19 + 1;
                long j5 = this.r;
                bArr8[i19] = (byte) ((j5 >> 16) & 255);
                int i20 = this.f16744g;
                this.f16744g = i20 + 1;
                bArr8[i20] = (byte) ((j5 >> 8) & 255);
                int i21 = this.f16744g;
                this.f16744g = i21 + 1;
                bArr8[i21] = (byte) (j5 & 255);
                break;
            case 7:
                this.r >>= 3;
                byte[] bArr9 = this.f16743f;
                int i22 = this.f16744g;
                this.f16744g = i22 + 1;
                long j6 = this.r;
                bArr9[i22] = (byte) ((j6 >> 24) & 255);
                int i23 = this.f16744g;
                this.f16744g = i23 + 1;
                bArr9[i23] = (byte) ((j6 >> 16) & 255);
                int i24 = this.f16744g;
                this.f16744g = i24 + 1;
                bArr9[i24] = (byte) ((j6 >> 8) & 255);
                int i25 = this.f16744g;
                this.f16744g = i25 + 1;
                bArr9[i25] = (byte) (j6 & 255);
                break;
        }
    }

    @Override // i.a.a.a.k.g
    void b(byte[] bArr, int i2, int i3) {
        if (this.f16746i) {
            return;
        }
        if (i3 >= 0) {
            int i4 = i2;
            int i5 = 0;
            while (i5 < i3) {
                a(this.u);
                this.f16748k = (this.f16748k + 1) % 5;
                int i6 = i4 + 1;
                int i7 = bArr[i4];
                if (i7 < 0) {
                    i7 += 256;
                }
                this.r = (this.r << 8) + i7;
                if (this.f16748k == 0) {
                    byte[] bArr2 = this.f16743f;
                    int i8 = this.f16744g;
                    this.f16744g = i8 + 1;
                    byte[] bArr3 = this.v;
                    long j2 = this.r;
                    bArr2[i8] = bArr3[((int) (j2 >> 35)) & 31];
                    int i9 = this.f16744g;
                    this.f16744g = i9 + 1;
                    bArr2[i9] = bArr3[((int) (j2 >> 30)) & 31];
                    int i10 = this.f16744g;
                    this.f16744g = i10 + 1;
                    bArr2[i10] = bArr3[((int) (j2 >> 25)) & 31];
                    int i11 = this.f16744g;
                    this.f16744g = i11 + 1;
                    bArr2[i11] = bArr3[((int) (j2 >> 20)) & 31];
                    int i12 = this.f16744g;
                    this.f16744g = i12 + 1;
                    bArr2[i12] = bArr3[((int) (j2 >> 15)) & 31];
                    int i13 = this.f16744g;
                    this.f16744g = i13 + 1;
                    bArr2[i13] = bArr3[((int) (j2 >> 10)) & 31];
                    int i14 = this.f16744g;
                    this.f16744g = i14 + 1;
                    bArr2[i14] = bArr3[((int) (j2 >> 5)) & 31];
                    int i15 = this.f16744g;
                    this.f16744g = i15 + 1;
                    bArr2[i15] = bArr3[((int) j2) & 31];
                    this.f16747j += 8;
                    int i16 = this.f16741d;
                    if (i16 > 0 && i16 <= this.f16747j) {
                        byte[] bArr4 = this.w;
                        System.arraycopy(bArr4, 0, bArr2, this.f16744g, bArr4.length);
                        this.f16744g += this.w.length;
                        this.f16747j = 0;
                    }
                }
                i5++;
                i4 = i6;
            }
            return;
        }
        this.f16746i = true;
        if (this.f16748k == 0 && this.f16741d == 0) {
            return;
        }
        a(this.u);
        int i17 = this.f16744g;
        int i18 = this.f16748k;
        if (i18 == 1) {
            byte[] bArr5 = this.f16743f;
            this.f16744g = i17 + 1;
            byte[] bArr6 = this.v;
            long j3 = this.r;
            bArr5[i17] = bArr6[((int) (j3 >> 3)) & 31];
            int i19 = this.f16744g;
            this.f16744g = i19 + 1;
            bArr5[i19] = bArr6[((int) (j3 << 2)) & 31];
            int i20 = this.f16744g;
            this.f16744g = i20 + 1;
            bArr5[i20] = 61;
            int i21 = this.f16744g;
            this.f16744g = i21 + 1;
            bArr5[i21] = 61;
            int i22 = this.f16744g;
            this.f16744g = i22 + 1;
            bArr5[i22] = 61;
            int i23 = this.f16744g;
            this.f16744g = i23 + 1;
            bArr5[i23] = 61;
            int i24 = this.f16744g;
            this.f16744g = i24 + 1;
            bArr5[i24] = 61;
            int i25 = this.f16744g;
            this.f16744g = i25 + 1;
            bArr5[i25] = 61;
        } else if (i18 == 2) {
            byte[] bArr7 = this.f16743f;
            this.f16744g = i17 + 1;
            byte[] bArr8 = this.v;
            long j4 = this.r;
            bArr7[i17] = bArr8[((int) (j4 >> 11)) & 31];
            int i26 = this.f16744g;
            this.f16744g = i26 + 1;
            bArr7[i26] = bArr8[((int) (j4 >> 6)) & 31];
            int i27 = this.f16744g;
            this.f16744g = i27 + 1;
            bArr7[i27] = bArr8[((int) (j4 >> 1)) & 31];
            int i28 = this.f16744g;
            this.f16744g = i28 + 1;
            bArr7[i28] = bArr8[((int) (j4 << 4)) & 31];
            int i29 = this.f16744g;
            this.f16744g = i29 + 1;
            bArr7[i29] = 61;
            int i30 = this.f16744g;
            this.f16744g = i30 + 1;
            bArr7[i30] = 61;
            int i31 = this.f16744g;
            this.f16744g = i31 + 1;
            bArr7[i31] = 61;
            int i32 = this.f16744g;
            this.f16744g = i32 + 1;
            bArr7[i32] = 61;
        } else if (i18 == 3) {
            byte[] bArr9 = this.f16743f;
            this.f16744g = i17 + 1;
            byte[] bArr10 = this.v;
            long j5 = this.r;
            bArr9[i17] = bArr10[((int) (j5 >> 19)) & 31];
            int i33 = this.f16744g;
            this.f16744g = i33 + 1;
            bArr9[i33] = bArr10[((int) (j5 >> 14)) & 31];
            int i34 = this.f16744g;
            this.f16744g = i34 + 1;
            bArr9[i34] = bArr10[((int) (j5 >> 9)) & 31];
            int i35 = this.f16744g;
            this.f16744g = i35 + 1;
            bArr9[i35] = bArr10[((int) (j5 >> 4)) & 31];
            int i36 = this.f16744g;
            this.f16744g = i36 + 1;
            bArr9[i36] = bArr10[((int) (j5 << 1)) & 31];
            int i37 = this.f16744g;
            this.f16744g = i37 + 1;
            bArr9[i37] = 61;
            int i38 = this.f16744g;
            this.f16744g = i38 + 1;
            bArr9[i38] = 61;
            int i39 = this.f16744g;
            this.f16744g = i39 + 1;
            bArr9[i39] = 61;
        } else if (i18 == 4) {
            byte[] bArr11 = this.f16743f;
            this.f16744g = i17 + 1;
            byte[] bArr12 = this.v;
            long j6 = this.r;
            bArr11[i17] = bArr12[((int) (j6 >> 27)) & 31];
            int i40 = this.f16744g;
            this.f16744g = i40 + 1;
            bArr11[i40] = bArr12[((int) (j6 >> 22)) & 31];
            int i41 = this.f16744g;
            this.f16744g = i41 + 1;
            bArr11[i41] = bArr12[((int) (j6 >> 17)) & 31];
            int i42 = this.f16744g;
            this.f16744g = i42 + 1;
            bArr11[i42] = bArr12[((int) (j6 >> 12)) & 31];
            int i43 = this.f16744g;
            this.f16744g = i43 + 1;
            bArr11[i43] = bArr12[((int) (j6 >> 7)) & 31];
            int i44 = this.f16744g;
            this.f16744g = i44 + 1;
            bArr11[i44] = bArr12[((int) (j6 >> 2)) & 31];
            int i45 = this.f16744g;
            this.f16744g = i45 + 1;
            bArr11[i45] = bArr12[((int) (j6 << 3)) & 31];
            int i46 = this.f16744g;
            this.f16744g = i46 + 1;
            bArr11[i46] = 61;
        }
        int i47 = this.f16747j;
        int i48 = this.f16744g;
        this.f16747j = i47 + (i48 - i17);
        if (this.f16741d <= 0 || this.f16747j <= 0) {
            return;
        }
        byte[] bArr13 = this.w;
        System.arraycopy(bArr13, 0, this.f16743f, i48, bArr13.length);
        this.f16744g += this.w.length;
    }

    public a(boolean z2) {
        this(0, null, z2);
    }

    public a(int i2) {
        this(i2, A);
    }

    public a(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public a(int i2, byte[] bArr, boolean z2) {
        super(5, 8, i2, bArr == null ? 0 : bArr.length);
        if (z2) {
            this.v = E;
            this.t = D;
        } else {
            this.v = C;
            this.t = B;
        }
        if (i2 <= 0) {
            this.u = 8;
            this.w = null;
        } else if (bArr != null) {
            if (!a(bArr)) {
                this.u = bArr.length + 8;
                this.w = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.w, 0, bArr.length);
            } else {
                throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + l.f(bArr) + "]");
            }
        } else {
            throw new IllegalArgumentException("lineLength " + i2 + " > 0, but lineSeparator is null");
        }
        this.s = this.u - 1;
    }

    @Override // i.a.a.a.k.g
    public boolean a(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.t;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }
}
