package h.a3;

import com.umeng.analytics.pro.bh;
import h.q2.t.i0;
import h.t0;
import h.z;
import java.util.concurrent.TimeUnit;

/* compiled from: DurationUnit.kt */
/* loaded from: classes2.dex */
class i extends h {
    @j
    @t0(version = "1.3")
    @i.c.a.d
    public static final String a(@i.c.a.d TimeUnit timeUnit) {
        i0.f(timeUnit, "$this$shortName");
        switch (f.f16082a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return bh.aE;
            case 5:
                return "m";
            case 6:
                return bh.aJ;
            case 7:
                return "d";
            default:
                throw new z();
        }
    }
}
