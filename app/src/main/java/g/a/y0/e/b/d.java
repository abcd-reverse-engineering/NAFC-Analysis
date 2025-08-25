package g.a.y0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: BlockingFlowableMostRecent.java */
/* loaded from: classes2.dex */
public final class d<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14159a;

    /* renamed from: b, reason: collision with root package name */
    final T f14160b;

    /* compiled from: BlockingFlowableMostRecent.java */
    static final class a<T> extends g.a.g1.a<T> {

        /* renamed from: b, reason: collision with root package name */
        volatile Object f14161b;

        /* compiled from: BlockingFlowableMostRecent.java */
        /* renamed from: g.a.y0.e.b.d$a$a, reason: collision with other inner class name */
        final class C0188a implements Iterator<T> {

            /* renamed from: a, reason: collision with root package name */
            private Object f14162a;

            C0188a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f14162a = a.this.f14161b;
                return !g.a.y0.j.q.isComplete(this.f14162a);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f14162a == null) {
                        this.f14162a = a.this.f14161b;
                    }
                    if (g.a.y0.j.q.isComplete(this.f14162a)) {
                        throw new NoSuchElementException();
                    }
                    if (g.a.y0.j.q.isError(this.f14162a)) {
                        throw g.a.y0.j.k.c(g.a.y0.j.q.getError(this.f14162a));
                    }
                    return (T) g.a.y0.j.q.getValue(this.f14162a);
                } finally {
                    this.f14162a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        a(T t) {
            this.f14161b = g.a.y0.j.q.next(t);
        }

        public a<T>.C0188a c() {
            return new C0188a();
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14161b = g.a.y0.j.q.complete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14161b = g.a.y0.j.q.error(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.f14161b = g.a.y0.j.q.next(t);
        }
    }

    public d(g.a.l<T> lVar, T t) {
        this.f14159a = lVar;
        this.f14160b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f14160b);
        this.f14159a.a((g.a.q) aVar);
        return aVar.c();
    }
}
