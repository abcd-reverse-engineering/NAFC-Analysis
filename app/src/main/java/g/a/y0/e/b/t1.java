package g.a.y0.e.b;

/* compiled from: FlowableJust.java */
/* loaded from: classes2.dex */
public final class t1<T> extends g.a.l<T> implements g.a.y0.c.m<T> {

    /* renamed from: b, reason: collision with root package name */
    private final T f14622b;

    public t1(T t) {
        this.f14622b = t;
    }

    @Override // g.a.y0.c.m, java.util.concurrent.Callable
    public T call() {
        return this.f14622b;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        cVar.onSubscribe(new g.a.y0.i.h(cVar, this.f14622b));
    }
}
