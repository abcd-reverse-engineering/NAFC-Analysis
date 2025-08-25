package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeObserveOn.java */
/* loaded from: classes2.dex */
public final class x0<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f14916b;

    /* compiled from: MaybeObserveOn.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final g.a.v<? super T> actual;
        Throwable error;
        final g.a.j0 scheduler;
        T value;

        a(g.a.v<? super T> vVar, g.a.j0 j0Var) {
            this.actual = vVar;
            this.scheduler = j0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.v
        public void onComplete() {
            g.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.error = th;
            g.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.value = t;
            g.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t == null) {
                this.actual.onComplete();
            } else {
                this.value = null;
                this.actual.onSuccess(t);
            }
        }
    }

    public x0(g.a.y<T> yVar, g.a.j0 j0Var) {
        super(yVar);
        this.f14916b = j0Var;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14916b));
    }
}
