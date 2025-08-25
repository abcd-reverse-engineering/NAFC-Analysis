package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableRepeatUntil.java */
/* loaded from: classes2.dex */
public final class v2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.e f14666c;

    /* compiled from: FlowableRepeatUntil.java */
    static final class a<T> extends AtomicInteger implements g.a.q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final i.d.c<? super T> actual;
        final g.a.y0.i.i sa;
        final i.d.b<? extends T> source;
        final g.a.x0.e stop;

        a(i.d.c<? super T> cVar, g.a.x0.e eVar, g.a.y0.i.i iVar, i.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = iVar;
            this.source = bVar;
            this.stop = eVar;
        }

        @Override // i.d.c
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
                do {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                } while (iAddAndGet != 0);
            }
        }
    }

    public v2(g.a.l<T> lVar, g.a.x0.e eVar) {
        super(lVar);
        this.f14666c = eVar;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        g.a.y0.i.i iVar = new g.a.y0.i.i();
        cVar.onSubscribe(iVar);
        new a(cVar, this.f14666c, iVar, this.f14110b).subscribeNext();
    }
}
