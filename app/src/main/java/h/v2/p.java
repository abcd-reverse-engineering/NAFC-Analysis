package h.v2;

import h.q2.t.i0;
import h.t0;

/* compiled from: Ranges.kt */
/* loaded from: classes2.dex */
class p {
    @i.c.a.d
    public static final <T extends Comparable<? super T>> g<T> a(@i.c.a.d T t, @i.c.a.d T t2) {
        i0.f(t, "$this$rangeTo");
        i0.f(t2, "that");
        return new h(t, t2);
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final f<Double> a(double d2, double d3) {
        return new d(d2, d3);
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final f<Float> a(float f2, float f3) {
        return new e(f2, f3);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Ljava/lang/Iterable<+TT;>;:Lh/v2/g<TT;>;>(TR;TT;)Z */
    @h.m2.f
    @t0(version = "1.3")
    private static final boolean a(@i.c.a.d Iterable iterable, Object obj) {
        i0.f(iterable, "$this$contains");
        return obj != null && ((g) iterable).contains((Comparable) obj);
    }

    public static final void a(boolean z, @i.c.a.d Number number) {
        i0.f(number, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
