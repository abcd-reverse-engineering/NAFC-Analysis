package g.a.y0.e.f;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

/* compiled from: SingleInternalHelper.java */
/* loaded from: classes2.dex */
public final class e0 {

    /* compiled from: SingleInternalHelper.java */
    enum a implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }
    }

    /* compiled from: SingleInternalHelper.java */
    enum b implements g.a.x0.o<g.a.q0, i.d.b> {
        INSTANCE;

        @Override // g.a.x0.o
        public i.d.b apply(g.a.q0 q0Var) {
            return new q0(q0Var);
        }
    }

    /* compiled from: SingleInternalHelper.java */
    static final class c<T> implements Iterable<g.a.l<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Iterable<? extends g.a.q0<? extends T>> f15753a;

        c(Iterable<? extends g.a.q0<? extends T>> iterable) {
            this.f15753a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<g.a.l<T>> iterator() {
            return new d(this.f15753a.iterator());
        }
    }

    /* compiled from: SingleInternalHelper.java */
    static final class d<T> implements Iterator<g.a.l<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<? extends g.a.q0<? extends T>> f15754a;

        d(Iterator<? extends g.a.q0<? extends T>> it) {
            this.f15754a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15754a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public g.a.l<T> next() {
            return new q0(this.f15754a.next());
        }
    }

    /* compiled from: SingleInternalHelper.java */
    enum e implements g.a.x0.o<g.a.q0, g.a.b0> {
        INSTANCE;

        @Override // g.a.x0.o
        public g.a.b0 apply(g.a.q0 q0Var) {
            return new r0(q0Var);
        }
    }

    private e0() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Callable<NoSuchElementException> a() {
        return a.INSTANCE;
    }

    public static <T> g.a.x0.o<g.a.q0<? extends T>, i.d.b<? extends T>> b() {
        return b.INSTANCE;
    }

    public static <T> g.a.x0.o<g.a.q0<? extends T>, g.a.b0<? extends T>> c() {
        return e.INSTANCE;
    }

    public static <T> Iterable<? extends g.a.l<T>> a(Iterable<? extends g.a.q0<? extends T>> iterable) {
        return new c(iterable);
    }
}
