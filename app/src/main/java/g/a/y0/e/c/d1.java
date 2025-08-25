package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeSwitchIfEmpty.java */
/* loaded from: classes2.dex */
public final class d1<T> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.y<? extends T> f14785b;

    /* compiled from: MaybeSwitchIfEmpty.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = -2223459372976438024L;
        final g.a.v<? super T> actual;
        final g.a.y<? extends T> other;

        /* compiled from: MaybeSwitchIfEmpty.java */
        /* renamed from: g.a.y0.e.c.d1$a$a, reason: collision with other inner class name */
        static final class C0201a<T> implements g.a.v<T> {

            /* renamed from: a, reason: collision with root package name */
            final g.a.v<? super T> f14786a;

            /* renamed from: b, reason: collision with root package name */
            final AtomicReference<g.a.u0.c> f14787b;

            C0201a(g.a.v<? super T> vVar, AtomicReference<g.a.u0.c> atomicReference) {
                this.f14786a = vVar;
                this.f14787b = atomicReference;
            }

            @Override // g.a.v
            public void onComplete() {
                this.f14786a.onComplete();
            }

            @Override // g.a.v
            public void onError(Throwable th) {
                this.f14786a.onError(th);
            }

            @Override // g.a.v
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this.f14787b, cVar);
            }

            @Override // g.a.v, g.a.n0
            public void onSuccess(T t) {
                this.f14786a.onSuccess(t);
            }
        }

        a(g.a.v<? super T> vVar, g.a.y<? extends T> yVar) {
            this.actual = vVar;
            this.other = yVar;
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
            g.a.u0.c cVar = get();
            if (cVar == g.a.y0.a.d.DISPOSED || !compareAndSet(cVar, null)) {
                return;
            }
            this.other.a(new C0201a(this.actual, this));
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
    }

    public d1(g.a.y<T> yVar, g.a.y<? extends T> yVar2) {
        super(yVar);
        this.f14785b = yVar2;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14785b));
    }
}
