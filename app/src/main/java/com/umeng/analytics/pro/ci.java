package com.umeng.analytics.pro;

import h.f1;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TBinaryProtocol.java */
/* loaded from: classes2.dex */
public class ci extends cp {

    /* renamed from: a, reason: collision with root package name */
    protected static final int f10223a = -65536;

    /* renamed from: b, reason: collision with root package name */
    protected static final int f10224b = -2147418112;

    /* renamed from: h, reason: collision with root package name */
    private static final cu f10225h = new cu();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f10226c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f10227d;

    /* renamed from: e, reason: collision with root package name */
    protected int f10228e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f10229f;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f10230i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f10231j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f10232k;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f10233l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f10234m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    /* compiled from: TBinaryProtocol.java */
    public static class a implements cr {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f10235a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f10236b;

        /* renamed from: c, reason: collision with root package name */
        protected int f10237c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.cr
        public cp a(dd ddVar) {
            ci ciVar = new ci(ddVar, this.f10235a, this.f10236b);
            int i2 = this.f10237c;
            if (i2 != 0) {
                ciVar.c(i2);
            }
            return ciVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i2) {
            this.f10235a = false;
            this.f10236b = true;
            this.f10235a = z;
            this.f10236b = z2;
            this.f10237c = i2;
        }
    }

    public ci(dd ddVar) {
        this(ddVar, false, true);
    }

