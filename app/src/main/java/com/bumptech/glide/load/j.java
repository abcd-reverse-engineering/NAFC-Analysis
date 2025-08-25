package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* compiled from: Options.java */
/* loaded from: classes.dex */
public final class j implements g {

    /* renamed from: c, reason: collision with root package name */
    private final ArrayMap<i<?>, Object> f4256c = new CachedHashCodeArrayMap();

    public void a(@NonNull j jVar) {
        this.f4256c.putAll((SimpleArrayMap<? extends i<?>, ? extends Object>) jVar.f4256c);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f4256c.equals(((j) obj).f4256c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f4256c.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f4256c + '}';
    }

    @NonNull
    public <T> j a(@NonNull i<T> iVar, @NonNull T t) {
        this.f4256c.put(iVar, t);
        return this;
    }

    @Nullable
    public <T> T a(@NonNull i<T> iVar) {
        return this.f4256c.containsKey(iVar) ? (T) this.f4256c.get(iVar) : iVar.a();
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f4256c.size(); i2++) {
            a(this.f4256c.keyAt(i2), this.f4256c.valueAt(i2), messageDigest);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(@NonNull i<T> iVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        iVar.a((i<T>) obj, messageDigest);
    }
}
