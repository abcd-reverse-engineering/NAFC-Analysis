package g.a;

import g.a.y0.e.b.a1;
import g.a.y0.e.b.l3;
import g.a.y0.e.d.z2;
import g.a.y0.e.f.s0;
import g.a.y0.e.f.t0;
import g.a.y0.e.f.u0;
import g.a.y0.e.f.v0;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Single.java */
/* loaded from: classes2.dex */
public abstract class k0<T> implements q0<T> {
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> a(Iterable<? extends q0<? extends T>> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.f.a(null, iterable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(Iterable<? extends q0<? extends T>> iterable) {
        return c((i.d.b) l.f((Iterable) iterable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(i.d.b<? extends q0<? extends T>> bVar) {
        return a(bVar, 2);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> d(i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "publisher is null");
        return g.a.c1.a.a(new g.a.y0.e.f.b0(bVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> e(i.d.b<? extends q0<? extends T>> bVar) {
        g.a.y0.b.b.a(bVar, "sources is null");
        return g.a.c1.a.a(new a1(bVar, g.a.y0.e.f.e0.b(), false, Integer.MAX_VALUE, l.Q()));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> f(q0<? extends q0<? extends T>> q0Var) {
        g.a.y0.b.b.a(q0Var, "source is null");
        return g.a.c1.a.a(new g.a.y0.e.f.v(q0Var, g.a.y0.b.a.e()));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> g(q0<T> q0Var) {
        g.a.y0.b.b.a(q0Var, "onSubscribe is null");
        if (q0Var instanceof k0) {
            throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        }
        return g.a.c1.a.a(new g.a.y0.e.f.c0(q0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> h(q0<T> q0Var) {
        g.a.y0.b.b.a(q0Var, "source is null");
        return q0Var instanceof k0 ? g.a.c1.a.a((k0) q0Var) : g.a.c1.a.a(new g.a.y0.e.f.c0(q0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> q() {
        return g.a.c1.a.a(g.a.y0.e.f.i0.f15781a);
    }

    protected abstract void b(@g.a.t0.f n0<? super T> n0Var);

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> i(g.a.x0.o<? super Throwable, ? extends q0<? extends T>> oVar) {
        g.a.y0.b.b.a(oVar, "resumeFunctionInCaseOfError is null");
        return g.a.c1.a.a(new g.a.y0.e.f.l0(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> j(g.a.x0.o<Throwable, ? extends T> oVar) {
        g.a.y0.b.b.a(oVar, "resumeFunction is null");
        return g.a.c1.a.a(new g.a.y0.e.f.k0(this, oVar, null));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> k(g.a.x0.o<? super l<Object>, ? extends i.d.b<?>> oVar) {
        return m().s(oVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> l(g.a.x0.o<? super l<Throwable>, ? extends i.d.b<?>> oVar) {
        return a((l) m().u(oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> R m(g.a.x0.o<? super k0<T>, R> oVar) {
        try {
            return (R) ((g.a.x0.o) g.a.y0.b.b.a(oVar, "convert is null")).apply(this);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            throw g.a.y0.j.k.c(th);
        }
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final Future<T> n() {
        return (Future) c((k0<T>) new g.a.y0.d.s());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> o() {
        return this instanceof g.a.y0.c.c ? ((g.a.y0.c.c) this).c() : g.a.c1.a.a(new g.a.y0.e.c.m0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> p() {
        return this instanceof g.a.y0.c.d ? ((g.a.y0.c.d) this).a() : g.a.c1.a.a(new g.a.y0.e.f.r0(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> b(g0<? extends q0<? extends T>> g0Var) {
        g.a.y0.b.b.a(g0Var, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.d.v(g0Var, g.a.y0.e.f.e0.c(), 2, g.a.y0.j.j.IMMEDIATE));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> c(Callable<? extends T> callable) {
        g.a.y0.b.b.a(callable, "callable is null");
        return g.a.c1.a.a(new g.a.y0.e.f.a0(callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.a1.n<T> k() {
        g.a.a1.n<T> nVar = new g.a.a1.n<>();
        a((n0) nVar);
        return nVar;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c l() {
        return g.a.c1.a.a(new g.a.y0.e.a.u(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> a(q0<? extends T>... q0VarArr) {
        if (q0VarArr.length == 0) {
            return b((Callable<? extends Throwable>) g.a.y0.e.f.e0.a());
        }
        if (q0VarArr.length == 1) {
            return h(q0VarArr[0]);
        }
        return g.a.c1.a.a(new g.a.y0.e.f.a(q0VarArr, null));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static k0<Long> d(long j2, TimeUnit timeUnit) {
        return d(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> e() {
        return g.a.c1.a.a(new g.a.y0.e.f.b(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> f() {
        return g.a.c1.a.a(new g.a.y0.e.f.d0(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> i() {
        return a((l) m().C());
    }

    @g.a.t0.h("none")
    public final g.a.u0.c j() {
        return a(g.a.y0.b.a.d(), g.a.y0.b.a.f13902f);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(q0<? extends T>... q0VarArr) {
        return g.a.c1.a.a(new g.a.y0.e.b.w(l.b((Object[]) q0VarArr), g.a.y0.e.f.e0.b(), 2, g.a.y0.j.j.BOUNDARY));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> c(g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "observableSource is null");
        return g.a.c1.a.a(new z2(g0Var, null));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static k0<Long> d(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.f.p0(j2, timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> e(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar) {
        return m().i((g.a.x0.o) oVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<U> f(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.f.x(this, oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> m() {
        if (this instanceof g.a.y0.c.b) {
            return ((g.a.y0.c.b) this).b();
        }
        return g.a.c1.a.a(new g.a.y0.e.f.q0(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> b(Callable<? extends Throwable> callable) {
        g.a.y0.b.b.a(callable, "errorSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.f.u(callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c e(g.a.x0.g<? super T> gVar) {
        return a(gVar, g.a.y0.b.a.f13902f);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<U> g(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.f.y(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> k0<R> h(g.a.x0.o<? super T, ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.f.h0(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> c(T t) {
        g.a.y0.b.b.a((Object) t, "value is null");
        return g.a.c1.a.a(new g.a.y0.e.f.f0(t));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <E> k0<T> e(q0<? extends E> q0Var) {
        g.a.y0.b.b.a(q0Var, "other is null");
        return b((i.d.b) new g.a.y0.e.f.q0(q0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(q0<? extends T> q0Var, q0<? extends T> q0Var2, q0<? extends T> q0Var3) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        return e(l.b((Object[]) new q0[]{q0Var, q0Var2, q0Var3}));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> d(g.a.x0.g<? super T> gVar) {
        g.a.y0.b.b.a(gVar, "onSuccess is null");
        return g.a.c1.a.a(new g.a.y0.e.f.s(this, gVar));
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> g() {
        return g.a.c1.a.a(new g.a.y0.e.f.k(this));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> h() {
        return m().A();
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(i.d.b<? extends q0<? extends T>> bVar, int i2) {
        g.a.y0.b.b.a(bVar, "sources is null");
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.b.z(bVar, g.a.y0.e.f.e0.b(), i2, g.a.y0.j.j.IMMEDIATE));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(Iterable<? extends q0<? extends T>> iterable) {
        return e(l.f((Iterable) iterable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(q0<? extends T> q0Var, q0<? extends T> q0Var2) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        return e(l.b((Object[]) new q0[]{q0Var, q0Var2}));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> d(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return p().j((g.a.x0.o) oVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final T d() {
        g.a.y0.d.h hVar = new g.a.y0.d.h();
        a((n0) hVar);
        return (T) hVar.a();
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(q0<? extends T> q0Var, q0<? extends T> q0Var2) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        return c((i.d.b) l.b((Object[]) new q0[]{q0Var, q0Var2}));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(q0<? extends T> q0Var, q0<? extends T> q0Var2, q0<? extends T> q0Var3, q0<? extends T> q0Var4) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        g.a.y0.b.b.a(q0Var4, "source4 is null");
        return e(l.b((Object[]) new q0[]{q0Var, q0Var2, q0Var3, q0Var4}));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> k0<T> c(q0<U> q0Var) {
        g.a.y0.b.b.a(q0Var, "other is null");
        return g.a.c1.a.a(new g.a.y0.e.f.j(this, q0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> d(q0<? extends T> q0Var) {
        return c(this, q0Var);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(q0<? extends T> q0Var, q0<? extends T> q0Var2, q0<? extends T> q0Var3) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        return c((i.d.b) l.b((Object[]) new q0[]{q0Var, q0Var2, q0Var3}));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> c(g.a.x0.g<? super g.a.u0.c> gVar) {
        g.a.y0.b.b.a(gVar, "onSubscribe is null");
        return g.a.c1.a.a(new g.a.y0.e.f.r(this, gVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> b(q0<? extends T> q0Var, q0<? extends T> q0Var2) {
        g.a.y0.b.b.a(q0Var, "first is null");
        g.a.y0.b.b.a(q0Var2, "second is null");
        return g.a.c1.a.a(new g.a.y0.e.f.t(q0Var, q0Var2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> c(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onDispose is null");
        return g.a.c1.a.a(new g.a.y0.e.f.o(this, aVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(q0<? extends T> q0Var, q0<? extends T> q0Var2, q0<? extends T> q0Var3, q0<? extends T> q0Var4) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        g.a.y0.b.b.a(q0Var4, "source4 is null");
        return c((i.d.b) l.b((Object[]) new q0[]{q0Var, q0Var2, q0Var3, q0Var4}));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> s<R> c(g.a.x0.o<? super T, ? extends y<? extends R>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.f.z(this, oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> b(q0<? extends T> q0Var) {
        return a(this, q0Var);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final k0<T> b(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <E extends n0<? super T>> E c(E e2) {
        a((n0) e2);
        return e2;
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final k0<T> b(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a((g0) b0.q(j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final k0<T> c(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, g.a.e1.a.a(), (q0) null);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> b(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onFinally is null");
        return g.a.c1.a.a(new g.a.y0.e.f.n(this, aVar));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final k0<T> c(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var, (q0) null);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> a(o0<T> o0Var) {
        g.a.y0.b.b.a(o0Var, "source is null");
        return g.a.c1.a.a(new g.a.y0.e.f.d(o0Var));
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final k0<T> c(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new s0(this, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> b(g.a.x0.g<? super Throwable> gVar) {
        g.a.y0.b.b.a(gVar, "onError is null");
        return g.a.c1.a.a(new g.a.y0.e.f.p(this, gVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> a(Callable<? extends q0<? extends T>> callable) {
        g.a.y0.b.b.a(callable, "singleSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.f.e(callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c b(g.a.x0.o<? super T, ? extends i> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.f.w(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> a(Throwable th) {
        g.a.y0.b.b.a(th, "error is null");
        return b((Callable<? extends Throwable>) g.a.y0.b.a.b(th));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> b(T t) {
        g.a.y0.b.b.a((Object) t, "value is null");
        return g.a.c1.a.a(new g.a.y0.e.f.k0(this, null, t));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> a(Future<? extends T> future) {
        return a(l.a((Future) future));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        return a(l.a(future, j2, timeUnit));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> b(long j2) {
        return a((l) m().e(j2));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static <T> k0<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(l.a(future, j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> b(g.a.x0.r<? super Throwable> rVar) {
        return a((l) m().e(rVar));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static <T> k0<T> a(Future<? extends T> future, j0 j0Var) {
        return a(l.a((Future) future, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c b(g.a.x0.b<? super T, ? super Throwable> bVar) {
        g.a.y0.b.b.a(bVar, "onCallback is null");
        g.a.y0.d.d dVar = new g.a.y0.d.d(bVar);
        a((n0) dVar);
        return dVar;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, U> k0<T> a(Callable<U> callable, g.a.x0.o<? super U, ? extends q0<? extends T>> oVar, g.a.x0.g<? super U> gVar) {
        return a((Callable) callable, (g.a.x0.o) oVar, (g.a.x0.g) gVar, true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, U> k0<T> a(Callable<U> callable, g.a.x0.o<? super U, ? extends q0<? extends T>> oVar, g.a.x0.g<? super U> gVar, boolean z) {
        g.a.y0.b.b.a(callable, "resourceSupplier is null");
        g.a.y0.b.b.a(oVar, "singleFunction is null");
        g.a.y0.b.b.a(gVar, "disposer is null");
        return g.a.c1.a.a(new t0(callable, oVar, gVar, z));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final k0<T> b(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.f.m0(this, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> b(i iVar) {
        g.a.y0.b.b.a(iVar, "other is null");
        return b((i.d.b) new g.a.y0.e.a.l0(iVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> k0<R> a(Iterable<? extends q0<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "zipper is null");
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new v0(iterable, oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <E> k0<T> b(i.d.b<E> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return g.a.c1.a.a(new g.a.y0.e.f.n0(this, bVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, g.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        return a(g.a.y0.b.a.a((g.a.x0.c) cVar), q0Var, q0Var2);
    }

    private k0<T> b(long j2, TimeUnit timeUnit, j0 j0Var, q0<? extends T> q0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.f.o0(this, j2, timeUnit, j0Var, q0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, g.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        return a(g.a.y0.b.a.a((g.a.x0.h) hVar), q0Var, q0Var2, q0Var3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, g.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        g.a.y0.b.b.a(q0Var4, "source4 is null");
        return a(g.a.y0.b.a.a((g.a.x0.i) iVar), q0Var, q0Var2, q0Var3, q0Var4);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, q0<? extends T5> q0Var5, g.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        g.a.y0.b.b.a(q0Var4, "source4 is null");
        g.a.y0.b.b.a(q0Var5, "source5 is null");
        return a(g.a.y0.b.a.a((g.a.x0.j) jVar), q0Var, q0Var2, q0Var3, q0Var4, q0Var5);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, q0<? extends T5> q0Var5, q0<? extends T6> q0Var6, g.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        g.a.y0.b.b.a(q0Var4, "source4 is null");
        g.a.y0.b.b.a(q0Var5, "source5 is null");
        g.a.y0.b.b.a(q0Var6, "source6 is null");
        return a(g.a.y0.b.a.a((g.a.x0.k) kVar), q0Var, q0Var2, q0Var3, q0Var4, q0Var5, q0Var6);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, q0<? extends T5> q0Var5, q0<? extends T6> q0Var6, q0<? extends T7> q0Var7, g.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        g.a.y0.b.b.a(q0Var4, "source4 is null");
        g.a.y0.b.b.a(q0Var5, "source5 is null");
        g.a.y0.b.b.a(q0Var6, "source6 is null");
        g.a.y0.b.b.a(q0Var7, "source7 is null");
        return a(g.a.y0.b.a.a((g.a.x0.l) lVar), q0Var, q0Var2, q0Var3, q0Var4, q0Var5, q0Var6, q0Var7);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, q0<? extends T5> q0Var5, q0<? extends T6> q0Var6, q0<? extends T7> q0Var7, q0<? extends T8> q0Var8, g.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        g.a.y0.b.b.a(q0Var4, "source4 is null");
        g.a.y0.b.b.a(q0Var5, "source5 is null");
        g.a.y0.b.b.a(q0Var6, "source6 is null");
        g.a.y0.b.b.a(q0Var7, "source7 is null");
        g.a.y0.b.b.a(q0Var8, "source8 is null");
        return a(g.a.y0.b.a.a((g.a.x0.m) mVar), q0Var, q0Var2, q0Var3, q0Var4, q0Var5, q0Var6, q0Var7, q0Var8);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, q0<? extends T5> q0Var5, q0<? extends T6> q0Var6, q0<? extends T7> q0Var7, q0<? extends T8> q0Var8, q0<? extends T9> q0Var9, g.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        g.a.y0.b.b.a(q0Var, "source1 is null");
        g.a.y0.b.b.a(q0Var2, "source2 is null");
        g.a.y0.b.b.a(q0Var3, "source3 is null");
        g.a.y0.b.b.a(q0Var4, "source4 is null");
        g.a.y0.b.b.a(q0Var5, "source5 is null");
        g.a.y0.b.b.a(q0Var6, "source6 is null");
        g.a.y0.b.b.a(q0Var7, "source7 is null");
        g.a.y0.b.b.a(q0Var8, "source8 is null");
        g.a.y0.b.b.a(q0Var9, "source9 is null");
        return a(g.a.y0.b.a.a((g.a.x0.n) nVar), q0Var, q0Var2, q0Var3, q0Var4, q0Var5, q0Var6, q0Var7, q0Var8, q0Var9);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> k0<R> a(g.a.x0.o<? super Object[], ? extends R> oVar, q0<? extends T>... q0VarArr) {
        g.a.y0.b.b.a(oVar, "zipper is null");
        g.a.y0.b.b.a(q0VarArr, "sources is null");
        if (q0VarArr.length == 0) {
            return a((Throwable) new NoSuchElementException());
        }
        return g.a.c1.a.a(new u0(q0VarArr, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> a(q0<? extends T> q0Var) {
        g.a.y0.b.b.a(q0Var, "other is null");
        return a(this, q0Var);
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> R a(@g.a.t0.f l0<T, ? extends R> l0Var) {
        return (R) ((l0) g.a.y0.b.b.a(l0Var, "converter is null")).a(this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> k0<R> a(r0<? super T, ? extends R> r0Var) {
        return h(((r0) g.a.y0.b.b.a(r0Var, "transformer is null")).a(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> k0<U> a(Class<? extends U> cls) {
        g.a.y0.b.b.a(cls, "clazz is null");
        return (k0<U>) h(g.a.y0.b.a.a((Class) cls));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final k0<T> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.a(), false);
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final k0<T> a(long j2, TimeUnit timeUnit, boolean z) {
        return a(j2, timeUnit, g.a.e1.a.a(), z);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final k0<T> a(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false);
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final k0<T> a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.f.f(this, j2, timeUnit, j0Var, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> a(i iVar) {
        g.a.y0.b.b.a(iVar, "other is null");
        return g.a.c1.a.a(new g.a.y0.e.f.g(this, iVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> k0<T> a(g0<U> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return g.a.c1.a.a(new g.a.y0.e.f.h(this, g0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> k0<T> a(i.d.b<U> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return g.a.c1.a.a(new g.a.y0.e.f.i(this, bVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> a(g.a.x0.g<? super T> gVar) {
        g.a.y0.b.b.a(gVar, "doAfterSuccess is null");
        return g.a.c1.a.a(new g.a.y0.e.f.l(this, gVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> a(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onAfterTerminate is null");
        return g.a.c1.a.a(new g.a.y0.e.f.m(this, aVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> a(g.a.x0.b<? super T, ? super Throwable> bVar) {
        g.a.y0.b.b.a(bVar, "onEvent is null");
        return g.a.c1.a.a(new g.a.y0.e.f.q(this, bVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new g.a.y0.e.c.y(this, rVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> k0<R> a(g.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new g.a.y0.e.f.v(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> k0<R> a(p0<? extends R, ? super T> p0Var) {
        g.a.y0.b.b.a(p0Var, "onLift is null");
        return g.a.c1.a.a(new g.a.y0.e.f.g0(this, p0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> a(Object obj) {
        return a(obj, g.a.y0.b.b.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> a(Object obj, g.a.x0.d<Object, Object> dVar) {
        g.a.y0.b.b.a(obj, "value is null");
        g.a.y0.b.b.a(dVar, "comparer is null");
        return g.a.c1.a.a(new g.a.y0.e.f.c(this, obj, dVar));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final k0<T> a(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.f.j0(this, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> a(k0<? extends T> k0Var) {
        g.a.y0.b.b.a(k0Var, "resumeSingleInCaseOfError is null");
        return i(g.a.y0.b.a.c(k0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(long j2) {
        return m().d(j2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(g.a.x0.e eVar) {
        return m().a(eVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> a(g.a.x0.d<? super Integer, ? super Throwable> dVar) {
        return a((l) m().b(dVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2) {
        g.a.y0.b.b.a(gVar, "onSuccess is null");
        g.a.y0.b.b.a(gVar2, "onError is null");
        g.a.y0.d.k kVar = new g.a.y0.d.k(gVar, gVar2);
        a((n0) kVar);
        return kVar;
    }

    @Override // g.a.q0
    @g.a.t0.h("none")
    public final void a(n0<? super T> n0Var) {
        g.a.y0.b.b.a(n0Var, "subscriber is null");
        n0<? super T> n0VarA = g.a.c1.a.a(this, n0Var);
        g.a.y0.b.b.a(n0VarA, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            b((n0) n0VarA);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final k0<T> a(long j2, TimeUnit timeUnit, j0 j0Var, q0<? extends T> q0Var) {
        g.a.y0.b.b.a(q0Var, "other is null");
        return b(j2, timeUnit, j0Var, q0Var);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final k0<T> a(long j2, TimeUnit timeUnit, q0<? extends T> q0Var) {
        g.a.y0.b.b.a(q0Var, "other is null");
        return b(j2, timeUnit, g.a.e1.a.a(), q0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> k0<R> a(q0<U> q0Var, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        return a(this, q0Var, cVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.a1.n<T> a(boolean z) {
        g.a.a1.n<T> nVar = new g.a.a1.n<>();
        if (z) {
            nVar.cancel();
        }
        a((n0) nVar);
        return nVar;
    }

    private static <T> k0<T> a(l<T> lVar) {
        return g.a.c1.a.a(new l3(lVar, null));
    }
}