    @Override // com.umeng.analytics.pro.cp
    public ByteBuffer A() throws bw {
        int iW = w();
        d(iW);
        if (this.f10278g.h() >= iW) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f10278g.f(), this.f10278g.g(), iW);
            this.f10278g.a(iW);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iW];
        this.f10278g.d(bArr, 0, iW);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a() {
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cn cnVar) throws bw, UnsupportedEncodingException {
        if (this.f10227d) {
            a(f10224b | cnVar.f10272b);
            a(cnVar.f10271a);
            a(cnVar.f10273c);
        } else {
            a(cnVar.f10271a);
            a(cnVar.f10272b);
            a(cnVar.f10273c);
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cu cuVar) {
    }

    public String b(int i2) throws bw {
        try {
            d(i2);
            byte[] bArr = new byte[i2];
            this.f10278g.d(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cp
    public void c() {
    }

    public void c(int i2) {
        this.f10228e = i2;
        this.f10229f = true;
    }

    @Override // com.umeng.analytics.pro.cp
    public void d() throws bw {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.cp
    public void e() {
    }

    @Override // com.umeng.analytics.pro.cp
    public void f() {
    }

    @Override // com.umeng.analytics.pro.cp
    public void g() {
    }

    @Override // com.umeng.analytics.pro.cp
    public cn h() throws bw {
        int iW = w();
        if (iW < 0) {
            if (((-65536) & iW) == f10224b) {
                return new cn(z(), (byte) (iW & 255), w());
            }
            throw new cq(4, "Bad version in readMessageBegin");
        }
        if (this.f10226c) {
            throw new cq(4, "Missing version in readMessageBegin, old client?");
        }
        return new cn(b(iW), u(), w());
    }

    @Override // com.umeng.analytics.pro.cp
    public void i() {
    }

    @Override // com.umeng.analytics.pro.cp
    public cu j() {
        return f10225h;
    }

    @Override // com.umeng.analytics.pro.cp
    public void k() {
    }

    @Override // com.umeng.analytics.pro.cp
    public ck l() throws bw {
        byte bU = u();
        return new ck("", bU, bU == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.cp
    public void m() {
    }

    @Override // com.umeng.analytics.pro.cp
    public cm n() throws bw {
        return new cm(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.cp
    public void o() {
    }

    @Override // com.umeng.analytics.pro.cp
    public cl p() throws bw {
        return new cl(u(), w());
    }

    @Override // com.umeng.analytics.pro.cp
    public void q() {
    }

    @Override // com.umeng.analytics.pro.cp
    public ct r() throws bw {
        return new ct(u(), w());
    }

    @Override // com.umeng.analytics.pro.cp
    public void s() {
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean t() throws bw {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.cp
    public byte u() throws bw {
        if (this.f10278g.h() < 1) {
            a(this.f10234m, 0, 1);
            return this.f10234m[0];
        }
        byte b2 = this.f10278g.f()[this.f10278g.g()];
        this.f10278g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.cp
    public short v() throws bw {
        byte[] bArrF = this.n;
        int iG = 0;
        if (this.f10278g.h() >= 2) {
            bArrF = this.f10278g.f();
            iG = this.f10278g.g();
            this.f10278g.a(2);
        } else {
            a(this.n, 0, 2);
        }
        return (short) ((bArrF[iG + 1] & f1.f16099c) | ((bArrF[iG] & f1.f16099c) << 8));
    }

    @Override // com.umeng.analytics.pro.cp
    public int w() throws bw {
        byte[] bArrF = this.o;
        int iG = 0;
        if (this.f10278g.h() >= 4) {
            bArrF = this.f10278g.f();
            iG = this.f10278g.g();
            this.f10278g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArrF[iG + 3] & f1.f16099c) | ((bArrF[iG] & f1.f16099c) << 24) | ((bArrF[iG + 1] & f1.f16099c) << 16) | ((bArrF[iG + 2] & f1.f16099c) << 8);
    }

    @Override // com.umeng.analytics.pro.cp
    public long x() throws bw {
        byte[] bArrF = this.p;
        int iG = 0;
        if (this.f10278g.h() >= 8) {
            bArrF = this.f10278g.f();
            iG = this.f10278g.g();
            this.f10278g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return (bArrF[iG + 7] & f1.f16099c) | ((bArrF[iG] & f1.f16099c) << 56) | ((bArrF[iG + 1] & f1.f16099c) << 48) | ((bArrF[iG + 2] & f1.f16099c) << 40) | ((bArrF[iG + 3] & f1.f16099c) << 32) | ((bArrF[iG + 4] & f1.f16099c) << 24) | ((bArrF[iG + 5] & f1.f16099c) << 16) | ((bArrF[iG + 6] & f1.f16099c) << 8);
    }

    @Override // com.umeng.analytics.pro.cp
    public double y() throws bw {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.cp
    public String z() throws bw {
        int iW = w();
        if (this.f10278g.h() < iW) {
            return b(iW);
        }
        try {
            String str = new String(this.f10278g.f(), this.f10278g.g(), iW, "UTF-8");
            this.f10278g.a(iW);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public ci(dd ddVar, boolean z, boolean z2) {
        super(ddVar);
        this.f10226c = false;
        this.f10227d = true;
        this.f10229f = false;
        this.f10230i = new byte[1];
        this.f10231j = new byte[2];
        this.f10232k = new byte[4];
        this.f10233l = new byte[8];
        this.f10234m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.f10226c = z;
        this.f10227d = z2;
    }

    protected void d(int i2) throws bw {
        if (i2 < 0) {
            throw new cq("Negative length: " + i2);
        }
        if (this.f10229f) {
            this.f10228e -= i2;
            if (this.f10228e >= 0) {
                return;
            }
            throw new cq("Message length exceeded: " + i2);
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ck ckVar) throws bw {
        a(ckVar.f10264b);
        a(ckVar.f10265c);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cm cmVar) throws bw {
        a(cmVar.f10268a);
        a(cmVar.f10269b);
        a(cmVar.f10270c);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cl clVar) throws bw {
        a(clVar.f10266a);
        a(clVar.f10267b);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ct ctVar) throws bw {
        a(ctVar.f10288a);
        a(ctVar.f10289b);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(boolean z) throws bw {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(byte b2) throws bw {
        byte[] bArr = this.f10230i;
        bArr[0] = b2;
        this.f10278g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(short s) throws bw {
        byte[] bArr = this.f10231j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f10278g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(int i2) throws bw {
        byte[] bArr = this.f10232k;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        this.f10278g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(long j2) throws bw {
        byte[] bArr = this.f10233l;
        bArr[0] = (byte) ((j2 >> 56) & 255);
        bArr[1] = (byte) ((j2 >> 48) & 255);
        bArr[2] = (byte) ((j2 >> 40) & 255);
        bArr[3] = (byte) ((j2 >> 32) & 255);
        bArr[4] = (byte) ((j2 >> 24) & 255);
        bArr[5] = (byte) ((j2 >> 16) & 255);
        bArr[6] = (byte) ((j2 >> 8) & 255);
        bArr[7] = (byte) (j2 & 255);
        this.f10278g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(double d2) throws bw {
        a(Double.doubleToLongBits(d2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(String str) throws bw, UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f10278g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ByteBuffer byteBuffer) throws bw {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(iLimit);
        this.f10278g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    private int a(byte[] bArr, int i2, int i3) throws bw {
        d(i3);
        return this.f10278g.d(bArr, i2, i3);
    }
}
