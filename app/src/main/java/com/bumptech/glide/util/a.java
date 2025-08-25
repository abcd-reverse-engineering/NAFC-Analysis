package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import h.f1;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ByteBufferUtil.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f5356a = 16384;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReference<byte[]> f5357b = new AtomicReference<>();

    /* compiled from: ByteBufferUtil.java */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f5361a;

        /* renamed from: b, reason: collision with root package name */
        final int f5362b;

        /* renamed from: c, reason: collision with root package name */
        final byte[] f5363c;

        b(@NonNull byte[] bArr, int i2, int i3) {
            this.f5363c = bArr;
            this.f5361a = i2;
            this.f5362b = i3;
        }
    }

    private a() {
    }

    @NonNull
    public static ByteBuffer a(@NonNull File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                channel = randomAccessFile.getChannel();
            } catch (Throwable th) {
                th = th;
            }
            try {
                MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return mappedByteBufferLoad;
            } catch (Throwable th2) {
                fileChannel = channel;
                th = th2;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static byte[] b(@NonNull ByteBuffer byteBuffer) {
        b bVarA = a(byteBuffer);
        if (bVarA != null && bVarA.f5361a == 0 && bVarA.f5362b == bVarA.f5363c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        byteBufferAsReadOnlyBuffer.position(0);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    @NonNull
    public static InputStream c(@NonNull ByteBuffer byteBuffer) {
        return new C0079a(byteBuffer);
    }

    /* compiled from: ByteBufferUtil.java */
    /* renamed from: com.bumptech.glide.util.a$a, reason: collision with other inner class name */
    private static class C0079a extends InputStream {

        /* renamed from: c, reason: collision with root package name */
        private static final int f5358c = -1;

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final ByteBuffer f5359a;

        /* renamed from: b, reason: collision with root package name */
        private int f5360b = -1;

        C0079a(@NonNull ByteBuffer byteBuffer) {
            this.f5359a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f5359a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i2) {
            this.f5360b = this.f5359a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f5359a.hasRemaining()) {
                return this.f5359a.get() & f1.f16099c;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            if (this.f5360b == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f5359a.position(this.f5360b);
        }

        @Override // java.io.InputStream
        public long skip(long j2) throws IOException {
            if (!this.f5359a.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j2, available());
            this.f5359a.position((int) (r0.position() + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
            if (!this.f5359a.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i3, available());
            this.f5359a.get(bArr, i2, iMin);
            return iMin;
        }
    }

    public static void a(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            channel = randomAccessFile.getChannel();
            channel.write(byteBuffer);
            channel.force(false);
            channel.close();
            randomAccessFile.close();
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException unused) {
                }
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public static void a(@NonNull ByteBuffer byteBuffer, @NonNull OutputStream outputStream) throws IOException {
        b bVarA = a(byteBuffer);
        if (bVarA != null) {
            byte[] bArr = bVarA.f5363c;
            int i2 = bVarA.f5361a;
            outputStream.write(bArr, i2, bVarA.f5362b + i2);
            return;
        }
        byte[] andSet = f5357b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int iMin = Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, iMin);
            outputStream.write(andSet, 0, iMin);
        }
        f5357b.set(andSet);
    }

    @NonNull
    public static ByteBuffer a(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f5357b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int i2 = inputStream.read(andSet);
            if (i2 >= 0) {
                byteArrayOutputStream.write(andSet, 0, i2);
            } else {
                f5357b.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    @Nullable
    private static b a(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }
}
