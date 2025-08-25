package g.a.y0.e.d;

import java.util.NoSuchElementException;

/* compiled from: ObservableSingleSingle.java */
/* loaded from: classes2.dex */
public final class z2<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<? extends T> f15613a;

    /* renamed from: b, reason: collision with root package name */
    final T f15614b;

    /* compiled from: ObservableSingleSingle.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f15615a;

        /* renamed from: b, reason: collision with root package name */
        final T f15616b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15617c;

        /* renamed from: d, reason: collision with root package name */
        T f15618d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15619e;

        a(g.a.n0<? super T> n0Var, T t) {
            this.f15615a = n0Var;
            this.f15616b = t;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15617c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15617c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15619e) {
                return;
            }
            this.f15619e = true;
            T t = this.f15618d;
            this.f15618d = null;
            if (t == null) {
                t = this.f15616b;
            }
            if (t != null) {
                this.f15615a.onSuccess(t);
            } else {
                this.f15615a.onError(new NoSuchElementException());
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15619e) {
                g.a.c1.a.b(th);
            } else {
                this.f15619e = true;
                this.f15615a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15619e) {
                return;
            }
            if (this.f15618d == null) {
                this.f15618d = t;
                return;
            }
            this.f15619e = true;
            this.f15617c.dispose();
            this.f15615a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15617c, cVar)) {
                this.f15617c = cVar;
                this.f15615a.onSubscribe(this);
            }
        }
    }

    public z2(g.a.g0<? extends T> g0Var, T t) {
        this.f15613a = g0Var;
        this.f15614b = t;
    }

    @Override // g.a.k0
    public void b(g.a.n0<? super T> n0Var) {
        this.f15613a.subscribe(new a(n0Var, this.f15614b));
    }
}
