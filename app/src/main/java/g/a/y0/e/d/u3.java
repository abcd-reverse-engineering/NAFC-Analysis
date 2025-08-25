package g.a.y0.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToList.java */
/* loaded from: classes2.dex */
public final class u3<T, U extends Collection<? super T>> extends g.a.y0.e.d.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<U> f15514b;

    /* compiled from: ObservableToList.java */
    static final class a<T, U extends Collection<? super T>> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        U f15515a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.i0<? super U> f15516b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15517c;

        a(g.a.i0<? super U> i0Var, U u) {
            this.f15516b = i0Var;
            this.f15515a = u;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15517c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15517c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            U u = this.f15515a;
            this.f15515a = null;
            this.f15516b.onNext(u);
            this.f15516b.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15515a = null;
            this.f15516b.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15515a.add(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15517c, cVar)) {
                this.f15517c = cVar;
                this.f15516b.onSubscribe(this);
            }
        }
    }

    public u3(g.a.g0<T> g0Var, int i2) {
        super(g0Var);
        this.f15514b = g.a.y0.b.a.a(i2);
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super U> i0Var) {
        try {
            this.f14934a.subscribe(new a(i0Var, (Collection) g.a.y0.b.b.a(this.f15514b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, i0Var);
        }
    }

    public u3(g.a.g0<T> g0Var, Callable<U> callable) {
        super(g0Var);
        this.f15514b = callable;
    }
}
