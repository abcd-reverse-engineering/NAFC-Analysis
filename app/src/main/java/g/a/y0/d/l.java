package g.a.y0.d;

import g.a.i0;

/* compiled from: DeferredScalarDisposable.java */
/* loaded from: classes2.dex */
public class l<T> extends b<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final i0<? super T> actual;
    protected T value;

    public l(i0<? super T> i0Var) {
        this.actual = i0Var;
    }

    @Override // g.a.y0.c.o
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t) {
        int i2 = get();
        if ((i2 & 54) != 0) {
            return;
        }
        if (i2 == 8) {
            this.value = t;
            lazySet(16);
        } else {
            lazySet(2);
        }
        i0<? super T> i0Var = this.actual;
        i0Var.onNext(t);
        if (get() != 4) {
            i0Var.onComplete();
        }
    }

    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            g.a.c1.a.b(th);
        } else {
            lazySet(2);
            this.actual.onError(th);
        }
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // g.a.y0.c.o
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // g.a.y0.c.o
    @g.a.t0.g
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t = this.value;
        this.value = null;
        lazySet(32);
        return t;
    }

    @Override // g.a.y0.c.k
    public final int requestFusion(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }

    public final void complete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.actual.onComplete();
    }
}
