package g.a.y0.e.d;

import g.a.y0.e.d.s2;

/* compiled from: ObservableJust.java */
/* loaded from: classes2.dex */
public final class q1<T> extends g.a.b0<T> implements g.a.y0.c.m<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f15416a;

    public q1(T t) {
        this.f15416a = t;
    }

    @Override // g.a.y0.c.m, java.util.concurrent.Callable
    public T call() {
        return this.f15416a;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        s2.a aVar = new s2.a(i0Var, this.f15416a);
        i0Var.onSubscribe(aVar);
        aVar.run();
    }
}
