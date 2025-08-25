package g.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableScanSeed.java */
/* loaded from: classes2.dex */
public final class f3<T, R> extends g.a.y0.e.b.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<R, ? super T, R> f14219c;

    /* renamed from: d, reason: collision with root package name */
    final Callable<R> f14220d;

    /* compiled from: FlowableScanSeed.java */
    static final class a<T, R> extends AtomicInteger implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -1776795561228106469L;
        final g.a.x0.c<R, ? super T, R> accumulator;
        final i.d.c<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final g.a.y0.c.n<R> queue;
        final AtomicLong requested;
        i.d.d s;
        R value;

        a(i.d.c<? super R> cVar, g.a.x0.c<R, ? super T, R> cVar2, R r, int i2) {
            this.actual = cVar;
            this.accumulator = cVar2;
            this.value = r;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            this.queue = new g.a.y0.f.b(i2);
            this.queue.offer(r);
            this.requested = new AtomicLong();
        }

        @Override // i.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super R> cVar = this.actual;
            g.a.y0.c.n<R> nVar = this.queue;
            int i2 = this.limit;
            int i3 = this.consumed;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        nVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        nVar.clear();
                        cVar.onError(th);
                        return;
                    }
                    R rPoll = nVar.poll();
                    boolean z2 = rPoll == null;
                    if (z && z2) {
                        cVar.onComplete();
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(rPoll);
                    j3++;
                    i3++;
                    if (i3 == i2) {
                        this.s.request(i2);
                        i3 = 0;
                    }
                }
                if (j3 == j2 && this.done) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        nVar.clear();
                        cVar.onError(th2);
                        return;
                    } else if (nVar.isEmpty()) {
                        cVar.onComplete();
                        return;
                    }
                }
                if (j3 != 0) {
                    g.a.y0.j.d.c(this.requested, j3);
                }
                this.consumed = i3;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                R r = (R) g.a.y0.b.b.a(this.accumulator.apply(this.value, t), "The accumulator returned a null value");
                this.value = r;
                this.queue.offer(r);
                drain();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch - 1);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public f3(g.a.l<T> lVar, Callable<R> callable, g.a.x0.c<R, ? super T, R> cVar) {
        super(lVar);
        this.f14219c = cVar;
        this.f14220d = callable;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        try {
            this.f14110b.a((g.a.q) new a(cVar, this.f14219c, g.a.y0.b.b.a(this.f14220d.call(), "The seed supplied is null"), g.a.l.Q()));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.i.g.error(th, cVar);
        }
    }
}
