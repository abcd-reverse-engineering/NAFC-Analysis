package g.a.y0.d;

import g.a.i0;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureObserver.java */
/* loaded from: classes2.dex */
public final class r<T> extends CountDownLatch implements i0<T>, Future<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    T f13963a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f13964b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<g.a.u0.c> f13965c;

    public r() {
        super(1);
        this.f13965c = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        g.a.u0.c cVar;
        g.a.y0.a.d dVar;
        do {
            cVar = this.f13965c.get();
            if (cVar == this || cVar == (dVar = g.a.y0.a.d.DISPOSED)) {
                return false;
            }
        } while (!this.f13965c.compareAndSet(cVar, dVar));
        if (cVar != null) {
            cVar.dispose();
        }
        countDown();
        return true;
    }

    @Override // g.a.u0.c
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        if (getCount() != 0) {
            g.a.y0.j.e.a();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.f13964b;
        if (th == null) {
            return this.f13963a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return g.a.y0.a.d.isDisposed(this.f13965c.get());
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // g.a.i0
    public void onComplete() {
        g.a.u0.c cVar;
        if (this.f13963a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            cVar = this.f13965c.get();
            if (cVar == this || cVar == g.a.y0.a.d.DISPOSED) {
                return;
            }
        } while (!this.f13965c.compareAndSet(cVar, this));
        countDown();
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        g.a.u0.c cVar;
        if (this.f13964b != null) {
            g.a.c1.a.b(th);
            return;
        }
        this.f13964b = th;
        do {
            cVar = this.f13965c.get();
            if (cVar == this || cVar == g.a.y0.a.d.DISPOSED) {
                g.a.c1.a.b(th);
                return;
            }
        } while (!this.f13965c.compareAndSet(cVar, this));
        countDown();
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (this.f13963a == null) {
            this.f13963a = t;
        } else {
            this.f13965c.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        g.a.y0.a.d.setOnce(this.f13965c, cVar);
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (getCount() != 0) {
            g.a.y0.j.e.a();
            if (!await(j2, timeUnit)) {
                throw new TimeoutException();
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f13964b;
            if (th == null) {
                return this.f13963a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
