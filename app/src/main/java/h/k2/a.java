package h.k2;

import h.k2.g;
import h.q2.s.p;
import h.q2.t.i0;
import h.t0;

/* compiled from: CoroutineContextImpl.kt */
@t0(version = "1.3")
/* loaded from: classes2.dex */
public abstract class a implements g.b {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final g.c<?> f16242a;

    public a(@i.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        this.f16242a = cVar;
    }

    @Override // h.k2.g.b, h.k2.g
    public <R> R fold(R r, @i.c.a.d p<? super R, ? super g.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return (R) g.b.a.a(this, r, pVar);
    }

    @Override // h.k2.g.b, h.k2.g
    @i.c.a.e
    public <E extends g.b> E get(@i.c.a.d g.c<E> cVar) {
        i0.f(cVar, "key");
        return (E) g.b.a.a(this, cVar);
    }

    @Override // h.k2.g.b
    @i.c.a.d
    public g.c<?> getKey() {
        return this.f16242a;
    }

    @Override // h.k2.g.b, h.k2.g
    @i.c.a.d
    public g minusKey(@i.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        return g.b.a.b(this, cVar);
    }

    @Override // h.k2.g
    @i.c.a.d
    public g plus(@i.c.a.d g gVar) {
        i0.f(gVar, com.umeng.analytics.pro.d.R);
        return g.b.a.a(this, gVar);
    }
}
