package g.a.y0.d;

import g.a.i0;

/* compiled from: DeferredScalarObserver.java */
/* loaded from: classes2.dex */
public abstract class m<T, R> extends l<R> implements i0<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected g.a.u0.c s;

    public m(i0<? super R> i0Var) {
        super(i0Var);
    }

    @Override // g.a.y0.d.l, g.a.u0.c
    public void dispose() {
        super.dispose();
        this.s.dispose();
    }

    @Override // g.a.i0
    public void onComplete() {
        T t = this.value;
        if (t == null) {
            complete();
        } else {
            this.value = null;
            complete(t);
        }
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        if (g.a.y0.a.d.validate(this.s, cVar)) {
            this.s = cVar;
            this.actual.onSubscribe(this);
        }
    }
}
