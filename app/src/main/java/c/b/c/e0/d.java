package c.b.c.e0;

import c.b.c.e0.g.e;
import c.b.c.g;
import c.b.c.v;
import c.b.c.w;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: PDF417Writer.java */
/* loaded from: classes.dex */
public final class d implements v {

    /* renamed from: a, reason: collision with root package name */
    static final int f2627a = 30;

    /* renamed from: b, reason: collision with root package name */
    static final int f2628b = 2;

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<g, ?> map) throws w {
        int i4;
        int i5;
        if (aVar != c.b.c.a.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + aVar);
        }
        e eVar = new e();
        if (map != null) {
            if (map.containsKey(g.PDF417_COMPACT)) {
                eVar.a(((Boolean) map.get(g.PDF417_COMPACT)).booleanValue());
            }
            if (map.containsKey(g.PDF417_COMPACTION)) {
                eVar.a((c.b.c.e0.g.c) map.get(g.PDF417_COMPACTION));
            }
            if (map.containsKey(g.PDF417_DIMENSIONS)) {
                c.b.c.e0.g.d dVar = (c.b.c.e0.g.d) map.get(g.PDF417_DIMENSIONS);
                eVar.a(dVar.a(), dVar.c(), dVar.b(), dVar.d());
            }
            int iIntValue = map.containsKey(g.MARGIN) ? ((Number) map.get(g.MARGIN)).intValue() : 30;
            int iIntValue2 = map.containsKey(g.ERROR_CORRECTION) ? ((Number) map.get(g.ERROR_CORRECTION)).intValue() : 2;
            if (map.containsKey(g.CHARACTER_SET)) {
                eVar.a(Charset.forName((String) map.get(g.CHARACTER_SET)));
            }
            i5 = iIntValue;
            i4 = iIntValue2;
        } else {
            i4 = 2;
            i5 = 30;
        }
        return a(eVar, str, i4, i2, i3, i5);
    }

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3) throws w {
        return a(str, aVar, i2, i3, null);
    }

    private static c.b.c.z.b a(e eVar, String str, int i2, int i3, int i4, int i5) throws w {
        boolean z;
        eVar.a(str, i2);
        byte[][] bArrA = eVar.a().a(1, 4);
        if ((i4 > i3) ^ (bArrA[0].length < bArrA.length)) {
            bArrA = a(bArrA);
            z = true;
        } else {
            z = false;
        }
        int length = i3 / bArrA[0].length;
        int length2 = i4 / bArrA.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            byte[][] bArrA2 = eVar.a().a(length, length * 4);
            if (z) {
                bArrA2 = a(bArrA2);
            }
            return a(bArrA2, i5);
        }
        return a(bArrA, i5);
    }

    private static c.b.c.z.b a(byte[][] bArr, int i2) {
        int i3 = i2 * 2;
        c.b.c.z.b bVar = new c.b.c.z.b(bArr[0].length + i3, bArr.length + i3);
        bVar.a();
        int iD = (bVar.d() - i2) - 1;
        int i4 = 0;
        while (i4 < bArr.length) {
            for (int i5 = 0; i5 < bArr[0].length; i5++) {
                if (bArr[i4][i5] == 1) {
                    bVar.c(i5 + i2, iD);
                }
            }
            i4++;
            iD--;
        }
        return bVar;
    }

    private static byte[][] a(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) byte.class, bArr[0].length, bArr.length);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int length = (bArr.length - i2) - 1;
            for (int i3 = 0; i3 < bArr[0].length; i3++) {
                bArr2[i3][length] = bArr[i2][i3];
            }
        }
        return bArr2;
    }
}
