package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeEqualSingle.java */
/* loaded from: classes2.dex */
public final class u<T> extends g.a.k0<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<? extends T> f14901a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.y<? extends T> f14902b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.d<? super T, ? super T> f14903c;

    /* compiled from: MaybeEqualSingle.java */
    static final class a<T> extends AtomicInteger implements g.a.u0.c {
        final g.a.n0<? super Boolean> actual;
        final g.a.x0.d<? super T, ? super T> isEqual;
        final b<T> observer1;
        final b<T> observer2;

        a(g.a.n0<? super Boolean> n0Var, g.a.x0.d<? super T, ? super T> dVar) {
            super(2);
            this.actual = n0Var;
            this.isEqual = dVar;
            this.observer1 = new b<>(this);
            this.observer2 = new b<>(this);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.observer1.dispose();
            this.observer2.dispose();
        }

        void done() {
            if (decrementAndGet() == 0) {
                Object obj = this.observer1.value;
                Object obj2 = this.observer2.value;
                if (obj == null || obj2 == null) {
                    this.actual.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
                    return;
                }
                try {
                    this.actual.onSuccess(Boolean.valueOf(this.isEqual.a(obj, obj2)));
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.actual.onError(th);
                }
            }
        }

        void error(b<T> bVar, Throwable th) {
            if (getAndSet(0) <= 0) {
                g.a.c1.a.b(th);
                return;
            }
            b<T> bVar2 = this.observer1;
            if (bVar == bVar2) {
                this.observer2.dispose();
            } else {
                bVar2.dispose();
            }
            this.actual.onError(th);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(this.observer1.get());
        }

        void subscribe(g.a.y<? extends T> yVar, g.a.y<? extends T> yVar2) {
            yVar.a(this.observer1);
            yVar2.a(this.observer2);
        }
    }

    /* compiled from: MaybeEqualSingle.java */
    static final class b<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        final a<T> parent;
        Object value;

        b(a<T> aVar) {
            this.parent = aVar;
        }

        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.v
        public void onComplete() {
            this.parent.done();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.value = t;
            this.parent.done();
        }
    }

    public u(g.a.y<? extends T> yVar, g.a.y<? extends T> yVar2, g.a.x0.d<? super T, ? super T> dVar) {
        this.f14901a = yVar;
        this.f14902b = yVar2;
        this.f14903c = dVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Boolean> n0Var) {
        a aVar = new a(n0Var, this.f14903c);
        n0Var.onSubscribe(aVar);
        aVar.subscribe(this.f14901a, this.f14902b);
    }
}
