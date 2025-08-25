package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableOnBackpressureLatest.java */
/* loaded from: classes2.dex */
public final class i2<T> extends g.a.y0.e.b.a<T, T> {

    /* compiled from: FlowableOnBackpressureLatest.java */
    static final class a<T> extends AtomicInteger implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = 163080509307634843L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        i.d.d s;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<T> current = new AtomicReference<>();

        a(i.d.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.current.lazySet(null);
            }
        }

        boolean checkTerminated(boolean z, boolean z2, i.d.c<?> cVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                atomicReference.lazySet(null);
                cVar.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        
            if (r7 != r1.get()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r9 = r13.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        
            if (r2.get() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (checkTerminated(r9, r11, r0, r2) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        
            if (r7 == 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        
            g.a.y0.j.d.c(r1, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                i.d.c<? super T> r0 = r13.actual
                java.util.concurrent.atomic.AtomicLong r1 = r13.requested
                java.util.concurrent.atomic.AtomicReference<T> r2 = r13.current
                r3 = 1
                r4 = 1
            Lf:
                r5 = 0
                r7 = r5
            L12:
                long r9 = r1.get()
                r11 = 0
                int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r12 == 0) goto L38
                boolean r9 = r13.done
                r10 = 0
                java.lang.Object r10 = r2.getAndSet(r10)
                if (r10 != 0) goto L26
                r12 = 1
                goto L27
            L26:
                r12 = 0
            L27:
                boolean r9 = r13.checkTerminated(r9, r12, r0, r2)
                if (r9 == 0) goto L2e
                return
            L2e:
                if (r12 == 0) goto L31
                goto L38
            L31:
                r0.onNext(r10)
                r9 = 1
                long r7 = r7 + r9
                goto L12
            L38:
                long r9 = r1.get()
                int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r12 != 0) goto L50
                boolean r9 = r13.done
                java.lang.Object r10 = r2.get()
                if (r10 != 0) goto L49
                r11 = 1
            L49:
                boolean r9 = r13.checkTerminated(r9, r11, r0, r2)
                if (r9 == 0) goto L50
                return
            L50:
                int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r9 == 0) goto L57
                g.a.y0.j.d.c(r1, r7)
            L57:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.i2.a.drain():void");
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
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

    public i2(g.a.l<T> lVar) {
        super(lVar);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar));
    }
}
