package c.b.c.a0.e;

import com.umeng.socialize.bean.HandlerRequestCode;

/* compiled from: SymbolInfo.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: i, reason: collision with root package name */
    static final k[] f2397i = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, com.hicorenational.antifraud.a.f5936e, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, HandlerRequestCode.TWITTER_REQUEST_AUTH_CODE, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, com.hicorenational.antifraud.a.f5936e, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, 408, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};

    /* renamed from: j, reason: collision with root package name */
    private static k[] f2398j = f2397i;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2399a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2400b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2401c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2402d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2403e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2404f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2405g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2406h;

    public k(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    public static void a(k[] kVarArr) {
        f2398j = kVarArr;
    }

    public static k c(int i2) {
        return a(i2, l.FORCE_NONE, true);
    }

    public final int b() {
        return this.f2400b;
    }

    final int d() {
        int i2 = this.f2404f;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2 && i2 != 4) {
                if (i2 == 16) {
                    return 4;
                }
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i3;
    }

    public int e() {
        return this.f2400b / this.f2405g;
    }

    public final int f() {
        return j() * this.f2403e;
    }

    public final int g() {
        return d() * this.f2402d;
    }

    public final int h() {
        return f() + (j() * 2);
    }

    public final int i() {
        return g() + (d() * 2);
    }

    final int j() {
        int i2 = this.f2404f;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2399a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f2402d);
        sb.append('x');
        sb.append(this.f2403e);
        sb.append(", symbol size ");
        sb.append(i());
        sb.append('x');
        sb.append(h());
        sb.append(", symbol data size ");
        sb.append(g());
        sb.append('x');
        sb.append(f());
        sb.append(", codewords ");
        sb.append(this.f2400b);
        sb.append('+');
        sb.append(this.f2401c);
        return sb.toString();
    }

    k(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f2399a = z;
        this.f2400b = i2;
        this.f2401c = i3;
        this.f2402d = i4;
        this.f2403e = i5;
        this.f2404f = i6;
        this.f2405g = i7;
        this.f2406h = i8;
    }

    public static k a(int i2, l lVar) {
        return a(i2, lVar, true);
    }

    public final int b(int i2) {
        return this.f2406h;
    }

    public final int c() {
        return this.f2401c;
    }

    public static k a(int i2, boolean z, boolean z2) {
        return a(i2, z ? l.FORCE_NONE : l.FORCE_SQUARE, z2);
    }

    private static k a(int i2, l lVar, boolean z) {
        return a(i2, lVar, null, null, z);
    }

    public static k a(int i2, l lVar, c.b.c.f fVar, c.b.c.f fVar2, boolean z) {
        for (k kVar : f2398j) {
            if (!(lVar == l.FORCE_SQUARE && kVar.f2399a) && ((lVar != l.FORCE_RECTANGLE || kVar.f2399a) && ((fVar == null || (kVar.i() >= fVar.b() && kVar.h() >= fVar.a())) && ((fVar2 == null || (kVar.i() <= fVar2.b() && kVar.h() <= fVar2.a())) && i2 <= kVar.f2400b)))) {
                return kVar;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i2);
    }

    public int a() {
        return this.f2400b + this.f2401c;
    }

    public int a(int i2) {
        return this.f2405g;
    }
}
