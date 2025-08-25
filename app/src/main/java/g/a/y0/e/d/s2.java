package g.a.y0.e.d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableScalarXMap.java */
/* loaded from: classes2.dex */
public final class s2 {

    /* compiled from: ObservableScalarXMap.java */
    public static final class a<T> extends AtomicInteger implements g.a.y0.c.j<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final g.a.i0<? super T> observer;
        final T value;

        public a(g.a.i0<? super T> i0Var, T t) {
            this.observer = i0Var;
            this.value = t;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            lazySet(3);
        }

        @Override // g.a.u0.c
        public void dispose() {
            set(3);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // g.a.y0.c.o
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        @Override // g.a.y0.c.o
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    /* compiled from: ObservableScalarXMap.java */
    static final class b<T, R> extends g.a.b0<R> {

        /* renamed from: a, reason: collision with root package name */
        final T f15465a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> f15466b;

        b(T t, g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> oVar) {
            this.f15465a = t;
            this.f15466b = oVar;
        }

        @Override // g.a.b0
        public void d(g.a.i0<? super R> i0Var) {
            try {
                g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.f15466b.apply(this.f15465a), "The mapper returned a null ObservableSource");
                if (!(g0Var instanceof Callable)) {
                    g0Var.subscribe(i0Var);
                    return;
                }
                try {
                    Object objCall = ((Callable) g0Var).call();
                    if (objCall == null) {
                        g.a.y0.a.e.complete(i0Var);
                        return;
                    }
                    a aVar = new a(i0Var, objCall);
                    i0Var.onSubscribe(aVar);
                    aVar.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.y0.a.e.error(th, i0Var);
                }
            } catch (Throwable th2) {
                g.a.y0.a.e.error(th2, i0Var);
            }
        }
    }

    private s2() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean a(g.a.g0<T> g0Var, g.a.i0<? super R> i0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> oVar) {
        if (!(g0Var instanceof Callable)) {
            return false;
        }
        try {
            a.a.a aVar = (Object) ((Callable) g0Var).call();
            if (aVar == null) {
                g.a.y0.a.e.complete(i0Var);
                return true;
            }
            try {
                g.a.g0 g0Var2 = (g.a.g0) g.a.y0.b.b.a(oVar.apply(aVar), "The mapper returned a null ObservableSource");
                if (g0Var2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) g0Var2).call();
                        if (objCall == null) {
                            g.a.y0.a.e.complete(i0Var);
                            return true;
                        }
                        a aVar2 = new a(i0Var, objCall);
                        i0Var.onSubscribe(aVar2);
                        aVar2.run();
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        g.a.y0.a.e.error(th, i0Var);
                        return true;
                    }
                } else {
                    g0Var2.subscribe(i0Var);
                }
                return true;
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                g.a.y0.a.e.error(th2, i0Var);
                return true;
            }
        } catch (Throwable th3) {
            g.a.v0.b.b(th3);
            g.a.y0.a.e.error(th3, i0Var);
            return true;
        }
    }

    public static <T, U> g.a.b0<U> a(T t, g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> oVar) {
        return g.a.c1.a.a(new b(t, oVar));
    }
}
