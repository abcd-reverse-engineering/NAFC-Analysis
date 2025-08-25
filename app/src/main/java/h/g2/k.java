package h.g2;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: Collections.kt */
/* loaded from: classes2.dex */
final class k<T> implements Collection<T>, h.q2.t.q1.a {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final T[] f16150a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f16151b;

    public k(@i.c.a.d T[] tArr, boolean z) {
        h.q2.t.i0.f(tArr, "values");
        this.f16150a = tArr;
        this.f16151b = z;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int b() {
        return this.f16150a.length;
    }

    @i.c.a.d
    public final T[] c() {
        return this.f16150a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return r.b((Object[]) this.f16150a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(@i.c.a.d Collection<? extends Object> collection) {
        h.q2.t.i0.f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean d() {
        return this.f16151b;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f16150a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @i.c.a.d
    public Iterator<T> iterator() {
        return h.q2.t.h.a(this.f16150a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return b();
    }

    @Override // java.util.Collection
    @i.c.a.d
    public final Object[] toArray() {
        return x.a(this.f16150a, this.f16151b);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) h.q2.t.u.a(this, tArr);
    }
}
