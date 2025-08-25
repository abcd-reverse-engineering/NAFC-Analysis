package h.g2;

import java.util.AbstractCollection;
import java.util.Collection;

/* compiled from: AbstractMutableCollection.kt */
@h.t0(version = "1.1")
/* loaded from: classes2.dex */
public abstract class f<E> extends AbstractCollection<E> implements Collection<E>, h.q2.t.q1.b {
    protected f() {
    }

    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E e2);

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
