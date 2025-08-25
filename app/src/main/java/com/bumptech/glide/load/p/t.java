package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.p.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: LoadPath.java */
/* loaded from: classes.dex */
public class t<Data, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<Data> f4646a;

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f4647b;

    /* renamed from: c, reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f4648c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4649d;

    public t(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f4646a = cls;
        this.f4647b = pool;
        this.f4648c = (List) com.bumptech.glide.util.j.a(list);
        this.f4649d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public v<Transcode> a(com.bumptech.glide.load.o.e<Data> eVar, @NonNull com.bumptech.glide.load.j jVar, int i2, int i3, i.a<ResourceType> aVar) throws q {
        List<Throwable> list = (List) com.bumptech.glide.util.j.a(this.f4647b.acquire());
        try {
            return a(eVar, jVar, i2, i3, aVar, list);
        } finally {
            this.f4647b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f4648c.toArray()) + '}';
    }

    private v<Transcode> a(com.bumptech.glide.load.o.e<Data> eVar, @NonNull com.bumptech.glide.load.j jVar, int i2, int i3, i.a<ResourceType> aVar, List<Throwable> list) throws q {
        int size = this.f4648c.size();
        v<Transcode> vVarA = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                vVarA = this.f4648c.get(i4).a(eVar, i2, i3, jVar, aVar);
            } catch (q e2) {
                list.add(e2);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f4649d, new ArrayList(list));
    }

    public Class<Data> a() {
        return this.f4646a;
    }
}
