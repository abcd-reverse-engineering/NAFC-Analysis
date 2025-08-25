package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;

/* compiled from: UnitModelLoader.java */
/* loaded from: classes.dex */
public class v<Model> implements n<Model, Model> {

    /* renamed from: a, reason: collision with root package name */
    private static final v<?> f4782a = new v<>();

    /* compiled from: UnitModelLoader.java */
    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a, reason: collision with root package name */
        private static final a<?> f4783a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> b() {
            return (a<T>) f4783a;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Model, Model> a(r rVar) {
            return v.a();
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* compiled from: UnitModelLoader.java */
    private static class b<Model> implements com.bumptech.glide.load.o.d<Model> {

        /* renamed from: a, reason: collision with root package name */
        private final Model f4784a;

        b(Model model) {
            this.f4784a = model;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super Model> aVar) {
            aVar.a((d.a<? super Model>) this.f4784a);
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.o.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.f4784a.getClass();
        }
    }

    @Deprecated
    public v() {
    }

    public static <T> v<T> a() {
        return (v<T>) f4782a;
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Model model) {
        return true;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Model> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(model), new b(model));
    }
}
