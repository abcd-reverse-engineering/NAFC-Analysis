package h.g2;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: _Sets.kt */
/* loaded from: classes2.dex */
class n1 extends m1 {
    @i.c.a.d
    public static final <T> Set<T> a(@i.c.a.d Set<? extends T> set, T t) {
        h.q2.t.i0.f(set, "$this$minus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(set.size()));
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && h.q2.t.i0.a(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    @h.m2.f
    private static final <T> Set<T> b(@i.c.a.d Set<? extends T> set, T t) {
        return a(set, t);
    }

    @i.c.a.d
    public static final <T> Set<T> c(@i.c.a.d Set<? extends T> set, T t) {
        h.q2.t.i0.f(set, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @h.m2.f
    private static final <T> Set<T> d(@i.c.a.d Set<? extends T> set, T t) {
        return c(set, t);
    }

    @i.c.a.d
    public static final <T> Set<T> b(@i.c.a.d Set<? extends T> set, @i.c.a.d T[] tArr) {
        h.q2.t.i0.f(set, "$this$plus");
        h.q2.t.i0.f(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(set.size() + tArr.length));
        linkedHashSet.addAll(set);
        d0.a((Collection) linkedHashSet, (Object[]) tArr);
        return linkedHashSet;
    }

    @i.c.a.d
    public static final <T> Set<T> a(@i.c.a.d Set<? extends T> set, @i.c.a.d T[] tArr) {
        h.q2.t.i0.f(set, "$this$minus");
        h.q2.t.i0.f(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        d0.d(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @i.c.a.d
    public static final <T> Set<T> b(@i.c.a.d Set<? extends T> set, @i.c.a.d Iterable<? extends T> iterable) {
        int size;
        h.q2.t.i0.f(set, "$this$plus");
        h.q2.t.i0.f(iterable, "elements");
        Integer numA = z.a((Iterable) iterable);
        if (numA != null) {
            size = set.size() + numA.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(size));
        linkedHashSet.addAll(set);
        d0.a((Collection) linkedHashSet, (Iterable) iterable);
        return linkedHashSet;
    }

    @i.c.a.d
    public static final <T> Set<T> a(@i.c.a.d Set<? extends T> set, @i.c.a.d Iterable<? extends T> iterable) {
        h.q2.t.i0.f(set, "$this$minus");
        h.q2.t.i0.f(iterable, "elements");
        Collection<?> collectionA = z.a(iterable, set);
        if (collectionA.isEmpty()) {
            return g0.Q(set);
        }
        if (collectionA instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!collectionA.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(collectionA);
        return linkedHashSet2;
    }

    @i.c.a.d
    public static final <T> Set<T> b(@i.c.a.d Set<? extends T> set, @i.c.a.d h.x2.m<? extends T> mVar) {
        h.q2.t.i0.f(set, "$this$plus");
        h.q2.t.i0.f(mVar, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(set.size() * 2));
        linkedHashSet.addAll(set);
        d0.a((Collection) linkedHashSet, (h.x2.m) mVar);
        return linkedHashSet;
    }

    @i.c.a.d
    public static final <T> Set<T> a(@i.c.a.d Set<? extends T> set, @i.c.a.d h.x2.m<? extends T> mVar) {
        h.q2.t.i0.f(set, "$this$minus");
        h.q2.t.i0.f(mVar, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        d0.d(linkedHashSet, mVar);
        return linkedHashSet;
    }
}
