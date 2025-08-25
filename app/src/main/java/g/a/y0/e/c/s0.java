package g.a.y0.e.c;

/* compiled from: MaybeJust.java */
/* loaded from: classes2.dex */
public final class s0<T> extends g.a.s<T> implements g.a.y0.c.m<T> {

    /* renamed from: a, reason: collision with root package name */
    final T f14895a;

    public s0(T t) {
        this.f14895a = t;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        vVar.onSubscribe(g.a.u0.d.a());
        vVar.onSuccess(this.f14895a);
    }

    @Override // g.a.y0.c.m, java.util.concurrent.Callable
    public T call() {
        return this.f14895a;
    }
}
