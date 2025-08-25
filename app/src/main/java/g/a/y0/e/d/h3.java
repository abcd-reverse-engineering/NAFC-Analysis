package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSwitchMap.java */
/* loaded from: classes2.dex */
public final class h3<T, R> extends g.a.y0.e.d.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> f15186b;

    /* renamed from: c, reason: collision with root package name */
    final int f15187c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f15188d;

    /* compiled from: ObservableSwitchMap.java */
    static final class a<T, R> extends AtomicReference<g.a.u0.c> implements g.a.i0<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        volatile boolean done;
        final long index;
        final b<T, R> parent;
        final g.a.y0.f.c<R> queue;

        a(b<T, R> bVar, long j2, int i2) {
            this.parent = bVar;
            this.index = j2;
            this.queue = new g.a.y0.f.c<>(i2);
        }

        public void cancel() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // g.a.i0
        public void onNext(R r) {
            if (this.index == this.parent.unique) {
                this.queue.offer(r);
                this.parent.drain();
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }
    }

    /* compiled from: ObservableSwitchMap.java */
    static final class b<T, R> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c {
        static final a<Object, Object> CANCELLED = new a<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final g.a.i0<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> mapper;
        g.a.u0.c s;
        volatile long unique;
        final AtomicReference<a<T, R>> active = new AtomicReference<>();
        final g.a.y0.j.c errors = new g.a.y0.j.c();

        static {
            CANCELLED.cancel();
        }

        b(g.a.i0<? super R> i0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> oVar, int i2, boolean z) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.bufferSize = i2;
            this.delayErrors = z;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.dispose();
            disposeInner();
        }

        void disposeInner() {
            a<Object, Object> aVar;
            a<T, R> aVar2 = this.active.get();
            a<Object, Object> aVar3 = CANCELLED;
            if (aVar2 == aVar3 || (aVar = (a) this.active.getAndSet(aVar3)) == CANCELLED || aVar == null) {
                return;
            }
            aVar.cancel();
        }

        /* JADX WARN: Removed duplicated region for block: B:78:0x00d6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x000b A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.d.h3.b.drain():void");
        }

        void innerError(a<T, R> aVar, Throwable th) {
            if (aVar.index != this.unique || !this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.s.dispose();
            }
            aVar.done = true;
            drain();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (!this.done && this.errors.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                if (!this.delayErrors) {
                    disposeInner();
                }
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            a<T, R> aVar;
            long j2 = this.unique + 1;
            this.unique = j2;
            a<T, R> aVar2 = this.active.get();
            if (aVar2 != null) {
                aVar2.cancel();
            }
            try {
                g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.mapper.apply(t), "The ObservableSource returned is null");
                a<T, R> aVar3 = new a<>(this, j2, this.bufferSize);
                do {
                    aVar = this.active.get();
                    if (aVar == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(aVar, aVar3));
                g0Var.subscribe(aVar3);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.s.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public h3(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> oVar, int i2, boolean z) {
        super(g0Var);
        this.f15186b = oVar;
        this.f15187c = i2;
        this.f15188d = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super R> i0Var) {
        if (s2.a(this.f14934a, i0Var, this.f15186b)) {
            return;
        }
        this.f14934a.subscribe(new b(i0Var, this.f15186b, this.f15187c, this.f15188d));
    }
}
