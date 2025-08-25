package com.bumptech.glide.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<i> f5202a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayMap<i, List<Class<?>>> f5203b = new ArrayMap<>();

    @Nullable
    public List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.f5202a.getAndSet(null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f5203b) {
            list = this.f5203b.get(andSet);
        }
        this.f5202a.set(andSet);
        return list;
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f5203b) {
            this.f5203b.put(new i(cls, cls2, cls3), list);
        }
    }

    public void a() {
        synchronized (this.f5203b) {
            this.f5203b.clear();
        }
    }
}
