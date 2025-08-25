package g.a.y0.e.d;

import java.util.concurrent.Callable;

/* compiled from: ObservableScanSeed.java */
/* loaded from: classes2.dex */
public final class u2<T, R> extends g.a.y0.e.d.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.c<R, ? super T, R> f15507b;

    /* renamed from: c, reason: collision with root package name */
    final Callable<R> f15508c;

    /* compiled from: ObservableScanSeed.java */
    static final class a<T, R> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super R> f15509a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.c<R, ? super T, R> f15510b;

        /* renamed from: c, reason: collision with root package name */
        R f15511c;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15512d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15513e;

        a(g.a.i0<? super R> i0Var, g.a.x0.c<R, ? super T, R> cVar, R r) {
            this.f15509a = i0Var;
            this.f15510b = cVar;
            this.f15511c = r;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15512d.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15512d.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15513e) {
                return;
            }
            this.f15513e = true;
            this.f15509a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15513e) {
                g.a.c1.a.b(th);
            } else {
                this.f15513e = true;
                this.f15509a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15513e) {
                return;
            }
            try {
                R r = (R) g.a.y0.b.b.a(this.f15510b.apply(this.f15511c, t), "The accumulator returned a null value");
                this.f15511c = r;
                this.f15509a.onNext(r);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15512d.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15512d, cVar)) {
                this.f15512d = cVar;
                this.f15509a.onSubscribe(this);
                this.f15509a.onNext(this.f15511c);
            }
        }
    }

    public u2(g.a.g0<T> g0Var, Callable<R> callable, g.a.x0.c<R, ? super T, R> cVar) {
        super(g0Var);
        this.f15507b = cVar;
        this.f15508c = callable;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super R> i0Var) {
        try {
            this.f14934a.subscribe(new a(i0Var, this.f15507b, g.a.y0.b.b.a(this.f15508c.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, i0Var);
        }
    }
}
