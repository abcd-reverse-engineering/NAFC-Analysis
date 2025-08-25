package g.a.y0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BlockingFlowableNext.java */
/* loaded from: classes2.dex */
public final class e<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<? extends T> f14183a;

    /* compiled from: BlockingFlowableNext.java */
    static final class a<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        private final b<T> f14184a;

        /* renamed from: b, reason: collision with root package name */
        private final i.d.b<? extends T> f14185b;

        /* renamed from: c, reason: collision with root package name */
        private T f14186c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f14187d = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f14188e = true;

        /* renamed from: f, reason: collision with root package name */
        private Throwable f14189f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f14190g;

        a(i.d.b<? extends T> bVar, b<T> bVar2) {
            this.f14185b = bVar;
            this.f14184a = bVar2;
        }

        private boolean a() {
            try {
                if (!this.f14190g) {
                    this.f14190g = true;
                    this.f14184a.c();
                    g.a.l.q(this.f14185b).t().a((g.a.q<? super g.a.a0<T>>) this.f14184a);
                }
                g.a.a0<T> a0VarD = this.f14184a.d();
                if (a0VarD.e()) {
                    this.f14188e = false;
                    this.f14186c = a0VarD.b();
                    return true;
                }
                this.f14187d = false;
                if (a0VarD.c()) {
                    return false;
                }
                if (!a0VarD.d()) {
                    throw new IllegalStateException("Should not reach here");
                }
                this.f14189f = a0VarD.a();
                throw g.a.y0.j.k.c(this.f14189f);
            } catch (InterruptedException e2) {
                this.f14184a.dispose();
                this.f14189f = e2;
                throw g.a.y0.j.k.c(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f14189f;
            if (th != null) {
                throw g.a.y0.j.k.c(th);
            }
            if (this.f14187d) {
                return !this.f14188e || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f14189f;
            if (th != null) {
                throw g.a.y0.j.k.c(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f14188e = true;
            return this.f14186c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* compiled from: BlockingFlowableNext.java */
    static final class b<T> extends g.a.g1.b<g.a.a0<T>> {

        /* renamed from: b, reason: collision with root package name */
        private final BlockingQueue<g.a.a0<T>> f14191b = new ArrayBlockingQueue(1);

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f14192c = new AtomicInteger();

        b() {
        }

        @Override // i.d.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(g.a.a0<T> a0Var) {
            if (this.f14192c.getAndSet(0) == 1 || !a0Var.e()) {
                while (!this.f14191b.offer(a0Var)) {
                    g.a.a0<T> a0VarPoll = this.f14191b.poll();
                    if (a0VarPoll != null && !a0VarPoll.e()) {
                        a0Var = a0VarPoll;
                    }
                }
            }
        }

        void c() {
            this.f14192c.set(1);
        }

        public g.a.a0<T> d() throws InterruptedException {
            c();
            g.a.y0.j.e.a();
            return this.f14191b.take();
        }

        @Override // i.d.c
        public void onComplete() {
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            g.a.c1.a.b(th);
        }
    }

    public e(i.d.b<? extends T> bVar) {
        this.f14183a = bVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f14183a, new b());
    }
}
