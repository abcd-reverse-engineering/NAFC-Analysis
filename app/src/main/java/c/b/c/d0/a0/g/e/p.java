package c.b.c.d0.a0.g.e;

/* compiled from: DecodedNumeric.java */
/* loaded from: classes.dex */
final class p extends q {

    /* renamed from: d, reason: collision with root package name */
    static final int f2514d = 10;

    /* renamed from: b, reason: collision with root package name */
    private final int f2515b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2516c;

    p(int i2, int i3, int i4) throws c.b.c.h {
        super(i2);
        if (i3 < 0 || i3 > 10 || i4 < 0 || i4 > 10) {
            throw c.b.c.h.getFormatInstance();
        }
        this.f2515b = i3;
        this.f2516c = i4;
    }

    int b() {
        return this.f2515b;
    }

    int c() {
        return this.f2516c;
    }

    int d() {
        return (this.f2515b * 10) + this.f2516c;
    }

    boolean e() {
        return this.f2515b == 10 || this.f2516c == 10;
    }

    boolean f() {
        return this.f2515b == 10;
    }

    boolean g() {
        return this.f2516c == 10;
    }
}
