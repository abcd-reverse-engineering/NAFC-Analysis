package h.k2.l;

import h.k2.l.e;
import h.q2.s.p;
import h.q2.t.i0;
import h.t0;

/* compiled from: CoroutineContextImpl.kt */
@t0(version = "1.1")
/* loaded from: classes2.dex */
public final class g implements e {

    /* renamed from: b, reason: collision with root package name */
    public static final g f16257b = new g();

    private g() {
    }

    @Override // h.k2.l.e
    @i.c.a.e
    public <E extends e.b> E a(@i.c.a.d e.c<E> cVar) {
        i0.f(cVar, "key");
        return null;
    }

    @Override // h.k2.l.e
    @i.c.a.d
    public e a(@i.c.a.d e eVar) {
        i0.f(eVar, com.umeng.analytics.pro.d.R);
        return eVar;
    }

    @Override // h.k2.l.e
    @i.c.a.d
    public e b(@i.c.a.d e.c<?> cVar) {
        i0.f(cVar, "key");
        return this;
    }

    @Override // h.k2.l.e
    public <R> R fold(R r, @i.c.a.d p<? super R, ? super e.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return r;
    }

    public int hashCode() {
        return 0;
    }

    @i.c.a.d
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
