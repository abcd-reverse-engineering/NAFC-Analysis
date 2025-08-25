package c.b.c.e0.g;

import java.lang.reflect.Array;

/* compiled from: BarcodeMatrix.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b[] f2701a;

    /* renamed from: b, reason: collision with root package name */
    private int f2702b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2703c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2704d;

    a(int i2, int i3) {
        this.f2701a = new b[i2];
        int length = this.f2701a.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f2701a[i4] = new b(((i3 + 4) * 17) + 1);
        }
        this.f2704d = i3 * 17;
        this.f2703c = i2;
        this.f2702b = -1;
    }

    void a(int i2, int i3, byte b2) {
        this.f2701a[i3].a(i2, b2);
    }

    public byte[][] b() {
        return a(1, 1);
    }

    void c() {
        this.f2702b++;
    }

    b a() {
        return this.f2701a[this.f2702b];
    }

    public byte[][] a(int i2, int i3) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f2703c * i3, this.f2704d * i2);
        int i4 = this.f2703c * i3;
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[(i4 - i5) - 1] = this.f2701a[i5 / i3].a(i2);
        }
        return bArr;
    }
}
