package h;

import java.io.Serializable;

/* compiled from: Tuples.kt */
/* loaded from: classes2.dex */
public final class i0<A, B> implements Serializable {
    private final A first;
    private final B second;

    public i0(A a2, B b2) {
        this.first = a2;
        this.second = b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ i0 copy$default(i0 i0Var, Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = i0Var.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = i0Var.second;
        }
        return i0Var.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    @i.c.a.d
    public final i0<A, B> copy(A a2, B b2) {
        return new i0<>(a2, b2);
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return h.q2.t.i0.a(this.first, i0Var.first) && h.q2.t.i0.a(this.second, i0Var.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a2 = this.first;
        int iHashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }

    @i.c.a.d
    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
