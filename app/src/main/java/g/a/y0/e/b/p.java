package g.a.y0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: FlowableBufferExactBoundary.java */
/* loaded from: classes2.dex */
public final class p<T, U extends Collection<? super T>, B> extends g.a.y0.e.b.a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<B> f14462c;

    /* renamed from: d, reason: collision with root package name */
    final Callable<U> f14463d;

    /* compiled from: FlowableBufferExactBoundary.java */
    static final class a<T, U extends Collection<? super T>, B> extends g.a.g1.b<B> {

        /* renamed from: b, reason: collision with root package name */
        final b<T, U, B> f14464b;

        a(b<T, U, B> bVar) {
            this.f14464b = bVar;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14464b.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14464b.onError(th);
        }

        @Override // i.d.c
        public void onNext(B b2) {
            this.f14464b.f();
        }
    }

    /* compiled from: FlowableBufferExactBoundary.java */
    static final class b<T, U extends Collection<? super T>, B> extends g.a.y0.h.m<T, U, U> implements g.a.q<T>, i.d.d, g.a.u0.c {
        final Callable<U> m0;
        final i.d.b<B> n0;
        i.d.d o0;
        g.a.u0.c p0;
        U q0;

        b(i.d.c<? super U> cVar, Callable<U> callable, i.d.b<B> bVar) {
            super(cVar, new g.a.y0.f.a());
            this.m0 = callable;
            this.n0 = bVar;
        }

        @Override // g.a.y0.h.m, g.a.y0.j.u
        public /* bridge */ /* synthetic */ boolean a(i.d.c cVar, Object obj) {
            return a((i.d.c<? super i.d.c>) cVar, (i.d.c) obj);
        }

        @Override // i.d.d
        public void cancel() {
            if (this.j0) {
                return;
            }
            this.j0 = true;
            this.p0.dispose();
            this.o0.cancel();
            if (b()) {
                this.i0.clear();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            cancel();
        }

        void f() {
            try {
                U u = (U) g.a.y0.b.b.a(this.m0.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.q0;
                    if (u2 == null) {
                        return;
                    }
                    this.q0 = u;
                    a(u2, false, this);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                this.h0.onError(th);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.j0;
        }

        @Override // i.d.c
        public void onComplete() {
            synchronized (this) {
                U u = this.q0;
                if (u == null) {
                    return;
                }
                this.q0 = null;
                this.i0.offer(u);
                this.k0 = true;
                if (b()) {
                    g.a.y0.j.v.a((g.a.y0.c.n) this.i0, (i.d.c) this.h0, false, (g.a.u0.c) this, (g.a.y0.j.u) this);
                }
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            cancel();
            this.h0.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.q0;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.o0, dVar)) {
                this.o0 = dVar;
                try {
                    this.q0 = (U) g.a.y0.b.b.a(this.m0.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.p0 = aVar;
                    this.h0.onSubscribe(this);
                    if (this.j0) {
                        return;
                    }
                    dVar.request(h.q2.t.m0.f16408b);
                    this.n0.subscribe(aVar);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.j0 = true;
                    dVar.cancel();
                    g.a.y0.i.g.error(th, this.h0);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }

        public boolean a(i.d.c<? super U> cVar, U u) {
            this.h0.onNext(u);
            return true;
        }
    }

    public p(g.a.l<T> lVar, i.d.b<B> bVar, Callable<U> callable) {
        super(lVar);
        this.f14462c = bVar;
        this.f14463d = callable;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super U> cVar) {
        this.f14110b.a((g.a.q) new b(new g.a.g1.e(cVar), this.f14463d, this.f14462c));
    }
}
