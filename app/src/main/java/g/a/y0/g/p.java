package g.a.y0.g;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SchedulerWhen.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public class p extends j0 implements g.a.u0.c {

    /* renamed from: e, reason: collision with root package name */
    static final g.a.u0.c f15969e = new g();

    /* renamed from: f, reason: collision with root package name */
    static final g.a.u0.c f15970f = g.a.u0.d.a();

    /* renamed from: b, reason: collision with root package name */
    private final j0 f15971b;

    /* renamed from: c, reason: collision with root package name */
    private final g.a.d1.c<g.a.l<g.a.c>> f15972c = g.a.d1.g.a0().X();

    /* renamed from: d, reason: collision with root package name */
    private g.a.u0.c f15973d;

    /* compiled from: SchedulerWhen.java */
    static final class a implements g.a.x0.o<f, g.a.c> {

        /* renamed from: a, reason: collision with root package name */
        final j0.c f15974a;

        /* compiled from: SchedulerWhen.java */
        /* renamed from: g.a.y0.g.p$a$a, reason: collision with other inner class name */
        final class C0231a extends g.a.c {

            /* renamed from: a, reason: collision with root package name */
            final f f15975a;

            C0231a(f fVar) {
                this.f15975a = fVar;
            }

            @Override // g.a.c
            protected void b(g.a.f fVar) {
                fVar.onSubscribe(this.f15975a);
                this.f15975a.call(a.this.f15974a, fVar);
            }
        }

        a(j0.c cVar) {
            this.f15974a = cVar;
        }

        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g.a.c apply(f fVar) {
            return new C0231a(fVar);
        }
    }

    /* compiled from: SchedulerWhen.java */
    static class b extends f {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        b(Runnable runnable, long j2, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j2;
            this.unit = timeUnit;
        }

        @Override // g.a.y0.g.p.f
        protected g.a.u0.c callActual(j0.c cVar, g.a.f fVar) {
            return cVar.a(new d(this.action, fVar), this.delayTime, this.unit);
        }
    }

    /* compiled from: SchedulerWhen.java */
    static class c extends f {
        private final Runnable action;

        c(Runnable runnable) {
            this.action = runnable;
        }

        @Override // g.a.y0.g.p.f
        protected g.a.u0.c callActual(j0.c cVar, g.a.f fVar) {
            return cVar.a(new d(this.action, fVar));
        }
    }

    /* compiled from: SchedulerWhen.java */
    static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f15977a;

        /* renamed from: b, reason: collision with root package name */
        final Runnable f15978b;

        d(Runnable runnable, g.a.f fVar) {
            this.f15978b = runnable;
            this.f15977a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f15978b.run();
            } finally {
                this.f15977a.onComplete();
            }
        }
    }

    /* compiled from: SchedulerWhen.java */
    static abstract class f extends AtomicReference<g.a.u0.c> implements g.a.u0.c {
        f() {
            super(p.f15969e);
        }

        void call(j0.c cVar, g.a.f fVar) {
            g.a.u0.c cVar2 = get();
            if (cVar2 != p.f15970f && cVar2 == p.f15969e) {
                g.a.u0.c cVarCallActual = callActual(cVar, fVar);
                if (compareAndSet(p.f15969e, cVarCallActual)) {
                    return;
                }
                cVarCallActual.dispose();
            }
        }

        protected abstract g.a.u0.c callActual(j0.c cVar, g.a.f fVar);

        @Override // g.a.u0.c
        public void dispose() {
            g.a.u0.c cVar;
            g.a.u0.c cVar2 = p.f15970f;
            do {
                cVar = get();
                if (cVar == p.f15970f) {
                    return;
                }
            } while (!compareAndSet(cVar, cVar2));
            if (cVar != p.f15969e) {
                cVar.dispose();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get().isDisposed();
        }
    }

    /* compiled from: SchedulerWhen.java */
    static final class g implements g.a.u0.c {
        g() {
        }

        @Override // g.a.u0.c
        public void dispose() {
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return false;
        }
    }

    public p(g.a.x0.o<g.a.l<g.a.l<g.a.c>>, g.a.c> oVar, j0 j0Var) {
        this.f15971b = j0Var;
        try {
            this.f15973d = oVar.apply(this.f15972c).l();
        } catch (Throwable th) {
            g.a.v0.b.a(th);
        }
    }

    @Override // g.a.j0
    @g.a.t0.f
    public j0.c a() {
        j0.c cVarA = this.f15971b.a();
        g.a.d1.c<T> cVarX = g.a.d1.g.a0().X();
        g.a.l<g.a.c> lVarO = cVarX.o(new a(cVarA));
        e eVar = new e(cVarX, cVarA);
        this.f15972c.onNext(lVarO);
        return eVar;
    }

    @Override // g.a.u0.c
    public void dispose() {
        this.f15973d.dispose();
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.f15973d.isDisposed();
    }

    /* compiled from: SchedulerWhen.java */
    static final class e extends j0.c {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f15979a = new AtomicBoolean();

        /* renamed from: b, reason: collision with root package name */
        private final g.a.d1.c<f> f15980b;

        /* renamed from: c, reason: collision with root package name */
        private final j0.c f15981c;

        e(g.a.d1.c<f> cVar, j0.c cVar2) {
            this.f15980b = cVar;
            this.f15981c = cVar2;
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit) {
            b bVar = new b(runnable, j2, timeUnit);
            this.f15980b.onNext(bVar);
            return bVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.f15979a.compareAndSet(false, true)) {
                this.f15980b.onComplete();
                this.f15981c.dispose();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15979a.get();
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
            c cVar = new c(runnable);
            this.f15980b.onNext(cVar);
            return cVar;
        }
    }
}
