package g.a.y0.e.d;

import java.util.ArrayDeque;

/* compiled from: ObservableSkipLast.java */
/* loaded from: classes2.dex */
public final class b3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final int f14984b;

    /* compiled from: ObservableSkipLast.java */
    static final class a<T> extends ArrayDeque<T> implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = -3807491841935125653L;
        final g.a.i0<? super T> actual;
        g.a.u0.c s;
        final int skip;

        a(g.a.i0<? super T> i0Var, int i2) {
            super(i2);
            this.actual = i0Var;
            this.skip = i2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.s.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.s.isDisposed();
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
            if (this.skip == size()) {
                this.actual.onNext(poll());
            }
            offer(t);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public b3(g.a.g0<T> g0Var, int i2) {
        super(g0Var);
        this.f14984b = i2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f14984b));
    }
}
