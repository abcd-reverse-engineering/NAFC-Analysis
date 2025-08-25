package h.k2.l;

import h.a0;
import h.e1;
import h.q2.s.p;
import h.q2.t.f0;
import h.q2.t.i0;
import h.t0;
import h.y1;

/* compiled from: CoroutinesLibrary.kt */
@h.q2.e(name = "CoroutinesKt")
/* loaded from: classes2.dex */
public final class f {
    @t0(version = "1.1")
    @i.c.a.d
    public static final <R, T> c<y1> a(@i.c.a.d p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, @i.c.a.d c<? super T> cVar) {
        i0.f(pVar, "$this$createCoroutine");
        i0.f(cVar, "completion");
        return new i(h.k2.l.n.b.a(pVar, r, cVar), h.k2.l.n.b.b());
    }

    @h.m2.f
    @t0(version = "1.2")
    public static /* synthetic */ void a() {
    }

    @t0(version = "1.1")
    public static final <R, T> void b(@i.c.a.d p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, @i.c.a.d c<? super T> cVar) {
        i0.f(pVar, "$this$startCoroutine");
        i0.f(cVar, "completion");
        h.k2.l.n.b.a(pVar, r, cVar).resume(y1.f16671a);
    }

    @t0(version = "1.1")
    @i.c.a.e
    public static final <T> Object c(@i.c.a.d h.q2.s.l<? super c<? super T>, y1> lVar, @i.c.a.d c<? super T> cVar) {
        i iVar = new i(h.k2.l.o.a.b.a(cVar));
        lVar.invoke(iVar);
        return iVar.a();
    }

    @t0(version = "1.1")
    @i.c.a.e
    private static final Object d(@i.c.a.d h.q2.s.l lVar, @i.c.a.d c cVar) throws Throwable {
        f0.c(0);
        i iVar = new i(h.k2.l.o.a.b.a(cVar));
        lVar.invoke(iVar);
        Object objA = iVar.a();
        f0.c(1);
        return objA;
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final <T> c<y1> a(@i.c.a.d h.q2.s.l<? super c<? super T>, ? extends Object> lVar, @i.c.a.d c<? super T> cVar) {
        i0.f(lVar, "$this$createCoroutine");
        i0.f(cVar, "completion");
        return new i(h.k2.l.n.b.a(lVar, cVar), h.k2.l.n.b.b());
    }

    @t0(version = "1.1")
    public static final <T> void b(@i.c.a.d h.q2.s.l<? super c<? super T>, ? extends Object> lVar, @i.c.a.d c<? super T> cVar) {
        i0.f(lVar, "$this$startCoroutine");
        i0.f(cVar, "completion");
        h.k2.l.n.b.a(lVar, cVar).resume(y1.f16671a);
    }

    @h.m2.f
    private static final void a(c<?> cVar, h.q2.s.a<? extends Object> aVar) {
        try {
            Object objInvoke = aVar.invoke();
            if (objInvoke != h.k2.l.n.b.b()) {
                if (cVar == null) {
                    throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                cVar.resume(objInvoke);
            }
        } catch (Throwable th) {
            cVar.resumeWithException(th);
        }
    }

    private static final e b() {
        throw new a0("Implemented as intrinsic");
    }
}
