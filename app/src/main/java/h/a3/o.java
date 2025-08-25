package h.a3;

import h.t0;

/* compiled from: TimeSource.kt */
@j
@t0(version = "1.3")
/* loaded from: classes2.dex */
public abstract class o {
    public abstract double a();

    @i.c.a.d
    public o a(double d2) {
        return b(d.y(d2));
    }

    @i.c.a.d
    public o b(double d2) {
        return new c(this, d2, null);
    }

    public final boolean c() {
        return !d.s(a());
    }

    public final boolean b() {
        return d.s(a());
    }
}
