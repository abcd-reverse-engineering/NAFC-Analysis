package g.a;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Completable.java */
/* loaded from: classes2.dex */
public abstract class c implements i {
    @g.a.t0.d
    @g.a.t0.h("none")
    public static c a(i... iVarArr) {
        g.a.y0.b.b.a(iVarArr, "sources is null");
        return iVarArr.length == 0 ? q() : iVarArr.length == 1 ? g(iVarArr[0]) : g.a.c1.a.a(new g.a.y0.e.a.a(iVarArr, null));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c b(i... iVarArr) {
        g.a.y0.b.b.a(iVarArr, "sources is null");
        return iVarArr.length == 0 ? q() : iVarArr.length == 1 ? g(iVarArr[0]) : g.a.c1.a.a(new g.a.y0.e.a.d(iVarArr));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static c c(i.d.b<? extends i> bVar) {
        return a(bVar, 2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c d(Callable<?> callable) {
        g.a.y0.b.b.a(callable, "callable is null");
        return g.a.c1.a.a(new g.a.y0.e.a.q(callable));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static c e(i.d.b<? extends i> bVar) {
        return a(bVar, Integer.MAX_VALUE, false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c f(i iVar) {
        g.a.y0.b.b.a(iVar, "source is null");
        if (iVar instanceof c) {
            throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
        }
        return g.a.c1.a.a(new g.a.y0.e.a.v(iVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c g(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "run is null");
        return g.a.c1.a.a(new g.a.y0.e.a.p(aVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c q() {
        return g.a.c1.a.a(g.a.y0.e.a.m.f14075a);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c r() {
        return g.a.c1.a.a(g.a.y0.e.a.d0.f14003a);
    }

    protected abstract void b(f fVar);

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c h() {
        return a(g.a.y0.b.a.b());
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("none")
    public final c i() {
        return g.a.c1.a.a(new g.a.y0.e.a.i(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c j() {
        return d(n().A());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c k() {
        return d(n().C());
    }

    @g.a.t0.h("none")
    public final g.a.u0.c l() {
        g.a.y0.d.o oVar = new g.a.y0.d.o();
        a((f) oVar);
        return oVar;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.a1.n<Void> m() {
        g.a.a1.n<Void> nVar = new g.a.a1.n<>();
        a((f) nVar);
        return nVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> l<T> n() {
        return this instanceof g.a.y0.c.b ? ((g.a.y0.c.b) this).b() : g.a.c1.a.a(new g.a.y0.e.a.l0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> s<T> o() {
        return this instanceof g.a.y0.c.c ? ((g.a.y0.c.c) this).c() : g.a.c1.a.a(new g.a.y0.e.c.j0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> b0<T> p() {
        return this instanceof g.a.y0.c.d ? ((g.a.y0.c.d) this).a() : g.a.c1.a.a(new g.a.y0.e.a.m0(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c c(Callable<? extends Throwable> callable) {
        g.a.y0.b.b.a(callable, "errorSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.a.o(callable));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static c e(long j2, TimeUnit timeUnit) {
        return c(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> c d(i.d.b<T> bVar) {
        g.a.y0.b.b.a(bVar, "publisher is null");
        return g.a.c1.a.a(new g.a.y0.e.a.s(bVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c g(i iVar) {
        g.a.y0.b.b.a(iVar, "source is null");
        if (iVar instanceof c) {
            return g.a.c1.a.a((c) iVar);
        }
        return g.a.c1.a.a(new g.a.y0.e.a.v(iVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final Throwable e() {
        g.a.y0.d.h hVar = new g.a.y0.d.h();
        a((f) hVar);
        return hVar.b();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c c(i... iVarArr) {
        g.a.y0.b.b.a(iVarArr, "sources is null");
        if (iVarArr.length == 0) {
            return q();
        }
        if (iVarArr.length == 1) {
            return g(iVarArr[0]);
        }
        return g.a.c1.a.a(new g.a.y0.e.a.z(iVarArr));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c d(i... iVarArr) {
        g.a.y0.b.b.a(iVarArr, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.a.a0(iVarArr));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static c f(i.d.b<? extends i> bVar) {
        return a(bVar, Integer.MAX_VALUE, true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c e(g.a.x0.a aVar) {
        g.a.x0.g<? super g.a.u0.c> gVarD = g.a.y0.b.a.d();
        g.a.x0.g<? super Throwable> gVarD2 = g.a.y0.b.a.d();
        g.a.x0.a aVar2 = g.a.y0.b.a.f13899c;
        return a(gVarD, gVarD2, aVar2, aVar, aVar2, aVar2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c f() {
        return g.a.c1.a.a(new g.a.y0.e.a.b(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c a(Iterable<? extends i> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.a.a(null, iterable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c b(Iterable<? extends i> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.a.e(iterable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c d(Iterable<? extends i> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.a.b0(iterable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c e(i iVar) {
        g.a.y0.b.b.a(iVar, "other is null");
        return b(iVar, this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c f(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onComplete is null");
        g.a.y0.d.j jVar = new g.a.y0.d.j(aVar);
        a((f) jVar);
        return jVar;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c g() {
        return g.a.c1.a.a(new g.a.y0.e.a.w(this));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static c a(i.d.b<? extends i> bVar, int i2) {
        g.a.y0.b.b.a(bVar, "sources is null");
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.a.c(bVar, i2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c b(Callable<? extends i> callable) {
        g.a.y0.b.b.a(callable, "completableSupplier");
        return g.a.c1.a.a(new g.a.y0.e.a.g(callable));
    }

    @g.a.t0.h("none")
    public final void d() throws InterruptedException {
        g.a.y0.d.h hVar = new g.a.y0.d.h();
        a((f) hVar);
        hVar.a();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c c(Iterable<? extends i> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.a.c0(iterable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> c b(g0<T> g0Var) {
        g.a.y0.b.b.a(g0Var, "observable is null");
        return g.a.c1.a.a(new g.a.y0.e.a.r(g0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c a(g gVar) {
        g.a.y0.b.b.a(gVar, "source is null");
        return g.a.c1.a.a(new g.a.y0.e.a.f(gVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static c c(i.d.b<? extends i> bVar, int i2) {
        return a(bVar, i2, true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c d(g.a.x0.a aVar) {
        g.a.x0.g<? super g.a.u0.c> gVarD = g.a.y0.b.a.d();
        g.a.x0.g<? super Throwable> gVarD2 = g.a.y0.b.a.d();
        g.a.x0.a aVar2 = g.a.y0.b.a.f13899c;
        return a(gVarD, gVarD2, aVar2, aVar2, aVar2, aVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> c b(q0<T> q0Var) {
        g.a.y0.b.b.a(q0Var, "single is null");
        return g.a.c1.a.a(new g.a.y0.e.a.u(q0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static c c(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.a.k0(j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c d(i iVar) {
        g.a.y0.b.b.a(iVar, "other is null");
        return c(this, iVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c a(Throwable th) {
        g.a.y0.b.b.a(th, "error is null");
        return g.a.c1.a.a(new g.a.y0.e.a.n(th));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static c b(i.d.b<? extends i> bVar, int i2) {
        return a(bVar, i2, false);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final c d(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, g.a.e1.a.a(), null);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c a(Future<?> future) {
        g.a.y0.b.b.a(future, "future is null");
        return g(g.a.y0.b.a.a(future));
    }

    private static NullPointerException b(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c c(i iVar) {
        g.a.y0.b.b.a(iVar, "other is null");
        return b(this, iVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> U d(g.a.x0.o<? super c, U> oVar) {
        try {
            return (U) ((g.a.x0.o) g.a.y0.b.b.a(oVar, "converter is null")).apply(this);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            throw g.a.y0.j.k.c(th);
        }
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static c a(Runnable runnable) {
        g.a.y0.b.b.a(runnable, "run is null");
        return g.a.c1.a.a(new g.a.y0.e.a.t(runnable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c b(i iVar) {
        return c(iVar);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final c c(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.a(), false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final Throwable b(long j2, TimeUnit timeUnit) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.d.h hVar = new g.a.y0.d.h();
        a((f) hVar);
        return hVar.b(j2, timeUnit);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c c(g.a.x0.a aVar) {
        g.a.x0.g<? super g.a.u0.c> gVarD = g.a.y0.b.a.d();
        g.a.x0.g<? super Throwable> gVarD2 = g.a.y0.b.a.d();
        g.a.x0.a aVar2 = g.a.y0.b.a.f13899c;
        return a(gVarD, gVarD2, aVar, aVar2, aVar2, aVar2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    private static c a(i.d.b<? extends i> bVar, int i2, boolean z) {
        g.a.y0.b.b.a(bVar, "sources is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        return g.a.c1.a.a(new g.a.y0.e.a.y(bVar, i2, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c c(g.a.x0.g<? super g.a.u0.c> gVar) {
        g.a.x0.g<? super Throwable> gVarD = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return a(gVar, gVarD, aVar, aVar, aVar, aVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c c(g.a.x0.o<? super l<Throwable>, ? extends i.d.b<?>> oVar) {
        return d(n().u(oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <E extends f> E c(E e2) {
        a((f) e2);
        return e2;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <R> c a(Callable<R> callable, g.a.x0.o<? super R, ? extends i> oVar, g.a.x0.g<? super R> gVar) {
        return a((Callable) callable, (g.a.x0.o) oVar, (g.a.x0.g) gVar, true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c b(g.a.x0.g<? super Throwable> gVar) {
        g.a.y0.b.b.a(gVar, "onEvent is null");
        return g.a.c1.a.a(new g.a.y0.e.a.l(this, gVar));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final c c(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.a.j(this, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <R> c a(Callable<R> callable, g.a.x0.o<? super R, ? extends i> oVar, g.a.x0.g<? super R> gVar, boolean z) {
        g.a.y0.b.b.a(callable, "resourceSupplier is null");
        g.a.y0.b.b.a(oVar, "completableFunction is null");
        g.a.y0.b.b.a(gVar, "disposer is null");
        return g.a.c1.a.a(new g.a.y0.e.a.o0(callable, oVar, gVar, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c b(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onFinally is null");
        return g.a.c1.a.a(new g.a.y0.e.a.k(this, aVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c b(g.a.x0.o<? super l<Object>, ? extends i.d.b<?>> oVar) {
        return d(n().s(oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c a(i iVar) {
        g.a.y0.b.b.a(iVar, "other is null");
        return a(this, iVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c b(long j2) {
        return d(n().e(j2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c b(g.a.x0.r<? super Throwable> rVar) {
        return d(n().e(rVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> b0<T> a(g0<T> g0Var) {
        g.a.y0.b.b.a(g0Var, "next is null");
        return g.a.c1.a.a(new g.a.y0.e.d.f0(g0Var, p()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> l<T> b(i.d.b<T> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return n().j((i.d.b) bVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> l<T> a(i.d.b<T> bVar) {
        g.a.y0.b.b.a(bVar, "next is null");
        return g.a.c1.a.a(new g.a.y0.e.b.h0(bVar, n()));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final c b(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.a.i0(this, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> k0<T> a(q0<T> q0Var) {
        g.a.y0.b.b.a(q0Var, "next is null");
        return g.a.c1.a.a(new g.a.y0.e.f.g(q0Var, this));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final c b(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var, null);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    private c b(long j2, TimeUnit timeUnit, j0 j0Var, i iVar) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.a.j0(this, j2, timeUnit, j0Var, iVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> s<T> a(y<T> yVar) {
        g.a.y0.b.b.a(yVar, "next is null");
        return g.a.c1.a.a(new g.a.y0.e.c.o(yVar, this));
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> R a(@g.a.t0.f d<? extends R> dVar) {
        return (R) ((d) g.a.y0.b.b.a(dVar, "converter is null")).a(this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final boolean a(long j2, TimeUnit timeUnit) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.d.h hVar = new g.a.y0.d.h();
        a((f) hVar);
        return hVar.a(j2, timeUnit);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c a(j jVar) {
        return g(((j) g.a.y0.b.b.a(jVar, "transformer is null")).a(this));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final c a(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final c a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.a.h(this, j2, timeUnit, j0Var, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c a(g.a.x0.g<? super Throwable> gVar) {
        g.a.x0.g<? super g.a.u0.c> gVarD = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return a(gVarD, gVar, aVar, aVar, aVar, aVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    private c a(g.a.x0.g<? super g.a.u0.c> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.a aVar2, g.a.x0.a aVar3, g.a.x0.a aVar4) {
        g.a.y0.b.b.a(gVar, "onSubscribe is null");
        g.a.y0.b.b.a(gVar2, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        g.a.y0.b.b.a(aVar2, "onTerminate is null");
        g.a.y0.b.b.a(aVar3, "onAfterTerminate is null");
        g.a.y0.b.b.a(aVar4, "onDispose is null");
        return g.a.c1.a.a(new g.a.y0.e.a.g0(this, gVar, gVar2, aVar, aVar2, aVar3, aVar4));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c a(g.a.x0.a aVar) {
        g.a.x0.g<? super g.a.u0.c> gVarD = g.a.y0.b.a.d();
        g.a.x0.g<? super Throwable> gVarD2 = g.a.y0.b.a.d();
        g.a.x0.a aVar2 = g.a.y0.b.a.f13899c;
        return a(gVarD, gVarD2, aVar2, aVar2, aVar, aVar2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c a(h hVar) {
        g.a.y0.b.b.a(hVar, "onLift is null");
        return g.a.c1.a.a(new g.a.y0.e.a.x(this, hVar));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final c a(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.a.e0(this, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c a(g.a.x0.r<? super Throwable> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new g.a.y0.e.a.f0(this, rVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c a(g.a.x0.o<? super Throwable, ? extends i> oVar) {
        g.a.y0.b.b.a(oVar, "errorMapper is null");
        return g.a.c1.a.a(new g.a.y0.e.a.h0(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c a(long j2) {
        return d(n().d(j2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c a(g.a.x0.e eVar) {
        return d(n().a(eVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c a(g.a.x0.d<? super Integer, ? super Throwable> dVar) {
        return d(n().b(dVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> b0<T> a(b0<T> b0Var) {
        g.a.y0.b.b.a(b0Var, "other is null");
        return b0Var.c((g0) p());
    }

    @Override // g.a.i
    @g.a.t0.h("none")
    public final void a(f fVar) {
        g.a.y0.b.b.a(fVar, "s is null");
        try {
            b(g.a.c1.a.a(this, fVar));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
            throw b(th);
        }
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c a(g.a.x0.a aVar, g.a.x0.g<? super Throwable> gVar) {
        g.a.y0.b.b.a(gVar, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        g.a.y0.d.j jVar = new g.a.y0.d.j(gVar, aVar);
        a((f) jVar);
        return jVar;
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final c a(long j2, TimeUnit timeUnit, i iVar) {
        g.a.y0.b.b.a(iVar, "other is null");
        return b(j2, timeUnit, g.a.e1.a.a(), iVar);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final c a(long j2, TimeUnit timeUnit, j0 j0Var, i iVar) {
        g.a.y0.b.b.a(iVar, "other is null");
        return b(j2, timeUnit, j0Var, iVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> k0<T> a(Callable<? extends T> callable) {
        g.a.y0.b.b.a(callable, "completionValueSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.a.n0(this, callable, null));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T> k0<T> a(T t) {
        g.a.y0.b.b.a((Object) t, "completionValue is null");
        return g.a.c1.a.a(new g.a.y0.e.a.n0(this, null, t));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.a1.n<Void> a(boolean z) {
        g.a.a1.n<Void> nVar = new g.a.a1.n<>();
        if (z) {
            nVar.cancel();
        }
        a((f) nVar);
        return nVar;
    }
}
