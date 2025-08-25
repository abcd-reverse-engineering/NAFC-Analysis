package h.g2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: AbstractMap.kt */
@h.t0(version = "1.1")
@h.y(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b'\u0018\u0000 )*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001)B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0018\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\rH\u0016J#\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0002J\u001c\u0010&\u001a\u00020'2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\bR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0088\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006*"}, d2 = {"Lkotlin/collections/AbstractMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", SurveyH5Bean.VALUE, "equals", DispatchConstants.OTHER, "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public abstract class e<K, V> implements Map<K, V>, h.q2.t.q1.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f16124c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private volatile Set<? extends K> f16125a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Collection<? extends V> f16126b;

    /* compiled from: AbstractMap.kt */
    public static final class a {
        private a() {
        }

        public final int a(@i.c.a.d Map.Entry<?, ?> entry) {
            h.q2.t.i0.f(entry, "e");
            Object key = entry.getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = entry.getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @i.c.a.d
        public final String b(@i.c.a.d Map.Entry<?, ?> entry) {
            h.q2.t.i0.f(entry, "e");
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            return sb.toString();
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }

        public final boolean a(@i.c.a.d Map.Entry<?, ?> entry, @i.c.a.e Object obj) {
            h.q2.t.i0.f(entry, "e");
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            return h.q2.t.i0.a(entry.getKey(), entry2.getKey()) && h.q2.t.i0.a(entry.getValue(), entry2.getValue());
        }
    }

    /* compiled from: AbstractMap.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"kotlin/collections/AbstractMap$keys$1", "Lkotlin/collections/AbstractSet;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    public static final class b extends j<K> {

        /* compiled from: AbstractMap.kt */
        public static final class a implements Iterator<K>, h.q2.t.q1.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator f16128a;

            a(Iterator it) {
                this.f16128a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f16128a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return (K) ((Map.Entry) this.f16128a.next()).getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        b() {
        }

        @Override // h.g2.a, java.util.Collection
        public boolean contains(Object obj) {
            return e.this.containsKey(obj);
        }

        @Override // h.g2.a
        public int getSize() {
            return e.this.size();
        }

        @Override // h.g2.j, h.g2.a, java.util.Collection, java.lang.Iterable
        @i.c.a.d
        public Iterator<K> iterator() {
            return new a(e.this.entrySet().iterator());
        }
    }

    /* compiled from: AbstractMap.kt */
    static final class c extends h.q2.t.j0 implements h.q2.s.l<Map.Entry<? extends K, ? extends V>, String> {
        c() {
            super(1);
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final String invoke(@i.c.a.d Map.Entry<? extends K, ? extends V> entry) {
            h.q2.t.i0.f(entry, "it");
            return e.this.b((Map.Entry) entry);
        }
    }

    /* compiled from: AbstractMap.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"kotlin/collections/AbstractMap$values$1", "Lkotlin/collections/AbstractCollection;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    public static final class d extends h.g2.a<V> {

        /* compiled from: AbstractMap.kt */
        public static final class a implements Iterator<V>, h.q2.t.q1.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator f16130a;

            a(Iterator it) {
                this.f16130a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f16130a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return (V) ((Map.Entry) this.f16130a.next()).getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        d() {
        }

        @Override // h.g2.a, java.util.Collection
        public boolean contains(Object obj) {
            return e.this.containsValue(obj);
        }

        @Override // h.g2.a
        public int getSize() {
            return e.this.size();
        }

        @Override // h.g2.a, java.util.Collection, java.lang.Iterable
        @i.c.a.d
        public Iterator<V> iterator() {
            return new a(e.this.entrySet().iterator());
        }
    }

    protected e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(Map.Entry<? extends K, ? extends V> entry) {
        return c(entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + c(entry.getValue());
    }

    public abstract Set b();

    @i.c.a.d
    public Set<K> c() {
        if (this.f16125a == null) {
            this.f16125a = new b();
        }
        Set<? extends K> set = this.f16125a;
        if (set == null) {
            h.q2.t.i0.f();
        }
        return set;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return b((e<K, V>) obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> setEntrySet = entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (h.q2.t.i0.a(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    public int d() {
        return entrySet().size();
    }

    @i.c.a.d
    public Collection<V> e() {
        if (this.f16126b == null) {
            this.f16126b = new d();
        }
        Collection<? extends V> collection = this.f16126b;
        if (collection == null) {
            h.q2.t.i0.f();
        }
        return collection;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return b();
    }

    @Override // java.util.Map
    public boolean equals(@i.c.a.e Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @i.c.a.e
    public V get(Object obj) {
        Map.Entry<K, V> entryB = b((e<K, V>) obj);
        if (entryB != null) {
            return entryB.getValue();
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
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
        return g0.a(entrySet(), ", ", "{", "}", 0, null, new c(), 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return e();
    }

    private final Map.Entry<K, V> b(K k2) {
        Object next;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (h.q2.t.i0.a(((Map.Entry) next).getKey(), k2)) {
                break;
            }
        }
        return (Map.Entry) next;
    }

    public final boolean a(@i.c.a.e Map.Entry<?, ?> entry) {
        if (!(entry instanceof Map.Entry)) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        V v = get(key);
        if (!h.q2.t.i0.a(value, v)) {
            return false;
        }
        return v != null || containsKey(key);
    }

    private final String c(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }
}
