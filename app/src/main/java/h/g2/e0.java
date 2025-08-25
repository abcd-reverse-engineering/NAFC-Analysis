package h.g2;

import java.util.List;

/* compiled from: ReversedViews.kt */
/* loaded from: classes2.dex */
class e0 extends d0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(@i.c.a.d List<?> list, int i2) {
        int iA = y.a((List) list);
        if (i2 >= 0 && iA >= i2) {
            return y.a((List) list) - i2;
        }
        throw new IndexOutOfBoundsException("Element index " + i2 + " must be in range [" + new h.v2.k(0, y.a((List) list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(@i.c.a.d List<?> list, int i2) {
        int size = list.size();
        if (i2 >= 0 && size >= i2) {
            return list.size() - i2;
        }
        throw new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new h.v2.k(0, list.size()) + "].");
    }

    @i.c.a.d
    public static final <T> List<T> h(@i.c.a.d List<? extends T> list) {
        h.q2.t.i0.f(list, "$this$asReversed");
        return new i1(list);
    }

    @h.q2.e(name = "asReversedMutable")
    @i.c.a.d
    public static final <T> List<T> i(@i.c.a.d List<T> list) {
        h.q2.t.i0.f(list, "$this$asReversed");
        return new h1(list);
    }
}
