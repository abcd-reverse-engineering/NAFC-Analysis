package g.a.y0.e.d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: BlockingObservableIterable.java */
/* loaded from: classes2.dex */
public final class b<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<? extends T> f14959a;

    /* renamed from: b, reason: collision with root package name */
    final int f14960b;

    /* compiled from: BlockingObservableIterable.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.i0<T>, Iterator<T>, g.a.u0.c {
        private static final long serialVersionUID = 6695226475494099826L;
        volatile boolean done;
        Throwable error;
        final g.a.y0.f.c<T> queue;
        final Lock lock = new ReentrantLock();
        final Condition condition = this.lock.newCondition();

        a(int i2) {
            this.queue = new g.a.y0.f.c<>(i2);
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z = this.done;
                boolean zIsEmpty = this.queue.isEmpty();
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        throw g.a.y0.j.k.c(th);
                    }
                    if (zIsEmpty) {
                        return false;
                    }
                }
                if (!zIsEmpty) {
                    return true;
                }
                try {
                    g.a.y0.j.e.a();
                    this.lock.lock();
                    while (!this.done && this.queue.isEmpty()) {
                        try {
                            this.condition.await();
                        } finally {
                        }
                    }
                    this.lock.unlock();
                } catch (InterruptedException e2) {
                    g.a.y0.a.d.dispose(this);
                    signalConsumer();
                    throw g.a.y0.j.k.c(e2);
                }
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.queue.offer(t);
            signalConsumer();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public b(g.a.g0<? extends T> g0Var, int i2) {
        this.f14959a = g0Var;
        this.f14960b = i2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f14960b);
        this.f14959a.subscribe(aVar);
        return aVar;
    }
}
