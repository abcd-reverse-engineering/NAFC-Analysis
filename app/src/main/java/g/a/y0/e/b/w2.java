package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableRepeatWhen.java */
/* loaded from: classes2.dex */
public final class w2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super g.a.l<Object>, ? extends i.d.b<?>> f14680c;

    /* compiled from: FlowableRepeatWhen.java */
    static final class a<T> extends c<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        a(i.d.c<? super T> cVar, g.a.d1.c<Object> cVar2, i.d.d dVar) {
            super(cVar, cVar2, dVar);
        }

        @Override // i.d.c
        public void onComplete() {
            again(0);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14681receiver.cancel();
            ((c) this).actual.onError(th);
        }
    }

    /* compiled from: FlowableRepeatWhen.java */
    static final class b<T, U> extends AtomicInteger implements g.a.q<Object>, i.d.d {
        private static final long serialVersionUID = 2827772011130406689L;
        final i.d.b<T> source;
        c<T, U> subscriber;
        final AtomicReference<i.d.d> subscription = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        b(i.d.b<T> bVar) {
            this.source = bVar;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this.subscription);
        }

        @Override // i.d.c
        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.subscriber.cancel();
            this.subscriber.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (!g.a.y0.i.j.isCancelled(this.subscription.get())) {
                    this.source.subscribe(this.subscriber);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            g.a.y0.i.j.deferredSetOnce(this.subscription, this.requested, dVar);
        }

        @Override // i.d.d
        public void request(long j2) {
            g.a.y0.i.j.deferredRequest(this.subscription, this.requested, j2);
        }
    }

    /* compiled from: FlowableRepeatWhen.java */
    static abstract class c<T, U> extends g.a.y0.i.i implements g.a.q<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        protected final i.d.c<? super T> actual;
        protected final g.a.d1.c<U> processor;
        private long produced;

        /* renamed from: receiver, reason: collision with root package name */
        protected final i.d.d f14681receiver;

        c(i.d.c<? super T> cVar, g.a.d1.c<U> cVar2, i.d.d dVar) {
            this.actual = cVar;
            this.processor = cVar2;
            this.f14681receiver = dVar;
        }

        protected final void again(U u) {
            long j2 = this.produced;
            if (j2 != 0) {
                this.produced = 0L;
                produced(j2);
            }
            this.f14681receiver.request(1L);
            this.processor.onNext(u);
        }

        @Override // g.a.y0.i.i, i.d.d
        public final void cancel() {
            super.cancel();
            this.f14681receiver.cancel();
        }

        @Override // i.d.c
        public final void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // g.a.q
        public final void onSubscribe(i.d.d dVar) {
            setSubscription(dVar);
        }
    }

    public w2(g.a.l<T> lVar, g.a.x0.o<? super g.a.l<Object>, ? extends i.d.b<?>> oVar) {
        super(lVar);
        this.f14680c = oVar;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        g.a.g1.e eVar = new g.a.g1.e(cVar);
        g.a.d1.c<T> cVarX = g.a.d1.g.m(8).X();
        try {
            i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.f14680c.apply(cVarX), "handler returned a null Publisher");
            b bVar2 = new b(this.f14110b);
            a aVar = new a(eVar, cVarX, bVar2);
            bVar2.subscriber = aVar;
            cVar.onSubscribe(aVar);
            bVar.subscribe(bVar2);
            bVar2.onNext(0);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.i.g.error(th, cVar);
        }
    }
}
