package g.a.y0.e.f;

/* compiled from: SingleJust.java */
/* loaded from: classes2.dex */
public final class f0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final T f15768a;

    public f0(T t) {
        this.f15768a = t;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        n0Var.onSubscribe(g.a.u0.d.a());
        n0Var.onSuccess(this.f15768a);
    }
}
