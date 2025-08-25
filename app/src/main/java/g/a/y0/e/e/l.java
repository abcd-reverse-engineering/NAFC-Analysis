package g.a.y0.e.e;

import g.a.x0.q;

/* compiled from: ParallelPeek.java */
/* loaded from: classes2.dex */
public final class l<T> extends g.a.b1.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<T> f15701a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super T> f15702b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super T> f15703c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.g<? super Throwable> f15704d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.x0.a f15705e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.x0.a f15706f;

    /* renamed from: g, reason: collision with root package name */
    final g.a.x0.g<? super i.d.d> f15707g;

    /* renamed from: h, reason: collision with root package name */
    final q f15708h;

    /* renamed from: i, reason: collision with root package name */
    final g.a.x0.a f15709i;

    /* compiled from: ParallelPeek.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f15710a;

        /* renamed from: b, reason: collision with root package name */
        final l<T> f15711b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f15712c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15713d;

        a(i.d.c<? super T> cVar, l<T> lVar) {
            this.f15710a = cVar;
            this.f15711b = lVar;
        }

        @Override // i.d.d
        public void cancel() {
            try {
                this.f15711b.f15709i.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
            this.f15712c.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15713d) {
                return;
            }
            this.f15713d = true;
            try {
                this.f15711b.f15705e.run();
                this.f15710a.onComplete();
                try {
                    this.f15711b.f15706f.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f15710a.onError(th2);
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15713d) {
                g.a.c1.a.b(th);
                return;
            }
            this.f15713d = true;
            try {
                this.f15711b.f15704d.accept(th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                th = new g.a.v0.a(th, th2);
            }
            this.f15710a.onError(th);
            try {
                this.f15711b.f15706f.run();
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                g.a.c1.a.b(th3);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f15713d) {
                return;
            }
            try {
                this.f15711b.f15702b.accept(t);
                this.f15710a.onNext(t);
                try {
                    this.f15711b.f15703c.accept(t);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                onError(th2);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15712c, dVar)) {
                this.f15712c = dVar;
                try {
                    this.f15711b.f15707g.accept(dVar);
                    this.f15710a.onSubscribe(this);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    dVar.cancel();
                    this.f15710a.onSubscribe(g.a.y0.i.g.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            try {
                this.f15711b.f15708h.a(j2);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
            this.f15712c.request(j2);
        }
    }

    public l(g.a.b1.b<T> bVar, g.a.x0.g<? super T> gVar, g.a.x0.g<? super T> gVar2, g.a.x0.g<? super Throwable> gVar3, g.a.x0.a aVar, g.a.x0.a aVar2, g.a.x0.g<? super i.d.d> gVar4, q qVar, g.a.x0.a aVar3) {
        this.f15701a = bVar;
        this.f15702b = (g.a.x0.g) g.a.y0.b.b.a(gVar, "onNext is null");
        this.f15703c = (g.a.x0.g) g.a.y0.b.b.a(gVar2, "onAfterNext is null");
        this.f15704d = (g.a.x0.g) g.a.y0.b.b.a(gVar3, "onError is null");
        this.f15705e = (g.a.x0.a) g.a.y0.b.b.a(aVar, "onComplete is null");
        this.f15706f = (g.a.x0.a) g.a.y0.b.b.a(aVar2, "onAfterTerminated is null");
        this.f15707g = (g.a.x0.g) g.a.y0.b.b.a(gVar4, "onSubscribe is null");
        this.f15708h = (q) g.a.y0.b.b.a(qVar, "onRequest is null");
        this.f15709i = (g.a.x0.a) g.a.y0.b.b.a(aVar3, "onCancel is null");
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super T>[] cVarArr2 = new i.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                cVarArr2[i2] = new a(cVarArr[i2], this);
            }
            this.f15701a.a(cVarArr2);
        }
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15701a.a();
    }
}
