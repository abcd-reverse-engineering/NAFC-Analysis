package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeSubscribeOn.java */
/* loaded from: classes2.dex */
public final class c1<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f14777b;

    /* compiled from: MaybeSubscribeOn.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = 8571289934935992137L;
        final g.a.v<? super T> actual;
        final g.a.y0.a.k task = new g.a.y0.a.k();

        a(g.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
            this.task.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    /* compiled from: MaybeSubscribeOn.java */
    static final class b<T> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14778a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.y<T> f14779b;

        b(g.a.v<? super T> vVar, g.a.y<T> yVar) {
            this.f14778a = vVar;
            this.f14779b = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14779b.a(this.f14778a);
        }
    }

    public c1(g.a.y<T> yVar, g.a.j0 j0Var) {
        super(yVar);
        this.f14777b = j0Var;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        aVar.task.replace(this.f14777b.a(new b(aVar, this.f14742a)));
    }
}
