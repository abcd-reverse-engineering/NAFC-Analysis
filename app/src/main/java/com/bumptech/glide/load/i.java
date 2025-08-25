package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;

/* compiled from: Option.java */
/* loaded from: classes.dex */
public final class i<T> {

    /* renamed from: e, reason: collision with root package name */
    private static final b<Object> f4251e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final T f4252a;

    /* renamed from: b, reason: collision with root package name */
    private final b<T> f4253b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4254c;

    /* renamed from: d, reason: collision with root package name */
    private volatile byte[] f4255d;

    /* compiled from: Option.java */
    class a implements b<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.i.b
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* compiled from: Option.java */
    public interface b<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private i(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        this.f4254c = com.bumptech.glide.util.j.a(str);
        this.f4252a = t;
        this.f4253b = (b) com.bumptech.glide.util.j.a(bVar);
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str) {
        return new i<>(str, null, b());
    }

    @NonNull
    private static <T> b<T> b() {
        return (b<T>) f4251e;
    }

    @NonNull
    private byte[] c() {
        if (this.f4255d == null) {
            this.f4255d = this.f4254c.getBytes(g.f4249b);
        }
        return this.f4255d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f4254c.equals(((i) obj).f4254c);
        }
        return false;
    }

    public int hashCode() {
        return this.f4254c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f4254c + "'}";
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str, @NonNull T t) {
        return new i<>(str, t, b());
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str, @NonNull b<T> bVar) {
        return new i<>(str, null, bVar);
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        return new i<>(str, t, bVar);
    }

    @Nullable
    public T a() {
        return this.f4252a;
    }

    public void a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f4253b.a(c(), t, messageDigest);
    }
}
