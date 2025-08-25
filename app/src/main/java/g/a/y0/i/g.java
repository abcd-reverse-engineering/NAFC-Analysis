package g.a.y0.i;

import g.a.y0.c.l;

/* compiled from: EmptySubscription.java */
/* loaded from: classes2.dex */
public enum g implements l<Object> {
    INSTANCE;

    public static void complete(i.d.c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void error(Throwable th, i.d.c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    @Override // i.d.d
    public void cancel() {
    }

    @Override // g.a.y0.c.o
    public void clear() {
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
    public Object poll() {
        return null;
    }

    @Override // i.d.d
    public void request(long j2) {
        j.validate(j2);
    }

    @Override // g.a.y0.c.k
    public int requestFusion(int i2) {
        return i2 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // g.a.y0.c.o
    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
