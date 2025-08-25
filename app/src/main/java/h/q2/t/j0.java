package h.q2.t;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* loaded from: classes2.dex */
public abstract class j0<R> implements b0<R>, Serializable {
    private final int arity;

    public j0(int i2) {
        this.arity = i2;
    }

    @Override // h.q2.t.b0
    public int getArity() {
        return this.arity;
    }

    @i.c.a.d
    public String toString() {
        String strA = h1.a((j0) this);
        i0.a((Object) strA, "Reflection.renderLambdaToString(this)");
        return strA;
    }
}
