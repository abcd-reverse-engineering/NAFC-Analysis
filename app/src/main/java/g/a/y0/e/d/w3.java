package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableUnsubscribeOn.java */
/* loaded from: classes2.dex */
public final class w3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f15565b;

    /* compiled from: ObservableUnsubscribeOn.java */
    static final class a<T> extends AtomicBoolean implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 1015244841293359600L;
        final g.a.i0<? super T> actual;
        g.a.u0.c s;
        final g.a.j0 scheduler;

        /* compiled from: ObservableUnsubscribeOn.java */
        /* renamed from: g.a.y0.e.d.w3$a$a, reason: collision with other inner class name */
        final class RunnableC0219a implements Runnable {
            RunnableC0219a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.s.dispose();
            }
        }

        a(g.a.i0<? super T> i0Var, g.a.j0 j0Var) {
            this.actual = i0Var;
            this.scheduler = j0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.a(new RunnableC0219a());
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (get()) {
                g.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public w3(g.a.g0<T> g0Var, g.a.j0 j0Var) {
        super(g0Var);
        this.f15565b = j0Var;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15565b));
    }
}
