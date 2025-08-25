package h.u2;

import h.m2.l;
import h.q2.t.i0;
import h.t0;
import java.util.Random;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final double a(int i2, int i3) {
        return ((i2 << 27) + i3) / 9007199254740992L;
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final Random a(@i.c.a.d f fVar) {
        Random randomG;
        i0.f(fVar, "$this$asJavaRandom");
        a aVar = (a) (!(fVar instanceof a) ? null : fVar);
        return (aVar == null || (randomG = aVar.g()) == null) ? new c(fVar) : randomG;
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final f a(@i.c.a.d Random random) {
        f impl;
        i0.f(random, "$this$asKotlinRandom");
        c cVar = (c) (!(random instanceof c) ? null : random);
        return (cVar == null || (impl = cVar.getImpl()) == null) ? new d(random) : impl;
    }

    @h.m2.f
    private static final f a() {
        return l.f16311a.a();
    }
}
