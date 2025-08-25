package h;

import java.io.Serializable;

/* compiled from: Lazy.kt */
/* loaded from: classes2.dex */
public final class z1<T> implements s<T>, Serializable {
    private Object _value;
    private h.q2.s.a<? extends T> initializer;

    public z1(@i.c.a.d h.q2.s.a<? extends T> aVar) {
        h.q2.t.i0.f(aVar, "initializer");
        this.initializer = aVar;
        this._value = r1.f16467a;
    }

    private final Object writeReplace() {
        return new o(getValue());
    }

    @Override // h.s
    public T getValue() {
        if (this._value == r1.f16467a) {
            h.q2.s.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                h.q2.t.i0.f();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @Override // h.s
    public boolean isInitialized() {
        return this._value != r1.f16467a;
    }

    @i.c.a.d
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
