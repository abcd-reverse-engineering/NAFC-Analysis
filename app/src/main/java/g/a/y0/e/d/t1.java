package g.a.y0.e.d;

/* compiled from: ObservableLift.java */
/* loaded from: classes2.dex */
public final class t1<R, T> extends a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.f0<? extends R, ? super T> f15486b;

    public t1(g.a.g0<T> g0Var, g.a.f0<? extends R, ? super T> f0Var) {
        super(g0Var);
        this.f15486b = f0Var;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super R> i0Var) {
        try {
            this.f14934a.subscribe((g.a.i0) g.a.y0.b.b.a(this.f15486b.a(i0Var), "Operator " + this.f15486b + " returned a null Observer"));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
