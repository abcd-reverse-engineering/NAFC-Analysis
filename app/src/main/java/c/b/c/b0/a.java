package c.b.c.b0;

import c.b.c.b0.b.c;
import c.b.c.d;
import c.b.c.e;
import c.b.c.h;
import c.b.c.m;
import c.b.c.p;
import c.b.c.r;
import c.b.c.s;
import c.b.c.t;
import c.b.c.z.b;
import java.util.Map;

/* compiled from: MaxiCodeReader.java */
/* loaded from: classes.dex */
public final class a implements p {

    /* renamed from: b, reason: collision with root package name */
    private static final t[] f2409b = new t[0];

    /* renamed from: c, reason: collision with root package name */
    private static final int f2410c = 30;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2411d = 33;

    /* renamed from: a, reason: collision with root package name */
    private final c f2412a = new c();

    @Override // c.b.c.p
    public r a(c.b.c.c cVar) throws d, h, m {
        return a(cVar, null);
    }

    @Override // c.b.c.p
    public void reset() {
    }

    @Override // c.b.c.p
    public r a(c.b.c.c cVar, Map<e, ?> map) throws d, h, m {
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            throw m.getNotFoundInstance();
        }
        c.b.c.z.e eVarA = this.f2412a.a(a(cVar.a()), map);
        r rVar = new r(eVarA.i(), eVarA.f(), f2409b, c.b.c.a.MAXICODE);
        String strB = eVarA.b();
        if (strB != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, strB);
        }
        return rVar;
    }

    private static b a(b bVar) throws m {
        int[] iArrC = bVar.c();
        if (iArrC != null) {
            int i2 = iArrC[0];
            int i3 = iArrC[1];
            int i4 = iArrC[2];
            int i5 = iArrC[3];
            b bVar2 = new b(30, 33);
            for (int i6 = 0; i6 < 33; i6++) {
                int i7 = (((i6 * i5) + (i5 / 2)) / 33) + i3;
                for (int i8 = 0; i8 < 30; i8++) {
                    if (bVar.b(((((i8 * i4) + (i4 / 2)) + (((i6 & 1) * i4) / 2)) / 30) + i2, i7)) {
                        bVar2.c(i8, i6);
                    }
                }
            }
            return bVar2;
        }
        throw m.getNotFoundInstance();
    }
}
