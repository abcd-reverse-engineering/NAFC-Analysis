package h.g2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: ArrayDeque.kt */
@h.t0(version = "1.3")
@h.j
/* loaded from: classes2.dex */
public final class l<E> extends g<E> {

    /* renamed from: a, reason: collision with root package name */
    private int f16152a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f16153b;

    /* renamed from: c, reason: collision with root package name */
    private int f16154c;

    public l(int i2) {
        Object[] objArr;
        if (i2 == 0) {
            objArr = m.f16155a;
        } else {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i2);
            }
            objArr = new Object[i2];
        }
        this.f16153b = objArr;
    }

    @h.m2.f
    private final E f(int i2) {
        return (E) this.f16153b[i2];
    }

    @h.m2.f
    private final int g(int i2) {
        return i(this.f16152a + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h(int i2) {
        return i2 < 0 ? i2 + this.f16153b.length : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int i(int i2) {
        Object[] objArr = this.f16153b;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    public final int a(int i2, int i3) {
        int i4 = i2 + (i2 >> 1);
        if (i4 - i3 < 0) {
            i4 = i3;
        }
        return i4 - 2147483639 > 0 ? i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i4;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@i.c.a.d Collection<? extends E> collection) {
        h.q2.t.i0.f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        d(size() + collection.size());
        a(i(this.f16152a + size()), collection);
        return true;
    }

    public final void addFirst(E e2) {
        d(size() + 1);
        this.f16152a = c(this.f16152a);
        this.f16153b[this.f16152a] = e2;
        this.f16154c = size() + 1;
    }

    public final void addLast(E e2) {
        d(size() + 1);
        this.f16153b[i(this.f16152a + size())] = e2;
        this.f16154c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int i2 = i(this.f16152a + size());
        int i3 = this.f16152a;
        if (i3 < i2) {
            q.b(this.f16153b, (Object) null, i3, i2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f16153b;
            q.b(objArr, (Object) null, this.f16152a, objArr.length);
            q.b(this.f16153b, (Object) null, 0, i2);
        }
        this.f16152a = 0;
        this.f16154c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        d.Companion.a(i2, size());
        return (E) this.f16153b[i(this.f16152a + i2)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i2;
        int i3 = i(this.f16152a + size());
        int length = this.f16152a;
        if (length < i3) {
            while (length < i3) {
                if (h.q2.t.i0.a(obj, this.f16153b[length])) {
                    i2 = this.f16152a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < i3) {
            return -1;
        }
        int length2 = this.f16153b.length;
        while (true) {
            if (length >= length2) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (h.q2.t.i0.a(obj, this.f16153b[i4])) {
                        length = i4 + this.f16153b.length;
                        i2 = this.f16152a;
                    }
                }
                return -1;
            }
            if (h.q2.t.i0.a(obj, this.f16153b[length])) {
                i2 = this.f16152a;
                break;
            }
            length++;
        }
        return length - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iU;
        int i2;
        int i3 = i(this.f16152a + size());
        int i4 = this.f16152a;
        if (i4 < i3) {
            iU = i3 - 1;
            if (iU < i4) {
                return -1;
            }
            while (!h.q2.t.i0.a(obj, this.f16153b[iU])) {
                if (iU == i4) {
                    return -1;
                }
                iU--;
            }
            i2 = this.f16152a;
        } else {
            if (i4 <= i3) {
                return -1;
            }
            int i5 = i3 - 1;
            while (true) {
                if (i5 < 0) {
                    iU = r.u(this.f16153b);
                    int i6 = this.f16152a;
                    if (iU < i6) {
                        return -1;
                    }
                    while (!h.q2.t.i0.a(obj, this.f16153b[iU])) {
                        if (iU == i6) {
                            return -1;
                        }
                        iU--;
                    }
                    i2 = this.f16152a;
                } else {
                    if (h.q2.t.i0.a(obj, this.f16153b[i5])) {
                        iU = i5 + this.f16153b.length;
                        i2 = this.f16152a;
                        break;
                    }
                    i5--;
                }
            }
        }
        return iU - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@i.c.a.d Collection<? extends Object> collection) {
        h.q2.t.i0.f(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f16153b.length == 0)) {
                int i2 = i(this.f16152a + size());
                int i3 = this.f16152a;
                if (this.f16152a < i2) {
                    for (int i4 = this.f16152a; i4 < i2; i4++) {
                        Object obj = this.f16153b[i4];
                        if (!collection.contains(obj)) {
                            this.f16153b[i3] = obj;
                            i3++;
                        } else {
                            z = true;
                        }
                    }
                    q.b(this.f16153b, (Object) null, i3, i2);
                } else {
                    int length = this.f16153b.length;
                    boolean z2 = false;
                    for (int i5 = this.f16152a; i5 < length; i5++) {
                        Object obj2 = this.f16153b[i5];
                        this.f16153b[i5] = null;
                        if (!collection.contains(obj2)) {
                            this.f16153b[i3] = obj2;
                            i3++;
                        } else {
                            z2 = true;
                        }
                    }
                    i3 = i(i3);
                    for (int i6 = 0; i6 < i2; i6++) {
                        Object obj3 = this.f16153b[i6];
                        this.f16153b[i6] = null;
                        if (!collection.contains(obj3)) {
                            this.f16153b[i3] = obj3;
                            i3 = e(i3);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f16154c = h(i3 - this.f16152a);
                }
            }
        }
        return z;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        E e2 = (E) this.f16153b[this.f16152a];
        Object[] objArr = this.f16153b;
        int i2 = this.f16152a;
        objArr[i2] = null;
        this.f16152a = e(i2);
        this.f16154c = size() - 1;
        return e2;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int i2 = i(this.f16152a + y.a((List) this));
        E e2 = (E) this.f16153b[i2];
        this.f16153b[i2] = null;
        this.f16154c = size() - 1;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@i.c.a.d Collection<? extends Object> collection) {
        h.q2.t.i0.f(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f16153b.length == 0)) {
                int i2 = i(this.f16152a + size());
                int i3 = this.f16152a;
                if (this.f16152a < i2) {
                    for (int i4 = this.f16152a; i4 < i2; i4++) {
                        Object obj = this.f16153b[i4];
                        if (collection.contains(obj)) {
                            this.f16153b[i3] = obj;
                            i3++;
                        } else {
                            z = true;
                        }
                    }
                    q.b(this.f16153b, (Object) null, i3, i2);
                } else {
                    int length = this.f16153b.length;
                    boolean z2 = false;
                    for (int i5 = this.f16152a; i5 < length; i5++) {
                        Object obj2 = this.f16153b[i5];
                        this.f16153b[i5] = null;
                        if (collection.contains(obj2)) {
                            this.f16153b[i3] = obj2;
                            i3++;
                        } else {
                            z2 = true;
                        }
                    }
                    i3 = i(i3);
                    for (int i6 = 0; i6 < i2; i6++) {
                        Object obj3 = this.f16153b[i6];
                        this.f16153b[i6] = null;
                        if (collection.contains(obj3)) {
                            this.f16153b[i3] = obj3;
                            i3 = e(i3);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f16154c = h(i3 - this.f16152a);
                }
            }
        }
        return z;
    }

    @Override // h.g2.g, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        d.Companion.a(i2, size());
        int i3 = i(this.f16152a + i2);
        E e3 = (E) this.f16153b[i3];
        this.f16153b[i3] = e2;
        return e3;
    }

    private final void d(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f16153b;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == m.f16155a) {
            this.f16153b = new Object[h.v2.q.a(i2, 10)];
        } else {
            b(a(this.f16153b.length, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int e(int i2) {
        if (i2 == r.u(this.f16153b)) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // h.g2.g, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        d.Companion.b(i2, size());
        if (i2 == size()) {
            addLast(e2);
            return;
        }
        if (i2 == 0) {
            addFirst(e2);
            return;
        }
        d(size() + 1);
        int i3 = i(this.f16152a + i2);
        if (i2 < ((size() + 1) >> 1)) {
            int iC = c(i3);
            int iC2 = c(this.f16152a);
            int i4 = this.f16152a;
            if (iC >= i4) {
                Object[] objArr = this.f16153b;
                objArr[iC2] = objArr[i4];
                q.a(objArr, objArr, i4, i4 + 1, iC + 1);
            } else {
                Object[] objArr2 = this.f16153b;
                q.a(objArr2, objArr2, i4 - 1, i4, objArr2.length);
                Object[] objArr3 = this.f16153b;
                objArr3[objArr3.length - 1] = objArr3[0];
                q.a(objArr3, objArr3, 0, 1, iC + 1);
            }
            this.f16153b[iC] = e2;
            this.f16152a = iC2;
        } else {
            int i5 = i(this.f16152a + size());
            if (i3 < i5) {
                Object[] objArr4 = this.f16153b;
                q.a(objArr4, objArr4, i3 + 1, i3, i5);
            } else {
                Object[] objArr5 = this.f16153b;
                q.a(objArr5, objArr5, 1, 0, i5);
                Object[] objArr6 = this.f16153b;
                objArr6[0] = objArr6[objArr6.length - 1];
                q.a(objArr6, objArr6, i3 + 1, i3, objArr6.length - 1);
            }
            this.f16153b[i3] = e2;
        }
        this.f16154c = size() + 1;
    }

    @i.c.a.e
    public final E f() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @i.c.a.e
    public final E g() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    private final void b(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.f16153b;
        q.a(objArr2, objArr, 0, this.f16152a, objArr2.length);
        Object[] objArr3 = this.f16153b;
        int length = objArr3.length;
        int i3 = this.f16152a;
        q.a(objArr3, objArr, length - i3, 0, i3);
        this.f16152a = 0;
        this.f16153b = objArr;
    }

    private final int c(int i2) {
        return i2 == 0 ? r.u(this.f16153b) : i2 - 1;
    }

    @i.c.a.e
    public final E e() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f16153b[i(this.f16152a + y.a((List) this))];
    }

    @Override // h.g2.g
    public int a() {
        return this.f16154c;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, @i.c.a.d Collection<? extends E> collection) {
        h.q2.t.i0.f(collection, "elements");
        d.Companion.b(i2, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(collection);
        }
        d(size() + collection.size());
        int i3 = i(this.f16152a + size());
        int i4 = i(this.f16152a + i2);
        int size = collection.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i5 = this.f16152a;
            int length = i5 - size;
            if (i4 < i5) {
                Object[] objArr = this.f16153b;
                q.a(objArr, objArr, length, i5, objArr.length);
                if (size >= i4) {
                    Object[] objArr2 = this.f16153b;
                    q.a(objArr2, objArr2, objArr2.length - size, 0, i4);
                } else {
                    Object[] objArr3 = this.f16153b;
                    q.a(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f16153b;
                    q.a(objArr4, objArr4, 0, size, i4);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f16153b;
                q.a(objArr5, objArr5, length, i5, i4);
            } else {
                Object[] objArr6 = this.f16153b;
                length += objArr6.length;
                int i6 = i4 - i5;
                int length2 = objArr6.length - length;
                if (length2 >= i6) {
                    q.a(objArr6, objArr6, length, i5, i4);
                } else {
                    q.a(objArr6, objArr6, length, i5, i5 + length2);
                    Object[] objArr7 = this.f16153b;
                    q.a(objArr7, objArr7, 0, this.f16152a + length2, i4);
                }
            }
            this.f16152a = length;
            a(h(i4 - size), collection);
        } else {
            int i7 = i4 + size;
            if (i4 < i3) {
                int i8 = size + i3;
                Object[] objArr8 = this.f16153b;
                if (i8 <= objArr8.length) {
                    q.a(objArr8, objArr8, i7, i4, i3);
                } else if (i7 >= objArr8.length) {
                    q.a(objArr8, objArr8, i7 - objArr8.length, i4, i3);
                } else {
                    int length3 = i3 - (i8 - objArr8.length);
                    q.a(objArr8, objArr8, 0, length3, i3);
                    Object[] objArr9 = this.f16153b;
                    q.a(objArr9, objArr9, i7, i4, length3);
                }
            } else {
                Object[] objArr10 = this.f16153b;
                q.a(objArr10, objArr10, size, 0, i3);
                Object[] objArr11 = this.f16153b;
                if (i7 >= objArr11.length) {
                    q.a(objArr11, objArr11, i7 - objArr11.length, i4, objArr11.length);
                } else {
                    q.a(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f16153b;
                    q.a(objArr12, objArr12, i7, i4, objArr12.length - size);
                }
            }
            a(i4, collection);
        }
        return true;
    }

    @i.c.a.e
    public final E c() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f16153b[this.f16152a];
    }

    private final void a(int i2, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f16153b.length;
        while (i2 < length && it.hasNext()) {
            this.f16153b[i2] = it.next();
            i2++;
        }
        int i3 = this.f16152a;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.f16153b[i4] = it.next();
        }
        this.f16154c = size() + collection.size();
    }

    public l() {
        this.f16153b = m.f16155a;
    }

    public l(@i.c.a.d Collection<? extends E> collection) {
        h.q2.t.i0.f(collection, "elements");
        Object[] array = collection.toArray(new Object[0]);
        if (array != null) {
            this.f16153b = array;
            Object[] objArr = this.f16153b;
            this.f16154c = objArr.length;
            if (objArr.length == 0) {
                this.f16153b = m.f16155a;
                return;
            }
            return;
        }
        throw new h.e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final E b() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f16153b[this.f16152a];
    }

    public final E d() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f16153b[i(this.f16152a + y.a((List) this))];
    }

    @Override // h.g2.g
    public E a(int i2) {
        d.Companion.a(i2, size());
        if (i2 == y.a((List) this)) {
            return removeLast();
        }
        if (i2 != 0) {
            int i3 = i(this.f16152a + i2);
            E e2 = (E) this.f16153b[i3];
            if (i2 < (size() >> 1)) {
                int i4 = this.f16152a;
                if (i3 >= i4) {
                    Object[] objArr = this.f16153b;
                    q.a(objArr, objArr, i4 + 1, i4, i3);
                } else {
                    Object[] objArr2 = this.f16153b;
                    q.a(objArr2, objArr2, 1, 0, i3);
                    Object[] objArr3 = this.f16153b;
                    objArr3[0] = objArr3[objArr3.length - 1];
                    int i5 = this.f16152a;
                    q.a(objArr3, objArr3, i5 + 1, i5, objArr3.length - 1);
                }
                Object[] objArr4 = this.f16153b;
                int i6 = this.f16152a;
                objArr4[i6] = null;
                this.f16152a = e(i6);
            } else {
                int i7 = i(this.f16152a + y.a((List) this));
                if (i3 <= i7) {
                    Object[] objArr5 = this.f16153b;
                    q.a(objArr5, objArr5, i3, i3 + 1, i7 + 1);
                } else {
                    Object[] objArr6 = this.f16153b;
                    q.a(objArr6, objArr6, i3, i3 + 1, objArr6.length);
                    Object[] objArr7 = this.f16153b;
                    objArr7[objArr7.length - 1] = objArr7[0];
                    q.a(objArr7, objArr7, 0, 1, i7 + 1);
                }
                this.f16153b[i7] = null;
            }
            this.f16154c = size() - 1;
            return e2;
        }
        return removeFirst();
    }

    private final boolean a(h.q2.s.l<? super E, Boolean> lVar) {
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f16153b.length == 0)) {
                int i2 = i(this.f16152a + size());
                int i3 = this.f16152a;
                if (this.f16152a < i2) {
                    for (int i4 = this.f16152a; i4 < i2; i4++) {
                        Object obj = this.f16153b[i4];
                        if (lVar.invoke(obj).booleanValue()) {
                            this.f16153b[i3] = obj;
                            i3++;
                        } else {
                            z = true;
                        }
                    }
                    q.b(this.f16153b, (Object) null, i3, i2);
                } else {
                    int length = this.f16153b.length;
                    boolean z2 = false;
                    for (int i5 = this.f16152a; i5 < length; i5++) {
                        Object obj2 = this.f16153b[i5];
                        this.f16153b[i5] = null;
                        if (lVar.invoke(obj2).booleanValue()) {
                            this.f16153b[i3] = obj2;
                            i3++;
                        } else {
                            z2 = true;
                        }
                    }
                    i3 = i(i3);
                    for (int i6 = 0; i6 < i2; i6++) {
                        Object obj3 = this.f16153b[i6];
                        this.f16153b[i6] = null;
                        if (lVar.invoke(obj3).booleanValue()) {
                            this.f16153b[i3] = obj3;
                            i3 = e(i3);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f16154c = h(i3 - this.f16152a);
                }
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.lang.Object[]] */
    public final void a(@i.c.a.d h.q2.s.p<? super Integer, ? super Object[], h.y1> pVar) {
        h.q2.t.i0.f(pVar, "structure");
        int i2 = i(this.f16152a + size());
        if (isEmpty()) {
            pVar.invoke(Integer.valueOf(this.f16152a), new Object[0]);
            return;
        }
        ?? r0 = new Object[size()];
        int i3 = this.f16152a;
        if (i3 < i2) {
            q.a(this.f16153b, (Object[]) r0, 0, i3, i2, 2, (Object) null);
            pVar.invoke(Integer.valueOf(this.f16152a), r0);
        } else {
            q.a(this.f16153b, (Object[]) r0, 0, i3, 0, 10, (Object) null);
            Object[] objArr = this.f16153b;
            q.a(objArr, (Object[]) r0, objArr.length - this.f16152a, 0, i2);
            pVar.invoke(Integer.valueOf(this.f16152a - this.f16153b.length), r0);
        }
    }
}
