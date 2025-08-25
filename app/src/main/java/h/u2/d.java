package h.u2;

import h.q2.t.i0;
import java.util.Random;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes2.dex */
final class d extends a {

    /* renamed from: d, reason: collision with root package name */
    @i.c.a.d
    private final Random f16496d;

    public d(@i.c.a.d Random random) {
        i0.f(random, "impl");
        this.f16496d = random;
    }

    @Override // h.u2.a
    @i.c.a.d
    public Random g() {
        return this.f16496d;
    }
}
