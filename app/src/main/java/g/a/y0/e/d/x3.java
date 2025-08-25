package g.a.y0.e.d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableUsing.java */
/* loaded from: classes2.dex */
public final class x3<T, D> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends D> f15576a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super D, ? extends g.a.g0<? extends T>> f15577b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super D> f15578c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f15579d;

    /* compiled from: ObservableUsing.java */
    static final class a<T, D> extends AtomicBoolean implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 5904473792286235046L;
        final g.a.i0<? super T> actual;
        final g.a.x0.g<? super D> disposer;
        final boolean eager;
        final D resource;
        g.a.u0.c s;

        a(g.a.i0<? super T> i0Var, D d2, g.a.x0.g<? super D> gVar, boolean z) {
            this.actual = i0Var;
            this.resource = d2;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // g.a.u0.c
        public void dispose() {
            disposeAfter();
            this.s.dispose();
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

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (!this.eager) {
                this.actual.onComplete();
                this.s.dispose();
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
            this.s.dispose();
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (!this.eager) {
                this.actual.onError(th);
                this.s.dispose();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    th = new g.a.v0.a(th, th2);
                }
            }
            this.s.dispose();
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public x3(Callable<? extends D> callable, g.a.x0.o<? super D, ? extends g.a.g0<? extends T>> oVar, g.a.x0.g<? super D> gVar, boolean z) {
        this.f15576a = callable;
        this.f15577b = oVar;
        this.f15578c = gVar;
        this.f15579d = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        try {
            D dCall = this.f15576a.call();
            try {
                ((g.a.g0) g.a.y0.b.b.a(this.f15577b.apply(dCall), "The sourceSupplier returned a null ObservableSource")).subscribe(new a(i0Var, dCall, this.f15578c, this.f15579d));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                try {
                    this.f15578c.accept(dCall);
                    g.a.y0.a.e.error(th, i0Var);
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    g.a.y0.a.e.error(new g.a.v0.a(th, th2), i0Var);
                }
            }
        } catch (Throwable th3) {
            g.a.v0.b.b(th3);
            g.a.y0.a.e.error(th3, i0Var);
        }
    }
}
