package com.heytap.mcssdk.b;

import i.a.a.a.e;
import i.a.a.a.g;
import i.a.a.a.k.l;

/* loaded from: classes.dex */
public abstract class b implements i.a.a.a.a, i.a.a.a.b {

    /* renamed from: l, reason: collision with root package name */
    public static final int f5777l = 76;

    /* renamed from: m, reason: collision with root package name */
    public static final int f5778m = 64;
    private static final int n = 2;
    private static final int o = 8192;
    protected static final int p = 255;
    protected static final byte q = 61;

    /* renamed from: a, reason: collision with root package name */
    protected final byte f5779a = q;

    /* renamed from: b, reason: collision with root package name */
    private final int f5780b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5781c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f5782d;

    /* renamed from: e, reason: collision with root package name */
    private final int f5783e;

    /* renamed from: f, reason: collision with root package name */
    protected byte[] f5784f;

    /* renamed from: g, reason: collision with root package name */
    protected int f5785g;

    /* renamed from: h, reason: collision with root package name */
    private int f5786h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f5787i;

    /* renamed from: j, reason: collision with root package name */
    protected int f5788j;

    /* renamed from: k, reason: collision with root package name */
    protected int f5789k;

    protected b(int i2, int i3, int i4, int i5) {
        this.f5780b = i2;
        this.f5781c = i3;
        this.f5782d = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.f5783e = i5;
    }

    protected static boolean b(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void d() {
        byte[] bArr = this.f5784f;
        if (bArr == null) {
            this.f5784f = new byte[c()];
            this.f5785g = 0;
            this.f5786h = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f5784f = bArr2;
        }
    }

    private void e() {
        this.f5784f = null;
        this.f5785g = 0;
        this.f5786h = 0;
        this.f5788j = 0;
        this.f5789k = 0;
        this.f5787i = false;
    }

    public String a(byte[] bArr) {
        return l.f(encode(bArr));
    }

    protected void a(int i2) {
        byte[] bArr = this.f5784f;
        if (bArr == null || bArr.length < this.f5785g + i2) {
            d();
        }
    }

    abstract void a(byte[] bArr, int i2, int i3);

    boolean a() {
        return this.f5784f != null;
    }

    protected abstract boolean a(byte b2);

    public boolean a(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!a(bArr[i2]) && (!z || (bArr[i2] != 61 && !b(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    public byte[] a(String str) {
        return decode(l.f(str));
    }

    int b() {
        if (this.f5784f != null) {
            return this.f5785g - this.f5786h;
        }
        return 0;
    }

    public String b(byte[] bArr) {
        return l.f(encode(bArr));
    }

    abstract void b(byte[] bArr, int i2, int i3);

    public boolean b(String str) {
        return a(l.f(str), true);
    }

    protected int c() {
        return 8192;
    }

    int c(byte[] bArr, int i2, int i3) {
        if (this.f5784f == null) {
            return this.f5787i ? -1 : 0;
        }
        int iMin = Math.min(b(), i3);
        System.arraycopy(this.f5784f, this.f5786h, bArr, i2, iMin);
        this.f5786h += iMin;
        if (this.f5786h >= this.f5785g) {
            this.f5784f = null;
        }
        return iMin;
    }

    protected boolean c(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || a(b2)) {
                return true;
            }
        }
        return false;
    }

    public long d(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f5780b;
        long j2 = (((length + i2) - 1) / i2) * this.f5781c;
        int i3 = this.f5782d;
        return i3 > 0 ? j2 + ((((i3 + j2) - 1) / i3) * this.f5783e) : j2;
    }

    @Override // i.a.a.a.d
    public Object decode(Object obj) throws e {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return a((String) obj);
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
        byte[] bArr2 = new byte[this.f5785g];
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
        byte[] bArr2 = new byte[this.f5785g - this.f5786h];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }
}
