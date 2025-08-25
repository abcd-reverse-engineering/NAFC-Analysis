package g.a.e1;

import g.a.t0.f;
import java.util.concurrent.TimeUnit;

/* compiled from: Timed.java */
/* loaded from: classes2.dex */
public final class c<T> {

    /* renamed from: a, reason: collision with root package name */
    final T f13748a;

    /* renamed from: b, reason: collision with root package name */
    final long f13749b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f13750c;

    public c(@f T t, long j2, @f TimeUnit timeUnit) {
        this.f13748a = t;
        this.f13749b = j2;
        this.f13750c = (TimeUnit) g.a.y0.b.b.a(timeUnit, "unit is null");
    }

    public long a() {
        return this.f13749b;
    }

    @f
    public TimeUnit b() {
        return this.f13750c;
    }

    @f
    public T c() {
        return this.f13748a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return g.a.y0.b.b.a(this.f13748a, cVar.f13748a) && this.f13749b == cVar.f13749b && g.a.y0.b.b.a(this.f13750c, cVar.f13750c);
    }

    public int hashCode() {
        T t = this.f13748a;
        int iHashCode = t != null ? t.hashCode() : 0;
        long j2 = this.f13749b;
        return (((iHashCode * 31) + ((int) (j2 ^ (j2 >>> 31)))) * 31) + this.f13750c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f13749b + ", unit=" + this.f13750c + ", value=" + this.f13748a + "]";
    }

    public long a(@f TimeUnit timeUnit) {
        return timeUnit.convert(this.f13749b, this.f13750c);
    }
}
