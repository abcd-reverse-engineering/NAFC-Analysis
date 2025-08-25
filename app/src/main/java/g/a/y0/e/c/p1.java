package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeUnsubscribeOn.java */
/* loaded from: classes2.dex */
public final class p1<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f14871b;

    /* compiled from: MaybeUnsubscribeOn.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final g.a.v<? super T> actual;
        g.a.u0.c ds;
        final g.a.j0 scheduler;

        a(g.a.v<? super T> vVar, g.a.j0 j0Var) {
            this.actual = vVar;
            this.scheduler = j0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.u0.c andSet = getAndSet(g.a.y0.a.d.DISPOSED);
            if (andSet != g.a.y0.a.d.DISPOSED) {
                this.ds = andSet;
                this.scheduler.a(this);
            }
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
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
        }
    }

    public p1(g.a.y<T> yVar, g.a.j0 j0Var) {
        super(yVar);
        this.f14871b = j0Var;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14871b));
    }
}
