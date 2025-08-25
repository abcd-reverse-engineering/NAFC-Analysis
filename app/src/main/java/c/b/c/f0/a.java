package c.b.c.f0;

import c.b.c.c;
import c.b.c.d;
import c.b.c.f0.c.e;
import c.b.c.f0.c.i;
import c.b.c.h;
import c.b.c.m;
import c.b.c.p;
import c.b.c.r;
import c.b.c.s;
import c.b.c.t;
import c.b.c.z.g;
import java.util.List;
import java.util.Map;

/* compiled from: QRCodeReader.java */
/* loaded from: classes.dex */
public class a implements p {

    /* renamed from: b, reason: collision with root package name */
    private static final t[] f2741b = new t[0];

    /* renamed from: a, reason: collision with root package name */
    private final e f2742a = new e();

    protected final e a() {
        return this.f2742a;
    }

    @Override // c.b.c.p
    public void reset() {
    }

    @Override // c.b.c.p
    public r a(c cVar) throws d, h, m {
        return a(cVar, (Map<c.b.c.e, ?>) null);
    }

    @Override // c.b.c.p
    public final r a(c cVar, Map<c.b.c.e, ?> map) throws d, h, m {
        t[] tVarArrB;
        c.b.c.z.e eVarA;
        if (map != null && map.containsKey(c.b.c.e.PURE_BARCODE)) {
            eVarA = this.f2742a.a(a(cVar.a()), map);
            tVarArrB = f2741b;
        } else {
            g gVarA = new c.b.c.f0.d.c(cVar.a()).a(map);
            c.b.c.z.e eVarA2 = this.f2742a.a(gVarA.a(), map);
            tVarArrB = gVarA.b();
            eVarA = eVarA2;
        }
        if (eVarA.e() instanceof i) {
            ((i) eVarA.e()).a(tVarArrB);
        }
        r rVar = new r(eVarA.i(), eVarA.f(), tVarArrB, c.b.c.a.QR_CODE);
        List<byte[]> listA = eVarA.a();
        if (listA != null) {
            rVar.a(s.BYTE_SEGMENTS, listA);
        }
        String strB = eVarA.b();
        if (strB != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, strB);
        }
        if (eVarA.j()) {
            rVar.a(s.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVarA.h()));
            rVar.a(s.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVarA.g()));
        }
        return rVar;
    }

    private static c.b.c.z.b a(c.b.c.z.b bVar) throws m {
        int[] iArrF = bVar.f();
        int[] iArrB = bVar.b();
        if (iArrF != null && iArrB != null) {
            float fA = a(iArrF, bVar);
            int i2 = iArrF[1];
            int i3 = iArrB[1];
            int i4 = iArrF[0];
            int i5 = iArrB[0];
            if (i4 < i5 && i2 < i3) {
                int i6 = i3 - i2;
                if (i6 != i5 - i4) {
                    i5 = i4 + i6;
                }
                int iRound = Math.round(((i5 - i4) + 1) / fA);
                int iRound2 = Math.round((i6 + 1) / fA);
                if (iRound <= 0 || iRound2 <= 0) {
                    throw m.getNotFoundInstance();
                }
                if (iRound2 == iRound) {
                    int i7 = (int) (fA / 2.0f);
                    int i8 = i2 + i7;
                    int i9 = i4 + i7;
                    int i10 = (((int) ((iRound - 1) * fA)) + i9) - i5;
                    if (i10 > 0) {
                        if (i10 > i7) {
                            throw m.getNotFoundInstance();
                        }
                        i9 -= i10;
                    }
                    int i11 = (((int) ((iRound2 - 1) * fA)) + i8) - i3;
                    if (i11 > 0) {
                        if (i11 > i7) {
                            throw m.getNotFoundInstance();
                        }
                        i8 -= i11;
                    }
                    c.b.c.z.b bVar2 = new c.b.c.z.b(iRound, iRound2);
                    for (int i12 = 0; i12 < iRound2; i12++) {
                        int i13 = ((int) (i12 * fA)) + i8;
                        for (int i14 = 0; i14 < iRound; i14++) {
                            if (bVar.b(((int) (i14 * fA)) + i9, i13)) {
                                bVar2.c(i14, i12);
                            }
                        }
                    }
                    return bVar2;
                }
                throw m.getNotFoundInstance();
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }

    private static float a(int[] iArr, c.b.c.z.b bVar) throws m {
        int iD = bVar.d();
        int iG = bVar.g();
        int i2 = iArr[0];
        boolean z = true;
        int i3 = iArr[1];
        int i4 = 0;
        while (i2 < iG && i3 < iD) {
            if (z != bVar.b(i2, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                z = !z;
            }
            i2++;
            i3++;
        }
        if (i2 != iG && i3 != iD) {
            return (i2 - iArr[0]) / 7.0f;
        }
        throw m.getNotFoundInstance();
    }
}
