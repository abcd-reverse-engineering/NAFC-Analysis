package g.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableGenerate.java */
/* loaded from: classes2.dex */
public final class j1<T, S> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<S> f14299b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<S, g.a.k<T>, S> f14300c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.g<? super S> f14301d;

    /* compiled from: FlowableGenerate.java */
    static final class a<T, S> extends AtomicLong implements g.a.k<T>, i.d.d {
        private static final long serialVersionUID = 7565982551505011832L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        final g.a.x0.g<? super S> disposeState;
        final g.a.x0.c<S, ? super g.a.k<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        a(i.d.c<? super T> cVar, g.a.x0.c<S, ? super g.a.k<T>, S> cVar2, g.a.x0.g<? super S> gVar, S s) {
            this.actual = cVar;
            this.generator = cVar2;
            this.disposeState = gVar;
            this.state = s;
        }

        private void a(S s) {
            try {
                this.disposeState.accept(s);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (g.a.y0.j.d.a(this, 1L) == 0) {
                S s = this.state;
                this.state = null;
                a(s);
            }
        }

        @Override // g.a.k
        public void onComplete() {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            this.actual.onComplete();
        }

        @Override // g.a.k
        public void onError(Throwable th) {
            if (this.terminate) {
                g.a.c1.a.b(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.actual.onError(th);
        }

        @Override // g.a.k
        public void onNext(T t) {
            if (this.terminate) {
                return;
            }
            if (this.hasNext) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.hasNext = true;
                this.actual.onNext(t);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
        
            r9.state = r0;
            r4 = addAndGet(-r10);
         */
        @Override // i.d.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void request(long r10) {
            /*
                r9 = this;
                boolean r0 = g.a.y0.i.j.validate(r10)
                if (r0 != 0) goto L7
                return
            L7:
                long r0 = g.a.y0.j.d.a(r9, r10)
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L12
                return
            L12:
                S r0 = r9.state
                g.a.x0.c<S, ? super g.a.k<T>, S> r1 = r9.generator
                r4 = r10
            L17:
                r10 = r2
            L18:
                int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r6 == 0) goto L4e
                boolean r6 = r9.cancelled
                r7 = 0
                if (r6 == 0) goto L27
                r9.state = r7
                r9.a(r0)
                return
            L27:
                r6 = 0
                r9.hasNext = r6
                r6 = 1
                java.lang.Object r0 = r1.apply(r0, r9)     // Catch: java.lang.Throwable -> L3f
                boolean r8 = r9.terminate
                if (r8 == 0) goto L3b
                r9.cancelled = r6
                r9.state = r7
                r9.a(r0)
                return
            L3b:
                r6 = 1
                long r10 = r10 + r6
                goto L18
            L3f:
                r10 = move-exception
                g.a.v0.b.b(r10)
                r9.cancelled = r6
                r9.state = r7
                r9.onError(r10)
                r9.a(r0)
                return
            L4e:
                long r4 = r9.get()
                int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r6 != 0) goto L18
                r9.state = r0
                long r10 = -r10
                long r4 = r9.addAndGet(r10)
                int r10 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r10 != 0) goto L17
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.j1.a.request(long):void");
        }
    }

    public j1(Callable<S> callable, g.a.x0.c<S, g.a.k<T>, S> cVar, g.a.x0.g<? super S> gVar) {
        this.f14299b = callable;
        this.f14300c = cVar;
        this.f14301d = gVar;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        try {
            cVar.onSubscribe(new a(cVar, this.f14300c, this.f14301d, this.f14299b.call()));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.i.g.error(th, cVar);
        }
    }
}
