package c.b.c.e0.e;

import h.z2.h0;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2650a = 900;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2651b = 901;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2652c = 902;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2653d = 924;

    /* renamed from: e, reason: collision with root package name */
    private static final int f2654e = 925;

    /* renamed from: f, reason: collision with root package name */
    private static final int f2655f = 926;

    /* renamed from: g, reason: collision with root package name */
    private static final int f2656g = 927;

    /* renamed from: h, reason: collision with root package name */
    private static final int f2657h = 928;

    /* renamed from: i, reason: collision with root package name */
    private static final int f2658i = 923;

    /* renamed from: j, reason: collision with root package name */
    private static final int f2659j = 922;

    /* renamed from: k, reason: collision with root package name */
    private static final int f2660k = 913;

    /* renamed from: l, reason: collision with root package name */
    private static final int f2661l = 15;

    /* renamed from: m, reason: collision with root package name */
    private static final int f2662m = 25;
    private static final int n = 27;
    private static final int o = 27;
    private static final int p = 28;
    private static final int q = 28;
    private static final int r = 29;
    private static final int s = 29;
    private static final char[] t = {';', h0.f16707d, h0.f16708e, '@', '[', '\\', ']', '_', '`', '~', '!', '\r', '\t', ',', ':', '\n', '-', '.', h0.f16705b, '/', h0.f16704a, '|', '*', '(', ')', '?', '{', '}', '\''};
    private static final char[] u = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', h0.f16706c, '\r', '\t', ',', ':', '#', '-', '.', h0.f16705b, '/', '+', '%', '*', '=', '^'};
    private static final Charset v = Charset.forName(i.a.a.a.c.f16729a);
    private static final BigInteger[] w = new BigInteger[16];
    private static final int x = 2;

    /* compiled from: DecodedBitStreamParser.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2663a = new int[b.values().length];

        static {
            try {
                f2663a[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2663a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2663a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2663a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2663a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2663a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: DecodedBitStreamParser.java */
    private enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        w[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        w[1] = bigIntegerValueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr = w;
            if (i2 >= bigIntegerArr.length) {
                return;
            }
            bigIntegerArr[i2] = bigIntegerArr[i2 - 1].multiply(bigIntegerValueOf);
            i2++;
        }
    }

    private e() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static c.b.c.z.e a(int[] r7, java.lang.String r8) throws c.b.c.h {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r7.length
            r2 = 2
            int r1 = r1 * 2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = c.b.c.e0.e.e.v
            r3 = 1
            r3 = r7[r3]
            c.b.c.e0.c r4 = new c.b.c.e0.c
            r4.<init>()
        L13:
            r5 = 0
            r5 = r7[r5]
            if (r2 >= r5) goto L75
            r5 = 913(0x391, float:1.28E-42)
            if (r3 == r5) goto L5c
            switch(r3) {
                case 900: goto L57;
                case 901: goto L52;
                case 902: goto L4d;
                default: goto L1f;
            }
        L1f:
            switch(r3) {
                case 922: goto L48;
                case 923: goto L48;
                case 924: goto L52;
                case 925: goto L45;
                case 926: goto L42;
                case 927: goto L2e;
                case 928: goto L29;
                default: goto L22;
            }
        L22:
            int r2 = r2 + (-1)
            int r2 = b(r7, r2, r0)
            goto L65
        L29:
            int r2 = a(r7, r2, r4)
            goto L65
        L2e:
            int r1 = r2 + 1
            r2 = r7[r2]
            c.b.c.z.d r2 = c.b.c.z.d.getCharacterSetECIByValue(r2)
            java.lang.String r2 = r2.name()
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)
            r6 = r2
            r2 = r1
            r1 = r6
            goto L65
        L42:
            int r2 = r2 + 2
            goto L65
        L45:
            int r2 = r2 + 1
            goto L65
        L48:
            c.b.c.h r7 = c.b.c.h.getFormatInstance()
            throw r7
        L4d:
            int r2 = a(r7, r2, r0)
            goto L65
        L52:
            int r2 = a(r3, r7, r1, r2, r0)
            goto L65
        L57:
            int r2 = b(r7, r2, r0)
            goto L65
        L5c:
            int r3 = r2 + 1
            r2 = r7[r2]
            char r2 = (char) r2
            r0.append(r2)
            r2 = r3
        L65:
            int r3 = r7.length
            if (r2 >= r3) goto L70
            int r3 = r2 + 1
            r2 = r7[r2]
            r6 = r3
            r3 = r2
            r2 = r6
            goto L13
        L70:
            c.b.c.h r7 = c.b.c.h.getFormatInstance()
            throw r7
        L75:
            int r7 = r0.length()
            if (r7 == 0) goto L89
            c.b.c.z.e r7 = new c.b.c.z.e
            java.lang.String r0 = r0.toString()
            r1 = 0
            r7.<init>(r1, r0, r1, r8)
            r7.a(r4)
            return r7
        L89:
            c.b.c.h r7 = c.b.c.h.getFormatInstance()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.e0.e.e.a(int[], java.lang.String):c.b.c.z.e");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0034. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0037. Please report as an issue. */
    private static int b(int[] iArr, int i2, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i2) * 2];
        int[] iArr3 = new int[(iArr[0] - i2) * 2];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i5 < f2650a) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != f2660k) {
                if (i5 != 928) {
                    switch (i5) {
                        case f2650a /* 900 */:
                            iArr2[i3] = f2650a;
                            i3++;
                            break;
                        case f2651b /* 901 */:
                        case f2652c /* 902 */:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                i2 = i4 - 1;
                z = true;
            } else {
                iArr2[i3] = f2660k;
                i2 = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i2 = i4;
        }
        a(iArr2, iArr3, i3, sb);
        return i2;
    }

    private static int a(int[] iArr, int i2, c.b.c.e0.c cVar) throws c.b.c.h {
        if (i2 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i3 = i2;
            int i4 = 0;
            while (i4 < 2) {
                iArr2[i4] = iArr[i3];
                i4++;
                i3++;
            }
            cVar.a(Integer.parseInt(a(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int iB = b(iArr, i3, sb);
            cVar.a(sb.toString());
            if (iArr[iB] == f2658i) {
                int i5 = iB + 1;
                int[] iArr3 = new int[iArr[0] - i5];
                boolean z = false;
                int i6 = 0;
                while (i5 < iArr[0] && !z) {
                    int i7 = i5 + 1;
                    int i8 = iArr[i5];
                    if (i8 < f2650a) {
                        iArr3[i6] = i8;
                        i5 = i7;
                        i6++;
                    } else if (i8 == f2659j) {
                        cVar.a(true);
                        i5 = i7 + 1;
                        z = true;
                    } else {
                        throw c.b.c.h.getFormatInstance();
                    }
                }
                cVar.a(Arrays.copyOf(iArr3, i6));
                return i5;
            }
            if (iArr[iB] != f2659j) {
                return iB;
            }
            cVar.a(true);
            return iB + 1;
        }
        throw c.b.c.h.getFormatInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(int[] iArr, int[] iArr2, int i2, StringBuilder sb) {
        char c2;
        b bVar;
        int i3;
        char c3;
        b bVar2 = b.ALPHA;
        b bVar3 = bVar2;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[i4];
            switch (a.f2663a[bVar2.ordinal()]) {
                case 1:
                    if (i5 < 26) {
                        i3 = i5 + 65;
                        c2 = (char) i3;
                        break;
                    } else {
                        if (i5 != 26) {
                            if (i5 == 27) {
                                bVar2 = b.LOWER;
                            } else if (i5 == 28) {
                                bVar2 = b.MIXED;
                            } else if (i5 == 29) {
                                bVar = b.PUNCT_SHIFT;
                                c2 = 0;
                                b bVar4 = bVar;
                                bVar3 = bVar2;
                                bVar2 = bVar4;
                                break;
                            } else if (i5 == f2660k) {
                                sb.append((char) iArr2[i4]);
                            } else if (i5 == f2650a) {
                                bVar2 = b.ALPHA;
                            }
                            c2 = 0;
                            break;
                        }
                        c2 = ' ';
                        break;
                    }
                case 2:
                    if (i5 < 26) {
                        i3 = i5 + 97;
                        c2 = (char) i3;
                        break;
                    } else {
                        if (i5 != 26) {
                            if (i5 != 27) {
                                if (i5 == 28) {
                                    bVar2 = b.MIXED;
                                } else if (i5 == 29) {
                                    bVar = b.PUNCT_SHIFT;
                                } else if (i5 == f2660k) {
                                    sb.append((char) iArr2[i4]);
                                } else if (i5 == f2650a) {
                                    bVar2 = b.ALPHA;
                                }
                                c2 = 0;
                                break;
                            } else {
                                bVar = b.ALPHA_SHIFT;
                            }
                            c2 = 0;
                            b bVar42 = bVar;
                            bVar3 = bVar2;
                            bVar2 = bVar42;
                            break;
                        }
                        c2 = ' ';
                        break;
                    }
                case 3:
                    if (i5 < 25) {
                        c2 = u[i5];
                        break;
                    } else {
                        if (i5 != 25) {
                            if (i5 != 26) {
                                if (i5 == 27) {
                                    bVar2 = b.LOWER;
                                } else if (i5 == 28) {
                                    bVar2 = b.ALPHA;
                                } else if (i5 == 29) {
                                    bVar = b.PUNCT_SHIFT;
                                    c2 = 0;
                                    b bVar422 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar422;
                                    break;
                                } else if (i5 == f2660k) {
                                    sb.append((char) iArr2[i4]);
                                } else if (i5 == f2650a) {
                                    bVar2 = b.ALPHA;
                                }
                            }
                            c2 = ' ';
                            break;
                        } else {
                            bVar2 = b.PUNCT;
                        }
                        c2 = 0;
                        break;
                    }
                case 4:
                    if (i5 < 29) {
                        c2 = t[i5];
                        break;
                    } else {
                        if (i5 == 29) {
                            bVar2 = b.ALPHA;
                        } else if (i5 == f2660k) {
                            sb.append((char) iArr2[i4]);
                        } else if (i5 == f2650a) {
                            bVar2 = b.ALPHA;
                        }
                        c2 = 0;
                        break;
                    }
                case 5:
                    if (i5 < 26) {
                        c3 = (char) (i5 + 65);
                        c2 = c3;
                        bVar2 = bVar3;
                        break;
                    } else if (i5 == 26) {
                        bVar2 = bVar3;
                        c2 = ' ';
                        break;
                    } else {
                        bVar2 = i5 == f2650a ? b.ALPHA : bVar3;
                        c2 = 0;
                        break;
                    }
                case 6:
                    if (i5 < 29) {
                        c3 = t[i5];
                        c2 = c3;
                        bVar2 = bVar3;
                        break;
                    } else {
                        if (i5 == 29) {
                            bVar2 = b.ALPHA;
                        } else if (i5 == f2660k) {
                            sb.append((char) iArr2[i4]);
                        } else if (i5 == f2650a) {
                            bVar2 = b.ALPHA;
                        }
                        c2 = 0;
                        break;
                    }
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    private static int a(int i2, int[] iArr, Charset charset, int i3, StringBuilder sb) {
        int i4;
        int i5;
        int i6;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = f2659j;
        int i8 = f2658i;
        int i9 = 928;
        long j2 = 900;
        if (i2 == f2651b) {
            int[] iArr2 = new int[6];
            i4 = i3 + 1;
            int i10 = iArr[i3];
            boolean z = false;
            loop0: while (true) {
                i5 = 0;
                long j3 = 0;
                while (i4 < iArr[0] && !z) {
                    int i11 = i5 + 1;
                    iArr2[i5] = i10;
                    j3 = (j3 * j2) + i10;
                    int i12 = i4 + 1;
                    i10 = iArr[i4];
                    if (i10 == f2650a || i10 == f2651b || i10 == f2652c || i10 == f2653d || i10 == 928 || i10 == i8 || i10 == i7) {
                        i4 = i12 - 1;
                        i5 = i11;
                        i7 = f2659j;
                        i8 = f2658i;
                        j2 = 900;
                        z = true;
                    } else if (i11 % 5 != 0 || i11 <= 0) {
                        i4 = i12;
                        i5 = i11;
                        i7 = f2659j;
                        i8 = f2658i;
                        j2 = 900;
                    } else {
                        int i13 = 0;
                        while (i13 < 6) {
                            byteArrayOutputStream.write((byte) (j3 >> ((5 - i13) * 8)));
                            i13++;
                            i7 = f2659j;
                            i8 = f2658i;
                        }
                        i4 = i12;
                        j2 = 900;
                    }
                }
                break loop0;
            }
            if (i4 != iArr[0] || i10 >= f2650a) {
                i6 = i5;
            } else {
                i6 = i5 + 1;
                iArr2[i5] = i10;
            }
            for (int i14 = 0; i14 < i6; i14++) {
                byteArrayOutputStream.write((byte) iArr2[i14]);
            }
        } else if (i2 == f2653d) {
            int i15 = i3;
            int i16 = 0;
            long j4 = 0;
            boolean z2 = false;
            while (i15 < iArr[0] && !z2) {
                int i17 = i15 + 1;
                int i18 = iArr[i15];
                if (i18 < f2650a) {
                    i16++;
                    j4 = (j4 * 900) + i18;
                    i15 = i17;
                } else {
                    if (i18 != f2650a && i18 != f2651b && i18 != f2652c && i18 != f2653d && i18 != i9) {
                        if (i18 != f2658i && i18 != f2659j) {
                            i15 = i17;
                        }
                    }
                    i15 = i17 - 1;
                    z2 = true;
                }
                if (i16 % 5 == 0 && i16 > 0) {
                    int i19 = 0;
                    for (int i20 = 6; i19 < i20; i20 = 6) {
                        byteArrayOutputStream.write((byte) (j4 >> ((5 - i19) * 8)));
                        i19++;
                    }
                    i16 = 0;
                    j4 = 0;
                }
                i9 = 928;
            }
            i4 = i15;
        } else {
            i4 = i3;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i4;
    }

    private static int a(int[] iArr, int i2, StringBuilder sb) throws c.b.c.h {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z = true;
            }
            if (i5 < f2650a) {
                iArr2[i3] = i5;
                i3++;
            } else if (i5 == f2650a || i5 == f2651b || i5 == f2653d || i5 == 928 || i5 == f2658i || i5 == f2659j) {
                i4--;
                z = true;
            }
            if ((i3 % 15 == 0 || i5 == f2652c || z) && i3 > 0) {
                sb.append(a(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }

    private static String a(int[] iArr, int i2) throws c.b.c.h {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigIntegerAdd = bigIntegerAdd.add(w[(i2 - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw c.b.c.h.getFormatInstance();
    }
}
