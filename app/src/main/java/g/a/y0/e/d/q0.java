package g.a.y0.e.d;

import java.util.NoSuchElementException;

/* compiled from: ObservableElementAtSingle.java */
/* loaded from: classes2.dex */
public final class q0<T> extends g.a.k0<T> implements g.a.y0.c.d<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15407a;

    /* renamed from: b, reason: collision with root package name */
    final long f15408b;

    /* renamed from: c, reason: collision with root package name */
    final T f15409c;

    /* compiled from: ObservableElementAtSingle.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f15410a;

        /* renamed from: b, reason: collision with root package name */
        final long f15411b;

        /* renamed from: c, reason: collision with root package name */
        final T f15412c;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15413d;

        /* renamed from: e, reason: collision with root package name */
        long f15414e;

        /* renamed from: f, reason: collision with root package name */
        boolean f15415f;

        a(g.a.n0<? super T> n0Var, long j2, T t) {
            this.f15410a = n0Var;
            this.f15411b = j2;
            this.f15412c = t;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15413d.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15413d.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15415f) {
                return;
            }
            this.f15415f = true;
            T t = this.f15412c;
            if (t != null) {
                this.f15410a.onSuccess(t);
            } else {
                this.f15410a.onError(new NoSuchElementException());
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15415f) {
                g.a.c1.a.b(th);
            } else {
                this.f15415f = true;
                this.f15410a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15415f) {
                return;
            }
            long j2 = this.f15414e;
            if (j2 != this.f15411b) {
                this.f15414e = j2 + 1;
                return;
            }
            this.f15415f = true;
            this.f15413d.dispose();
            this.f15410a.onSuccess(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15413d, cVar)) {
                this.f15413d = cVar;
                this.f15410a.onSubscribe(this);
            }
        }
    }

    public q0(g.a.g0<T> g0Var, long j2, T t) {
        this.f15407a = g0Var;
        this.f15408b = j2;
        this.f15409c = t;
    }

    @Override // g.a.y0.c.d
    public g.a.b0<T> a() {
        return g.a.c1.a.a(new o0(this.f15407a, this.f15408b, this.f15409c, true));
    }

    @Override // g.a.k0
    public void b(g.a.n0<? super T> n0Var) {
        this.f15407a.subscribe(new a(n0Var, this.f15408b, this.f15409c));
    }
}
