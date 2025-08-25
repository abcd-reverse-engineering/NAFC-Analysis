package h.g2;

import java.util.List;

/* compiled from: ReversedViews.kt */
/* loaded from: classes2.dex */
final class h1<T> extends g<T> {

    /* renamed from: a, reason: collision with root package name */
    private final List<T> f16139a;

    public h1(@i.c.a.d List<T> list) {
        h.q2.t.i0.f(list, "delegate");
        this.f16139a = list;
    }

    @Override // h.g2.g
    public int a() {
        return this.f16139a.size();
    }

    @Override // h.g2.g, java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        this.f16139a.add(e0.d((List<?>) this, i2), t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f16139a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        return this.f16139a.get(e0.c((List<?>) this, i2));
    }

    @Override // h.g2.g, java.util.AbstractList, java.util.List
    public T set(int i2, T t) {
        return this.f16139a.set(e0.c((List<?>) this, i2), t);
    }

    @Override // h.g2.g
    public T a(int i2) {
        return this.f16139a.remove(e0.c((List<?>) this, i2));
    }
}
