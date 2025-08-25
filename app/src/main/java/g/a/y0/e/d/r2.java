package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSampleWithObservable.java */
/* loaded from: classes2.dex */
public final class r2<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<?> f15442b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f15443c;

    /* compiled from: ObservableSampleWithObservable.java */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        a(g.a.i0<? super T> i0Var, g.a.g0<?> g0Var) {
            super(i0Var, g0Var);
            this.wip = new AtomicInteger();
        }

        @Override // g.a.y0.e.d.r2.c
        void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // g.a.y0.e.d.r2.c
        void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // g.a.y0.e.d.r2.c
        void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.actual.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        b(g.a.i0<? super T> i0Var, g.a.g0<?> g0Var) {
            super(i0Var, g0Var);
        }

        @Override // g.a.y0.e.d.r2.c
        void completeMain() {
            this.actual.onComplete();
        }

        @Override // g.a.y0.e.d.r2.c
        void completeOther() {
            this.actual.onComplete();
        }

        @Override // g.a.y0.e.d.r2.c
        void run() {
            emit();
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    static abstract class c<T> extends AtomicReference<T> implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = -3517602651313910099L;
        final g.a.i0<? super T> actual;
        final AtomicReference<g.a.u0.c> other = new AtomicReference<>();
        g.a.u0.c s;
        final g.a.g0<?> sampler;

        c(g.a.i0<? super T> i0Var, g.a.g0<?> g0Var) {
            this.actual = i0Var;
            this.sampler = g0Var;
        }

        public void complete() {
            this.s.dispose();
            completeOther();
        }

        abstract void completeMain();

        abstract void completeOther();

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this.other);
            this.s.dispose();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }

        public void error(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.other.get() == g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.i0
        public void onComplete() {
            g.a.y0.a.d.dispose(this.other);
            completeMain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            g.a.y0.a.d.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new d(this));
                }
            }
        }

        abstract void run();

        boolean setOther(g.a.u0.c cVar) {
            return g.a.y0.a.d.setOnce(this.other, cVar);
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    static final class d<T> implements g.a.i0<Object> {

        /* renamed from: a, reason: collision with root package name */
        final c<T> f15444a;

        d(c<T> cVar) {
            this.f15444a = cVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15444a.complete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15444a.error(th);
        }

        @Override // g.a.i0
        public void onNext(Object obj) {
            this.f15444a.run();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15444a.setOther(cVar);
        }
    }

    public r2(g.a.g0<T> g0Var, g.a.g0<?> g0Var2, boolean z) {
        super(g0Var);
        this.f15442b = g0Var2;
        this.f15443c = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.a1.m mVar = new g.a.a1.m(i0Var);
        if (this.f15443c) {
            this.f14934a.subscribe(new a(mVar, this.f15442b));
        } else {
            this.f14934a.subscribe(new b(mVar, this.f15442b));
        }
    }
}
