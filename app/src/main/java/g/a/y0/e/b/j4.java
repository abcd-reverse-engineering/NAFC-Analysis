package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FlowableUnsubscribeOn.java */
/* loaded from: classes2.dex */
public final class j4<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.j0 f14311c;

    /* compiled from: FlowableUnsubscribeOn.java */
    static final class a<T> extends AtomicBoolean implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = 1015244841293359600L;
        final i.d.c<? super T> actual;
        i.d.d s;
        final g.a.j0 scheduler;

        /* compiled from: FlowableUnsubscribeOn.java */
        /* renamed from: g.a.y0.e.b.j4$a$a, reason: collision with other inner class name */
        final class RunnableC0192a implements Runnable {
            RunnableC0192a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.s.cancel();
            }
        }

        a(i.d.c<? super T> cVar, g.a.j0 j0Var) {
            this.actual = cVar;
            this.scheduler = j0Var;
        }

        @Override // i.d.d
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.a(new RunnableC0192a());
            }
        }

        @Override // i.d.c
        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (get()) {
                g.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.s.request(j2);
        }
    }

    public j4(g.a.l<T> lVar, g.a.j0 j0Var) {
        super(lVar);
        this.f14311c = j0Var;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14311c));
    }
}
