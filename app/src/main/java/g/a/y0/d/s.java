package g.a.y0.d;

import g.a.n0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureSingleObserver.java */
/* loaded from: classes2.dex */
public final class s<T> extends CountDownLatch implements n0<T>, Future<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    T f13966a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f13967b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<g.a.u0.c> f13968c;

    public s() {
        super(1);
        this.f13968c = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        g.a.u0.c cVar;
        g.a.y0.a.d dVar;
        do {
            cVar = this.f13968c.get();
            if (cVar == this || cVar == (dVar = g.a.y0.a.d.DISPOSED)) {
                return false;
            }
        } while (!this.f13968c.compareAndSet(cVar, dVar));
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
        Throwable th = this.f13967b;
        if (th == null) {
            return this.f13966a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return g.a.y0.a.d.isDisposed(this.f13968c.get());
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // g.a.n0
    public void onError(Throwable th) {
        g.a.u0.c cVar;
        do {
            cVar = this.f13968c.get();
            if (cVar == g.a.y0.a.d.DISPOSED) {
                g.a.c1.a.b(th);
                return;
            }
            this.f13967b = th;
        } while (!this.f13968c.compareAndSet(cVar, this));
        countDown();
    }

    @Override // g.a.n0
    public void onSubscribe(g.a.u0.c cVar) {
        g.a.y0.a.d.setOnce(this.f13968c, cVar);
    }

    @Override // g.a.n0
    public void onSuccess(T t) {
        g.a.u0.c cVar = this.f13968c.get();
        if (cVar == g.a.y0.a.d.DISPOSED) {
            return;
        }
        this.f13966a = t;
        this.f13968c.compareAndSet(cVar, this);
        countDown();
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
            Throwable th = this.f13967b;
            if (th == null) {
                return this.f13966a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
