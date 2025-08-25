package g.a.y0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: BlockingFlowableIterable.java */
/* loaded from: classes2.dex */
public final class b<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14124a;

    /* renamed from: b, reason: collision with root package name */
    final int f14125b;

    /* compiled from: BlockingFlowableIterable.java */
    static final class a<T> extends AtomicReference<i.d.d> implements g.a.q<T>, Iterator<T>, Runnable, g.a.u0.c {
        private static final long serialVersionUID = 6695226475494099826L;
        final long batchSize;
        volatile boolean done;
        Throwable error;
        final long limit;
        long produced;
        final g.a.y0.f.b<T> queue;
        final Lock lock = new ReentrantLock();
        final Condition condition = this.lock.newCondition();

        a(int i2) {
            this.queue = new g.a.y0.f.b<>(i2);
            this.batchSize = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.i.j.cancel(this);
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
                g.a.y0.j.e.a();
                this.lock.lock();
                while (!this.done && this.queue.isEmpty()) {
                    try {
                        try {
                            this.condition.await();
                        } catch (InterruptedException e2) {
                            run();
                            throw g.a.y0.j.k.c(e2);
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.i.j.isCancelled(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tPoll = this.queue.poll();
            long j2 = this.produced + 1;
            if (j2 == this.limit) {
                this.produced = 0L;
                get().request(j2);
            } else {
                this.produced = j2;
            }
            return tPoll;
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                signalConsumer();
            } else {
                g.a.y0.i.j.cancel(this);
                onError(new g.a.v0.c("Queue full?!"));
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(this.batchSize);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a.y0.i.j.cancel(this);
            signalConsumer();
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

    public b(g.a.l<T> lVar, int i2) {
        this.f14124a = lVar;
        this.f14125b = i2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f14125b);
        this.f14124a.a((g.a.q) aVar);
        return aVar;
    }
}
