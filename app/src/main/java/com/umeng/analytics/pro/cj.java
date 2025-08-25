package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TCompactProtocol.java */
/* loaded from: classes2.dex */
public class cj extends cp {

    /* renamed from: d, reason: collision with root package name */
    private static final cu f10238d = new cu("");

    /* renamed from: e, reason: collision with root package name */
    private static final ck f10239e = new ck("", (byte) 0, 0);

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f10240f = new byte[16];

    /* renamed from: h, reason: collision with root package name */
    private static final byte f10241h = -126;

    /* renamed from: i, reason: collision with root package name */
    private static final byte f10242i = 1;

    /* renamed from: j, reason: collision with root package name */
    private static final byte f10243j = 31;

    /* renamed from: k, reason: collision with root package name */
    private static final byte f10244k = -32;

    /* renamed from: l, reason: collision with root package name */
    private static final int f10245l = 5;

    /* renamed from: a, reason: collision with root package name */
    byte[] f10246a;

    /* renamed from: b, reason: collision with root package name */
    byte[] f10247b;

    /* renamed from: c, reason: collision with root package name */
    byte[] f10248c;

    /* renamed from: m, reason: collision with root package name */
    private bo f10249m;
    private short n;
    private ck o;
    private Boolean p;
    private final long q;
    private byte[] r;

    /* compiled from: TCompactProtocol.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final byte f10251a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final byte f10252b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final byte f10253c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final byte f10254d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final byte f10255e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static final byte f10256f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static final byte f10257g = 7;

        /* renamed from: h, reason: collision with root package name */
        public static final byte f10258h = 8;

        /* renamed from: i, reason: collision with root package name */
        public static final byte f10259i = 9;

        /* renamed from: j, reason: collision with root package name */
        public static final byte f10260j = 10;

        /* renamed from: k, reason: collision with root package name */
        public static final byte f10261k = 11;

        /* renamed from: l, reason: collision with root package name */
        public static final byte f10262l = 12;

