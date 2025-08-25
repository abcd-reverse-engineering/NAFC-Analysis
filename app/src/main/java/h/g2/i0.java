package h.g2;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: Collections.kt */
/* loaded from: classes2.dex */
public final class i0 implements ListIterator, h.q2.t.q1.a {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f16140a = new i0();

    private i0() {
    }

    public void a(Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void b(Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    @i.c.a.d
    public Void next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    @i.c.a.d
    public Void previous() {
        throw new NoSuchElementException();
    }
}
