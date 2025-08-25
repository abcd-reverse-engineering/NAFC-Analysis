package c.b.c.f0.d;

import c.b.c.f0.c.j;
import c.b.c.h;
import c.b.c.m;
import c.b.c.t;
import c.b.c.u;
import c.b.c.z.g;
import c.b.c.z.i;
import c.b.c.z.k;
import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f2783a;

    /* renamed from: b, reason: collision with root package name */
    private u f2784b;

    public c(c.b.c.z.b bVar) {
        this.f2783a = bVar;
    }

    public g a() throws h, m {
        return a((Map<c.b.c.e, ?>) null);
    }

    protected final c.b.c.z.b b() {
        return this.f2783a;
    }

    protected final u c() {
        return this.f2784b;
    }

    private float b(int i2, int i3, int i4, int i5) {
        int iG;
        float fG;
        float fD;
        float fA = a(i2, i3, i4, i5);
        int i6 = i2 - (i4 - i2);
        int iD = 0;
        if (i6 < 0) {
            fG = i2 / (i2 - i6);
            iG = 0;
        } else if (i6 >= this.f2783a.g()) {
            fG = ((this.f2783a.g() - 1) - i2) / (i6 - i2);
            iG = this.f2783a.g() - 1;
        } else {
            iG = i6;
            fG = 1.0f;
        }
        float f2 = i3;
        int i7 = (int) (f2 - ((i5 - i3) * fG));
        if (i7 < 0) {
            fD = f2 / (i3 - i7);
        } else if (i7 >= this.f2783a.d()) {
            fD = ((this.f2783a.d() - 1) - i3) / (i7 - i3);
            iD = this.f2783a.d() - 1;
        } else {
            iD = i7;
            fD = 1.0f;
        }
        return (fA + a(i2, i3, (int) (i2 + ((iG - i2) * fD)), iD)) - 1.0f;
    }

    public final g a(Map<c.b.c.e, ?> map) throws h, m {
        this.f2784b = map == null ? null : (u) map.get(c.b.c.e.NEED_RESULT_POINT_CALLBACK);
        return a(new e(this.f2783a, this.f2784b).a(map));
    }

    protected final g a(f fVar) throws h, m {
        d dVarB = fVar.b();
        d dVarC = fVar.c();
        d dVarA = fVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA >= 1.0f) {
            int iA = a(dVarB, dVarC, dVarA, fA);
            j jVarB = j.b(iA);
            int iC = jVarB.c() - 7;
            a aVarA = null;
            if (jVarB.b().length > 0) {
                float fA2 = (dVarC.a() - dVarB.a()) + dVarA.a();
                float fB = (dVarC.b() - dVarB.b()) + dVarA.b();
                float f2 = 1.0f - (3.0f / iC);
                int iA2 = (int) (dVarB.a() + ((fA2 - dVarB.a()) * f2));
                int iB = (int) (dVarB.b() + (f2 * (fB - dVarB.b())));
                for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                    try {
                        aVarA = a(fA, iA2, iB, i2);
                        break;
                    } catch (m unused) {
                    }
                }
            }
            return new g(a(this.f2783a, a(dVarB, dVarC, dVarA, aVarA, iA), iA), aVarA == null ? new t[]{dVarA, dVarB, dVarC} : new t[]{dVarA, dVarB, dVarC, aVarA});
        }
        throw m.getNotFoundInstance();
    }

    private static k a(t tVar, t tVar2, t tVar3, t tVar4, int i2) {
        float fA;
        float fB;
        float f2;
        float f3 = i2 - 3.5f;
        if (tVar4 != null) {
            fA = tVar4.a();
            fB = tVar4.b();
            f2 = f3 - 3.0f;
        } else {
            fA = (tVar2.a() - tVar.a()) + tVar3.a();
            fB = (tVar2.b() - tVar.b()) + tVar3.b();
            f2 = f3;
        }
        return k.a(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, tVar.a(), tVar.b(), tVar2.a(), tVar2.b(), fA, fB, tVar3.a(), tVar3.b());
    }

    private static c.b.c.z.b a(c.b.c.z.b bVar, k kVar, int i2) throws m {
        return i.a().a(bVar, i2, i2, kVar);
    }

    private static int a(t tVar, t tVar2, t tVar3, float f2) throws m {
        int iA = ((c.b.c.z.m.a.a(t.a(tVar, tVar2) / f2) + c.b.c.z.m.a.a(t.a(tVar, tVar3) / f2)) / 2) + 7;
        int i2 = iA & 3;
        if (i2 == 0) {
            return iA + 1;
        }
        if (i2 == 2) {
            return iA - 1;
        }
        if (i2 != 3) {
            return iA;
        }
        throw m.getNotFoundInstance();
    }

    protected final float a(t tVar, t tVar2, t tVar3) {
        return (a(tVar, tVar2) + a(tVar, tVar3)) / 2.0f;
    }

    private float a(t tVar, t tVar2) {
        float fB = b((int) tVar.a(), (int) tVar.b(), (int) tVar2.a(), (int) tVar2.b());
        float fB2 = b((int) tVar2.a(), (int) tVar2.b(), (int) tVar.a(), (int) tVar.b());
        return Float.isNaN(fB) ? fB2 / 7.0f : Float.isNaN(fB2) ? fB / 7.0f : (fB + fB2) / 14.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
    
        if (r14 != 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
    
        return c.b.c.z.m.a.a(r19, r5, r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008f, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r6 = r18
            r4 = r19
            r5 = r20
            r1 = r21
            goto L25
        L1d:
            r4 = r18
            r6 = r19
            r1 = r20
            r5 = r21
        L25:
            int r7 = r1 - r4
            int r7 = java.lang.Math.abs(r7)
            int r8 = r5 - r6
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r4 >= r1) goto L39
            r12 = 1
            goto L3a
        L39:
            r12 = -1
        L3a:
            if (r6 >= r5) goto L3d
            r11 = 1
        L3d:
            int r1 = r1 + r12
            r13 = r6
            r15 = r9
            r14 = 0
            r9 = r4
        L42:
            if (r9 == r1) goto L81
            if (r0 == 0) goto L48
            r2 = r13
            goto L49
        L48:
            r2 = r9
        L49:
            if (r0 == 0) goto L4d
            r10 = r9
            goto L4e
        L4d:
            r10 = r13
        L4e:
            if (r14 != r3) goto L58
            r3 = r17
            r16 = r0
            r19 = r1
            r0 = 1
            goto L5f
        L58:
            r3 = r17
            r16 = r0
            r19 = r1
            r0 = 0
        L5f:
            c.b.c.z.b r1 = r3.f2783a
            boolean r1 = r1.b(r2, r10)
            if (r0 != r1) goto L71
            r0 = 2
            if (r14 != r0) goto L6f
            float r0 = c.b.c.z.m.a.a(r9, r13, r4, r6)
            return r0
        L6f:
            int r14 = r14 + 1
        L71:
            int r15 = r15 + r8
            if (r15 <= 0) goto L79
            if (r13 != r5) goto L77
            goto L85
        L77:
            int r13 = r13 + r11
            int r15 = r15 - r7
        L79:
            int r9 = r9 + r12
            r1 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L42
        L81:
            r3 = r17
            r19 = r1
        L85:
            r0 = 2
            if (r14 != r0) goto L8f
            r1 = r19
            float r0 = c.b.c.z.m.a.a(r1, r5, r4, r6)
            return r0
        L8f:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.f0.d.c.a(int, int, int, int):float");
    }

    protected final a a(float f2, int i2, int i3, float f3) throws m {
        int i4 = (int) (f3 * f2);
        int iMax = Math.max(0, i2 - i4);
        int iMin = Math.min(this.f2783a.g() - 1, i2 + i4) - iMax;
        float f4 = 3.0f * f2;
        if (iMin >= f4) {
            int iMax2 = Math.max(0, i3 - i4);
            int iMin2 = Math.min(this.f2783a.d() - 1, i3 + i4) - iMax2;
            if (iMin2 >= f4) {
                return new b(this.f2783a, iMax, iMax2, iMin, iMin2, f2, this.f2784b).a();
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }
}
