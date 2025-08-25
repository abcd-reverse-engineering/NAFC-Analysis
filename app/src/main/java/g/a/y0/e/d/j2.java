package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRepeat.java */
/* loaded from: classes2.dex */
public final class j2<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f15230b;

    /* compiled from: ObservableRepeat.java */
    static final class a<T> extends AtomicInteger implements g.a.i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final g.a.i0<? super T> actual;
        long remaining;
        final g.a.y0.a.k sd;
        final g.a.g0<? extends T> source;

        a(g.a.i0<? super T> i0Var, long j2, g.a.y0.a.k kVar, g.a.g0<? extends T> g0Var) {
            this.actual = i0Var;
            this.sd = kVar;
            this.source = g0Var;
            this.remaining = j2;
        }

        @Override // g.a.i0
        public void onComplete() {
            long j2 = this.remaining;
            if (j2 != h.q2.t.m0.f16408b) {
                this.remaining = j2 - 1;
            }
            if (j2 != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.sd.replace(cVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.sd.isDisposed()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public j2(g.a.b0<T> b0Var, long j2) {
        super(b0Var);
        this.f15230b = j2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.y0.a.k kVar = new g.a.y0.a.k();
        i0Var.onSubscribe(kVar);
        long j2 = this.f15230b;
        long j3 = h.q2.t.m0.f16408b;
        if (j2 != h.q2.t.m0.f16408b) {
            j3 = j2 - 1;
        }
        new a(i0Var, j3, kVar, this.f14934a).subscribeNext();
    }
}
