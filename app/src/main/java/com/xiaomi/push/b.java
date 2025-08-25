package com.xiaomi.push;

import h.f1;
import java.io.InputStream;
import java.util.Vector;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f12473a;

    /* renamed from: a, reason: collision with other field name */
    private final InputStream f206a;

    /* renamed from: a, reason: collision with other field name */
    private final byte[] f207a;

    /* renamed from: b, reason: collision with root package name */
    private int f12474b;

    /* renamed from: c, reason: collision with root package name */
    private int f12475c;

    /* renamed from: d, reason: collision with root package name */
    private int f12476d;

    /* renamed from: e, reason: collision with root package name */
    private int f12477e;

    /* renamed from: f, reason: collision with root package name */
    private int f12478f;

    /* renamed from: g, reason: collision with root package name */
    private int f12479g;

    /* renamed from: h, reason: collision with root package name */
    private int f12480h;

    /* renamed from: i, reason: collision with root package name */
    private int f12481i;

    private b(byte[] bArr, int i2, int i3) {
        this.f12478f = Integer.MAX_VALUE;
        this.f12480h = 64;
        this.f12481i = c.c.a.b.a.a.B1;
        this.f207a = bArr;
        this.f12473a = i3 + i2;
        this.f12475c = i2;
        this.f206a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m172b() {
        return m174c();
    }

    public int c() {
        return d();
    }

    public int d() throws d {
        int i2;
        byte bA = a();
        if (bA >= 0) {
            return bA;
        }
        int i3 = bA & h.q2.t.n.f16414b;
        byte bA2 = a();
        if (bA2 >= 0) {
            i2 = bA2 << 7;
        } else {
            i3 |= (bA2 & h.q2.t.n.f16414b) << 7;
            byte bA3 = a();
            if (bA3 >= 0) {
                i2 = bA3 << com.umeng.analytics.pro.cw.f10302l;
            } else {
                i3 |= (bA3 & h.q2.t.n.f16414b) << 14;
                byte bA4 = a();
                if (bA4 < 0) {
                    int i4 = i3 | ((bA4 & h.q2.t.n.f16414b) << 21);
                    byte bA5 = a();
                    int i5 = i4 | (bA5 << 28);
                    if (bA5 >= 0) {
                        return i5;
                    }
                    for (int i6 = 0; i6 < 5; i6++) {
                        if (a() >= 0) {
                            return i5;
                        }
                    }
                    throw d.c();
                }
                i2 = bA4 << 21;
            }
        }
        return i3 | i2;
    }

    public int e() throws d {
        return (a() & f1.f16099c) | ((a() & f1.f16099c) << 8) | ((a() & f1.f16099c) << 16) | ((a() & f1.f16099c) << 24);
    }

    public static b a(byte[] bArr, int i2, int i3) {
        return new b(bArr, i2, i3);
    }

    /* renamed from: b, reason: collision with other method in class */
    public int m171b() {
        return d();
    }

    /* renamed from: c, reason: collision with other method in class */
    public long m174c() throws d {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            j2 |= (r3 & h.q2.t.n.f16414b) << i2;
            if ((a() & h.q2.t.n.f16413a) == 0) {
                return j2;
            }
        }
        throw d.c();
    }

    private void b() {
        this.f12473a += this.f12474b;
        int i2 = this.f12477e;
        int i3 = this.f12473a;
        int i4 = i2 + i3;
        int i5 = this.f12478f;
        if (i4 > i5) {
            this.f12474b = i4 - i5;
            this.f12473a = i3 - this.f12474b;
        } else {
            this.f12474b = 0;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m162a() throws d {
        if (m173b()) {
            this.f12476d = 0;
            return 0;
        }
        this.f12476d = d();
        int i2 = this.f12476d;
        if (i2 != 0) {
            return i2;
        }
        throw d.d();
    }

    public void c(int i2) throws d {
        if (i2 >= 0) {
            int i3 = this.f12477e;
            int i4 = this.f12475c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f12478f;
            if (i5 <= i6) {
                int i7 = this.f12473a;
                if (i2 <= i7 - i4) {
                    this.f12475c = i4 + i2;
                    return;
                }
                int i8 = i7 - i4;
                this.f12477e = i3 + i7;
                this.f12475c = 0;
                this.f12473a = 0;
                while (i8 < i2) {
                    InputStream inputStream = this.f206a;
                    int iSkip = inputStream == null ? -1 : (int) inputStream.skip(i2 - i8);
                    if (iSkip > 0) {
                        i8 += iSkip;
                        this.f12477e += iSkip;
                    } else {
                        throw d.a();
                    }
                }
                return;
            }
            c((i6 - i3) - i4);
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m167a(int i2) throws d {
        if (this.f12476d != i2) {
            throw d.e();
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public long m175d() throws d {
        return ((a() & 255) << 8) | (a() & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    private b(InputStream inputStream) {
        this.f12478f = Integer.MAX_VALUE;
        this.f12480h = 64;
        this.f12481i = c.c.a.b.a.a.B1;
        this.f207a = new byte[4096];
        this.f12473a = 0;
        this.f12475c = 0;
        this.f206a = inputStream;
    }

    public void b(int i2) {
        this.f12478f = i2;
        b();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m169a(int i2) throws d {
        int iA = f.a(i2);
        if (iA == 0) {
            m171b();
            return true;
        }
        if (iA == 1) {
            m175d();
            return true;
        }
        if (iA == 2) {
            c(d());
            return true;
        }
        if (iA == 3) {
            m166a();
            m167a(f.a(f.b(i2), 4));
            return true;
        }
        if (iA == 4) {
            return false;
        }
        if (iA == 5) {
            e();
            return true;
        }
        throw d.f();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m173b() {
        return this.f12475c == this.f12473a && !a(false);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m166a() throws d {
        int iM162a;
        do {
            iM162a = m162a();
            if (iM162a == 0) {
                return;
            }
        } while (m169a(iM162a));
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m163a() {
        return m174c();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m168a() {
        return d() != 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m165a() throws d {
        int iD = d();
        int i2 = this.f12473a;
        int i3 = this.f12475c;
        if (iD <= i2 - i3 && iD > 0) {
            String str = new String(this.f207a, i3, iD, "UTF-8");
            this.f12475c += iD;
            return str;
        }
        return new String(m170a(iD), "UTF-8");
    }

    public void a(e eVar) throws d {
        int iD = d();
        if (this.f12479g < this.f12480h) {
            int iA = a(iD);
            this.f12479g++;
            eVar.a(this);
            m167a(0);
            this.f12479g--;
            b(iA);
            return;
        }
        throw d.g();
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m164a() throws d {
        int iD = d();
        int i2 = this.f12473a;
        int i3 = this.f12475c;
        if (iD <= i2 - i3 && iD > 0) {
            a aVarA = a.a(this.f207a, i3, iD);
            this.f12475c += iD;
            return aVarA;
        }
        return a.a(m170a(iD));
    }

    public int a(int i2) throws d {
        if (i2 >= 0) {
            int i3 = i2 + this.f12477e + this.f12475c;
            int i4 = this.f12478f;
            if (i3 <= i4) {
                this.f12478f = i3;
                b();
                return i4;
            }
            throw d.a();
        }
        throw d.b();
    }

    private boolean a(boolean z) throws d {
        int i2 = this.f12475c;
        int i3 = this.f12473a;
        if (i2 >= i3) {
            int i4 = this.f12477e;
            if (i4 + i3 == this.f12478f) {
                if (z) {
                    throw d.a();
                }
                return false;
            }
            this.f12477e = i4 + i3;
            this.f12475c = 0;
            InputStream inputStream = this.f206a;
            this.f12473a = inputStream == null ? -1 : inputStream.read(this.f207a);
            int i5 = this.f12473a;
            if (i5 == 0 || i5 < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f12473a + "\nThe InputStream implementation is buggy.");
            }
            if (i5 == -1) {
                this.f12473a = 0;
                if (z) {
                    throw d.a();
                }
                return false;
            }
            b();
            int i6 = this.f12477e + this.f12473a + this.f12474b;
            if (i6 > this.f12481i || i6 < 0) {
                throw d.h();
            }
            return true;
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    public byte a() throws d {
        if (this.f12475c == this.f12473a) {
            a(true);
        }
        byte[] bArr = this.f207a;
        int i2 = this.f12475c;
        this.f12475c = i2 + 1;
        return bArr[i2];
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m170a(int i2) throws d {
        if (i2 >= 0) {
            int i3 = this.f12477e;
            int i4 = this.f12475c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f12478f;
            if (i5 <= i6) {
                int i7 = this.f12473a;
                if (i2 <= i7 - i4) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f207a, i4, bArr, 0, i2);
                    this.f12475c += i2;
                    return bArr;
                }
                if (i2 < 4096) {
                    byte[] bArr2 = new byte[i2];
                    int i8 = i7 - i4;
                    System.arraycopy(this.f207a, i4, bArr2, 0, i8);
                    this.f12475c = this.f12473a;
                    a(true);
                    while (true) {
                        int i9 = i2 - i8;
                        int i10 = this.f12473a;
                        if (i9 > i10) {
                            System.arraycopy(this.f207a, 0, bArr2, i8, i10);
                            int i11 = this.f12473a;
                            i8 += i11;
                            this.f12475c = i11;
                            a(true);
                        } else {
                            System.arraycopy(this.f207a, 0, bArr2, i8, i9);
                            this.f12475c = i9;
                            return bArr2;
                        }
                    }
                } else {
                    this.f12477e = i3 + i7;
                    this.f12475c = 0;
                    this.f12473a = 0;
                    int length = i7 - i4;
                    int length2 = i2 - length;
                    Vector vector = new Vector();
                    while (length2 > 0) {
                        byte[] bArr3 = new byte[Math.min(length2, 4096)];
                        int i12 = 0;
                        while (i12 < bArr3.length) {
                            InputStream inputStream = this.f206a;
                            int i13 = inputStream == null ? -1 : inputStream.read(bArr3, i12, bArr3.length - i12);
                            if (i13 == -1) {
                                throw d.a();
                            }
                            this.f12477e += i13;
                            i12 += i13;
                        }
                        length2 -= bArr3.length;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.f207a, i4, bArr4, 0, length);
                    for (int i14 = 0; i14 < vector.size(); i14++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i14);
                        System.arraycopy(bArr5, 0, bArr4, length, bArr5.length);
                        length += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                c((i6 - i3) - i4);
                throw d.a();
            }
        } else {
            throw d.b();
        }
    }
}
