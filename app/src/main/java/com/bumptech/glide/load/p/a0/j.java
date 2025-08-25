package com.bumptech.glide.load.p.a0;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool.java */
/* loaded from: classes.dex */
public final class j implements com.bumptech.glide.load.p.a0.b {

    /* renamed from: h, reason: collision with root package name */
    private static final int f4349h = 4194304;

    /* renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    static final int f4350i = 8;

    /* renamed from: j, reason: collision with root package name */
    private static final int f4351j = 2;

    /* renamed from: b, reason: collision with root package name */
    private final h<a, Object> f4352b;

    /* renamed from: c, reason: collision with root package name */
    private final b f4353c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f4354d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.p.a0.a<?>> f4355e;

    /* renamed from: f, reason: collision with root package name */
    private final int f4356f;

    /* renamed from: g, reason: collision with root package name */
    private int f4357g;

    /* compiled from: LruArrayPool.java */
    private static final class a implements m {

        /* renamed from: a, reason: collision with root package name */
        private final b f4358a;

        /* renamed from: b, reason: collision with root package name */
        int f4359b;

        /* renamed from: c, reason: collision with root package name */
        private Class<?> f4360c;

        a(b bVar) {
            this.f4358a = bVar;
        }

        void a(int i2, Class<?> cls) {
            this.f4359b = i2;
            this.f4360c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4359b == aVar.f4359b && this.f4360c == aVar.f4360c;
        }

        public int hashCode() {
            int i2 = this.f4359b * 31;
            Class<?> cls = this.f4360c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        @Override // com.bumptech.glide.load.p.a0.m
        public void offer() {
            this.f4358a.a(this);
        }

        public String toString() {
            return "Key{size=" + this.f4359b + "array=" + this.f4360c + '}';
        }
    }

    /* compiled from: LruArrayPool.java */
    private static final class b extends d<a> {
        b() {
        }

        a a(int i2, Class<?> cls) {
            a aVarB = b();
            aVarB.a(i2, cls);
            return aVarB;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.p.a0.d
        public a a() {
            return new a(this);
        }
    }

    @VisibleForTesting
    public j() {
        this.f4352b = new h<>();
        this.f4353c = new b();
        this.f4354d = new HashMap();
        this.f4355e = new HashMap();
        this.f4356f = 4194304;
    }

    private boolean c(int i2) {
        return i2 <= this.f4356f / 2;
    }

    private boolean d() {
        int i2 = this.f4357g;
        return i2 == 0 || this.f4356f / i2 >= 2;
    }

    @Override // com.bumptech.glide.load.p.a0.b
    @Deprecated
    public <T> void a(T t, Class<T> cls) {
        put(t);
    }

    @Override // com.bumptech.glide.load.p.a0.b
    public synchronized <T> T b(int i2, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = b((Class<?>) cls).ceilingKey(Integer.valueOf(i2));
        return (T) a(a(i2, numCeilingKey) ? this.f4353c.a(numCeilingKey.intValue(), cls) : this.f4353c.a(i2, cls), (Class) cls);
    }

    @Override // com.bumptech.glide.load.p.a0.b
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        com.bumptech.glide.load.p.a0.a<T> aVarA = a((Class) cls);
        int iA = aVarA.a(t);
        int iA2 = aVarA.a() * iA;
        if (c(iA2)) {
            a aVarA2 = this.f4353c.a(iA, cls);
            this.f4352b.a(aVarA2, t);
            NavigableMap<Integer, Integer> navigableMapB = b(cls);
            Integer num = (Integer) navigableMapB.get(Integer.valueOf(aVarA2.f4359b));
            Integer numValueOf = Integer.valueOf(aVarA2.f4359b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapB.put(numValueOf, Integer.valueOf(iIntValue));
            this.f4357g += iA2;
            c();
        }
    }

    private void c() {
        b(this.f4356f);
    }

    @Override // com.bumptech.glide.load.p.a0.b
    public synchronized <T> T a(int i2, Class<T> cls) {
        return (T) a(this.f4353c.a(i2, cls), (Class) cls);
    }

    private void c(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapB = b(cls);
        Integer num = (Integer) navigableMapB.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapB.remove(Integer.valueOf(i2));
                return;
            } else {
                navigableMapB.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    private <T> T a(a aVar, Class<T> cls) {
        com.bumptech.glide.load.p.a0.a<T> aVarA = a((Class) cls);
        T t = (T) a(aVar);
        if (t != null) {
            this.f4357g -= aVarA.a(t) * aVarA.a();
            c(aVarA.a(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(aVarA.getTag(), 2)) {
            aVarA.getTag();
            String str = "Allocated " + aVar.f4359b + " bytes";
        }
        return aVarA.newArray(aVar.f4359b);
    }

    private void b(int i2) {
        while (this.f4357g > i2) {
            Object objA = this.f4352b.a();
            com.bumptech.glide.util.j.a(objA);
            com.bumptech.glide.load.p.a0.a aVarA = a((j) objA);
            this.f4357g -= aVarA.a(objA) * aVarA.a();
            c(aVarA.a(objA), objA.getClass());
            if (Log.isLoggable(aVarA.getTag(), 2)) {
                aVarA.getTag();
                String str = "evicted: " + aVarA.a(objA);
            }
        }
    }

    public j(int i2) {
        this.f4352b = new h<>();
        this.f4353c = new b();
        this.f4354d = new HashMap();
        this.f4355e = new HashMap();
        this.f4356f = i2;
    }

    @Nullable
    private <T> T a(a aVar) {
        return (T) this.f4352b.a((h<a, Object>) aVar);
    }

    private boolean a(int i2, Integer num) {
        return num != null && (d() || num.intValue() <= i2 * 8);
    }

    @Override // com.bumptech.glide.load.p.a0.b
    public synchronized void a() {
        b(0);
    }

    private NavigableMap<Integer, Integer> b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f4354d.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f4354d.put(cls, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.p.a0.b
    public synchronized void a(int i2) {
        try {
            if (i2 >= 40) {
                a();
            } else if (i2 >= 20 || i2 == 15) {
                b(this.f4356f / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    int b() {
        int iIntValue = 0;
        for (Class<?> cls : this.f4354d.keySet()) {
            for (Integer num : this.f4354d.get(cls).keySet()) {
                iIntValue += num.intValue() * ((Integer) this.f4354d.get(cls).get(num)).intValue() * a((Class) cls).a();
            }
        }
        return iIntValue;
    }

    private <T> com.bumptech.glide.load.p.a0.a<T> a(T t) {
        return a((Class) t.getClass());
    }

    private <T> com.bumptech.glide.load.p.a0.a<T> a(Class<T> cls) {
        com.bumptech.glide.load.p.a0.a<T> gVar = (com.bumptech.glide.load.p.a0.a) this.f4355e.get(cls);
        if (gVar == null) {
            if (cls.equals(int[].class)) {
                gVar = new i();
            } else if (cls.equals(byte[].class)) {
                gVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f4355e.put(cls, gVar);
        }
        return gVar;
    }
}
