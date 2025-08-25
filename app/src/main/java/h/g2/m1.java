package h.g2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sets.kt */
/* loaded from: classes2.dex */
public class m1 extends l1 {
    @i.c.a.d
    public static <T> Set<T> a() {
        return l0.INSTANCE;
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <T> HashSet<T> b() {
        return new HashSet<>();
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <T> LinkedHashSet<T> c() {
        return new LinkedHashSet<>();
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <T> Set<T> d() {
        return new LinkedHashSet();
    }

    @i.c.a.d
    public static final <T> Set<T> e(@i.c.a.d T... tArr) {
        h.q2.t.i0.f(tArr, "elements");
        return tArr.length > 0 ? r.M(tArr) : a();
    }

    @h.m2.f
    @h.t0(version = "1.3")
    @h.j
    private static final <E> Set<E> a(@h.b h.q2.s.l<? super Set<E>, h.y1> lVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        lVar.invoke(linkedHashSet);
        return linkedHashSet;
    }

    @i.c.a.d
    public static final <T> HashSet<T> b(@i.c.a.d T... tArr) {
        h.q2.t.i0.f(tArr, "elements");
        return (HashSet) r.e((Object[]) tArr, new HashSet(b1.b(tArr.length)));
    }

    @i.c.a.d
    public static final <T> LinkedHashSet<T> c(@i.c.a.d T... tArr) {
        h.q2.t.i0.f(tArr, "elements");
        return (LinkedHashSet) r.e((Object[]) tArr, new LinkedHashSet(b1.b(tArr.length)));
    }

    @i.c.a.d
    public static final <T> Set<T> d(@i.c.a.d T... tArr) {
        h.q2.t.i0.f(tArr, "elements");
        return (Set) r.e((Object[]) tArr, new LinkedHashSet(b1.b(tArr.length)));
    }

    @h.m2.f
    private static final <T> Set<T> e() {
        return a();
    }

    @h.m2.f
    @h.t0(version = "1.3")
    @h.j
    private static final <E> Set<E> a(int i2, @h.b h.q2.s.l<? super Set<E>, h.y1> lVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(i2));
        lVar.invoke(linkedHashSet);
        return linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    private static final <T> Set<T> b(@i.c.a.e Set<? extends T> set) {
        return set != 0 ? set : a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.c.a.d
    public static <T> Set<T> a(@i.c.a.d Set<? extends T> set) {
        h.q2.t.i0.f(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : l1.a(set.iterator().next());
        }
        return a();
    }
}
