package l.q.a;

import g.a.b0;
import g.a.i0;
import l.m;

/* compiled from: ResultObservable.java */
/* loaded from: classes2.dex */
final class f<T> extends b0<e<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final b0<m<T>> f17224a;

    /* compiled from: ResultObservable.java */
    private static class a<R> implements i0<m<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final i0<? super e<R>> f17225a;

        a(i0<? super e<R>> i0Var) {
            this.f17225a = i0Var;
        }

        @Override // g.a.i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(m<R> mVar) {
            this.f17225a.onNext(e.a(mVar));
        }

        @Override // g.a.i0
        public void onComplete() {
            this.f17225a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            try {
                this.f17225a.onNext(e.a(th));
                this.f17225a.onComplete();
            } catch (Throwable th2) {
                try {
                    this.f17225a.onError(th2);
                } catch (Throwable th3) {
                    g.a.v0.b.b(th3);
                    g.a.c1.a.b(new g.a.v0.a(th2, th3));
                }
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f17225a.onSubscribe(cVar);
        }
    }

    f(b0<m<T>> b0Var) {
        this.f17224a = b0Var;
    }

    @Override // g.a.b0
    protected void d(i0<? super e<T>> i0Var) {
        this.f17224a.subscribe(new a(i0Var));
    }
}
