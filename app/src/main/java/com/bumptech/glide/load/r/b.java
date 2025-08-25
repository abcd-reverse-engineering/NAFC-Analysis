package com.bumptech.glide.load.r;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.util.j;

/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class b<T> implements v<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final T f4831a;

    public b(@NonNull T t) {
        this.f4831a = (T) j.a(t);
    }

    @Override // com.bumptech.glide.load.p.v
    public final int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<T> b() {
        return (Class<T>) this.f4831a.getClass();
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public final T get() {
        return this.f4831a;
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
    }
}
