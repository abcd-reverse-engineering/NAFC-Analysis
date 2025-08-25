package g.a.y0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingFlowableLatest.java */
/* loaded from: classes2.dex */
public final class c<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<? extends T> f14142a;

    /* compiled from: BlockingFlowableLatest.java */
    static final class a<T> extends g.a.g1.b<g.a.a0<T>> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        final Semaphore f14143b = new Semaphore(0);

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference<g.a.a0<T>> f14144c = new AtomicReference<>();

        /* renamed from: d, reason: collision with root package name */
        g.a.a0<T> f14145d;

        a() {
        }

        @Override // i.d.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(g.a.a0<T> a0Var) {
            if (this.f14144c.getAndSet(a0Var) == null) {
                this.f14143b.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws InterruptedException {
            g.a.a0<T> a0Var = this.f14145d;
            if (a0Var != null && a0Var.d()) {
                throw g.a.y0.j.k.c(this.f14145d.a());
            }
            g.a.a0<T> a0Var2 = this.f14145d;
            if ((a0Var2 == null || a0Var2.e()) && this.f14145d == null) {
                try {
                    g.a.y0.j.e.a();
                    this.f14143b.acquire();
                    g.a.a0<T> andSet = this.f14144c.getAndSet(null);
                    this.f14145d = andSet;
                    if (andSet.d()) {
                        throw g.a.y0.j.k.c(andSet.a());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f14145d = g.a.a0.a((Throwable) e2);
                    throw g.a.y0.j.k.c(e2);
                }
            }
            return this.f14145d.e();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext() || !this.f14145d.e()) {
                throw new NoSuchElementException();
            }
            T tB = this.f14145d.b();
            this.f14145d = null;
            return tB;
        }

        @Override // i.d.c
        public void onComplete() {
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            g.a.c1.a.b(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public c(i.d.b<? extends T> bVar) {
        this.f14142a = bVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        g.a.l.q(this.f14142a).t().a((g.a.q<? super g.a.a0<T>>) aVar);
        return aVar;
    }
}
