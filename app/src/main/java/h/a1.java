package h;

import java.io.Serializable;

/* compiled from: LazyJVM.kt */
/* loaded from: classes2.dex */
final class a1<T> implements s<T>, Serializable {
    private volatile Object _value;
    private h.q2.s.a<? extends T> initializer;
    private final Object lock;

    public a1(@i.c.a.d h.q2.s.a<? extends T> aVar, @i.c.a.e Object obj) {
        h.q2.t.i0.f(aVar, "initializer");
        this.initializer = aVar;
        this._value = r1.f16467a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new o(getValue());
    }

    @Override // h.s
    public T getValue() {
        T tInvoke;
        T t = (T) this._value;
        if (t != r1.f16467a) {
            return t;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == r1.f16467a) {
                h.q2.s.a<? extends T> aVar = this.initializer;
                if (aVar == null) {
                    h.q2.t.i0.f();
                }
                tInvoke = aVar.invoke();
                this._value = tInvoke;
                this.initializer = null;
            }
        }
        return tInvoke;
    }

    @Override // h.s
    public boolean isInitialized() {
        return this._value != r1.f16467a;
    }

    @i.c.a.d
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ a1(h.q2.s.a aVar, Object obj, int i2, h.q2.t.v vVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}
