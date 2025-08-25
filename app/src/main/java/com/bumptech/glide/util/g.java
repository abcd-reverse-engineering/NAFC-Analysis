package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class g<T, Y> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<T, Y> f5376a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    private final long f5377b;

    /* renamed from: c, reason: collision with root package name */
    private long f5378c;

    /* renamed from: d, reason: collision with root package name */
    private long f5379d;

    public g(long j2) {
        this.f5377b = j2;
        this.f5378c = j2;
    }

    public synchronized void a(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.f5378c = Math.round(this.f5377b * f2);
        d();
    }

    protected void a(@NonNull T t, @Nullable Y y) {
    }

    public synchronized long b() {
        return this.f5378c;
    }

    protected synchronized int c() {
        return this.f5376a.size();
    }

    protected int c(@Nullable Y y) {
        return 1;
    }

    @Nullable
    public synchronized Y d(@NonNull T t) {
        Y yRemove;
        yRemove = this.f5376a.remove(t);
        if (yRemove != null) {
            this.f5379d -= c(yRemove);
        }
        return yRemove;
    }

    public synchronized long getCurrentSize() {
        return this.f5379d;
    }

    @Nullable
    public synchronized Y b(@NonNull T t) {
        return this.f5376a.get(t);
    }

    @Nullable
    public synchronized Y b(@NonNull T t, @Nullable Y y) {
        long jC = c(y);
        if (jC >= this.f5378c) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.f5379d += jC;
        }
        Y yPut = this.f5376a.put(t, y);
        if (yPut != null) {
            this.f5379d -= c(yPut);
            if (!yPut.equals(y)) {
                a(t, yPut);
            }
        }
        d();
        return yPut;
    }

    private void d() {
        a(this.f5378c);
    }

    public synchronized boolean a(@NonNull T t) {
        return this.f5376a.containsKey(t);
    }

    public void a() {
        a(0L);
    }

    protected synchronized void a(long j2) {
        while (this.f5379d > j2) {
            Iterator<Map.Entry<T, Y>> it = this.f5376a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f5379d -= c(value);
            T key = next.getKey();
            it.remove();
            a(key, value);
        }
    }
}
