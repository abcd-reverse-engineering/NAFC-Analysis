package h.a3;

import h.q2.t.i0;
import h.q2.t.v;
import h.t0;

/* compiled from: measureTime.kt */
@j
@t0(version = "1.3")
/* loaded from: classes2.dex */
public final class s<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f16093a;

    /* renamed from: b, reason: collision with root package name */
    private final double f16094b;

    private s(T t, double d2) {
        this.f16093a = t;
        this.f16094b = d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ s a(s sVar, Object obj, double d2, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = sVar.f16093a;
        }
        if ((i2 & 2) != 0) {
            d2 = sVar.f16094b;
        }
        return sVar.a(obj, d2);
    }

    @i.c.a.d
    public final s<T> a(T t, double d2) {
        return new s<>(t, d2);
    }

    public final T a() {
        return this.f16093a;
    }

    public final double b() {
        return this.f16094b;
    }

    public final double c() {
        return this.f16094b;
    }

    public final T d() {
        return this.f16093a;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return i0.a(this.f16093a, sVar.f16093a) && Double.compare(this.f16094b, sVar.f16094b) == 0;
    }

    public int hashCode() {
        T t = this.f16093a;
        int iHashCode = t != null ? t.hashCode() : 0;
        long jDoubleToLongBits = Double.doubleToLongBits(this.f16094b);
        return (iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }

    @i.c.a.d
    public String toString() {
        return "TimedValue(value=" + this.f16093a + ", duration=" + d.x(this.f16094b) + ")";
    }

    public /* synthetic */ s(Object obj, double d2, v vVar) {
        this(obj, d2);
    }
}
