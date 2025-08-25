package g.a.y0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableFromCallable.java */
/* loaded from: classes2.dex */
public final class e1<T> extends g.a.l<T> implements Callable<T> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends T> f14196b;

    public e1(Callable<? extends T> callable) {
        this.f14196b = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) g.a.y0.b.b.a((Object) this.f14196b.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        g.a.y0.i.f fVar = new g.a.y0.i.f(cVar);
        cVar.onSubscribe(fVar);
        try {
            fVar.complete(g.a.y0.b.b.a((Object) this.f14196b.call(), "The callable returned a null value"));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            cVar.onError(th);
        }
    }
}
