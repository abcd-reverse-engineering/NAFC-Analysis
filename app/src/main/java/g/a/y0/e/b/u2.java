package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableRepeat.java */
/* loaded from: classes2.dex */
public final class u2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14653c;

    /* compiled from: FlowableRepeat.java */
    static final class a<T> extends AtomicInteger implements g.a.q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final i.d.c<? super T> actual;
        long remaining;
        final g.a.y0.i.i sa;
        final i.d.b<? extends T> source;

        a(i.d.c<? super T> cVar, long j2, g.a.y0.i.i iVar, i.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = iVar;
            this.source = bVar;
            this.remaining = j2;
        }

        @Override // i.d.c
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

        @Override // i.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
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

    public u2(g.a.l<T> lVar, long j2) {
        super(lVar);
        this.f14653c = j2;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        g.a.y0.i.i iVar = new g.a.y0.i.i();
        cVar.onSubscribe(iVar);
        long j2 = this.f14653c;
        long j3 = h.q2.t.m0.f16408b;
        if (j2 != h.q2.t.m0.f16408b) {
            j3 = j2 - 1;
        }
        new a(cVar, j3, iVar, this.f14110b).subscribeNext();
    }
}
