package g.a;

import g.a.y0.e.b.a3;
import g.a.y0.e.b.a4;
import g.a.y0.e.b.b1;
import g.a.y0.e.b.b2;
import g.a.y0.e.b.b3;
import g.a.y0.e.b.b4;
import g.a.y0.e.b.c1;
import g.a.y0.e.b.c2;
import g.a.y0.e.b.c3;
import g.a.y0.e.b.c4;
import g.a.y0.e.b.d1;
import g.a.y0.e.b.d2;
import g.a.y0.e.b.d3;
import g.a.y0.e.b.d4;
import g.a.y0.e.b.e1;
import g.a.y0.e.b.e2;
import g.a.y0.e.b.e3;
import g.a.y0.e.b.e4;
import g.a.y0.e.b.f1;
import g.a.y0.e.b.f2;
import g.a.y0.e.b.f3;
import g.a.y0.e.b.f4;
import g.a.y0.e.b.g1;
import g.a.y0.e.b.g2;
import g.a.y0.e.b.g4;
import g.a.y0.e.b.h3;
import g.a.y0.e.b.i1;
import g.a.y0.e.b.i2;
import g.a.y0.e.b.i3;
import g.a.y0.e.b.i4;
import g.a.y0.e.b.j1;
import g.a.y0.e.b.j2;
import g.a.y0.e.b.j4;
import g.a.y0.e.b.k1;
import g.a.y0.e.b.k2;
import g.a.y0.e.b.k3;
import g.a.y0.e.b.k4;
import g.a.y0.e.b.l1;
import g.a.y0.e.b.l2;
import g.a.y0.e.b.l3;
import g.a.y0.e.b.l4;
import g.a.y0.e.b.m1;
import g.a.y0.e.b.m2;
import g.a.y0.e.b.m3;
import g.a.y0.e.b.m4;
import g.a.y0.e.b.n1;
import g.a.y0.e.b.n2;
import g.a.y0.e.b.n3;
import g.a.y0.e.b.n4;
import g.a.y0.e.b.o1;
import g.a.y0.e.b.o2;
import g.a.y0.e.b.o3;
import g.a.y0.e.b.o4;
import g.a.y0.e.b.p1;
import g.a.y0.e.b.p3;
import g.a.y0.e.b.p4;
import g.a.y0.e.b.q1;
import g.a.y0.e.b.q2;
import g.a.y0.e.b.q3;
import g.a.y0.e.b.q4;
import g.a.y0.e.b.r1;
import g.a.y0.e.b.r2;
import g.a.y0.e.b.r3;
import g.a.y0.e.b.r4;
import g.a.y0.e.b.s0;
import g.a.y0.e.b.s1;
import g.a.y0.e.b.s2;
import g.a.y0.e.b.s3;
import g.a.y0.e.b.s4;
import g.a.y0.e.b.t0;
import g.a.y0.e.b.t1;
import g.a.y0.e.b.t3;
import g.a.y0.e.b.t4;
import g.a.y0.e.b.u0;
import g.a.y0.e.b.u1;
import g.a.y0.e.b.u2;
import g.a.y0.e.b.u3;
import g.a.y0.e.b.v0;
import g.a.y0.e.b.v1;
import g.a.y0.e.b.v2;
import g.a.y0.e.b.v3;
import g.a.y0.e.b.w0;
import g.a.y0.e.b.w1;
import g.a.y0.e.b.w2;
import g.a.y0.e.b.w3;
import g.a.y0.e.b.x1;
import g.a.y0.e.b.x2;
import g.a.y0.e.b.x3;
import g.a.y0.e.b.y0;
import g.a.y0.e.b.y1;
import g.a.y0.e.b.y2;
import g.a.y0.e.b.z0;
import g.a.y0.e.b.z1;
import g.a.y0.e.b.z2;
import g.a.y0.e.b.z3;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Flowable.java */
/* loaded from: classes2.dex */
public abstract class l<T> implements i.d.b<T> {

