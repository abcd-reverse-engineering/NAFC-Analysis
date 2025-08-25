package com.heytap.msp.push.encrypt;

import i.a.a.a.e;
import i.a.a.a.g;
import i.a.a.a.k.l;

/* loaded from: classes.dex */
public abstract class b implements i.a.a.a.a, i.a.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    private static final int f5919a = 2;

    /* renamed from: b, reason: collision with root package name */
    public static final int f5920b = 76;

    /* renamed from: c, reason: collision with root package name */
    public static final int f5921c = 64;

    /* renamed from: d, reason: collision with root package name */
    protected static final int f5922d = 255;

    /* renamed from: e, reason: collision with root package name */
    protected static final byte f5923e = 61;

    /* renamed from: m, reason: collision with root package name */
    private static final int f5924m = 8192;

    /* renamed from: f, reason: collision with root package name */
    protected final byte f5925f = f5923e;

    /* renamed from: g, reason: collision with root package name */
    protected final int f5926g;

    /* renamed from: h, reason: collision with root package name */
    protected byte[] f5927h;

    /* renamed from: i, reason: collision with root package name */
    protected int f5928i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f5929j;

    /* renamed from: k, reason: collision with root package name */
    protected int f5930k;

    /* renamed from: l, reason: collision with root package name */
    protected int f5931l;
    private final int n;
    private final int o;
    private final int p;
    private int q;

    protected b(int i2, int i3, int i4, int i5) {
        this.n = i2;
        this.o = i3;
        this.f5926g = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.p = i5;
    }

    private void a() {
        byte[] bArr = this.f5927h;
        if (bArr == null) {
            this.f5927h = new byte[d()];
            this.f5928i = 0;
            this.q = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f5927h = bArr2;
        }
    }

    protected static boolean c(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void e() {
        this.f5927h = null;
        this.f5928i = 0;
        this.q = 0;
        this.f5930k = 0;
        this.f5931l = 0;
        this.f5929j = false;
    }

    protected void a(int i2) {
        byte[] bArr = this.f5927h;
        if (bArr == null || bArr.length < this.f5928i + i2) {
            a();
        }
    }

    abstract void a(byte[] bArr, int i2, int i3);

    abstract void b(byte[] bArr, int i2, int i3);

    boolean b() {
        return this.f5927h != null;
    }

    protected abstract boolean b(byte b2);

    public boolean b(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!b(bArr[i2]) && (!z || (bArr[i2] != 61 && !c(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    int c() {
        if (this.f5927h != null) {
            return this.f5928i - this.q;
        }
        return 0;
    }

    int c(byte[] bArr, int i2, int i3) {
        if (this.f5927h == null) {
            return this.f5929j ? -1 : 0;
        }
        int iMin = Math.min(c(), i3);
        System.arraycopy(this.f5927h, this.q, bArr, i2, iMin);
        this.q += iMin;
        if (this.q >= this.f5928i) {
            this.f5927h = null;
        }
        return iMin;
    }

    public byte[] c(String str) {
        return decode(l.f(str));
    }

    protected int d() {
        return 8192;
    }

    public boolean d(String str) {
        return b(l.f(str), true);
    }

    @Override // i.a.a.a.d
    public Object decode(Object obj) throws e {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return c((String) obj);
        }
        throw new e("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // i.a.a.a.a
    public byte[] decode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f5928i];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws g {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new g("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // i.a.a.a.b
    public byte[] encode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f5928i - this.q];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    public String j(byte[] bArr) {
        return l.f(encode(bArr));
    }

    public String k(byte[] bArr) {
        return l.f(encode(bArr));
    }

    protected boolean l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || b(b2)) {
                return true;
            }
        }
        return false;
    }

    public long m(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.n;
        long j2 = (((length + i2) - 1) / i2) * this.o;
        int i3 = this.f5926g;
        return i3 > 0 ? j2 + ((((i3 + j2) - 1) / i3) * this.p) : j2;
    }
}
