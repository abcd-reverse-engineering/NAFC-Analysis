package i.a.a.a.k;

/* compiled from: BaseNCodec.java */
/* loaded from: classes2.dex */
public abstract class g implements i.a.a.a.b, i.a.a.a.a {

    /* renamed from: l, reason: collision with root package name */
    public static final int f16736l = 76;

    /* renamed from: m, reason: collision with root package name */
    public static final int f16737m = 64;
    private static final int n = 2;
    private static final int o = 8192;
    protected static final int p = 255;
    protected static final byte q = 61;

    /* renamed from: a, reason: collision with root package name */
    protected final byte f16738a = q;

    /* renamed from: b, reason: collision with root package name */
    private final int f16739b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16740c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f16741d;

    /* renamed from: e, reason: collision with root package name */
    private final int f16742e;

    /* renamed from: f, reason: collision with root package name */
    protected byte[] f16743f;

    /* renamed from: g, reason: collision with root package name */
    protected int f16744g;

    /* renamed from: h, reason: collision with root package name */
    private int f16745h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f16746i;

    /* renamed from: j, reason: collision with root package name */
    protected int f16747j;

    /* renamed from: k, reason: collision with root package name */
    protected int f16748k;

    protected g(int i2, int i3, int i4, int i5) {
        this.f16739b = i2;
        this.f16740c = i3;
        this.f16741d = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.f16742e = i5;
    }

    protected static boolean b(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void d() {
        this.f16743f = null;
        this.f16744g = 0;
        this.f16745h = 0;
        this.f16747j = 0;
        this.f16748k = 0;
        this.f16746i = false;
    }

    private void e() {
        byte[] bArr = this.f16743f;
        if (bArr == null) {
            this.f16743f = new byte[b()];
            this.f16744g = 0;
            this.f16745h = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f16743f = bArr2;
        }
    }

    int a() {
        if (this.f16743f != null) {
            return this.f16744g - this.f16745h;
        }
        return 0;
    }

    abstract void a(byte[] bArr, int i2, int i3);

    protected abstract boolean a(byte b2);

    protected int b() {
        return 8192;
    }

    public String b(byte[] bArr) {
        return l.f(encode(bArr));
    }

    abstract void b(byte[] bArr, int i2, int i3);

    boolean c() {
        return this.f16743f != null;
    }

    @Override // i.a.a.a.d
    public Object decode(Object obj) throws i.a.a.a.e {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new i.a.a.a.e("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new i.a.a.a.g("Parameter supplied to Base-N encode is not a byte[]");
    }

    protected void a(int i2) {
        byte[] bArr = this.f16743f;
        if (bArr == null || bArr.length < this.f16744g + i2) {
            e();
        }
    }

    public boolean b(String str) {
        return a(l.f(str), true);
    }

    int c(byte[] bArr, int i2, int i3) {
        if (this.f16743f == null) {
            return this.f16746i ? -1 : 0;
        }
        int iMin = Math.min(a(), i3);
        System.arraycopy(this.f16743f, this.f16745h, bArr, i2, iMin);
        this.f16745h += iMin;
        if (this.f16745h >= this.f16744g) {
            this.f16743f = null;
        }
        return iMin;
    }

    public byte[] a(String str) {
        return decode(l.f(str));
    }

    @Override // i.a.a.a.b
    public byte[] encode(byte[] bArr) {
        d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f16744g - this.f16745h];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    public boolean a(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!a(bArr[i2]) && (!z || (bArr[i2] != 61 && !b(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    @Override // i.a.a.a.a
    public byte[] decode(byte[] bArr) {
        d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f16744g];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    protected boolean a(byte[] bArr) {
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
        int i2 = this.f16739b;
        long j2 = (((length + i2) - 1) / i2) * this.f16740c;
        int i3 = this.f16741d;
        return i3 > 0 ? j2 + ((((i3 + j2) - 1) / i3) * this.f16742e) : j2;
    }

    public String c(byte[] bArr) {
        return l.f(encode(bArr));
    }
}
