package g.a.y0.e.b;

/* compiled from: AbstractFlowableWithUpstream.java */
/* loaded from: classes2.dex */
abstract class a<T, R> extends g.a.l<R> implements g.a.y0.c.h<T> {

    /* renamed from: b, reason: collision with root package name */
    protected final g.a.l<T> f14110b;

    a(g.a.l<T> lVar) {
        this.f14110b = (g.a.l) g.a.y0.b.b.a(lVar, "source is null");
    }

    @Override // g.a.y0.c.h
    public final i.d.b<T> source() {
        return this.f14110b;
    }
}
