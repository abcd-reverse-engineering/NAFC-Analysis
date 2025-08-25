package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream.java */
/* loaded from: classes.dex */
public class c extends InputStream {

    /* renamed from: c, reason: collision with root package name */
    private static final Queue<c> f5368c = l.a(0);

    /* renamed from: a, reason: collision with root package name */
    private InputStream f5369a;

    /* renamed from: b, reason: collision with root package name */
    private IOException f5370b;

    c() {
    }

    @NonNull
    public static c b(@NonNull InputStream inputStream) {
        c cVarPoll;
        synchronized (f5368c) {
            cVarPoll = f5368c.poll();
        }
        if (cVarPoll == null) {
            cVarPoll = new c();
        }
        cVarPoll.a(inputStream);
        return cVarPoll;
    }

    static void e() {
        while (!f5368c.isEmpty()) {
            f5368c.remove();
        }
    }

    void a(@NonNull InputStream inputStream) {
        this.f5369a = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f5369a.available();
    }

    @Nullable
    public IOException c() {
        return this.f5370b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5369a.close();
    }

    public void d() {
        this.f5370b = null;
        this.f5369a = null;
        synchronized (f5368c) {
            f5368c.offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f5369a.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f5369a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f5369a.read(bArr);
        } catch (IOException e2) {
            this.f5370b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f5369a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        try {
            return this.f5369a.skip(j2);
        } catch (IOException e2) {
            this.f5370b = e2;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f5369a.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f5370b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f5369a.read();
        } catch (IOException e2) {
            this.f5370b = e2;
            return -1;
        }
    }
}
