package g.a.y0.e.d;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableWindow.java */
/* loaded from: classes2.dex */
public final class y3<T> extends g.a.y0.e.d.a<T, g.a.b0<T>> {

    /* renamed from: b, reason: collision with root package name */
    final long f15594b;

    /* renamed from: c, reason: collision with root package name */
    final long f15595c;

    /* renamed from: d, reason: collision with root package name */
    final int f15596d;

    /* compiled from: ObservableWindow.java */
    static final class a<T> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        final g.a.i0<? super g.a.b0<T>> actual;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        g.a.u0.c s;
        long size;
        g.a.f1.j<T> window;

        a(g.a.i0<? super g.a.b0<T>> i0Var, long j2, int i2) {
            this.actual = i0Var;
            this.count = j2;
            this.capacityHint = i2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.cancelled = true;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.i0
        public void onComplete() {
            g.a.f1.j<T> jVar = this.window;
            if (jVar != null) {
                this.window = null;
                jVar.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.f1.j<T> jVar = this.window;
            if (jVar != null) {
                this.window = null;
                jVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            g.a.f1.j<T> jVarA = this.window;
            if (jVarA == null && !this.cancelled) {
                jVarA = g.a.f1.j.a(this.capacityHint, (Runnable) this);
                this.window = jVarA;
                this.actual.onNext(jVarA);
            }
            if (jVarA != null) {
                jVarA.onNext(t);
                long j2 = this.size + 1;
                this.size = j2;
                if (j2 >= this.count) {
                    this.size = 0L;
                    this.window = null;
                    jVarA.onComplete();
                    if (this.cancelled) {
                        this.s.dispose();
                    }
                }
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.s.dispose();
            }
        }
    }

    /* compiled from: ObservableWindow.java */
    static final class b<T> extends AtomicBoolean implements g.a.i0<T>, g.a.u0.c, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        final g.a.i0<? super g.a.b0<T>> actual;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        long firstEmission;
        long index;
        g.a.u0.c s;
        final long skip;
        final AtomicInteger wip = new AtomicInteger();
        final ArrayDeque<g.a.f1.j<T>> windows = new ArrayDeque<>();

        b(g.a.i0<? super g.a.b0<T>> i0Var, long j2, long j3, int i2) {
            this.actual = i0Var;
            this.count = j2;
            this.skip = j3;
            this.capacityHint = i2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.cancelled = true;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.i0
        public void onComplete() {
            ArrayDeque<g.a.f1.j<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            ArrayDeque<g.a.f1.j<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            ArrayDeque<g.a.f1.j<T>> arrayDeque = this.windows;
            long j2 = this.index;
            long j3 = this.skip;
            if (j2 % j3 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                g.a.f1.j<T> jVarA = g.a.f1.j.a(this.capacityHint, (Runnable) this);
                arrayDeque.offer(jVarA);
                this.actual.onNext(jVarA);
            }
            long j4 = this.firstEmission + 1;
            Iterator<g.a.f1.j<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j4 >= this.count) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.cancelled) {
                    this.s.dispose();
                    return;
                }
                this.firstEmission = j4 - j3;
            } else {
                this.firstEmission = j4;
            }
            this.index = j2 + 1;
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.s.dispose();
            }
        }
    }

    public y3(g.a.g0<T> g0Var, long j2, long j3, int i2) {
        super(g0Var);
        this.f15594b = j2;
        this.f15595c = j3;
        this.f15596d = i2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super g.a.b0<T>> i0Var) {
        long j2 = this.f15594b;
        long j3 = this.f15595c;
        if (j2 == j3) {
            this.f14934a.subscribe(new a(i0Var, j2, this.f15596d));
        } else {
            this.f14934a.subscribe(new b(i0Var, j2, j3, this.f15596d));
        }
    }
}
