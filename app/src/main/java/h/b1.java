package h;

import java.io.Serializable;

/* compiled from: Tuples.kt */
/* loaded from: classes2.dex */
public final class b1<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public b1(A a2, B b2, C c2) {
        this.first = a2;
        this.second = b2;
        this.third = c2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b1 copy$default(b1 b1Var, Object obj, Object obj2, Object obj3, int i2, Object obj4) {
        if ((i2 & 1) != 0) {
            obj = b1Var.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = b1Var.second;
        }
        if ((i2 & 4) != 0) {
            obj3 = b1Var.third;
        }
        return b1Var.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    @i.c.a.d
    public final b1<A, B, C> copy(A a2, B b2, C c2) {
        return new b1<>(a2, b2, c2);
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        return h.q2.t.i0.a(this.first, b1Var.first) && h.q2.t.i0.a(this.second, b1Var.second) && h.q2.t.i0.a(this.third, b1Var.third);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a2 = this.first;
        int iHashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        int iHashCode2 = (iHashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c2 = this.third;
        return iHashCode2 + (c2 != null ? c2.hashCode() : 0);
    }

    @i.c.a.d
    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
