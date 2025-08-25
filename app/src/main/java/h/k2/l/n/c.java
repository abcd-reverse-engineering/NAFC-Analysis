package h.k2.l.n;

import h.a0;
import h.m2.f;
import h.q2.s.l;
import h.q2.t.f0;
import h.t0;
import i.c.a.d;

/* compiled from: Intrinsics.kt */
/* loaded from: classes2.dex */
class c extends b {
    @f
    @t0(version = "1.2")
    private static final <T> h.k2.l.c<T> a(@d h.k2.l.c<? super T> cVar) {
        throw new a0("Implementation of intercepted is intrinsic");
    }

    @f
    @t0(version = "1.1")
    private static final <T> Object b(l<? super h.k2.l.c<? super T>, ? extends Object> lVar, h.k2.l.c<? super T> cVar) {
        f0.c(0);
        Object objInvoke = lVar.invoke(h.k2.l.o.a.b.a(cVar));
        f0.c(1);
        return objInvoke;
    }

    @f
    @t0(version = "1.2")
    private static final <T> Object c(l<? super h.k2.l.c<? super T>, ? extends Object> lVar, h.k2.l.c<? super T> cVar) {
        throw new a0("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic");
    }
}
