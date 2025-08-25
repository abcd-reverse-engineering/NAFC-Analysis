package g.a.y0.e.c;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeTimeoutMaybe.java */
/* loaded from: classes2.dex */
public final class h1<T, U> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.y<U> f14814b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.y<? extends T> f14815c;

    /* compiled from: MaybeTimeoutMaybe.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T> {
        private static final long serialVersionUID = 8663801314800248617L;
        final g.a.v<? super T> actual;

        a(g.a.v<? super T> vVar) {
            this.actual = vVar;
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

    /* compiled from: MaybeTimeoutMaybe.java */
    static final class b<T, U> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = -5955289211445418871L;
        final g.a.v<? super T> actual;
        final g.a.y<? extends T> fallback;
        final c<T, U> other = new c<>(this);
        final a<T> otherObserver;

        b(g.a.v<? super T> vVar, g.a.y<? extends T> yVar) {
            this.actual = vVar;
            this.fallback = yVar;
            this.otherObserver = yVar != null ? new a<>(vVar) : null;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
            g.a.y0.a.d.dispose(this.other);
            a<T> aVar = this.otherObserver;
            if (aVar != null) {
                g.a.y0.a.d.dispose(aVar);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.v
        public void onComplete() {
            g.a.y0.a.d.dispose(this.other);
            if (getAndSet(g.a.y0.a.d.DISPOSED) != g.a.y0.a.d.DISPOSED) {
                this.actual.onComplete();
            }
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            g.a.y0.a.d.dispose(this.other);
            if (getAndSet(g.a.y0.a.d.DISPOSED) != g.a.y0.a.d.DISPOSED) {
                this.actual.onError(th);
            } else {
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            g.a.y0.a.d.dispose(this.other);
            if (getAndSet(g.a.y0.a.d.DISPOSED) != g.a.y0.a.d.DISPOSED) {
                this.actual.onSuccess(t);
            }
        }

        public void otherComplete() {
            if (g.a.y0.a.d.dispose(this)) {
                g.a.y<? extends T> yVar = this.fallback;
                if (yVar == null) {
                    this.actual.onError(new TimeoutException());
                } else {
                    yVar.a(this.otherObserver);
                }
            }
        }

        public void otherError(Throwable th) {
            if (g.a.y0.a.d.dispose(this)) {
                this.actual.onError(th);
            } else {
                g.a.c1.a.b(th);
            }
        }
    }

    /* compiled from: MaybeTimeoutMaybe.java */
    static final class c<T, U> extends AtomicReference<g.a.u0.c> implements g.a.v<Object> {
        private static final long serialVersionUID = 8663801314800248617L;
        final b<T, U> parent;

        c(b<T, U> bVar) {
            this.parent = bVar;
        }

        @Override // g.a.v
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(Object obj) {
            this.parent.otherComplete();
        }
    }

    public h1(g.a.y<T> yVar, g.a.y<U> yVar2, g.a.y<? extends T> yVar3) {
        super(yVar);
        this.f14814b = yVar2;
        this.f14815c = yVar3;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        b bVar = new b(vVar, this.f14815c);
        vVar.onSubscribe(bVar);
        this.f14814b.a(bVar.other);
        this.f14742a.a(bVar);
    }
}
