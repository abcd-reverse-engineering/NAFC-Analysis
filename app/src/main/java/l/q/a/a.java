package l.q.a;

import g.a.b0;
import g.a.i0;
import l.m;

/* compiled from: BodyObservable.java */
/* loaded from: classes2.dex */
final class a<T> extends b0<T> {

    /* renamed from: a, reason: collision with root package name */
    private final b0<m<T>> f17211a;

    /* compiled from: BodyObservable.java */
    /* renamed from: l.q.a.a$a, reason: collision with other inner class name */
    private static class C0273a<R> implements i0<m<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final i0<? super R> f17212a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f17213b;

        C0273a(i0<? super R> i0Var) {
            this.f17212a = i0Var;
        }

        @Override // g.a.i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(m<R> mVar) {
            if (mVar.e()) {
                this.f17212a.onNext(mVar.a());
                return;
            }
            this.f17213b = true;
            d dVar = new d(mVar);
            try {
                this.f17212a.onError(dVar);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(new g.a.v0.a(dVar, th));
            }
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f17213b) {
                return;
            }
            this.f17212a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (!this.f17213b) {
                this.f17212a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            g.a.c1.a.b(assertionError);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f17212a.onSubscribe(cVar);
        }
    }

    a(b0<m<T>> b0Var) {
        this.f17211a = b0Var;
    }

    @Override // g.a.b0
    protected void d(i0<? super T> i0Var) {
        this.f17211a.subscribe(new C0273a(i0Var));
    }
}
