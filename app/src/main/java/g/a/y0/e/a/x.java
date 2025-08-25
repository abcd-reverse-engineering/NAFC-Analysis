package g.a.y0.e.a;

/* compiled from: CompletableLift.java */
/* loaded from: classes2.dex */
public final class x extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14104a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.h f14105b;

    public x(g.a.i iVar, g.a.h hVar) {
        this.f14104a = iVar;
        this.f14105b = hVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        try {
            this.f14104a.a(this.f14105b.a(fVar));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
    }
}
