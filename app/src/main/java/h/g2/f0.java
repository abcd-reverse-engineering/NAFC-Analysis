package h.g2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: _CollectionsJvm.kt */
/* loaded from: classes2.dex */
class f0 extends e0 {
    @i.c.a.d
    public static final <R> List<R> a(@i.c.a.d Iterable<?> iterable, @i.c.a.d Class<R> cls) {
        h.q2.t.i0.f(iterable, "$this$filterIsInstance");
        h.q2.t.i0.f(cls, "klass");
        return (List) a(iterable, new ArrayList(), cls);
    }

    @i.c.a.d
    public static final <T extends Comparable<? super T>> SortedSet<T> f(@i.c.a.d Iterable<? extends T> iterable) {
        h.q2.t.i0.f(iterable, "$this$toSortedSet");
        return (SortedSet) g0.c((Iterable) iterable, new TreeSet());
    }

    public static <T> void j(@i.c.a.d List<T> list) {
        h.q2.t.i0.f(list, "$this$reverse");
        Collections.reverse(list);
    }

    @i.c.a.d
    public static final <C extends Collection<? super R>, R> C a(@i.c.a.d Iterable<?> iterable, @i.c.a.d C c2, @i.c.a.d Class<R> cls) {
        h.q2.t.i0.f(iterable, "$this$filterIsInstanceTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(cls, "klass");
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @i.c.a.d
    public static final <T> SortedSet<T> a(@i.c.a.d Iterable<? extends T> iterable, @i.c.a.d Comparator<? super T> comparator) {
        h.q2.t.i0.f(iterable, "$this$toSortedSet");
        h.q2.t.i0.f(comparator, "comparator");
        return (SortedSet) g0.c((Iterable) iterable, new TreeSet(comparator));
    }
}
