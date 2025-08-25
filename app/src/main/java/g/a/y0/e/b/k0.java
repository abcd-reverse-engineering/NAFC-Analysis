package g.a.y0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: FlowableDistinct.java */
/* loaded from: classes2.dex */
public final class k0<T, K> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, K> f14317c;

    /* renamed from: d, reason: collision with root package name */
    final Callable<? extends Collection<? super K>> f14318d;

    /* compiled from: FlowableDistinct.java */
    static final class a<T, K> extends g.a.y0.h.b<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final Collection<? super K> f14319f;

        /* renamed from: g, reason: collision with root package name */
        final g.a.x0.o<? super T, K> f14320g;

        a(i.d.c<? super T> cVar, g.a.x0.o<? super T, K> oVar, Collection<? super K> collection) {
            super(cVar);
            this.f14320g = oVar;
            this.f14319f = collection;
        }

        @Override // g.a.y0.h.b, g.a.y0.c.o
        public void clear() {
            this.f14319f.clear();
            super.clear();
        }

        @Override // g.a.y0.h.b, i.d.c
        public void onComplete() {
            if (this.f16013d) {
                return;
            }
            this.f16013d = true;
            this.f14319f.clear();
            this.f16010a.onComplete();
        }

        @Override // g.a.y0.h.b, i.d.c
        public void onError(Throwable th) {
            if (this.f16013d) {
                g.a.c1.a.b(th);
                return;
            }
            this.f16013d = true;
            this.f14319f.clear();
            this.f16010a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f16013d) {
                return;
            }
            if (this.f16014e != 0) {
                this.f16010a.onNext(null);
                return;
            }
            try {
                if (this.f14319f.add(g.a.y0.b.b.a(this.f14320g.apply(t), "The keySelector returned a null key"))) {
                    this.f16010a.onNext(t);
                } else {
                    this.f16011b.request(1L);
                }
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T tPoll;
            while (true) {
                tPoll = this.f16012c.poll();
                if (tPoll == null || this.f14319f.add((Object) g.a.y0.b.b.a(this.f14320g.apply(tPoll), "The keySelector returned a null key"))) {
                    break;
                }
                if (this.f16014e == 2) {
                    this.f16011b.request(1L);
                }
            }
            return tPoll;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public k0(g.a.l<T> lVar, g.a.x0.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        super(lVar);
        this.f14317c = oVar;
        this.f14318d = callable;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        try {
            this.f14110b.a((g.a.q) new a(cVar, this.f14317c, (Collection) g.a.y0.b.b.a(this.f14318d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.i.g.error(th, cVar);
        }
    }
}
