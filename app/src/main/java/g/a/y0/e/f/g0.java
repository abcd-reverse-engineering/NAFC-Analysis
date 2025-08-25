package g.a.y0.e.f;

/* compiled from: SingleLift.java */
/* loaded from: classes2.dex */
public final class g0<T, R> extends g.a.k0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<T> f15771a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.p0<? extends R, ? super T> f15772b;

    public g0(g.a.q0<T> q0Var, g.a.p0<? extends R, ? super T> p0Var) {
        this.f15771a = q0Var;
        this.f15772b = p0Var;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super R> n0Var) {
        try {
            this.f15771a.a((g.a.n0) g.a.y0.b.b.a(this.f15772b.a(n0Var), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, n0Var);
        }
    }
}
