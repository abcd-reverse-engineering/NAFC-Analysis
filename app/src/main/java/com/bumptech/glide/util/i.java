package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f5383a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f5384b;

    /* renamed from: c, reason: collision with root package name */
    private Class<?> f5385c;

    public i() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f5383a.equals(iVar.f5383a) && this.f5384b.equals(iVar.f5384b) && l.b(this.f5385c, iVar.f5385c);
    }

    public int hashCode() {
        int iHashCode = ((this.f5383a.hashCode() * 31) + this.f5384b.hashCode()) * 31;
        Class<?> cls = this.f5385c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f5383a + ", second=" + this.f5384b + '}';
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f5383a = cls;
        this.f5384b = cls2;
        this.f5385c = cls3;
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
