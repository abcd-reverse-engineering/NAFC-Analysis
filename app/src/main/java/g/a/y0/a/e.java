package g.a.y0.a;

import g.a.i0;
import g.a.n0;
import g.a.v;

/* compiled from: EmptyDisposable.java */
/* loaded from: classes2.dex */
public enum e implements g.a.y0.c.j<Object> {
    INSTANCE,
    NEVER;

    public static void complete(i0<?> i0Var) {
        i0Var.onSubscribe(INSTANCE);
        i0Var.onComplete();
    }

    public static void error(Throwable th, i0<?> i0Var) {
        i0Var.onSubscribe(INSTANCE);
        i0Var.onError(th);
    }

    @Override // g.a.y0.c.o
    public void clear() {
    }

    @Override // g.a.u0.c
    public void dispose() {
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // g.a.y0.c.o
    public boolean isEmpty() {
        return true;
    }

    @Override // g.a.y0.c.o
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // g.a.y0.c.o
    @g.a.t0.g
    public Object poll() throws Exception {
        return null;
    }

    @Override // g.a.y0.c.k
    public int requestFusion(int i2) {
        return i2 & 2;
    }

    @Override // g.a.y0.c.o
    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(v<?> vVar) {
        vVar.onSubscribe(INSTANCE);
        vVar.onComplete();
    }

    public static void error(Throwable th, g.a.f fVar) {
        fVar.onSubscribe(INSTANCE);
        fVar.onError(th);
    }

    public static void complete(g.a.f fVar) {
        fVar.onSubscribe(INSTANCE);
        fVar.onComplete();
    }

    public static void error(Throwable th, n0<?> n0Var) {
        n0Var.onSubscribe(INSTANCE);
        n0Var.onError(th);
    }

    public static void error(Throwable th, v<?> vVar) {
        vVar.onSubscribe(INSTANCE);
        vVar.onError(th);
    }
}
