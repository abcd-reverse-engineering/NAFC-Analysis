package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: MaybeDoFinally.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class r<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.a f14883b;

    /* compiled from: MaybeDoFinally.java */
    static final class a<T> extends AtomicInteger implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = 4109457741734051389L;
        final g.a.v<? super T> actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f14884d;
        final g.a.x0.a onFinally;

        a(g.a.v<? super T> vVar, g.a.x0.a aVar) {
            this.actual = vVar;
            this.onFinally = aVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14884d.dispose();
            runFinally();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14884d.isDisposed();
        }

        @Override // g.a.v
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14884d, cVar)) {
                this.f14884d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            runFinally();
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            }
        }
    }

    public r(g.a.y<T> yVar, g.a.x0.a aVar) {
        super(yVar);
        this.f14883b = aVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14883b));
    }
}
