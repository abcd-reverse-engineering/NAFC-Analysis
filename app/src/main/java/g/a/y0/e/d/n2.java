package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRetryBiPredicate.java */
/* loaded from: classes2.dex */
public final class n2<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.d<? super Integer, ? super Throwable> f15344b;

    /* compiled from: ObservableRetryBiPredicate.java */
    static final class a<T> extends AtomicInteger implements g.a.i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final g.a.i0<? super T> actual;
        final g.a.x0.d<? super Integer, ? super Throwable> predicate;
        int retries;
        final g.a.y0.a.k sa;
        final g.a.g0<? extends T> source;

        a(g.a.i0<? super T> i0Var, g.a.x0.d<? super Integer, ? super Throwable> dVar, g.a.y0.a.k kVar, g.a.g0<? extends T> g0Var) {
            this.actual = i0Var;
            this.sa = kVar;
            this.source = g0Var;
            this.predicate = dVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            try {
                g.a.x0.d<? super Integer, ? super Throwable> dVar = this.predicate;
                int i2 = this.retries + 1;
                this.retries = i2;
                if (dVar.a(Integer.valueOf(i2), th)) {
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

    public n2(g.a.b0<T> b0Var, g.a.x0.d<? super Integer, ? super Throwable> dVar) {
        super(b0Var);
        this.f15344b = dVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.y0.a.k kVar = new g.a.y0.a.k();
        i0Var.onSubscribe(kVar);
        new a(i0Var, this.f15344b, kVar, this.f14934a).subscribeNext();
    }
}
