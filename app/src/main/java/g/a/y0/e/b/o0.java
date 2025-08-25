package g.a.y0.e.b;

/* compiled from: FlowableDoOnEach.java */
/* loaded from: classes2.dex */
public final class o0<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super T> f14436c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.g<? super Throwable> f14437d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.x0.a f14438e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.x0.a f14439f;

    /* compiled from: FlowableDoOnEach.java */
    static final class a<T> extends g.a.y0.h.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.g<? super T> f14440f;

        /* renamed from: g, reason: collision with root package name */
        final g.a.x0.g<? super Throwable> f14441g;

        /* renamed from: h, reason: collision with root package name */
        final g.a.x0.a f14442h;

        /* renamed from: i, reason: collision with root package name */
        final g.a.x0.a f14443i;

        a(g.a.y0.c.a<? super T> aVar, g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar2, g.a.x0.a aVar3) {
            super(aVar);
            this.f14440f = gVar;
            this.f14441g = gVar2;
            this.f14442h = aVar2;
            this.f14443i = aVar3;
        }

        @Override // g.a.y0.h.a, i.d.c
        public void onComplete() {
            if (this.f16008d) {
                return;
            }
            try {
                this.f14442h.run();
                this.f16008d = true;
                this.f16005a.onComplete();
                try {
                    this.f14443i.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }

        @Override // g.a.y0.h.a, i.d.c
        public void onError(Throwable th) {
            if (this.f16008d) {
                g.a.c1.a.b(th);
                return;
            }
            boolean z = true;
            this.f16008d = true;
            try {
                this.f14441g.accept(th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f16005a.onError(new g.a.v0.a(th, th2));
                z = false;
            }
            if (z) {
                this.f16005a.onError(th);
            }
            try {
                this.f14443i.run();
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                g.a.c1.a.b(th3);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f16008d) {
                return;
            }
            if (this.f16009e != 0) {
                this.f16005a.onNext(null);
                return;
            }
            try {
                this.f14440f.accept(t);
                this.f16005a.onNext(t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            try {
                T tPoll = this.f16007c.poll();
                if (tPoll != null) {
                    try {
                        this.f14440f.accept(tPoll);
                    } catch (Throwable th) {
                        try {
                            g.a.v0.b.b(th);
                            try {
                                this.f14441g.accept(th);
                                throw g.a.y0.j.k.b(th);
                            } catch (Throwable th2) {
                                throw new g.a.v0.a(th, th2);
                            }
                        } finally {
                            this.f14443i.run();
                        }
                    }
                } else if (this.f16009e == 1) {
                    this.f14442h.run();
                }
                return tPoll;
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                try {
                    this.f14441g.accept(th3);
                    throw g.a.y0.j.k.b(th3);
                } catch (Throwable th4) {
                    throw new g.a.v0.a(th3, th4);
                }
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (this.f16008d) {
                return false;
            }
            try {
                this.f14440f.accept(t);
                return this.f16005a.tryOnNext(t);
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }
    }

    /* compiled from: FlowableDoOnEach.java */
    static final class b<T> extends g.a.y0.h.b<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final g.a.x0.g<? super T> f14444f;

        /* renamed from: g, reason: collision with root package name */
        final g.a.x0.g<? super Throwable> f14445g;

        /* renamed from: h, reason: collision with root package name */
        final g.a.x0.a f14446h;

        /* renamed from: i, reason: collision with root package name */
        final g.a.x0.a f14447i;

        b(i.d.c<? super T> cVar, g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.a aVar2) {
            super(cVar);
            this.f14444f = gVar;
            this.f14445g = gVar2;
            this.f14446h = aVar;
            this.f14447i = aVar2;
        }

        @Override // g.a.y0.h.b, i.d.c
        public void onComplete() {
            if (this.f16013d) {
                return;
            }
            try {
                this.f14446h.run();
                this.f16013d = true;
                this.f16010a.onComplete();
                try {
                    this.f14447i.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }

        @Override // g.a.y0.h.b, i.d.c
        public void onError(Throwable th) {
            if (this.f16013d) {
                g.a.c1.a.b(th);
                return;
            }
            boolean z = true;
            this.f16013d = true;
            try {
                this.f14445g.accept(th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f16010a.onError(new g.a.v0.a(th, th2));
                z = false;
            }
            if (z) {
                this.f16010a.onError(th);
            }
            try {
                this.f14447i.run();
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                g.a.c1.a.b(th3);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f16013d) {
                return;
            }
            if (this.f16014e != 0) {
                this.f16010a.onNext(null);
                return;
            }
            try {
                this.f14444f.accept(t);
                this.f16010a.onNext(t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            try {
                T tPoll = this.f16012c.poll();
                if (tPoll != null) {
                    try {
                        this.f14444f.accept(tPoll);
                    } catch (Throwable th) {
                        try {
                            g.a.v0.b.b(th);
                            try {
                                this.f14445g.accept(th);
                                throw g.a.y0.j.k.b(th);
                            } catch (Throwable th2) {
                                throw new g.a.v0.a(th, th2);
                            }
                        } finally {
                            this.f14447i.run();
                        }
                    }
                } else if (this.f16014e == 1) {
                    this.f14446h.run();
                }
                return tPoll;
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                try {
                    this.f14445g.accept(th3);
                    throw g.a.y0.j.k.b(th3);
                } catch (Throwable th4) {
                    throw new g.a.v0.a(th3, th4);
                }
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public o0(g.a.l<T> lVar, g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.a aVar2) {
        super(lVar);
        this.f14436c = gVar;
        this.f14437d = gVar2;
        this.f14438e = aVar;
        this.f14439f = aVar2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        if (cVar instanceof g.a.y0.c.a) {
            this.f14110b.a((g.a.q) new a((g.a.y0.c.a) cVar, this.f14436c, this.f14437d, this.f14438e, this.f14439f));
        } else {
            this.f14110b.a((g.a.q) new b(cVar, this.f14436c, this.f14437d, this.f14438e, this.f14439f));
        }
    }
}
