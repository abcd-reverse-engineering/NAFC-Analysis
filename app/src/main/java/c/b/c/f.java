package c.b.c;

/* compiled from: Dimension.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final int f2739a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2740b;

    public f(int i2, int i3) {
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException();
        }
        this.f2739a = i2;
        this.f2740b = i3;
    }

    public int a() {
        return this.f2740b;
    }

    public int b() {
        return this.f2739a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f2739a == fVar.f2739a && this.f2740b == fVar.f2740b;
    }

    public int hashCode() {
        return (this.f2739a * 32713) + this.f2740b;
    }

    public String toString() {
        return this.f2739a + "x" + this.f2740b;
    }
}
