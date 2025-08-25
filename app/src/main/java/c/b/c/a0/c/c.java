package c.b.c.a0.c;

import c.b.c.h;
import h.z2.h0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2341a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f2342b = {'!', h0.f16704a, '#', h0.f16705b, '%', h0.f16706c, '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', h0.f16707d, '=', h0.f16708e, '?', '@', '[', '\\', ']', '^', '_'};

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f2343c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f2344d = f2342b;

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f2345e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* compiled from: DecodedBitStreamParser.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2346a = new int[b.values().length];

        static {
            try {
                f2346a[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2346a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2346a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2346a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2346a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: DecodedBitStreamParser.java */
    private enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    private c() {
    }

    static c.b.c.z.e a(byte[] bArr) throws h {
        c.b.c.z.c cVar = new c.b.c.z.c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVarA = b.ASCII_ENCODE;
        do {
            if (bVarA == b.ASCII_ENCODE) {
                bVarA = a(cVar, sb, sb2);
            } else {
                int i2 = a.f2346a[bVarA.ordinal()];
                if (i2 == 1) {
                    b(cVar, sb);
                } else if (i2 == 2) {
                    d(cVar, sb);
                } else if (i2 == 3) {
                    a(cVar, sb);
                } else if (i2 == 4) {
                    c(cVar, sb);
                } else {
                    if (i2 != 5) {
                        throw h.getFormatInstance();
                    }
                    a(cVar, sb, arrayList);
                }
                bVarA = b.ASCII_ENCODE;
            }
            if (bVarA == b.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new c.b.c.z.e(bArr, string, arrayList, null);
    }

    private static void b(c.b.c.z.c cVar, StringBuilder sb) throws h {
        int iA;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (iA = cVar.a(8)) != 254) {
            a(iA, cVar.a(8), iArr);
            boolean z2 = z;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f2342b;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                    z2 = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw h.getFormatInstance();
                                }
                                z2 = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw h.getFormatInstance();
                            }
                            if (z2) {
                                sb.append((char) (i4 + 224));
                                z2 = false;
                                i2 = 0;
                            } else {
                                sb.append((char) (i4 + 96));
                                i2 = 0;
                            }
                        }
                    } else if (z2) {
                        sb.append((char) (i4 + 128));
                        z2 = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = f2341a;
                    if (i4 >= cArr2.length) {
                        throw h.getFormatInstance();
                    }
                    char c3 = cArr2[i4];
                    if (z2) {
                        sb.append((char) (c3 + 128));
                        z2 = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            } else {
                z = z2;
            }
        }
    }

    private static void c(c.b.c.z.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i2 = 0; i2 < 4; i2++) {
                int iA = cVar.a(6);
                if (iA == 31) {
                    int iB = 8 - cVar.b();
                    if (iB != 8) {
                        cVar.a(iB);
                        return;
                    }
                    return;
                }
                if ((iA & 32) == 0) {
                    iA |= 64;
                }
                sb.append((char) iA);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void d(c.b.c.z.c cVar, StringBuilder sb) throws h {
        int iA;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (iA = cVar.a(8)) != 254) {
            a(iA, cVar.a(8), iArr);
            boolean z2 = z;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f2344d;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                    z2 = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw h.getFormatInstance();
                                }
                                z2 = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw h.getFormatInstance();
                            }
                            char[] cArr2 = f2345e;
                            if (i4 >= cArr2.length) {
                                throw h.getFormatInstance();
                            }
                            char c3 = cArr2[i4];
                            if (z2) {
                                sb.append((char) (c3 + 128));
                                z2 = false;
                                i2 = 0;
                            } else {
                                sb.append(c3);
                                i2 = 0;
                            }
                        }
                    } else if (z2) {
                        sb.append((char) (i4 + 128));
                        z2 = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr3 = f2343c;
                    if (i4 >= cArr3.length) {
                        throw h.getFormatInstance();
                    }
                    char c4 = cArr3[i4];
                    if (z2) {
                        sb.append((char) (c4 + 128));
                        z2 = false;
                    } else {
                        sb.append(c4);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            } else {
                z = z2;
            }
        }
    }

    private static b a(c.b.c.z.c cVar, StringBuilder sb, StringBuilder sb2) throws h {
        boolean z = false;
        do {
            int iA = cVar.a(8);
            if (iA == 0) {
                throw h.getFormatInstance();
            }
            if (iA <= 128) {
                if (z) {
                    iA += 128;
                }
                sb.append((char) (iA - 1));
                return b.ASCII_ENCODE;
            }
            if (iA == 129) {
                return b.PAD_ENCODE;
            }
            if (iA <= 229) {
                int i2 = iA - 130;
                if (i2 < 10) {
                    sb.append('0');
                }
                sb.append(i2);
            } else {
                if (iA == 230) {
                    return b.C40_ENCODE;
                }
                if (iA == 231) {
                    return b.BASE256_ENCODE;
                }
                if (iA == 232) {
                    sb.append((char) 29);
                } else if (iA != 233 && iA != 234) {
                    if (iA == 235) {
                        z = true;
                    } else if (iA == 236) {
                        sb.append("[)>\u001e05\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else if (iA == 237) {
                        sb.append("[)>\u001e06\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else {
                        if (iA == 238) {
                            return b.ANSIX12_ENCODE;
                        }
                        if (iA == 239) {
                            return b.TEXT_ENCODE;
                        }
                        if (iA == 240) {
                            return b.EDIFACT_ENCODE;
                        }
                        if (iA != 241 && iA >= 242 && (iA != 254 || cVar.a() != 0)) {
                            throw h.getFormatInstance();
                        }
                    }
                }
            }
        } while (cVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static void a(c.b.c.z.c cVar, StringBuilder sb) throws h {
        int iA;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (iA = cVar.a(8)) != 254) {
            a(iA, cVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    sb.append('\r');
                } else if (i3 == 1) {
                    sb.append('*');
                } else if (i3 == 2) {
                    sb.append(h0.f16708e);
                } else if (i3 == 3) {
                    sb.append(' ');
                } else if (i3 < 14) {
                    sb.append((char) (i3 + 44));
                } else if (i3 < 40) {
                    sb.append((char) (i3 + 51));
                } else {
                    throw h.getFormatInstance();
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void a(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    private static void a(c.b.c.z.c cVar, StringBuilder sb, Collection<byte[]> collection) throws h {
        int iC = cVar.c() + 1;
        int i2 = iC + 1;
        int iA = a(cVar.a(8), iC);
        if (iA == 0) {
            iA = cVar.a() / 8;
        } else if (iA >= 250) {
            iA = ((iA - 249) * 250) + a(cVar.a(8), i2);
            i2++;
        }
        if (iA >= 0) {
            byte[] bArr = new byte[iA];
            int i3 = 0;
            while (i3 < iA) {
                if (cVar.a() >= 8) {
                    bArr[i3] = (byte) a(cVar.a(8), i2);
                    i3++;
                    i2++;
                } else {
                    throw h.getFormatInstance();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
                return;
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: " + e2);
            }
        }
        throw h.getFormatInstance();
    }

    private static int a(int i2, int i3) {
        int i4 = i2 - (((i3 * 149) % 255) + 1);
        return i4 >= 0 ? i4 : i4 + 256;
    }
}
