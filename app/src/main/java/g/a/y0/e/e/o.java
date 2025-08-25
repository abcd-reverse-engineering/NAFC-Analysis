package g.a.y0.e.e;

import g.a.j0;
import g.a.q;
import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ParallelRunOn.java */
/* loaded from: classes2.dex */
public final class o<T> extends g.a.b1.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<? extends T> f15719a;

    /* renamed from: b, reason: collision with root package name */
    final j0 f15720b;

    /* renamed from: c, reason: collision with root package name */
    final int f15721c;

    /* compiled from: ParallelRunOn.java */
    static abstract class a<T> extends AtomicInteger implements q<T>, i.d.d, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final g.a.y0.f.b<T> queue;
        final AtomicLong requested = new AtomicLong();
        i.d.d s;
        final j0.c worker;

        a(int i2, g.a.y0.f.b<T> bVar, j0.c cVar) {
            this.prefetch = i2;
            this.queue = bVar;
            this.limit = i2 - (i2 >> 2);
            this.worker = cVar;
        }

        @Override // i.d.d
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // i.d.c
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // i.d.c
        public final void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // i.d.c
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.queue.offer(t)) {
                schedule();
            } else {
                this.s.cancel();
                onError(new g.a.v0.c("Queue is full?!"));
            }
        }

        @Override // i.d.d
        public final void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                schedule();
            }
        }

        final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.a(this);
            }
        }
    }

    /* compiled from: ParallelRunOn.java */
    static final class b<T> extends a<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final g.a.y0.c.a<? super T> actual;

        b(g.a.y0.c.a<? super T> aVar, int i2, g.a.y0.f.b<T> bVar, j0.c cVar) {
            super(i2, bVar, cVar);
            this.actual = aVar;
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i2 = this.consumed;
            g.a.y0.f.b<T> bVar = this.queue;
            g.a.y0.c.a<? super T> aVar = this.actual;
            int i3 = this.limit;
            int iAddAndGet = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        bVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        bVar.clear();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T tPoll = bVar.poll();
                    boolean z2 = tPoll == null;
                    if (z && z2) {
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        if (aVar.tryOnNext(tPoll)) {
                            j3++;
                        }
                        i2++;
                        if (i2 == i3) {
                            this.s.request(i2);
                            i2 = 0;
                        }
                    }
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        bVar.clear();
                        return;
                    }
                    if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            bVar.clear();
                            aVar.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (bVar.isEmpty()) {
                            aVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j3 != 0 && j2 != m0.f16408b) {
                    this.requested.addAndGet(-j3);
                }
                int i4 = get();
                if (i4 == iAddAndGet) {
                    this.consumed = i2;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i4;
                }
            }
        }
    }

    /* compiled from: ParallelRunOn.java */
    static final class c<T> extends a<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final i.d.c<? super T> actual;

        c(i.d.c<? super T> cVar, int i2, g.a.y0.f.b<T> bVar, j0.c cVar2) {
            super(i2, bVar, cVar2);
            this.actual = cVar;
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i2 = this.consumed;
            g.a.y0.f.b<T> bVar = this.queue;
            i.d.c<? super T> cVar = this.actual;
            int i3 = this.limit;
            int iAddAndGet = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        bVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        bVar.clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T tPoll = bVar.poll();
                    boolean z2 = tPoll == null;
                    if (z && z2) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        cVar.onNext(tPoll);
                        j3++;
                        i2++;
                        if (i2 == i3) {
                            this.s.request(i2);
                            i2 = 0;
                        }
                    }
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        bVar.clear();
                        return;
                    }
                    if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            bVar.clear();
                            cVar.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (bVar.isEmpty()) {
                            cVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j3 != 0 && j2 != m0.f16408b) {
                    this.requested.addAndGet(-j3);
                }
                int i4 = get();
                if (i4 == iAddAndGet) {
                    this.consumed = i2;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i4;
                }
            }
        }
    }

    public o(g.a.b1.b<? extends T> bVar, j0 j0Var, int i2) {
        this.f15719a = bVar;
        this.f15720b = j0Var;
        this.f15721c = i2;
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super Object>[] cVarArr2 = new i.d.c[length];
            int i2 = this.f15721c;
            for (int i3 = 0; i3 < length; i3++) {
                i.d.c<? super T> cVar = cVarArr[i3];
                j0.c cVarA = this.f15720b.a();
                g.a.y0.f.b bVar = new g.a.y0.f.b(i2);
                if (cVar instanceof g.a.y0.c.a) {
                    cVarArr2[i3] = new b((g.a.y0.c.a) cVar, i2, bVar, cVarA);
                } else {
                    cVarArr2[i3] = new c(cVar, i2, bVar, cVarA);
                }
            }
            this.f15719a.a(cVarArr2);
        }
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15719a.a();
    }
}
