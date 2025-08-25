package com.bumptech.glide.load.r.d;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import h.f1;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RecyclableBufferedInputStream.java */
/* loaded from: classes.dex */
public class b0 extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private volatile byte[] f4838a;

    /* renamed from: b, reason: collision with root package name */
    private int f4839b;

    /* renamed from: c, reason: collision with root package name */
    private int f4840c;

    /* renamed from: d, reason: collision with root package name */
    private int f4841d;

    /* renamed from: e, reason: collision with root package name */
    private int f4842e;

    /* renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f4843f;

    /* compiled from: RecyclableBufferedInputStream.java */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    public b0(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f4841d;
        if (i2 != -1) {
            int i3 = this.f4842e - i2;
            int i4 = this.f4840c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f4839b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i4) {
                        length = i4;
                    }
                    byte[] bArr2 = (byte[]) this.f4843f.b(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f4838a = bArr2;
                    this.f4843f.put(bArr);
                    bArr = bArr2;
                } else {
                    int i5 = this.f4841d;
                    if (i5 > 0) {
                        System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                    }
                }
                this.f4842e -= this.f4841d;
                this.f4841d = 0;
                this.f4839b = 0;
                int i6 = this.f4842e;
                int i7 = inputStream.read(bArr, i6, bArr.length - i6);
                int i8 = this.f4842e;
                if (i7 > 0) {
                    i8 += i7;
                }
                this.f4839b = i8;
                return i7;
            }
        }
        int i9 = inputStream.read(bArr);
        if (i9 > 0) {
            this.f4841d = -1;
            this.f4842e = 0;
            this.f4839b = i9;
        }
        return i9;
    }

    private static IOException e() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f4838a == null || inputStream == null) {
            throw e();
        }
        return (this.f4839b - this.f4842e) + inputStream.available();
    }

    public synchronized void c() {
        this.f4840c = this.f4838a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4838a != null) {
            this.f4843f.put(this.f4838a);
            this.f4838a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void d() {
        if (this.f4838a != null) {
            this.f4843f.put(this.f4838a);
            this.f4838a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.f4840c = Math.max(this.f4840c, i2);
        this.f4841d = this.f4842e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f4838a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw e();
        }
        if (this.f4842e >= this.f4839b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f4838a && (bArr = this.f4838a) == null) {
            throw e();
        }
        if (this.f4839b - this.f4842e <= 0) {
            return -1;
        }
        int i2 = this.f4842e;
        this.f4842e = i2 + 1;
        return bArr[i2] & f1.f16099c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f4838a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f4841d) {
            throw new a("Mark has been invalidated, pos: " + this.f4842e + " markLimit: " + this.f4840c);
        }
        this.f4842e = this.f4841d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.f4838a;
        if (bArr == null) {
            throw e();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw e();
        }
        if (this.f4839b - this.f4842e >= j2) {
            this.f4842e = (int) (this.f4842e + j2);
            return j2;
        }
        long j3 = this.f4839b - this.f4842e;
        this.f4842e = this.f4839b;
        if (this.f4841d == -1 || j2 > this.f4840c) {
            return j3 + inputStream.skip(j2 - j3);
        }
        if (a(inputStream, bArr) == -1) {
            return j3;
        }
        if (this.f4839b - this.f4842e >= j2 - j3) {
            this.f4842e = (int) ((this.f4842e + j2) - j3);
            return j2;
        }
        long j4 = (j3 + this.f4839b) - this.f4842e;
        this.f4842e = this.f4839b;
        return j4;
    }

    @VisibleForTesting
    b0(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar, int i2) {
        super(inputStream);
        this.f4841d = -1;
        this.f4843f = bVar;
        this.f4838a = (byte[]) bVar.b(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.f4838a;
        if (bArr2 == null) {
            throw e();
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            if (this.f4842e < this.f4839b) {
                int i6 = this.f4839b - this.f4842e >= i3 ? i3 : this.f4839b - this.f4842e;
                System.arraycopy(bArr2, this.f4842e, bArr, i2, i6);
                this.f4842e += i6;
                if (i6 == i3 || inputStream.available() == 0) {
                    return i6;
                }
                i2 += i6;
                i4 = i3 - i6;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f4841d == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                    if (bArr2 != this.f4838a && (bArr2 = this.f4838a) == null) {
                        throw e();
                    }
                    i5 = this.f4839b - this.f4842e >= i4 ? i4 : this.f4839b - this.f4842e;
                    System.arraycopy(bArr2, this.f4842e, bArr, i2, i5);
                    this.f4842e += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        } else {
            throw e();
        }
    }
}
