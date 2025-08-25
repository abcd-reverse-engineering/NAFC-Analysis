package c.b.c.d0.a0.g.e;

/* compiled from: CurrentParsingState.java */
/* loaded from: classes.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private int f2506a = 0;

    /* renamed from: b, reason: collision with root package name */
    private a f2507b = a.NUMERIC;

    /* compiled from: CurrentParsingState.java */
    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    m() {
    }

    int a() {
        return this.f2506a;
    }

    void b(int i2) {
        this.f2506a = i2;
    }

    boolean c() {
        return this.f2507b == a.ISO_IEC_646;
    }

    boolean d() {
        return this.f2507b == a.NUMERIC;
    }

    void e() {
        this.f2507b = a.ALPHA;
    }

    void f() {
        this.f2507b = a.ISO_IEC_646;
    }

    void g() {
        this.f2507b = a.NUMERIC;
    }

    void a(int i2) {
        this.f2506a += i2;
    }

    boolean b() {
        return this.f2507b == a.ALPHA;
    }
}
