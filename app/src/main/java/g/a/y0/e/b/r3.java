package g.a.y0.e.b;

import g.a.j0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSubscribeOn.java */
/* loaded from: classes2.dex */
public final class r3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.j0 f14577c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14578d;

    /* compiled from: FlowableSubscribeOn.java */
    static final class a<T> extends AtomicReference<Thread> implements g.a.q<T>, i.d.d, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final i.d.c<? super T> actual;
        final boolean nonScheduledRequests;
        i.d.b<T> source;
        final j0.c worker;
        final AtomicReference<i.d.d> s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        /* compiled from: FlowableSubscribeOn.java */
        /* renamed from: g.a.y0.e.b.r3$a$a, reason: collision with other inner class name */
        static final class RunnableC0195a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final i.d.d f14579a;

            /* renamed from: b, reason: collision with root package name */
            private final long f14580b;

            RunnableC0195a(i.d.d dVar, long j2) {
                this.f14579a = dVar;
                this.f14580b = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f14579a.request(this.f14580b);
            }
        }

        a(i.d.c<? super T> cVar, j0.c cVar2, i.d.b<T> bVar, boolean z) {
            this.actual = cVar;
            this.worker = cVar2;
            this.source = bVar;
            this.nonScheduledRequests = !z;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this.s);
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this.s, dVar)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, dVar);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                i.d.d dVar = this.s.get();
                if (dVar != null) {
                    requestUpstream(j2, dVar);
                    return;
                }
                g.a.y0.j.d.a(this.requested, j2);
                i.d.d dVar2 = this.s.get();
                if (dVar2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, dVar2);
                    }
                }
            }
        }

        void requestUpstream(long j2, i.d.d dVar) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                dVar.request(j2);
            } else {
                this.worker.a(new RunnableC0195a(dVar, j2));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            i.d.b<T> bVar = this.source;
            this.source = null;
            bVar.subscribe(this);
        }
    }

    public r3(g.a.l<T> lVar, g.a.j0 j0Var, boolean z) {
        super(lVar);
        this.f14577c = j0Var;
        this.f14578d = z;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        j0.c cVarA = this.f14577c.a();
        a aVar = new a(cVar, cVarA, this.f14110b, this.f14578d);
        cVar.onSubscribe(aVar);
        cVarA.a(aVar);
    }
}
