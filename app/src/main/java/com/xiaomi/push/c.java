package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f12534a;

    /* renamed from: a, reason: collision with other field name */
    private final OutputStream f244a;

    /* renamed from: a, reason: collision with other field name */
    private final byte[] f245a;

    /* renamed from: b, reason: collision with root package name */
    private int f12535b;

    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(byte[] bArr, int i2, int i3) {
        this.f244a = null;
        this.f245a = bArr;
        this.f12535b = i2;
        this.f12534a = i2 + i3;
    }

    public static int a(boolean z) {
        return 1;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static int c(long j2) {
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (((-16384) & j2) == 0) {
            return 2;
        }
        if (((-2097152) & j2) == 0) {
            return 3;
        }
        if (((-268435456) & j2) == 0) {
            return 4;
        }
        if (((-34359738368L) & j2) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j2) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j2) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j2) == 0) {
            return 8;
        }
        return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private void c() throws IOException {
        OutputStream outputStream = this.f244a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f245a, 0, this.f12535b);
        this.f12535b = 0;
    }

    public static int d(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m212b(int i2, long j2) throws IOException {
        c(i2, 0);
        m213b(j2);
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m216d(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            m214c((i2 & 127) | 128);
            i2 >>>= 7;
        }
        m214c(i2);
    }

    public static c a(OutputStream outputStream, int i2) {
        return new c(outputStream, new byte[i2]);
    }

    public static c a(byte[] bArr, int i2, int i3) {
        return new c(bArr, i2, i3);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m211b(int i2, int i3) throws IOException {
        c(i2, 0);
        m210b(i3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m199a(int i2, long j2) throws IOException {
        c(i2, 0);
        m204a(j2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m213b(long j2) throws IOException {
        m215c(j2);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m214c(int i2) throws IOException {
        a((byte) i2);
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f244a = outputStream;
        this.f245a = bArr;
        this.f12535b = 0;
        this.f12534a = bArr.length;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m198a(int i2, int i3) throws IOException {
        c(i2, 0);
        m197a(i3);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m210b(int i2) throws IOException {
        m216d(i2);
    }

    public void c(int i2, int i3) throws IOException {
        m216d(f.a(i2, i3));
    }

    public static int b(int i2, long j2) {
        return c(i2) + b(j2);
    }

    public static int c(int i2) {
        return d(f.a(i2, 0));
    }

    public static int b(int i2, int i3) {
        return c(i2) + b(i3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m203a(int i2, boolean z) throws IOException {
        c(i2, 0);
        m208a(z);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m215c(long j2) throws IOException {
        while (((-128) & j2) != 0) {
            m214c((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        m214c((int) j2);
    }

    public static int b(long j2) {
        return c(j2);
    }

    public static int b(int i2) {
        return d(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m202a(int i2, String str) throws IOException {
        c(i2, 2);
        m207a(str);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m201a(int i2, e eVar) throws IOException {
        c(i2, 2);
        m206a(eVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m200a(int i2, com.xiaomi.push.a aVar) throws IOException {
        c(i2, 2);
        m205a(aVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m204a(long j2) throws IOException {
        m215c(j2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m197a(int i2) throws IOException {
        if (i2 >= 0) {
            m216d(i2);
        } else {
            m215c(i2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m208a(boolean z) throws IOException {
        m214c(z ? 1 : 0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m207a(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m216d(bytes.length);
        a(bytes);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m206a(e eVar) throws IOException {
        m216d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m205a(com.xiaomi.push.a aVar) throws IOException {
        byte[] bArrM127a = aVar.m127a();
        m216d(bArrM127a.length);
        a(bArrM127a);
    }

    public static int a(int i2, long j2) {
        return c(i2) + a(j2);
    }

    public static int a(int i2, int i3) {
        return c(i2) + a(i3);
    }

    public static int a(int i2, boolean z) {
        return c(i2) + a(z);
    }

    public static int a(int i2, String str) {
        return c(i2) + a(str);
    }

    public static int a(int i2, e eVar) {
        return c(i2) + a(eVar);
    }

    public static int a(int i2, com.xiaomi.push.a aVar) {
        return c(i2) + a(aVar);
    }

    public static int a(long j2) {
        return c(j2);
    }

    public static int a(int i2) {
        if (i2 >= 0) {
            return d(i2);
        }
        return 10;
    }

    public static int a(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(e eVar) {
        int iB = eVar.b();
        return d(iB) + iB;
    }

    public static int a(com.xiaomi.push.a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m196a() throws IOException {
        if (this.f244a != null) {
            c();
        }
    }

    public int a() {
        if (this.f244a == null) {
            return this.f12534a - this.f12535b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void a(byte b2) throws IOException {
        if (this.f12535b == this.f12534a) {
            c();
        }
        byte[] bArr = this.f245a;
        int i2 = this.f12535b;
        this.f12535b = i2 + 1;
        bArr[i2] = b2;
    }

    public void a(byte[] bArr) throws IOException {
        m209a(bArr, 0, bArr.length);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m209a(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f12534a;
        int i5 = this.f12535b;
        if (i4 - i5 >= i3) {
            System.arraycopy(bArr, i2, this.f245a, i5, i3);
            this.f12535b += i3;
            return;
        }
        int i6 = i4 - i5;
        System.arraycopy(bArr, i2, this.f245a, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f12535b = this.f12534a;
        c();
        if (i8 <= this.f12534a) {
            System.arraycopy(bArr, i7, this.f245a, 0, i8);
            this.f12535b = i8;
        } else {
            this.f244a.write(bArr, i7, i8);
        }
    }
}
