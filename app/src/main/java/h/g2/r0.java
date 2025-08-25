package h.g2;

/* compiled from: IndexedValue.kt */
/* loaded from: classes2.dex */
public final class r0<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f16192a;

    /* renamed from: b, reason: collision with root package name */
    private final T f16193b;

    public r0(int i2, T t) {
        this.f16192a = i2;
        this.f16193b = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ r0 a(r0 r0Var, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            i2 = r0Var.f16192a;
        }
        if ((i3 & 2) != 0) {
            obj = r0Var.f16193b;
        }
        return r0Var.a(i2, obj);
    }

    public final int a() {
        return this.f16192a;
    }

    @i.c.a.d
    public final r0<T> a(int i2, T t) {
        return new r0<>(i2, t);
    }

    public final T b() {
        return this.f16193b;
    }

    public final int c() {
        return this.f16192a;
    }

    public final T d() {
        return this.f16193b;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return this.f16192a == r0Var.f16192a && h.q2.t.i0.a(this.f16193b, r0Var.f16193b);
    }

    public int hashCode() {
        int i2 = this.f16192a * 31;
        T t = this.f16193b;
        return i2 + (t != null ? t.hashCode() : 0);
    }

    @i.c.a.d
    public String toString() {
        return "IndexedValue(index=" + this.f16192a + ", value=" + this.f16193b + ")";
    }
}
