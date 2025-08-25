package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.b0.a;
import java.io.File;

/* compiled from: DataCacheWriter.java */
/* loaded from: classes.dex */
class e<DataType> implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.d<DataType> f4522a;

    /* renamed from: b, reason: collision with root package name */
    private final DataType f4523b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.j f4524c;

    e(com.bumptech.glide.load.d<DataType> dVar, DataType datatype, com.bumptech.glide.load.j jVar) {
        this.f4522a = dVar;
        this.f4523b = datatype;
        this.f4524c = jVar;
    }

    @Override // com.bumptech.glide.load.p.b0.a.b
    public boolean a(@NonNull File file) {
        return this.f4522a.a(this.f4523b, file, this.f4524c);
    }
}
