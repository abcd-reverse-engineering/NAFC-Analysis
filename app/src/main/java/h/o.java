package h;

import java.io.Serializable;

/* compiled from: Lazy.kt */
/* loaded from: classes2.dex */
public final class o<T> implements s<T>, Serializable {
    private final T value;

    public o(T t) {
        this.value = t;
    }

    @Override // h.s
    public T getValue() {
        return this.value;
    }

    @Override // h.s
    public boolean isInitialized() {
        return true;
    }

    @i.c.a.d
    public String toString() {
        return String.valueOf(getValue());
    }
}
