package g.a.y0.e.d;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableDebounceTimed.java */
/* loaded from: classes2.dex */
public final class c0<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f14993b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f14994c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f14995d;

    /* compiled from: ObservableDebounceTimed.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements Runnable, g.a.u0.c {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final b<T> parent;
        final T value;

        a(T t, long j2, b<T> bVar) {
            this.value = t;
            this.idx = j2;
            this.parent = bVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == g.a.y0.a.d.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }

        public void setResource(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this, cVar);
        }
    }

    /* compiled from: ObservableDebounceTimed.java */
    static final class b<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f14996a;

        /* renamed from: b, reason: collision with root package name */
        final long f14997b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f14998c;

        /* renamed from: d, reason: collision with root package name */
        final j0.c f14999d;

        /* renamed from: e, reason: collision with root package name */
        g.a.u0.c f15000e;

        /* renamed from: f, reason: collision with root package name */
        final AtomicReference<g.a.u0.c> f15001f = new AtomicReference<>();

        /* renamed from: g, reason: collision with root package name */
        volatile long f15002g;

        /* renamed from: h, reason: collision with root package name */
        boolean f15003h;

        b(g.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, j0.c cVar) {
            this.f14996a = i0Var;
            this.f14997b = j2;
            this.f14998c = timeUnit;
            this.f14999d = cVar;
        }

        void a(long j2, T t, a<T> aVar) {
            if (j2 == this.f15002g) {
                this.f14996a.onNext(t);
                aVar.dispose();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15000e.dispose();
            this.f14999d.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14999d.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15003h) {
                return;
            }
            this.f15003h = true;
            g.a.u0.c cVar = this.f15001f.get();
            if (cVar != g.a.y0.a.d.DISPOSED) {
                a aVar = (a) cVar;
                if (aVar != null) {
                    aVar.run();
                }
                this.f14996a.onComplete();
                this.f14999d.dispose();
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15003h) {
                g.a.c1.a.b(th);
                return;
            }
            this.f15003h = true;
            this.f14996a.onError(th);
            this.f14999d.dispose();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15003h) {
                return;
            }
            long j2 = this.f15002g + 1;
            this.f15002g = j2;
            g.a.u0.c cVar = this.f15001f.get();
            if (cVar != null) {
                cVar.dispose();
            }
            a aVar = new a(t, j2, this);
            if (this.f15001f.compareAndSet(cVar, aVar)) {
                aVar.setResource(this.f14999d.a(aVar, this.f14997b, this.f14998c));
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15000e, cVar)) {
                this.f15000e = cVar;
                this.f14996a.onSubscribe(this);
            }
        }
    }

    public c0(g.a.g0<T> g0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        super(g0Var);
        this.f14993b = j2;
        this.f14994c = timeUnit;
        this.f14995d = j0Var;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new b(new g.a.a1.m(i0Var), this.f14993b, this.f14994c, this.f14995d.a()));
    }
}
