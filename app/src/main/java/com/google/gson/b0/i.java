package com.google.gson.b0;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* compiled from: LinkedTreeMap.java */
/* loaded from: classes.dex */
public final class i<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<Comparable> f5521a = new a();
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private i<K, V>.b entrySet;
    final e<K, V> header;
    private i<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    /* compiled from: LinkedTreeMap.java */
    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        class a extends i<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && i.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarFindByEntry;
            if (!(obj instanceof Map.Entry) || (eVarFindByEntry = i.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            i.this.removeInternal(eVarFindByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    final class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        class a extends i<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f5535f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return i.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return i.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    private abstract class d<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        e<K, V> f5526a;

        /* renamed from: b, reason: collision with root package name */
        e<K, V> f5527b;

        /* renamed from: c, reason: collision with root package name */
        int f5528c;

        d() {
            i iVar = i.this;
            this.f5526a = iVar.header.f5533d;
            this.f5527b = null;
            this.f5528c = iVar.modCount;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.f5526a;
            i iVar = i.this;
            if (eVar == iVar.header) {
                throw new NoSuchElementException();
            }
            if (iVar.modCount != this.f5528c) {
                throw new ConcurrentModificationException();
            }
            this.f5526a = eVar.f5533d;
            this.f5527b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f5526a != i.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f5527b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            i.this.removeInternal(eVar, true);
            this.f5527b = null;
            this.f5528c = i.this.modCount;
        }
    }

    public i() {
        this(f5521a, true);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void b(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f5531b;
        e<K, V> eVar3 = eVar.f5532c;
        e<K, V> eVar4 = eVar2.f5531b;
        e<K, V> eVar5 = eVar2.f5532c;
        eVar.f5531b = eVar5;
        if (eVar5 != null) {
            eVar5.f5530a = eVar;
        }
        a((e) eVar, (e) eVar2);
        eVar2.f5532c = eVar;
        eVar.f5530a = eVar2;
        eVar.f5538i = Math.max(eVar3 != null ? eVar3.f5538i : 0, eVar5 != null ? eVar5.f5538i : 0) + 1;
        eVar2.f5538i = Math.max(eVar.f5538i, eVar4 != null ? eVar4.f5538i : 0) + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f5534e = eVar;
        eVar.f5533d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        i<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        i<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    e<K, V> find(K k2, boolean z) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == f5521a ? (Comparable) k2 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f5535f) : comparator.compare(k2, eVar2.f5535f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f5531b : eVar2.f5532c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.header;
        if (eVar2 != null) {
            eVar = new e<>(this.allowNullValues, eVar2, k2, eVar4, eVar4.f5534e);
            if (iCompareTo < 0) {
                eVar2.f5531b = eVar;
            } else {
                eVar2.f5532c = eVar;
            }
            a((e) eVar2, true);
        } else {
            if (comparator == f5521a && !(k2 instanceof Comparable)) {
                throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(this.allowNullValues, eVar2, k2, eVar4, eVar4.f5534e);
            this.root = eVar;
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    e<K, V> findByEntry(Map.Entry<?, ?> entry) {
        e<K, V> eVarFindByObject = findByObject(entry.getKey());
        if (eVarFindByObject != null && a(eVarFindByObject.f5537h, entry.getValue())) {
            return eVarFindByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarFindByObject = findByObject(obj);
        if (eVarFindByObject != null) {
            return eVarFindByObject.f5537h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        i<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        i<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        if (v == null && !this.allowNullValues) {
            throw new NullPointerException("value == null");
        }
        e<K, V> eVarFind = find(k2, true);
        V v2 = eVarFind.f5537h;
        eVarFind.f5537h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarRemoveInternalByKey = removeInternalByKey(obj);
        if (eVarRemoveInternalByKey != null) {
            return eVarRemoveInternalByKey.f5537h;
        }
        return null;
    }

    void removeInternal(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f5534e;
            eVar2.f5533d = eVar.f5533d;
            eVar.f5533d.f5534e = eVar2;
        }
        e<K, V> eVar3 = eVar.f5531b;
        e<K, V> eVar4 = eVar.f5532c;
        e<K, V> eVar5 = eVar.f5530a;
        int i3 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                a((e) eVar, (e) eVar3);
                eVar.f5531b = null;
            } else if (eVar4 != null) {
                a((e) eVar, (e) eVar4);
                eVar.f5532c = null;
            } else {
                a((e) eVar, (e) null);
            }
            a((e) eVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        e<K, V> eVarB = eVar3.f5538i > eVar4.f5538i ? eVar3.b() : eVar4.a();
        removeInternal(eVarB, false);
        e<K, V> eVar6 = eVar.f5531b;
        if (eVar6 != null) {
            i2 = eVar6.f5538i;
            eVarB.f5531b = eVar6;
            eVar6.f5530a = eVarB;
            eVar.f5531b = null;
        } else {
            i2 = 0;
        }
        e<K, V> eVar7 = eVar.f5532c;
        if (eVar7 != null) {
            i3 = eVar7.f5538i;
            eVarB.f5532c = eVar7;
            eVar7.f5530a = eVarB;
            eVar.f5532c = null;
        }
        eVarB.f5538i = Math.max(i2, i3) + 1;
        a((e) eVar, (e) eVarB);
    }

    e<K, V> removeInternalByKey(Object obj) {
        e<K, V> eVarFindByObject = findByObject(obj);
        if (eVarFindByObject != null) {
            removeInternal(eVarFindByObject, true);
        }
        return eVarFindByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public i(boolean z) {
        this(f5521a, z);
    }

    private void a(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f5530a;
        eVar.f5530a = null;
        if (eVar2 != null) {
            eVar2.f5530a = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.f5531b == eVar) {
            eVar3.f5531b = eVar2;
        } else {
            eVar3.f5532c = eVar2;
        }
    }

    public i(Comparator<? super K> comparator, boolean z) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? f5521a : comparator;
        this.allowNullValues = z;
        this.header = new e<>(z);
    }

    /* compiled from: LinkedTreeMap.java */
    static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        e<K, V> f5530a;

        /* renamed from: b, reason: collision with root package name */
        e<K, V> f5531b;

        /* renamed from: c, reason: collision with root package name */
        e<K, V> f5532c;

        /* renamed from: d, reason: collision with root package name */
        e<K, V> f5533d;

        /* renamed from: e, reason: collision with root package name */
        e<K, V> f5534e;

        /* renamed from: f, reason: collision with root package name */
        final K f5535f;

        /* renamed from: g, reason: collision with root package name */
        final boolean f5536g;

        /* renamed from: h, reason: collision with root package name */
        V f5537h;

        /* renamed from: i, reason: collision with root package name */
        int f5538i;

        e(boolean z) {
            this.f5535f = null;
            this.f5536g = z;
            this.f5534e = this;
            this.f5533d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f5531b; eVar2 != null; eVar2 = eVar2.f5531b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f5532c; eVar2 != null; eVar2 = eVar2.f5532c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k2 = this.f5535f;
            if (k2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k2.equals(entry.getKey())) {
                return false;
            }
            V v = this.f5537h;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f5535f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f5537h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f5535f;
            int iHashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f5537h;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (v == null && !this.f5536g) {
                throw new NullPointerException("value == null");
            }
            V v2 = this.f5537h;
            this.f5537h = v;
            return v2;
        }

        public String toString() {
            return this.f5535f + ContainerUtils.KEY_VALUE_DELIMITER + this.f5537h;
        }

        e(boolean z, e<K, V> eVar, K k2, e<K, V> eVar2, e<K, V> eVar3) {
            this.f5530a = eVar;
            this.f5535f = k2;
            this.f5536g = z;
            this.f5538i = 1;
            this.f5533d = eVar2;
            this.f5534e = eVar3;
            eVar3.f5533d = this;
            eVar2.f5534e = this;
        }
    }

    private void a(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f5531b;
            e<K, V> eVar3 = eVar.f5532c;
            int i2 = eVar2 != null ? eVar2.f5538i : 0;
            int i3 = eVar3 != null ? eVar3.f5538i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.f5531b;
                e<K, V> eVar5 = eVar3.f5532c;
                int i5 = (eVar4 != null ? eVar4.f5538i : 0) - (eVar5 != null ? eVar5.f5538i : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    b(eVar3);
                    a(eVar);
                } else {
                    a(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.f5531b;
                e<K, V> eVar7 = eVar2.f5532c;
                int i6 = (eVar6 != null ? eVar6.f5538i : 0) - (eVar7 != null ? eVar7.f5538i : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    a(eVar2);
                    b(eVar);
                } else {
                    b(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.f5538i = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f5538i = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f5530a;
        }
    }

    private void a(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f5531b;
        e<K, V> eVar3 = eVar.f5532c;
        e<K, V> eVar4 = eVar3.f5531b;
        e<K, V> eVar5 = eVar3.f5532c;
        eVar.f5532c = eVar4;
        if (eVar4 != null) {
            eVar4.f5530a = eVar;
        }
        a((e) eVar, (e) eVar3);
        eVar3.f5531b = eVar;
        eVar.f5530a = eVar3;
        eVar.f5538i = Math.max(eVar2 != null ? eVar2.f5538i : 0, eVar4 != null ? eVar4.f5538i : 0) + 1;
        eVar3.f5538i = Math.max(eVar.f5538i, eVar5 != null ? eVar5.f5538i : 0) + 1;
    }
}
