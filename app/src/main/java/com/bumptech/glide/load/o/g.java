package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import h.f1;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ExifOrientationStream.java */
/* loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* renamed from: c, reason: collision with root package name */
    private static final int f4269c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f4270d = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: e, reason: collision with root package name */
    private static final int f4271e = f4270d.length;

    /* renamed from: f, reason: collision with root package name */
    private static final int f4272f = f4271e + 2;

    /* renamed from: a, reason: collision with root package name */
    private final byte f4273a;

    /* renamed from: b, reason: collision with root package name */
    private int f4274b;

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 >= -1 && i2 <= 8) {
            this.f4273a = (byte) i2;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2;
        int i3 = this.f4274b;
        int i4 = (i3 < 2 || i3 > (i2 = f4272f)) ? super.read() : i3 == i2 ? this.f4273a : f4270d[i3 - 2] & f1.f16099c;
        if (i4 != -1) {
            this.f4274b++;
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long jSkip = super.skip(j2);
        if (jSkip > 0) {
            this.f4274b = (int) (this.f4274b + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f4274b;
        int i6 = f4272f;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f4273a;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int iMin = Math.min(i6 - i5, i3);
            System.arraycopy(f4270d, this.f4274b - 2, bArr, i2, iMin);
            i4 = iMin;
        }
        if (i4 > 0) {
            this.f4274b += i4;
        }
        return i4;
    }
}