        private b() {
        }
    }

    static {
        byte[] bArr = f10240f;
        bArr[0] = 0;
        bArr[2] = 1;
        bArr[3] = 3;
        bArr[6] = 4;
        bArr[8] = 5;
        bArr[10] = 6;
        bArr[4] = 7;
        bArr[11] = 8;
        bArr[15] = 9;
        bArr[14] = 10;
        bArr[13] = 11;
        bArr[12] = 12;
    }

    public cj(dd ddVar, long j2) {
        super(ddVar);
        this.f10249m = new bo(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.f10246a = new byte[5];
        this.f10247b = new byte[10];
        this.r = new byte[1];
        this.f10248c = new byte[1];
        this.q = j2;
    }

    private int E() throws bw {
        int i2 = 0;
        if (this.f10278g.h() >= 5) {
            byte[] bArrF = this.f10278g.f();
            int iG = this.f10278g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                i3 |= (b2 & h.q2.t.n.f16414b) << i4;
                if ((b2 & h.q2.t.n.f16413a) != 128) {
                    this.f10278g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte bU = u();
                i2 |= (bU & h.q2.t.n.f16414b) << i5;
                if ((bU & h.q2.t.n.f16413a) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws bw {
        int i2 = 0;
        long j2 = 0;
        if (this.f10278g.h() >= 10) {
            byte[] bArrF = this.f10278g.f();
            int iG = this.f10278g.g();
            int i3 = 0;
            while (true) {
                j2 |= (r7 & h.q2.t.n.f16414b) << i3;
                if ((bArrF[iG + i2] & h.q2.t.n.f16413a) != 128) {
                    break;
                }
                i3 += 7;
                i2++;
            }
            this.f10278g.a(i2 + 1);
        } else {
            while (true) {
                j2 |= (r0 & h.q2.t.n.f16414b) << i2;
                if ((u() & h.q2.t.n.f16413a) != 128) {
                    break;
                }
                i2 += 7;
            }
        }
        return j2;
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & cw.f10303m;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private byte[] e(int i2) throws bw {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.f10278g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws cq {
        if (i2 < 0) {
            throw new cq("Negative length: " + i2);
        }
        long j2 = this.q;
        if (j2 == -1 || i2 <= j2) {
            return;
        }
        throw new cq("Length exceeded max allowed: " + i2);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.cp
    public ByteBuffer A() throws bw {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iE];
        this.f10278g.d(bArr, 0, iE);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cp
    public void B() {
        this.f10249m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cp
    public void a() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cn cnVar) throws bw {
        b(f10241h);
        d(((cnVar.f10272b << 5) & (-32)) | 1);
        b(cnVar.f10273c);
        a(cnVar.f10271a);
    }

    @Override // com.umeng.analytics.pro.cp
    public void b() throws bw {
        this.n = this.f10249m.a();
    }

    @Override // com.umeng.analytics.pro.cp
    public void c() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void d() throws bw {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.cp
    public void e() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void f() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void g() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cn h() throws bw {
        byte bU = u();
        if (bU != -126) {
            throw new cq("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(bU));
        }
        byte bU2 = u();
        byte b2 = (byte) (bU2 & f10243j);
        if (b2 == 1) {
            return new cn(z(), (byte) ((bU2 >> 5) & 3), E());
        }
        throw new cq("Expected version 1 but got " + ((int) b2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void i() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cu j() throws bw {
        this.f10249m.a(this.n);
        this.n = (short) 0;
        return f10238d;
    }

    @Override // com.umeng.analytics.pro.cp
    public void k() throws bw {
        this.n = this.f10249m.a();
    }

    @Override // com.umeng.analytics.pro.cp
    public ck l() throws bw {
        byte bU = u();
        if (bU == 0) {
            return f10239e;
        }
        short s = (short) ((bU & 240) >> 4);
        short sV = s == 0 ? v() : (short) (this.n + s);
        byte b2 = (byte) (bU & cw.f10303m);
        ck ckVar = new ck("", d(b2), sV);
        if (c(bU)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = ckVar.f10265c;
        return ckVar;
    }

    @Override // com.umeng.analytics.pro.cp
    public void m() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cm n() throws bw {
        int iE = E();
        byte bU = iE == 0 ? (byte) 0 : u();
        return new cm(d((byte) (bU >> 4)), d((byte) (bU & cw.f10303m)), iE);
    }

    @Override // com.umeng.analytics.pro.cp
    public void o() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cl p() throws bw {
        byte bU = u();
        int iE = (bU >> 4) & 15;
        if (iE == 15) {
            iE = E();
        }
        return new cl(d(bU), iE);
    }

    @Override // com.umeng.analytics.pro.cp
    public void q() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public ct r() throws bw {
        return new ct(p());
    }

    @Override // com.umeng.analytics.pro.cp
    public void s() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean t() throws bw {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.p = null;
        return zBooleanValue;
    }

    @Override // com.umeng.analytics.pro.cp
    public byte u() throws bw {
        if (this.f10278g.h() <= 0) {
            this.f10278g.d(this.f10248c, 0, 1);
            return this.f10248c[0];
        }
        byte b2 = this.f10278g.f()[this.f10278g.g()];
        this.f10278g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.cp
    public short v() throws bw {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.cp
    public int w() throws bw {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.cp
    public long x() throws bw {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.cp
    public double y() throws bw {
        byte[] bArr = new byte[8];
        this.f10278g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.cp
    public String z() throws bw {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return "";
        }
        try {
            if (this.f10278g.h() < iE) {
                return new String(e(iE), "UTF-8");
            }
            String str = new String(this.f10278g.f(), this.f10278g.g(), iE, "UTF-8");
            this.f10278g.a(iE);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bw("UTF-8 not supported!");
        }
    }

    /* compiled from: TCompactProtocol.java */
    public static class a implements cr {

        /* renamed from: a, reason: collision with root package name */
        private final long f10250a;

        public a() {
            this.f10250a = -1L;
        }

        @Override // com.umeng.analytics.pro.cr
        public cp a(dd ddVar) {
            return new cj(ddVar, this.f10250a);
        }

        public a(int i2) {
            this.f10250a = i2;
        }
    }

    private void b(int i2) throws bw {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.f10246a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.f10246a;
        bArr[i3] = (byte) i2;
        this.f10278g.b(bArr, 0, i3 + 1);
    }

    private void d(int i2) throws bw {
        b((byte) i2);
    }

    private byte d(byte b2) throws cq {
        byte b3 = (byte) (b2 & cw.f10303m);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return cw.f10303m;
            case 10:
                return cw.f10302l;
            case 11:
                return cw.f10301k;
            case 12:
                return (byte) 12;
            default:
                throw new cq("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f10240f[b2];
    }

    private void b(long j2) throws bw {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.f10247b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.f10247b;
        bArr[i2] = (byte) j2;
        this.f10278g.b(bArr, 0, i2 + 1);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cu cuVar) throws bw {
        this.f10249m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ck ckVar) throws bw {
        if (ckVar.f10264b == 2) {
            this.o = ckVar;
        } else {
            a(ckVar, (byte) -1);
        }
    }

    private void b(byte b2) throws bw {
        byte[] bArr = this.r;
        bArr[0] = b2;
        this.f10278g.b(bArr);
    }

    private void a(ck ckVar, byte b2) throws bw {
        if (b2 == -1) {
            b2 = e(ckVar.f10264b);
        }
        short s = ckVar.f10265c;
        short s2 = this.n;
        if (s > s2 && s - s2 <= 15) {
            d(b2 | ((s - s2) << 4));
        } else {
            b(b2);
            a(ckVar.f10265c);
        }
        this.n = ckVar.f10265c;
    }

    public cj(dd ddVar) {
        this(ddVar, -1L);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cm cmVar) throws bw {
        int i2 = cmVar.f10270c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(cmVar.f10269b) | (e(cmVar.f10268a) << 4));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cl clVar) throws bw {
        a(clVar.f10266a, clVar.f10267b);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ct ctVar) throws bw {
        a(ctVar.f10288a, ctVar.f10289b);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(boolean z) throws bw {
        ck ckVar = this.o;
        if (ckVar != null) {
            a(ckVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        } else {
            b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(byte b2) throws bw {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(short s) throws bw {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(int i2) throws bw {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(long j2) throws bw {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(double d2) throws bw {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.f10278g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(String str) throws bw {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bw("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ByteBuffer byteBuffer) throws bw {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws bw {
        b(i3);
        this.f10278g.b(bArr, i2, i3);
    }

    protected void a(byte b2, int i2) throws bw {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }
}
