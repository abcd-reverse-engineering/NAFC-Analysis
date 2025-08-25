package g.a.y0.e.c;

/* compiled from: MaybeToPublisher.java */
/* loaded from: classes2.dex */
public enum m1 implements g.a.x0.o<g.a.y<Object>, i.d.b<Object>> {
    INSTANCE;

    public static <T> g.a.x0.o<g.a.y<T>, i.d.b<T>> instance() {
        return INSTANCE;
    }

    @Override // g.a.x0.o
    public i.d.b<Object> apply(g.a.y<Object> yVar) throws Exception {
        return new k1(yVar);
    }
}
