package h.a3;

import h.a3.p;
import h.q2.t.i0;
import h.t0;
import h.y1;

/* compiled from: measureTime.kt */
/* loaded from: classes2.dex */
public final class l {
    @j
    @t0(version = "1.3")
    public static final double a(@i.c.a.d h.q2.s.a<y1> aVar) {
        i0.f(aVar, "block");
        o oVarA = p.b.f16091c.a();
        aVar.invoke();
        return oVarA.a();
    }

    @j
    @t0(version = "1.3")
    @i.c.a.d
    public static final <T> s<T> b(@i.c.a.d h.q2.s.a<? extends T> aVar) {
        i0.f(aVar, "block");
        return new s<>(aVar.invoke(), p.b.f16091c.a().a(), null);
    }

    @j
    @t0(version = "1.3")
    public static final double a(@i.c.a.d p pVar, @i.c.a.d h.q2.s.a<y1> aVar) {
        i0.f(pVar, "$this$measureTime");
        i0.f(aVar, "block");
        o oVarA = pVar.a();
        aVar.invoke();
        return oVarA.a();
    }

    @j
    @t0(version = "1.3")
    @i.c.a.d
    public static final <T> s<T> b(@i.c.a.d p pVar, @i.c.a.d h.q2.s.a<? extends T> aVar) {
        i0.f(pVar, "$this$measureTimedValue");
        i0.f(aVar, "block");
        return new s<>(aVar.invoke(), pVar.a().a(), null);
    }
}
