package com.bumptech.glide.n;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
class b implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private static final byte f5130f = 13;

    /* renamed from: g, reason: collision with root package name */
    private static final byte f5131g = 10;

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f5132a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f5133b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f5134c;

    /* renamed from: d, reason: collision with root package name */
    private int f5135d;

    /* renamed from: e, reason: collision with root package name */
    private int f5136e;

    /* compiled from: StrictLineReader.java */
    class a extends ByteArrayOutputStream {
        a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, (i2 <= 0 || ((ByteArrayOutputStream) this).buf[i2 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i2 - 1, b.this.f5133b.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void e() throws IOException {
        InputStream inputStream = this.f5132a;
        byte[] bArr = this.f5134c;
        int i2 = inputStream.read(bArr, 0, bArr.length);
        if (i2 == -1) {
            throw new EOFException();
        }
        this.f5135d = 0;
        this.f5136e = i2;
    }

    public boolean c() {
        return this.f5136e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f5132a) {
            if (this.f5134c != null) {
                this.f5134c = null;
                this.f5132a.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String d() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f5132a
            monitor-enter(r0)
            byte[] r1 = r7.f5134c     // Catch: java.lang.Throwable -> L97
            if (r1 == 0) goto L8f
            int r1 = r7.f5135d     // Catch: java.lang.Throwable -> L97
            int r2 = r7.f5136e     // Catch: java.lang.Throwable -> L97
            if (r1 < r2) goto L10
            r7.e()     // Catch: java.lang.Throwable -> L97
        L10:
            int r1 = r7.f5135d     // Catch: java.lang.Throwable -> L97
        L12:
            int r2 = r7.f5136e     // Catch: java.lang.Throwable -> L97
            r3 = 10
            if (r1 == r2) goto L49
            byte[] r2 = r7.f5134c     // Catch: java.lang.Throwable -> L97
            r2 = r2[r1]     // Catch: java.lang.Throwable -> L97
            if (r2 != r3) goto L46
            int r2 = r7.f5135d     // Catch: java.lang.Throwable -> L97
            if (r1 == r2) goto L2d
            byte[] r2 = r7.f5134c     // Catch: java.lang.Throwable -> L97
            int r3 = r1 + (-1)
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L97
            r4 = 13
            if (r2 != r4) goto L2d
            goto L2e
        L2d:
            r3 = r1
        L2e:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L97
            byte[] r4 = r7.f5134c     // Catch: java.lang.Throwable -> L97
            int r5 = r7.f5135d     // Catch: java.lang.Throwable -> L97
            int r6 = r7.f5135d     // Catch: java.lang.Throwable -> L97
            int r3 = r3 - r6
            java.nio.charset.Charset r6 = r7.f5133b     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L97
            r2.<init>(r4, r5, r3, r6)     // Catch: java.lang.Throwable -> L97
            int r1 = r1 + 1
            r7.f5135d = r1     // Catch: java.lang.Throwable -> L97
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L97
            return r2
        L46:
            int r1 = r1 + 1
            goto L12
        L49:
            com.bumptech.glide.n.b$a r1 = new com.bumptech.glide.n.b$a     // Catch: java.lang.Throwable -> L97
            int r2 = r7.f5136e     // Catch: java.lang.Throwable -> L97
            int r4 = r7.f5135d     // Catch: java.lang.Throwable -> L97
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L97
        L55:
            byte[] r2 = r7.f5134c     // Catch: java.lang.Throwable -> L97
            int r4 = r7.f5135d     // Catch: java.lang.Throwable -> L97
            int r5 = r7.f5136e     // Catch: java.lang.Throwable -> L97
            int r6 = r7.f5135d     // Catch: java.lang.Throwable -> L97
            int r5 = r5 - r6
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L97
            r2 = -1
            r7.f5136e = r2     // Catch: java.lang.Throwable -> L97
            r7.e()     // Catch: java.lang.Throwable -> L97
            int r2 = r7.f5135d     // Catch: java.lang.Throwable -> L97
        L69:
            int r4 = r7.f5136e     // Catch: java.lang.Throwable -> L97
            if (r2 == r4) goto L55
            byte[] r4 = r7.f5134c     // Catch: java.lang.Throwable -> L97
            r4 = r4[r2]     // Catch: java.lang.Throwable -> L97
            if (r4 != r3) goto L8c
            int r3 = r7.f5135d     // Catch: java.lang.Throwable -> L97
            if (r2 == r3) goto L82
            byte[] r3 = r7.f5134c     // Catch: java.lang.Throwable -> L97
            int r4 = r7.f5135d     // Catch: java.lang.Throwable -> L97
            int r5 = r7.f5135d     // Catch: java.lang.Throwable -> L97
            int r5 = r2 - r5
            r1.write(r3, r4, r5)     // Catch: java.lang.Throwable -> L97
        L82:
            int r2 = r2 + 1
            r7.f5135d = r2     // Catch: java.lang.Throwable -> L97
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L97
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L97
            return r1
        L8c:
            int r2 = r2 + 1
            goto L69
        L8f:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L97
            throw r1     // Catch: java.lang.Throwable -> L97
        L97:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L97
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.n.b.d():java.lang.String");
    }

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f5138a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f5132a = inputStream;
        this.f5133b = charset;
        this.f5134c = new byte[i2];
    }
}
