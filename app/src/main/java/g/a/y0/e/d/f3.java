package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSubscribeOn.java */
/* loaded from: classes2.dex */
public final class f3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f15119b;

    /* compiled from: ObservableSubscribeOn.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 8094547886072529208L;
        final g.a.i0<? super T> actual;
        final AtomicReference<g.a.u0.c> s = new AtomicReference<>();

        a(g.a.i0<? super T> i0Var) {
            this.actual = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this.s);
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this.s, cVar);
        }

        void setDisposable(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final a<T> f15120a;

        b(a<T> aVar) {
            this.f15120a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f3.this.f14934a.subscribe(this.f15120a);
        }
    }

    public f3(g.a.g0<T> g0Var, g.a.j0 j0Var) {
        super(g0Var);
        this.f15119b = j0Var;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        a aVar = new a(i0Var);
        i0Var.onSubscribe(aVar);
        aVar.setDisposable(this.f15119b.a(new b(aVar)));
    }
}
