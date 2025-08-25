package c.b.c.x;

import c.b.c.g;
import c.b.c.v;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: AztecWriter.java */
/* loaded from: classes.dex */
public final class c implements v {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f2855a = Charset.forName(i.a.a.a.c.f16729a);

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3) {
        return a(str, aVar, i2, i3, null);
    }

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<g, ?> map) {
        String str2 = map == null ? null : (String) map.get(g.CHARACTER_SET);
        Number number = map == null ? null : (Number) map.get(g.ERROR_CORRECTION);
        Number number2 = map != null ? (Number) map.get(g.AZTEC_LAYERS) : null;
        return a(str, aVar, i2, i3, str2 == null ? f2855a : Charset.forName(str2), number == null ? 33 : number.intValue(), number2 == null ? 0 : number2.intValue());
    }

    private static c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Charset charset, int i4, int i5) {
        if (aVar == c.b.c.a.AZTEC) {
            return a(c.b.c.x.f.c.a(str.getBytes(charset), i4, i5), i2, i3);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + aVar);
    }

    private static c.b.c.z.b a(c.b.c.x.f.a aVar, int i2, int i3) {
        c.b.c.z.b bVarC = aVar.c();
        if (bVarC != null) {
            int iG = bVarC.g();
            int iD = bVarC.d();
            int iMax = Math.max(i2, iG);
            int iMax2 = Math.max(i3, iD);
            int iMin = Math.min(iMax / iG, iMax2 / iD);
            int i4 = (iMax - (iG * iMin)) / 2;
            int i5 = (iMax2 - (iD * iMin)) / 2;
            c.b.c.z.b bVar = new c.b.c.z.b(iMax, iMax2);
            int i6 = 0;
            while (i6 < iD) {
                int i7 = i4;
                int i8 = 0;
                while (i8 < iG) {
                    if (bVarC.b(i8, i6)) {
                        bVar.a(i7, i5, iMin, iMin);
                    }
                    i8++;
                    i7 += iMin;
                }
                i6++;
                i5 += iMin;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
