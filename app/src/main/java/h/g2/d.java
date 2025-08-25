package h.g2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.bh;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* compiled from: AbstractList.kt */
@h.t0(version = "1.1")
@h.y(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b'\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lkotlin/collections/AbstractList;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", DispatchConstants.OTHER, "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public abstract class d<E> extends h.g2.a<E> implements List<E>, h.q2.t.q1.a {
    public static final a Companion = new a(null);

    /* compiled from: AbstractList.kt */
    public static final class a {
        private a() {
        }

        public final void a(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void b(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }

        public final void a(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("startIndex: " + i2 + ", endIndex: " + i3 + ", size: " + i4);
            }
            if (i2 <= i3) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i2 + " > endIndex: " + i3);
        }

        public final void b(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
            }
            if (i2 <= i3) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i3);
        }

        public final int a(@i.c.a.d Collection<?> collection) {
            h.q2.t.i0.f(collection, bh.aI);
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public final boolean a(@i.c.a.d Collection<?> collection, @i.c.a.d Collection<?> collection2) {
            h.q2.t.i0.f(collection, bh.aI);
            h.q2.t.i0.f(collection2, DispatchConstants.OTHER);
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!h.q2.t.i0.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    /* compiled from: AbstractList.kt */
    private class b implements Iterator<E>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        private int f16118a;

        public b() {
        }

        protected final void a(int i2) {
            this.f16118a = i2;
        }

        protected final int b() {
            return this.f16118a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16118a < d.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            d dVar = d.this;
            int i2 = this.f16118a;
            this.f16118a = i2 + 1;
            return (E) dVar.get(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    private class c extends d<E>.b implements ListIterator<E>, h.q2.t.q1.a {
        public c(int i2) {
            super();
            d.Companion.b(i2, d.this.size());
            a(i2);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return b() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return b();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            d dVar = d.this;
            a(b() - 1);
            return (E) dVar.get(b());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: h.g2.d$d, reason: collision with other inner class name */
    private static final class C0237d<E> extends d<E> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        private int f16121a;

        /* renamed from: b, reason: collision with root package name */
        private final d<E> f16122b;

        /* renamed from: c, reason: collision with root package name */
        private final int f16123c;

        /* JADX WARN: Multi-variable type inference failed */
        public C0237d(@i.c.a.d d<? extends E> dVar, int i2, int i3) {
            h.q2.t.i0.f(dVar, "list");
            this.f16122b = dVar;
            this.f16123c = i2;
            d.Companion.b(this.f16123c, i3, this.f16122b.size());
            this.f16121a = i3 - this.f16123c;
        }

        @Override // h.g2.d, java.util.List
        public E get(int i2) {
            d.Companion.a(i2, this.f16121a);
            return this.f16122b.get(this.f16123c + i2);
        }

        @Override // h.g2.d, h.g2.a
        public int getSize() {
            return this.f16121a;
        }
    }

    protected d() {
    }

    @Override // java.util.List
    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@i.c.a.e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.a(this, (Collection<?>) obj);
        }
        return false;
    }

    public abstract E get(int i2);

    @Override // h.g2.a
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.a(this);
    }

    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (h.q2.t.i0.a(it.next(), obj)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // h.g2.a, java.util.Collection, java.lang.Iterable
    @i.c.a.d
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (h.q2.t.i0.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @i.c.a.d
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @i.c.a.d
    public List<E> subList(int i2, int i3) {
        return new C0237d(this, i2, i3);
    }

    @Override // java.util.List
    @i.c.a.d
    public ListIterator<E> listIterator(int i2) {
        return new c(i2);
    }
}
