package g.a.y0.i;

/* compiled from: DeferredScalarSubscription.java */
/* loaded from: classes2.dex */
public class f<T> extends c<T> {
    static final int CANCELLED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    protected final i.d.c<? super T> actual;
    protected T value;

    public f(i.d.c<? super T> cVar) {
        this.actual = cVar;
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    @Override // g.a.y0.c.o
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t) {
        int i2 = get();
        while (i2 != 8) {
            if ((i2 & (-3)) != 0) {
                return;
            }
            if (i2 == 2) {
                lazySet(3);
                i.d.c<? super T> cVar = this.actual;
                cVar.onNext(t);
                if (get() != 4) {
                    cVar.onComplete();
                    return;
                }
                return;
            }
            this.value = t;
            if (compareAndSet(0, 1)) {
                return;
            }
            i2 = get();
            if (i2 == 4) {
                this.value = null;
                return;
            }
        }
        this.value = t;
        lazySet(16);
        i.d.c<? super T> cVar2 = this.actual;
        cVar2.onNext(t);
        if (get() != 4) {
            cVar2.onComplete();
        }
    }

    public final boolean isCancelled() {
        return get() == 4;
    }

    @Override // g.a.y0.c.o
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // g.a.y0.c.o
    @g.a.t0.g
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t = this.value;
        this.value = null;
        return t;
    }

    @Override // i.d.d
    public final void request(long j2) {
        T t;
        if (j.validate(j2)) {
            do {
                int i2 = get();
                if ((i2 & (-2)) != 0) {
                    return;
                }
                if (i2 == 1) {
                    if (!compareAndSet(1, 3) || (t = this.value) == null) {
                        return;
                    }
                    this.value = null;
                    i.d.c<? super T> cVar = this.actual;
                    cVar.onNext(t);
                    if (get() != 4) {
                        cVar.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    @Override // g.a.y0.c.k
    public final int requestFusion(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryCancel() {
        return getAndSet(4) != 4;
    }
}
