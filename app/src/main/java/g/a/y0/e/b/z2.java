package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableRetryPredicate.java */
/* loaded from: classes2.dex */
public final class z2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.r<? super Throwable> f14739c;

    /* renamed from: d, reason: collision with root package name */
    final long f14740d;

    /* compiled from: FlowableRetryPredicate.java */
    static final class a<T> extends AtomicInteger implements g.a.q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final i.d.c<? super T> actual;
        final g.a.x0.r<? super Throwable> predicate;
        long remaining;
        final g.a.y0.i.i sa;
        final i.d.b<? extends T> source;

        a(i.d.c<? super T> cVar, long j2, g.a.x0.r<? super Throwable> rVar, g.a.y0.i.i iVar, i.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = iVar;
            this.source = bVar;
            this.predicate = rVar;
            this.remaining = j2;
        }

        @Override // i.d.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // i.d.c
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

    public z2(g.a.l<T> lVar, long j2, g.a.x0.r<? super Throwable> rVar) {
        super(lVar);
        this.f14739c = rVar;
        this.f14740d = j2;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        g.a.y0.i.i iVar = new g.a.y0.i.i();
        cVar.onSubscribe(iVar);
        new a(cVar, this.f14740d, this.f14739c, iVar, this.f14110b).subscribeNext();
    }
}
