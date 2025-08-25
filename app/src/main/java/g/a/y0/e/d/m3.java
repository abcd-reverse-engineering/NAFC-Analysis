package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableTakeUntil.java */
/* loaded from: classes2.dex */
public final class m3<T, U> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.g0<? extends U> f15326b;

    /* compiled from: ObservableTakeUntil.java */
    final class a implements g.a.i0<U> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.y0.a.a f15327a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.a1.m<T> f15328b;

        a(g.a.y0.a.a aVar, g.a.a1.m<T> mVar) {
            this.f15327a = aVar;
            this.f15328b = mVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f15327a.dispose();
            this.f15328b.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15327a.dispose();
            this.f15328b.onError(th);
        }

        @Override // g.a.i0
        public void onNext(U u) {
            this.f15327a.dispose();
            this.f15328b.onComplete();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15327a.setResource(1, cVar);
        }
    }

    /* compiled from: ObservableTakeUntil.java */
    static final class b<T> extends AtomicBoolean implements g.a.i0<T> {
        private static final long serialVersionUID = 3451719290311127173L;
        final g.a.i0<? super T> actual;
        final g.a.y0.a.a frc;
        g.a.u0.c s;

        b(g.a.i0<? super T> i0Var, g.a.y0.a.a aVar) {
            this.actual = i0Var;
            this.frc = aVar;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.frc.dispose();
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.frc.dispose();
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
                this.frc.setResource(0, cVar);
            }
        }
    }

    public m3(g.a.g0<T> g0Var, g.a.g0<? extends U> g0Var2) {
        super(g0Var);
        this.f15326b = g0Var2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.a1.m mVar = new g.a.a1.m(i0Var);
        g.a.y0.a.a aVar = new g.a.y0.a.a(2);
        b bVar = new b(mVar, aVar);
        i0Var.onSubscribe(aVar);
        this.f15326b.subscribe(new a(aVar, mVar));
        this.f14934a.subscribe(bVar);
    }
}
