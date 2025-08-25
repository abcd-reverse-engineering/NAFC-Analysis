package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableOnBackpressureBuffer.java */
/* loaded from: classes2.dex */
public final class e2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final int f14197c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14198d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f14199e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.x0.a f14200f;

    /* compiled from: FlowableOnBackpressureBuffer.java */
    static final class a<T> extends g.a.y0.i.c<T> implements g.a.q<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final g.a.x0.a onOverflow;
        boolean outputFused;
        final g.a.y0.c.n<T> queue;
        final AtomicLong requested = new AtomicLong();
        i.d.d s;

        a(i.d.c<? super T> cVar, int i2, boolean z, boolean z2, g.a.x0.a aVar) {
            this.actual = cVar;
            this.onOverflow = aVar;
            this.delayError = z2;
            this.queue = z ? new g.a.y0.f.c<>(i2) : new g.a.y0.f.b<>(i2);
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, i.d.c<? super T> cVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                cVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                g.a.y0.c.n<T> nVar = this.queue;
                i.d.c<? super T> cVar = this.actual;
                int iAddAndGet = 1;
                while (!checkTerminated(this.done, nVar.isEmpty(), cVar)) {
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (j3 != j2) {
                        boolean z = this.done;
                        T tPoll = nVar.poll();
                        boolean z2 = tPoll == null;
                        if (checkTerminated(z, z2, cVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        cVar.onNext(tPoll);
                        j3++;
                    }
                    if (j3 == j2 && checkTerminated(this.done, nVar.isEmpty(), cVar)) {
                        return;
                    }
                    if (j3 != 0 && j2 != h.q2.t.m0.f16408b) {
                        this.requested.addAndGet(-j3);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.actual.onComplete();
            } else {
                drain();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.actual.onError(th);
            } else {
                drain();
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                if (this.outputFused) {
                    this.actual.onNext(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            this.s.cancel();
            g.a.v0.c cVar = new g.a.v0.c("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cVar.initCause(th);
            }
            onError(cVar);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // i.d.d
        public void request(long j2) {
            if (this.outputFused || !g.a.y0.i.j.validate(j2)) {
                return;
            }
            g.a.y0.j.d.a(this.requested, j2);
            drain();
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public e2(g.a.l<T> lVar, int i2, boolean z, boolean z2, g.a.x0.a aVar) {
        super(lVar);
        this.f14197c = i2;
        this.f14198d = z;
        this.f14199e = z2;
        this.f14200f = aVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14197c, this.f14198d, this.f14199e, this.f14200f));
    }
}