    /* renamed from: a, reason: collision with root package name */
    static final int f13848a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int Q() {
        return f13848a;
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> R() {
        return g.a.c1.a.a(t0.f14621b);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> S() {
        return g.a.c1.a.a(c2.f14151b);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(i.d.b<? extends T>... bVarArr) {
        g.a.y0.b.b.a(bVarArr, "sources is null");
        int length = bVarArr.length;
        return length == 0 ? R() : length == 1 ? q(bVarArr[0]) : g.a.c1.a.a(new g.a.y0.e.b.h(bVarArr, null));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(Iterable<? extends i.d.b<? extends T>> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.b.h(null, iterable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> c(i.d.b<? extends T>[] bVarArr, g.a.x0.o<? super Object[], ? extends R> oVar) {
        return b(bVarArr, oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> d(i.d.b<? extends T>... bVarArr) {
        return a(Q(), Q(), bVarArr);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> e(Iterable<? extends i.d.b<? extends T>> iterable) {
        return a(iterable, Q(), Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> f(Callable<? extends T> callable) {
        g.a.y0.b.b.a(callable, "supplier is null");
        return g.a.c1.a.a((l) new e1(callable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> g(Iterable<? extends i.d.b<? extends T>> iterable) {
        return f((Iterable) iterable).i(g.a.y0.b.a.e());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> h(Iterable<? extends i.d.b<? extends T>> iterable) {
        return f((Iterable) iterable).b(g.a.y0.b.a.e(), true);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> k(g.a.x0.g<k<T>> gVar) {
        g.a.y0.b.b.a(gVar, "generator is null");
        return a(g.a.y0.b.a.h(), p1.a(gVar), g.a.y0.b.a.d());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> l(T t) {
        g.a.y0.b.b.a((Object) t, "item is null");
        return g.a.c1.a.a((l) new t1(t));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> n(i.d.b<? extends i.d.b<? extends T>> bVar) {
        return c(bVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> o(i.d.b<? extends i.d.b<? extends T>> bVar) {
        return a((i.d.b) bVar, Q(), true);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> p(i.d.b<? extends i.d.b<? extends T>> bVar) {
        return a(bVar, Q(), Q());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> q(i.d.b<? extends T> bVar) {
        if (bVar instanceof l) {
            return g.a.c1.a.a((l) bVar);
        }
        g.a.y0.b.b.a(bVar, "publisher is null");
        return g.a.c1.a.a(new i1(bVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> r(i.d.b<? extends i.d.b<? extends T>> bVar) {
        return d(bVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> s(i.d.b<? extends i.d.b<? extends T>> bVar) {
        return e(bVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> t(i.d.b<? extends i.d.b<? extends T>> bVar) {
        return q(bVar).v(g.a.y0.b.a.e());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> u(i.d.b<? extends i.d.b<? extends T>> bVar) {
        return g(bVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.NONE)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> v(i.d.b<T> bVar) {
        g.a.y0.b.b.a(bVar, "onSubscribe is null");
        if (bVar instanceof l) {
            throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
        }
        return g.a.c1.a.a(new i1(bVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> A() {
        return d(h.q2.t.m0.f16408b);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.w0.a<T> B() {
        return x2.a((l) this);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> C() {
        return a(h.q2.t.m0.f16408b, g.a.y0.b.a.b());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> D() {
        return g.a.c1.a.a(new i3(this));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> E() {
        return z().V();
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> F() {
        return g.a.c1.a.a(new k3(this));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> G() {
        return g.a.c1.a.a(new l3(this, null));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> H() {
        return N().m().o(g.a.y0.b.a.a(g.a.y0.b.a.f())).k((g.a.x0.o<? super R, ? extends Iterable<? extends U>>) g.a.y0.b.a.e());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.h("none")
    public final g.a.u0.c I() {
        return a((g.a.x0.g) g.a.y0.b.a.d(), (g.a.x0.g<? super Throwable>) g.a.y0.b.a.f13902f, g.a.y0.b.a.f13899c, (g.a.x0.g<? super i.d.d>) p1.i.INSTANCE);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.g1.f<T> J() {
        g.a.g1.f<T> fVar = new g.a.g1.f<>();
        a((q) fVar);
        return fVar;
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<g.a.e1.c<T>> K() {
        return a(TimeUnit.MILLISECONDS, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<g.a.e1.c<T>> L() {
        return b(TimeUnit.MILLISECONDS, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final Future<T> M() {
        return (Future) e((l<T>) new g.a.y0.h.i());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> N() {
        return g.a.c1.a.a(new i4(this));
    }

    @g.a.t0.b(g.a.t0.a.NONE)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> O() {
        return g.a.c1.a.a(new g.a.y0.e.d.e1(this));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> P() {
        return b((Comparator) g.a.y0.b.a.f());
    }

    protected abstract void d(i.d.c<? super T> cVar);

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Long> i() {
        return g.a.c1.a.a(new g.a.y0.e.b.b0(this));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T2> l<T2> j() {
        return g.a.c1.a.a(new g.a.y0.e.b.i0(this));
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> m() {
        return a(0L);
    }

    @Override // i.d.b
    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.h("none")
    public final void subscribe(i.d.c<? super T> cVar) {
        if (cVar instanceof q) {
            a((q) cVar);
        } else {
            g.a.y0.b.b.a(cVar, "s is null");
            a((q) new g.a.y0.h.t(cVar));
        }
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> w() {
        return g.a.c1.a.a(new i2(this));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> x() {
        return g.a.c1.a.a(new g.a.y0.e.b.j0(this));
    }

    @g.a.t0.h("none")
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.c
    public final g.a.b1.b<T> y() {
        return g.a.b1.b.a(this);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.w0.a<T> z() {
        return f(Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> c(Iterable<? extends i.d.b<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar) {
        return b(iterable, oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> d(Iterable<? extends i.d.b<? extends T>> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return f((Iterable) iterable).b(g.a.y0.b.a.e());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> e(Callable<? extends Throwable> callable) {
        g.a.y0.b.b.a(callable, "errorSupplier is null");
        return g.a.c1.a.a(new u0(callable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> g(i.d.b<? extends i.d.b<? extends T>> bVar, int i2) {
        return q(bVar).h(g.a.y0.b.a.e(), i2);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static l<Long> p(long j2, TimeUnit timeUnit) {
        return d(j2, j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> k0<Map<K, Collection<T>>> A(g.a.x0.o<? super T, ? extends K> oVar) {
        return (k0<Map<K, Collection<T>>>) a((g.a.x0.o) oVar, (g.a.x0.o) g.a.y0.b.a.e(), (Callable) g.a.y0.j.m.asCallable(), (g.a.x0.o) g.a.y0.j.b.asFunction());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> h() {
        return c(16);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> i(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar) {
        return a((g.a.x0.o) oVar, false, Q(), Q());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final c j(g.a.x0.o<? super T, ? extends i> oVar) {
        return b((g.a.x0.o) oVar, false, Integer.MAX_VALUE);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> m(g.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        return d((g.a.x0.o) oVar, false, Integer.MAX_VALUE);
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> n() {
        return b(0L);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> o() {
        return g.a.c1.a.a(new m1(this));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> r() {
        return g.a.c1.a.a(new u1(this));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> s() {
        return g.a.c1.a.a(new v1(this, null));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<a0<T>> t() {
        return g.a.c1.a.a(new b2(this));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> u() {
        return a(Q(), false, true);
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> w(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar) {
        return h(oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <V> l<T> x(g.a.x0.o<? super T, ? extends i.d.b<V>> oVar) {
        return b((i.d.b) null, oVar, (i.d.b) null);
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> R y(g.a.x0.o<? super l<T>, R> oVar) {
        try {
            return (R) ((g.a.x0.o) g.a.y0.b.b.a(oVar, "converter is null")).apply(this);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            throw g.a.y0.j.k.c(th);
        }
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> k0<Map<K, T>> z(g.a.x0.o<? super T, ? extends K> oVar) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        return (k0<Map<K, T>>) a((Callable) g.a.y0.j.m.asCallable(), (g.a.x0.b) g.a.y0.b.a.a((g.a.x0.o) oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> b(i.d.b<? extends T>[] bVarArr, g.a.x0.o<? super Object[], ? extends R> oVar) {
        return a(bVarArr, oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(Iterable<? extends i.d.b<? extends T>> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return f((Iterable) iterable).a(g.a.y0.b.a.e(), 2, false);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> f(Iterable<? extends T> iterable) {
        g.a.y0.b.b.a(iterable, "source is null");
        return g.a.c1.a.a(new g1(iterable));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public static l<Long> p(long j2, TimeUnit timeUnit, j0 j0Var) {
        return d(j2, j2, timeUnit, j0Var);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.h("none")
    public final void g() {
        g.a.y0.e.b.l.a(this);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> l<T> h(g.a.x0.o<? super T, K> oVar) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        return g.a.c1.a.a(new g.a.y0.e.b.l0(this, oVar, g.a.y0.b.b.a()));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> i(g.a.x0.g<? super T> gVar) {
        g.a.y0.b.b.a(gVar, "onDrop is null");
        return g.a.c1.a.a((l) new g2(this, gVar));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> j(T t) {
        g.a.y0.b.b.a((Object) t, "defaultItem is null");
        return g.a.c1.a.a(new l3(this, t));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> l() {
        return h((g.a.x0.o) g.a.y0.b.a.e());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> m(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> l<g.a.w0.b<K, T>> n(g.a.x0.o<? super T, ? extends K> oVar) {
        return (l<g.a.w0.b<K, T>>) a((g.a.x0.o) oVar, (g.a.x0.o) g.a.y0.b.a.e(), false, Q());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> o(g.a.x0.o<? super T, ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new y1(this, oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> r(g.a.x0.o<? super l<T>, ? extends i.d.b<R>> oVar) {
        return e(oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> s(g.a.x0.o<? super l<Object>, ? extends i.d.b<?>> oVar) {
        g.a.y0.b.b.a(oVar, "handler is null");
        return g.a.c1.a.a(new w2(this, oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> t(g.a.x0.o<? super l<T>, ? extends i.d.b<R>> oVar) {
        g.a.y0.b.b.a(oVar, "selector is null");
        return x2.a(p1.a(this), (g.a.x0.o) oVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> u(g.a.x0.o<? super l<Throwable>, ? extends i.d.b<?>> oVar) {
        g.a.y0.b.b.a(oVar, "handler is null");
        return g.a.c1.a.a(new a3(this, oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> b(Iterable<? extends i.d.b<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar) {
        return a(iterable, oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> d(Callable<? extends i.d.b<? extends T>> callable) {
        g.a.y0.b.b.a(callable, "supplier is null");
        return g.a.c1.a.a(new g.a.y0.e.b.f0(callable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> e(i.d.b<? extends T>... bVarArr) {
        return b((Object[]) bVarArr).c(g.a.y0.b.a.e(), bVarArr.length);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> l<T> g(g.a.x0.o<? super T, K> oVar) {
        return a((g.a.x0.o) oVar, (Callable) g.a.y0.b.a.c());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> l(g.a.x0.o<? super T, ? extends y<? extends R>> oVar) {
        return c((g.a.x0.o) oVar, false, Integer.MAX_VALUE);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> m(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> n(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, (i.d.b) null, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final c p() {
        return g.a.c1.a.a(new o1(this));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> b(g.a.x0.o<? super Object[], ? extends R> oVar, i.d.b<? extends T>... bVarArr) {
        return b(bVarArr, oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(i.d.b<? extends i.d.b<? extends T>> bVar, int i2) {
        return q(bVar).a(g.a.y0.b.a.e(), i2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> e(i.d.b<? extends i.d.b<? extends T>> bVar, int i2) {
        return q(bVar).a(g.a.y0.b.a.e(), true, i2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> f(i.d.b<? extends T>... bVarArr) {
        return b((Object[]) bVarArr).a(g.a.y0.b.a.e(), true, bVarArr.length);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static l<Long> q(long j2, TimeUnit timeUnit) {
        return q(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> g(g.a.x0.g<? super i.d.d> gVar) {
        return a(gVar, g.a.y0.b.a.f13903g, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.NONE)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c h(g.a.x0.g<? super T> gVar) {
        return j((g.a.x0.g) gVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> i(T t) {
        g.a.y0.b.b.a((Object) t, "item is null");
        return q(g.a.y0.b.a.c(t));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> j(i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return b(bVar, this);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<T> l(i.d.b<U> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return g.a.c1.a.a(new z3(this, bVar));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> l<l<T>> m(i.d.b<B> bVar) {
        return b(bVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> n(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, (i.d.b) null, j0Var);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<l<T>> o(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.a(), h.q2.t.m0.f16408b, false);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> p(g.a.x0.o<? super Throwable, ? extends i.d.b<? extends T>> oVar) {
        g.a.y0.b.b.a(oVar, "resumeFunction is null");
        return g.a.c1.a.a(new j2(this, oVar, false));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> v() {
        return g.a.c1.a.a((l) new g2(this));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> a(g.a.x0.o<? super Object[], ? extends R> oVar, i.d.b<? extends T>... bVarArr) {
        return a(bVarArr, oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> b(i.d.b<? extends T>[] bVarArr, g.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        g.a.y0.b.b.a(bVarArr, "sources is null");
        g.a.y0.b.b.a(oVar, "combiner is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        if (bVarArr.length == 0) {
            return R();
        }
        return g.a.c1.a.a(new g.a.y0.e.b.u((i.d.b[]) bVarArr, (g.a.x0.o) oVar, i2, true));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(i.d.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return R();
        }
        if (bVarArr.length == 1) {
            return q(bVarArr[0]);
        }
        return g.a.c1.a.a(new g.a.y0.e.b.v(bVarArr, true));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static l<Long> d(long j2, long j3, TimeUnit timeUnit) {
        return d(j2, j3, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> f(i.d.b<? extends i.d.b<? extends T>> bVar, int i2) {
        return q(bVar).g(g.a.y0.b.a.e(), i2);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public static l<Long> q(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g4(Math.max(0L, j2), timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final Iterable<T> e() {
        return new g.a.y0.e.b.e(this);
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> g(T t) {
        return a(0L, (long) t);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> h(T t) {
        g.a.y0.b.b.a((Object) t, "defaultItem");
        return g.a.c1.a.a(new v1(this, t));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> k() {
        return a((g.a.x0.o) g.a.y0.b.a.e(), (Callable) g.a.y0.b.a.c());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<l<T>> o(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, h.q2.t.m0.f16408b, false);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> v(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar) {
        return g(oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> a(i.d.b<? extends T>[] bVarArr, g.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        g.a.y0.b.b.a(bVarArr, "sources is null");
        if (bVarArr.length == 0) {
            return R();
        }
        g.a.y0.b.b.a(oVar, "combiner is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new g.a.y0.e.b.u((i.d.b[]) bVarArr, (g.a.x0.o) oVar, i2, false));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public static l<Long> d(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new q1(Math.max(0L, j2), Math.max(0L, j3), timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> e(Object obj) {
        g.a.y0.b.b.a(obj, "item is null");
        return b((g.a.x0.r) g.a.y0.b.a.a(obj));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final T f() {
        return G().d();
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> g(i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "next is null");
        return g.a.c1.a.a(new j2(this, g.a.y0.b.a.c(bVar), true));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> i(int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return g.a.c1.a.a(this);
            }
            return g.a.c1.a.a(new n3(this, i2));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c j(g.a.x0.g<? super T> gVar) {
        return a((g.a.x0.g) gVar, (g.a.x0.g<? super Throwable>) g.a.y0.b.a.f13902f, g.a.y0.b.a.f13899c, (g.a.x0.g<? super i.d.d>) p1.i.INSTANCE);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<U> k(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return d(oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> l(long j2, TimeUnit timeUnit) {
        return f(j2, timeUnit);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> f(T t) {
        g.a.y0.b.b.a((Object) t, "item is null");
        return k((i.d.b) l(t));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.w0.a<T> h(int i2) {
        g.a.y0.b.b.a(i2, "bufferSize");
        return x2.a((l) this, i2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> j(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        }
        if (i2 == 0) {
            return g.a.c1.a.a(new n1(this));
        }
        if (i2 == 1) {
            return g.a.c1.a.a(new w3(this));
        }
        return g.a.c1.a.a(new v3(this, i2));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> k(T t) {
        g.a.y0.b.b.a((Object) t, "item is null");
        return b(l(t), this);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> l(long j2, TimeUnit timeUnit, j0 j0Var) {
        return f(j2, timeUnit, j0Var);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<T> e(g.a.x0.o<? super T, ? extends i.d.b<U>> oVar) {
        g.a.y0.b.b.a(oVar, "debounceIndicator is null");
        return g.a.c1.a.a(new g.a.y0.e.b.d0(this, oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> g(int i2) {
        return a(g.a.y0.g.e.f15926b, true, i2);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> l(int i2) {
        return a(g.a.y0.b.a.f(), i2);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> q() {
        return a((g.a.x0.r) g.a.y0.b.a.a());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> d(i.d.b<? extends i.d.b<? extends T>> bVar, int i2) {
        return q(bVar).c(g.a.y0.b.a.e(), i2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<T> f(g.a.x0.o<? super T, ? extends i.d.b<U>> oVar) {
        g.a.y0.b.b.a(oVar, "itemDelayIndicator is null");
        return (l<T>) i((g.a.x0.o) p1.b(oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> g(long j2, TimeUnit timeUnit) {
        return i((i.d.b) q(j2, timeUnit));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<T> h(i.d.b<U> bVar) {
        g.a.y0.b.b.a(bVar, "sampler is null");
        return g.a.c1.a.a(new b3(this, bVar, false));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<T> i(i.d.b<U> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return g.a.c1.a.a(new p3(this, bVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> k(i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return g.a.c1.a.a(new s3(this, bVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> q(g.a.x0.o<? super Throwable, ? extends T> oVar) {
        g.a.y0.b.b.a(oVar, "valueSupplier is null");
        return g.a.c1.a.a(new k2(this, oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, S> l<T> c(Callable<S> callable, g.a.x0.c<S, k<T>, S> cVar) {
        return a((Callable) callable, (g.a.x0.c) cVar, g.a.y0.b.a.d());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> d(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2) {
        return a(bVar, bVar2, g.a.y0.b.b.a(), Q());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> e(g.a.x0.g<? super Throwable> gVar) {
        g.a.x0.g<? super T> gVarD = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return a((g.a.x0.g) gVarD, gVar, aVar, aVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> g(long j2, TimeUnit timeUnit, j0 j0Var) {
        return i((i.d.b) q(j2, timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> b(Iterable<? extends i.d.b<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        g.a.y0.b.b.a(iterable, "sources is null");
        g.a.y0.b.b.a(oVar, "combiner is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new g.a.y0.e.b.u((Iterable) iterable, (g.a.x0.o) oVar, i2, true));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(Iterable<? extends i.d.b<? extends T>> iterable, int i2, int i3) {
        return f((Iterable) iterable).a(g.a.y0.b.a.e(), true, i2, i3);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> d(Iterable<? extends i.d.b<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "zipper is null");
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new s4(null, iterable, oVar, Q(), false));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> e(g.a.x0.a aVar) {
        return a((g.a.x0.g) g.a.y0.b.a.d(), g.a.y0.b.a.a(aVar), aVar, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> f(g.a.x0.g<? super T> gVar) {
        g.a.x0.g<? super Throwable> gVarD = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return a((g.a.x0.g) gVar, gVarD, aVar, aVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> g(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2) {
        return b((g.a.x0.o) oVar, i2, false);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> h(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.a(), false, Q());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> i(long j2, TimeUnit timeUnit) {
        return l((i.d.b) q(j2, timeUnit));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> j(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, g.a.e1.a.a(), false, Q());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> k(long j2, TimeUnit timeUnit) {
        return k(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> a(Iterable<? extends i.d.b<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        g.a.y0.b.b.a(iterable, "sources is null");
        g.a.y0.b.b.a(oVar, "combiner is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new g.a.y0.e.b.u((Iterable) iterable, (g.a.x0.o) oVar, i2, false));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(int i2, int i3, i.d.b<? extends T>... bVarArr) {
        return b((Object[]) bVarArr).a(g.a.y0.b.a.e(), true, i2, i3);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> e(i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return b(this, bVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> f(i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "next is null");
        return p(g.a.y0.b.a.c(bVar));
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> g(long j2) {
        if (j2 >= 0) {
            return g.a.c1.a.a(new u3(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> h(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false, Q());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> i(long j2, TimeUnit timeUnit, j0 j0Var) {
        return l((i.d.b) q(j2, timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> j(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var, false, Q());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> k(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new c4(this, j2, timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        return b((Object[]) new i.d.b[]{bVar, bVar2}).a(g.a.y0.b.a.e(), true, 2);
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> h(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2) {
        return b((g.a.x0.o) oVar, i2, true);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<l<T>> i(long j2) {
        return a(j2, j2, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> d(i.d.b<? extends i.d.b<? extends T>> bVar, g.a.x0.o<? super Object[], ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "zipper is null");
        return q(bVar).N().e(p1.c(oVar));
    }

    @g.a.t0.h("none")
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.c
    public final g.a.b1.b<T> e(int i2) {
        g.a.y0.b.b.a(i2, "parallelism");
        return g.a.b1.b.a(this, i2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.w0.a<T> f(int i2) {
        g.a.y0.b.b.a(i2, "bufferSize");
        return l2.a((l) this, i2);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> g(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "stopPredicate is null");
        return g.a.c1.a.a(new a4(this, rVar));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> h(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new b4(this, rVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(i.d.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return R();
        }
        if (bVarArr.length == 1) {
            return q(bVarArr[0]);
        }
        return g.a.c1.a.a(new g.a.y0.e.b.v(bVarArr, false));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> k(int i2) {
        g.a.y0.b.b.a(i2, "capacityHint");
        return g.a.c1.a.a(new i4(this, g.a.y0.b.a.a(i2)));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> a(g.a.x0.o<? super Object[], ? extends R> oVar, int i2, i.d.b<? extends T>... bVarArr) {
        return b(bVarArr, oVar, i2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2, i.d.b<? extends T> bVar3) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        return b((Object[]) new i.d.b[]{bVar, bVar2, bVar3}).a(g.a.y0.b.a.e(), true, 3);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final Iterable<T> d() {
        return new g.a.y0.e.b.c(this);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> e(g.a.x0.o<? super l<T>, ? extends i.d.b<? extends R>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new m2(this, oVar, i2, false));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> f(g.a.x0.o<? super l<T>, ? extends i.d.b<R>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return x2.a(p1.a(this, i2), (g.a.x0.o) oVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.g1.f<T> h(long j2) {
        g.a.g1.f<T> fVar = new g.a.g1.f<>(j2);
        a((q) fVar);
        return fVar;
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, R> l<R> a(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, g.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        return a(g.a.y0.b.a.a((g.a.x0.c) cVar), bVar, bVar2);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final T d(T t) {
        return j((l<T>) t).d();
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<U> d(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return b(oVar, 2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<T> d(i.d.b<U> bVar) {
        g.a.y0.b.b.a(bVar, "subscriptionIndicator is null");
        return g.a.c1.a.a(new g.a.y0.e.b.h0(this, bVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final g.a.w0.a<T> e(long j2, TimeUnit timeUnit) {
        return e(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> f(long j2, TimeUnit timeUnit) {
        return f(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(T... tArr) {
        g.a.y0.b.b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return R();
        }
        if (tArr.length == 1) {
            return l(tArr[0]);
        }
        return g.a.c1.a.a(new d1(tArr));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> c(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2, i.d.b<? extends T> bVar3, i.d.b<? extends T> bVar4) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        return b((Object[]) new i.d.b[]{bVar, bVar2, bVar3, bVar4}).a(g.a.y0.b.a.e(), true, 4);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final g.a.w0.a<T> e(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a(this, j2, timeUnit, j0Var);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> f(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new c3(this, j2, timeUnit, j0Var, false));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, R> l<R> a(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, g.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        return a(g.a.y0.b.a.a((g.a.x0.h) hVar), bVar, bVar2, bVar3);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> d(long j2, TimeUnit timeUnit) {
        return d(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> d(long j2, TimeUnit timeUnit, j0 j0Var) {
        return d((i.d.b) q(j2, timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> d(g.a.x0.a aVar) {
        return a((g.a.x0.g) g.a.y0.b.a.d(), g.a.y0.b.a.d(), aVar, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> e(long j2) {
        return a(j2, g.a.y0.b.a.b());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> f(long j2) {
        if (j2 <= 0) {
            return g.a.c1.a.a(this);
        }
        return g.a.c1.a.a(new m3(this, j2));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> d(g.a.x0.g<? super a0<T>> gVar) {
        g.a.y0.b.b.a(gVar, "consumer is null");
        return a((g.a.x0.g) g.a.y0.b.a.c((g.a.x0.g) gVar), (g.a.x0.g<? super Throwable>) g.a.y0.b.a.b((g.a.x0.g) gVar), g.a.y0.b.a.a((g.a.x0.g) gVar), g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> e(g.a.x0.r<? super Throwable> rVar) {
        return a(h.q2.t.m0.f16408b, rVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, R> l<R> a(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, g.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        return a(g.a.y0.b.a.a((g.a.x0.i) iVar), bVar, bVar2, bVar3, bVar4);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static l<Integer> c(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i3);
        }
        if (i3 == 0) {
            return R();
        }
        if (i3 == 1) {
            return l(Integer.valueOf(i2));
        }
        if (i2 + (i3 - 1) <= 2147483647L) {
            return g.a.c1.a.a(new n2(i2, i3));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <E extends i.d.c<? super T>> E e(E e2) {
        subscribe(e2);
        return e2;
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> f(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new q3(this, rVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, S> l<T> b(Callable<S> callable, g.a.x0.b<S, k<T>> bVar) {
        g.a.y0.b.b.a(bVar, "generator is null");
        return a((Callable) callable, p1.a(bVar), g.a.y0.b.a.d());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<g.a.e1.c<T>> e(j0 j0Var) {
        return b(TimeUnit.MILLISECONDS, j0Var);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> f(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new j4(this, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<U> d(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new c1(this, oVar, i2));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> l<R> a(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, i.d.b<? extends T5> bVar5, g.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        g.a.y0.b.b.a(bVar5, "source5 is null");
        return a(g.a.y0.b.a.a((g.a.x0.j) jVar), bVar, bVar2, bVar3, bVar4, bVar5);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(Iterable<? extends i.d.b<? extends T>> iterable, int i2, int i3) {
        return f((Iterable) iterable).a(g.a.y0.b.a.e(), false, i2, i3);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final T c() {
        g.a.y0.h.e eVar = new g.a.y0.h.e();
        a((q) eVar);
        T tA = eVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(int i2, int i3, i.d.b<? extends T>... bVarArr) {
        return b((Object[]) bVarArr).a(g.a.y0.b.a.e(), false, i2, i3);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        return b((Object[]) new i.d.b[]{bVar, bVar2}).a(g.a.y0.b.a.e(), false, 2);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> d(g.a.x0.o<? super T, ? extends q0<? extends R>> oVar, boolean z, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        return g.a.c1.a.a(new b1(this, oVar, z, i2));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final Iterable<T> c(T t) {
        return new g.a.y0.e.b.d(this, t);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2, i.d.b<? extends T> bVar3) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        return b((Object[]) new i.d.b[]{bVar, bVar2, bVar3}).a(g.a.y0.b.a.e(), false, 3);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> c(int i2) {
        g.a.y0.b.b.a(i2, "initialCapacity");
        return g.a.c1.a.a(new g.a.y0.e.b.r(this, i2));
    }

    @g.a.t0.b(g.a.t0.a.NONE)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c d(g.a.x0.r<? super T> rVar) {
        return a((g.a.x0.r) rVar, (g.a.x0.g<? super Throwable>) g.a.y0.b.a.f13902f, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> l<R> a(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, i.d.b<? extends T5> bVar5, i.d.b<? extends T6> bVar6, g.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        g.a.y0.b.b.a(bVar5, "source5 is null");
        g.a.y0.b.b.a(bVar6, "source6 is null");
        return a(g.a.y0.b.a.a((g.a.x0.k) kVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> d(int i2) {
        return a(i2, false, false);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> c(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar) {
        return a(oVar, Q(), Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> d(long j2) {
        if (j2 >= 0) {
            if (j2 == 0) {
                return R();
            }
            return g.a.c1.a.a(new u2(this, j2));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> c(i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return a((i.d.b) this, (i.d.b) bVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2, i.d.b<? extends T> bVar3, i.d.b<? extends T> bVar4) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        return b((Object[]) new i.d.b[]{bVar, bVar2, bVar3, bVar4}).a(g.a.y0.b.a.e(), false, 4);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> c(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.a(), false);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> d(long j2, TimeUnit timeUnit, boolean z) {
        return b(j2, timeUnit, g.a.e1.a.a(), z, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> c(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> d(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        return b(j2, timeUnit, j0Var, z, Q());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> c(g.a.x0.g<? super T> gVar) {
        g.a.y0.b.b.a(gVar, "onAfterNext is null");
        return g.a.c1.a.a(new g.a.y0.e.b.m0(this, gVar));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<g.a.e1.c<T>> d(j0 j0Var) {
        return a(TimeUnit.MILLISECONDS, j0Var);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> l<R> a(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, i.d.b<? extends T5> bVar5, i.d.b<? extends T6> bVar6, i.d.b<? extends T7> bVar7, g.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        g.a.y0.b.b.a(bVar5, "source5 is null");
        g.a.y0.b.b.a(bVar6, "source6 is null");
        g.a.y0.b.b.a(bVar7, "source7 is null");
        return a(g.a.y0.b.a.a((g.a.x0.l) lVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> b(Iterable<? extends i.d.b<? extends T>> iterable, int i2) {
        return f((Iterable) iterable).a(g.a.y0.b.a.e(), true, i2);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> c(g.a.x0.a aVar) {
        return a(g.a.y0.b.a.d(), g.a.y0.b.a.f13903g, aVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static l<Long> b(long j2, long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return R();
        }
        if (j3 == 1) {
            return l(Long.valueOf(j2));
        }
        long j4 = (j3 - 1) + j2;
        if (j2 > 0 && j4 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        return g.a.c1.a.a(new o2(j2, j3));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> c(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new v0(this, rVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> c(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2) {
        return a((g.a.x0.o) oVar, false, i2, Q());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> c(g.a.x0.o<? super T, ? extends y<? extends R>> oVar, boolean z, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        return g.a.c1.a.a(new z0(this, oVar, z, i2));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, R> l<R> b(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, g.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        return a(g.a.y0.b.a.a((g.a.x0.c) cVar), false, Q(), bVar, bVar2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> l<R> a(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, i.d.b<? extends T5> bVar5, i.d.b<? extends T6> bVar6, i.d.b<? extends T7> bVar7, i.d.b<? extends T8> bVar8, g.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        g.a.y0.b.b.a(bVar5, "source5 is null");
        g.a.y0.b.b.a(bVar6, "source6 is null");
        g.a.y0.b.b.a(bVar7, "source7 is null");
        g.a.y0.b.b.a(bVar8, "source8 is null");
        return a(g.a.y0.b.a.a((g.a.x0.m) mVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> l<g.a.w0.b<K, T>> c(g.a.x0.o<? super T, ? extends K> oVar, boolean z) {
        return (l<g.a.w0.b<K, T>>) a(oVar, g.a.y0.b.a.e(), z, Q());
    }

    @g.a.t0.e
    @g.a.t0.h("none")
    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    public final l<T> c(long j2) {
        if (j2 >= 0) {
            return g.a.c1.a.a(new x1(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, R> l<R> b(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, g.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        return a(g.a.y0.b.a.a((g.a.x0.h) hVar), false, Q(), bVar, bVar2, bVar3);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.h("none")
    public final void c(i.d.c<? super T> cVar) {
        g.a.y0.b.b.a(cVar, "s is null");
        if (cVar instanceof g.a.g1.d) {
            a((q) cVar);
        } else {
            a((q) new g.a.g1.d(cVar));
        }
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, R> l<R> b(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, g.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        return a(g.a.y0.b.a.a((g.a.x0.i) iVar), false, Q(), bVar, bVar2, bVar3, bVar4);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> c(long j2, TimeUnit timeUnit, boolean z) {
        return a(j2, timeUnit, g.a.e1.a.a(), z, Q());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> c(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        return a(j2, timeUnit, j0Var, z, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> l<R> a(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, i.d.b<? extends T5> bVar5, i.d.b<? extends T6> bVar6, i.d.b<? extends T7> bVar7, i.d.b<? extends T8> bVar8, i.d.b<? extends T9> bVar9, g.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        g.a.y0.b.b.a(bVar5, "source5 is null");
        g.a.y0.b.b.a(bVar6, "source6 is null");
        g.a.y0.b.b.a(bVar7, "source7 is null");
        g.a.y0.b.b.a(bVar8, "source8 is null");
        g.a.y0.b.b.a(bVar9, "source9 is null");
        return a(g.a.y0.b.a.a((g.a.x0.n) nVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> c(@g.a.t0.f j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return b(j0Var, !(this instanceof g.a.y0.e.b.c0));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> l<R> b(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, i.d.b<? extends T5> bVar5, g.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        g.a.y0.b.b.a(bVar5, "source5 is null");
        return a(g.a.y0.b.a.a((g.a.x0.j) jVar), false, Q(), bVar, bVar2, bVar3, bVar4, bVar5);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> c(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2) {
        return a((g.a.x0.o) oVar, (g.a.x0.o) oVar2, (Callable) g.a.y0.j.m.asCallable(), (g.a.x0.o) g.a.y0.j.b.asFunction());
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> c(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, Callable<Map<K, Collection<V>>> callable) {
        return a((g.a.x0.o) oVar, (g.a.x0.o) oVar2, (Callable) callable, (g.a.x0.o) g.a.y0.j.b.asFunction());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<l<T>> c(long j2, long j3, TimeUnit timeUnit) {
        return a(j2, j3, timeUnit, g.a.e1.a.a(), Q());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<l<T>> c(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, j3, timeUnit, j0Var, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> l<R> b(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, i.d.b<? extends T5> bVar5, i.d.b<? extends T6> bVar6, g.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        g.a.y0.b.b.a(bVar5, "source5 is null");
        g.a.y0.b.b.a(bVar6, "source6 is null");
        return a(g.a.y0.b.a.a((g.a.x0.k) kVar), false, Q(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> l<l<T>> c(i.d.b<U> bVar, g.a.x0.o<? super U, ? extends i.d.b<V>> oVar) {
        return a(bVar, oVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> l<l<T>> c(Callable<? extends i.d.b<B>> callable) {
        return a(callable, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        return b(bVar, bVar2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2, i.d.b<? extends T> bVar3) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        return b(bVar, bVar2, bVar3);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> l<R> b(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, i.d.b<? extends T5> bVar5, i.d.b<? extends T6> bVar6, i.d.b<? extends T7> bVar7, g.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        g.a.y0.b.b.a(bVar5, "source5 is null");
        g.a.y0.b.b.a(bVar6, "source6 is null");
        g.a.y0.b.b.a(bVar7, "source7 is null");
        return a(g.a.y0.b.a.a((g.a.x0.l) lVar), false, Q(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2, i.d.b<? extends T> bVar3, i.d.b<? extends T> bVar4) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        return b(bVar, bVar2, bVar3, bVar4);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(int i2, int i3, i.d.b<? extends T>... bVarArr) {
        g.a.y0.b.b.a(bVarArr, "sources is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.b.x(new d1(bVarArr), g.a.y0.b.a.e(), i2, i3, g.a.y0.j.j.IMMEDIATE));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> l<R> b(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, i.d.b<? extends T5> bVar5, i.d.b<? extends T6> bVar6, i.d.b<? extends T7> bVar7, i.d.b<? extends T8> bVar8, g.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        g.a.y0.b.b.a(bVar5, "source5 is null");
        g.a.y0.b.b.a(bVar6, "source6 is null");
        g.a.y0.b.b.a(bVar7, "source7 is null");
        g.a.y0.b.b.a(bVar8, "source8 is null");
        return a(g.a.y0.b.a.a((g.a.x0.m) mVar), false, Q(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(i.d.b<? extends i.d.b<? extends T>> bVar, int i2, boolean z) {
        return q(bVar).a(g.a.y0.b.a.e(), i2, z);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(i.d.b<? extends i.d.b<? extends T>> bVar, int i2, int i3) {
        g.a.y0.b.b.a(bVar, "sources is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.b.y(bVar, g.a.y0.b.a.e(), i2, i3, g.a.y0.j.j.IMMEDIATE));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(Iterable<? extends i.d.b<? extends T>> iterable, int i2, int i3) {
        g.a.y0.b.b.a(iterable, "sources is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.b.x(new g1(iterable), g.a.y0.b.a.e(), i2, i3, g.a.y0.j.j.IMMEDIATE));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> l<R> b(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, i.d.b<? extends T3> bVar3, i.d.b<? extends T4> bVar4, i.d.b<? extends T5> bVar5, i.d.b<? extends T6> bVar6, i.d.b<? extends T7> bVar7, i.d.b<? extends T8> bVar8, i.d.b<? extends T9> bVar9, g.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        g.a.y0.b.b.a(bVar5, "source5 is null");
        g.a.y0.b.b.a(bVar6, "source6 is null");
        g.a.y0.b.b.a(bVar7, "source7 is null");
        g.a.y0.b.b.a(bVar8, "source8 is null");
        g.a.y0.b.b.a(bVar9, "source9 is null");
        return a(g.a.y0.b.a.a((g.a.x0.n) nVar), false, Q(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9);
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(o<T> oVar, b bVar) {
        g.a.y0.b.b.a(oVar, "source is null");
        g.a.y0.b.b.a(bVar, "mode is null");
        return g.a.c1.a.a(new g.a.y0.e.b.c0(oVar, bVar));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(Throwable th) {
        g.a.y0.b.b.a(th, "throwable is null");
        return e((Callable<? extends Throwable>) g.a.y0.b.a.b(th));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(Future<? extends T> future) {
        g.a.y0.b.b.a(future, "future is null");
        return g.a.c1.a.a(new f1(future, 0L, null));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        g.a.y0.b.b.a(future, "future is null");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        return g.a.c1.a.a(new f1(future, j2, timeUnit));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> b(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new g.a.y0.e.b.j(this, rVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final Iterable<T> b() {
        return a(Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public static <T> l<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return a(future, j2, timeUnit).c(j0Var);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final T b(T t) {
        g.a.y0.h.e eVar = new g.a.y0.h.e();
        a((q) eVar);
        T tA = eVar.a();
        return tA != null ? tA : t;
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public static <T> l<T> a(Future<? extends T> future, j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return a((Future) future).c(j0Var);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.h("none")
    public final void b(g.a.x0.g<? super T> gVar) {
        g.a.y0.e.b.l.a(this, gVar, g.a.y0.b.a.f13902f, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, S> l<T> a(Callable<S> callable, g.a.x0.b<S, k<T>> bVar, g.a.x0.g<? super S> gVar) {
        g.a.y0.b.b.a(bVar, "generator is null");
        return a((Callable) callable, p1.a(bVar), (g.a.x0.g) gVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<List<T>> b(int i2) {
        return a(i2, i2);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> l<List<T>> b(i.d.b<B> bVar) {
        return (l<List<T>>) a((i.d.b) bVar, (Callable) g.a.y0.j.b.asCallable());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, S> l<T> a(Callable<S> callable, g.a.x0.c<S, k<T>, S> cVar, g.a.x0.g<? super S> gVar) {
        g.a.y0.b.b.a(callable, "initialState is null");
        g.a.y0.b.b.a(cVar, "generator is null");
        g.a.y0.b.b.a(gVar, "disposeState is null");
        return g.a.c1.a.a(new j1(callable, cVar, gVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> b(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar) {
        return a((g.a.x0.o) oVar, 2, true);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<U> b(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new c1(this, oVar, i2));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static l<Long> a(long j2, long j3, long j4, long j5, TimeUnit timeUnit) {
        return a(j2, j3, j4, j5, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> b(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public static l<Long> a(long j2, long j3, long j4, long j5, TimeUnit timeUnit, j0 j0Var) {
        if (j3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return R().c(j4, timeUnit, j0Var);
        }
        long j6 = j2 + (j3 - 1);
        if (j2 > 0 && j6 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new r1(j2, j6, Math.max(0L, j4), Math.max(0L, j5), timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> b(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.b.e0(this, j2, timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> b(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onFinally is null");
        return g.a.c1.a.a(new g.a.y0.e.b.n0(this, aVar));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> b(i.d.c<? super T> cVar) {
        g.a.y0.b.b.a(cVar, "subscriber is null");
        return a((g.a.x0.g) p1.c(cVar), (g.a.x0.g<? super Throwable>) p1.b(cVar), p1.a(cVar), g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(T t, T t2) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        return b(t, t2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        return b(t, t2, t3);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> b(long j2) {
        if (j2 >= 0) {
            return g.a.c1.a.a(new s0(this, j2, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> b(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, boolean z) {
        return a(oVar, z, Q(), Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        return b(t, t2, t3, t4);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final c b(g.a.x0.o<? super T, ? extends i> oVar, boolean z, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        return g.a.c1.a.a(new y0(this, oVar, z, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> l<V> b(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends V> cVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(cVar, "resultSelector is null");
        return (l<V>) a((g.a.x0.o) p1.a(oVar), (g.a.x0.c) cVar, false, Q(), Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        g.a.y0.b.b.a((Object) t5, "The fifth item is null");
        return b(t, t2, t3, t4, t5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> l<V> b(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends V> cVar, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(cVar, "resultSelector is null");
        return (l<V>) a((g.a.x0.o) p1.a(oVar), (g.a.x0.c) cVar, false, Q(), i2);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <TRight, TLeftEnd, TRightEnd, R> l<R> b(i.d.b<? extends TRight> bVar, g.a.x0.o<? super T, ? extends i.d.b<TLeftEnd>> oVar, g.a.x0.o<? super TRight, ? extends i.d.b<TRightEnd>> oVar2, g.a.x0.c<? super T, ? super TRight, ? extends R> cVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        g.a.y0.b.b.a(oVar, "leftEnd is null");
        g.a.y0.b.b.a(oVar2, "rightEnd is null");
        g.a.y0.b.b.a(cVar, "resultSelector is null");
        return g.a.c1.a.a(new s1(this, bVar, oVar, oVar2, cVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5, T t6) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        g.a.y0.b.b.a((Object) t5, "The fifth item is null");
        g.a.y0.b.b.a((Object) t6, "The sixth item is null");
        return b(t, t2, t3, t4, t5, t6);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<U> b(Class<U> cls) {
        g.a.y0.b.b.a(cls, "clazz is null");
        return c((g.a.x0.r) g.a.y0.b.a.b((Class) cls)).a((Class) cls);
    }

    @g.a.t0.h("none")
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.c
    public final g.a.b1.b<T> b(int i2, int i3) {
        g.a.y0.b.b.a(i2, "parallelism");
        g.a.y0.b.b.a(i3, "prefetch");
        return g.a.b1.b.a(this, i2, i3);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        g.a.y0.b.b.a((Object) t5, "The fifth item is null");
        g.a.y0.b.b.a((Object) t6, "The sixth item is null");
        g.a.y0.b.b.a((Object) t7, "The seventh item is null");
        return b(t, t2, t3, t4, t5, t6, t7);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final g.a.w0.a<T> b(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a((g.a.w0.a) B(), j0Var);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> b(g.a.x0.d<? super Integer, ? super Throwable> dVar) {
        g.a.y0.b.b.a(dVar, "predicate is null");
        return g.a.c1.a.a(new y2(this, dVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> b(g.a.x0.e eVar) {
        g.a.y0.b.b.a(eVar, "stop is null");
        return a(h.q2.t.m0.f16408b, g.a.y0.b.a.a(eVar));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> b(long j2, TimeUnit timeUnit, boolean z) {
        return b(j2, timeUnit, g.a.e1.a.a(), z);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        g.a.y0.b.b.a((Object) t5, "The fifth item is null");
        g.a.y0.b.b.a((Object) t6, "The sixth item is null");
        g.a.y0.b.b.a((Object) t7, "The seventh item is null");
        g.a.y0.b.b.a((Object) t8, "The eighth item is null");
        return b(t, t2, t3, t4, t5, t6, t7, t8);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> b(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new c3(this, j2, timeUnit, j0Var, z));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> b(g.a.x0.c<T, T, T> cVar) {
        g.a.y0.b.b.a(cVar, "accumulator is null");
        return g.a.c1.a.a(new e3(this, cVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> b(R r, g.a.x0.c<R, ? super T, R> cVar) {
        g.a.y0.b.b.a(r, "seed is null");
        return b((Callable) g.a.y0.b.a.b(r), (g.a.x0.c) cVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> b(Callable<R> callable, g.a.x0.c<R, ? super T, R> cVar) {
        g.a.y0.b.b.a(callable, "seedSupplier is null");
        g.a.y0.b.b.a(cVar, "accumulator is null");
        return g.a.c1.a.a(new f3(this, callable, cVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        g.a.y0.b.b.a((Object) t5, "The fifth item is null");
        g.a.y0.b.b.a((Object) t6, "The sixth item is null");
        g.a.y0.b.b.a((Object) t7, "The seventh item is null");
        g.a.y0.b.b.a((Object) t8, "The eighth item is null");
        g.a.y0.b.b.a((Object) t9, "The ninth is null");
        return b(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c b(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2) {
        return a((g.a.x0.g) gVar, gVar2, g.a.y0.b.a.f13899c, (g.a.x0.g<? super i.d.d>) p1.i.INSTANCE);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c b(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar) {
        return a((g.a.x0.g) gVar, gVar2, aVar, (g.a.x0.g<? super i.d.d>) p1.i.INSTANCE);
    }

    @g.a.t0.e
    @g.a.t0.h("custom")
    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    public final l<T> b(@g.a.t0.f j0 j0Var, boolean z) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new r3(this, j0Var, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> l<R> b(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, boolean z) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        if (this instanceof g.a.y0.c.m) {
            Object objCall = ((g.a.y0.c.m) this).call();
            if (objCall == null) {
                return R();
            }
            return d3.a(objCall, oVar);
        }
        return g.a.c1.a.a(new t3(this, oVar, i2, z));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        g.a.y0.b.b.a((Object) t5, "The fifth item is null");
        g.a.y0.b.b.a((Object) t6, "The sixth item is null");
        g.a.y0.b.b.a((Object) t7, "The seventh item is null");
        g.a.y0.b.b.a((Object) t8, "The eighth item is null");
        g.a.y0.b.b.a((Object) t9, "The ninth item is null");
        g.a.y0.b.b.a((Object) t10, "The tenth item is null");
        return b(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> b(long j2, long j3, TimeUnit timeUnit) {
        return a(j2, j3, timeUnit, g.a.e1.a.a(), false, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> b(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, j3, timeUnit, j0Var, false, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> b(long j2, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        return a(h.q2.t.m0.f16408b, j2, timeUnit, j0Var, z, i2);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> l<T> b(i.d.b<U> bVar, g.a.x0.o<? super T, ? extends i.d.b<V>> oVar) {
        g.a.y0.b.b.a(bVar, "firstTimeoutIndicator is null");
        return b(bVar, oVar, (i.d.b) null);
    }

    private <U, V> l<T> b(i.d.b<U> bVar, g.a.x0.o<? super T, ? extends i.d.b<V>> oVar, i.d.b<? extends T> bVar2) {
        g.a.y0.b.b.a(oVar, "itemTimeoutIndicator is null");
        return g.a.c1.a.a(new e4(this, bVar, oVar, bVar2));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<g.a.e1.c<T>> b(TimeUnit timeUnit) {
        return b(timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<g.a.e1.c<T>> b(TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return (l<g.a.e1.c<T>>) o(g.a.y0.b.a.a(timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> l<T> a(Iterable<? extends i.d.b<? extends T>> iterable, int i2) {
        return f((Iterable) iterable).c(g.a.y0.b.a.e(), i2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> a(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2, g.a.x0.d<? super T, ? super T> dVar) {
        return a(bVar, bVar2, dVar, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> a(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2, g.a.x0.d<? super T, ? super T> dVar, int i2) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(dVar, "isEqual is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new h3(bVar, bVar2, dVar, i2));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U extends Collection<? super T>> k0<U> b(Callable<U> callable) {
        g.a.y0.b.b.a(callable, "collectionSupplier is null");
        return g.a.c1.a.a(new i4(this, callable));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> k0<Map<K, V>> b(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        g.a.y0.b.b.a(oVar2, "valueSelector is null");
        return (k0<Map<K, V>>) a((Callable) g.a.y0.j.m.asCallable(), (g.a.x0.b) g.a.y0.b.a.a(oVar, oVar2));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> a(i.d.b<? extends T> bVar, i.d.b<? extends T> bVar2, int i2) {
        return a(bVar, bVar2, g.a.y0.b.b.a(), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> k0<Map<K, V>> b(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, V>> callable) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        g.a.y0.b.b.a(oVar2, "valueSelector is null");
        return (k0<Map<K, V>>) a((Callable) callable, (g.a.x0.b) g.a.y0.b.a.a(oVar, oVar2));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, D> l<T> a(Callable<? extends D> callable, g.a.x0.o<? super D, ? extends i.d.b<? extends T>> oVar, g.a.x0.g<? super D> gVar) {
        return a((Callable) callable, (g.a.x0.o) oVar, (g.a.x0.g) gVar, true);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, D> l<T> a(Callable<? extends D> callable, g.a.x0.o<? super D, ? extends i.d.b<? extends T>> oVar, g.a.x0.g<? super D> gVar, boolean z) {
        g.a.y0.b.b.a(callable, "resourceSupplier is null");
        g.a.y0.b.b.a(oVar, "sourceSupplier is null");
        g.a.y0.b.b.a(gVar, "disposer is null");
        return g.a.c1.a.a(new k4(callable, oVar, gVar, z));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> b(Comparator<? super T> comparator) {
        g.a.y0.b.b.a(comparator, "comparator is null");
        return (k0<List<T>>) N().h(g.a.y0.b.a.a((Comparator) comparator));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> l<l<T>> b(i.d.b<B> bVar, int i2) {
        g.a.y0.b.b.a(bVar, "boundaryIndicator is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new m4(this, bVar, i2));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, R> l<R> a(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, g.a.x0.c<? super T1, ? super T2, ? extends R> cVar, boolean z) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        return a(g.a.y0.b.a.a((g.a.x0.c) cVar), z, Q(), bVar, bVar2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> l<R> b(i.d.b<? extends U> bVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return b(this, bVar, cVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, R> l<R> a(i.d.b<? extends T1> bVar, i.d.b<? extends T2> bVar2, g.a.x0.c<? super T1, ? super T2, ? extends R> cVar, boolean z, int i2) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        return a(g.a.y0.b.a.a((g.a.x0.c) cVar), z, i2, bVar, bVar2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> a(g.a.x0.o<? super Object[], ? extends R> oVar, boolean z, int i2, i.d.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return R();
        }
        g.a.y0.b.b.a(oVar, "zipper is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new s4(bVarArr, null, oVar, i2, z));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> l<R> a(Iterable<? extends i.d.b<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar, boolean z, int i2) {
        g.a.y0.b.b.a(oVar, "zipper is null");
        g.a.y0.b.b.a(iterable, "sources is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new s4(null, iterable, oVar, i2, z));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> a(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new g.a.y0.e.b.g(this, rVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return a(this, bVar);
    }

    @g.a.t0.e
    @g.a.t0.h("none")
    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    public final <R> R a(@g.a.t0.f m<T, ? extends R> mVar) {
        return (R) ((m) g.a.y0.b.b.a(mVar, "converter is null")).a(this);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final T a() {
        g.a.y0.h.d dVar = new g.a.y0.h.d();
        a((q) dVar);
        T tA = dVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final T a(T t) {
        g.a.y0.h.d dVar = new g.a.y0.h.d();
        a((q) dVar);
        T tA = dVar.a();
        return tA != null ? tA : t;
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.h("none")
    public final void a(g.a.x0.g<? super T> gVar) {
        Iterator<T> it = b().iterator();
        while (it.hasNext()) {
            try {
                gVar.accept(it.next());
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                ((g.a.u0.c) it).dispose();
                throw g.a.y0.j.k.c(th);
            }
        }
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final Iterable<T> a(int i2) {
        g.a.y0.b.b.a(i2, "bufferSize");
        return new g.a.y0.e.b.b(this, i2);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.h("none")
    public final void a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2) {
        g.a.y0.e.b.l.a(this, gVar, gVar2, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.h("none")
    public final void a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar) {
        g.a.y0.e.b.l.a(this, gVar, gVar2, aVar);
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.h("none")
    public final void a(i.d.c<? super T> cVar) {
        g.a.y0.e.b.l.a(this, cVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<List<T>> a(int i2, int i3) {
        return (l<List<T>>) a(i2, i3, g.a.y0.j.b.asCallable());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U extends Collection<? super T>> l<U> a(int i2, int i3, Callable<U> callable) {
        g.a.y0.b.b.a(i2, "count");
        g.a.y0.b.b.a(i3, "skip");
        g.a.y0.b.b.a(callable, "bufferSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.b.m(this, i2, i3, callable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U extends Collection<? super T>> l<U> a(int i2, Callable<U> callable) {
        return a(i2, i2, callable);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<List<T>> a(long j2, long j3, TimeUnit timeUnit) {
        return (l<List<T>>) a(j2, j3, timeUnit, g.a.e1.a.a(), g.a.y0.j.b.asCallable());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<List<T>> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return (l<List<T>>) a(j2, j3, timeUnit, j0Var, g.a.y0.j.b.asCallable());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <U extends Collection<? super T>> l<U> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, Callable<U> callable) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(callable, "bufferSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.b.q(this, j2, j3, timeUnit, j0Var, callable, Integer.MAX_VALUE, false));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<List<T>> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.a(), Integer.MAX_VALUE);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<List<T>> a(long j2, TimeUnit timeUnit, int i2) {
        return a(j2, timeUnit, g.a.e1.a.a(), i2);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<List<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, int i2) {
        return (l<List<T>>) a(j2, timeUnit, j0Var, i2, (Callable) g.a.y0.j.b.asCallable(), false);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <U extends Collection<? super T>> l<U> a(long j2, TimeUnit timeUnit, j0 j0Var, int i2, Callable<U> callable, boolean z) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(callable, "bufferSupplier is null");
        g.a.y0.b.b.a(i2, "count");
        return g.a.c1.a.a(new g.a.y0.e.b.q(this, j2, j2, timeUnit, j0Var, callable, i2, z));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<List<T>> a(long j2, TimeUnit timeUnit, j0 j0Var) {
        return (l<List<T>>) a(j2, timeUnit, j0Var, Integer.MAX_VALUE, (Callable) g.a.y0.j.b.asCallable(), false);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <TOpening, TClosing> l<List<T>> a(l<? extends TOpening> lVar, g.a.x0.o<? super TOpening, ? extends i.d.b<? extends TClosing>> oVar) {
        return (l<List<T>>) a((l) lVar, (g.a.x0.o) oVar, (Callable) g.a.y0.j.b.asCallable());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <TOpening, TClosing, U extends Collection<? super T>> l<U> a(l<? extends TOpening> lVar, g.a.x0.o<? super TOpening, ? extends i.d.b<? extends TClosing>> oVar, Callable<U> callable) {
        g.a.y0.b.b.a(lVar, "openingIndicator is null");
        g.a.y0.b.b.a(oVar, "closingIndicator is null");
        g.a.y0.b.b.a(callable, "bufferSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.b.n(this, lVar, oVar, callable));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> l<List<T>> a(i.d.b<B> bVar, int i2) {
        g.a.y0.b.b.a(i2, "initialCapacity");
        return (l<List<T>>) a((i.d.b) bVar, (Callable) g.a.y0.b.a.a(i2));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B, U extends Collection<? super T>> l<U> a(i.d.b<B> bVar, Callable<U> callable) {
        g.a.y0.b.b.a(bVar, "boundaryIndicator is null");
        g.a.y0.b.b.a(callable, "bufferSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.b.p(this, bVar, callable));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> l<List<T>> a(Callable<? extends i.d.b<B>> callable) {
        return (l<List<T>>) a((Callable) callable, (Callable) g.a.y0.j.b.asCallable());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B, U extends Collection<? super T>> l<U> a(Callable<? extends i.d.b<B>> callable, Callable<U> callable2) {
        g.a.y0.b.b.a(callable, "boundaryIndicatorSupplier is null");
        g.a.y0.b.b.a(callable2, "bufferSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.b.o(this, callable, callable2));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<U> a(Class<U> cls) {
        g.a.y0.b.b.a(cls, "clazz is null");
        return (l<U>) o(g.a.y0.b.a.a((Class) cls));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> k0<U> a(Callable<? extends U> callable, g.a.x0.b<? super U, ? super T> bVar) {
        g.a.y0.b.b.a(callable, "initialItemSupplier is null");
        g.a.y0.b.b.a(bVar, "collector is null");
        return g.a.c1.a.a(new g.a.y0.e.b.t(this, callable, bVar));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> k0<U> a(U u, g.a.x0.b<? super U, ? super T> bVar) {
        g.a.y0.b.b.a(u, "initialItem is null");
        return a((Callable) g.a.y0.b.a.b(u), (g.a.x0.b) bVar);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(r<? super T, ? extends R> rVar) {
        return q(((r) g.a.y0.b.b.a(rVar, "composer is null")).a(this));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar) {
        return a(oVar, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "prefetch");
        if (this instanceof g.a.y0.c.m) {
            Object objCall = ((g.a.y0.c.m) this).call();
            if (objCall == null) {
                return R();
            }
            return d3.a(objCall, oVar);
        }
        return g.a.c1.a.a(new g.a.y0.e.b.w(this, oVar, i2, g.a.y0.j.j.IMMEDIATE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, boolean z) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "prefetch");
        if (this instanceof g.a.y0.c.m) {
            Object objCall = ((g.a.y0.c.m) this).call();
            if (objCall == null) {
                return R();
            }
            return d3.a(objCall, oVar);
        }
        return g.a.c1.a.a(new g.a.y0.e.b.w(this, oVar, i2, z ? g.a.y0.j.j.END : g.a.y0.j.j.BOUNDARY));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, int i3) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.b.x(this, oVar, i2, i3, g.a.y0.j.j.IMMEDIATE));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, boolean z) {
        return a(oVar, Q(), Q(), z);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, int i3, boolean z) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.b.x(this, oVar, i2, i3, z ? g.a.y0.j.j.END : g.a.y0.j.j.BOUNDARY));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> a(long j2, TimeUnit timeUnit, boolean z) {
        return a(j2, timeUnit, g.a.e1.a.a(), z);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.b.g0(this, Math.max(0L, j2), timeUnit, j0Var, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> l<T> a(i.d.b<U> bVar, g.a.x0.o<? super T, ? extends i.d.b<V>> oVar) {
        return d((i.d.b) bVar).f((g.a.x0.o) oVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> l<T> a(g.a.x0.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        g.a.y0.b.b.a(callable, "collectionSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.b.k0(this, oVar, callable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(g.a.x0.d<? super T, ? super T> dVar) {
        g.a.y0.b.b.a(dVar, "comparer is null");
        return g.a.c1.a.a(new g.a.y0.e.b.l0(this, g.a.y0.b.a.e(), dVar));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(g.a.x0.a aVar) {
        return a((g.a.x0.g) g.a.y0.b.a.d(), g.a.y0.b.a.d(), g.a.y0.b.a.f13899c, aVar);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    private l<T> a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.a aVar2) {
        g.a.y0.b.b.a(gVar, "onNext is null");
        g.a.y0.b.b.a(gVar2, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        g.a.y0.b.b.a(aVar2, "onAfterTerminate is null");
        return g.a.c1.a.a(new g.a.y0.e.b.o0(this, gVar, gVar2, aVar, aVar2));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(g.a.x0.g<? super i.d.d> gVar, g.a.x0.q qVar, g.a.x0.a aVar) {
        g.a.y0.b.b.a(gVar, "onSubscribe is null");
        g.a.y0.b.b.a(qVar, "onRequest is null");
        g.a.y0.b.b.a(aVar, "onCancel is null");
        return g.a.c1.a.a(new g.a.y0.e.b.p0(this, gVar, qVar, aVar));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(g.a.x0.q qVar) {
        return a(g.a.y0.b.a.d(), qVar, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(long j2) {
        if (j2 >= 0) {
            return g.a.c1.a.a(new g.a.y0.e.b.r0(this, j2));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> a(long j2, T t) {
        if (j2 >= 0) {
            g.a.y0.b.b.a((Object) t, "defaultItem is null");
            return g.a.c1.a.a(new s0(this, j2, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, boolean z, int i2) {
        return a(oVar, z, i2, Q());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, boolean z, int i2, int i3) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "bufferSize");
        if (this instanceof g.a.y0.c.m) {
            Object objCall = ((g.a.y0.c.m) this).call();
            if (objCall == null) {
                return R();
            }
            return d3.a(objCall, oVar);
        }
        return g.a.c1.a.a(new w0(this, oVar, z, i2, i3));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, g.a.x0.o<? super Throwable, ? extends i.d.b<? extends R>> oVar2, Callable<? extends i.d.b<? extends R>> callable) {
        g.a.y0.b.b.a(oVar, "onNextMapper is null");
        g.a.y0.b.b.a(oVar2, "onErrorMapper is null");
        g.a.y0.b.b.a(callable, "onCompleteSupplier is null");
        return r(new z1(this, oVar, oVar2, callable));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, g.a.x0.o<Throwable, ? extends i.d.b<? extends R>> oVar2, Callable<? extends i.d.b<? extends R>> callable, int i2) {
        g.a.y0.b.b.a(oVar, "onNextMapper is null");
        g.a.y0.b.b.a(oVar2, "onErrorMapper is null");
        g.a.y0.b.b.a(callable, "onCompleteSupplier is null");
        return d(new z1(this, oVar, oVar2, callable), i2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        return a((g.a.x0.o) oVar, (g.a.x0.c) cVar, false, Q(), Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return a(oVar, cVar, z, Q(), Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return a(oVar, cVar, z, i2, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2, int i3) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(cVar, "combiner is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "bufferSize");
        return a(p1.a(oVar, cVar), z, i2, i3);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> l<R> a(g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, int i2) {
        return a((g.a.x0.o) oVar, (g.a.x0.c) cVar, false, i2, Q());
    }

    @g.a.t0.b(g.a.t0.a.NONE)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c a(g.a.x0.r<? super T> rVar, g.a.x0.g<? super Throwable> gVar) {
        return a((g.a.x0.r) rVar, gVar, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.b(g.a.t0.a.NONE)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c a(g.a.x0.r<? super T> rVar, g.a.x0.g<? super Throwable> gVar, g.a.x0.a aVar) {
        g.a.y0.b.b.a(rVar, "onNext is null");
        g.a.y0.b.b.a(gVar, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        g.a.y0.h.h hVar = new g.a.y0.h.h(rVar, gVar, aVar);
        a((q) hVar);
        return hVar;
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> l<g.a.w0.b<K, V>> a(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2) {
        return a((g.a.x0.o) oVar, (g.a.x0.o) oVar2, false, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> l<g.a.w0.b<K, V>> a(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, boolean z) {
        return a(oVar, oVar2, z, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> l<g.a.w0.b<K, V>> a(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, boolean z, int i2) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        g.a.y0.b.b.a(oVar2, "valueSelector is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new k1(this, oVar, oVar2, i2, z));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <TRight, TLeftEnd, TRightEnd, R> l<R> a(i.d.b<? extends TRight> bVar, g.a.x0.o<? super T, ? extends i.d.b<TLeftEnd>> oVar, g.a.x0.o<? super TRight, ? extends i.d.b<TRightEnd>> oVar2, g.a.x0.c<? super T, ? super l<TRight>, ? extends R> cVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        g.a.y0.b.b.a(oVar, "leftEnd is null");
        g.a.y0.b.b.a(oVar2, "rightEnd is null");
        g.a.y0.b.b.a(cVar, "resultSelector is null");
        return g.a.c1.a.a(new l1(this, bVar, oVar, oVar2, cVar));
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(p<? extends R, ? super T> pVar) {
        g.a.y0.b.b.a(pVar, "lifter is null");
        return g.a.c1.a.a(new w1(this, pVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> a(j0 j0Var) {
        return a(j0Var, false, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> a(j0 j0Var, boolean z) {
        return a(j0Var, z, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> a(j0 j0Var, boolean z, int i2) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new d2(this, j0Var, z, i2));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(boolean z) {
        return a(Q(), z, true);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(int i2, boolean z) {
        return a(i2, z, false);
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(int i2, boolean z, boolean z2) {
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new e2(this, i2, z2, z, g.a.y0.b.a.f13899c));
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(int i2, boolean z, boolean z2, g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onOverflow is null");
        g.a.y0.b.b.a(i2, "capacity");
        return g.a.c1.a.a(new e2(this, i2, z2, z, aVar));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(int i2, g.a.x0.a aVar) {
        return a(i2, false, false, aVar);
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(long j2, g.a.x0.a aVar, a aVar2) {
        g.a.y0.b.b.a(aVar2, "strategy is null");
        g.a.y0.b.b.a(j2, "capacity");
        return g.a.c1.a.a(new f2(this, j2, aVar, aVar2));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(g.a.x0.c<T, T, T> cVar) {
        g.a.y0.b.b.a(cVar, "reducer is null");
        return g.a.c1.a.a(new q2(this, cVar));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> k0<R> a(R r, g.a.x0.c<R, ? super T, R> cVar) {
        g.a.y0.b.b.a(r, "seed is null");
        g.a.y0.b.b.a(cVar, "reducer is null");
        return g.a.c1.a.a(new r2(this, r, cVar));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> k0<R> a(Callable<R> callable, g.a.x0.c<R, ? super T, R> cVar) {
        g.a.y0.b.b.a(callable, "seedSupplier is null");
        g.a.y0.b.b.a(cVar, "reducer is null");
        return g.a.c1.a.a(new s2(this, callable, cVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(g.a.x0.e eVar) {
        g.a.y0.b.b.a(eVar, "stop is null");
        return g.a.c1.a.a(new v2(this, eVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final <R> l<R> a(g.a.x0.o<? super l<T>, ? extends i.d.b<R>> oVar, int i2, long j2, TimeUnit timeUnit) {
        return a(oVar, i2, j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <R> l<R> a(g.a.x0.o<? super l<T>, ? extends i.d.b<R>> oVar, int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a(p1.a(this, i2, j2, timeUnit, j0Var), (g.a.x0.o) oVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <R> l<R> a(g.a.x0.o<? super l<T>, ? extends i.d.b<R>> oVar, int i2, j0 j0Var) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return x2.a(p1.a(this, i2), p1.a(oVar, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final <R> l<R> a(g.a.x0.o<? super l<T>, ? extends i.d.b<R>> oVar, long j2, TimeUnit timeUnit) {
        return a(oVar, j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <R> l<R> a(g.a.x0.o<? super l<T>, ? extends i.d.b<R>> oVar, long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a(p1.a(this, j2, timeUnit, j0Var), (g.a.x0.o) oVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <R> l<R> a(g.a.x0.o<? super l<T>, ? extends i.d.b<R>> oVar, j0 j0Var) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a(p1.a(this), p1.a(oVar, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final g.a.w0.a<T> a(int i2, long j2, TimeUnit timeUnit) {
        return a(i2, j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final g.a.w0.a<T> a(int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(i2, "bufferSize");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return x2.a(this, j2, timeUnit, j0Var, i2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final g.a.w0.a<T> a(int i2, j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a((g.a.w0.a) h(i2), j0Var);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(long j2, g.a.x0.r<? super Throwable> rVar) {
        if (j2 >= 0) {
            g.a.y0.b.b.a(rVar, "predicate is null");
            return g.a.c1.a.a(new z2(this, j2, rVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> l<T> a(i.d.b<U> bVar, boolean z) {
        g.a.y0.b.b.a(bVar, "sampler is null");
        return g.a.c1.a.a(new b3(this, bVar, z));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new o3(this, j2, timeUnit, j0Var, i2 << 1, z));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(Comparator<? super T> comparator) {
        g.a.y0.b.b.a(comparator, "sortFunction");
        return N().m().o(g.a.y0.b.a.a((Comparator) comparator)).k((g.a.x0.o<? super R, ? extends Iterable<? extends U>>) g.a.y0.b.a.e());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(Iterable<? extends T> iterable) {
        return b(f((Iterable) iterable), this);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(T... tArr) {
        l lVarB = b((Object[]) tArr);
        if (lVarB == R()) {
            return g.a.c1.a.a(this);
        }
        return b(lVarB, this);
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.g<? super i.d.d> gVar3) {
        g.a.y0.b.b.a(gVar, "onNext is null");
        g.a.y0.b.b.a(gVar2, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        g.a.y0.b.b.a(gVar3, "onSubscribe is null");
        g.a.y0.h.l lVar = new g.a.y0.h.l(gVar, gVar2, aVar, gVar3);
        a((q) lVar);
        return lVar;
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.h("none")
    @g.a.t0.c
    public final void a(q<? super T> qVar) {
        g.a.y0.b.b.a(qVar, "s is null");
        try {
            i.d.c<? super T> cVarA = g.a.c1.a.a(this, qVar);
            g.a.y0.b.b.a(cVarA, "Plugin returned null Subscriber");
            d((i.d.c) cVarA);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        if (j2 >= 0) {
            return g.a.c1.a.a(new x3(this, j2, j3, timeUnit, j0Var, i2, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j2);
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<g.a.e1.c<T>> a(TimeUnit timeUnit) {
        return a(timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<g.a.e1.c<T>> a(TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new d4(this, timeUnit, j0Var));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <V> l<T> a(g.a.x0.o<? super T, ? extends i.d.b<V>> oVar, l<? extends T> lVar) {
        g.a.y0.b.b.a(lVar, "other is null");
        return b((i.d.b) null, oVar, lVar);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<T> a(long j2, TimeUnit timeUnit, i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return a(j2, timeUnit, bVar, g.a.e1.a.a());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<T> a(long j2, TimeUnit timeUnit, j0 j0Var, i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        return a(j2, timeUnit, bVar, j0Var);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> l<T> a(i.d.b<U> bVar, g.a.x0.o<? super T, ? extends i.d.b<V>> oVar, i.d.b<? extends T> bVar2) {
        g.a.y0.b.b.a(bVar, "firstTimeoutSelector is null");
        g.a.y0.b.b.a(bVar2, "other is null");
        return b(bVar, oVar, bVar2);
    }

    private l<T> a(long j2, TimeUnit timeUnit, i.d.b<? extends T> bVar, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "timeUnit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new f4(this, j2, timeUnit, j0Var, bVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> a(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, Collection<V>>> callable, g.a.x0.o<? super K, ? extends Collection<? super V>> oVar3) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        g.a.y0.b.b.a(oVar2, "valueSelector is null");
        g.a.y0.b.b.a(callable, "mapSupplier is null");
        g.a.y0.b.b.a(oVar3, "collectionFactory is null");
        return (k0<Map<K, Collection<V>>>) a((Callable) callable, (g.a.x0.b) g.a.y0.b.a.a(oVar, oVar2, oVar3));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> a(Comparator<? super T> comparator, int i2) {
        g.a.y0.b.b.a(comparator, "comparator is null");
        return (k0<List<T>>) k(i2).h(g.a.y0.b.a.a((Comparator) comparator));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<l<T>> a(long j2, long j3) {
        return a(j2, j3, Q());
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<l<T>> a(long j2, long j3, int i2) {
        g.a.y0.b.b.a(j3, "skip");
        g.a.y0.b.b.a(j2, "count");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new l4(this, j2, j3, i2));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<l<T>> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, int i2) {
        g.a.y0.b.b.a(i2, "bufferSize");
        g.a.y0.b.b.a(j2, "timespan");
        g.a.y0.b.b.a(j3, "timeskip");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        return g.a.c1.a.a(new p4(this, j2, j3, timeUnit, j0Var, h.q2.t.m0.f16408b, i2, false));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<l<T>> a(long j2, TimeUnit timeUnit, long j3) {
        return a(j2, timeUnit, g.a.e1.a.a(), j3, false);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final l<l<T>> a(long j2, TimeUnit timeUnit, long j3, boolean z) {
        return a(j2, timeUnit, g.a.e1.a.a(), j3, z);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<l<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3) {
        return a(j2, timeUnit, j0Var, j3, false);
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<l<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3, boolean z) {
        return a(j2, timeUnit, j0Var, j3, z, Q());
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("custom")
    public final l<l<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3, boolean z, int i2) {
        g.a.y0.b.b.a(i2, "bufferSize");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j3, "count");
        return g.a.c1.a.a(new p4(this, j2, j2, timeUnit, j0Var, j3, i2, z));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> l<l<T>> a(i.d.b<U> bVar, g.a.x0.o<? super U, ? extends i.d.b<V>> oVar, int i2) {
        g.a.y0.b.b.a(bVar, "openingIndicator is null");
        g.a.y0.b.b.a(oVar, "closingIndicator is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new n4(this, bVar, oVar, i2));
    }

    @g.a.t0.b(g.a.t0.a.ERROR)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> l<l<T>> a(Callable<? extends i.d.b<B>> callable, int i2) {
        g.a.y0.b.b.a(callable, "boundaryIndicatorSupplier is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new o4(this, callable, i2));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> l<R> a(i.d.b<? extends U> bVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        g.a.y0.b.b.a(bVar, "other is null");
        g.a.y0.b.b.a(cVar, "combiner is null");
        return g.a.c1.a.a(new q4(this, cVar, bVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T1, T2, R> l<R> a(i.d.b<T1> bVar, i.d.b<T2> bVar2, g.a.x0.h<? super T, ? super T1, ? super T2, R> hVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        return a((i.d.b<?>[]) new i.d.b[]{bVar, bVar2}, g.a.y0.b.a.a((g.a.x0.h) hVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T1, T2, T3, R> l<R> a(i.d.b<T1> bVar, i.d.b<T2> bVar2, i.d.b<T3> bVar3, g.a.x0.i<? super T, ? super T1, ? super T2, ? super T3, R> iVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        return a((i.d.b<?>[]) new i.d.b[]{bVar, bVar2, bVar3}, g.a.y0.b.a.a((g.a.x0.i) iVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T1, T2, T3, T4, R> l<R> a(i.d.b<T1> bVar, i.d.b<T2> bVar2, i.d.b<T3> bVar3, i.d.b<T4> bVar4, g.a.x0.j<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> jVar) {
        g.a.y0.b.b.a(bVar, "source1 is null");
        g.a.y0.b.b.a(bVar2, "source2 is null");
        g.a.y0.b.b.a(bVar3, "source3 is null");
        g.a.y0.b.b.a(bVar4, "source4 is null");
        return a((i.d.b<?>[]) new i.d.b[]{bVar, bVar2, bVar3, bVar4}, g.a.y0.b.a.a((g.a.x0.j) jVar));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(i.d.b<?>[] bVarArr, g.a.x0.o<? super Object[], R> oVar) {
        g.a.y0.b.b.a(bVarArr, "others is null");
        g.a.y0.b.b.a(oVar, "combiner is null");
        return g.a.c1.a.a(new r4(this, bVarArr, oVar));
    }

    @g.a.t0.b(g.a.t0.a.PASS_THROUGH)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> l<R> a(Iterable<? extends i.d.b<?>> iterable, g.a.x0.o<? super Object[], R> oVar) {
        g.a.y0.b.b.a(iterable, "others is null");
        g.a.y0.b.b.a(oVar, "combiner is null");
        return g.a.c1.a.a(new r4(this, iterable, oVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> l<R> a(Iterable<U> iterable, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        g.a.y0.b.b.a(iterable, "other is null");
        g.a.y0.b.b.a(cVar, "zipper is null");
        return g.a.c1.a.a(new t4(this, iterable, cVar));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> l<R> a(i.d.b<? extends U> bVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return a(this, bVar, cVar, z);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> l<R> a(i.d.b<? extends U> bVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return a(this, bVar, cVar, z, i2);
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.g1.f<T> a(long j2, boolean z) {
        g.a.g1.f<T> fVar = new g.a.g1.f<>(j2);
        if (z) {
            fVar.cancel();
        }
        a((q) fVar);
        return fVar;
    }
}
