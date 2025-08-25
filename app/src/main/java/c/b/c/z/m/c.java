package c.b.c.z.m;

import c.b.c.m;
import c.b.c.t;

/* compiled from: WhiteRectangleDetector.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: h, reason: collision with root package name */
    private static final int f3054h = 10;

    /* renamed from: i, reason: collision with root package name */
    private static final int f3055i = 1;

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f3056a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3057b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3058c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3059d;

    /* renamed from: e, reason: collision with root package name */
    private final int f3060e;

    /* renamed from: f, reason: collision with root package name */
    private final int f3061f;

    /* renamed from: g, reason: collision with root package name */
    private final int f3062g;

    public c(c.b.c.z.b bVar) throws m {
        this(bVar, 10, bVar.g() / 2, bVar.d() / 2);
    }

    public t[] a() throws m {
        boolean z;
        int i2 = this.f3059d;
        int i3 = this.f3060e;
        int i4 = this.f3062g;
        int i5 = this.f3061f;
        boolean z2 = false;
        int i6 = i2;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (boolean z8 = true; z8; z8 = z) {
            boolean zA = true;
            z = false;
            while (true) {
                if ((!zA && z3) || i3 >= this.f3058c) {
                    break;
                }
                zA = a(i4, i5, i3, false);
                if (zA) {
                    i3++;
                    z3 = true;
                    z = true;
                } else if (!z3) {
                    i3++;
                }
            }
            if (i3 < this.f3058c) {
                boolean zA2 = true;
                while (true) {
                    if ((!zA2 && z4) || i5 >= this.f3057b) {
                        break;
                    }
                    zA2 = a(i6, i3, i5, true);
                    if (zA2) {
                        i5++;
                        z4 = true;
                        z = true;
                    } else if (!z4) {
                        i5++;
                    }
                }
                if (i5 < this.f3057b) {
                    boolean zA3 = true;
                    while (true) {
                        if ((!zA3 && z5) || i6 < 0) {
                            break;
                        }
                        zA3 = a(i4, i5, i6, false);
                        if (zA3) {
                            i6--;
                            z5 = true;
                            z = true;
                        } else if (!z5) {
                            i6--;
                        }
                    }
                    if (i6 >= 0) {
                        boolean zA4 = true;
                        while (true) {
                            if ((!zA4 && z7) || i4 < 0) {
                                break;
                            }
                            zA4 = a(i6, i3, i4, true);
                            if (zA4) {
                                i4--;
                                z7 = true;
                                z = true;
                            } else if (!z7) {
                                i4--;
                            }
                        }
                        if (i4 >= 0) {
                            if (z) {
                                z6 = true;
                            }
                        }
                    }
                }
            }
            z2 = true;
            break;
        }
        if (z2 || !z6) {
            throw m.getNotFoundInstance();
        }
        int i7 = i3 - i6;
        t tVarA = null;
        t tVarA2 = null;
        for (int i8 = 1; i8 < i7; i8++) {
            tVarA2 = a(i6, i5 - i8, i6 + i8, i5);
            if (tVarA2 != null) {
                break;
            }
        }
        if (tVarA2 == null) {
            throw m.getNotFoundInstance();
        }
        t tVarA3 = null;
        for (int i9 = 1; i9 < i7; i9++) {
            tVarA3 = a(i6, i4 + i9, i6 + i9, i4);
            if (tVarA3 != null) {
                break;
            }
        }
        if (tVarA3 == null) {
            throw m.getNotFoundInstance();
        }
        t tVarA4 = null;
        for (int i10 = 1; i10 < i7; i10++) {
            tVarA4 = a(i3, i4 + i10, i3 - i10, i4);
            if (tVarA4 != null) {
                break;
            }
        }
        if (tVarA4 == null) {
            throw m.getNotFoundInstance();
        }
        for (int i11 = 1; i11 < i7; i11++) {
            tVarA = a(i3, i5 - i11, i3 - i11, i5);
            if (tVarA != null) {
                break;
            }
        }
        if (tVarA != null) {
            return a(tVarA, tVarA2, tVarA4, tVarA3);
        }
        throw m.getNotFoundInstance();
    }

    public c(c.b.c.z.b bVar, int i2, int i3, int i4) throws m {
        this.f3056a = bVar;
        this.f3057b = bVar.d();
        this.f3058c = bVar.g();
        int i5 = i2 / 2;
        this.f3059d = i3 - i5;
        this.f3060e = i3 + i5;
        this.f3062g = i4 - i5;
        this.f3061f = i4 + i5;
        if (this.f3062g < 0 || this.f3059d < 0 || this.f3061f >= this.f3057b || this.f3060e >= this.f3058c) {
            throw m.getNotFoundInstance();
        }
    }

    private t a(float f2, float f3, float f4, float f5) {
        int iA = a.a(a.a(f2, f3, f4, f5));
        float f6 = iA;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < iA; i2++) {
            float f9 = i2;
            int iA2 = a.a((f9 * f7) + f2);
            int iA3 = a.a((f9 * f8) + f3);
            if (this.f3056a.b(iA2, iA3)) {
                return new t(iA2, iA3);
            }
        }
        return null;
    }

    private t[] a(t tVar, t tVar2, t tVar3, t tVar4) {
        float fA = tVar.a();
        float fB = tVar.b();
        float fA2 = tVar2.a();
        float fB2 = tVar2.b();
        float fA3 = tVar3.a();
        float fB3 = tVar3.b();
        float fA4 = tVar4.a();
        float fB4 = tVar4.b();
        return fA < ((float) this.f3058c) / 2.0f ? new t[]{new t(fA4 - 1.0f, fB4 + 1.0f), new t(fA2 + 1.0f, fB2 + 1.0f), new t(fA3 - 1.0f, fB3 - 1.0f), new t(fA + 1.0f, fB - 1.0f)} : new t[]{new t(fA4 + 1.0f, fB4 + 1.0f), new t(fA2 + 1.0f, fB2 - 1.0f), new t(fA3 - 1.0f, fB3 + 1.0f), new t(fA - 1.0f, fB - 1.0f)};
    }

    private boolean a(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.f3056a.b(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.f3056a.b(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }
}
