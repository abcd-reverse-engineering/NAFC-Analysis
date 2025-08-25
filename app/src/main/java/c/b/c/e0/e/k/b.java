package c.b.c.e0.e.k;

/* compiled from: ModulusGF.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final b f2680f = new b(c.b.c.e0.a.f2613a, 3);

    /* renamed from: a, reason: collision with root package name */
    private final int[] f2681a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f2682b;

    /* renamed from: c, reason: collision with root package name */
    private final c f2683c;

    /* renamed from: d, reason: collision with root package name */
    private final c f2684d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2685e;

    private b(int i2, int i3) {
        this.f2685e = i2;
        this.f2681a = new int[i2];
        this.f2682b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f2681a[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f2682b[this.f2681a[i6]] = i6;
        }
        this.f2683c = new c(this, new int[]{0});
        this.f2684d = new c(this, new int[]{1});
    }

    c a() {
        return this.f2684d;
    }

    c b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f2683c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new c(this, iArr);
    }

    c c() {
        return this.f2683c;
    }

    int d(int i2, int i3) {
        int i4 = this.f2685e;
        return ((i2 + i4) - i3) % i4;
    }

    int a(int i2, int i3) {
        return (i2 + i3) % this.f2685e;
    }

    int c(int i2) {
        if (i2 != 0) {
            return this.f2682b[i2];
        }
        throw new IllegalArgumentException();
    }

    int a(int i2) {
        return this.f2681a[i2];
    }

    int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f2681a;
        int[] iArr2 = this.f2682b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f2685e - 1)];
    }

    int b(int i2) {
        if (i2 != 0) {
            return this.f2681a[(this.f2685e - this.f2682b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int b() {
        return this.f2685e;
    }
}
