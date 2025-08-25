package g.a.y0.h;

import h.q2.t.m0;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureSubscriber.java */
/* loaded from: classes2.dex */
public final class i<T> extends CountDownLatch implements g.a.q<T>, Future<T>, i.d.d {

    /* renamed from: a, reason: collision with root package name */
    T f16019a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f16020b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<i.d.d> f16021c;

    public i() {
        super(1);
        this.f16021c = new AtomicReference<>();
    }

    @Override // i.d.d
    public void cancel() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        i.d.d dVar;
        g.a.y0.i.j jVar;
        do {
            dVar = this.f16021c.get();
            if (dVar == this || dVar == (jVar = g.a.y0.i.j.CANCELLED)) {
                return false;
            }
        } while (!this.f16021c.compareAndSet(dVar, jVar));
        if (dVar != null) {
            dVar.cancel();
        }
        countDown();
        return true;
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
        Throwable th = this.f16020b;
        if (th == null) {
            return this.f16019a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return g.a.y0.i.j.isCancelled(this.f16021c.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // i.d.c
    public void onComplete() {
        i.d.d dVar;
        if (this.f16019a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            dVar = this.f16021c.get();
            if (dVar == this || dVar == g.a.y0.i.j.CANCELLED) {
                return;
            }
        } while (!this.f16021c.compareAndSet(dVar, this));
        countDown();
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        i.d.d dVar;
        do {
            dVar = this.f16021c.get();
            if (dVar == this || dVar == g.a.y0.i.j.CANCELLED) {
                g.a.c1.a.b(th);
                return;
            }
            this.f16020b = th;
        } while (!this.f16021c.compareAndSet(dVar, this));
        countDown();
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (this.f16019a == null) {
            this.f16019a = t;
        } else {
            this.f16021c.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (g.a.y0.i.j.setOnce(this.f16021c, dVar)) {
            dVar.request(m0.f16408b);
        }
    }

    @Override // i.d.d
    public void request(long j2) {
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
            Throwable th = this.f16020b;
            if (th == null) {
                return this.f16019a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
