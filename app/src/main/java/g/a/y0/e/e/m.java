package g.a.y0.e.e;

import h.q2.t.m0;
import java.util.concurrent.Callable;

/* compiled from: ParallelReduce.java */
/* loaded from: classes2.dex */
public final class m<T, R> extends g.a.b1.b<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<? extends T> f15714a;

    /* renamed from: b, reason: collision with root package name */
    final Callable<R> f15715b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<R, ? super T, R> f15716c;

    /* compiled from: ParallelReduce.java */
    static final class a<T, R> extends g.a.y0.h.g<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;
        R accumulator;
        boolean done;
        final g.a.x0.c<R, ? super T, R> reducer;

        a(i.d.c<? super R> cVar, R r, g.a.x0.c<R, ? super T, R> cVar2) {
            super(cVar);
            this.accumulator = r;
            this.reducer = cVar2;
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
            R r = this.accumulator;
            this.accumulator = null;
            complete(r);
        }

        @Override // g.a.y0.h.g, i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.accumulator = null;
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.accumulator = (R) g.a.y0.b.b.a(this.reducer.apply(this.accumulator, t), "The reducer returned a null value");
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

    public m(g.a.b1.b<? extends T> bVar, Callable<R> callable, g.a.x0.c<R, ? super T, R> cVar) {
        this.f15714a = bVar;
        this.f15715b = callable;
        this.f15716c = cVar;
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super R>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super Object>[] cVarArr2 = new i.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    cVarArr2[i2] = new a(cVarArr[i2], g.a.y0.b.b.a(this.f15715b.call(), "The initialSupplier returned a null value"), this.f15716c);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    a(cVarArr, th);
                    return;
                }
            }
            this.f15714a.a(cVarArr2);
        }
    }

    void a(i.d.c<?>[] cVarArr, Throwable th) {
        for (i.d.c<?> cVar : cVarArr) {
            g.a.y0.i.g.error(th, cVar);
        }
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15714a.a();
    }
}
