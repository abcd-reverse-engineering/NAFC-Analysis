package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWithLatestFrom.java */
/* loaded from: classes2.dex */
public final class d4<T, U, R> extends g.a.y0.e.d.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.c<? super T, ? super U, ? extends R> f15055b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.g0<? extends U> f15056c;

    /* compiled from: ObservableWithLatestFrom.java */
    final class a implements g.a.i0<U> {

        /* renamed from: a, reason: collision with root package name */
        private final b<T, U, R> f15057a;

        a(b<T, U, R> bVar) {
            this.f15057a = bVar;
        }

        @Override // g.a.i0
        public void onComplete() {
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15057a.otherError(th);
        }

        @Override // g.a.i0
        public void onNext(U u) {
            this.f15057a.lazySet(u);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15057a.setOther(cVar);
        }
    }

    /* compiled from: ObservableWithLatestFrom.java */
    static final class b<T, U, R> extends AtomicReference<U> implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = -312246233408980075L;
        final g.a.i0<? super R> actual;
        final g.a.x0.c<? super T, ? super U, ? extends R> combiner;
        final AtomicReference<g.a.u0.c> s = new AtomicReference<>();
        final AtomicReference<g.a.u0.c> other = new AtomicReference<>();

        b(g.a.i0<? super R> i0Var, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
            this.actual = i0Var;
            this.combiner = cVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this.s);
            g.a.y0.a.d.dispose(this.other);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(this.s.get());
        }

        @Override // g.a.i0
        public void onComplete() {
            g.a.y0.a.d.dispose(this.other);
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.y0.a.d.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.actual.onNext(g.a.y0.b.b.a(this.combiner.apply(t, u), "The combiner returned a null value"));
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    dispose();
                    this.actual.onError(th);
                }
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this.s, cVar);
        }

        public void otherError(Throwable th) {
            g.a.y0.a.d.dispose(this.s);
            this.actual.onError(th);
        }

        public boolean setOther(g.a.u0.c cVar) {
            return g.a.y0.a.d.setOnce(this.other, cVar);
        }
    }

    public d4(g.a.g0<T> g0Var, g.a.x0.c<? super T, ? super U, ? extends R> cVar, g.a.g0<? extends U> g0Var2) {
        super(g0Var);
        this.f15055b = cVar;
        this.f15056c = g0Var2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super R> i0Var) {
        g.a.a1.m mVar = new g.a.a1.m(i0Var);
        b bVar = new b(mVar, this.f15055b);
        mVar.onSubscribe(bVar);
        this.f15056c.subscribe(new a(bVar));
        this.f14934a.subscribe(bVar);
    }
}
