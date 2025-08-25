package g.a.y0.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableDistinct.java */
/* loaded from: classes2.dex */
public final class i0<T, K> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, K> f15194b;

    /* renamed from: c, reason: collision with root package name */
    final Callable<? extends Collection<? super K>> f15195c;

    /* compiled from: ObservableDistinct.java */
    static final class a<T, K> extends g.a.y0.d.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final Collection<? super K> f15196f;

        /* renamed from: g, reason: collision with root package name */
        final g.a.x0.o<? super T, K> f15197g;

        a(g.a.i0<? super T> i0Var, g.a.x0.o<? super T, K> oVar, Collection<? super K> collection) {
            super(i0Var);
            this.f15197g = oVar;
            this.f15196f = collection;
        }

        @Override // g.a.y0.d.a, g.a.y0.c.o
        public void clear() {
            this.f15196f.clear();
            super.clear();
        }

        @Override // g.a.y0.d.a, g.a.i0
        public void onComplete() {
            if (this.f13943d) {
                return;
            }
            this.f13943d = true;
            this.f15196f.clear();
            this.f13940a.onComplete();
        }

        @Override // g.a.y0.d.a, g.a.i0
        public void onError(Throwable th) {
            if (this.f13943d) {
                g.a.c1.a.b(th);
                return;
            }
            this.f13943d = true;
            this.f15196f.clear();
            this.f13940a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f13943d) {
                return;
            }
            if (this.f13944e != 0) {
                this.f13940a.onNext(null);
                return;
            }
            try {
                if (this.f15196f.add(g.a.y0.b.b.a(this.f15197g.apply(t), "The keySelector returned a null key"))) {
                    this.f13940a.onNext(t);
                }
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f13942c.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f15196f.add((Object) g.a.y0.b.b.a(this.f15197g.apply(tPoll), "The keySelector returned a null key")));
            return tPoll;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public i0(g.a.g0<T> g0Var, g.a.x0.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        super(g0Var);
        this.f15194b = oVar;
        this.f15195c = callable;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        try {
            this.f14934a.subscribe(new a(i0Var, this.f15194b, (Collection) g.a.y0.b.b.a(this.f15195c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, i0Var);
        }
    }
}
