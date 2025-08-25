package g.a.y0.f;

import g.a.t0.g;
import g.a.y0.c.n;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MpscLinkedQueue.java */
/* loaded from: classes2.dex */
public final class a<T> implements n<T> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<C0229a<T>> f15883a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<C0229a<T>> f15884b = new AtomicReference<>();

    /* compiled from: MpscLinkedQueue.java */
    /* renamed from: g.a.y0.f.a$a, reason: collision with other inner class name */
    static final class C0229a<E> extends AtomicReference<C0229a<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        C0229a() {
        }

        public E getAndNullValue() {
            E eLpValue = lpValue();
            spValue(null);
            return eLpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public C0229a<E> lvNext() {
            return get();
        }

        public void soNext(C0229a<E> c0229a) {
            lazySet(c0229a);
        }

        public void spValue(E e2) {
            this.value = e2;
        }

        C0229a(E e2) {
            spValue(e2);
        }
    }

    public a() {
        C0229a<T> c0229a = new C0229a<>();
        a(c0229a);
        b(c0229a);
    }

    C0229a<T> a() {
        return this.f15884b.get();
    }

    C0229a<T> b(C0229a<T> c0229a) {
        return this.f15883a.getAndSet(c0229a);
    }

    C0229a<T> c() {
        return this.f15883a.get();
    }

    @Override // g.a.y0.c.o
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // g.a.y0.c.o
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // g.a.y0.c.o
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        C0229a<T> c0229a = new C0229a<>(t);
        b(c0229a).soNext(c0229a);
        return true;
    }

    @Override // g.a.y0.c.n, g.a.y0.c.o
    @g
    public T poll() {
        C0229a<T> c0229aLvNext;
        C0229a<T> c0229aA = a();
        C0229a<T> c0229aLvNext2 = c0229aA.lvNext();
        if (c0229aLvNext2 != null) {
            T andNullValue = c0229aLvNext2.getAndNullValue();
            a(c0229aLvNext2);
            return andNullValue;
        }
        if (c0229aA == c()) {
            return null;
        }
        do {
            c0229aLvNext = c0229aA.lvNext();
        } while (c0229aLvNext == null);
        T andNullValue2 = c0229aLvNext.getAndNullValue();
        a(c0229aLvNext);
        return andNullValue2;
    }

    void a(C0229a<T> c0229a) {
        this.f15884b.lazySet(c0229a);
    }

    C0229a<T> b() {
        return this.f15884b.get();
    }

    @Override // g.a.y0.c.o
    public boolean offer(T t, T t2) {
        offer(t);
        offer(t2);
        return true;
    }
}
