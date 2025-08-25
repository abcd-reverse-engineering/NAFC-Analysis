package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSamplePublisher.java */
/* loaded from: classes2.dex */
public final class b3<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<T> f14133b;

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<?> f14134c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14135d;

    /* compiled from: FlowableSamplePublisher.java */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        a(i.d.c<? super T> cVar, i.d.b<?> bVar) {
            super(cVar, bVar);
            this.wip = new AtomicInteger();
        }

        @Override // g.a.y0.e.b.b3.c
        void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // g.a.y0.e.b.b3.c
        void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // g.a.y0.e.b.b3.c
        void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.actual.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    /* compiled from: FlowableSamplePublisher.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        b(i.d.c<? super T> cVar, i.d.b<?> bVar) {
            super(cVar, bVar);
        }

        @Override // g.a.y0.e.b.b3.c
        void completeMain() {
            this.actual.onComplete();
        }

        @Override // g.a.y0.e.b.b3.c
        void completeOther() {
            this.actual.onComplete();
        }

        @Override // g.a.y0.e.b.b3.c
        void run() {
            emit();
        }
    }

    /* compiled from: FlowableSamplePublisher.java */
    static abstract class c<T> extends AtomicReference<T> implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -3517602651313910099L;
        final i.d.c<? super T> actual;
        i.d.d s;
        final i.d.b<?> sampler;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<i.d.d> other = new AtomicReference<>();

        c(i.d.c<? super T> cVar, i.d.b<?> bVar) {
            this.actual = cVar;
            this.sampler = bVar;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this.other);
            this.s.cancel();
        }

        public void complete() {
            this.s.cancel();
            completeOther();
        }

        abstract void completeMain();

        abstract void completeOther();

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(andSet);
                    g.a.y0.j.d.c(this.requested, 1L);
                } else {
                    cancel();
                    this.actual.onError(new g.a.v0.c("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        public void error(Throwable th) {
            this.s.cancel();
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onComplete() {
            g.a.y0.i.j.cancel(this.other);
            completeMain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            g.a.y0.i.j.cancel(this.other);
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new d(this));
                    dVar.request(h.q2.t.m0.f16408b);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
            }
        }

        abstract void run();

        boolean setOther(i.d.d dVar) {
            return g.a.y0.i.j.setOnce(this.other, dVar);
        }
    }

    /* compiled from: FlowableSamplePublisher.java */
    static final class d<T> implements g.a.q<Object> {

        /* renamed from: a, reason: collision with root package name */
        final c<T> f14136a;

        d(c<T> cVar) {
            this.f14136a = cVar;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14136a.complete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14136a.error(th);
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            this.f14136a.run();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (this.f14136a.setOther(dVar)) {
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public b3(i.d.b<T> bVar, i.d.b<?> bVar2, boolean z) {
        this.f14133b = bVar;
        this.f14134c = bVar2;
        this.f14135d = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        g.a.g1.e eVar = new g.a.g1.e(cVar);
        if (this.f14135d) {
            this.f14133b.subscribe(new a(eVar, this.f14134c));
        } else {
            this.f14133b.subscribe(new b(eVar, this.f14134c));
        }
    }
}
