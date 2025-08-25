package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableDebounce.java */
/* loaded from: classes2.dex */
public final class b0<T, U> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.g0<U>> f14961b;

    /* compiled from: ObservableDebounce.java */
    static final class a<T, U> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f14962a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends g.a.g0<U>> f14963b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14964c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f14965d = new AtomicReference<>();

        /* renamed from: e, reason: collision with root package name */
        volatile long f14966e;

        /* renamed from: f, reason: collision with root package name */
        boolean f14967f;

        /* compiled from: ObservableDebounce.java */
        /* renamed from: g.a.y0.e.d.b0$a$a, reason: collision with other inner class name */
        static final class C0208a<T, U> extends g.a.a1.e<U> {

            /* renamed from: b, reason: collision with root package name */
            final a<T, U> f14968b;

            /* renamed from: c, reason: collision with root package name */
            final long f14969c;

            /* renamed from: d, reason: collision with root package name */
            final T f14970d;

            /* renamed from: e, reason: collision with root package name */
            boolean f14971e;

            /* renamed from: f, reason: collision with root package name */
            final AtomicBoolean f14972f = new AtomicBoolean();

            C0208a(a<T, U> aVar, long j2, T t) {
                this.f14968b = aVar;
                this.f14969c = j2;
                this.f14970d = t;
            }

            void b() {
                if (this.f14972f.compareAndSet(false, true)) {
                    this.f14968b.a(this.f14969c, this.f14970d);
                }
            }

            @Override // g.a.i0
            public void onComplete() {
                if (this.f14971e) {
                    return;
                }
                this.f14971e = true;
                b();
            }

            @Override // g.a.i0
            public void onError(Throwable th) {
                if (this.f14971e) {
                    g.a.c1.a.b(th);
                } else {
                    this.f14971e = true;
                    this.f14968b.onError(th);
                }
            }

            @Override // g.a.i0
            public void onNext(U u) {
                if (this.f14971e) {
                    return;
                }
                this.f14971e = true;
                dispose();
                b();
            }
        }

        a(g.a.i0<? super T> i0Var, g.a.x0.o<? super T, ? extends g.a.g0<U>> oVar) {
            this.f14962a = i0Var;
            this.f14963b = oVar;
        }

        void a(long j2, T t) {
            if (j2 == this.f14966e) {
                this.f14962a.onNext(t);
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14964c.dispose();
            g.a.y0.a.d.dispose(this.f14965d);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14964c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f14967f) {
                return;
            }
            this.f14967f = true;
            g.a.u0.c cVar = this.f14965d.get();
            if (cVar != g.a.y0.a.d.DISPOSED) {
                ((C0208a) cVar).b();
                g.a.y0.a.d.dispose(this.f14965d);
                this.f14962a.onComplete();
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.y0.a.d.dispose(this.f14965d);
            this.f14962a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f14967f) {
                return;
            }
            long j2 = this.f14966e + 1;
            this.f14966e = j2;
            g.a.u0.c cVar = this.f14965d.get();
            if (cVar != null) {
                cVar.dispose();
            }
            try {
                g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.f14963b.apply(t), "The ObservableSource supplied is null");
                C0208a c0208a = new C0208a(this, j2, t);
                if (this.f14965d.compareAndSet(cVar, c0208a)) {
                    g0Var.subscribe(c0208a);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                dispose();
                this.f14962a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14964c, cVar)) {
                this.f14964c = cVar;
                this.f14962a.onSubscribe(this);
            }
        }
    }

    public b0(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.g0<U>> oVar) {
        super(g0Var);
        this.f14961b = oVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(new g.a.a1.m(i0Var), this.f14961b));
    }
}
