package h.k2;

import h.k2.g;
import h.q2.s.p;
import h.q2.t.i0;
import h.t0;
import java.io.Serializable;

/* compiled from: CoroutineContextImpl.kt */
@t0(version = "1.3")
/* loaded from: classes2.dex */
public final class i implements g, Serializable {
    public static final i INSTANCE = new i();
    private static final long serialVersionUID = 0;

    private i() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // h.k2.g
    public <R> R fold(R r, @i.c.a.d p<? super R, ? super g.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return r;
    }

    @Override // h.k2.g
    @i.c.a.e
    public <E extends g.b> E get(@i.c.a.d g.c<E> cVar) {
        i0.f(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // h.k2.g
    @i.c.a.d
    public g minusKey(@i.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        return this;
    }

    @Override // h.k2.g
    @i.c.a.d
    public g plus(@i.c.a.d g gVar) {
        i0.f(gVar, com.umeng.analytics.pro.d.R);
        return gVar;
    }

    @i.c.a.d
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
