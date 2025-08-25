package h.g2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: classes2.dex */
public class c0 extends b0 {
    @h.m2.f
    @h.c(level = h.d.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @h.o0(expression = "this.sortWith(comparator)", imports = {}))
    private static final <T> void a(@i.c.a.d List<T> list, Comparator<? super T> comparator) {
        throw new h.a0(null, 1, null);
    }

    public static <T> void b(@i.c.a.d List<T> list, @i.c.a.d Comparator<? super T> comparator) {
        h.q2.t.i0.f(list, "$this$sortWith");
        h.q2.t.i0.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    @h.m2.f
    @h.t0(version = "1.2")
    private static final <T> void c(@i.c.a.d List<T> list) {
        Collections.shuffle(list);
    }

    public static <T extends Comparable<? super T>> void d(@i.c.a.d List<T> list) {
        h.q2.t.i0.f(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @h.t0(version = "1.2")
    @i.c.a.d
    public static final <T> List<T> e(@i.c.a.d Iterable<? extends T> iterable) {
        h.q2.t.i0.f(iterable, "$this$shuffled");
        List<T> listO = g0.O(iterable);
        Collections.shuffle(listO);
        return listO;
    }

    @h.m2.f
    @h.c(level = h.d.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @h.o0(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    private static final <T> void a(@i.c.a.d List<T> list, h.q2.s.p<? super T, ? super T, Integer> pVar) {
        throw new h.a0(null, 1, null);
    }

    @h.m2.f
    @h.t0(version = "1.2")
    private static final <T> void a(@i.c.a.d List<T> list, T t) {
        Collections.fill(list, t);
    }

    @h.m2.f
    @h.t0(version = "1.2")
    private static final <T> void a(@i.c.a.d List<T> list, Random random) {
        Collections.shuffle(list, random);
    }

    @h.t0(version = "1.2")
    @i.c.a.d
    public static final <T> List<T> a(@i.c.a.d Iterable<? extends T> iterable, @i.c.a.d Random random) {
        h.q2.t.i0.f(iterable, "$this$shuffled");
        h.q2.t.i0.f(random, "random");
        List<T> listO = g0.O(iterable);
        Collections.shuffle(listO, random);
        return listO;
    }
}
