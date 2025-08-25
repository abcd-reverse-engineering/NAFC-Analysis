package g.a.y0.e.b;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableTimeoutTimed.java */
/* loaded from: classes2.dex */
public final class f4<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14221c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f14222d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.j0 f14223e;

    /* renamed from: f, reason: collision with root package name */
    final i.d.b<? extends T> f14224f;

    /* compiled from: FlowableTimeoutTimed.java */
    static final class a<T> implements g.a.q<T> {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14225a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.y0.i.i f14226b;

        a(i.d.c<? super T> cVar, g.a.y0.i.i iVar) {
            this.f14225a = cVar;
            this.f14226b = iVar;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14225a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14225a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f14225a.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            this.f14226b.setSubscription(dVar);
        }
    }

    /* compiled from: FlowableTimeoutTimed.java */
    static final class b<T> extends g.a.y0.i.i implements g.a.q<T>, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final i.d.c<? super T> actual;
        long consumed;
        i.d.b<? extends T> fallback;
        final long timeout;
        final TimeUnit unit;
        final j0.c worker;
        final g.a.y0.a.k task = new g.a.y0.a.k();
        final AtomicReference<i.d.d> upstream = new AtomicReference<>();
        final AtomicLong index = new AtomicLong();

        b(i.d.c<? super T> cVar, long j2, TimeUnit timeUnit, j0.c cVar2, i.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar2;
            this.fallback = bVar;
        }

        @Override // g.a.y0.i.i, i.d.d
        public void cancel() {
            super.cancel();
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.index.getAndSet(h.q2.t.m0.f16408b) != h.q2.t.m0.f16408b) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.index.getAndSet(h.q2.t.m0.f16408b) == h.q2.t.m0.f16408b) {
                g.a.c1.a.b(th);
                return;
            }
            this.task.dispose();
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onNext(T t) {
            long j2 = this.index.get();
            if (j2 != h.q2.t.m0.f16408b) {
                long j3 = j2 + 1;
                if (this.index.compareAndSet(j2, j3)) {
                    this.task.get().dispose();
                    this.consumed++;
                    this.actual.onNext(t);
                    startTimeout(j3);
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this.upstream, dVar)) {
                setSubscription(dVar);
            }
        }

        @Override // g.a.y0.e.b.f4.d
        public void onTimeout(long j2) {
            if (this.index.compareAndSet(j2, h.q2.t.m0.f16408b)) {
                g.a.y0.i.j.cancel(this.upstream);
                long j3 = this.consumed;
                if (j3 != 0) {
                    produced(j3);
                }
                i.d.b<? extends T> bVar = this.fallback;
                this.fallback = null;
                bVar.subscribe(new a(this.actual, this));
                this.worker.dispose();
            }
        }

        void startTimeout(long j2) {
            this.task.replace(this.worker.a(new e(j2, this), this.timeout, this.unit));
        }
    }

    /* compiled from: FlowableTimeoutTimed.java */
    static final class c<T> extends AtomicLong implements g.a.q<T>, i.d.d, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final i.d.c<? super T> actual;
        final long timeout;
        final TimeUnit unit;
        final j0.c worker;
        final g.a.y0.a.k task = new g.a.y0.a.k();
        final AtomicReference<i.d.d> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        c(i.d.c<? super T> cVar, long j2, TimeUnit timeUnit, j0.c cVar2) {
            this.actual = cVar;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar2;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onComplete() {
            if (getAndSet(h.q2.t.m0.f16408b) != h.q2.t.m0.f16408b) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (getAndSet(h.q2.t.m0.f16408b) == h.q2.t.m0.f16408b) {
                g.a.c1.a.b(th);
                return;
            }
            this.task.dispose();
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onNext(T t) {
            long j2 = get();
            if (j2 != h.q2.t.m0.f16408b) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    this.task.get().dispose();
                    this.actual.onNext(t);
                    startTimeout(j3);
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            g.a.y0.i.j.deferredSetOnce(this.upstream, this.requested, dVar);
        }

        @Override // g.a.y0.e.b.f4.d
        public void onTimeout(long j2) {
            if (compareAndSet(j2, h.q2.t.m0.f16408b)) {
                g.a.y0.i.j.cancel(this.upstream);
                this.actual.onError(new TimeoutException());
                this.worker.dispose();
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            g.a.y0.i.j.deferredRequest(this.upstream, this.requested, j2);
        }

        void startTimeout(long j2) {
            this.task.replace(this.worker.a(new e(j2, this), this.timeout, this.unit));
        }
    }

    /* compiled from: FlowableTimeoutTimed.java */
    interface d {
        void onTimeout(long j2);
    }

    /* compiled from: FlowableTimeoutTimed.java */
    static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final d f14227a;

        /* renamed from: b, reason: collision with root package name */
        final long f14228b;

        e(long j2, d dVar) {
            this.f14228b = j2;
            this.f14227a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14227a.onTimeout(this.f14228b);
        }
    }

    public f4(g.a.l<T> lVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var, i.d.b<? extends T> bVar) {
        super(lVar);
        this.f14221c = j2;
        this.f14222d = timeUnit;
        this.f14223e = j0Var;
        this.f14224f = bVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        if (this.f14224f == null) {
            c cVar2 = new c(cVar, this.f14221c, this.f14222d, this.f14223e.a());
            cVar.onSubscribe(cVar2);
            cVar2.startTimeout(0L);
            this.f14110b.a((g.a.q) cVar2);
            return;
        }
        b bVar = new b(cVar, this.f14221c, this.f14222d, this.f14223e.a(), this.f14224f);
        cVar.onSubscribe(bVar);
        bVar.startTimeout(0L);
        this.f14110b.a((g.a.q) bVar);
    }
}
