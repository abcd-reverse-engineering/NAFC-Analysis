package c.b.c.d0;

import com.luck.picture.lib.camera.CustomCameraView;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code39Reader.java */
/* loaded from: classes.dex */
public final class e extends q {

    /* renamed from: e, reason: collision with root package name */
    static final String f2556e = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";

    /* renamed from: f, reason: collision with root package name */
    private static final char[] f2557f = f2556e.toCharArray();

    /* renamed from: g, reason: collision with root package name */
    static final int[] f2558g = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, CustomCameraView.BUTTON_STATE_BOTH, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, TinkerReport.KEY_APPLIED_FAIL_COST_60S_LESS, 133, 388, 196, 148, 168, 162, 138, 42};

    /* renamed from: h, reason: collision with root package name */
    private static final int f2559h = f2558g[39];

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2560a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f2561b;

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f2562c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f2563d;

    public e() {
        this(false);
    }

    @Override // c.b.c.d0.q
    public c.b.c.r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws c.b.c.d, c.b.c.h, c.b.c.m {
        int[] iArr = this.f2563d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f2562c;
        sb.setLength(0);
        int iC = aVar.c(a(aVar, iArr)[1]);
        int iC2 = aVar.c();
        while (true) {
            q.a(aVar, iC, iArr);
            int iA = a(iArr);
            if (iA < 0) {
                throw c.b.c.m.getNotFoundInstance();
            }
            char cA = a(iA);
            sb.append(cA);
            int i3 = iC;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int iC3 = aVar.c(i3);
            if (cA == '*') {
                sb.setLength(sb.length() - 1);
                int i5 = 0;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                int i7 = (iC3 - iC) - i5;
                if (iC3 != iC2 && i7 * 2 < i5) {
                    throw c.b.c.m.getNotFoundInstance();
                }
                if (this.f2560a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i8 = 0; i8 < length; i8++) {
                        iIndexOf += f2556e.indexOf(this.f2562c.charAt(i8));
                    }
                    if (sb.charAt(length) != f2557f[iIndexOf % 43]) {
                        throw c.b.c.d.getChecksumInstance();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw c.b.c.m.getNotFoundInstance();
                }
                float f2 = i2;
                return new c.b.c.r(this.f2561b ? a(sb) : sb.toString(), null, new c.b.c.t[]{new c.b.c.t((r2[1] + r2[0]) / 2.0f, f2), new c.b.c.t(iC + (i5 / 2.0f), f2)}, c.b.c.a.CODE_39);
            }
            iC = iC3;
        }
    }

    public e(boolean z) {
        this(z, false);
    }

    public e(boolean z, boolean z2) {
        this.f2560a = z;
        this.f2561b = z2;
        this.f2562c = new StringBuilder(20);
        this.f2563d = new int[9];
    }

    private static int[] a(c.b.c.z.a aVar, int[] iArr) throws c.b.c.m {
        int iC = aVar.c();
        int iC2 = aVar.c(0);
        int length = iArr.length;
        int i2 = iC2;
        boolean z = false;
        int i3 = 0;
        while (iC2 < iC) {
            if (aVar.b(iC2) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else {
                    if (a(iArr) == f2559h && aVar.a(Math.max(0, i2 - ((iC2 - i2) / 2)), i2, false)) {
                        return new int[]{i2, iC2};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i4] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z = !z;
            }
            iC2++;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if (i11 * 2 >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i5 <= 3) {
                return -1;
            }
            i2 = i3;
        }
    }

    private static char a(int i2) throws c.b.c.m {
        int i3 = 0;
        while (true) {
            int[] iArr = f2558g;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return f2557f[i3];
                }
                i3++;
            } else {
                throw c.b.c.m.getNotFoundInstance();
            }
        }
    }

    private static String a(CharSequence charSequence) throws c.b.c.h {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt != '+' && cCharAt != '$' && cCharAt != '%' && cCharAt != '/') {
                sb.append(cCharAt);
            } else {
                i3++;
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c2 = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i2 = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw c.b.c.h.getFormatInstance();
                                }
                                c2 = ':';
                            }
                            sb.append(c2);
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw c.b.c.h.getFormatInstance();
                            }
                            i2 = cCharAt2 + ' ';
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i2 = cCharAt2 - '&';
                    } else {
                        if (cCharAt2 < 'F' || cCharAt2 > 'W') {
                            throw c.b.c.h.getFormatInstance();
                        }
                        i2 = cCharAt2 - 11;
                    }
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw c.b.c.h.getFormatInstance();
                    }
                    i2 = cCharAt2 - '@';
                }
                c2 = (char) i2;
                sb.append(c2);
            }
            i3++;
        }
        return sb.toString();
    }
}
