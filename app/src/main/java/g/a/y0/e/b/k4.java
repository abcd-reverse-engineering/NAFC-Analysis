package g.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FlowableUsing.java */
/* loaded from: classes2.dex */
public final class k4<T, D> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends D> f14332b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super D, ? extends i.d.b<? extends T>> f14333c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.g<? super D> f14334d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f14335e;

    /* compiled from: FlowableUsing.java */
    static final class a<T, D> extends AtomicBoolean implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = 5904473792286235046L;
        final i.d.c<? super T> actual;
        final g.a.x0.g<? super D> disposer;
        final boolean eager;
        final D resource;
        i.d.d s;

        a(i.d.c<? super T> cVar, D d2, g.a.x0.g<? super D> gVar, boolean z) {
            this.actual = cVar;
            this.resource = d2;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // i.d.d
        public void cancel() {
            disposeAfter();
            this.s.cancel();
        }

        void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            }
        }

        @Override // i.d.c
        public void onComplete() {
            if (!this.eager) {
                this.actual.onComplete();
                this.s.cancel();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.s.cancel();
            this.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (!this.eager) {
                this.actual.onError(th);
                this.s.cancel();
                disposeAfter();
                return;
            }
            Throwable th2 = null;
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th3) {
                    th2 = th3;
                    g.a.v0.b.b(th2);
                }
            }
            this.s.cancel();
            if (th2 != null) {
                this.actual.onError(new g.a.v0.a(th, th2));
            } else {
                this.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.s.request(j2);
        }
    }

    public k4(Callable<? extends D> callable, g.a.x0.o<? super D, ? extends i.d.b<? extends T>> oVar, g.a.x0.g<? super D> gVar, boolean z) {
        this.f14332b = callable;
        this.f14333c = oVar;
        this.f14334d = gVar;
        this.f14335e = z;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        try {
            D dCall = this.f14332b.call();
            try {
                ((i.d.b) g.a.y0.b.b.a(this.f14333c.apply(dCall), "The sourceSupplier returned a null Publisher")).subscribe(new a(cVar, dCall, this.f14334d, this.f14335e));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                try {
                    this.f14334d.accept(dCall);
                    g.a.y0.i.g.error(th, cVar);
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    g.a.y0.i.g.error(new g.a.v0.a(th, th2), cVar);
                }
            }
        } catch (Throwable th3) {
            g.a.v0.b.b(th3);
            g.a.y0.i.g.error(th3, cVar);
        }
    }
}
