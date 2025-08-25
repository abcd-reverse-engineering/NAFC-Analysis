package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: DataFetcher.java */
/* loaded from: classes.dex */
public interface d<T> {

    /* compiled from: DataFetcher.java */
    public interface a<T> {
        void a(@NonNull Exception exc);

        void a(@Nullable T t);
    }

    @NonNull
    Class<T> a();

    void a(@NonNull com.bumptech.glide.h hVar, @NonNull a<? super T> aVar);

    void b();

    @NonNull
    com.bumptech.glide.load.a c();

    void cancel();
}
