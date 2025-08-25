package g.a.y0.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToListSingle.java */
/* loaded from: classes2.dex */
public final class v3<T, U extends Collection<? super T>> extends g.a.k0<U> implements g.a.y0.c.d<U> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15542a;

    /* renamed from: b, reason: collision with root package name */
    final Callable<U> f15543b;

    /* compiled from: ObservableToListSingle.java */
    static final class a<T, U extends Collection<? super T>> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super U> f15544a;

        /* renamed from: b, reason: collision with root package name */
        U f15545b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15546c;

        a(g.a.n0<? super U> n0Var, U u) {
            this.f15544a = n0Var;
            this.f15545b = u;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15546c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15546c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            U u = this.f15545b;
            this.f15545b = null;
            this.f15544a.onSuccess(u);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15545b = null;
            this.f15544a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15545b.add(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15546c, cVar)) {
                this.f15546c = cVar;
                this.f15544a.onSubscribe(this);
            }
        }
    }

    public v3(g.a.g0<T> g0Var, int i2) {
        this.f15542a = g0Var;
        this.f15543b = g.a.y0.b.a.a(i2);
    }

    @Override // g.a.y0.c.d
    public g.a.b0<U> a() {
        return g.a.c1.a.a(new u3(this.f15542a, this.f15543b));
    }

    @Override // g.a.k0
    public void b(g.a.n0<? super U> n0Var) {
        try {
            this.f15542a.subscribe(new a(n0Var, (Collection) g.a.y0.b.b.a(this.f15543b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, n0Var);
        }
    }

    public v3(g.a.g0<T> g0Var, Callable<U> callable) {
        this.f15542a = g0Var;
        this.f15543b = callable;
    }
}
