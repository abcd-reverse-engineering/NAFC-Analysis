package h.g2;

import bean.SurveyH5Bean;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: Maps.kt */
/* loaded from: classes2.dex */
final class k0 implements Map, Serializable, h.q2.t.q1.a {
    public static final k0 INSTANCE = new k0();
    private static final long serialVersionUID = 8246714829545688274L;

    private k0() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(@i.c.a.e Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return containsValue((Void) obj);
        }
        return false;
    }

    public boolean containsValue(@i.c.a.d Void r2) {
        h.q2.t.i0.f(r2, SurveyH5Bean.VALUE);
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@i.c.a.e Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Object get(Object obj) {
        return get(obj);
    }

    @Override // java.util.Map
    @i.c.a.e
    public Void get(@i.c.a.e Object obj) {
        return null;
    }

    @i.c.a.d
    public Set<Map.Entry> getEntries() {
        return l0.INSTANCE;
    }

    @i.c.a.d
    public Set<Object> getKeys() {
        return l0.INSTANCE;
    }

    public int getSize() {
        return 0;
    }

    @i.c.a.d
    public Collection getValues() {
        return j0.INSTANCE;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void put(Object obj, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @i.c.a.d
    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }
}
