package g.a.a1;

import g.a.i0;
import g.a.y0.j.q;

/* compiled from: SerializedObserver.java */
/* loaded from: classes2.dex */
public final class m<T> implements i0<T>, g.a.u0.c {

    /* renamed from: g, reason: collision with root package name */
    static final int f13642g = 4;

    /* renamed from: a, reason: collision with root package name */
    final i0<? super T> f13643a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f13644b;

    /* renamed from: c, reason: collision with root package name */
    g.a.u0.c f13645c;

    /* renamed from: d, reason: collision with root package name */
    boolean f13646d;

    /* renamed from: e, reason: collision with root package name */
    g.a.y0.j.a<Object> f13647e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f13648f;

    public m(@g.a.t0.f i0<? super T> i0Var) {
        this(i0Var, false);
    }

    void a() {
        g.a.y0.j.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f13647e;
                if (aVar == null) {
                    this.f13646d = false;
                    return;
                }
                this.f13647e = null;
            }
        } while (!aVar.a((i0) this.f13643a));
    }

    @Override // g.a.u0.c
    public void dispose() {
        this.f13645c.dispose();
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.f13645c.isDisposed();
    }

    @Override // g.a.i0
    public void onComplete() {
        if (this.f13648f) {
            return;
        }
        synchronized (this) {
            if (this.f13648f) {
                return;
            }
            if (!this.f13646d) {
                this.f13648f = true;
                this.f13646d = true;
                this.f13643a.onComplete();
            } else {
                g.a.y0.j.a<Object> aVar = this.f13647e;
                if (aVar == null) {
                    aVar = new g.a.y0.j.a<>(4);
                    this.f13647e = aVar;
                }
                aVar.a((g.a.y0.j.a<Object>) q.complete());
            }
        }
    }

    @Override // g.a.i0
    public void onError(@g.a.t0.f Throwable th) {
        if (this.f13648f) {
            g.a.c1.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f13648f) {
                if (this.f13646d) {
                    this.f13648f = true;
                    g.a.y0.j.a<Object> aVar = this.f13647e;
                    if (aVar == null) {
                        aVar = new g.a.y0.j.a<>(4);
                        this.f13647e = aVar;
                    }
                    Object objError = q.error(th);
                    if (this.f13644b) {
                        aVar.a((g.a.y0.j.a<Object>) objError);
                    } else {
                        aVar.b(objError);
                    }
                    return;
                }
                this.f13648f = true;
                this.f13646d = true;
                z = false;
            }
            if (z) {
                g.a.c1.a.b(th);
            } else {
                this.f13643a.onError(th);
            }
        }
    }

    @Override // g.a.i0
    public void onNext(@g.a.t0.f T t) {
        if (this.f13648f) {
            return;
        }
        if (t == null) {
            this.f13645c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f13648f) {
                return;
            }
            if (!this.f13646d) {
                this.f13646d = true;
                this.f13643a.onNext(t);
                a();
            } else {
                g.a.y0.j.a<Object> aVar = this.f13647e;
                if (aVar == null) {
                    aVar = new g.a.y0.j.a<>(4);
                    this.f13647e = aVar;
                }
                aVar.a((g.a.y0.j.a<Object>) q.next(t));
            }
        }
    }

    @Override // g.a.i0
    public void onSubscribe(@g.a.t0.f g.a.u0.c cVar) {
        if (g.a.y0.a.d.validate(this.f13645c, cVar)) {
            this.f13645c = cVar;
            this.f13643a.onSubscribe(this);
        }
    }

    public m(@g.a.t0.f i0<? super T> i0Var, boolean z) {
        this.f13643a = i0Var;
        this.f13644b = z;
    }
}
