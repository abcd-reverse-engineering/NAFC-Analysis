package com.bumptech.glide.load.p.b0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* compiled from: DiskCache.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.p.b0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0059a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f4393a = 262144000;

        /* renamed from: b, reason: collision with root package name */
        public static final String f4394b = "image_manager_disk_cache";

        @Nullable
        a build();
    }

    /* compiled from: DiskCache.java */
    public interface b {
        boolean a(@NonNull File file);
    }

    @Nullable
    File a(com.bumptech.glide.load.g gVar);

    void a(com.bumptech.glide.load.g gVar, b bVar);

    void b(com.bumptech.glide.load.g gVar);

    void clear();
}
