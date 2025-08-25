package c.b.c.d0.a0;

/* compiled from: DataCharacter.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f2467a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2468b;

    public b(int i2, int i3) {
        this.f2467a = i2;
        this.f2468b = i3;
    }

    public final int a() {
        return this.f2468b;
    }

    public final int b() {
        return this.f2467a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2467a == bVar.f2467a && this.f2468b == bVar.f2468b;
    }

    public final int hashCode() {
        return this.f2467a ^ this.f2468b;
    }

    public final String toString() {
        return this.f2467a + "(" + this.f2468b + ')';
    }
}
