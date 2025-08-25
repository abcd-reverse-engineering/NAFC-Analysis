package c.b.c.d0.a0;

import c.b.c.d0.q;
import c.b.c.m;

/* compiled from: AbstractRSSReader.java */
/* loaded from: classes.dex */
public abstract class a extends q {

    /* renamed from: g, reason: collision with root package name */
    private static final float f2457g = 0.2f;

    /* renamed from: h, reason: collision with root package name */
    private static final float f2458h = 0.45f;

    /* renamed from: i, reason: collision with root package name */
    private static final float f2459i = 0.7916667f;

    /* renamed from: j, reason: collision with root package name */
    private static final float f2460j = 0.89285713f;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f2461a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final int[] f2462b = new int[8];

    /* renamed from: c, reason: collision with root package name */
    private final float[] f2463c = new float[4];

    /* renamed from: d, reason: collision with root package name */
    private final float[] f2464d = new float[4];

    /* renamed from: e, reason: collision with root package name */
    private final int[] f2465e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f2466f;

    protected a() {
        int[] iArr = this.f2462b;
        this.f2465e = new int[iArr.length / 2];
        this.f2466f = new int[iArr.length / 2];
    }

    protected final int[] a() {
        return this.f2462b;
    }

    protected final int[] b() {
        return this.f2461a;
    }

    protected final int[] c() {
        return this.f2466f;
    }

    protected final float[] d() {
        return this.f2464d;
    }

    protected final int[] e() {
        return this.f2465e;
    }

    protected final float[] f() {
        return this.f2463c;
    }

    protected static int a(int[] iArr, int[][] iArr2) throws m {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (q.a(iArr, iArr2[i2], f2458h) < f2457g) {
                return i2;
            }
        }
        throw m.getNotFoundInstance();
    }

    protected static void b(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    protected static int a(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }

    protected static void a(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    protected static boolean b(int[] iArr) {
        float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f2 < f2459i || f2 > f2460j) {
            return false;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (int i4 : iArr) {
            if (i4 > i2) {
                i2 = i4;
            }
            if (i4 < i3) {
                i3 = i4;
            }
        }
        return i2 < i3 * 10;
    }
}
