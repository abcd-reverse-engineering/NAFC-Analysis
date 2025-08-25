package g.a.d1;

import g.a.y0.j.q;

/* compiled from: SerializedProcessor.java */
/* loaded from: classes2.dex */
final class f<T> extends c<T> {

    /* renamed from: b, reason: collision with root package name */
    final c<T> f13713b;

    /* renamed from: c, reason: collision with root package name */
    boolean f13714c;

    /* renamed from: d, reason: collision with root package name */
    g.a.y0.j.a<Object> f13715d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f13716e;

    f(c<T> cVar) {
        this.f13713b = cVar;
    }

    @Override // g.a.d1.c
    public Throwable T() {
        return this.f13713b.T();
    }

    @Override // g.a.d1.c
    public boolean U() {
        return this.f13713b.U();
    }

    @Override // g.a.d1.c
    public boolean V() {
        return this.f13713b.V();
    }

    @Override // g.a.d1.c
    public boolean W() {
        return this.f13713b.W();
    }

    void Y() {
        g.a.y0.j.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f13715d;
                if (aVar == null) {
                    this.f13714c = false;
                    return;
                }
                this.f13715d = null;
            }
            aVar.a((i.d.c) this.f13713b);
        }
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f13713b.subscribe(cVar);
    }

    @Override // i.d.c
    public void onComplete() {
        if (this.f13716e) {
            return;
        }
        synchronized (this) {
            if (this.f13716e) {
                return;
            }
            this.f13716e = true;
            if (!this.f13714c) {
                this.f13714c = true;
                this.f13713b.onComplete();
                return;
            }
            g.a.y0.j.a<Object> aVar = this.f13715d;
            if (aVar == null) {
                aVar = new g.a.y0.j.a<>(4);
                this.f13715d = aVar;
            }
            aVar.a((g.a.y0.j.a<Object>) q.complete());
        }
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        boolean z;
        if (this.f13716e) {
            g.a.c1.a.b(th);
            return;
        }
        synchronized (this) {
            if (this.f13716e) {
                z = true;
            } else {
                this.f13716e = true;
                if (this.f13714c) {
                    g.a.y0.j.a<Object> aVar = this.f13715d;
                    if (aVar == null) {
                        aVar = new g.a.y0.j.a<>(4);
                        this.f13715d = aVar;
                    }
                    aVar.b(q.error(th));
                    return;
                }
                z = false;
                this.f13714c = true;
            }
            if (z) {
                g.a.c1.a.b(th);
            } else {
                this.f13713b.onError(th);
            }
        }
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (this.f13716e) {
            return;
        }
        synchronized (this) {
            if (this.f13716e) {
                return;
            }
            if (!this.f13714c) {
                this.f13714c = true;
                this.f13713b.onNext(t);
                Y();
            } else {
                g.a.y0.j.a<Object> aVar = this.f13715d;
                if (aVar == null) {
                    aVar = new g.a.y0.j.a<>(4);
                    this.f13715d = aVar;
                }
                aVar.a((g.a.y0.j.a<Object>) q.next(t));
            }
        }
    }

    @Override // i.d.c, g.a.q
    public void onSubscribe(i.d.d dVar) {
        boolean z = true;
        if (!this.f13716e) {
            synchronized (this) {
                if (!this.f13716e) {
                    if (this.f13714c) {
                        g.a.y0.j.a<Object> aVar = this.f13715d;
                        if (aVar == null) {
                            aVar = new g.a.y0.j.a<>(4);
                            this.f13715d = aVar;
                        }
                        aVar.a((g.a.y0.j.a<Object>) q.subscription(dVar));
                        return;
                    }
                    this.f13714c = true;
                    z = false;
                }
            }
        }
        if (z) {
            dVar.cancel();
        } else {
            this.f13713b.onSubscribe(dVar);
            Y();
        }
    }
}
