package h.k2.l;

import h.k2.l.e;
import h.q2.s.p;
import h.q2.t.i0;
import h.t0;

/* compiled from: CoroutineContextImpl.kt */
@t0(version = "1.1")
/* loaded from: classes2.dex */
public abstract class a implements e.b {

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final e.c<?> f16252b;

    public a(@i.c.a.d e.c<?> cVar) {
        i0.f(cVar, "key");
        this.f16252b = cVar;
    }

    @Override // h.k2.l.e.b, h.k2.l.e
    @i.c.a.e
    public <E extends e.b> E a(@i.c.a.d e.c<E> cVar) {
        i0.f(cVar, "key");
        return (E) e.b.a.a(this, cVar);
    }

    @Override // h.k2.l.e.b, h.k2.l.e
    @i.c.a.d
    public e b(@i.c.a.d e.c<?> cVar) {
        i0.f(cVar, "key");
        return e.b.a.b(this, cVar);
    }

    @Override // h.k2.l.e.b, h.k2.l.e
    public <R> R fold(R r, @i.c.a.d p<? super R, ? super e.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return (R) e.b.a.a(this, r, pVar);
    }

    @Override // h.k2.l.e.b
    @i.c.a.d
    public e.c<?> getKey() {
        return this.f16252b;
    }

    @Override // h.k2.l.e
    @i.c.a.d
    public e a(@i.c.a.d e eVar) {
        i0.f(eVar, com.umeng.analytics.pro.d.R);
        return e.b.a.a(this, eVar);
    }
}
