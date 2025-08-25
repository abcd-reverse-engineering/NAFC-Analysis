package g.a;

import g.a.y0.e.c.a1;
import g.a.y0.e.c.b1;
import g.a.y0.e.c.c1;
import g.a.y0.e.c.d1;
import g.a.y0.e.c.e1;
import g.a.y0.e.c.f1;
import g.a.y0.e.c.g1;
import g.a.y0.e.c.h1;
import g.a.y0.e.c.i1;
import g.a.y0.e.c.j1;
import g.a.y0.e.c.k1;
import g.a.y0.e.c.l1;
import g.a.y0.e.c.m1;
import g.a.y0.e.c.n1;
import g.a.y0.e.c.o1;
import g.a.y0.e.c.p1;
import g.a.y0.e.c.q1;
import g.a.y0.e.c.r1;
import g.a.y0.e.c.s0;
import g.a.y0.e.c.s1;
import g.a.y0.e.c.t0;
import g.a.y0.e.c.u0;
import g.a.y0.e.c.v0;
import g.a.y0.e.c.w0;
import g.a.y0.e.c.x0;
import g.a.y0.e.c.y0;
import g.a.y0.e.c.z0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Maybe.java */
/* loaded from: classes2.dex */
public abstract class s<T> implements y<T> {
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> a(Iterable<? extends y<? extends T>> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.c.b(null, iterable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(Iterable<? extends y<? extends T>> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.c.g(iterable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(y<? extends T>... yVarArr) {
        return yVarArr.length == 0 ? l.R() : yVarArr.length == 1 ? g.a.c1.a.a(new k1(yVarArr[0])) : g.a.c1.a.a(new g.a.y0.e.c.f(yVarArr));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> d(y<? extends T>... yVarArr) {
        return l.b((Object[]) yVarArr).c(m1.instance());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> e(i.d.b<? extends y<? extends T>> bVar) {
        return a(bVar, 2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> f(i.d.b<? extends y<? extends T>> bVar) {
        return l.q(bVar).b(m1.instance());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> g(i.d.b<? extends y<? extends T>> bVar) {
        return l.q(bVar).c(m1.instance());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> h(i.d.b<? extends y<? extends T>> bVar) {
        return b(bVar, Integer.MAX_VALUE);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> i(y<? extends y<? extends T>> yVar) {
        g.a.y0.b.b.a(yVar, "source is null");
        return g.a.c1.a.a(new g.a.y0.e.c.g0(yVar, g.a.y0.b.a.e()));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> j(y<T> yVar) {
        if (yVar instanceof s) {
            throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
        }
        g.a.y0.b.b.a(yVar, "onSubscribe is null");
        return g.a.c1.a.a(new o1(yVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> k(y<T> yVar) {
        if (yVar instanceof s) {
            return g.a.c1.a.a((s) yVar);
        }
        g.a.y0.b.b.a(yVar, "onSubscribe is null");
        return g.a.c1.a.a(new o1(yVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> r() {
        return g.a.c1.a.a((s) g.a.y0.e.c.t.f14899a);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> s() {
        return g.a.c1.a.a(w0.f14911a);
    }

    protected abstract void b(v<? super T> vVar);

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> l(g.a.x0.o<? super Throwable, ? extends T> oVar) {
        g.a.y0.b.b.a(oVar, "valueSupplier is null");
        return g.a.c1.a.a(new a1(this, oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> m(g.a.x0.o<? super l<Object>, ? extends i.d.b<?>> oVar) {
        return o().s(oVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> n(g.a.x0.o<? super l<Throwable>, ? extends i.d.b<?>> oVar) {
        return o().u(oVar).F();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> R o(g.a.x0.o<? super s<T>, R> oVar) {
        try {
            return (R) ((g.a.x0.o) g.a.y0.b.b.a(oVar, "convert is null")).apply(this);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            throw g.a.y0.j.k.c(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> p() {
        return this instanceof g.a.y0.c.d ? ((g.a.y0.c.d) this).a() : g.a.c1.a.a(new l1(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> q() {
        return g.a.c1.a.a(new n1(this, null));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> d(Iterable<? extends y<? extends T>> iterable) {
        return l.f((Iterable) iterable).c(m1.instance());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> e(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "run is null");
        return g.a.c1.a.a((s) new g.a.y0.e.c.h0(aVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> f(T t) {
        g.a.y0.b.b.a((Object) t, "item is null");
        return g.a.c1.a.a((s) new s0(t));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> s<R> g(g.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.c.f0(this, oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<U> h(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.c.b0(this, oVar));
    }

    @g.a.t0.h("none")
    public final g.a.u0.c m() {
        return a(g.a.y0.b.a.d(), g.a.y0.b.a.f13902f, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.a1.n<T> n() {
        g.a.a1.n<T> nVar = new g.a.a1.n<>();
        a((v) nVar);
        return nVar;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> a(y<? extends T>... yVarArr) {
        if (yVarArr.length == 0) {
            return r();
        }
        if (yVarArr.length == 1) {
            return k(yVarArr[0]);
        }
        return g.a.c1.a.a(new g.a.y0.e.c.b(yVarArr, null));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(y<? extends T> yVar, y<? extends T> yVar2) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        return b(yVar, yVar2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> d(y<? extends T> yVar, y<? extends T> yVar2) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        return f(yVar, yVar2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> i(i.d.b<? extends y<? extends T>> bVar) {
        return l.q(bVar).b(m1.instance(), true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> l() {
        return a(h.q2.t.m0.f16408b, g.a.y0.b.a.b());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> e(Iterable<? extends y<? extends T>> iterable) {
        return h(l.f((Iterable) iterable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> f(y<? extends T>... yVarArr) {
        if (yVarArr.length == 0) {
            return l.R();
        }
        return l.b((Object[]) yVarArr).a(m1.instance(), true, yVarArr.length);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c g() {
        return g.a.c1.a.a(new g.a.y0.e.c.p0(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> h() {
        return g.a.c1.a.a(new g.a.y0.e.c.r0(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<U> i(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.c.c0(this, oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> o() {
        if (this instanceof g.a.y0.c.b) {
            return ((g.a.y0.c.b) this).b();
        }
        return g.a.c1.a.a(new k1(this));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> e(y<? extends T>... yVarArr) {
        g.a.y0.b.b.a(yVarArr, "sources is null");
        if (yVarArr.length == 0) {
            return l.R();
        }
        if (yVarArr.length == 1) {
            return g.a.c1.a.a(new k1(yVarArr[0]));
        }
        return g.a.c1.a.a(new v0(yVarArr));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> s<T> g(y<U> yVar) {
        g.a.y0.b.b.a(yVar, "other is null");
        return g.a.c1.a.a(new f1(this, yVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> s<T> h(y<U> yVar) {
        g.a.y0.b.b.a(yVar, "timeoutIndicator is null");
        return g.a.c1.a.a(new h1(this, yVar, null));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> s<R> j(g.a.x0.o<? super T, ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new u0(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> k(g.a.x0.o<? super Throwable, ? extends y<? extends T>> oVar) {
        g.a.y0.b.b.a(oVar, "resumeFunction is null");
        return g.a.c1.a.a(new z0(this, oVar, true));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(y<? extends T>... yVarArr) {
        g.a.y0.b.b.a(yVarArr, "sources is null");
        if (yVarArr.length == 0) {
            return l.R();
        }
        if (yVarArr.length == 1) {
            return g.a.c1.a.a(new k1(yVarArr[0]));
        }
        return g.a.c1.a.a(new g.a.y0.e.c.e(yVarArr));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(Iterable<? extends y<? extends T>> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return l.f((Iterable) iterable).b(m1.instance());
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static s<Long> d(long j2, TimeUnit timeUnit) {
        return d(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> i() {
        return b(g.a.y0.b.a.b());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static s<Long> d(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new j1(Math.max(0L, j2), timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> f(Iterable<? extends y<? extends T>> iterable) {
        return l.f((Iterable) iterable).b(m1.instance(), true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> j() {
        return g.a.c1.a.a(new g.a.y0.e.c.p(this));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> k() {
        return a(h.q2.t.m0.f16408b);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        return b(yVar, yVar2, yVar3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> c(Callable<? extends T> callable) {
        g.a.y0.b.b.a(callable, "callable is null");
        return g.a.c1.a.a((s) new g.a.y0.e.c.i0(callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> k0<R> f(g.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.c.e0(this, oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(y<? extends T> yVar, y<? extends T> yVar2) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        return e(yVar, yVar2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> d() {
        return g.a.c1.a.a(new g.a.y0.e.c.c(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> f() {
        return g.a.c1.a.a(new g.a.y0.e.c.n0(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> e(y<? extends T> yVar, y<? extends T> yVar2) {
        return a(yVar, yVar2, g.a.y0.b.b.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> d(g.a.x0.a aVar) {
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.g gVarD3 = g.a.y0.b.a.d();
        g.a.x0.a aVar2 = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new b1(this, gVarD, gVarD2, gVarD3, aVar2, aVar2, (g.a.x0.a) g.a.y0.b.b.a(aVar, "onDispose is null")));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> f(y<? extends T> yVar) {
        g.a.y0.b.b.a(yVar, "other is null");
        return g.a.c1.a.a(new d1(this, yVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3, y<? extends T> yVar4) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        g.a.y0.b.b.a(yVar4, "source4 is null");
        return b(yVar, yVar2, yVar3, yVar4);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> b(Callable<? extends Throwable> callable) {
        g.a.y0.b.b.a(callable, "errorSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.c.w(callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Long> e() {
        return g.a.c1.a.a(new g.a.y0.e.c.i(this));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        return f(yVar, yVar2, yVar3);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> e(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar) {
        return o().i((g.a.x0.o) oVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> b(q0<T> q0Var) {
        g.a.y0.b.b.a(q0Var, "singleSource is null");
        return g.a.c1.a.a(new g.a.y0.e.c.m0(q0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> e(T t) {
        g.a.y0.b.b.a((Object) t, "defaultValue is null");
        return g.a.c1.a.a(new n1(this, t));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(i.d.b<? extends y<? extends T>> bVar, int i2) {
        g.a.y0.b.b.a(bVar, "source is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        return g.a.c1.a.a(new g.a.y0.e.b.a1(bVar, m1.instance(), false, i2, l.Q()));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> e(y<? extends T> yVar) {
        g.a.y0.b.b.a(yVar, "next is null");
        return g.a.c1.a.a(new z0(this, g.a.y0.b.a.c(yVar), false));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(i.d.b<? extends y<? extends T>> bVar, int i2) {
        g.a.y0.b.b.a(bVar, "sources is null");
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.b.z(bVar, m1.instance(), i2, g.a.y0.j.j.IMMEDIATE));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3, y<? extends T> yVar4) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        g.a.y0.b.b.a(yVar4, "source4 is null");
        return f(yVar, yVar2, yVar3, yVar4);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> d(g.a.x0.g<? super T> gVar) {
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVar2 = (g.a.x0.g) g.a.y0.b.b.a(gVar, "onSubscribe is null");
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new b1(this, gVarD, gVar2, gVarD2, aVar, aVar, aVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c e(g.a.x0.g<? super T> gVar) {
        return a(gVar, g.a.y0.b.a.f13902f, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        return e(yVar, yVar2, yVar3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> a(w<T> wVar) {
        g.a.y0.b.b.a(wVar, "onSubscribe is null");
        return g.a.c1.a.a(new g.a.y0.e.c.j(wVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> a(Callable<? extends y<? extends T>> callable) {
        g.a.y0.b.b.a(callable, "maybeSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.c.k(callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final T c() {
        g.a.y0.d.h hVar = new g.a.y0.d.h();
        a((v) hVar);
        return (T) hVar.a();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> d(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return p().j((g.a.x0.o) oVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3, y<? extends T> yVar4) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        g.a.y0.b.b.a(yVar4, "source4 is null");
        return e(yVar, yVar2, yVar3, yVar4);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> d(y<? extends T> yVar) {
        g.a.y0.b.b.a(yVar, "next is null");
        return k(g.a.y0.b.a.c(yVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> a(Throwable th) {
        g.a.y0.b.b.a(th, "exception is null");
        return g.a.c1.a.a(new g.a.y0.e.c.v(th));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> c(T t) {
        g.a.y0.b.b.a((Object) t, "item is null");
        return f((y) f(t));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> d(T t) {
        g.a.y0.b.b.a((Object) t, "item is null");
        return l(g.a.y0.b.a.c(t));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> a(i iVar) {
        g.a.y0.b.b.a(iVar, "completableSource is null");
        return g.a.c1.a.a(new g.a.y0.e.c.j0(iVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> c(g.a.x0.a aVar) {
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.g gVarD3 = g.a.y0.b.a.d();
        g.a.x0.a aVar2 = (g.a.x0.a) g.a.y0.b.b.a(aVar, "onComplete is null");
        g.a.x0.a aVar3 = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new b1(this, gVarD, gVarD2, gVarD3, aVar2, aVar3, aVar3));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> s<T> d(i.d.b<U> bVar) {
        g.a.y0.b.b.a(bVar, "timeoutIndicator is null");
        return g.a.c1.a.a(new i1(this, bVar, null));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> a(Future<? extends T> future) {
        g.a.y0.b.b.a(future, "future is null");
        return g.a.c1.a.a(new g.a.y0.e.c.k0(future, 0L, null));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> b(y<? extends T> yVar) {
        g.a.y0.b.b.a(yVar, "other is null");
        return b(this, yVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        g.a.y0.b.b.a(future, "future is null");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        return g.a.c1.a.a(new g.a.y0.e.c.k0(future, j2, timeUnit));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> b(Object obj) {
        g.a.y0.b.b.a(obj, "item is null");
        return g.a.c1.a.a(new g.a.y0.e.c.h(this, obj));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> s<T> b(i.d.b<U> bVar) {
        g.a.y0.b.b.a(bVar, "subscriptionIndicator is null");
        return g.a.c1.a.a(new g.a.y0.e.c.n(this, bVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> s<T> a(Runnable runnable) {
        g.a.y0.b.b.a(runnable, "run is null");
        return g.a.c1.a.a((s) new g.a.y0.e.c.l0(runnable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> c(g.a.x0.g<? super g.a.u0.c> gVar) {
        g.a.x0.g gVar2 = (g.a.x0.g) g.a.y0.b.b.a(gVar, "onSubscribe is null");
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new b1(this, gVar2, gVarD, gVarD2, aVar, aVar, aVar));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final s<T> b(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> a(y<? extends T> yVar, y<? extends T> yVar2, g.a.x0.d<? super T, ? super T> dVar) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(dVar, "isEqual is null");
        return g.a.c1.a.a(new g.a.y0.e.c.u(yVar, yVar2, dVar));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final s<T> b(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b((i.d.b) l.q(j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> b(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onFinally is null");
        return g.a.c1.a.a(new g.a.y0.e.c.r(this, aVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> b(g.a.x0.g<? super Throwable> gVar) {
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.g gVar2 = (g.a.x0.g) g.a.y0.b.b.a(gVar, "onError is null");
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new b1(this, gVarD, gVarD2, gVar2, aVar, aVar, aVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c c(g.a.x0.o<? super T, ? extends i> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.c.a0(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, D> s<T> a(Callable<? extends D> callable, g.a.x0.o<? super D, ? extends y<? extends T>> oVar, g.a.x0.g<? super D> gVar) {
        return a((Callable) callable, (g.a.x0.o) oVar, (g.a.x0.g) gVar, true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, D> s<T> a(Callable<? extends D> callable, g.a.x0.o<? super D, ? extends y<? extends T>> oVar, g.a.x0.g<? super D> gVar, boolean z) {
        g.a.y0.b.b.a(callable, "resourceSupplier is null");
        g.a.y0.b.b.a(oVar, "sourceSupplier is null");
        g.a.y0.b.b.a(gVar, "disposer is null");
        return g.a.c1.a.a(new q1(callable, oVar, gVar, z));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> c(y<? extends T> yVar) {
        g.a.y0.b.b.a(yVar, "other is null");
        return c(this, yVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> c(g.a.x0.r<? super Throwable> rVar) {
        return a(h.q2.t.m0.f16408b, rVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> s<R> b(g.a.x0.o<? super T, ? extends y<? extends R>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.c.g0(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <E extends v<? super T>> E c(E e2) {
        a((v) e2);
        return e2;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> s<R> a(Iterable<? extends y<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "zipper is null");
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new s1(iterable, oVar));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> s<T> c(i.d.b<U> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return g.a.c1.a.a(new g1(this, bVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> s<U> b(Class<U> cls) {
        g.a.y0.b.b.a(cls, "clazz is null");
        return a((g.a.x0.r) g.a.y0.b.a.b((Class) cls)).a((Class) cls);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final s<T> c(long j2, TimeUnit timeUnit) {
        return c(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, g.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        return a(g.a.y0.b.a.a((g.a.x0.c) cVar), yVar, yVar2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> b(g.a.x0.r<? super Throwable> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new y0(this, rVar));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final s<T> c(long j2, TimeUnit timeUnit, j0 j0Var) {
        return h(d(j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final s<T> c(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new p1(this, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> b(long j2) {
        return a(j2, g.a.y0.b.a.b());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, g.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        return a(g.a.y0.b.a.a((g.a.x0.h) hVar), yVar, yVar2, yVar3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> b(g.a.x0.e eVar) {
        g.a.y0.b.b.a(eVar, "stop is null");
        return a(h.q2.t.m0.f16408b, g.a.y0.b.a.a(eVar));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final s<T> b(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new c1(this, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, g.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        g.a.y0.b.b.a(yVar4, "source4 is null");
        return a(g.a.y0.b.a.a((g.a.x0.i) iVar), yVar, yVar2, yVar3, yVar4);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, y<? extends T5> yVar5, g.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        g.a.y0.b.b.a(yVar4, "source4 is null");
        g.a.y0.b.b.a(yVar5, "source5 is null");
        return a(g.a.y0.b.a.a((g.a.x0.j) jVar), yVar, yVar2, yVar3, yVar4, yVar5);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, y<? extends T5> yVar5, y<? extends T6> yVar6, g.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        g.a.y0.b.b.a(yVar4, "source4 is null");
        g.a.y0.b.b.a(yVar5, "source5 is null");
        g.a.y0.b.b.a(yVar6, "source6 is null");
        return a(g.a.y0.b.a.a((g.a.x0.k) kVar), yVar, yVar2, yVar3, yVar4, yVar5, yVar6);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, y<? extends T5> yVar5, y<? extends T6> yVar6, y<? extends T7> yVar7, g.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        g.a.y0.b.b.a(yVar4, "source4 is null");
        g.a.y0.b.b.a(yVar5, "source5 is null");
        g.a.y0.b.b.a(yVar6, "source6 is null");
        g.a.y0.b.b.a(yVar7, "source7 is null");
        return a(g.a.y0.b.a.a((g.a.x0.l) lVar), yVar, yVar2, yVar3, yVar4, yVar5, yVar6, yVar7);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, y<? extends T5> yVar5, y<? extends T6> yVar6, y<? extends T7> yVar7, y<? extends T8> yVar8, g.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        g.a.y0.b.b.a(yVar4, "source4 is null");
        g.a.y0.b.b.a(yVar5, "source5 is null");
        g.a.y0.b.b.a(yVar6, "source6 is null");
        g.a.y0.b.b.a(yVar7, "source7 is null");
        g.a.y0.b.b.a(yVar8, "source8 is null");
        return a(g.a.y0.b.a.a((g.a.x0.m) mVar), yVar, yVar2, yVar3, yVar4, yVar5, yVar6, yVar7, yVar8);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, y<? extends T5> yVar5, y<? extends T6> yVar6, y<? extends T7> yVar7, y<? extends T8> yVar8, y<? extends T9> yVar9, g.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        g.a.y0.b.b.a(yVar, "source1 is null");
        g.a.y0.b.b.a(yVar2, "source2 is null");
        g.a.y0.b.b.a(yVar3, "source3 is null");
        g.a.y0.b.b.a(yVar4, "source4 is null");
        g.a.y0.b.b.a(yVar5, "source5 is null");
        g.a.y0.b.b.a(yVar6, "source6 is null");
        g.a.y0.b.b.a(yVar7, "source7 is null");
        g.a.y0.b.b.a(yVar8, "source8 is null");
        g.a.y0.b.b.a(yVar9, "source9 is null");
        return a(g.a.y0.b.a.a((g.a.x0.n) nVar), yVar, yVar2, yVar3, yVar4, yVar5, yVar6, yVar7, yVar8, yVar9);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> s<R> a(g.a.x0.o<? super Object[], ? extends R> oVar, y<? extends T>... yVarArr) {
        g.a.y0.b.b.a(yVarArr, "sources is null");
        if (yVarArr.length == 0) {
            return r();
        }
        g.a.y0.b.b.a(oVar, "zipper is null");
        return g.a.c1.a.a(new r1(yVarArr, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(y<? extends T> yVar) {
        g.a.y0.b.b.a(yVar, "other is null");
        return a(this, yVar);
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> R a(@g.a.t0.f t<T, ? extends R> tVar) {
        return (R) ((t) g.a.y0.b.b.a(tVar, "converter is null")).a(this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final T a(T t) {
        g.a.y0.b.b.a((Object) t, "defaultValue is null");
        g.a.y0.d.h hVar = new g.a.y0.d.h();
        a((v) hVar);
        return (T) hVar.a(t);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> s<U> a(Class<? extends U> cls) {
        g.a.y0.b.b.a(cls, "clazz is null");
        return (s<U>) j(g.a.y0.b.a.a((Class) cls));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> s<R> a(z<? super T, ? extends R> zVar) {
        return k(((z) g.a.y0.b.b.a(zVar, "transformer is null")).a(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> s<R> a(g.a.x0.o<? super T, ? extends y<? extends R>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.c.g0(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final s<T> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final s<T> a(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.c.l(this, Math.max(0L, j2), timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> s<T> a(i.d.b<U> bVar) {
        g.a.y0.b.b.a(bVar, "delayIndicator is null");
        return g.a.c1.a.a(new g.a.y0.e.c.m(this, bVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(g.a.x0.g<? super T> gVar) {
        g.a.y0.b.b.a(gVar, "doAfterSuccess is null");
        return g.a.c1.a.a(new g.a.y0.e.c.q(this, gVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(g.a.x0.a aVar) {
        return g.a.c1.a.a(new b1(this, g.a.y0.b.a.d(), g.a.y0.b.a.d(), g.a.y0.b.a.d(), g.a.y0.b.a.f13899c, (g.a.x0.a) g.a.y0.b.b.a(aVar, "onAfterTerminate is null"), g.a.y0.b.a.f13899c));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(g.a.x0.b<? super T, ? super Throwable> bVar) {
        g.a.y0.b.b.a(bVar, "onEvent is null");
        return g.a.c1.a.a(new g.a.y0.e.c.s(this, bVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new g.a.y0.e.c.x(this, rVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> s<R> a(g.a.x0.o<? super T, ? extends y<? extends R>> oVar, g.a.x0.o<? super Throwable, ? extends y<? extends R>> oVar2, Callable<? extends y<? extends R>> callable) {
        g.a.y0.b.b.a(oVar, "onSuccessMapper is null");
        g.a.y0.b.b.a(oVar2, "onErrorMapper is null");
        g.a.y0.b.b.a(callable, "onCompleteSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.c.d0(this, oVar, oVar2, callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> s<R> a(g.a.x0.o<? super T, ? extends y<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(cVar, "resultSelector is null");
        return g.a.c1.a.a(new g.a.y0.e.c.z(this, oVar, cVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> s<R> a(x<? extends R, ? super T> xVar) {
        g.a.y0.b.b.a(xVar, "onLift is null");
        return g.a.c1.a.a(new t0(this, xVar));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final s<T> a(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new x0(this, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(long j2) {
        return o().d(j2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(g.a.x0.e eVar) {
        return o().a(eVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(g.a.x0.d<? super Integer, ? super Throwable> dVar) {
        return o().b(dVar).F();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(long j2, g.a.x0.r<? super Throwable> rVar) {
        return o().a(j2, rVar).F();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2) {
        return a(gVar, gVar2, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar) {
        g.a.y0.b.b.a(gVar, "onSuccess is null");
        g.a.y0.b.b.a(gVar2, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        return (g.a.u0.c) c((s<T>) new g.a.y0.e.c.d(gVar, gVar2, aVar));
    }

    @Override // g.a.y
    @g.a.t0.h("none")
    public final void a(v<? super T> vVar) {
        g.a.y0.b.b.a(vVar, "observer is null");
        v<? super T> vVarA = g.a.c1.a.a(this, vVar);
        g.a.y0.b.b.a(vVarA, "observer returned by the RxJavaPlugins hook is null");
        try {
            b((v) vVarA);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> a(q0<? extends T> q0Var) {
        g.a.y0.b.b.a(q0Var, "other is null");
        return g.a.c1.a.a(new e1(this, q0Var));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final s<T> a(long j2, TimeUnit timeUnit, y<? extends T> yVar) {
        g.a.y0.b.b.a(yVar, "other is null");
        return a(j2, timeUnit, g.a.e1.a.a(), yVar);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final s<T> a(long j2, TimeUnit timeUnit, j0 j0Var, y<? extends T> yVar) {
        g.a.y0.b.b.a(yVar, "fallback is null");
        return a(d(j2, timeUnit, j0Var), yVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> s<T> a(y<U> yVar, y<? extends T> yVar2) {
        g.a.y0.b.b.a(yVar, "timeoutIndicator is null");
        g.a.y0.b.b.a(yVar2, "fallback is null");
        return g.a.c1.a.a(new h1(this, yVar, yVar2));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> s<T> a(i.d.b<U> bVar, y<? extends T> yVar) {
        g.a.y0.b.b.a(bVar, "timeoutIndicator is null");
        g.a.y0.b.b.a(yVar, "fallback is null");
        return g.a.c1.a.a(new i1(this, bVar, yVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> s<R> a(y<? extends U> yVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        g.a.y0.b.b.a(yVar, "other is null");
        return a(this, yVar, cVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.a1.n<T> a(boolean z) {
        g.a.a1.n<T> nVar = new g.a.a1.n<>();
        if (z) {
            nVar.cancel();
        }
        a((v) nVar);
        return nVar;
    }
}
