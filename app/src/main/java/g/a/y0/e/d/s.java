package g.a.y0.e.d;

import java.util.concurrent.Callable;

/* compiled from: ObservableCollect.java */
/* loaded from: classes2.dex */
public final class s<T, U> extends g.a.y0.e.d.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends U> f15451b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.b<? super U, ? super T> f15452c;

    /* compiled from: ObservableCollect.java */
    static final class a<T, U> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super U> f15453a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.b<? super U, ? super T> f15454b;

        /* renamed from: c, reason: collision with root package name */
        final U f15455c;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15456d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15457e;

        a(g.a.i0<? super U> i0Var, U u, g.a.x0.b<? super U, ? super T> bVar) {
            this.f15453a = i0Var;
            this.f15454b = bVar;
            this.f15455c = u;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15456d.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15456d.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15457e) {
                return;
            }
            this.f15457e = true;
            this.f15453a.onNext(this.f15455c);
            this.f15453a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15457e) {
                g.a.c1.a.b(th);
            } else {
                this.f15457e = true;
                this.f15453a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15457e) {
                return;
            }
            try {
                this.f15454b.a(this.f15455c, t);
            } catch (Throwable th) {
                this.f15456d.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15456d, cVar)) {
                this.f15456d = cVar;
                this.f15453a.onSubscribe(this);
            }
        }
    }

    public s(g.a.g0<T> g0Var, Callable<? extends U> callable, g.a.x0.b<? super U, ? super T> bVar) {
        super(g0Var);
        this.f15451b = callable;
        this.f15452c = bVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super U> i0Var) {
        try {
            this.f14934a.subscribe(new a(i0Var, g.a.y0.b.b.a(this.f15451b.call(), "The initialSupplier returned a null value"), this.f15452c));
        } catch (Throwable th) {
            g.a.y0.a.e.error(th, i0Var);
        }
    }
}
