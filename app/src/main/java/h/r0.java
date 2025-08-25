package h;

import h.q0;

/* compiled from: Result.kt */
/* loaded from: classes2.dex */
public final class r0 {
    @t0(version = "1.3")
    @n0
    @i.c.a.d
    public static final Object a(@i.c.a.d Throwable th) {
        h.q2.t.i0.f(th, "exception");
        return new q0.b(th);
    }

    @t0(version = "1.3")
    @n0
    public static final void b(@i.c.a.d Object obj) {
        if (obj instanceof q0.b) {
            throw ((q0.b) obj).exception;
        }
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <R, T> Object c(@i.c.a.d Object obj, h.q2.s.l<? super T, ? extends R> lVar) {
        if (!q0.m778isSuccessimpl(obj)) {
            return q0.m772constructorimpl(obj);
        }
        try {
            q0.a aVar = q0.Companion;
            return q0.m772constructorimpl(lVar.invoke(obj));
        } catch (Throwable th) {
            q0.a aVar2 = q0.Companion;
            return q0.m772constructorimpl(a(th));
        }
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <T> Object d(@i.c.a.d Object obj, h.q2.s.l<? super Throwable, y1> lVar) {
        Throwable thM775exceptionOrNullimpl = q0.m775exceptionOrNullimpl(obj);
        if (thM775exceptionOrNullimpl != null) {
            lVar.invoke(thM775exceptionOrNullimpl);
        }
        return obj;
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <T> Object e(@i.c.a.d Object obj, h.q2.s.l<? super T, y1> lVar) {
        if (q0.m778isSuccessimpl(obj)) {
            lVar.invoke(obj);
        }
        return obj;
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <R, T extends R> Object f(@i.c.a.d Object obj, h.q2.s.l<? super Throwable, ? extends R> lVar) {
        Throwable thM775exceptionOrNullimpl = q0.m775exceptionOrNullimpl(obj);
        if (thM775exceptionOrNullimpl == null) {
            return obj;
        }
        q0.a aVar = q0.Companion;
        return q0.m772constructorimpl(lVar.invoke(thM775exceptionOrNullimpl));
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <R, T extends R> Object g(@i.c.a.d Object obj, h.q2.s.l<? super Throwable, ? extends R> lVar) {
        Throwable thM775exceptionOrNullimpl = q0.m775exceptionOrNullimpl(obj);
        if (thM775exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            q0.a aVar = q0.Companion;
            return q0.m772constructorimpl(lVar.invoke(thM775exceptionOrNullimpl));
        } catch (Throwable th) {
            q0.a aVar2 = q0.Companion;
            return q0.m772constructorimpl(a(th));
        }
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <T, R> Object h(T t, h.q2.s.l<? super T, ? extends R> lVar) {
        try {
            q0.a aVar = q0.Companion;
            return q0.m772constructorimpl(lVar.invoke(t));
        } catch (Throwable th) {
            q0.a aVar2 = q0.Companion;
            return q0.m772constructorimpl(a(th));
        }
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <R> Object a(h.q2.s.a<? extends R> aVar) {
        try {
            q0.a aVar2 = q0.Companion;
            return q0.m772constructorimpl(aVar.invoke());
        } catch (Throwable th) {
            q0.a aVar3 = q0.Companion;
            return q0.m772constructorimpl(a(th));
        }
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <R, T> Object b(@i.c.a.d Object obj, h.q2.s.l<? super T, ? extends R> lVar) {
        if (!q0.m778isSuccessimpl(obj)) {
            return q0.m772constructorimpl(obj);
        }
        q0.a aVar = q0.Companion;
        return q0.m772constructorimpl(lVar.invoke(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    @t0(version = "1.3")
    private static final <T> T a(@i.c.a.d Object obj) {
        b(obj);
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    @t0(version = "1.3")
    private static final <R, T extends R> R a(@i.c.a.d Object obj, h.q2.s.l<? super Throwable, ? extends R> lVar) {
        Throwable thM775exceptionOrNullimpl = q0.m775exceptionOrNullimpl(obj);
        return thM775exceptionOrNullimpl == null ? obj : lVar.invoke(thM775exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    @t0(version = "1.3")
    private static final <R, T extends R> R a(@i.c.a.d Object obj, R r) {
        return q0.m777isFailureimpl(obj) ? r : obj;
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final <R, T> R a(@i.c.a.d Object obj, h.q2.s.l<? super T, ? extends R> lVar, h.q2.s.l<? super Throwable, ? extends R> lVar2) {
        Throwable thM775exceptionOrNullimpl = q0.m775exceptionOrNullimpl(obj);
        if (thM775exceptionOrNullimpl == null) {
            return lVar.invoke(obj);
        }
        return lVar2.invoke(thM775exceptionOrNullimpl);
    }
}
