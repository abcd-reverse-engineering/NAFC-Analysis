package h.a3;

import h.o0;
import h.q2.t.i0;
import h.t0;

/* compiled from: TimeSource.kt */
/* loaded from: classes2.dex */
public final class q {
    @j
    @h.m2.f
    @t0(version = "1.3")
    @h.c(level = h.d.ERROR, message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    private static final int a(@i.c.a.d o oVar, o oVar2) {
        i0.f(oVar, "$this$compareTo");
        throw new Error("Operation is disallowed.");
    }

    @j
    @t0(version = "1.3")
    @h.c(message = "Use TimeSource interface instead.", replaceWith = @o0(expression = "TimeSource", imports = {"kotlin.time.TimeSource"}))
    public static /* synthetic */ void a() {
    }

    @j
    @h.m2.f
    @t0(version = "1.3")
    @h.c(level = h.d.ERROR, message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    private static final double b(@i.c.a.d o oVar, o oVar2) {
        i0.f(oVar, "$this$minus");
        throw new Error("Operation is disallowed.");
    }

    @j
    @t0(version = "1.3")
    @h.c(message = "Use TimeMark class instead.", replaceWith = @o0(expression = "TimeMark", imports = {"kotlin.time.TimeMark"}))
    public static /* synthetic */ void b() {
    }
}
