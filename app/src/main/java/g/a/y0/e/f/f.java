package g.a.y0.e.f;

import java.util.concurrent.TimeUnit;

/* compiled from: SingleDelay.java */
/* loaded from: classes2.dex */
public final class f<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15756a;

    /* renamed from: b, reason: collision with root package name */
    final long f15757b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f15758c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f15759d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f15760e;

    /* compiled from: SingleDelay.java */
    final class a implements g.a.n0<T> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.y0.a.k f15761a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.n0<? super T> f15762b;

        /* compiled from: SingleDelay.java */
        /* renamed from: g.a.y0.e.f.f$a$a, reason: collision with other inner class name */
        final class RunnableC0226a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final Throwable f15764a;

            RunnableC0226a(Throwable th) {
                this.f15764a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f15762b.onError(this.f15764a);
            }
        }

        /* compiled from: SingleDelay.java */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final T f15766a;

            b(T t) {
                this.f15766a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f15762b.onSuccess(this.f15766a);
            }
        }

        a(g.a.y0.a.k kVar, g.a.n0<? super T> n0Var) {
            this.f15761a = kVar;
            this.f15762b = n0Var;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            g.a.y0.a.k kVar = this.f15761a;
            g.a.j0 j0Var = f.this.f15759d;
            RunnableC0226a runnableC0226a = new RunnableC0226a(th);
            f fVar = f.this;
            kVar.replace(j0Var.a(runnableC0226a, fVar.f15760e ? fVar.f15757b : 0L, f.this.f15758c));
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15761a.replace(cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            g.a.y0.a.k kVar = this.f15761a;
            g.a.j0 j0Var = f.this.f15759d;
            b bVar = new b(t);
            f fVar = f.this;
            kVar.replace(j0Var.a(bVar, fVar.f15757b, fVar.f15758c));
        }
    }

    public f(g.a.q0<? extends T> q0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var, boolean z) {
        this.f15756a = q0Var;
        this.f15757b = j2;
        this.f15758c = timeUnit;
        this.f15759d = j0Var;
        this.f15760e = z;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        g.a.y0.a.k kVar = new g.a.y0.a.k();
        n0Var.onSubscribe(kVar);
        this.f15756a.a(new a(kVar, n0Var));
    }
}
