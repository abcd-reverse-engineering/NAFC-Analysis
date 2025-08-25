package com.tencent.bugly.beta.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f8873a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static long f8874b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static long f8875c = 1;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f8876d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f8877e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f8878f;

    /* renamed from: g, reason: collision with root package name */
    private long f8879g;

    /* renamed from: h, reason: collision with root package name */
    private String f8880h;

    /* renamed from: i, reason: collision with root package name */
    private BufferedInputStream f8881i;

    /* renamed from: j, reason: collision with root package name */
    private long f8882j;

    /* renamed from: k, reason: collision with root package name */
    private long f8883k;

    public a(String str) throws Exception {
        this.f8876d = new byte[2];
        this.f8877e = new byte[4];
        this.f8878f = new byte[8];
        this.f8879g = f8875c;
        this.f8880h = null;
        this.f8881i = null;
        this.f8882j = 0L;
        this.f8883k = 0L;
        this.f8880h = str;
        this.f8881i = new BufferedInputStream(new FileInputStream(this.f8880h));
        this.f8882j = 0L;
        this.f8883k = 0L;
    }

    public synchronized void a(long j2) {
        this.f8879g = j2;
    }

    public synchronized boolean b(long j2) {
        if (this.f8881i == null) {
            return false;
        }
        if (j2 == 0) {
            return true;
        }
        long jSkip = j2;
        while (jSkip > 0) {
            try {
                jSkip -= this.f8881i.skip(jSkip);
            } catch (IOException unused) {
                return false;
            }
        }
        this.f8882j += j2;
        return true;
    }

    public synchronized short c() throws IOException {
        if (this.f8881i == null) {
            return (short) 0;
        }
        this.f8881i.read(this.f8876d);
        short sA = a(this.f8876d, this.f8879g);
        this.f8882j += 2;
        this.f8883k += 2;
        return sA;
    }

    public synchronized int d() throws IOException {
        if (this.f8881i == null) {
            return 0;
        }
        this.f8881i.read(this.f8877e);
        int iB = b(this.f8877e, this.f8879g);
        this.f8882j += 4;
        this.f8883k += 4;
        return iB;
    }

    public synchronized long e() throws IOException {
        if (this.f8881i == null) {
            return 0L;
        }
        this.f8881i.read(this.f8878f);
        long jC = c(this.f8878f, this.f8879g);
        this.f8882j += 8;
        this.f8883k += 8;
        return jC;
    }

    public synchronized long f() throws IOException {
        return b() & 255;
    }

    public synchronized long g() throws IOException {
        return c() & 65535;
    }

    public synchronized long h() throws IOException {
        return d() & 4294967295L;
    }

    public synchronized long i() throws IOException {
        return e();
    }

    private static int f(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) g(bArr);
    }

    private static long g(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j2 = 0;
        for (byte b2 : bArr) {
            j2 = (j2 << 8) | (b2 & 255);
        }
        return j2;
    }

    public synchronized boolean a() {
        try {
            if (this.f8881i != null) {
                this.f8881i.close();
            }
            this.f8881i = null;
            this.f8880h = null;
            this.f8882j = 0L;
            this.f8883k = 0L;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    private static int c(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) d(bArr);
    }

    private static long d(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j2 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            j2 = (j2 << 8) | (bArr[length] & 255);
        }
        return j2;
    }

    private static short e(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) f(bArr);
    }

    public synchronized byte b() throws IOException {
        if (this.f8881i == null) {
            return (byte) 0;
        }
        byte b2 = (byte) this.f8881i.read();
        this.f8882j++;
        this.f8883k++;
        return b2;
    }

    public static long c(byte[] bArr, long j2) {
        if (j2 == f8875c) {
            return d(bArr);
        }
        return g(bArr);
    }

    public synchronized boolean a(byte[] bArr) {
        try {
            this.f8881i.read(bArr);
            this.f8882j += bArr.length;
            this.f8883k += bArr.length;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    public a(String str, long j2) throws Exception {
        this.f8876d = new byte[2];
        this.f8877e = new byte[4];
        this.f8878f = new byte[8];
        this.f8879g = f8875c;
        this.f8880h = null;
        this.f8881i = null;
        this.f8882j = 0L;
        this.f8883k = 0L;
        this.f8880h = str;
        this.f8879g = j2;
        this.f8881i = new BufferedInputStream(new FileInputStream(this.f8880h));
        this.f8882j = 0L;
        this.f8883k = 0L;
    }

    private static short b(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) c(bArr);
    }

    public static int b(byte[] bArr, long j2) {
        if (j2 == f8875c) {
            return c(bArr);
        }
        return f(bArr);
    }

    public static short a(byte[] bArr, long j2) {
        if (j2 == f8875c) {
            return b(bArr);
        }
        return e(bArr);
    }
}
