package h.g2;

import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: MapWithDefault.kt */
/* loaded from: classes2.dex */
class a1 {
    @h.q2.e(name = "getOrImplicitDefaultNullable")
    @h.n0
    public static final <K, V> V a(@i.c.a.d Map<K, ? extends V> map, K k2) {
        h.q2.t.i0.f(map, "$this$getOrImplicitDefault");
        if (map instanceof x0) {
            return (V) ((x0) map).a(k2);
        }
        V v = map.get(k2);
        if (v != null || map.containsKey(k2)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k2 + " is missing in the map.");
    }

    @h.q2.e(name = "withDefaultMutable")
    @i.c.a.d
    public static final <K, V> Map<K, V> b(@i.c.a.d Map<K, V> map, @i.c.a.d h.q2.s.l<? super K, ? extends V> lVar) {
        h.q2.t.i0.f(map, "$this$withDefault");
        h.q2.t.i0.f(lVar, "defaultValue");
        return map instanceof f1 ? b(((f1) map).a(), lVar) : new g1(map, lVar);
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> a(@i.c.a.d Map<K, ? extends V> map, @i.c.a.d h.q2.s.l<? super K, ? extends V> lVar) {
        h.q2.t.i0.f(map, "$this$withDefault");
        h.q2.t.i0.f(lVar, "defaultValue");
        return map instanceof x0 ? a((Map) ((x0) map).a(), (h.q2.s.l) lVar) : new y0(map, lVar);
    }
}
