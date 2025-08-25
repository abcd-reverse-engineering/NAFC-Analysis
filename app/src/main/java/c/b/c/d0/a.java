package c.b.c.d0;

import java.util.Arrays;
import java.util.Map;

/* compiled from: CodaBarReader.java */
/* loaded from: classes.dex */
public final class a extends q {

    /* renamed from: d, reason: collision with root package name */
    private static final float f2447d = 2.0f;

    /* renamed from: e, reason: collision with root package name */
    private static final float f2448e = 1.5f;

    /* renamed from: i, reason: collision with root package name */
    private static final int f2452i = 3;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f2454a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private int[] f2455b = new int[80];

    /* renamed from: c, reason: collision with root package name */
    private int f2456c = 0;

    /* renamed from: f, reason: collision with root package name */
    private static final String f2449f = "0123456789-$:/.+ABCD";

    /* renamed from: g, reason: collision with root package name */
    static final char[] f2450g = f2449f.toCharArray();

    /* renamed from: h, reason: collision with root package name */
    static final int[] f2451h = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f2453j = {'A', 'B', 'C', 'D'};

    private void b(int i2) {
        int[] iArr = this.f2455b;
        int i3 = this.f2456c;
        iArr[i3] = i2;
        this.f2456c = i3 + 1;
        int i4 = this.f2456c;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f2455b = iArr2;
        }
    }

    private int c(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f2456c) {
            return -1;
        }
        int[] iArr = this.f2455b;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = f2451h;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    @Override // c.b.c.d0.q
    public c.b.c.r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws c.b.c.m {
        Arrays.fill(this.f2455b, 0);
        a(aVar);
        int iA = a();
        this.f2454a.setLength(0);
        int i3 = iA;
        do {
            int iC = c(i3);
            if (iC == -1) {
                throw c.b.c.m.getNotFoundInstance();
            }
            this.f2454a.append((char) iC);
            i3 += 8;
            if (this.f2454a.length() > 1 && a(f2453j, f2450g[iC])) {
                break;
            }
        } while (i3 < this.f2456c);
        int i4 = i3 - 1;
        int i5 = this.f2455b[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.f2455b[i3 + i7];
        }
        if (i3 < this.f2456c && i5 < i6 / 2) {
            throw c.b.c.m.getNotFoundInstance();
        }
        a(iA);
        for (int i8 = 0; i8 < this.f2454a.length(); i8++) {
            StringBuilder sb = this.f2454a;
            sb.setCharAt(i8, f2450g[sb.charAt(i8)]);
        }
        if (!a(f2453j, this.f2454a.charAt(0))) {
            throw c.b.c.m.getNotFoundInstance();
        }
        StringBuilder sb2 = this.f2454a;
        if (!a(f2453j, sb2.charAt(sb2.length() - 1))) {
            throw c.b.c.m.getNotFoundInstance();
        }
        if (this.f2454a.length() <= 3) {
            throw c.b.c.m.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(c.b.c.e.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f2454a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f2454a.deleteCharAt(0);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < iA; i10++) {
            i9 += this.f2455b[i10];
        }
        float f2 = i9;
        while (iA < i4) {
            i9 += this.f2455b[iA];
            iA++;
        }
        float f3 = i2;
        return new c.b.c.r(this.f2454a.toString(), null, new c.b.c.t[]{new c.b.c.t(f2, f3), new c.b.c.t(i9, f3)}, c.b.c.a.CODABAR);
    }

    void a(int i2) throws c.b.c.m {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f2454a.length() - 1;
        int i3 = 0;
        int i4 = i2;
        int i5 = 0;
        while (true) {
            int i6 = f2451h[this.f2454a.charAt(i5)];
            for (int i7 = 6; i7 >= 0; i7--) {
                int i8 = (i7 & 1) + ((i6 & 1) * 2);
                iArr[i8] = iArr[i8] + this.f2455b[i4 + i7];
                iArr2[i8] = iArr2[i8] + 1;
                i6 >>= 1;
            }
            if (i5 >= length) {
                break;
            }
            i4 += 8;
            i5++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i9 = 0; i9 < 2; i9++) {
            fArr2[i9] = 0.0f;
            int i10 = i9 + 2;
            fArr2[i10] = ((iArr[i9] / iArr2[i9]) + (iArr[i10] / iArr2[i10])) / 2.0f;
            fArr[i9] = fArr2[i10];
            fArr[i10] = ((iArr[i10] * 2.0f) + f2448e) / iArr2[i10];
        }
        loop3: while (true) {
            int i11 = f2451h[this.f2454a.charAt(i3)];
            for (int i12 = 6; i12 >= 0; i12--) {
                int i13 = (i12 & 1) + ((i11 & 1) * 2);
                float f2 = this.f2455b[i2 + i12];
                if (f2 < fArr2[i13] || f2 > fArr[i13]) {
                    break loop3;
                }
                i11 >>= 1;
            }
            if (i3 >= length) {
                return;
            }
            i2 += 8;
            i3++;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private void a(c.b.c.z.a aVar) throws c.b.c.m {
        int i2 = 0;
        this.f2456c = 0;
        int iD = aVar.d(0);
        int iC = aVar.c();
        if (iD < iC) {
            boolean z = true;
            while (iD < iC) {
                if (aVar.b(iD) ^ z) {
                    i2++;
                } else {
                    b(i2);
                    z = !z;
                    i2 = 1;
                }
                iD++;
            }
            b(i2);
            return;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private int a() throws c.b.c.m {
        for (int i2 = 1; i2 < this.f2456c; i2 += 2) {
            int iC = c(i2);
            if (iC != -1 && a(f2453j, f2450g[iC])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.f2455b[i4];
                }
                if (i2 == 1 || this.f2455b[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }
}
