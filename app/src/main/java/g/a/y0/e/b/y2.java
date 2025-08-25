package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableRetryBiPredicate.java */
/* loaded from: classes2.dex */
public final class y2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.d<? super Integer, ? super Throwable> f14726c;

    /* compiled from: FlowableRetryBiPredicate.java */
    static final class a<T> extends AtomicInteger implements g.a.q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final i.d.c<? super T> actual;
        final g.a.x0.d<? super Integer, ? super Throwable> predicate;
        int retries;
        final g.a.y0.i.i sa;
        final i.d.b<? extends T> source;

        a(i.d.c<? super T> cVar, g.a.x0.d<? super Integer, ? super Throwable> dVar, g.a.y0.i.i iVar, i.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = iVar;
            this.source = bVar;
            this.predicate = dVar;
        }

        @Override // i.d.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // i.d.c
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

        @Override // i.d.c
        public void onNext(T t) {
            this.actual.onNext(t);
            this.sa.produced(1L);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            this.sa.setSubscription(dVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.sa.isCancelled()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public y2(g.a.l<T> lVar, g.a.x0.d<? super Integer, ? super Throwable> dVar) {
        super(lVar);
        this.f14726c = dVar;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        g.a.y0.i.i iVar = new g.a.y0.i.i();
        cVar.onSubscribe(iVar);
        new a(cVar, this.f14726c, iVar, this.f14110b).subscribeNext();
    }
}
