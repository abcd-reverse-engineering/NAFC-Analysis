package g.a.y0.h;

import h.q2.t.m0;

/* compiled from: DeferredScalarSubscriber.java */
/* loaded from: classes2.dex */
public abstract class g<T, R> extends g.a.y0.i.f<R> implements g.a.q<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected i.d.d s;

    public g(i.d.c<? super R> cVar) {
        super(cVar);
    }

    @Override // g.a.y0.i.f, i.d.d
    public void cancel() {
        super.cancel();
        this.s.cancel();
    }

    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.actual.onComplete();
        }
    }

    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    public void onSubscribe(i.d.d dVar) {
        if (g.a.y0.i.j.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(m0.f16408b);
        }
    }
}
