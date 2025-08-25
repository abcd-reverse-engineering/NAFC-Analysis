package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader.java */
/* loaded from: classes.dex */
public interface n<Model, Data> {

    /* compiled from: ModelLoader.java */
    public static class a<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.g f4747a;

        /* renamed from: b, reason: collision with root package name */
        public final List<com.bumptech.glide.load.g> f4748b;

        /* renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.o.d<Data> f4749c;

        public a(@NonNull com.bumptech.glide.load.g gVar, @NonNull com.bumptech.glide.load.o.d<Data> dVar) {
            this(gVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull com.bumptech.glide.load.g gVar, @NonNull List<com.bumptech.glide.load.g> list, @NonNull com.bumptech.glide.load.o.d<Data> dVar) {
            this.f4747a = (com.bumptech.glide.load.g) com.bumptech.glide.util.j.a(gVar);
            this.f4748b = (List) com.bumptech.glide.util.j.a(list);
            this.f4749c = (com.bumptech.glide.load.o.d) com.bumptech.glide.util.j.a(dVar);
        }
    }

    @Nullable
    a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar);

    boolean a(@NonNull Model model);
}
