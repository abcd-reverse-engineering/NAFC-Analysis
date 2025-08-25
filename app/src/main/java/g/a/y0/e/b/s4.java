package g.a.y0.e.b;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableZip.java */
/* loaded from: classes2.dex */
public final class s4<T, R> extends g.a.l<R> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<? extends T>[] f14608b;

    /* renamed from: c, reason: collision with root package name */
    final Iterable<? extends i.d.b<? extends T>> f14609c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.o<? super Object[], ? extends R> f14610d;

    /* renamed from: e, reason: collision with root package name */
    final int f14611e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f14612f;

    /* compiled from: FlowableZip.java */
    static final class a<T, R> extends AtomicInteger implements i.d.d {
        private static final long serialVersionUID = -2434867452883857743L;
        final i.d.c<? super R> actual;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final g.a.y0.j.c errors;
        final AtomicLong requested;
        final b<T, R>[] subscribers;
        final g.a.x0.o<? super Object[], ? extends R> zipper;

        a(i.d.c<? super R> cVar, g.a.x0.o<? super Object[], ? extends R> oVar, int i2, int i3, boolean z) {
            this.actual = cVar;
            this.zipper = oVar;
            this.delayErrors = z;
            b<T, R>[] bVarArr = new b[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                bVarArr[i4] = new b<>(this, i3);
            }
            this.current = new Object[i2];
            this.subscribers = bVarArr;
            this.requested = new AtomicLong();
            this.errors = new g.a.y0.j.c();
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
        }

        void cancelAll() {
            for (b<T, R> bVar : this.subscribers) {
                bVar.cancel();
            }
        }

        void drain() {
            boolean z;
            T tPoll;
            boolean z2;
            if (getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super R> cVar = this.actual;
            b<T, R>[] bVarArr = this.subscribers;
            int length = bVarArr.length;
            Object[] objArr = this.current;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j2 != j3) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        cancelAll();
                        cVar.onError(this.errors.terminate());
                        return;
                    }
                    boolean z3 = false;
                    for (int i2 = 0; i2 < length; i2++) {
                        b<T, R> bVar = bVarArr[i2];
                        if (objArr[i2] == null) {
                            try {
                                z = bVar.done;
                                g.a.y0.c.o<T> oVar = bVar.queue;
                                tPoll = oVar != null ? oVar.poll() : null;
                                z2 = tPoll == null;
                            } catch (Throwable th) {
                                g.a.v0.b.b(th);
                                this.errors.addThrowable(th);
                                if (!this.delayErrors) {
                                    cancelAll();
                                    cVar.onError(this.errors.terminate());
                                    return;
                                }
                            }
                            if (z && z2) {
                                cancelAll();
                                if (this.errors.get() != null) {
                                    cVar.onError(this.errors.terminate());
                                    return;
                                } else {
                                    cVar.onComplete();
                                    return;
                                }
                            }
                            if (z2) {
                                z3 = true;
                            } else {
                                objArr[i2] = tPoll;
                            }
                        }
                    }
                    if (z3) {
                        break;
                    }
                    try {
                        cVar.onNext((Object) g.a.y0.b.b.a(this.zipper.apply(objArr.clone()), "The zipper returned a null value"));
                        j3++;
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        cancelAll();
                        this.errors.addThrowable(th2);
                        cVar.onError(this.errors.terminate());
                        return;
                    }
                }
                if (j2 == j3) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        cancelAll();
                        cVar.onError(this.errors.terminate());
                        return;
                    }
                    for (int i3 = 0; i3 < length; i3++) {
                        b<T, R> bVar2 = bVarArr[i3];
                        if (objArr[i3] == null) {
                            try {
                                boolean z4 = bVar2.done;
                                g.a.y0.c.o<T> oVar2 = bVar2.queue;
                                T tPoll2 = oVar2 != null ? oVar2.poll() : null;
                                boolean z5 = tPoll2 == null;
                                if (z4 && z5) {
                                    cancelAll();
                                    if (this.errors.get() != null) {
                                        cVar.onError(this.errors.terminate());
                                        return;
                                    } else {
                                        cVar.onComplete();
                                        return;
                                    }
                                }
                                if (!z5) {
                                    objArr[i3] = tPoll2;
                                }
                            } catch (Throwable th3) {
                                g.a.v0.b.b(th3);
                                this.errors.addThrowable(th3);
                                if (!this.delayErrors) {
                                    cancelAll();
                                    cVar.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        }
                    }
                }
                if (j3 != 0) {
                    for (b<T, R> bVar3 : bVarArr) {
                        bVar3.request(j3);
                    }
                    if (j2 != h.q2.t.m0.f16408b) {
                        this.requested.addAndGet(-j3);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        void error(b<T, R> bVar, Throwable th) {
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
            } else {
                bVar.done = true;
                drain();
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        void subscribe(i.d.b<? extends T>[] bVarArr, int i2) {
            b<T, R>[] bVarArr2 = this.subscribers;
            for (int i3 = 0; i3 < i2 && !this.cancelled; i3++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    return;
                }
                bVarArr[i3].subscribe(bVarArr2[i3]);
            }
        }
    }

    /* compiled from: FlowableZip.java */
    static final class b<T, R> extends AtomicReference<i.d.d> implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final a<T, R> parent;
        final int prefetch;
        long produced;
        g.a.y0.c.o<T> queue;
        int sourceMode;

        b(a<T, R> aVar, int i2) {
            this.parent = aVar;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.drain();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new g.a.y0.f.b(this.prefetch);
                dVar.request(this.prefetch);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (this.sourceMode != 1) {
                long j3 = this.produced + j2;
                if (j3 < this.limit) {
                    this.produced = j3;
                } else {
                    this.produced = 0L;
                    get().request(j3);
                }
            }
        }
    }

    public s4(i.d.b<? extends T>[] bVarArr, Iterable<? extends i.d.b<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
        this.f14608b = bVarArr;
        this.f14609c = iterable;
        this.f14610d = oVar;
        this.f14611e = i2;
        this.f14612f = z;
    }

    @Override // g.a.l
    public void d(i.d.c<? super R> cVar) {
        int length;
        i.d.b<? extends T>[] bVarArr = this.f14608b;
        if (bVarArr == null) {
            bVarArr = new i.d.b[8];
            length = 0;
            for (i.d.b<? extends T> bVar : this.f14609c) {
                if (length == bVarArr.length) {
                    i.d.b<? extends T>[] bVarArr2 = new i.d.b[(length >> 2) + length];
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                    bVarArr = bVarArr2;
                }
                bVarArr[length] = bVar;
                length++;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            g.a.y0.i.g.complete(cVar);
            return;
        }
        a aVar = new a(cVar, this.f14610d, length, this.f14611e, this.f14612f);
        cVar.onSubscribe(aVar);
        aVar.subscribe(bVarArr, length);
    }
}
