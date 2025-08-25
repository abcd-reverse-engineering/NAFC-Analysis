package h.v2;

/* compiled from: Ranges.kt */
/* loaded from: classes2.dex */
final class d implements f<Double> {

    /* renamed from: a, reason: collision with root package name */
    private final double f16517a;

    /* renamed from: b, reason: collision with root package name */
    private final double f16518b;

    public d(double d2, double d3) {
        this.f16517a = d2;
        this.f16518b = d3;
    }

    public boolean a(double d2, double d3) {
        return d2 <= d3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.v2.f
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable, Comparable comparable2) {
        return a(((Number) comparable).doubleValue(), ((Number) comparable2).doubleValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.v2.f, h.v2.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).doubleValue());
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (this.f16517a != dVar.f16517a || this.f16518b != dVar.f16518b) {
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
        return (Double.valueOf(this.f16517a).hashCode() * 31) + Double.valueOf(this.f16518b).hashCode();
    }

    @Override // h.v2.f, h.v2.g
    public boolean isEmpty() {
        return this.f16517a > this.f16518b;
    }

    @i.c.a.d
    public String toString() {
        return this.f16517a + ".." + this.f16518b;
    }

    public boolean a(double d2) {
        return d2 >= this.f16517a && d2 <= this.f16518b;
    }

    @Override // h.v2.g
    @i.c.a.d
    public Double getEndInclusive() {
        return Double.valueOf(this.f16518b);
    }

    @Override // h.v2.g
    @i.c.a.d
    public Double getStart() {
        return Double.valueOf(this.f16517a);
    }
}
