package h.g2;

import java.util.Map;

/* compiled from: MapAccessors.kt */
@h.q2.e(name = "MapAccessorsKt")
/* loaded from: classes2.dex */
public final class w0 {
    @h.m2.f
    private static final <V, V1 extends V> V1 a(@i.c.a.d Map<? super String, ? extends V> map, Object obj, h.w2.m<?> mVar) {
        h.q2.t.i0.f(map, "$this$getValue");
        return (V1) a1.a((Map<String, ? extends V>) map, mVar.getName());
    }

    @h.m2.f
    @h.q2.e(name = "getVar")
    private static final <V, V1 extends V> V1 b(@i.c.a.d Map<? super String, ? extends V> map, Object obj, h.w2.m<?> mVar) {
        h.q2.t.i0.f(map, "$this$getValue");
        return (V1) a1.a((Map<String, ? extends V>) map, mVar.getName());
    }

    @h.m2.f
    @h.q2.e(name = "getVarContravariant")
    @h.c(level = h.d.ERROR, message = "Use getValue() with two type parameters instead")
    @h.m2.g
    private static final <V> V c(@i.c.a.d Map<? super String, ? super V> map, Object obj, h.w2.m<?> mVar) {
        return (V) a1.a((Map<String, ? extends V>) map, mVar.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    private static final <V> void a(@i.c.a.d Map<? super String, ? super V> map, Object obj, h.w2.m<?> mVar, V v) {
        h.q2.t.i0.f(map, "$this$setValue");
        map.put(mVar.getName(), v);
    }
}
