package g.a.g1;

import g.a.q;
import g.a.y0.i.j;

/* compiled from: SerializedSubscriber.java */
/* loaded from: classes2.dex */
public final class e<T> implements q<T>, i.d.d {

    /* renamed from: g, reason: collision with root package name */
    static final int f13823g = 4;

    /* renamed from: a, reason: collision with root package name */
    final i.d.c<? super T> f13824a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f13825b;

    /* renamed from: c, reason: collision with root package name */
    i.d.d f13826c;

    /* renamed from: d, reason: collision with root package name */
    boolean f13827d;

    /* renamed from: e, reason: collision with root package name */
    g.a.y0.j.a<Object> f13828e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f13829f;

    public e(i.d.c<? super T> cVar) {
        this(cVar, false);
    }

    void a() {
        g.a.y0.j.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f13828e;
                if (aVar == null) {
                    this.f13827d = false;
                    return;
                }
                this.f13828e = null;
            }
        } while (!aVar.a((i.d.c) this.f13824a));
    }

    @Override // i.d.d
    public void cancel() {
        this.f13826c.cancel();
    }

    @Override // i.d.c
    public void onComplete() {
        if (this.f13829f) {
            return;
        }
        synchronized (this) {
            if (this.f13829f) {
                return;
            }
            if (!this.f13827d) {
                this.f13829f = true;
                this.f13827d = true;
                this.f13824a.onComplete();
            } else {
                g.a.y0.j.a<Object> aVar = this.f13828e;
                if (aVar == null) {
                    aVar = new g.a.y0.j.a<>(4);
                    this.f13828e = aVar;
                }
                aVar.a((g.a.y0.j.a<Object>) g.a.y0.j.q.complete());
            }
        }
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        if (this.f13829f) {
            g.a.c1.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f13829f) {
                if (this.f13827d) {
                    this.f13829f = true;
                    g.a.y0.j.a<Object> aVar = this.f13828e;
                    if (aVar == null) {
                        aVar = new g.a.y0.j.a<>(4);
                        this.f13828e = aVar;
                    }
                    Object objError = g.a.y0.j.q.error(th);
                    if (this.f13825b) {
                        aVar.a((g.a.y0.j.a<Object>) objError);
                    } else {
                        aVar.b(objError);
                    }
                    return;
                }
                this.f13829f = true;
                this.f13827d = true;
                z = false;
            }
            if (z) {
                g.a.c1.a.b(th);
            } else {
                this.f13824a.onError(th);
            }
        }
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (this.f13829f) {
            return;
        }
        if (t == null) {
            this.f13826c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f13829f) {
                return;
            }
            if (!this.f13827d) {
                this.f13827d = true;
                this.f13824a.onNext(t);
                a();
            } else {
                g.a.y0.j.a<Object> aVar = this.f13828e;
                if (aVar == null) {
                    aVar = new g.a.y0.j.a<>(4);
                    this.f13828e = aVar;
                }
                aVar.a((g.a.y0.j.a<Object>) g.a.y0.j.q.next(t));
            }
        }
    }

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (j.validate(this.f13826c, dVar)) {
            this.f13826c = dVar;
            this.f13824a.onSubscribe(this);
        }
    }

    @Override // i.d.d
    public void request(long j2) {
        this.f13826c.request(j2);
    }

    public e(i.d.c<? super T> cVar, boolean z) {
        this.f13824a = cVar;
        this.f13825b = z;
    }
}
