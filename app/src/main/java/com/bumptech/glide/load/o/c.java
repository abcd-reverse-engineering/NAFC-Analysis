package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BufferedOutputStream.java */
/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final OutputStream f4262a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f4263b;

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.p.a0.b f4264c;

    /* renamed from: d, reason: collision with root package name */
    private int f4265d;

    public c(@NonNull OutputStream outputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void c() throws IOException {
        int i2 = this.f4265d;
        if (i2 > 0) {
            this.f4262a.write(this.f4263b, 0, i2);
            this.f4265d = 0;
        }
    }

    private void d() throws IOException {
        if (this.f4265d == this.f4263b.length) {
            c();
        }
    }

    private void e() {
        byte[] bArr = this.f4263b;
        if (bArr != null) {
            this.f4264c.put(bArr);
            this.f4263b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f4262a.close();
            e();
        } catch (Throwable th) {
            this.f4262a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        c();
        this.f4262a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.f4263b;
        int i3 = this.f4265d;
        this.f4265d = i3 + 1;
        bArr[i3] = (byte) i2;
        d();
    }

    @VisibleForTesting
    c(@NonNull OutputStream outputStream, com.bumptech.glide.load.p.a0.b bVar, int i2) {
        this.f4262a = outputStream;
        this.f4264c = bVar;
        this.f4263b = (byte[]) bVar.b(i2, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.f4265d == 0 && i5 >= this.f4263b.length) {
                this.f4262a.write(bArr, i6, i5);
                return;
            }
            int iMin = Math.min(i5, this.f4263b.length - this.f4265d);
            System.arraycopy(bArr, i6, this.f4263b, this.f4265d, iMin);
            this.f4265d += iMin;
            i4 += iMin;
            d();
        } while (i4 < i3);
    }
}
