package g.a.y0.e.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableBufferBoundary.java */
/* loaded from: classes2.dex */
public final class n<T, U extends Collection<? super T>, Open, Close> extends g.a.y0.e.b.a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final Callable<U> f14408c;

    /* renamed from: d, reason: collision with root package name */
    final i.d.b<? extends Open> f14409d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.x0.o<? super Open, ? extends i.d.b<? extends Close>> f14410e;

    /* compiled from: FlowableBufferBoundary.java */
    static final class a<T, U extends Collection<? super T>, Open, Close> extends g.a.y0.h.m<T, U, U> implements i.d.d, g.a.u0.c {
        final i.d.b<? extends Open> m0;
        final g.a.x0.o<? super Open, ? extends i.d.b<? extends Close>> n0;
        final Callable<U> o0;
        final g.a.u0.b p0;
        i.d.d q0;
        final List<U> r0;
        final AtomicInteger s0;

        a(i.d.c<? super U> cVar, i.d.b<? extends Open> bVar, g.a.x0.o<? super Open, ? extends i.d.b<? extends Close>> oVar, Callable<U> callable) {
            super(cVar, new g.a.y0.f.a());
            this.s0 = new AtomicInteger();
            this.m0 = bVar;
            this.n0 = oVar;
            this.o0 = callable;
            this.r0 = new LinkedList();
            this.p0 = new g.a.u0.b();
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
            dispose();
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.p0.dispose();
        }

        void f() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.r0);
                this.r0.clear();
            }
            g.a.y0.c.n<U> nVar = this.i0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                nVar.offer((Collection) it.next());
            }
            this.k0 = true;
            if (b()) {
                g.a.y0.j.v.a((g.a.y0.c.n) nVar, (i.d.c) this.h0, false, (g.a.u0.c) this, (g.a.y0.j.u) this);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.p0.isDisposed();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.s0.decrementAndGet() == 0) {
                f();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            cancel();
            this.j0 = true;
            synchronized (this) {
                this.r0.clear();
            }
            this.h0.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.r0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.q0, dVar)) {
                this.q0 = dVar;
                c cVar = new c(this);
                this.p0.b(cVar);
                this.h0.onSubscribe(this);
                this.s0.lazySet(1);
                this.m0.subscribe(cVar);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            b(j2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(i.d.c<? super U> cVar, U u) {
            cVar.onNext(u);
            return true;
        }

        void a(Open open) {
            if (this.j0) {
                return;
            }
            try {
                Collection collection = (Collection) g.a.y0.b.b.a(this.o0.call(), "The buffer supplied is null");
                try {
                    i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.n0.apply(open), "The buffer closing publisher is null");
                    if (this.j0) {
                        return;
                    }
                    synchronized (this) {
                        if (this.j0) {
                            return;
                        }
                        this.r0.add(collection);
                        b bVar2 = new b(collection, this);
                        this.p0.b(bVar2);
                        this.s0.getAndIncrement();
                        bVar.subscribe(bVar2);
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                onError(th2);
            }
        }

        void a(g.a.u0.c cVar) {
            if (this.p0.a(cVar) && this.s0.decrementAndGet() == 0) {
                f();
            }
        }

        void a(U u, g.a.u0.c cVar) {
            boolean zRemove;
            synchronized (this) {
                zRemove = this.r0.remove(u);
            }
            if (zRemove) {
                b(u, false, this);
            }
            if (this.p0.a(cVar) && this.s0.decrementAndGet() == 0) {
                f();
            }
        }
    }

    /* compiled from: FlowableBufferBoundary.java */
    static final class b<T, U extends Collection<? super T>, Open, Close> extends g.a.g1.b<Close> {

        /* renamed from: b, reason: collision with root package name */
        final a<T, U, Open, Close> f14411b;

        /* renamed from: c, reason: collision with root package name */
        final U f14412c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14413d;

        b(U u, a<T, U, Open, Close> aVar) {
            this.f14411b = aVar;
            this.f14412c = u;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14413d) {
                return;
            }
            this.f14413d = true;
            this.f14411b.a((a<T, U, Open, Close>) this.f14412c, (g.a.u0.c) this);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14413d) {
                g.a.c1.a.b(th);
            } else {
                this.f14411b.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(Close close) {
            onComplete();
        }
    }

    /* compiled from: FlowableBufferBoundary.java */
    static final class c<T, U extends Collection<? super T>, Open, Close> extends g.a.g1.b<Open> {

        /* renamed from: b, reason: collision with root package name */
        final a<T, U, Open, Close> f14414b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14415c;

        c(a<T, U, Open, Close> aVar) {
            this.f14414b = aVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14415c) {
                return;
            }
            this.f14415c = true;
            this.f14414b.a((g.a.u0.c) this);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14415c) {
                g.a.c1.a.b(th);
            } else {
                this.f14415c = true;
                this.f14414b.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(Open open) {
            if (this.f14415c) {
                return;
            }
            this.f14414b.a((a<T, U, Open, Close>) open);
        }
    }

    public n(g.a.l<T> lVar, i.d.b<? extends Open> bVar, g.a.x0.o<? super Open, ? extends i.d.b<? extends Close>> oVar, Callable<U> callable) {
        super(lVar);
        this.f14409d = bVar;
        this.f14410e = oVar;
        this.f14408c = callable;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super U> cVar) {
        this.f14110b.a((g.a.q) new a(new g.a.g1.e(cVar), this.f14409d, this.f14410e, this.f14408c));
    }
}
