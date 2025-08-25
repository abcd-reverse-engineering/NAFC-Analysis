package c.b.c.a0.c;

import c.b.c.h;
import com.umeng.socialize.bean.HandlerRequestCode;

/* compiled from: Version.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: h, reason: collision with root package name */
    private static final e[] f2349h = h();

    /* renamed from: a, reason: collision with root package name */
    private final int f2350a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2351b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2352c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2353d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2354e;

    /* renamed from: f, reason: collision with root package name */
    private final c f2355f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2356g;

    /* compiled from: Version.java */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f2357a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2358b;

        int a() {
            return this.f2357a;
        }

        int b() {
            return this.f2358b;
        }

        private b(int i2, int i3) {
            this.f2357a = i2;
            this.f2358b = i3;
        }
    }

    private e(int i2, int i3, int i4, int i5, int i6, c cVar) {
        this.f2350a = i2;
        this.f2351b = i3;
        this.f2352c = i4;
        this.f2353d = i5;
        this.f2354e = i6;
        this.f2355f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.f2356g = iA;
    }

    private static e[] h() {
        int i2 = 1;
        int i3 = 5;
        int i4 = 8;
        int i5 = 7;
        e eVar = new e(3, 14, 14, 12, 12, new c(10, new b(i2, i4)));
        int i6 = 2;
        int i7 = 12;
        int i8 = 18;
        e eVar2 = new e(5, 18, 18, 16, 16, new c(14, new b(i2, 18)));
        int i9 = 4;
        e eVar3 = new e(7, 22, 22, 20, 20, new c(20, new b(i2, 30)));
        int i10 = 6;
        b bVar = new b(i2, 36);
        b bVar2 = new b(i2, 44);
        b bVar3 = new b(i2, 62);
        b bVar4 = new b(i2, 86);
        b bVar5 = new b(i2, 114);
        b bVar6 = new b(i2, 144);
        int i11 = 56;
        b bVar7 = new b(i2, com.hicorenational.antifraud.a.f5936e);
        e eVar4 = new e(15, 52, 52, 24, 24, new c(42, new b(i6, 102)));
        b bVar8 = new b(i9, 92);
        b bVar9 = new b(i9, 114);
        b bVar10 = new b(i9, com.hicorenational.antifraud.a.f5936e);
        b bVar11 = new b(i10, 175);
        return new e[]{new e(1, 10, 10, 8, 8, new c(i3, new b(i2, 3))), new e(2, 12, 12, 10, 10, new c(i5, new b(i2, i3))), eVar, new e(4, 16, 16, 14, 14, new c(i7, new b(i2, i7))), eVar2, new e(6, 20, 20, 18, 18, new c(i8, new b(i2, 22))), eVar3, new e(8, 24, 24, 22, 22, new c(24, bVar)), new e(9, 26, 26, 24, 24, new c(28, bVar2)), new e(10, 32, 32, 14, 14, new c(36, bVar3)), new e(11, 36, 36, 16, 16, new c(42, bVar4)), new e(12, 40, 40, 18, 18, new c(48, bVar5)), new e(13, 44, 44, 20, 20, new c(56, bVar6)), new e(14, 48, 48, 22, 22, new c(68, bVar7)), eVar4, new e(16, 64, 64, 14, 14, new c(i11, new b(i6, HandlerRequestCode.TWITTER_REQUEST_AUTH_CODE))), new e(17, 72, 72, 16, 16, new c(36, bVar8)), new e(18, 80, 80, 18, 18, new c(48, bVar9)), new e(19, 88, 88, 20, 20, new c(i11, new b(i9, 144))), new e(20, 96, 96, 22, 22, new c(68, bVar10)), new e(21, 104, 104, 24, 24, new c(i11, new b(i10, 136))), new e(22, 120, 120, 18, 18, new c(68, bVar11)), new e(23, 132, 132, 20, 20, new c(62, new b(i4, 163))), new e(24, 144, 144, 22, 22, new c(62, new b(i4, 156), new b(i6, 155))), new e(25, 8, 18, 6, 16, new c(i5, new b(i2, i3))), new e(26, 8, 32, 6, 14, new c(11, new b(i2, 10))), new e(27, 12, 26, 10, 24, new c(14, new b(i2, 16))), new e(28, 12, 36, 10, 16, new c(i8, new b(i2, 22))), new e(29, 16, 36, 14, 16, new c(24, new b(i2, 32))), new e(30, 16, 48, 14, 22, new c(28, new b(i2, 49)))};
    }

    public int a() {
        return this.f2354e;
    }

    public int b() {
        return this.f2353d;
    }

    c c() {
        return this.f2355f;
    }

    public int d() {
        return this.f2352c;
    }

    public int e() {
        return this.f2351b;
    }

    public int f() {
        return this.f2356g;
    }

    public int g() {
        return this.f2350a;
    }

    public String toString() {
        return String.valueOf(this.f2350a);
    }

    /* compiled from: Version.java */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final int f2359a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f2360b;

        b[] a() {
            return this.f2360b;
        }

        int b() {
            return this.f2359a;
        }

        private c(int i2, b bVar) {
            this.f2359a = i2;
            this.f2360b = new b[]{bVar};
        }

        private c(int i2, b bVar, b bVar2) {
            this.f2359a = i2;
            this.f2360b = new b[]{bVar, bVar2};
        }
    }

    public static e a(int i2, int i3) throws h {
        if ((i2 & 1) != 0 || (i3 & 1) != 0) {
            throw h.getFormatInstance();
        }
        for (e eVar : f2349h) {
            if (eVar.f2351b == i2 && eVar.f2352c == i3) {
                return eVar;
            }
        }
        throw h.getFormatInstance();
    }
}
