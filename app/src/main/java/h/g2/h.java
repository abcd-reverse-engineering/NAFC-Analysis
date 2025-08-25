package h.g2;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: AbstractMutableMap.kt */
@h.t0(version = "1.1")
/* loaded from: classes2.dex */
public abstract class h<K, V> extends AbstractMap<K, V> implements Map<K, V>, h.q2.t.q1.g {
    protected h() {
    }

    public abstract Set b();

    public /* bridge */ Set c() {
        return super.keySet();
    }

    public /* bridge */ int d() {
        return super.size();
    }

    public /* bridge */ Collection e() {
        return super.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @i.c.a.e
    public abstract V put(K k2, V v);

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return e();
    }
}
