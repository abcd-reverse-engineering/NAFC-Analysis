package g.a.y0.e.e;

import h.q2.t.m0;
import java.util.concurrent.Callable;

/* compiled from: ParallelCollect.java */
/* loaded from: classes2.dex */
public final class a<T, C> extends g.a.b1.b<C> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<? extends T> f15624a;

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends C> f15625b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.b<? super C, ? super T> f15626c;

    /* compiled from: ParallelCollect.java */
    /* renamed from: g.a.y0.e.e.a$a, reason: collision with other inner class name */
    static final class C0222a<T, C> extends g.a.y0.h.g<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        C collection;
        final g.a.x0.b<? super C, ? super T> collector;
        boolean done;

        C0222a(i.d.c<? super C> cVar, C c2, g.a.x0.b<? super C, ? super T> bVar) {
            super(cVar);
            this.collection = c2;
            this.collector = bVar;
        }

        @Override // g.a.y0.h.g, g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // g.a.y0.h.g, i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c2 = this.collection;
            this.collection = null;
            complete(c2);
        }

        @Override // g.a.y0.h.g, i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.collection = null;
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.collector.a(this.collection, t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // g.a.y0.h.g, g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(m0.f16408b);
            }
        }
    }

    public a(g.a.b1.b<? extends T> bVar, Callable<? extends C> callable, g.a.x0.b<? super C, ? super T> bVar2) {
        this.f15624a = bVar;
        this.f15625b = callable;
        this.f15626c = bVar2;
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super C>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super Object>[] cVarArr2 = new i.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    cVarArr2[i2] = new C0222a(cVarArr[i2], g.a.y0.b.b.a(this.f15625b.call(), "The initialSupplier returned a null value"), this.f15626c);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    a(cVarArr, th);
                    return;
                }
            }
            this.f15624a.a(cVarArr2);
        }
    }

    void a(i.d.c<?>[] cVarArr, Throwable th) {
        for (i.d.c<?> cVar : cVarArr) {
            g.a.y0.i.g.error(th, cVar);
        }
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15624a.a();
    }
}
