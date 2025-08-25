package com.bumptech.glide.q;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.p.i;
import com.bumptech.glide.load.p.t;
import com.bumptech.glide.load.r.h.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static final t<?, ?, ?> f5199c = new t<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* renamed from: a, reason: collision with root package name */
    private final ArrayMap<com.bumptech.glide.util.i, t<?, ?, ?>> f5200a = new ArrayMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<com.bumptech.glide.util.i> f5201b = new AtomicReference<>();

    private com.bumptech.glide.util.i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        com.bumptech.glide.util.i andSet = this.f5201b.getAndSet(null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.util.i();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public boolean a(@Nullable t<?, ?, ?> tVar) {
        return f5199c.equals(tVar);
    }

    @Nullable
    public <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        t<Data, TResource, Transcode> tVar;
        com.bumptech.glide.util.i iVarB = b(cls, cls2, cls3);
        synchronized (this.f5200a) {
            tVar = (t) this.f5200a.get(iVarB);
        }
        this.f5201b.set(iVarB);
        return tVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable t<?, ?, ?> tVar) {
        synchronized (this.f5200a) {
            ArrayMap<com.bumptech.glide.util.i, t<?, ?, ?>> arrayMap = this.f5200a;
            com.bumptech.glide.util.i iVar = new com.bumptech.glide.util.i(cls, cls2, cls3);
            if (tVar == null) {
                tVar = f5199c;
            }
            arrayMap.put(iVar, tVar);
        }
    }
}
