package g.a.y0.e.a;

/* compiled from: CompletableError.java */
/* loaded from: classes2.dex */
public final class n extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final Throwable f14078a;

    public n(Throwable th) {
        this.f14078a = th;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        g.a.y0.a.e.error(this.f14078a, fVar);
    }
}
