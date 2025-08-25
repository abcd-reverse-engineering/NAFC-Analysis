package g.a.y0.e.d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BlockingObservableNext.java */
/* loaded from: classes2.dex */
public final class e<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15059a;

    /* compiled from: BlockingObservableNext.java */
    static final class a<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        private final b<T> f15060a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.g0<T> f15061b;

        /* renamed from: c, reason: collision with root package name */
        private T f15062c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f15063d = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f15064e = true;

        /* renamed from: f, reason: collision with root package name */
        private Throwable f15065f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f15066g;

        a(g.a.g0<T> g0Var, b<T> bVar) {
            this.f15061b = g0Var;
            this.f15060a = bVar;
        }

        private boolean a() {
            if (!this.f15066g) {
                this.f15066g = true;
                this.f15060a.b();
                new w1(this.f15061b).subscribe(this.f15060a);
            }
            try {
                g.a.a0<T> a0VarC = this.f15060a.c();
                if (a0VarC.e()) {
                    this.f15064e = false;
                    this.f15062c = a0VarC.b();
                    return true;
                }
                this.f15063d = false;
                if (a0VarC.c()) {
                    return false;
                }
                this.f15065f = a0VarC.a();
                throw g.a.y0.j.k.c(this.f15065f);
            } catch (InterruptedException e2) {
                this.f15060a.dispose();
                this.f15065f = e2;
                throw g.a.y0.j.k.c(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f15065f;
            if (th != null) {
                throw g.a.y0.j.k.c(th);
            }
            if (this.f15063d) {
                return !this.f15064e || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f15065f;
            if (th != null) {
                throw g.a.y0.j.k.c(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f15064e = true;
            return this.f15062c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* compiled from: BlockingObservableNext.java */
    static final class b<T> extends g.a.a1.e<g.a.a0<T>> {

        /* renamed from: b, reason: collision with root package name */
        private final BlockingQueue<g.a.a0<T>> f15067b = new ArrayBlockingQueue(1);

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f15068c = new AtomicInteger();

        b() {
        }

        @Override // g.a.i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(g.a.a0<T> a0Var) {
            if (this.f15068c.getAndSet(0) == 1 || !a0Var.e()) {
                while (!this.f15067b.offer(a0Var)) {
                    g.a.a0<T> a0VarPoll = this.f15067b.poll();
                    if (a0VarPoll != null && !a0VarPoll.e()) {
                        a0Var = a0VarPoll;
                    }
                }
            }
        }

        void b() {
            this.f15068c.set(1);
        }

        public g.a.a0<T> c() throws InterruptedException {
            b();
            g.a.y0.j.e.a();
            return this.f15067b.take();
        }

        @Override // g.a.i0
        public void onComplete() {
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.c1.a.b(th);
        }
    }

    public e(g.a.g0<T> g0Var) {
        this.f15059a = g0Var;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f15059a, new b());
    }
}
