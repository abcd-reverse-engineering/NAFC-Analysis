package h.g2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: _Maps.kt */
/* loaded from: classes2.dex */
class d1 extends c1 {
    @i.c.a.d
    public static final <K, V, R, C extends Collection<? super R>> C a(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d C c2, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> lVar) {
        h.q2.t.i0.f(map, "$this$flatMapTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.a((Collection) c2, (Iterable) lVar.invoke(it.next()));
        }
        return c2;
    }

    @h.m2.f
    private static final <K, V> Map.Entry<K, V> b(@i.c.a.d Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) g0.b((Iterable) map.entrySet(), (Comparator) comparator);
    }

    @i.c.a.d
    public static final <K, V, R, C extends Collection<? super R>> C c(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d C c2, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        h.q2.t.i0.f(map, "$this$mapTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            c2.add(lVar.invoke(it.next()));
        }
        return c2;
    }

    @i.c.a.d
    public static final <K, V> h.x2.m<Map.Entry<K, V>> e(@i.c.a.d Map<? extends K, ? extends V> map) {
        h.q2.t.i0.f(map, "$this$asSequence");
        return g0.i((Iterable) map.entrySet());
    }

    @h.m2.f
    private static final <K, V> int f(@i.c.a.d Map<? extends K, ? extends V> map) {
        return map.size();
    }

    public static final <K, V> boolean h(@i.c.a.d Map<? extends K, ? extends V> map) {
        h.q2.t.i0.f(map, "$this$none");
        return map.isEmpty();
    }

    public static final <K, V> boolean i(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        h.q2.t.i0.f(map, "$this$all");
        h.q2.t.i0.f(lVar, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean j(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        h.q2.t.i0.f(map, "$this$any");
        h.q2.t.i0.f(lVar, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @i.c.a.d
    public static final <K, V> List<h.i0<K, V>> k(@i.c.a.d Map<? extends K, ? extends V> map) {
        h.q2.t.i0.f(map, "$this$toList");
        if (map.size() == 0) {
            return y.b();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return y.b();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return x.a(new h.i0(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new h.i0(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new h.i0(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    @i.c.a.d
    public static final <K, V, R> List<R> l(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> lVar) {
        h.q2.t.i0.f(map, "$this$flatMap");
        h.q2.t.i0.f(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.a((Collection) arrayList, (Iterable) lVar.invoke(it.next()));
        }
        return arrayList;
    }

    @h.m2.e
    public static final <K, V> void m(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, h.y1> lVar) {
        h.q2.t.i0.f(map, "$this$forEach");
        h.q2.t.i0.f(lVar, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
    }

    @i.c.a.d
    public static final <K, V, R> List<R> n(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        h.q2.t.i0.f(map, "$this$map");
        h.q2.t.i0.f(lVar, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(lVar.invoke(it.next()));
        }
        return arrayList;
    }

    @i.c.a.d
    public static final <K, V, R> List<R> o(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        h.q2.t.i0.f(map, "$this$mapNotNull");
        h.q2.t.i0.f(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    @h.m2.f
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> p(@i.c.a.d Map<? extends K, ? extends V> map, h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Map.Entry<K, V> entry;
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            entry = (Object) it.next();
            if (it.hasNext()) {
                R rInvoke = lVar.invoke(entry);
                do {
                    Map.Entry<K, V> entry2 = (Object) it.next();
                    R rInvoke2 = lVar.invoke(entry2);
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        entry = entry2;
                        rInvoke = rInvoke2;
                    }
                } while (it.hasNext());
            }
        } else {
            entry = null;
        }
        return entry;
    }

    @i.c.a.e
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> q(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Map.Entry<K, V> entry;
        h.q2.t.i0.f(map, "$this$minBy");
        h.q2.t.i0.f(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            entry = (Object) it.next();
            if (it.hasNext()) {
                R rInvoke = lVar.invoke(entry);
                do {
                    Map.Entry<K, V> entry2 = (Object) it.next();
                    R rInvoke2 = lVar.invoke(entry2);
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        entry = entry2;
                        rInvoke = rInvoke2;
                    }
                } while (it.hasNext());
            }
        } else {
            entry = null;
        }
        return entry;
    }

    public static final <K, V> boolean r(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        h.q2.t.i0.f(map, "$this$none");
        h.q2.t.i0.f(lVar, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <K, V, M extends Map<? extends K, ? extends V>> M s(@i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, h.y1> lVar) {
        h.q2.t.i0.f(m2, "$this$onEach");
        h.q2.t.i0.f(lVar, "action");
        Iterator<Map.Entry<K, V>> it = m2.entrySet().iterator();
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
        return m2;
    }

    @i.c.a.d
    public static final <K, V, R, C extends Collection<? super R>> C b(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d C c2, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        h.q2.t.i0.f(map, "$this$mapNotNullTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
        }
        return c2;
    }

    @i.c.a.e
    public static final <K, V> Map.Entry<K, V> c(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        h.q2.t.i0.f(map, "$this$minWith");
        h.q2.t.i0.f(comparator, "comparator");
        return (Map.Entry) g0.c((Iterable) map.entrySet(), (Comparator) comparator);
    }

    public static final <K, V> boolean a(@i.c.a.d Map<? extends K, ? extends V> map) {
        h.q2.t.i0.f(map, "$this$any");
        return !map.isEmpty();
    }

    @h.m2.f
    private static final <K, V> Iterable<Map.Entry<K, V>> c(@i.c.a.d Map<? extends K, ? extends V> map) {
        return map.entrySet();
    }

    public static final <K, V> int k(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        h.q2.t.i0.f(map, "$this$count");
        h.q2.t.i0.f(lVar, "predicate");
        int i2 = 0;
        if (map.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }
}
