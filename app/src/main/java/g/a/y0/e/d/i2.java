package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ObservableRefCount.java */
/* loaded from: classes2.dex */
public final class i2<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.z0.a<? extends T> f15202b;

    /* renamed from: c, reason: collision with root package name */
    volatile g.a.u0.b f15203c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicInteger f15204d;

    /* renamed from: e, reason: collision with root package name */
    final ReentrantLock f15205e;

    /* compiled from: ObservableRefCount.java */
    final class a extends AtomicReference<g.a.u0.c> implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 3813126992133394324L;
        final g.a.u0.b currentBase;
        final g.a.u0.c resource;
        final g.a.i0<? super T> subscriber;

        a(g.a.i0<? super T> i0Var, g.a.u0.b bVar, g.a.u0.c cVar) {
            this.subscriber = i0Var;
            this.currentBase = bVar;
            this.resource = cVar;
        }

        void cleanup() {
            i2.this.f15205e.lock();
            try {
                if (i2.this.f15203c == this.currentBase) {
                    if (i2.this.f15202b instanceof g.a.u0.c) {
                        ((g.a.u0.c) i2.this.f15202b).dispose();
                    }
                    i2.this.f15203c.dispose();
                    i2.this.f15203c = new g.a.u0.b();
                    i2.this.f15204d.set(0);
                }
            } finally {
                i2.this.f15205e.unlock();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
            this.resource.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.i0
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }
    }

    /* compiled from: ObservableRefCount.java */
    final class b implements g.a.x0.g<g.a.u0.c> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.i0<? super T> f15206a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f15207b;

        b(g.a.i0<? super T> i0Var, AtomicBoolean atomicBoolean) {
            this.f15206a = i0Var;
            this.f15207b = atomicBoolean;
        }

        @Override // g.a.x0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(g.a.u0.c cVar) {
            try {
                i2.this.f15203c.b(cVar);
                i2.this.a((g.a.i0) this.f15206a, i2.this.f15203c);
            } finally {
                i2.this.f15205e.unlock();
                this.f15207b.set(false);
            }
        }
    }

    /* compiled from: ObservableRefCount.java */
    final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.u0.b f15209a;

        c(g.a.u0.b bVar) {
            this.f15209a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            i2.this.f15205e.lock();
            try {
                if (i2.this.f15203c == this.f15209a && i2.this.f15204d.decrementAndGet() == 0) {
                    if (i2.this.f15202b instanceof g.a.u0.c) {
                        ((g.a.u0.c) i2.this.f15202b).dispose();
                    }
                    i2.this.f15203c.dispose();
                    i2.this.f15203c = new g.a.u0.b();
                }
            } finally {
                i2.this.f15205e.unlock();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i2(g.a.z0.a<T> aVar) {
        super(aVar);
        this.f15203c = new g.a.u0.b();
        this.f15204d = new AtomicInteger();
        this.f15205e = new ReentrantLock();
        this.f15202b = aVar;
    }

    private g.a.x0.g<g.a.u0.c> a(g.a.i0<? super T> i0Var, AtomicBoolean atomicBoolean) {
        return new b(i0Var, atomicBoolean);
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f15205e.lock();
        if (this.f15204d.incrementAndGet() != 1) {
            try {
                a((g.a.i0) i0Var, this.f15203c);
            } finally {
                this.f15205e.unlock();
            }
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f15202b.k((g.a.x0.g<? super g.a.u0.c>) a((g.a.i0) i0Var, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
    }

    void a(g.a.i0<? super T> i0Var, g.a.u0.b bVar) {
        a aVar = new a(i0Var, bVar, a(bVar));
        i0Var.onSubscribe(aVar);
        this.f15202b.subscribe(aVar);
    }

    private g.a.u0.c a(g.a.u0.b bVar) {
        return g.a.u0.d.a(new c(bVar));
    }
}
