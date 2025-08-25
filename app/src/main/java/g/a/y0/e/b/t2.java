package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: FlowableRefCount.java */
/* loaded from: classes2.dex */
public final class t2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.w0.a<T> f14623c;

    /* renamed from: d, reason: collision with root package name */
    volatile g.a.u0.b f14624d;

    /* renamed from: e, reason: collision with root package name */
    final AtomicInteger f14625e;

    /* renamed from: f, reason: collision with root package name */
    final ReentrantLock f14626f;

    /* compiled from: FlowableRefCount.java */
    final class a extends AtomicReference<i.d.d> implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = 152064694420235350L;
        final g.a.u0.b currentBase;
        final AtomicLong requested = new AtomicLong();
        final g.a.u0.c resource;
        final i.d.c<? super T> subscriber;

        a(i.d.c<? super T> cVar, g.a.u0.b bVar, g.a.u0.c cVar2) {
            this.subscriber = cVar;
            this.currentBase = bVar;
            this.resource = cVar2;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this);
            this.resource.dispose();
        }

        void cleanup() {
            t2.this.f14626f.lock();
            try {
                if (t2.this.f14624d == this.currentBase) {
                    if (t2.this.f14623c instanceof g.a.u0.c) {
                        ((g.a.u0.c) t2.this.f14623c).dispose();
                    }
                    t2.this.f14624d.dispose();
                    t2.this.f14624d = new g.a.u0.b();
                    t2.this.f14625e.set(0);
                }
            } finally {
                t2.this.f14626f.unlock();
            }
        }

        @Override // i.d.c
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            g.a.y0.i.j.deferredSetOnce(this, this.requested, dVar);
        }

        @Override // i.d.d
        public void request(long j2) {
            g.a.y0.i.j.deferredRequest(this, this.requested, j2);
        }
    }

    /* compiled from: FlowableRefCount.java */
    final class b implements g.a.x0.g<g.a.u0.c> {

        /* renamed from: a, reason: collision with root package name */
        private final i.d.c<? super T> f14627a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f14628b;

        b(i.d.c<? super T> cVar, AtomicBoolean atomicBoolean) {
            this.f14627a = cVar;
            this.f14628b = atomicBoolean;
        }

        @Override // g.a.x0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(g.a.u0.c cVar) {
            try {
                t2.this.f14624d.b(cVar);
                t2.this.a((i.d.c) this.f14627a, t2.this.f14624d);
            } finally {
                t2.this.f14626f.unlock();
                this.f14628b.set(false);
            }
        }
    }

    /* compiled from: FlowableRefCount.java */
    final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.u0.b f14630a;

        c(g.a.u0.b bVar) {
            this.f14630a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            t2.this.f14626f.lock();
            try {
                if (t2.this.f14624d == this.f14630a && t2.this.f14625e.decrementAndGet() == 0) {
                    if (t2.this.f14623c instanceof g.a.u0.c) {
                        ((g.a.u0.c) t2.this.f14623c).dispose();
                    }
                    t2.this.f14624d.dispose();
                    t2.this.f14624d = new g.a.u0.b();
                }
            } finally {
                t2.this.f14626f.unlock();
            }
        }
    }

    public t2(g.a.w0.a<T> aVar) {
        super(aVar);
        this.f14624d = new g.a.u0.b();
        this.f14625e = new AtomicInteger();
        this.f14626f = new ReentrantLock();
        this.f14623c = aVar;
    }

    private g.a.x0.g<g.a.u0.c> a(i.d.c<? super T> cVar, AtomicBoolean atomicBoolean) {
        return new b(cVar, atomicBoolean);
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        this.f14626f.lock();
        if (this.f14625e.incrementAndGet() != 1) {
            try {
                a((i.d.c) cVar, this.f14624d);
            } finally {
                this.f14626f.unlock();
            }
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f14623c.l((g.a.x0.g<? super g.a.u0.c>) a((i.d.c) cVar, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
    }

    void a(i.d.c<? super T> cVar, g.a.u0.b bVar) {
        a aVar = new a(cVar, bVar, a(bVar));
        cVar.onSubscribe(aVar);
        this.f14623c.a((g.a.q) aVar);
    }

    private g.a.u0.c a(g.a.u0.b bVar) {
        return g.a.u0.d.a(new c(bVar));
    }
}
