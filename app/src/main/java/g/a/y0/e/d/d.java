package g.a.y0.e.d;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: BlockingObservableMostRecent.java */
/* loaded from: classes2.dex */
public final class d<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15029a;

    /* renamed from: b, reason: collision with root package name */
    final T f15030b;

    /* compiled from: BlockingObservableMostRecent.java */
    static final class a<T> extends g.a.a1.b<T> {

        /* renamed from: b, reason: collision with root package name */
        volatile Object f15031b;

        /* compiled from: BlockingObservableMostRecent.java */
        /* renamed from: g.a.y0.e.d.d$a$a, reason: collision with other inner class name */
        final class C0210a implements Iterator<T> {

            /* renamed from: a, reason: collision with root package name */
            private Object f15032a;

            C0210a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f15032a = a.this.f15031b;
                return !g.a.y0.j.q.isComplete(this.f15032a);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f15032a == null) {
                        this.f15032a = a.this.f15031b;
                    }
                    if (g.a.y0.j.q.isComplete(this.f15032a)) {
                        throw new NoSuchElementException();
                    }
                    if (g.a.y0.j.q.isError(this.f15032a)) {
                        throw g.a.y0.j.k.c(g.a.y0.j.q.getError(this.f15032a));
                    }
                    return (T) g.a.y0.j.q.getValue(this.f15032a);
                } finally {
                    this.f15032a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        a(T t) {
            this.f15031b = g.a.y0.j.q.next(t);
        }

        public a<T>.C0210a c() {
            return new C0210a();
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15031b = g.a.y0.j.q.complete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15031b = g.a.y0.j.q.error(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.f15031b = g.a.y0.j.q.next(t);
        }
    }

    public d(g.a.g0<T> g0Var, T t) {
        this.f15029a = g0Var;
        this.f15030b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f15030b);
        this.f15029a.subscribe(aVar);
        return aVar.c();
    }
}
