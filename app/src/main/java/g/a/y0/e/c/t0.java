package g.a.y0.e.c;

/* compiled from: MaybeLift.java */
/* loaded from: classes2.dex */
public final class t0<T, R> extends a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x<? extends R, ? super T> f14900b;

    public t0(g.a.y<T> yVar, g.a.x<? extends R, ? super T> xVar) {
        super(yVar);
        this.f14900b = xVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super R> vVar) {
        try {
            this.f14742a.a((g.a.v) g.a.y0.b.b.a(this.f14900b.a(vVar), "The operator returned a null MaybeObserver"));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, vVar);
        }
    }
}
