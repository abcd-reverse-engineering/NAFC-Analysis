package c.b.c.a0.e;

import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;

/* compiled from: HighLevelEncoder.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final char f2384a = 129;

    /* renamed from: b, reason: collision with root package name */
    static final char f2385b = 230;

    /* renamed from: c, reason: collision with root package name */
    static final char f2386c = 231;

    /* renamed from: d, reason: collision with root package name */
    static final char f2387d = 235;

    /* renamed from: e, reason: collision with root package name */
    private static final char f2388e = 236;

    /* renamed from: f, reason: collision with root package name */
    private static final char f2389f = 237;

    /* renamed from: g, reason: collision with root package name */
    static final char f2390g = 238;

    /* renamed from: h, reason: collision with root package name */
    static final char f2391h = 239;

    /* renamed from: i, reason: collision with root package name */
    static final char f2392i = 240;

    /* renamed from: j, reason: collision with root package name */
    static final char f2393j = 254;

    /* renamed from: k, reason: collision with root package name */
    static final char f2394k = 254;

    /* renamed from: l, reason: collision with root package name */
    private static final String f2395l = "[)>\u001e05\u001d";

    /* renamed from: m, reason: collision with root package name */
    private static final String f2396m = "[)>\u001e06\u001d";
    private static final String n = "\u001e\u0004";
    static final int o = 0;
    static final int p = 1;
    static final int q = 2;
    static final int r = 3;
    static final int s = 4;
    static final int t = 5;

    private j() {
    }

    private static char a(char c2, int i2) {
        int i3 = c2 + ((i2 * 149) % TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK) + 1;
        if (i3 > 254) {
            i3 -= TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE;
        }
        return (char) i3;
    }

    static boolean b(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    static boolean c(char c2) {
        return c2 >= 128 && c2 <= 255;
    }

    private static boolean d(char c2) {
        return c2 == ' ' || (c2 >= '0' && c2 <= '9') || (c2 >= 'A' && c2 <= 'Z');
    }

    private static boolean e(char c2) {
        return c2 >= ' ' && c2 <= '^';
    }

    private static boolean f(char c2) {
        return c2 == ' ' || (c2 >= '0' && c2 <= '9') || (c2 >= 'a' && c2 <= 'z');
    }

    private static boolean g(char c2) {
        return i(c2) || c2 == ' ' || (c2 >= '0' && c2 <= '9') || (c2 >= 'A' && c2 <= 'Z');
    }

    private static boolean h(char c2) {
        return false;
    }

    private static boolean i(char c2) {
        return c2 == '\r' || c2 == '*' || c2 == '>';
    }

    public static String a(String str) {
        return a(str, l.FORCE_NONE, (c.b.c.f) null, (c.b.c.f) null);
    }

    public static String a(String str, l lVar, c.b.c.f fVar, c.b.c.f fVar2) {
        int iF = 0;
        g[] gVarArr = {new a(), new c(), new m(), new n(), new f(), new b()};
        h hVar = new h(str);
        hVar.a(lVar);
        hVar.a(fVar, fVar2);
        if (str.startsWith(f2395l) && str.endsWith(n)) {
            hVar.a(f2388e);
            hVar.a(2);
            hVar.f2375f += 7;
        } else if (str.startsWith(f2396m) && str.endsWith(n)) {
            hVar.a(f2389f);
            hVar.a(2);
            hVar.f2375f += 7;
        }
        while (hVar.i()) {
            gVarArr[iF].a(hVar);
            if (hVar.f() >= 0) {
                iF = hVar.f();
                hVar.j();
            }
        }
        int iA = hVar.a();
        hVar.l();
        int iB = hVar.h().b();
        if (iA < iB && iF != 0 && iF != 5) {
            hVar.a((char) 254);
        }
        StringBuilder sbB = hVar.b();
        if (sbB.length() < iB) {
            sbB.append(f2384a);
        }
        while (sbB.length() < iB) {
            sbB.append(a(f2384a, sbB.length() + 1));
        }
        return hVar.b().toString();
    }

    static int a(CharSequence charSequence, int i2, int i3) {
        float[] fArr;
        char c2;
        if (i2 >= charSequence.length()) {
            return i3;
        }
        if (i3 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i3] = 0.0f;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int iA = a(fArr, iArr, Integer.MAX_VALUE, bArr);
                int iA2 = a(bArr);
                if (iArr[0] == iA) {
                    return 0;
                }
                if (iA2 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (iA2 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (iA2 != 1 || bArr[2] <= 0) {
                    return (iA2 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char cCharAt = charSequence.charAt(i5);
            i4++;
            if (b(cCharAt)) {
                fArr[0] = (float) (fArr[0] + 0.5d);
            } else if (c(cCharAt)) {
                fArr[0] = (int) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (int) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (d(cCharAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (c(cCharAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (f(cCharAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (c(cCharAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (g(cCharAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (c(cCharAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (e(cCharAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (c(cCharAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (h(cCharAt)) {
                c2 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c2 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i4 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                a(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int iA3 = a(bArr2);
                if (iArr2[0] < iArr2[c2] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (iA3 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (iA3 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (iA3 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i6 = i2 + i4 + 1; i6 < charSequence.length(); i6++) {
                            char cCharAt2 = charSequence.charAt(i6);
                            if (i(cCharAt2)) {
                                return 3;
                            }
                            if (!g(cCharAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static int a(float[] fArr, int[] iArr, int i2, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i3 = i2;
        for (int i4 = 0; i4 < 6; i4++) {
            iArr[i4] = (int) Math.ceil(fArr[i4]);
            int i5 = iArr[i4];
            if (i3 > i5) {
                Arrays.fill(bArr, (byte) 0);
                i3 = i5;
            }
            if (i3 == i5) {
                bArr[i4] = (byte) (bArr[i4] + 1);
            }
        }
        return i3;
    }

    private static int a(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 += bArr[i3];
        }
        return i2;
    }

    public static int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            while (b(cCharAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    cCharAt = charSequence.charAt(i2);
                }
            }
        }
        return i3;
    }

    static void a(char c2) {
        String hexString = Integer.toHexString(c2);
        throw new IllegalArgumentException("Illegal character: " + c2 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }
}
