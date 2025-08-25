package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CompletableMergeArray.java */
/* loaded from: classes2.dex */
public final class z extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i[] f14109a;

    /* compiled from: CompletableMergeArray.java */
    static final class a extends AtomicInteger implements g.a.f {
        private static final long serialVersionUID = -8360547806504310570L;
        final g.a.f actual;
        final AtomicBoolean once;
        final g.a.u0.b set;

        a(g.a.f fVar, AtomicBoolean atomicBoolean, g.a.u0.b bVar, int i2) {
            this.actual = fVar;
            this.once = atomicBoolean;
            this.set = bVar;
            lazySet(i2);
        }

        @Override // g.a.f
        public void onComplete() {
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.set.b(cVar);
        }
    }

    public z(g.a.i[] iVarArr) {
        this.f14109a = iVarArr;
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        g.a.u0.b bVar = new g.a.u0.b();
        a aVar = new a(fVar, new AtomicBoolean(), bVar, this.f14109a.length + 1);
        fVar.onSubscribe(bVar);
        for (g.a.i iVar : this.f14109a) {
            if (bVar.isDisposed()) {
                return;
            }
            if (iVar == null) {
                bVar.dispose();
                aVar.onError(new NullPointerException("A completable source is null"));
                return;
            }
            iVar.a(aVar);
        }
        aVar.onComplete();
    }
}
