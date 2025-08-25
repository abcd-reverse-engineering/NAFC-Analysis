package g.a.y0.e.d;

import java.util.concurrent.TimeUnit;

/* compiled from: ObservableTimeInterval.java */
/* loaded from: classes2.dex */
public final class q3<T> extends g.a.y0.e.d.a<T, g.a.e1.c<T>> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f15421b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f15422c;

    /* compiled from: ObservableTimeInterval.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super g.a.e1.c<T>> f15423a;

        /* renamed from: b, reason: collision with root package name */
        final TimeUnit f15424b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.j0 f15425c;

        /* renamed from: d, reason: collision with root package name */
        long f15426d;

        /* renamed from: e, reason: collision with root package name */
        g.a.u0.c f15427e;

        a(g.a.i0<? super g.a.e1.c<T>> i0Var, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.f15423a = i0Var;
            this.f15425c = j0Var;
            this.f15424b = timeUnit;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15427e.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15427e.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15423a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15423a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            long jA = this.f15425c.a(this.f15424b);
            long j2 = this.f15426d;
            this.f15426d = jA;
            this.f15423a.onNext(new g.a.e1.c(t, jA - j2, this.f15424b));
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15427e, cVar)) {
                this.f15427e = cVar;
                this.f15426d = this.f15425c.a(this.f15424b);
                this.f15423a.onSubscribe(this);
            }
        }
    }

    public q3(g.a.g0<T> g0Var, TimeUnit timeUnit, g.a.j0 j0Var) {
        super(g0Var);
        this.f15421b = j0Var;
        this.f15422c = timeUnit;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super g.a.e1.c<T>> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15422c, this.f15421b));
    }
}
