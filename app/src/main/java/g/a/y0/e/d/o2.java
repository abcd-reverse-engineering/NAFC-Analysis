package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRetryPredicate.java */
/* loaded from: classes2.dex */
public final class o2<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super Throwable> f15370b;

    /* renamed from: c, reason: collision with root package name */
    final long f15371c;

    /* compiled from: ObservableRetryPredicate.java */
    static final class a<T> extends AtomicInteger implements g.a.i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final g.a.i0<? super T> actual;
        final g.a.x0.r<? super Throwable> predicate;
        long remaining;
        final g.a.y0.a.k sa;
        final g.a.g0<? extends T> source;

        a(g.a.i0<? super T> i0Var, long j2, g.a.x0.r<? super Throwable> rVar, g.a.y0.a.k kVar, g.a.g0<? extends T> g0Var) {
            this.actual = i0Var;
            this.sa = kVar;
            this.source = g0Var;
            this.predicate = rVar;
            this.remaining = j2;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            long j2 = this.remaining;
            if (j2 != h.q2.t.m0.f16408b) {
                this.remaining = j2 - 1;
            }
            if (j2 == 0) {
                this.actual.onError(th);
                return;
            }
            try {
                if (this.predicate.test(th)) {
                    subscribeNext();
                } else {
                    this.actual.onError(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.actual.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.sa.update(cVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.sa.isDisposed()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public o2(g.a.b0<T> b0Var, long j2, g.a.x0.r<? super Throwable> rVar) {
        super(b0Var);
        this.f15370b = rVar;
        this.f15371c = j2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.y0.a.k kVar = new g.a.y0.a.k();
        i0Var.onSubscribe(kVar);
        new a(i0Var, this.f15371c, this.f15370b, kVar, this.f14934a).subscribeNext();
    }
}
