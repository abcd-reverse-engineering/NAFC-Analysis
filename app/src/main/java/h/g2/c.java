package h.g2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: AbstractIterator.kt */
/* loaded from: classes2.dex */
public abstract class c<T> implements Iterator<T>, h.q2.t.q1.a {

    /* renamed from: a, reason: collision with root package name */
    private q1 f16116a = q1.NotReady;

    /* renamed from: b, reason: collision with root package name */
    private T f16117b;

    private final boolean d() {
        this.f16116a = q1.Failed;
        b();
        return this.f16116a == q1.Ready;
    }

    protected abstract void b();

    protected final void b(T t) {
        this.f16117b = t;
        this.f16116a = q1.Ready;
    }

    protected final void c() {
        this.f16116a = q1.Done;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!(this.f16116a != q1.Failed)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i2 = b.f16114a[this.f16116a.ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f16116a = q1.NotReady;
        return this.f16117b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
