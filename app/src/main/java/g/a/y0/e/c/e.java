package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeConcatArray.java */
/* loaded from: classes2.dex */
public final class e<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.y<? extends T>[] f14788b;

    /* compiled from: MaybeConcatArray.java */
    static final class a<T> extends AtomicInteger implements g.a.v<T>, i.d.d {
        private static final long serialVersionUID = 3520831347801429610L;
        final i.d.c<? super T> actual;
        int index;
        long produced;
        final g.a.y<? extends T>[] sources;
        final AtomicLong requested = new AtomicLong();
        final g.a.y0.a.k disposables = new g.a.y0.a.k();
        final AtomicReference<Object> current = new AtomicReference<>(g.a.y0.j.q.COMPLETE);

        a(i.d.c<? super T> cVar, g.a.y<? extends T>[] yVarArr) {
            this.actual = cVar;
            this.sources = yVarArr;
        }

        @Override // i.d.d
        public void cancel() {
            this.disposables.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<Object> atomicReference = this.current;
            i.d.c<? super T> cVar = this.actual;
            g.a.y0.a.k kVar = this.disposables;
            while (!kVar.isDisposed()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    boolean z = true;
                    if (obj != g.a.y0.j.q.COMPLETE) {
                        long j2 = this.produced;
                        if (j2 != this.requested.get()) {
                            this.produced = j2 + 1;
                            atomicReference.lazySet(null);
                            cVar.onNext(obj);
                        } else {
                            z = false;
                        }
                    } else {
                        atomicReference.lazySet(null);
                    }
                    if (z && !kVar.isDisposed()) {
                        int i2 = this.index;
                        g.a.y<? extends T>[] yVarArr = this.sources;
                        if (i2 == yVarArr.length) {
                            cVar.onComplete();
                            return;
                        } else {
                            this.index = i2 + 1;
                            yVarArr[i2].a(this);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // g.a.v
        public void onComplete() {
            this.current.lazySet(g.a.y0.j.q.COMPLETE);
            drain();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            this.disposables.replace(cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public e(g.a.y<? extends T>[] yVarArr) {
        this.f14788b = yVarArr;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        a aVar = new a(cVar, this.f14788b);
        cVar.onSubscribe(aVar);
        aVar.drain();
    }
}
