package h.v2;

/* compiled from: Ranges.kt */
/* loaded from: classes2.dex */
final class e implements f<Float> {

    /* renamed from: a, reason: collision with root package name */
    private final float f16519a;

    /* renamed from: b, reason: collision with root package name */
    private final float f16520b;

    public e(float f2, float f3) {
        this.f16519a = f2;
        this.f16520b = f3;
    }

    public boolean a(float f2, float f3) {
        return f2 <= f3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.v2.f
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable, Comparable comparable2) {
        return a(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.v2.f, h.v2.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).floatValue());
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof e) {
            if (!isEmpty() || !((e) obj).isEmpty()) {
                e eVar = (e) obj;
                if (this.f16519a != eVar.f16519a || this.f16520b != eVar.f16520b) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.f16519a).hashCode() * 31) + Float.valueOf(this.f16520b).hashCode();
    }

    @Override // h.v2.f, h.v2.g
    public boolean isEmpty() {
        return this.f16519a > this.f16520b;
    }

    @i.c.a.d
    public String toString() {
        return this.f16519a + ".." + this.f16520b;
    }

    public boolean a(float f2) {
        return f2 >= this.f16519a && f2 <= this.f16520b;
    }

    @Override // h.v2.g
    @i.c.a.d
    public Float getEndInclusive() {
        return Float.valueOf(this.f16520b);
    }

    @Override // h.v2.g
    @i.c.a.d
    public Float getStart() {
        return Float.valueOf(this.f16519a);
    }
}
