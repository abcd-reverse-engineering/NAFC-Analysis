package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CompletableConcatArray.java */
/* loaded from: classes2.dex */
public final class d extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i[] f14002a;

    /* compiled from: CompletableConcatArray.java */
    static final class a extends AtomicInteger implements g.a.f {
        private static final long serialVersionUID = -7965400327305809232L;
        final g.a.f actual;
        int index;
        final g.a.y0.a.k sd = new g.a.y0.a.k();
        final g.a.i[] sources;

        a(g.a.f fVar, g.a.i[] iVarArr) {
            this.actual = fVar;
            this.sources = iVarArr;
        }

        void next() {
            if (!this.sd.isDisposed() && getAndIncrement() == 0) {
                g.a.i[] iVarArr = this.sources;
                while (!this.sd.isDisposed()) {
                    int i2 = this.index;
                    this.index = i2 + 1;
                    if (i2 == iVarArr.length) {
                        this.actual.onComplete();
                        return;
                    } else {
                        iVarArr[i2].a(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // g.a.f
        public void onComplete() {
            next();
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.sd.replace(cVar);
        }
    }

    public d(g.a.i[] iVarArr) {
        this.f14002a = iVarArr;
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        a aVar = new a(fVar, this.f14002a);
        fVar.onSubscribe(aVar.sd);
        aVar.next();
    }
}
