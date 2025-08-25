package g.a.y0.e.e;

import g.a.q;
import h.q2.t.m0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ParallelSortedJoin.java */
/* loaded from: classes2.dex */
public final class p<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.b1.b<List<T>> f15722b;

    /* renamed from: c, reason: collision with root package name */
    final Comparator<? super T> f15723c;

    /* compiled from: ParallelSortedJoin.java */
    static final class a<T> extends AtomicReference<i.d.d> implements q<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final b<T> parent;

        a(b<T> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        void cancel() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // i.d.c
        public void onComplete() {
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(m0.f16408b);
            }
        }

        @Override // i.d.c
        public void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }
    }

    /* compiled from: ParallelSortedJoin.java */
    static final class b<T> extends AtomicInteger implements i.d.d {
        private static final long serialVersionUID = 3481980673745556697L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final int[] indexes;
        final List<T>[] lists;
        final a<T>[] subscribers;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        b(i.d.c<? super T> cVar, int i2, Comparator<? super T> comparator) {
            this.actual = cVar;
            this.comparator = comparator;
            a<T>[] aVarArr = new a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = new a<>(this, i3);
            }
            this.subscribers = aVarArr;
            this.lists = new List[i2];
            this.indexes = new int[i2];
            this.remaining.lazySet(i2);
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                Arrays.fill(this.lists, (Object) null);
            }
        }

        void cancelAll() {
            for (a<T> aVar : this.subscribers) {
                aVar.cancel();
            }
        }

        void drain() {
            boolean z;
            T t;
            if (getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super T> cVar = this.actual;
            List<T>[] listArr = this.lists;
            int[] iArr = this.indexes;
            int length = iArr.length;
            int i2 = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th = this.error.get();
                    if (th != null) {
                        cancelAll();
                        Arrays.fill(listArr, (Object) null);
                        cVar.onError(th);
                        return;
                    }
                    a.a.a aVar = null;
                    int i3 = -1;
                    for (int i4 = 0; i4 < length; i4++) {
                        List<T> list = listArr[i4];
                        int i5 = iArr[i4];
                        if (list.size() != i5) {
                            if (aVar == null) {
                                t = list.get(i5);
                            } else {
                                t = list.get(i5);
                                try {
                                    if (this.comparator.compare(aVar, t) > 0) {
                                    }
                                } catch (Throwable th2) {
                                    g.a.v0.b.b(th2);
                                    cancelAll();
                                    Arrays.fill(listArr, (Object) null);
                                    if (!this.error.compareAndSet(null, th2)) {
                                        g.a.c1.a.b(th2);
                                    }
                                    cVar.onError(this.error.get());
                                    return;
                                }
                            }
                            aVar = (Object) t;
                            i3 = i4;
                        }
                    }
                    if (aVar == null) {
                        Arrays.fill(listArr, (Object) null);
                        cVar.onComplete();
                        return;
                    } else {
                        cVar.onNext(aVar);
                        iArr[i3] = iArr[i3] + 1;
                        j3++;
                    }
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th3 = this.error.get();
                    if (th3 != null) {
                        cancelAll();
                        Arrays.fill(listArr, (Object) null);
                        cVar.onError(th3);
                        return;
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            z = true;
                            break;
                        } else {
                            if (iArr[i6] != listArr[i6].size()) {
                                z = false;
                                break;
                            }
                            i6++;
                        }
                    }
                    if (z) {
                        Arrays.fill(listArr, (Object) null);
                        cVar.onComplete();
                        return;
                    }
                }
                if (j3 != 0 && j2 != m0.f16408b) {
                    this.requested.addAndGet(-j3);
                }
                int iAddAndGet = get();
                if (iAddAndGet == i2 && (iAddAndGet = addAndGet(-i2)) == 0) {
                    return;
                } else {
                    i2 = iAddAndGet;
                }
            }
        }

        void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                drain();
            } else if (th != this.error.get()) {
                g.a.c1.a.b(th);
            }
        }

        void innerNext(List<T> list, int i2) {
            this.lists[i2] = list;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }
    }

    public p(g.a.b1.b<List<T>> bVar, Comparator<? super T> comparator) {
        this.f15722b = bVar;
        this.f15723c = comparator;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        b bVar = new b(cVar, this.f15722b.a(), this.f15723c);
        cVar.onSubscribe(bVar);
        this.f15722b.a(bVar.subscribers);
    }
}
