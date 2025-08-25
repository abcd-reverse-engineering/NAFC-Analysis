package c.b.c.z.n;

/* compiled from: GenericGF.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f3063h = new a(4201, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final a f3064i = new a(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final a f3065j = new a(67, 64, 1);

    /* renamed from: k, reason: collision with root package name */
    public static final a f3066k = new a(19, 16, 1);

    /* renamed from: l, reason: collision with root package name */
    public static final a f3067l = new a(285, 256, 0);

    /* renamed from: m, reason: collision with root package name */
    public static final a f3068m = new a(301, 256, 1);
    public static final a n = f3068m;
    public static final a o = f3065j;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f3069a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f3070b;

    /* renamed from: c, reason: collision with root package name */
    private final b f3071c;

    /* renamed from: d, reason: collision with root package name */
    private final b f3072d;

    /* renamed from: e, reason: collision with root package name */
    private final int f3073e;

    /* renamed from: f, reason: collision with root package name */
    private final int f3074f;

    /* renamed from: g, reason: collision with root package name */
    private final int f3075g;

    public a(int i2, int i3, int i4) {
        this.f3074f = i2;
        this.f3073e = i3;
        this.f3075g = i4;
        this.f3069a = new int[i3];
        this.f3070b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f3069a[i6] = i5;
            i5 *= 2;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f3070b[this.f3069a[i7]] = i7;
        }
        this.f3071c = new b(this, new int[]{0});
        this.f3072d = new b(this, new int[]{1});
    }

    static int c(int i2, int i3) {
        return i2 ^ i3;
    }

    b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f3071c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new b(this, iArr);
    }

    b b() {
        return this.f3072d;
    }

    int c(int i2) {
        if (i2 != 0) {
            return this.f3070b[i2];
        }
        throw new IllegalArgumentException();
    }

    b d() {
        return this.f3071c;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f3074f) + ',' + this.f3073e + ')';
    }

    int b(int i2) {
        if (i2 != 0) {
            return this.f3069a[(this.f3073e - this.f3070b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int c() {
        return this.f3073e;
    }

    int b(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f3069a;
        int[] iArr2 = this.f3070b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f3073e - 1)];
    }

    int a(int i2) {
        return this.f3069a[i2];
    }

    public int a() {
        return this.f3075g;
    }
}
