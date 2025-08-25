package c.b.c.c0;

import c.b.c.d;
import c.b.c.e;
import c.b.c.h;
import c.b.c.m;
import c.b.c.p;
import c.b.c.r;
import c.b.c.t;
import java.util.Map;

/* compiled from: ByQuadrantReader.java */
/* loaded from: classes.dex */
public final class a implements p {

    /* renamed from: a, reason: collision with root package name */
    private final p f2434a;

    public a(p pVar) {
        this.f2434a = pVar;
    }

    @Override // c.b.c.p
    public r a(c.b.c.c cVar) throws d, h, m {
        return a(cVar, null);
    }

    @Override // c.b.c.p
    public void reset() {
        this.f2434a.reset();
    }

    @Override // c.b.c.p
    public r a(c.b.c.c cVar, Map<e, ?> map) throws d, h, m {
        int iC = cVar.c() / 2;
        int iB = cVar.b() / 2;
        try {
            try {
                try {
                    try {
                        return this.f2434a.a(cVar.a(0, 0, iC, iB), map);
                    } catch (m unused) {
                        r rVarA = this.f2434a.a(cVar.a(iC, 0, iC, iB), map);
                        a(rVarA.d(), iC, 0);
                        return rVarA;
                    }
                } catch (m unused2) {
                    int i2 = iC / 2;
                    int i3 = iB / 2;
                    r rVarA2 = this.f2434a.a(cVar.a(i2, i3, iC, iB), map);
                    a(rVarA2.d(), i2, i3);
                    return rVarA2;
                }
            } catch (m unused3) {
                r rVarA3 = this.f2434a.a(cVar.a(0, iB, iC, iB), map);
                a(rVarA3.d(), 0, iB);
                return rVarA3;
            }
        } catch (m unused4) {
            r rVarA4 = this.f2434a.a(cVar.a(iC, iB, iC, iB), map);
            a(rVarA4.d(), iC, iB);
            return rVarA4;
        }
    }

    private static void a(t[] tVarArr, int i2, int i3) {
        if (tVarArr != null) {
            for (int i4 = 0; i4 < tVarArr.length; i4++) {
                t tVar = tVarArr[i4];
                tVarArr[i4] = new t(tVar.a() + i2, tVar.b() + i3);
            }
        }
    }
}
