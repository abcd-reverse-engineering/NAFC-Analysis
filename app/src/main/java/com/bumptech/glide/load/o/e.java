package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: DataRewinder.java */
/* loaded from: classes.dex */
public interface e<T> {

    /* compiled from: DataRewinder.java */
    public interface a<T> {
        @NonNull
        e<T> a(@NonNull T t);

        @NonNull
        Class<T> a();
    }

    @NonNull
    T a() throws IOException;

    void b();
}
