package g.a.y0.e.a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CompletableConcatIterable.java */
/* loaded from: classes2.dex */
public final class e extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends g.a.i> f14004a;

    /* compiled from: CompletableConcatIterable.java */
    static final class a extends AtomicInteger implements g.a.f {
        private static final long serialVersionUID = -7965400327305809232L;
        final g.a.f actual;
        final g.a.y0.a.k sd = new g.a.y0.a.k();
        final Iterator<? extends g.a.i> sources;

        a(g.a.f fVar, Iterator<? extends g.a.i> it) {
            this.actual = fVar;
            this.sources = it;
        }

        void next() {
            if (!this.sd.isDisposed() && getAndIncrement() == 0) {
                Iterator<? extends g.a.i> it = this.sources;
                while (!this.sd.isDisposed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onComplete();
                            return;
                        }
                        try {
                            ((g.a.i) g.a.y0.b.b.a(it.next(), "The CompletableSource returned is null")).a(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            g.a.v0.b.b(th);
                            this.actual.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        this.actual.onError(th2);
                        return;
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

    public e(Iterable<? extends g.a.i> iterable) {
        this.f14004a = iterable;
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        try {
            a aVar = new a(fVar, (Iterator) g.a.y0.b.b.a(this.f14004a.iterator(), "The iterator returned is null"));
            fVar.onSubscribe(aVar.sd);
            aVar.next();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, fVar);
        }
    }
}
