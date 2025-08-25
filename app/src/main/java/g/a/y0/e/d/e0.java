package g.a.y0.e.d;

import g.a.j0;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableDelay.java */
/* loaded from: classes2.dex */
public final class e0<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f15069b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f15070c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f15071d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f15072e;

    /* compiled from: ObservableDelay.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15073a;

        /* renamed from: b, reason: collision with root package name */
        final long f15074b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f15075c;

        /* renamed from: d, reason: collision with root package name */
        final j0.c f15076d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f15077e;

        /* renamed from: f, reason: collision with root package name */
        g.a.u0.c f15078f;

        /* compiled from: ObservableDelay.java */
        /* renamed from: g.a.y0.e.d.e0$a$a, reason: collision with other inner class name */
        final class RunnableC0211a implements Runnable {
            RunnableC0211a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f15073a.onComplete();
                } finally {
                    a.this.f15076d.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final Throwable f15080a;

            b(Throwable th) {
                this.f15080a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f15073a.onError(this.f15080a);
                } finally {
                    a.this.f15076d.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        final class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final T f15082a;

            c(T t) {
                this.f15082a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f15073a.onNext(this.f15082a);
            }
        }

        a(g.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, j0.c cVar, boolean z) {
            this.f15073a = i0Var;
            this.f15074b = j2;
            this.f15075c = timeUnit;
            this.f15076d = cVar;
            this.f15077e = z;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15078f.dispose();
            this.f15076d.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15076d.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15076d.a(new RunnableC0211a(), this.f15074b, this.f15075c);
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15076d.a(new b(th), this.f15077e ? this.f15074b : 0L, this.f15075c);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15076d.a(new c(t), this.f15074b, this.f15075c);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15078f, cVar)) {
                this.f15078f = cVar;
                this.f15073a.onSubscribe(this);
            }
        }
    }

    public e0(g.a.g0<T> g0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var, boolean z) {
        super(g0Var);
        this.f15069b = j2;
        this.f15070c = timeUnit;
        this.f15071d = j0Var;
        this.f15072e = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(this.f15072e ? i0Var : new g.a.a1.m(i0Var), this.f15069b, this.f15070c, this.f15071d.a(), this.f15072e));
    }
}
