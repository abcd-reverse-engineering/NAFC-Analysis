package h.g2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapsJVM.kt */
/* loaded from: classes2.dex */
public class b1 extends a1 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16115a = 1073741824;

    @i.c.a.d
    public static final <K, V> Map<K, V> a(@i.c.a.d h.i0<? extends K, ? extends V> i0Var) {
        h.q2.t.i0.f(i0Var, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(i0Var.getFirst(), i0Var.getSecond());
        h.q2.t.i0.a((Object) mapSingletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return mapSingletonMap;
    }

    @h.m2.f
    @h.j
    @h.t0(version = "1.3")
    @h.n0
    private static final void a(int i2) {
    }

    @h.n0
    public static int b(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> b(@i.c.a.d Map<? extends K, ? extends V> map) {
        h.q2.t.i0.f(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        h.q2.t.i0.a((Object) mapSingletonMap, "java.util.Collections.singletonMap(key, value)");
        h.q2.t.i0.a((Object) mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }

    @h.m2.f
    private static final <K, V> Map<K, V> c(@i.c.a.d Map<K, ? extends V> map) {
        return b(map);
    }

    @i.c.a.d
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> d(@i.c.a.d Map<? extends K, ? extends V> map) {
        h.q2.t.i0.f(map, "$this$toSortedMap");
        return new TreeMap(map);
    }

    public static final <K, V> V a(@i.c.a.d ConcurrentMap<K, V> concurrentMap, K k2, @i.c.a.d h.q2.s.a<? extends V> aVar) {
        h.q2.t.i0.f(concurrentMap, "$this$getOrPut");
        h.q2.t.i0.f(aVar, "defaultValue");
        V v = concurrentMap.get(k2);
        if (v != null) {
            return v;
        }
        V vInvoke = aVar.invoke();
        V vPutIfAbsent = concurrentMap.putIfAbsent(k2, vInvoke);
        return vPutIfAbsent != null ? vPutIfAbsent : vInvoke;
    }

    @i.c.a.d
    public static final <K, V> SortedMap<K, V> a(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d Comparator<? super K> comparator) {
        h.q2.t.i0.f(map, "$this$toSortedMap");
        h.q2.t.i0.f(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

    @i.c.a.d
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> a(@i.c.a.d h.i0<? extends K, ? extends V>... i0VarArr) {
        h.q2.t.i0.f(i0VarArr, "pairs");
        TreeMap treeMap = new TreeMap();
        c1.c((Map) treeMap, (h.i0[]) i0VarArr);
        return treeMap;
    }

    @h.m2.f
    private static final Properties a(@i.c.a.d Map<String, String> map) {
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }
}
