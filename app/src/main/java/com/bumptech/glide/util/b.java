package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* loaded from: classes.dex */
public final class b extends FilterInputStream {

    /* renamed from: c, reason: collision with root package name */
    private static final String f5364c = "ContentLengthStream";

    /* renamed from: d, reason: collision with root package name */
    private static final int f5365d = -1;

    /* renamed from: a, reason: collision with root package name */
    private final long f5366a;

    /* renamed from: b, reason: collision with root package name */
    private int f5367b;

    private b(@NonNull InputStream inputStream, long j2) {
        super(inputStream);
        this.f5366a = j2;
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, @Nullable String str) {
        return a(inputStream, a(str));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f5366a - this.f5367b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i2;
        i2 = super.read();
        a(i2 >= 0 ? 1 : -1);
        return i2;
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, long j2) {
        return new b(inputStream, j2);
    }

    private static int a(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                if (Log.isLoggable(f5364c, 3)) {
                    String str2 = "failed to parse content length header: " + str;
                }
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        return a(super.read(bArr, i2, i3));
    }

    private int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f5367b += i2;
        } else if (this.f5366a - this.f5367b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f5366a + ", but read: " + this.f5367b);
        }
        return i2;
    }
}
