package g.a.y0.e.d;

import java.util.NoSuchElementException;

/* compiled from: ObservableLastSingle.java */
/* loaded from: classes2.dex */
public final class s1<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15459a;

    /* renamed from: b, reason: collision with root package name */
    final T f15460b;

    /* compiled from: ObservableLastSingle.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f15461a;

        /* renamed from: b, reason: collision with root package name */
        final T f15462b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15463c;

        /* renamed from: d, reason: collision with root package name */
        T f15464d;

        a(g.a.n0<? super T> n0Var, T t) {
            this.f15461a = n0Var;
            this.f15462b = t;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15463c.dispose();
            this.f15463c = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15463c == g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15463c = g.a.y0.a.d.DISPOSED;
            T t = this.f15464d;
            if (t != null) {
                this.f15464d = null;
                this.f15461a.onSuccess(t);
                return;
            }
            T t2 = this.f15462b;
            if (t2 != null) {
                this.f15461a.onSuccess(t2);
            } else {
                this.f15461a.onError(new NoSuchElementException());
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15463c = g.a.y0.a.d.DISPOSED;
            this.f15464d = null;
            this.f15461a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15464d = t;
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15463c, cVar)) {
                this.f15463c = cVar;
                this.f15461a.onSubscribe(this);
            }
        }
    }

    public s1(g.a.g0<T> g0Var, T t) {
        this.f15459a = g0Var;
        this.f15460b = t;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15459a.subscribe(new a(n0Var, this.f15460b));
    }
}
