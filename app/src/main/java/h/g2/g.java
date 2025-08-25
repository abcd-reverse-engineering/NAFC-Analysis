package h.g2;

import java.util.AbstractList;
import java.util.List;

/* compiled from: AbstractMutableList.kt */
@h.t0(version = "1.1")
/* loaded from: classes2.dex */
public abstract class g<E> extends AbstractList<E> implements List<E>, h.q2.t.q1.e {
    protected g() {
    }

    public abstract int a();

    public abstract E a(int i2);

    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i2, E e2);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i2) {
        return a(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i2, E e2);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
