package com.bumptech.glide.util.n;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5393a = "FactoryPools";

    /* renamed from: b, reason: collision with root package name */
    private static final int f5394b = 20;

    /* renamed from: c, reason: collision with root package name */
    private static final g<Object> f5395c = new C0080a();

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.n.a$a, reason: collision with other inner class name */
    class C0080a implements g<Object> {
        C0080a() {
        }

        @Override // com.bumptech.glide.util.n.a.g
        public void a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    class b<T> implements d<List<T>> {
        b() {
        }

        @Override // com.bumptech.glide.util.n.a.d
        @NonNull
        public List<T> create() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    class c<T> implements g<List<T>> {
        c() {
        }

        @Override // com.bumptech.glide.util.n.a.g
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* compiled from: FactoryPools.java */
    public interface d<T> {
        T create();
    }

    /* compiled from: FactoryPools.java */
    private static final class e<T> implements Pools.Pool<T> {

        /* renamed from: a, reason: collision with root package name */
        private final d<T> f5396a;

        /* renamed from: b, reason: collision with root package name */
        private final g<T> f5397b;

        /* renamed from: c, reason: collision with root package name */
        private final Pools.Pool<T> f5398c;

        e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f5398c = pool;
            this.f5396a = dVar;
            this.f5397b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.f5398c.acquire();
            if (tAcquire == null) {
                tAcquire = this.f5396a.create();
                if (Log.isLoggable(a.f5393a, 2)) {
                    String str = "Created new " + tAcquire.getClass();
                }
            }
            if (tAcquire instanceof f) {
                tAcquire.c().a(false);
            }
            return (T) tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof f) {
                ((f) t).c().a(true);
            }
            this.f5397b.a(t);
            return this.f5398c.release(t);
        }
    }

    /* compiled from: FactoryPools.java */
    public interface f {
        @NonNull
        com.bumptech.glide.util.n.c c();
    }

    /* compiled from: FactoryPools.java */
    public interface g<T> {
        void a(@NonNull T t);
    }

    private a() {
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> a(int i2, @NonNull d<T> dVar) {
        return a(new Pools.SimplePool(i2), dVar);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> b(int i2, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i2), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a(int i2) {
        return a(new Pools.SynchronizedPool(i2), new b(), new c());
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> b() {
        return a(20);
    }

    @NonNull
    private static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return a(pool, dVar, a());
    }

    @NonNull
    private static <T> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    private static <T> g<T> a() {
        return (g<T>) f5395c;
    }
}
