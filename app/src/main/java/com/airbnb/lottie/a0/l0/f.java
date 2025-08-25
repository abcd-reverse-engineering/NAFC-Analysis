package com.airbnb.lottie.a0.l0;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: LinkedHashTreeMap.java */
/* loaded from: classes.dex */
final class f<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<Comparable> f3377a = new a();
    Comparator<? super K> comparator;
    private f<K, V>.d entrySet;
    final g<K, V> header;
    private f<K, V>.e keySet;
    int modCount;
    int size;
    g<K, V>[] table;
    int threshold;

    /* compiled from: LinkedHashTreeMap.java */
    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    final class d extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedHashTreeMap.java */
        class a extends f<K, V>.AbstractC0046f<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && f.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            g<K, V> gVarFindByEntry;
            if (!(obj instanceof Map.Entry) || (gVarFindByEntry = f.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            f.this.removeInternal(gVarFindByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f.this.size;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    final class e extends AbstractSet<K> {

        /* compiled from: LinkedHashTreeMap.java */
        class a extends f<K, V>.AbstractC0046f<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f3396f;
            }
        }

        e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return f.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return f.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f.this.size;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    /* renamed from: com.airbnb.lottie.a0.l0.f$f, reason: collision with other inner class name */
    abstract class AbstractC0046f<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        g<K, V> f3387a;

        /* renamed from: b, reason: collision with root package name */
        g<K, V> f3388b;

        /* renamed from: c, reason: collision with root package name */
        int f3389c;

        AbstractC0046f() {
            f fVar = f.this;
            this.f3387a = fVar.header.f3394d;
            this.f3388b = null;
            this.f3389c = fVar.modCount;
        }

        final g<K, V> a() {
            g<K, V> gVar = this.f3387a;
            f fVar = f.this;
            if (gVar == fVar.header) {
                throw new NoSuchElementException();
            }
            if (fVar.modCount != this.f3389c) {
                throw new ConcurrentModificationException();
            }
            this.f3387a = gVar.f3394d;
            this.f3388b = gVar;
            return gVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f3387a != f.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            g<K, V> gVar = this.f3388b;
            if (gVar == null) {
                throw new IllegalStateException();
            }
            f.this.removeInternal(gVar, true);
            this.f3388b = null;
            this.f3389c = f.this.modCount;
        }
    }

    f() {
        this(null);
    }

    private static int a(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void b(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f3392b;
        g<K, V> gVar3 = gVar.f3393c;
        g<K, V> gVar4 = gVar2.f3392b;
        g<K, V> gVar5 = gVar2.f3393c;
        gVar.f3392b = gVar5;
        if (gVar5 != null) {
            gVar5.f3391a = gVar;
        }
        a((g) gVar, (g) gVar2);
        gVar2.f3393c = gVar;
        gVar.f3391a = gVar2;
        gVar.f3399i = Math.max(gVar3 != null ? gVar3.f3399i : 0, gVar5 != null ? gVar5.f3399i : 0) + 1;
        gVar2.f3399i = Math.max(gVar.f3399i, gVar4 != null ? gVar4.f3399i : 0) + 1;
    }

    static <K, V> g<K, V>[] doubleCapacity(g<K, V>[] gVarArr) {
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[length * 2];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i2 = 0; i2 < length; i2++) {
            g<K, V> gVar = gVarArr[i2];
            if (gVar != null) {
                cVar.a(gVar);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    g<K, V> gVarA = cVar.a();
                    if (gVarA == null) {
                        break;
                    }
                    if ((gVarA.f3397g & length) == 0) {
                        i3++;
                    } else {
                        i4++;
                    }
                }
                bVar.a(i3);
                bVar2.a(i4);
                cVar.a(gVar);
                while (true) {
                    g<K, V> gVarA2 = cVar.a();
                    if (gVarA2 == null) {
                        break;
                    }
                    if ((gVarA2.f3397g & length) == 0) {
                        bVar.a(gVarA2);
                    } else {
                        bVar2.a(gVarA2);
                    }
                }
                gVarArr2[i2] = i3 > 0 ? bVar.a() : null;
                gVarArr2[i2 + length] = i4 > 0 ? bVar2.a() : null;
            }
        }
        return gVarArr2;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        g<K, V> gVar = this.header;
        g<K, V> gVar2 = gVar.f3394d;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.f3394d;
            gVar2.f3395e = null;
            gVar2.f3394d = null;
            gVar2 = gVar3;
        }
        gVar.f3395e = gVar;
        gVar.f3394d = gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        f<K, V>.d dVar = this.entrySet;
        if (dVar != null) {
            return dVar;
        }
        f<K, V>.d dVar2 = new d();
        this.entrySet = dVar2;
        return dVar2;
    }

    g<K, V> find(K k2, boolean z) {
        g<K, V> gVar;
        int i2;
        g<K, V> gVar2;
        Comparator<? super K> comparator = this.comparator;
        g<K, V>[] gVarArr = this.table;
        int iA = a(k2.hashCode());
        int length = (gVarArr.length - 1) & iA;
        g<K, V> gVar3 = gVarArr[length];
        if (gVar3 != null) {
            Comparable comparable = comparator == f3377a ? (Comparable) k2 : null;
            while (true) {
                int iCompareTo = comparable != null ? comparable.compareTo(gVar3.f3396f) : comparator.compare(k2, gVar3.f3396f);
                if (iCompareTo == 0) {
                    return gVar3;
                }
                g<K, V> gVar4 = iCompareTo < 0 ? gVar3.f3392b : gVar3.f3393c;
                if (gVar4 == null) {
                    gVar = gVar3;
                    i2 = iCompareTo;
                    break;
                }
                gVar3 = gVar4;
            }
        } else {
            gVar = gVar3;
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        g<K, V> gVar5 = this.header;
        if (gVar != null) {
            gVar2 = new g<>(gVar, k2, iA, gVar5, gVar5.f3395e);
            if (i2 < 0) {
                gVar.f3392b = gVar2;
            } else {
                gVar.f3393c = gVar2;
            }
            a((g) gVar, true);
        } else {
            if (comparator == f3377a && !(k2 instanceof Comparable)) {
                throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
            }
            gVar2 = new g<>(gVar, k2, iA, gVar5, gVar5.f3395e);
            gVarArr[length] = gVar2;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 > this.threshold) {
            b();
        }
        this.modCount++;
        return gVar2;
    }

    g<K, V> findByEntry(Map.Entry<?, ?> entry) {
        g<K, V> gVarFindByObject = findByObject(entry.getKey());
        if (gVarFindByObject != null && a(gVarFindByObject.f3398h, entry.getValue())) {
            return gVarFindByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    g<K, V> findByObject(Object obj) {
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
        g<K, V> gVarFindByObject = findByObject(obj);
        if (gVarFindByObject != null) {
            return gVarFindByObject.f3398h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        f<K, V>.e eVar = this.keySet;
        if (eVar != null) {
            return eVar;
        }
        f<K, V>.e eVar2 = new e();
        this.keySet = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        g<K, V> gVarFind = find(k2, true);
        V v2 = gVarFind.f3398h;
        gVarFind.f3398h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> gVarRemoveInternalByKey = removeInternalByKey(obj);
        if (gVarRemoveInternalByKey != null) {
            return gVarRemoveInternalByKey.f3398h;
        }
        return null;
    }

    void removeInternal(g<K, V> gVar, boolean z) {
        int i2;
        if (z) {
            g<K, V> gVar2 = gVar.f3395e;
            gVar2.f3394d = gVar.f3394d;
            gVar.f3394d.f3395e = gVar2;
            gVar.f3395e = null;
            gVar.f3394d = null;
        }
        g<K, V> gVar3 = gVar.f3392b;
        g<K, V> gVar4 = gVar.f3393c;
        g<K, V> gVar5 = gVar.f3391a;
        int i3 = 0;
        if (gVar3 == null || gVar4 == null) {
            if (gVar3 != null) {
                a((g) gVar, (g) gVar3);
                gVar.f3392b = null;
            } else if (gVar4 != null) {
                a((g) gVar, (g) gVar4);
                gVar.f3393c = null;
            } else {
                a((g) gVar, (g) null);
            }
            a((g) gVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        g<K, V> gVarB = gVar3.f3399i > gVar4.f3399i ? gVar3.b() : gVar4.a();
        removeInternal(gVarB, false);
        g<K, V> gVar6 = gVar.f3392b;
        if (gVar6 != null) {
            i2 = gVar6.f3399i;
            gVarB.f3392b = gVar6;
            gVar6.f3391a = gVarB;
            gVar.f3392b = null;
        } else {
            i2 = 0;
        }
        g<K, V> gVar7 = gVar.f3393c;
        if (gVar7 != null) {
            i3 = gVar7.f3399i;
            gVarB.f3393c = gVar7;
            gVar7.f3391a = gVarB;
            gVar.f3393c = null;
        }
        gVarB.f3399i = Math.max(i2, i3) + 1;
        a((g) gVar, (g) gVarB);
    }

    g<K, V> removeInternalByKey(Object obj) {
        g<K, V> gVarFindByObject = findByObject(obj);
        if (gVarFindByObject != null) {
            removeInternal(gVarFindByObject, true);
        }
        return gVarFindByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    f(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? f3377a : comparator;
        this.header = new g<>();
        this.table = new g[16];
        g<K, V>[] gVarArr = this.table;
        this.threshold = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    private void a(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.f3391a;
        gVar.f3391a = null;
        if (gVar2 != null) {
            gVar2.f3391a = gVar3;
        }
        if (gVar3 == null) {
            int i2 = gVar.f3397g;
            this.table[i2 & (r0.length - 1)] = gVar2;
        } else if (gVar3.f3392b == gVar) {
            gVar3.f3392b = gVar2;
        } else {
            gVar3.f3393c = gVar2;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    static class c<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private g<K, V> f3382a;

        c() {
        }

        void a(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (true) {
                g<K, V> gVar3 = gVar2;
                gVar2 = gVar;
                if (gVar2 == null) {
                    this.f3382a = gVar3;
                    return;
                } else {
                    gVar2.f3391a = gVar3;
                    gVar = gVar2.f3392b;
                }
            }
        }

        public g<K, V> a() {
            g<K, V> gVar = this.f3382a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.f3391a;
            gVar.f3391a = null;
            g<K, V> gVar3 = gVar.f3393c;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                if (gVar2 != null) {
                    gVar2.f3391a = gVar4;
                    gVar3 = gVar2.f3392b;
                } else {
                    this.f3382a = gVar4;
                    return gVar;
                }
            }
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    static final class g<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        g<K, V> f3391a;

        /* renamed from: b, reason: collision with root package name */
        g<K, V> f3392b;

        /* renamed from: c, reason: collision with root package name */
        g<K, V> f3393c;

        /* renamed from: d, reason: collision with root package name */
        g<K, V> f3394d;

        /* renamed from: e, reason: collision with root package name */
        g<K, V> f3395e;

        /* renamed from: f, reason: collision with root package name */
        final K f3396f;

        /* renamed from: g, reason: collision with root package name */
        final int f3397g;

        /* renamed from: h, reason: collision with root package name */
        V f3398h;

        /* renamed from: i, reason: collision with root package name */
        int f3399i;

        g() {
            this.f3396f = null;
            this.f3397g = -1;
            this.f3395e = this;
            this.f3394d = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f3392b; gVar2 != null; gVar2 = gVar2.f3392b) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f3393c; gVar2 != null; gVar2 = gVar2.f3393c) {
                gVar = gVar2;
            }
            return gVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k2 = this.f3396f;
            if (k2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k2.equals(entry.getKey())) {
                return false;
            }
            V v = this.f3398h;
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
            return this.f3396f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3398h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f3396f;
            int iHashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f3398h;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f3398h;
            this.f3398h = v;
            return v2;
        }

        public String toString() {
            return this.f3396f + ContainerUtils.KEY_VALUE_DELIMITER + this.f3398h;
        }

        g(g<K, V> gVar, K k2, int i2, g<K, V> gVar2, g<K, V> gVar3) {
            this.f3391a = gVar;
            this.f3396f = k2;
            this.f3397g = i2;
            this.f3399i = 1;
            this.f3394d = gVar2;
            this.f3395e = gVar3;
            gVar3.f3394d = this;
            gVar2.f3395e = this;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    static final class b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private g<K, V> f3378a;

        /* renamed from: b, reason: collision with root package name */
        private int f3379b;

        /* renamed from: c, reason: collision with root package name */
        private int f3380c;

        /* renamed from: d, reason: collision with root package name */
        private int f3381d;

        b() {
        }

        void a(int i2) {
            this.f3379b = ((Integer.highestOneBit(i2) * 2) - 1) - i2;
            this.f3381d = 0;
            this.f3380c = 0;
            this.f3378a = null;
        }

        void a(g<K, V> gVar) {
            gVar.f3393c = null;
            gVar.f3391a = null;
            gVar.f3392b = null;
            gVar.f3399i = 1;
            int i2 = this.f3379b;
            if (i2 > 0) {
                int i3 = this.f3381d;
                if ((i3 & 1) == 0) {
                    this.f3381d = i3 + 1;
                    this.f3379b = i2 - 1;
                    this.f3380c++;
                }
            }
            gVar.f3391a = this.f3378a;
            this.f3378a = gVar;
            this.f3381d++;
            int i4 = this.f3379b;
            if (i4 > 0) {
                int i5 = this.f3381d;
                if ((i5 & 1) == 0) {
                    this.f3381d = i5 + 1;
                    this.f3379b = i4 - 1;
                    this.f3380c++;
                }
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.f3381d & i7) != i7) {
                    return;
                }
                int i8 = this.f3380c;
                if (i8 == 0) {
                    g<K, V> gVar2 = this.f3378a;
                    g<K, V> gVar3 = gVar2.f3391a;
                    g<K, V> gVar4 = gVar3.f3391a;
                    gVar3.f3391a = gVar4.f3391a;
                    this.f3378a = gVar3;
                    gVar3.f3392b = gVar4;
                    gVar3.f3393c = gVar2;
                    gVar3.f3399i = gVar2.f3399i + 1;
                    gVar4.f3391a = gVar3;
                    gVar2.f3391a = gVar3;
                } else if (i8 == 1) {
                    g<K, V> gVar5 = this.f3378a;
                    g<K, V> gVar6 = gVar5.f3391a;
                    this.f3378a = gVar6;
                    gVar6.f3393c = gVar5;
                    gVar6.f3399i = gVar5.f3399i + 1;
                    gVar5.f3391a = gVar6;
                    this.f3380c = 0;
                } else if (i8 == 2) {
                    this.f3380c = 0;
                }
                i6 *= 2;
            }
        }

        g<K, V> a() {
            g<K, V> gVar = this.f3378a;
            if (gVar.f3391a == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    private void a(g<K, V> gVar, boolean z) {
        while (gVar != null) {
            g<K, V> gVar2 = gVar.f3392b;
            g<K, V> gVar3 = gVar.f3393c;
            int i2 = gVar2 != null ? gVar2.f3399i : 0;
            int i3 = gVar3 != null ? gVar3.f3399i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                g<K, V> gVar4 = gVar3.f3392b;
                g<K, V> gVar5 = gVar3.f3393c;
                int i5 = (gVar4 != null ? gVar4.f3399i : 0) - (gVar5 != null ? gVar5.f3399i : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    b(gVar3);
                    a(gVar);
                } else {
                    a(gVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                g<K, V> gVar6 = gVar2.f3392b;
                g<K, V> gVar7 = gVar2.f3393c;
                int i6 = (gVar6 != null ? gVar6.f3399i : 0) - (gVar7 != null ? gVar7.f3399i : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    a(gVar2);
                    b(gVar);
                } else {
                    b(gVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                gVar.f3399i = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                gVar.f3399i = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            gVar = gVar.f3391a;
        }
    }

    private void b() {
        this.table = doubleCapacity(this.table);
        g<K, V>[] gVarArr = this.table;
        this.threshold = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    private void a(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f3392b;
        g<K, V> gVar3 = gVar.f3393c;
        g<K, V> gVar4 = gVar3.f3392b;
        g<K, V> gVar5 = gVar3.f3393c;
        gVar.f3393c = gVar4;
        if (gVar4 != null) {
            gVar4.f3391a = gVar;
        }
        a((g) gVar, (g) gVar3);
        gVar3.f3392b = gVar;
        gVar.f3391a = gVar3;
        gVar.f3399i = Math.max(gVar2 != null ? gVar2.f3399i : 0, gVar4 != null ? gVar4.f3399i : 0) + 1;
        gVar3.f3399i = Math.max(gVar.f3399i, gVar5 != null ? gVar5.f3399i : 0) + 1;
    }
}
