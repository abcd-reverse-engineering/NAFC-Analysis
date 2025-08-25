package g.a.f1;

import g.a.i0;
import g.a.y0.j.a;
import g.a.y0.j.q;

/* compiled from: SerializedSubject.java */
/* loaded from: classes2.dex */
final class g<T> extends i<T> implements a.InterfaceC0232a<Object> {

    /* renamed from: a, reason: collision with root package name */
    final i<T> f13795a;

    /* renamed from: b, reason: collision with root package name */
    boolean f13796b;

    /* renamed from: c, reason: collision with root package name */
    g.a.y0.j.a<Object> f13797c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f13798d;

    g(i<T> iVar) {
        this.f13795a = iVar;
    }

    @Override // g.a.f1.i
    public Throwable O() {
        return this.f13795a.O();
    }

    @Override // g.a.f1.i
    public boolean P() {
        return this.f13795a.P();
    }

    @Override // g.a.f1.i
    public boolean Q() {
        return this.f13795a.Q();
    }

    @Override // g.a.f1.i
    public boolean R() {
        return this.f13795a.R();
    }

    void T() {
        g.a.y0.j.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f13797c;
                if (aVar == null) {
                    this.f13796b = false;
                    return;
                }
                this.f13797c = null;
            }
            aVar.a((a.InterfaceC0232a<? super Object>) this);
        }
    }

    @Override // g.a.b0
    protected void d(i0<? super T> i0Var) {
        this.f13795a.subscribe(i0Var);
    }

    @Override // g.a.i0
    public void onComplete() {
        if (this.f13798d) {
            return;
        }
        synchronized (this) {
            if (this.f13798d) {
                return;
            }
            this.f13798d = true;
            if (!this.f13796b) {
                this.f13796b = true;
                this.f13795a.onComplete();
                return;
            }
            g.a.y0.j.a<Object> aVar = this.f13797c;
            if (aVar == null) {
                aVar = new g.a.y0.j.a<>(4);
                this.f13797c = aVar;
            }
            aVar.a((g.a.y0.j.a<Object>) q.complete());
        }
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        boolean z;
        if (this.f13798d) {
            g.a.c1.a.b(th);
            return;
        }
        synchronized (this) {
            if (this.f13798d) {
                z = true;
            } else {
                this.f13798d = true;
                if (this.f13796b) {
                    g.a.y0.j.a<Object> aVar = this.f13797c;
                    if (aVar == null) {
                        aVar = new g.a.y0.j.a<>(4);
                        this.f13797c = aVar;
                    }
                    aVar.b(q.error(th));
                    return;
                }
                z = false;
                this.f13796b = true;
            }
            if (z) {
                g.a.c1.a.b(th);
            } else {
                this.f13795a.onError(th);
            }
        }
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (this.f13798d) {
            return;
        }
        synchronized (this) {
            if (this.f13798d) {
                return;
            }
            if (!this.f13796b) {
                this.f13796b = true;
                this.f13795a.onNext(t);
                T();
            } else {
                g.a.y0.j.a<Object> aVar = this.f13797c;
                if (aVar == null) {
                    aVar = new g.a.y0.j.a<>(4);
                    this.f13797c = aVar;
                }
                aVar.a((g.a.y0.j.a<Object>) q.next(t));
            }
        }
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        boolean z = true;
        if (!this.f13798d) {
            synchronized (this) {
                if (!this.f13798d) {
                    if (this.f13796b) {
                        g.a.y0.j.a<Object> aVar = this.f13797c;
                        if (aVar == null) {
                            aVar = new g.a.y0.j.a<>(4);
                            this.f13797c = aVar;
                        }
                        aVar.a((g.a.y0.j.a<Object>) q.disposable(cVar));
                        return;
                    }
                    this.f13796b = true;
                    z = false;
                }
            }
        }
        if (z) {
            cVar.dispose();
        } else {
            this.f13795a.onSubscribe(cVar);
            T();
        }
    }

    @Override // g.a.y0.j.a.InterfaceC0232a, g.a.x0.r
    public boolean test(Object obj) {
        return q.acceptFull(obj, this.f13795a);
    }
}
