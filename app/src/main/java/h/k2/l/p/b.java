package h.k2.l.p;

import h.k2.e;
import h.k2.g;
import h.q2.s.p;
import h.q2.t.i0;

/* compiled from: CoroutinesMigration.kt */
/* loaded from: classes2.dex */
final class b implements h.k2.e {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final h.k2.l.d f16287a;

    public b(@i.c.a.d h.k2.l.d dVar) {
        i0.f(dVar, "interceptor");
        this.f16287a = dVar;
    }

    @i.c.a.d
    public final h.k2.l.d a() {
        return this.f16287a;
    }

    @Override // h.k2.e
    @i.c.a.d
    public <T> h.k2.d<T> b(@i.c.a.d h.k2.d<? super T> dVar) {
        i0.f(dVar, "continuation");
        return d.a(this.f16287a.a(d.a(dVar)));
    }

    @Override // h.k2.g.b, h.k2.g
    public <R> R fold(R r, @i.c.a.d p<? super R, ? super g.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return (R) e.a.a(this, r, pVar);
    }

    @Override // h.k2.e, h.k2.g.b, h.k2.g
    @i.c.a.e
    public <E extends g.b> E get(@i.c.a.d g.c<E> cVar) {
        i0.f(cVar, "key");
        return (E) e.a.a(this, cVar);
    }

    @Override // h.k2.g.b
    @i.c.a.d
    public g.c<?> getKey() {
        return h.k2.e.V;
    }

    @Override // h.k2.e, h.k2.g.b, h.k2.g
    @i.c.a.d
    public h.k2.g minusKey(@i.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        return e.a.b(this, cVar);
    }

    @Override // h.k2.g
    @i.c.a.d
    public h.k2.g plus(@i.c.a.d h.k2.g gVar) {
        i0.f(gVar, com.umeng.analytics.pro.d.R);
        return e.a.a(this, gVar);
    }

    @Override // h.k2.e
    public void a(@i.c.a.d h.k2.d<?> dVar) {
        i0.f(dVar, "continuation");
        e.a.a(this, dVar);
    }
}
