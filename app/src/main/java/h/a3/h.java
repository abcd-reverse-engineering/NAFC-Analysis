package h.a3;

import h.q2.t.i0;
import h.t0;
import java.util.concurrent.TimeUnit;

/* compiled from: DurationUnitJvm.kt */
/* loaded from: classes2.dex */
class h {
    @j
    @t0(version = "1.3")
    public static final double a(double d2, @i.c.a.d TimeUnit timeUnit, @i.c.a.d TimeUnit timeUnit2) {
        i0.f(timeUnit, "sourceUnit");
        i0.f(timeUnit2, "targetUnit");
        long jConvert = timeUnit2.convert(1L, timeUnit);
        return jConvert > 0 ? d2 * jConvert : d2 / timeUnit.convert(1L, timeUnit2);
    }

    @j
    @t0(version = "1.3")
    public static /* synthetic */ void a() {
    }
}
