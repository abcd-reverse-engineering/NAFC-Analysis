package h.g2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: SetsJVM.kt */
/* loaded from: classes2.dex */
class l1 {
    @i.c.a.d
    public static <T> Set<T> a(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        h.q2.t.i0.a((Object) setSingleton, "java.util.Collections.singleton(element)");
        return setSingleton;
    }

    @i.c.a.d
    public static final <T> TreeSet<T> a(@i.c.a.d T... tArr) {
        h.q2.t.i0.f(tArr, "elements");
        return (TreeSet) r.e((Object[]) tArr, new TreeSet());
    }

    @i.c.a.d
    public static final <T> TreeSet<T> a(@i.c.a.d Comparator<? super T> comparator, @i.c.a.d T... tArr) {
        h.q2.t.i0.f(comparator, "comparator");
        h.q2.t.i0.f(tArr, "elements");
        return (TreeSet) r.e((Object[]) tArr, new TreeSet(comparator));
    }
}
