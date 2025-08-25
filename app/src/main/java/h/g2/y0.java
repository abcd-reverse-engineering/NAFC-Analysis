package h.g2;

import com.taobao.accs.AccsClientConfig;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: MapWithDefault.kt */
/* loaded from: classes2.dex */
final class y0<K, V> implements x0<K, V> {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final Map<K, V> f16198a;

    /* renamed from: b, reason: collision with root package name */
    private final h.q2.s.l<K, V> f16199b;

    /* JADX WARN: Multi-variable type inference failed */
    public y0(@i.c.a.d Map<K, ? extends V> map, @i.c.a.d h.q2.s.l<? super K, ? extends V> lVar) {
        h.q2.t.i0.f(map, "map");
        h.q2.t.i0.f(lVar, AccsClientConfig.DEFAULT_CONFIGTAG);
        this.f16198a = map;
        this.f16199b = lVar;
    }

    @Override // h.g2.x0
    @i.c.a.d
    public Map<K, V> a() {
        return this.f16198a;
    }

    @i.c.a.d
    public Set<Map.Entry<K, V>> b() {
        return a().entrySet();
    }

    @i.c.a.d
    public Set<K> c() {
        return a().keySet();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return a().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return a().containsValue(obj);
    }

    public int d() {
        return a().size();
    }

    @i.c.a.d
    public Collection<V> e() {
        return a().values();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return b();
    }

    @Override // java.util.Map
    public boolean equals(@i.c.a.e Object obj) {
        return a().equals(obj);
    }

    @Override // java.util.Map
    @i.c.a.e
    public V get(Object obj) {
        return a().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return a().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return a().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return c();
    }

    @Override // java.util.Map
    public V put(K k2, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @i.c.a.d
    public String toString() {
        return a().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return e();
    }

    @Override // h.g2.x0
    public V a(K k2) {
        Map<K, V> mapA = a();
        V v = mapA.get(k2);
        return (v != null || mapA.containsKey(k2)) ? v : this.f16199b.invoke(k2);
    }
}
