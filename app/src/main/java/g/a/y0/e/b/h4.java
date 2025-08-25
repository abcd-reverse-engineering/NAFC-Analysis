package g.a.y0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: FlowableToList.java */
/* loaded from: classes2.dex */
public final class h4<T, U extends Collection<? super T>> extends g.a.y0.e.b.a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final Callable<U> f14280c;

    /* compiled from: FlowableToList.java */
    static final class a<T, U extends Collection<? super T>> extends g.a.y0.i.f<U> implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -8134157938864266736L;
        i.d.d s;

        /* JADX WARN: Multi-variable type inference failed */
        a(i.d.c<? super U> cVar, U u) {
            super(cVar);
            this.value = u;
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            complete(this.value);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.value = null;
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            Collection collection = (Collection) this.value;
            if (collection != null) {
                collection.add(t);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public h4(g.a.l<T> lVar, Callable<U> callable) {
        super(lVar);
        this.f14280c = callable;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super U> cVar) {
        try {
            this.f14110b.a((g.a.q) new a(cVar, (Collection) g.a.y0.b.b.a(this.f14280c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.i.g.error(th, cVar);
        }
    }
}
