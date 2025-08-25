package h.h2;

import h.q2.t.i0;
import h.t0;
import java.util.Comparator;

/* compiled from: _Comparisons.kt */
/* loaded from: classes2.dex */
class d extends c {
    @t0(version = "1.1")
    public static final <T> T a(T t, T t2, T t3, @i.c.a.d Comparator<? super T> comparator) {
        i0.f(comparator, "comparator");
        return (T) a(t, a(t2, t3, comparator), comparator);
    }

    @t0(version = "1.1")
    public static final <T> T b(T t, T t2, T t3, @i.c.a.d Comparator<? super T> comparator) {
        i0.f(comparator, "comparator");
        return (T) b(t, b(t2, t3, comparator), comparator);
    }

    @t0(version = "1.1")
    public static final <T> T a(T t, T t2, @i.c.a.d Comparator<? super T> comparator) {
        i0.f(comparator, "comparator");
        return comparator.compare(t, t2) >= 0 ? t : t2;
    }

    @t0(version = "1.1")
    public static final <T> T b(T t, T t2, @i.c.a.d Comparator<? super T> comparator) {
        i0.f(comparator, "comparator");
        return comparator.compare(t, t2) <= 0 ? t : t2;
    }
}
