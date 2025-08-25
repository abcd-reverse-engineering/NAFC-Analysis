package com.bumptech.glide.o;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* compiled from: GifDecoder.java */
/* loaded from: classes.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5140a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f5141b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f5142c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f5143d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f5144e = 0;

    /* compiled from: GifDecoder.java */
    /* renamed from: com.bumptech.glide.o.a$a, reason: collision with other inner class name */
    public interface InterfaceC0076a {
        @NonNull
        Bitmap a(int i2, int i3, @NonNull Bitmap.Config config);

        void a(@NonNull Bitmap bitmap);

        void a(@NonNull byte[] bArr);

        void a(@NonNull int[] iArr);

        @NonNull
        int[] a(int i2);

        @NonNull
        byte[] b(int i2);
    }

    /* compiled from: GifDecoder.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    int a(int i2);

    int a(@Nullable InputStream inputStream, int i2);

    @Nullable
    Bitmap a();

    void a(@NonNull Bitmap.Config config);

    void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer);

    void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i2);

    void a(@NonNull c cVar, @NonNull byte[] bArr);

    void b();

    int c();

    void clear();

    int d();

    @NonNull
    ByteBuffer e();

    void f();

    int g();

    int getHeight();

    int getWidth();

    int h();

    int i();

    int j();

    int k();

    @Deprecated
    int l();

    int read(@Nullable byte[] bArr);
}
