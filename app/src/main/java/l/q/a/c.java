package l.q.a;

import g.a.b0;
import g.a.i0;
import l.m;

/* compiled from: CallExecuteObservable.java */
/* loaded from: classes2.dex */
final class c<T> extends b0<m<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final l.b<T> f17219a;

    /* compiled from: CallExecuteObservable.java */
    private static final class a implements g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        private final l.b<?> f17220a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f17221b;

        a(l.b<?> bVar) {
            this.f17220a = bVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f17221b = true;
            this.f17220a.cancel();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f17221b;
        }
    }

    c(l.b<T> bVar) {
        this.f17219a = bVar;
    }

    @Override // g.a.b0
    protected void d(i0<? super m<T>> i0Var) {
        boolean z;
        l.b<T> bVarClone = this.f17219a.clone();
        a aVar = new a(bVarClone);
        i0Var.onSubscribe(aVar);
        try {
            m<T> mVarExecute = bVarClone.execute();
            if (!aVar.isDisposed()) {
                i0Var.onNext(mVarExecute);
            }
            if (aVar.isDisposed()) {
                return;
            }
            try {
                i0Var.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                g.a.v0.b.b(th);
                if (z) {
                    g.a.c1.a.b(th);
                    return;
                }
                if (aVar.isDisposed()) {
                    return;
                }
                try {
                    i0Var.onError(th);
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    g.a.c1.a.b(new g.a.v0.a(th, th2));
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
