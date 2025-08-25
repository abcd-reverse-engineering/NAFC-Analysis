package g.a.y0.e.d;

import java.util.ArrayDeque;

/* compiled from: ObservableTakeLast.java */
/* loaded from: classes2.dex */
public final class j3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final int f15231b;

    /* compiled from: ObservableTakeLast.java */
    static final class a<T> extends ArrayDeque<T> implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 7240042530241604978L;
        final g.a.i0<? super T> actual;
        volatile boolean cancelled;
        final int count;
        g.a.u0.c s;

        a(g.a.i0<? super T> i0Var, int i2) {
            this.actual = i0Var;
            this.count = i2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.i0
        public void onComplete() {
            g.a.i0<? super T> i0Var = this.actual;
            while (!this.cancelled) {
                T tPoll = poll();
                if (tPoll == null) {
                    if (this.cancelled) {
                        return;
                    }
                    i0Var.onComplete();
                    return;
                }
                i0Var.onNext(tPoll);
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
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

    public j3(g.a.g0<T> g0Var, int i2) {
        super(g0Var);
        this.f15231b = i2;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15231b));
    }
}
