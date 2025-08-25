package g.a.y0.e.d;

import java.util.concurrent.Callable;

/* compiled from: ObservableGenerate.java */
/* loaded from: classes2.dex */
public final class g1<T, S> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<S> f15141a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.c<S, g.a.k<T>, S> f15142b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super S> f15143c;

    public g1(Callable<S> callable, g.a.x0.c<S, g.a.k<T>, S> cVar, g.a.x0.g<? super S> gVar) {
        this.f15141a = callable;
        this.f15142b = cVar;
        this.f15143c = gVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        try {
            a aVar = new a(i0Var, this.f15142b, this.f15143c, this.f15141a.call());
            i0Var.onSubscribe(aVar);
            aVar.a();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, i0Var);
        }
    }

    /* compiled from: ObservableGenerate.java */
    static final class a<T, S> implements g.a.k<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15144a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.c<S, ? super g.a.k<T>, S> f15145b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.g<? super S> f15146c;

        /* renamed from: d, reason: collision with root package name */
        S f15147d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f15148e;

        /* renamed from: f, reason: collision with root package name */
        boolean f15149f;

        /* renamed from: g, reason: collision with root package name */
        boolean f15150g;

        a(g.a.i0<? super T> i0Var, g.a.x0.c<S, ? super g.a.k<T>, S> cVar, g.a.x0.g<? super S> gVar, S s) {
            this.f15144a = i0Var;
            this.f15145b = cVar;
            this.f15146c = gVar;
            this.f15147d = s;
        }

        public void a() {
            S sApply = this.f15147d;
            if (this.f15148e) {
                this.f15147d = null;
                a(sApply);
                return;
            }
            g.a.x0.c<S, ? super g.a.k<T>, S> cVar = this.f15145b;
            while (!this.f15148e) {
                this.f15150g = false;
                try {
                    sApply = cVar.apply(sApply, this);
                    if (this.f15149f) {
                        this.f15148e = true;
                        this.f15147d = null;
                        a(sApply);
                        return;
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.f15147d = null;
                    this.f15148e = true;
                    onError(th);
                    a(sApply);
                    return;
                }
            }
            this.f15147d = null;
            a(sApply);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15148e = true;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15148e;
        }

        @Override // g.a.k
        public void onComplete() {
            if (this.f15149f) {
                return;
            }
            this.f15149f = true;
            this.f15144a.onComplete();
        }

        @Override // g.a.k
        public void onError(Throwable th) {
            if (this.f15149f) {
                g.a.c1.a.b(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f15149f = true;
            this.f15144a.onError(th);
        }

        @Override // g.a.k
        public void onNext(T t) {
            if (this.f15149f) {
                return;
            }
            if (this.f15150g) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f15150g = true;
                this.f15144a.onNext(t);
            }
        }

        private void a(S s) {
            try {
                this.f15146c.accept(s);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
        }
    }
}
