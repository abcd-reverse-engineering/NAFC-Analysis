package g.a.y0.e.e;

import g.a.q;
import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ParallelReduceFull.java */
/* loaded from: classes2.dex */
public final class n<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.b1.b<? extends T> f15717b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<T, T, T> f15718c;

    /* compiled from: ParallelReduceFull.java */
    static final class a<T> extends AtomicReference<i.d.d> implements q<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        boolean done;
        final b<T> parent;
        final g.a.x0.c<T, T, T> reducer;
        T value;

        a(b<T> bVar, g.a.x0.c<T, T, T> cVar) {
            this.parent = bVar;
            this.reducer = cVar;
        }

        void cancel() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete(this.value);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                this.value = (T) g.a.y0.b.b.a((Object) this.reducer.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                get().cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(m0.f16408b);
            }
        }
    }

    /* compiled from: ParallelReduceFull.java */
    static final class b<T> extends g.a.y0.i.f<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference<c<T>> current;
        final AtomicReference<Throwable> error;
        final g.a.x0.c<T, T, T> reducer;
        final AtomicInteger remaining;
        final a<T>[] subscribers;

        b(i.d.c<? super T> cVar, int i2, g.a.x0.c<T, T, T> cVar2) {
            super(cVar);
            this.current = new AtomicReference<>();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference<>();
            a<T>[] aVarArr = new a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = new a<>(this, cVar2);
            }
            this.subscribers = aVarArr;
            this.reducer = cVar2;
            this.remaining.lazySet(i2);
        }

        c<T> addValue(T t) {
            c<T> cVar;
            int iTryAcquireSlot;
            while (true) {
                cVar = this.current.get();
                if (cVar == null) {
                    cVar = new c<>();
                    if (!this.current.compareAndSet(null, cVar)) {
                        continue;
                    }
                }
                iTryAcquireSlot = cVar.tryAcquireSlot();
                if (iTryAcquireSlot >= 0) {
                    break;
                }
                this.current.compareAndSet(cVar, null);
            }
            if (iTryAcquireSlot == 0) {
                cVar.first = t;
            } else {
                cVar.second = t;
            }
            if (!cVar.releaseSlot()) {
                return null;
            }
            this.current.compareAndSet(cVar, null);
            return cVar;
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            for (a<T> aVar : this.subscribers) {
                aVar.cancel();
            }
        }

        void innerComplete(T t) {
            if (t != null) {
                while (true) {
                    c<T> cVarAddValue = addValue(t);
                    if (cVarAddValue == null) {
                        break;
                    }
                    try {
                        t = (T) g.a.y0.b.b.a((Object) this.reducer.apply(cVarAddValue.first, cVarAddValue.second), "The reducer returned a null value");
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        innerError(th);
                        return;
                    }
                }
            }
            if (this.remaining.decrementAndGet() == 0) {
                c<T> cVar = this.current.get();
                this.current.lazySet(null);
                if (cVar != null) {
                    complete(cVar.first);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                cancel();
                this.actual.onError(th);
            } else if (th != this.error.get()) {
                g.a.c1.a.b(th);
            }
        }
    }

    /* compiled from: ParallelReduceFull.java */
    static final class c<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final AtomicInteger releaseIndex = new AtomicInteger();
        T second;

        c() {
        }

        boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }

        int tryAcquireSlot() {
            int i2;
            do {
                i2 = get();
                if (i2 >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i2, i2 + 1));
            return i2;
        }
    }

    public n(g.a.b1.b<? extends T> bVar, g.a.x0.c<T, T, T> cVar) {
        this.f15717b = bVar;
        this.f15718c = cVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        b bVar = new b(cVar, this.f15717b.a(), this.f15718c);
        cVar.onSubscribe(bVar);
        this.f15717b.a(bVar.subscribers);
    }
}
