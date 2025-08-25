package l.q.a;

import g.a.b0;
import g.a.i0;
import l.m;

/* compiled from: CallEnqueueObservable.java */
/* loaded from: classes2.dex */
final class b<T> extends b0<m<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final l.b<T> f17214a;

    /* compiled from: CallEnqueueObservable.java */
    private static final class a<T> implements g.a.u0.c, l.d<T> {

        /* renamed from: a, reason: collision with root package name */
        private final l.b<?> f17215a;

        /* renamed from: b, reason: collision with root package name */
        private final i0<? super m<T>> f17216b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f17217c;

        /* renamed from: d, reason: collision with root package name */
        boolean f17218d = false;

        a(l.b<?> bVar, i0<? super m<T>> i0Var) {
            this.f17215a = bVar;
            this.f17216b = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f17217c = true;
            this.f17215a.cancel();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f17217c;
        }

        @Override // l.d
        public void onFailure(l.b<T> bVar, Throwable th) {
            if (bVar.isCanceled()) {
                return;
            }
            try {
                this.f17216b.onError(th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                g.a.c1.a.b(new g.a.v0.a(th, th2));
            }
        }

        @Override // l.d
        public void onResponse(l.b<T> bVar, m<T> mVar) {
            if (this.f17217c) {
                return;
            }
            try {
                this.f17216b.onNext(mVar);
                if (this.f17217c) {
                    return;
                }
                this.f17218d = true;
                this.f17216b.onComplete();
            } catch (Throwable th) {
                if (this.f17218d) {
                    g.a.c1.a.b(th);
                    return;
                }
                if (this.f17217c) {
                    return;
                }
                try {
                    this.f17216b.onError(th);
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    g.a.c1.a.b(new g.a.v0.a(th, th2));
                }
            }
        }
    }

    b(l.b<T> bVar) {
        this.f17214a = bVar;
    }

    @Override // g.a.b0
    protected void d(i0<? super m<T>> i0Var) {
        l.b<T> bVarClone = this.f17214a.clone();
        a aVar = new a(bVarClone, i0Var);
        i0Var.onSubscribe(aVar);
        bVarClone.a(aVar);
    }
}
