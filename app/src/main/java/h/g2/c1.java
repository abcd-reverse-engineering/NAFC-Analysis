package h.g2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Maps.kt */
/* loaded from: classes2.dex */
class c1 extends b1 {
    @i.c.a.d
    public static final <K, V> Map<K, V> a() {
        k0 k0Var = k0.INSTANCE;
        if (k0Var != null) {
            return k0Var;
        }
        throw new h.e1("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <K, V> HashMap<K, V> b() {
        return new HashMap<>();
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <K, V> LinkedHashMap<K, V> c() {
        return new LinkedHashMap<>();
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> d(@i.c.a.d h.i0<? extends K, ? extends V>... i0VarArr) {
        h.q2.t.i0.f(i0VarArr, "pairs");
        return i0VarArr.length > 0 ? a(i0VarArr, new LinkedHashMap(b1.b(i0VarArr.length))) : a();
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <K, V> Map<K, V> e() {
        return new LinkedHashMap();
    }

    @h.t0(version = "1.1")
    public static final <K, V> V f(@i.c.a.d Map<K, ? extends V> map, K k2) {
        h.q2.t.i0.f(map, "$this$getValue");
        return (V) a1.a(map, k2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.c.a.d
    public static final <K, V, R> Map<R, V> g(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        h.q2.t.i0.f(map, "$this$mapKeys");
        h.q2.t.i0.f(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.b(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(lVar.invoke(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    private static final <K, V> Map<K, V> h(@i.c.a.e Map<K, ? extends V> map) {
        return map != 0 ? map : a();
    }

    @h.m2.f
    private static final <K, V> V i(@i.c.a.d Map<? extends K, V> map, K k2) {
        if (map != null) {
            return (V) h.q2.t.n1.f(map).remove(k2);
        }
        throw new h.e1("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <K, V> Map<K, V> j(@i.c.a.d Map<? extends K, ? extends V> map) {
        h.q2.t.i0.f(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    @h.m2.f
    @h.t0(version = "1.3")
    @h.j
    private static final <K, V> Map<K, V> a(@h.b h.q2.s.l<? super Map<K, V>, h.y1> lVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        lVar.invoke(linkedHashMap);
        return linkedHashMap;
    }

    @i.c.a.d
    public static final <K, V> HashMap<K, V> b(@i.c.a.d h.i0<? extends K, ? extends V>... i0VarArr) {
        h.q2.t.i0.f(i0VarArr, "pairs");
        HashMap<K, V> map = new HashMap<>(b1.b(i0VarArr.length));
        c((Map) map, (h.i0[]) i0VarArr);
        return map;
    }

    @i.c.a.d
    public static final <K, V> LinkedHashMap<K, V> c(@i.c.a.d h.i0<? extends K, ? extends V>... i0VarArr) {
        h.q2.t.i0.f(i0VarArr, "pairs");
        return (LinkedHashMap) a(i0VarArr, new LinkedHashMap(b1.b(i0VarArr.length)));
    }

    @h.m2.f
    private static final <K, V> Map<K, V> d() {
        return a();
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> e(@i.c.a.d h.i0<? extends K, ? extends V>... i0VarArr) {
        h.q2.t.i0.f(i0VarArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.b(i0VarArr.length));
        c((Map) linkedHashMap, (h.i0[]) i0VarArr);
        return linkedHashMap;
    }

    @h.m2.f
    @h.q2.e(name = "mutableIterator")
    private static final <K, V> Iterator<Map.Entry<K, V>> f(@i.c.a.d Map<K, V> map) {
        h.q2.t.i0.f(map, "$this$iterator");
        return map.entrySet().iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.c.a.d
    public static final <K, V, R> Map<K, R> h(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        h.q2.t.i0.f(map, "$this$mapValues");
        h.q2.t.i0.f(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.b(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(entry.getKey(), lVar.invoke(entry));
        }
        return linkedHashMap;
    }

    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <K, V> Map<K, V> i(@i.c.a.d Map<? extends K, ? extends V> map) {
        h.q2.t.i0.f(map, "$this$toMap");
        int size = map.size();
        return size != 0 ? size != 1 ? j(map) : b1.b(map) : a();
    }

    @h.m2.f
    @h.t0(version = "1.3")
    @h.j
    private static final <K, V> Map<K, V> a(int i2, @h.b h.q2.s.l<? super Map<K, V>, h.y1> lVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.b(i2));
        lVar.invoke(linkedHashMap);
        return linkedHashMap;
    }

    @h.m2.f
    private static final <K, V> boolean b(@i.c.a.d Map<? extends K, ? extends V> map, K k2) {
        h.q2.t.i0.f(map, "$this$contains");
        return map.containsKey(k2);
    }

    @h.m2.f
    @h.t0(version = "1.3")
    private static final <K, V> boolean c(@i.c.a.e Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @h.m2.f
    private static final <K, V> boolean d(@i.c.a.d Map<K, ? extends V> map, V v) {
        return map.containsValue(v);
    }

    @h.m2.f
    private static final <K, V> V e(@i.c.a.d Map<? extends K, ? extends V> map, K k2) {
        h.q2.t.i0.f(map, "$this$get");
        return map.get(k2);
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> f(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super V, Boolean> lVar) {
        h.q2.t.i0.f(map, "$this$filterValues");
        h.q2.t.i0.f(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @h.m2.f
    private static final <K, V> boolean a(@i.c.a.d Map<? extends K, ? extends V> map) {
        return !map.isEmpty();
    }

    @h.m2.f
    private static final <K, V> V b(@i.c.a.d Map.Entry<? extends K, ? extends V> entry) {
        h.q2.t.i0.f(entry, "$this$component2");
        return entry.getValue();
    }

    @h.m2.f
    private static final <K> boolean c(@i.c.a.d Map<? extends K, ?> map, K k2) {
        if (map != null) {
            return map.containsKey(k2);
        }
        throw new h.e1("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.c.a.d
    public static final <K, V, R, M extends Map<? super K, ? super R>> M d(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        h.q2.t.i0.f(map, "$this$mapValuesTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(lVar, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            m2.put(entry.getKey(), lVar.invoke(entry));
        }
        return m2;
    }

    @h.m2.f
    private static final <K, V> Iterator<Map.Entry<K, V>> e(@i.c.a.d Map<? extends K, ? extends V> map) {
        h.q2.t.i0.f(map, "$this$iterator");
        return map.entrySet().iterator();
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Lh/q2/s/a<+TR;>;)TR; */
    @h.m2.f
    @h.t0(version = "1.3")
    private static final Object a(Map map, h.q2.s.a aVar) {
        return map.isEmpty() ? aVar.invoke() : map;
    }

    public static final <K, V> V b(@i.c.a.d Map<K, ? extends V> map, K k2, @i.c.a.d h.q2.s.a<? extends V> aVar) {
        h.q2.t.i0.f(map, "$this$getOrElseNullable");
        h.q2.t.i0.f(aVar, "defaultValue");
        V v = map.get(k2);
        return (v != null || map.containsKey(k2)) ? v : aVar.invoke();
    }

    @h.m2.f
    private static final <K, V> h.i0<K, V> c(@i.c.a.d Map.Entry<? extends K, ? extends V> entry) {
        return new h.i0<>(entry.getKey(), entry.getValue());
    }

    public static final <K, V> void e(@i.c.a.d Map<? super K, ? super V> map, @i.c.a.d Iterable<? extends h.i0<? extends K, ? extends V>> iterable) {
        h.q2.t.i0.f(map, "$this$putAll");
        h.q2.t.i0.f(iterable, "pairs");
        for (h.i0<? extends K, ? extends V> i0Var : iterable) {
            map.put(i0Var.component1(), i0Var.component2());
        }
    }

    @h.m2.f
    private static final <K, V> void a(@i.c.a.d Map<K, V> map, K k2, V v) {
        h.q2.t.i0.f(map, "$this$set");
        map.put(k2, v);
    }

    public static final <K, V> V c(@i.c.a.d Map<K, V> map, K k2, @i.c.a.d h.q2.s.a<? extends V> aVar) {
        h.q2.t.i0.f(map, "$this$getOrPut");
        h.q2.t.i0.f(aVar, "defaultValue");
        V v = map.get(k2);
        if (v != null) {
            return v;
        }
        V vInvoke = aVar.invoke();
        map.put(k2, vInvoke);
        return vInvoke;
    }

    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <K, V> Map<K, V> g(@i.c.a.d Map<? extends K, ? extends V> map, K k2) {
        h.q2.t.i0.f(map, "$this$minus");
        Map mapJ = j(map);
        mapJ.remove(k2);
        return g(mapJ);
    }

    @h.m2.f
    private static final <K, V> K a(@i.c.a.d Map.Entry<? extends K, ? extends V> entry) {
        h.q2.t.i0.f(entry, "$this$component1");
        return entry.getKey();
    }

    public static final <K, V> void e(@i.c.a.d Map<? super K, ? super V> map, @i.c.a.d h.x2.m<? extends h.i0<? extends K, ? extends V>> mVar) {
        h.q2.t.i0.f(map, "$this$putAll");
        h.q2.t.i0.f(mVar, "pairs");
        for (h.i0<? extends K, ? extends V> i0Var : mVar) {
            map.put(i0Var.component1(), i0Var.component2());
        }
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> f(@i.c.a.d h.i0<? extends K, ? extends V>[] i0VarArr) {
        h.q2.t.i0.f(i0VarArr, "$this$toMap");
        int length = i0VarArr.length;
        if (length == 0) {
            return a();
        }
        if (length != 1) {
            return a(i0VarArr, new LinkedHashMap(b1.b(i0VarArr.length)));
        }
        return b1.a(i0VarArr[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.c.a.d
    public static final <K, V> Map<K, V> g(@i.c.a.d Map<K, ? extends V> map) {
        h.q2.t.i0.f(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : b1.b(map);
        }
        return a();
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <K, V> void h(@i.c.a.d Map<K, V> map, K k2) {
        h.q2.t.i0.f(map, "$this$minusAssign");
        map.remove(k2);
    }

    @h.m2.f
    private static final <K, V> V a(@i.c.a.d Map<K, ? extends V> map, K k2, h.q2.s.a<? extends V> aVar) {
        V v = map.get(k2);
        return v != null ? v : aVar.invoke();
    }

    @i.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M b(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        h.q2.t.i0.f(map, "$this$filterTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(lVar, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                m2.put(entry.getKey(), entry.getValue());
            }
        }
        return m2;
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> d(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super K, Boolean> lVar) {
        h.q2.t.i0.f(map, "$this$filterKeys");
        h.q2.t.i0.f(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @i.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        h.q2.t.i0.f(map, "$this$filterNotTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(lVar, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!lVar.invoke(entry).booleanValue()) {
                m2.put(entry.getKey(), entry.getValue());
            }
        }
        return m2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.c.a.d
    public static final <K, V, R, M extends Map<? super R, ? super V>> M c(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        h.q2.t.i0.f(map, "$this$mapKeysTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(lVar, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            m2.put(lVar.invoke(entry), entry.getValue());
        }
        return m2;
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> e(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        h.q2.t.i0.f(map, "$this$filterNot");
        h.q2.t.i0.f(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!lVar.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @h.m2.f
    private static final <K, V> void b(@i.c.a.d Map<? super K, ? super V> map, h.i0<? extends K, ? extends V> i0Var) {
        h.q2.t.i0.f(map, "$this$plusAssign");
        map.put(i0Var.getFirst(), i0Var.getSecond());
    }

    @i.c.a.d
    public static <K, V> Map<K, V> a(@i.c.a.d Iterable<? extends h.i0<? extends K, ? extends V>> iterable) {
        h.q2.t.i0.f(iterable, "$this$toMap");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return a();
            }
            if (size != 1) {
                return a(iterable, new LinkedHashMap(b1.b(collection.size())));
            }
            return b1.a(iterable instanceof List ? (h.i0<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
        }
        return g(a(iterable, new LinkedHashMap()));
    }

    @h.m2.f
    private static final <K, V> void b(@i.c.a.d Map<? super K, ? super V> map, h.i0<? extends K, ? extends V>[] i0VarArr) {
        h.q2.t.i0.f(map, "$this$plusAssign");
        c((Map) map, (h.i0[]) i0VarArr);
    }

    @h.m2.f
    private static final <K, V> void d(@i.c.a.d Map<? super K, ? super V> map, Iterable<? extends h.i0<? extends K, ? extends V>> iterable) {
        h.q2.t.i0.f(map, "$this$plusAssign");
        e((Map) map, (Iterable) iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    private static final <K, V> void b(@i.c.a.d Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        h.q2.t.i0.f(map, "$this$plusAssign");
        map.putAll(map2);
    }

    public static final <K, V> void c(@i.c.a.d Map<? super K, ? super V> map, @i.c.a.d h.i0<? extends K, ? extends V>[] i0VarArr) {
        h.q2.t.i0.f(map, "$this$putAll");
        h.q2.t.i0.f(i0VarArr, "pairs");
        for (h.i0<? extends K, ? extends V> i0Var : i0VarArr) {
            map.put(i0Var.component1(), i0Var.component2());
        }
    }

    @h.m2.f
    private static final <K, V> void d(@i.c.a.d Map<? super K, ? super V> map, h.x2.m<? extends h.i0<? extends K, ? extends V>> mVar) {
        h.q2.t.i0.f(map, "$this$plusAssign");
        e((Map) map, (h.x2.m) mVar);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <K, V> void b(@i.c.a.d Map<K, V> map, Iterable<? extends K> iterable) {
        h.q2.t.i0.f(map, "$this$minusAssign");
        d0.d(map.keySet(), iterable);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <K, V> void b(@i.c.a.d Map<K, V> map, K[] kArr) {
        h.q2.t.i0.f(map, "$this$minusAssign");
        d0.d(map.keySet(), kArr);
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> c(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        h.q2.t.i0.f(map, "$this$filter");
        h.q2.t.i0.f(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <K, V> void b(@i.c.a.d Map<K, V> map, h.x2.m<? extends K> mVar) {
        h.q2.t.i0.f(map, "$this$minusAssign");
        d0.d(map.keySet(), mVar);
    }

    @i.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@i.c.a.d Iterable<? extends h.i0<? extends K, ? extends V>> iterable, @i.c.a.d M m2) {
        h.q2.t.i0.f(iterable, "$this$toMap");
        h.q2.t.i0.f(m2, "destination");
        e((Map) m2, (Iterable) iterable);
        return m2;
    }

    @i.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@i.c.a.d h.i0<? extends K, ? extends V>[] i0VarArr, @i.c.a.d M m2) {
        h.q2.t.i0.f(i0VarArr, "$this$toMap");
        h.q2.t.i0.f(m2, "destination");
        c((Map) m2, (h.i0[]) i0VarArr);
        return m2;
    }

    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M c(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d M m2) {
        h.q2.t.i0.f(map, "$this$toMap");
        h.q2.t.i0.f(m2, "destination");
        m2.putAll(map);
        return m2;
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> a(@i.c.a.d h.x2.m<? extends h.i0<? extends K, ? extends V>> mVar) {
        h.q2.t.i0.f(mVar, "$this$toMap");
        return g(a(mVar, new LinkedHashMap()));
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> c(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d Iterable<? extends h.i0<? extends K, ? extends V>> iterable) {
        h.q2.t.i0.f(map, "$this$plus");
        h.q2.t.i0.f(iterable, "pairs");
        if (map.isEmpty()) {
            return a(iterable);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        e((Map) linkedHashMap, (Iterable) iterable);
        return linkedHashMap;
    }

    @i.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@i.c.a.d h.x2.m<? extends h.i0<? extends K, ? extends V>> mVar, @i.c.a.d M m2) {
        h.q2.t.i0.f(mVar, "$this$toMap");
        h.q2.t.i0.f(m2, "destination");
        e((Map) m2, (h.x2.m) mVar);
        return m2;
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> c(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.x2.m<? extends h.i0<? extends K, ? extends V>> mVar) {
        h.q2.t.i0.f(map, "$this$plus");
        h.q2.t.i0.f(mVar, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        e((Map) linkedHashMap, (h.x2.m) mVar);
        return g(linkedHashMap);
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> a(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.i0<? extends K, ? extends V> i0Var) {
        h.q2.t.i0.f(map, "$this$plus");
        h.q2.t.i0.f(i0Var, "pair");
        if (map.isEmpty()) {
            return b1.a(i0Var);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(i0Var.getFirst(), i0Var.getSecond());
        return linkedHashMap;
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> a(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.i0<? extends K, ? extends V>[] i0VarArr) {
        h.q2.t.i0.f(map, "$this$plus");
        h.q2.t.i0.f(i0VarArr, "pairs");
        if (map.isEmpty()) {
            return f(i0VarArr);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        c((Map) linkedHashMap, (h.i0[]) i0VarArr);
        return linkedHashMap;
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> a(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d Map<? extends K, ? extends V> map2) {
        h.q2.t.i0.f(map, "$this$plus");
        h.q2.t.i0.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <K, V> Map<K, V> a(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d Iterable<? extends K> iterable) {
        h.q2.t.i0.f(map, "$this$minus");
        h.q2.t.i0.f(iterable, "keys");
        Map mapJ = j(map);
        d0.d(mapJ.keySet(), iterable);
        return g(mapJ);
    }

    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <K, V> Map<K, V> a(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d K[] kArr) {
        h.q2.t.i0.f(map, "$this$minus");
        h.q2.t.i0.f(kArr, "keys");
        Map mapJ = j(map);
        d0.d(mapJ.keySet(), kArr);
        return g(mapJ);
    }

    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <K, V> Map<K, V> a(@i.c.a.d Map<? extends K, ? extends V> map, @i.c.a.d h.x2.m<? extends K> mVar) {
        h.q2.t.i0.f(map, "$this$minus");
        h.q2.t.i0.f(mVar, "keys");
        Map mapJ = j(map);
        d0.d(mapJ.keySet(), mVar);
        return g(mapJ);
    }
}
