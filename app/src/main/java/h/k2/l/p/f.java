package h.k2.l.p;

import h.k2.l.d;
import h.k2.l.e;
import h.q2.s.p;
import h.q2.t.i0;

/* compiled from: CoroutinesMigration.kt */
/* loaded from: classes2.dex */
final class f implements h.k2.l.d {

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final h.k2.e f16292b;

    public f(@i.c.a.d h.k2.e eVar) {
        i0.f(eVar, "interceptor");
        this.f16292b = eVar;
    }

    @Override // h.k2.l.e.b, h.k2.l.e
    @i.c.a.e
    public <E extends e.b> E a(@i.c.a.d e.c<E> cVar) {
        i0.f(cVar, "key");
        return (E) d.a.a(this, cVar);
    }

    @Override // h.k2.l.e.b, h.k2.l.e
    @i.c.a.d
    public h.k2.l.e b(@i.c.a.d e.c<?> cVar) {
        i0.f(cVar, "key");
        return d.a.b(this, cVar);
    }

    @Override // h.k2.l.e.b, h.k2.l.e
    public <R> R fold(R r, @i.c.a.d p<? super R, ? super e.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return (R) d.a.a(this, r, pVar);
    }

    @Override // h.k2.l.e.b
    @i.c.a.d
    public e.c<?> getKey() {
        return h.k2.l.d.f16255a;
    }

    @i.c.a.d
    public final h.k2.e a() {
        return this.f16292b;
    }

    @Override // h.k2.l.e
    @i.c.a.d
    public h.k2.l.e a(@i.c.a.d h.k2.l.e eVar) {
        i0.f(eVar, com.umeng.analytics.pro.d.R);
        return d.a.a(this, eVar);
    }

    @Override // h.k2.l.d
    @i.c.a.d
    public <T> h.k2.l.c<T> a(@i.c.a.d h.k2.l.c<? super T> cVar) {
        i0.f(cVar, "continuation");
        return d.a(this.f16292b.b(d.a(cVar)));
    }
}
