package com.bumptech.glide.load.r.h;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TranscoderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?, ?>> f4991a = new ArrayList();

    /* compiled from: TranscoderRegistry.java */
    private static final class a<Z, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<Z> f4992a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<R> f4993b;

        /* renamed from: c, reason: collision with root package name */
        final e<Z, R> f4994c;

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.f4992a = cls;
            this.f4993b = cls2;
            this.f4994c = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f4992a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f4993b);
        }
    }

    public synchronized <Z, R> void a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f4991a.add(new a<>(cls, cls2, eVar));
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.f4991a.iterator();
        while (it.hasNext()) {
            if (it.next().a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a<?, ?> aVar : this.f4991a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f4994c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }
}
