package c.b.c.f0.c;

import c.b.c.z.l;
import h.z2.h0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2751a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', h0.f16705b, '%', '*', '+', '-', '.', '/', ':'};

    /* renamed from: b, reason: collision with root package name */
    private static final int f2752b = 1;

    private d() {
    }

    static c.b.c.z.e a(byte[] bArr, j jVar, f fVar, Map<c.b.c.e, ?> map) throws c.b.c.h {
        h hVar;
        c.b.c.z.c cVar = new c.b.c.z.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i2 = 1;
        ArrayList arrayList = new ArrayList(1);
        c.b.c.z.d characterSetECIByValue = null;
        boolean z = false;
        int i3 = -1;
        int iA = -1;
        while (true) {
            try {
                h hVarForBits = cVar.a() < 4 ? h.TERMINATOR : h.forBits(cVar.a(4));
                if (hVarForBits == h.TERMINATOR) {
                    hVar = hVarForBits;
                } else if (hVarForBits == h.FNC1_FIRST_POSITION || hVarForBits == h.FNC1_SECOND_POSITION) {
                    hVar = hVarForBits;
                    z = true;
                } else {
                    if (hVarForBits == h.STRUCTURED_APPEND) {
                        if (cVar.a() < 16) {
                            throw c.b.c.h.getFormatInstance();
                        }
                        int iA2 = cVar.a(8);
                        iA = cVar.a(8);
                        i3 = iA2;
                    } else if (hVarForBits == h.ECI) {
                        characterSetECIByValue = c.b.c.z.d.getCharacterSetECIByValue(a(cVar));
                        if (characterSetECIByValue == null) {
                            throw c.b.c.h.getFormatInstance();
                        }
                    } else if (hVarForBits == h.HANZI) {
                        int iA3 = cVar.a(4);
                        int iA4 = cVar.a(hVarForBits.getCharacterCountBits(jVar));
                        if (iA3 == i2) {
                            a(cVar, sb, iA4);
                        }
                    } else {
                        int iA5 = cVar.a(hVarForBits.getCharacterCountBits(jVar));
                        if (hVarForBits == h.NUMERIC) {
                            c(cVar, sb, iA5);
                        } else if (hVarForBits == h.ALPHANUMERIC) {
                            a(cVar, sb, iA5, z);
                        } else if (hVarForBits == h.BYTE) {
                            hVar = hVarForBits;
                            a(cVar, sb, iA5, characterSetECIByValue, arrayList, map);
                        } else {
                            hVar = hVarForBits;
                            if (hVar != h.KANJI) {
                                throw c.b.c.h.getFormatInstance();
                            }
                            b(cVar, sb, iA5);
                        }
                    }
                    hVar = hVarForBits;
                }
                if (hVar == h.TERMINATOR) {
                    return new c.b.c.z.e(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, fVar == null ? null : fVar.toString(), i3, iA);
                }
                i2 = 1;
            } catch (IllegalArgumentException unused) {
                throw c.b.c.h.getFormatInstance();
            }
        }
    }

    private static void b(c.b.c.z.c cVar, StringBuilder sb, int i2) throws c.b.c.h {
        if (i2 * 13 > cVar.a()) {
            throw c.b.c.h.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iA = cVar.a(13);
            int i4 = (iA % 192) | ((iA / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, l.f3046b));
        } catch (UnsupportedEncodingException unused) {
            throw c.b.c.h.getFormatInstance();
        }
    }

    private static void c(c.b.c.z.c cVar, StringBuilder sb, int i2) throws c.b.c.h {
        while (i2 >= 3) {
            if (cVar.a() < 10) {
                throw c.b.c.h.getFormatInstance();
            }
            int iA = cVar.a(10);
            if (iA >= 1000) {
                throw c.b.c.h.getFormatInstance();
            }
            sb.append(a(iA / 100));
            sb.append(a((iA / 10) % 10));
            sb.append(a(iA % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (cVar.a() < 7) {
                throw c.b.c.h.getFormatInstance();
            }
            int iA2 = cVar.a(7);
            if (iA2 >= 100) {
                throw c.b.c.h.getFormatInstance();
            }
            sb.append(a(iA2 / 10));
            sb.append(a(iA2 % 10));
            return;
        }
        if (i2 == 1) {
            if (cVar.a() < 4) {
                throw c.b.c.h.getFormatInstance();
            }
            int iA3 = cVar.a(4);
            if (iA3 >= 10) {
                throw c.b.c.h.getFormatInstance();
            }
            sb.append(a(iA3));
        }
    }

    private static void a(c.b.c.z.c cVar, StringBuilder sb, int i2) throws c.b.c.h {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int iA = cVar.a(13);
                int i4 = (iA % 96) | ((iA / 96) << 8);
                int i5 = i4 + (i4 < 959 ? 41377 : 42657);
                bArr[i3] = (byte) ((i5 >> 8) & 255);
                bArr[i3 + 1] = (byte) (i5 & 255);
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, l.f3047c));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw c.b.c.h.getFormatInstance();
            }
        }
        throw c.b.c.h.getFormatInstance();
    }

    private static void a(c.b.c.z.c cVar, StringBuilder sb, int i2, c.b.c.z.d dVar, Collection<byte[]> collection, Map<c.b.c.e, ?> map) throws c.b.c.h {
        String strName;
        if (i2 * 8 <= cVar.a()) {
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = (byte) cVar.a(8);
            }
            if (dVar == null) {
                strName = l.a(bArr, map);
            } else {
                strName = dVar.name();
            }
            try {
                sb.append(new String(bArr, strName));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw c.b.c.h.getFormatInstance();
            }
        }
        throw c.b.c.h.getFormatInstance();
    }

    private static char a(int i2) throws c.b.c.h {
        char[] cArr = f2751a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw c.b.c.h.getFormatInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(c.b.c.z.c r3, java.lang.StringBuilder r4, int r5, boolean r6) throws c.b.c.h {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.a()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.a(r2)
            int r2 = r1 / 45
            char r2 = a(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = a(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            c.b.c.h r3 = c.b.c.h.getFormatInstance()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.a()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.a(r2)
            char r3 = a(r3)
            r4.append(r3)
            goto L47
        L42:
            c.b.c.h r3 = c.b.c.h.getFormatInstance()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.f0.c.d.a(c.b.c.z.c, java.lang.StringBuilder, int, boolean):void");
    }

    private static int a(c.b.c.z.c cVar) throws c.b.c.h {
        int iA = cVar.a(8);
        if ((iA & 128) == 0) {
            return iA & 127;
        }
        if ((iA & 192) == 128) {
            return cVar.a(8) | ((iA & 63) << 8);
        }
        if ((iA & 224) == 192) {
            return cVar.a(16) | ((iA & 31) << 16);
        }
        throw c.b.c.h.getFormatInstance();
    }
}
