package g.a.y0.e.b;

import g.a.j0;
import java.util.concurrent.TimeUnit;

/* compiled from: FlowableDelay.java */
/* loaded from: classes2.dex */
public final class g0<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14235c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f14236d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.j0 f14237e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f14238f;

    /* compiled from: FlowableDelay.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14239a;

        /* renamed from: b, reason: collision with root package name */
        final long f14240b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f14241c;

        /* renamed from: d, reason: collision with root package name */
        final j0.c f14242d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f14243e;

        /* renamed from: f, reason: collision with root package name */
        i.d.d f14244f;

        /* compiled from: FlowableDelay.java */
        /* renamed from: g.a.y0.e.b.g0$a$a, reason: collision with other inner class name */
        final class RunnableC0190a implements Runnable {
            RunnableC0190a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f14239a.onComplete();
                } finally {
                    a.this.f14242d.dispose();
                }
            }
        }

        /* compiled from: FlowableDelay.java */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final Throwable f14246a;

            b(Throwable th) {
                this.f14246a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f14239a.onError(this.f14246a);
                } finally {
                    a.this.f14242d.dispose();
                }
            }
        }

        /* compiled from: FlowableDelay.java */
        final class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final T f14248a;

            c(T t) {
                this.f14248a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f14239a.onNext(this.f14248a);
            }
        }

        a(i.d.c<? super T> cVar, long j2, TimeUnit timeUnit, j0.c cVar2, boolean z) {
            this.f14239a = cVar;
            this.f14240b = j2;
            this.f14241c = timeUnit;
            this.f14242d = cVar2;
            this.f14243e = z;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14244f.cancel();
            this.f14242d.dispose();
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14242d.a(new RunnableC0190a(), this.f14240b, this.f14241c);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14242d.a(new b(th), this.f14243e ? this.f14240b : 0L, this.f14241c);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f14242d.a(new c(t), this.f14240b, this.f14241c);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14244f, dVar)) {
                this.f14244f = dVar;
                this.f14239a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14244f.request(j2);
        }
    }

    public g0(g.a.l<T> lVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var, boolean z) {
        super(lVar);
        this.f14235c = j2;
        this.f14236d = timeUnit;
        this.f14237e = j0Var;
        this.f14238f = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(this.f14238f ? cVar : new g.a.g1.e(cVar), this.f14235c, this.f14236d, this.f14237e.a(), this.f14238f));
    }
}
