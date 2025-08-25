package h.y2;

import h.q2.e;
import h.q2.t.i0;
import h.y1;
import i.c.a.d;

/* compiled from: Timing.kt */
@e(name = "TimingKt")
/* loaded from: classes2.dex */
public final class b {
    public static final long a(@d h.q2.s.a<y1> aVar) {
        i0.f(aVar, "block");
        long jNanoTime = System.nanoTime();
        aVar.invoke();
        return System.nanoTime() - jNanoTime;
    }

    public static final long b(@d h.q2.s.a<y1> aVar) {
        i0.f(aVar, "block");
        long jCurrentTimeMillis = System.currentTimeMillis();
        aVar.invoke();
        return System.currentTimeMillis() - jCurrentTimeMillis;
    }
}
