package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRepeatUntil.java */
/* loaded from: classes2.dex */
public final class k2<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.e f15240b;

    /* compiled from: ObservableRepeatUntil.java */
    static final class a<T> extends AtomicInteger implements g.a.i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final g.a.i0<? super T> actual;
        final g.a.y0.a.k sd;
        final g.a.g0<? extends T> source;
        final g.a.x0.e stop;

        a(g.a.i0<? super T> i0Var, g.a.x0.e eVar, g.a.y0.a.k kVar, g.a.g0<? extends T> g0Var) {
            this.actual = i0Var;
            this.sd = kVar;
            this.source = g0Var;
            this.stop = eVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.actual.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.actual.onError(th);
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
                do {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                } while (iAddAndGet != 0);
            }
        }
    }

    public k2(g.a.b0<T> b0Var, g.a.x0.e eVar) {
        super(b0Var);
        this.f15240b = eVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.y0.a.k kVar = new g.a.y0.a.k();
        i0Var.onSubscribe(kVar);
        new a(i0Var, this.f15240b, kVar, this.f14934a).subscribeNext();
    }
}
