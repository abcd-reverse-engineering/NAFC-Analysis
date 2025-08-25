package h.k2.n.a;

import h.q2.t.b0;
import h.q2.t.h1;
import h.q2.t.i0;
import h.t0;

/* compiled from: ContinuationImpl.kt */
@t0(version = "1.3")
/* loaded from: classes2.dex */
public abstract class k extends j implements b0<Object>, n {
    private final int arity;

    public k(int i2, @i.c.a.e h.k2.d<Object> dVar) {
        super(dVar);
        this.arity = i2;
    }

    @Override // h.q2.t.b0
    public int getArity() {
        return this.arity;
    }

    @Override // h.k2.n.a.a
    @i.c.a.d
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strA = h1.a(this);
        i0.a((Object) strA, "Reflection.renderLambdaToString(this)");
        return strA;
    }

    public k(int i2) {
        this(i2, null);
    }
}
