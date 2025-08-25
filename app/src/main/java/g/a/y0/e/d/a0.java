package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCreate.java */
/* loaded from: classes2.dex */
public final class a0<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.e0<T> f14935a;

    /* compiled from: ObservableCreate.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.d0<T>, g.a.u0.c {
        private static final long serialVersionUID = -3434801548987643227L;
        final g.a.i0<? super T> observer;

        a(g.a.i0<? super T> i0Var) {
            this.observer = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.d0, g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.k
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // g.a.k
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            g.a.c1.a.b(th);
        }

        @Override // g.a.k
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.observer.onNext(t);
            }
        }

        @Override // g.a.d0
        public g.a.d0<T> serialize() {
            return new b(this);
        }

        @Override // g.a.d0
        public void setCancellable(g.a.x0.f fVar) {
            setDisposable(new g.a.y0.a.b(fVar));
        }

        @Override // g.a.d0
        public void setDisposable(g.a.u0.c cVar) {
            g.a.y0.a.d.set(this, cVar);
        }

        @Override // g.a.d0
        public boolean tryOnError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }
    }

    /* compiled from: ObservableCreate.java */
    static final class b<T> extends AtomicInteger implements g.a.d0<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final g.a.d0<T> emitter;
        final g.a.y0.j.c error = new g.a.y0.j.c();
        final g.a.y0.f.c<T> queue = new g.a.y0.f.c<>(16);

        b(g.a.d0<T> d0Var) {
            this.emitter = d0Var;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            g.a.d0<T> d0Var = this.emitter;
            g.a.y0.f.c<T> cVar = this.queue;
            g.a.y0.j.c cVar2 = this.error;
            int iAddAndGet = 1;
            while (!d0Var.isDisposed()) {
                if (cVar2.get() != null) {
                    cVar.clear();
                    d0Var.onError(cVar2.terminate());
                    return;
                }
                boolean z = this.done;
                T tPoll = cVar.poll();
                boolean z2 = tPoll == null;
                if (z && z2) {
                    d0Var.onComplete();
                    return;
                } else if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    d0Var.onNext(tPoll);
                }
            }
            cVar.clear();
        }

        @Override // g.a.d0, g.a.u0.c
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // g.a.k
        public void onComplete() {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // g.a.k
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            g.a.c1.a.b(th);
        }

        @Override // g.a.k
        public void onNext(T t) {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                g.a.y0.f.c<T> cVar = this.queue;
                synchronized (cVar) {
                    cVar.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // g.a.d0
        public g.a.d0<T> serialize() {
            return this;
        }

        @Override // g.a.d0
        public void setCancellable(g.a.x0.f fVar) {
            this.emitter.setCancellable(fVar);
        }

        @Override // g.a.d0
        public void setDisposable(g.a.u0.c cVar) {
            this.emitter.setDisposable(cVar);
        }

        @Override // g.a.d0
        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isDisposed() && !this.done) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }
    }

    public a0(g.a.e0<T> e0Var) {
        this.f14935a = e0Var;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        a aVar = new a(i0Var);
        i0Var.onSubscribe(aVar);
        try {
            this.f14935a.a(aVar);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            aVar.onError(th);
        }
    }
}
