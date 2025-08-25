package g.a.y0.e.d;

import java.util.NoSuchElementException;

/* compiled from: ObservableElementAt.java */
/* loaded from: classes2.dex */
public final class o0<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f15354b;

    /* renamed from: c, reason: collision with root package name */
    final T f15355c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f15356d;

    /* compiled from: ObservableElementAt.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15357a;

        /* renamed from: b, reason: collision with root package name */
        final long f15358b;

        /* renamed from: c, reason: collision with root package name */
        final T f15359c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f15360d;

        /* renamed from: e, reason: collision with root package name */
        g.a.u0.c f15361e;

        /* renamed from: f, reason: collision with root package name */
        long f15362f;

        /* renamed from: g, reason: collision with root package name */
        boolean f15363g;

        a(g.a.i0<? super T> i0Var, long j2, T t, boolean z) {
            this.f15357a = i0Var;
            this.f15358b = j2;
            this.f15359c = t;
            this.f15360d = z;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15361e.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15361e.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15363g) {
                return;
            }
            this.f15363g = true;
            T t = this.f15359c;
            if (t == null && this.f15360d) {
                this.f15357a.onError(new NoSuchElementException());
                return;
            }
            if (t != null) {
                this.f15357a.onNext(t);
            }
            this.f15357a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15363g) {
                g.a.c1.a.b(th);
            } else {
                this.f15363g = true;
                this.f15357a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15363g) {
                return;
            }
            long j2 = this.f15362f;
            if (j2 != this.f15358b) {
                this.f15362f = j2 + 1;
                return;
            }
            this.f15363g = true;
            this.f15361e.dispose();
            this.f15357a.onNext(t);
            this.f15357a.onComplete();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15361e, cVar)) {
                this.f15361e = cVar;
                this.f15357a.onSubscribe(this);
            }
        }
    }

    public o0(g.a.g0<T> g0Var, long j2, T t, boolean z) {
        super(g0Var);
        this.f15354b = j2;
        this.f15355c = t;
        this.f15356d = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15354b, this.f15355c, this.f15356d));
    }
}
