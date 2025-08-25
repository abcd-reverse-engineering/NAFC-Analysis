package g.a.y0.e.d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingObservableLatest.java */
/* loaded from: classes2.dex */
public final class c<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f14989a;

    /* compiled from: BlockingObservableLatest.java */
    static final class a<T> extends g.a.a1.e<g.a.a0<T>> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        g.a.a0<T> f14990b;

        /* renamed from: c, reason: collision with root package name */
        final Semaphore f14991c = new Semaphore(0);

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference<g.a.a0<T>> f14992d = new AtomicReference<>();

        a() {
        }

        @Override // g.a.i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(g.a.a0<T> a0Var) {
            if (this.f14992d.getAndSet(a0Var) == null) {
                this.f14991c.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws InterruptedException {
            g.a.a0<T> a0Var = this.f14990b;
            if (a0Var != null && a0Var.d()) {
                throw g.a.y0.j.k.c(this.f14990b.a());
            }
            if (this.f14990b == null) {
                try {
                    g.a.y0.j.e.a();
                    this.f14991c.acquire();
                    g.a.a0<T> andSet = this.f14992d.getAndSet(null);
                    this.f14990b = andSet;
                    if (andSet.d()) {
                        throw g.a.y0.j.k.c(andSet.a());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f14990b = g.a.a0.a((Throwable) e2);
                    throw g.a.y0.j.k.c(e2);
                }
            }
            return this.f14990b.e();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tB = this.f14990b.b();
            this.f14990b = null;
            return tB;
        }

        @Override // g.a.i0
        public void onComplete() {
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.c1.a.b(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public c(g.a.g0<T> g0Var) {
        this.f14989a = g0Var;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        g.a.b0.v(this.f14989a).t().subscribe(aVar);
        return aVar;
    }
}
