package c.b.c;

/* compiled from: BinaryBitmap.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final b f2432a;

    /* renamed from: b, reason: collision with root package name */
    private c.b.c.z.b f2433b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f2432a = bVar;
    }

    public c.b.c.z.a a(int i2, c.b.c.z.a aVar) throws m {
        return this.f2432a.a(i2, aVar);
    }

    public int b() {
        return this.f2432a.b();
    }

    public int c() {
        return this.f2432a.d();
    }

    public boolean d() {
        return this.f2432a.c().e();
    }

    public boolean e() {
        return this.f2432a.c().f();
    }

    public c f() {
        return new c(this.f2432a.a(this.f2432a.c().g()));
    }

    public c g() {
        return new c(this.f2432a.a(this.f2432a.c().h()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (m unused) {
            return "";
        }
    }

    public c.b.c.z.b a() throws m {
        if (this.f2433b == null) {
            this.f2433b = this.f2432a.a();
        }
        return this.f2433b;
    }

    public c a(int i2, int i3, int i4, int i5) {
        return new c(this.f2432a.a(this.f2432a.c().a(i2, i3, i4, i5)));
    }
}
