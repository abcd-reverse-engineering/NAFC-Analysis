package c.b.c.d0.a0;

import c.b.c.t;

/* compiled from: FinderPattern.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f2469a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f2470b;

    /* renamed from: c, reason: collision with root package name */
    private final t[] f2471c;

    public c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.f2469a = i2;
        this.f2470b = iArr;
        float f2 = i5;
        this.f2471c = new t[]{new t(i3, f2), new t(i4, f2)};
    }

    public t[] a() {
        return this.f2471c;
    }

    public int[] b() {
        return this.f2470b;
    }

    public int c() {
        return this.f2469a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f2469a == ((c) obj).f2469a;
    }

    public int hashCode() {
        return this.f2469a;
    }
}
