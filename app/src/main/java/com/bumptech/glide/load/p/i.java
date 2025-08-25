package com.bumptech.glide.load.p;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath.java */
/* loaded from: classes.dex */
public class i<DataType, ResourceType, Transcode> {

    /* renamed from: f, reason: collision with root package name */
    private static final String f4564f = "DecodePath";

    /* renamed from: a, reason: collision with root package name */
    private final Class<DataType> f4565a;

    /* renamed from: b, reason: collision with root package name */
    private final List<? extends com.bumptech.glide.load.l<DataType, ResourceType>> f4566b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.r.h.e<ResourceType, Transcode> f4567c;

    /* renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f4568d;

    /* renamed from: e, reason: collision with root package name */
    private final String f4569e;

    /* compiled from: DecodePath.java */
    interface a<ResourceType> {
        @NonNull
        v<ResourceType> a(@NonNull v<ResourceType> vVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.l<DataType, ResourceType>> list, com.bumptech.glide.load.r.h.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f4565a = cls;
        this.f4566b = list;
        this.f4567c = eVar;
        this.f4568d = pool;
        this.f4569e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public v<Transcode> a(com.bumptech.glide.load.o.e<DataType> eVar, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar, a<ResourceType> aVar) throws q {
        return this.f4567c.a(aVar.a(a(eVar, i2, i3, jVar)), jVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f4565a + ", decoders=" + this.f4566b + ", transcoder=" + this.f4567c + '}';
    }

    @NonNull
    private v<ResourceType> a(com.bumptech.glide.load.o.e<DataType> eVar, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws q {
        List<Throwable> list = (List) com.bumptech.glide.util.j.a(this.f4568d.acquire());
        try {
            return a(eVar, i2, i3, jVar, list);
        } finally {
            this.f4568d.release(list);
        }
    }

    @NonNull
    private v<ResourceType> a(com.bumptech.glide.load.o.e<DataType> eVar, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar, List<Throwable> list) throws q {
        int size = this.f4566b.size();
        v<ResourceType> vVarA = null;
        for (int i4 = 0; i4 < size; i4++) {
            com.bumptech.glide.load.l<DataType, ResourceType> lVar = this.f4566b.get(i4);
            try {
                if (lVar.a(eVar.a(), jVar)) {
                    vVarA = lVar.a(eVar.a(), i2, i3, jVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable(f4564f, 2)) {
                    String str = "Failed to decode data for " + lVar;
                }
                list.add(e2);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f4569e, new ArrayList(list));
    }
}
