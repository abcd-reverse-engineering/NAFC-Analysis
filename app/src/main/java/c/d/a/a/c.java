package c.d.a.a;

/* compiled from: Pair.java */
/* loaded from: classes.dex */
public final class c<A, B> {

    /* renamed from: a, reason: collision with root package name */
    private final A f3152a;

    /* renamed from: b, reason: collision with root package name */
    private final B f3153b;

    private c(A a2, B b2) {
        this.f3152a = a2;
        this.f3153b = b2;
    }

    public static <A, B> c<A, B> a(A a2, B b2) {
        return new c<>(a2, b2);
    }

    public B b() {
        return this.f3153b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        A a2 = this.f3152a;
        if (a2 == null) {
            if (cVar.f3152a != null) {
                return false;
            }
        } else if (!a2.equals(cVar.f3152a)) {
            return false;
        }
        B b2 = this.f3153b;
        if (b2 == null) {
            if (cVar.f3153b != null) {
                return false;
            }
        } else if (!b2.equals(cVar.f3153b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.f3152a;
        int iHashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
        B b2 = this.f3153b;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        return "first = " + this.f3152a + " , second = " + this.f3153b;
    }

    public A a() {
        return this.f3152a;
    }
}
