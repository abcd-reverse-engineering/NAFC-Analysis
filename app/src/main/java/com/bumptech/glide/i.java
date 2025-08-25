package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.m;
import com.bumptech.glide.load.o.e;
import com.bumptech.glide.load.p.t;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.load.q.n;
import com.bumptech.glide.load.q.o;
import com.bumptech.glide.load.q.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Registry.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: k, reason: collision with root package name */
    public static final String f4203k = "Gif";

    /* renamed from: l, reason: collision with root package name */
    public static final String f4204l = "Bitmap";

    /* renamed from: m, reason: collision with root package name */
    public static final String f4205m = "BitmapDrawable";
    private static final String n = "legacy_prepend_all";
    private static final String o = "legacy_append";

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.q.d f4213h = new com.bumptech.glide.q.d();

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.q.c f4214i = new com.bumptech.glide.q.c();

    /* renamed from: j, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f4215j = com.bumptech.glide.util.n.a.b();

    /* renamed from: a, reason: collision with root package name */
    private final p f4206a = new p(this.f4215j);

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.q.a f4207b = new com.bumptech.glide.q.a();

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.q.e f4208c = new com.bumptech.glide.q.e();

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.q.f f4209d = new com.bumptech.glide.q.f();

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.o.f f4210e = new com.bumptech.glide.load.o.f();

    /* renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.r.h.f f4211f = new com.bumptech.glide.load.r.h.f();

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.q.b f4212g = new com.bumptech.glide.q.b();

    /* compiled from: Registry.java */
    public static class a extends RuntimeException {
        public a(@NonNull String str) {
            super(str);
        }
    }

    /* compiled from: Registry.java */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* compiled from: Registry.java */
    public static class c extends a {
        public c(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> c(@NonNull M m2, @NonNull List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m2);
        }

        public c(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* compiled from: Registry.java */
    public static class d extends a {
        public d(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* compiled from: Registry.java */
    public static class e extends a {
        public e(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public i() {
        a(Arrays.asList(f4203k, f4204l, f4205m));
    }

    @NonNull
    public <Data> i a(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.d<Data> dVar) {
        this.f4207b.a(cls, dVar);
        return this;
    }

    @NonNull
    public <Data> i b(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.d<Data> dVar) {
        this.f4207b.b(cls, dVar);
        return this;
    }

    @NonNull
    @Deprecated
    public <Data> i c(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.d<Data> dVar) {
        return a(cls, dVar);
    }

    @NonNull
    public <Data, TResource> i a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.l<Data, TResource> lVar) {
        a(o, cls, cls2, lVar);
        return this;
    }

    @NonNull
    public <Data, TResource> i b(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.l<Data, TResource> lVar) {
        b(n, cls, cls2, lVar);
        return this;
    }

    @NonNull
    @Deprecated
    public <TResource> i c(@NonNull Class<TResource> cls, @NonNull m<TResource> mVar) {
        return a((Class) cls, (m) mVar);
    }

    @NonNull
    public <Data, TResource> i a(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.l<Data, TResource> lVar) {
        this.f4208c.a(str, lVar, cls, cls2);
        return this;
    }

    @NonNull
    public <Data, TResource> i b(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.l<Data, TResource> lVar) {
        this.f4208c.b(str, lVar, cls, cls2);
        return this;
    }

    @NonNull
    public <Model, Data> i c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f4206a.c(cls, cls2, oVar);
        return this;
    }

    @NonNull
    private <Data, TResource, Transcode> List<com.bumptech.glide.load.p.i<Data, TResource, Transcode>> c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f4208c.b(cls, cls2)) {
            for (Class cls5 : this.f4211f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.p.i(cls, cls4, cls5, this.f4208c.a(cls, cls4), this.f4211f.a(cls4, cls5), this.f4215j));
            }
        }
        return arrayList;
    }

    @NonNull
    public final i a(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, n);
        arrayList.add(o);
        this.f4208c.a(arrayList);
        return this;
    }

    @NonNull
    public <TResource> i b(@NonNull Class<TResource> cls, @NonNull m<TResource> mVar) {
        this.f4209d.b(cls, mVar);
        return this;
    }

    @NonNull
    public <Model, Data> i b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.f4206a.b(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> b(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> listA = this.f4213h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.f4206a.a((Class<?>) cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f4208c.b(it.next(), cls2)) {
                    if (!this.f4211f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f4213h.a(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    @NonNull
    public <TResource> i a(@NonNull Class<TResource> cls, @NonNull m<TResource> mVar) {
        this.f4209d.a(cls, mVar);
        return this;
    }

    @NonNull
    public i a(@NonNull e.a<?> aVar) {
        this.f4210e.a(aVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> i a(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.bumptech.glide.load.r.h.e<TResource, Transcode> eVar) {
        this.f4211f.a(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public i a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f4212g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public <Model, Data> i a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.f4206a.a(cls, cls2, oVar);
        return this;
    }

    @Nullable
    public <Data, TResource, Transcode> t<Data, TResource, Transcode> a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        t<Data, TResource, Transcode> tVarA = this.f4214i.a(cls, cls2, cls3);
        if (this.f4214i.a(tVarA)) {
            return null;
        }
        if (tVarA == null) {
            List<com.bumptech.glide.load.p.i<Data, TResource, Transcode>> listC = c(cls, cls2, cls3);
            tVarA = listC.isEmpty() ? null : new t<>(cls, cls2, cls3, listC, this.f4215j);
            this.f4214i.a(cls, cls2, cls3, tVarA);
        }
        return tVarA;
    }

    @NonNull
    public <X> com.bumptech.glide.load.d<X> c(@NonNull X x) throws e {
        com.bumptech.glide.load.d<X> dVarA = this.f4207b.a(x.getClass());
        if (dVarA != null) {
            return dVarA;
        }
        throw new e(x.getClass());
    }

    @NonNull
    public <X> m<X> a(@NonNull v<X> vVar) throws d {
        m<X> mVarA = this.f4209d.a(vVar.b());
        if (mVarA != null) {
            return mVarA;
        }
        throw new d(vVar.b());
    }

    public boolean b(@NonNull v<?> vVar) {
        return this.f4209d.a(vVar.b()) != null;
    }

    @NonNull
    public <X> com.bumptech.glide.load.o.e<X> b(@NonNull X x) {
        return this.f4210e.a((com.bumptech.glide.load.o.f) x);
    }

    @NonNull
    public <Model> List<n<Model, ?>> a(@NonNull Model model) {
        return this.f4206a.a((p) model);
    }

    @NonNull
    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> listA = this.f4212g.a();
        if (listA.isEmpty()) {
            throw new b();
        }
        return listA;
    }
}
