package com.bumptech.glide.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final List<C0077a<?>> f5195a = new ArrayList();

    /* compiled from: EncoderRegistry.java */
    /* renamed from: com.bumptech.glide.q.a$a, reason: collision with other inner class name */
    private static final class C0077a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f5196a;

        /* renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.d<T> f5197b;

        C0077a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.d<T> dVar) {
            this.f5196a = cls;
            this.f5197b = dVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f5196a.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> com.bumptech.glide.load.d<T> a(@NonNull Class<T> cls) {
        for (C0077a<?> c0077a : this.f5195a) {
            if (c0077a.a(cls)) {
                return (com.bumptech.glide.load.d<T>) c0077a.f5197b;
            }
        }
        return null;
    }

    public synchronized <T> void b(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.d<T> dVar) {
        this.f5195a.add(0, new C0077a<>(cls, dVar));
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.d<T> dVar) {
        this.f5195a.add(new C0077a<>(cls, dVar));
    }
}
