package g.a;

import g.a.y0.e.d.a1;
import g.a.y0.e.d.a2;
import g.a.y0.e.d.a3;
import g.a.y0.e.d.a4;
import g.a.y0.e.d.b1;
import g.a.y0.e.d.b2;
import g.a.y0.e.d.b3;
import g.a.y0.e.d.b4;
import g.a.y0.e.d.c1;
import g.a.y0.e.d.c2;
import g.a.y0.e.d.c3;
import g.a.y0.e.d.c4;
import g.a.y0.e.d.d1;
import g.a.y0.e.d.d2;
import g.a.y0.e.d.d3;
import g.a.y0.e.d.d4;
import g.a.y0.e.d.e1;
import g.a.y0.e.d.e2;
import g.a.y0.e.d.e3;
import g.a.y0.e.d.e4;
import g.a.y0.e.d.f1;
import g.a.y0.e.d.f2;
import g.a.y0.e.d.f3;
import g.a.y0.e.d.f4;
import g.a.y0.e.d.g1;
import g.a.y0.e.d.g2;
import g.a.y0.e.d.g3;
import g.a.y0.e.d.g4;
import g.a.y0.e.d.h1;
import g.a.y0.e.d.h2;
import g.a.y0.e.d.h3;
import g.a.y0.e.d.i1;
import g.a.y0.e.d.i3;
import g.a.y0.e.d.j1;
import g.a.y0.e.d.j2;
import g.a.y0.e.d.j3;
import g.a.y0.e.d.k1;
import g.a.y0.e.d.k2;
import g.a.y0.e.d.k3;
import g.a.y0.e.d.l1;
import g.a.y0.e.d.l2;
import g.a.y0.e.d.l3;
import g.a.y0.e.d.m1;
import g.a.y0.e.d.m2;
import g.a.y0.e.d.m3;
import g.a.y0.e.d.n1;
import g.a.y0.e.d.n2;
import g.a.y0.e.d.n3;
import g.a.y0.e.d.o1;
import g.a.y0.e.d.o2;
import g.a.y0.e.d.o3;
import g.a.y0.e.d.p1;
import g.a.y0.e.d.p2;
import g.a.y0.e.d.p3;
import g.a.y0.e.d.q1;
import g.a.y0.e.d.q2;
import g.a.y0.e.d.q3;
import g.a.y0.e.d.r1;
import g.a.y0.e.d.r2;
import g.a.y0.e.d.r3;
import g.a.y0.e.d.s0;
import g.a.y0.e.d.s1;
import g.a.y0.e.d.s2;
import g.a.y0.e.d.s3;
import g.a.y0.e.d.t0;
import g.a.y0.e.d.t1;
import g.a.y0.e.d.t2;
import g.a.y0.e.d.t3;
import g.a.y0.e.d.u0;
import g.a.y0.e.d.u1;
import g.a.y0.e.d.u2;
import g.a.y0.e.d.u3;
import g.a.y0.e.d.v1;
import g.a.y0.e.d.v3;
import g.a.y0.e.d.w0;
import g.a.y0.e.d.w1;
import g.a.y0.e.d.w2;
import g.a.y0.e.d.w3;
import g.a.y0.e.d.x0;
import g.a.y0.e.d.x1;
import g.a.y0.e.d.x2;
import g.a.y0.e.d.x3;
import g.a.y0.e.d.y0;
import g.a.y0.e.d.y1;
import g.a.y0.e.d.y2;
import g.a.y0.e.d.y3;
import g.a.y0.e.d.z0;
import g.a.y0.e.d.z1;
import g.a.y0.e.d.z2;
import g.a.y0.e.d.z3;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Observable.java */
/* loaded from: classes2.dex */
public abstract class b0<T> implements g0<T> {

    /* compiled from: Observable.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13654a = new int[b.values().length];

        static {
            try {
                f13654a[b.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13654a[b.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13654a[b.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13654a[b.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int L() {
        return l.Q();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> M() {
        return g.a.c1.a.a(g.a.y0.e.d.r0.f15437a);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> N() {
        return g.a.c1.a.a(x1.f15575a);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends T>... g0VarArr) {
        g.a.y0.b.b.a(g0VarArr, "sources is null");
        int length = g0VarArr.length;
        return length == 0 ? M() : length == 1 ? v(g0VarArr[0]) : g.a.c1.a.a(new g.a.y0.e.d.h(g0VarArr, null));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> b(Iterable<? extends g0<? extends T>> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new g.a.y0.e.d.h(null, iterable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> c(g0<? extends T>[] g0VarArr, g.a.x0.o<? super Object[], ? extends R> oVar) {
        return b(g0VarArr, oVar, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> d(g0<? extends T>... g0VarArr) {
        return a(L(), L(), g0VarArr);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> e(Iterable<? extends g0<? extends T>> iterable) {
        return a(iterable, L(), L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> f(Callable<? extends T> callable) {
        g.a.y0.b.b.a(callable, "supplier is null");
        return g.a.c1.a.a((b0) new b1(callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> g(Iterable<? extends g0<? extends T>> iterable) {
        return f((Iterable) iterable).j(g.a.y0.b.a.e());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> h(Iterable<? extends g0<? extends T>> iterable) {
        return f((Iterable) iterable).b(g.a.y0.b.a.e(), true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> j(g.a.x0.g<k<T>> gVar) {
        g.a.y0.b.b.a(gVar, "generator  is null");
        return a(g.a.y0.b.a.h(), m1.a(gVar), g.a.y0.b.a.d());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> l(T t) {
        g.a.y0.b.b.a((Object) t, "The item is null");
        return g.a.c1.a.a((b0) new q1(t));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> n(g0<? extends g0<? extends T>> g0Var) {
        return c(g0Var, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> o(g0<? extends g0<? extends T>> g0Var) {
        return a((g0) g0Var, L(), true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> p(g0<? extends g0<? extends T>> g0Var) {
        return a(g0Var, L(), L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> q(g0<? extends g0<? extends T>> g0Var) {
        g.a.y0.b.b.a(g0Var, "sources is null");
        return g.a.c1.a.a(new u0(g0Var, g.a.y0.b.a.e(), false, Integer.MAX_VALUE, L()));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> r(g0<? extends g0<? extends T>> g0Var) {
        g.a.y0.b.b.a(g0Var, "sources is null");
        return g.a.c1.a.a(new u0(g0Var, g.a.y0.b.a.e(), true, Integer.MAX_VALUE, L()));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> s(g0<? extends g0<? extends T>> g0Var) {
        return f(g0Var, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> t(g0<? extends g0<? extends T>> g0Var) {
        return g(g0Var, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> u(g0<T> g0Var) {
        g.a.y0.b.b.a(g0Var, "source is null");
        g.a.y0.b.b.a(g0Var, "onSubscribe is null");
        if (g0Var instanceof b0) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return g.a.c1.a.a(new f1(g0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> v(g0<T> g0Var) {
        g.a.y0.b.b.a(g0Var, "source is null");
        return g0Var instanceof b0 ? g.a.c1.a.a((b0) g0Var) : g.a.c1.a.a(new f1(g0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> A() {
        return v().Q();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> B() {
        return g.a.c1.a.a(new y2(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> C() {
        return g.a.c1.a.a(new z2(this, null));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> D() {
        return J().p().p(g.a.y0.b.a.a(g.a.y0.b.a.f())).l((g.a.x0.o<? super R, ? extends Iterable<? extends U>>) g.a.y0.b.a.e());
    }

    @g.a.t0.h("none")
    public final g.a.u0.c E() {
        return a((g.a.x0.g) g.a.y0.b.a.d(), (g.a.x0.g<? super Throwable>) g.a.y0.b.a.f13902f, g.a.y0.b.a.f13899c, g.a.y0.b.a.d());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.a1.n<T> F() {
        g.a.a1.n<T> nVar = new g.a.a1.n<>();
        subscribe(nVar);
        return nVar;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<g.a.e1.c<T>> G() {
        return a(TimeUnit.MILLISECONDS, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<g.a.e1.c<T>> H() {
        return b(TimeUnit.MILLISECONDS, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final Future<T> I() {
        return (Future) e((b0<T>) new g.a.y0.d.r());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> J() {
        return g(16);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> K() {
        return b((Comparator) g.a.y0.b.a.g());
    }

    protected abstract void d(i0<? super T> i0Var);

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Long> i() {
        return g.a.c1.a.a(new g.a.y0.e.d.z(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> k() {
        return a((g.a.x0.o) g.a.y0.b.a.e(), (Callable) g.a.y0.b.a.c());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> m() {
        return a(0L);
    }

    @Override // g.a.g0
    @g.a.t0.h("none")
    public final void subscribe(i0<? super T> i0Var) {
        g.a.y0.b.b.a(i0Var, "observer is null");
        try {
            i0<? super T> i0VarA = g.a.c1.a.a(this, i0Var);
            g.a.y0.b.b.a(i0VarA, "Plugin returned null Observer");
            d((i0) i0VarA);
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

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> w() {
        return c(h.q2.t.m0.f16408b);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.z0.a<T> x() {
        return m2.w(this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> y() {
        return a(h.q2.t.m0.f16408b, g.a.y0.b.a.b());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> z() {
        return g.a.c1.a.a(new x2(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> c(Iterable<? extends g0<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar) {
        return b(iterable, oVar, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> d(Iterable<? extends g0<? extends T>> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return o(f((Iterable) iterable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> e(Callable<? extends Throwable> callable) {
        g.a.y0.b.b.a(callable, "errorSupplier is null");
        return g.a.c1.a.a(new s0(callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> g(g0<? extends g0<? extends T>> g0Var, int i2) {
        g.a.y0.b.b.a(g0Var, "sources is null");
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new h3(g0Var, g.a.y0.b.a.e(), i2, true));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static b0<Long> p(long j2, TimeUnit timeUnit) {
        return d(j2, j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <V> b0<T> A(g.a.x0.o<? super T, ? extends g0<V>> oVar) {
        return b((g0) null, oVar, (g0) null);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> R B(g.a.x0.o<? super b0<T>, R> oVar) {
        try {
            return (R) ((g.a.x0.o) g.a.y0.b.b.a(oVar, "converter is null")).apply(this);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            throw g.a.y0.j.k.c(th);
        }
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> k0<Map<K, T>> C(g.a.x0.o<? super T, ? extends K> oVar) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        return (k0<Map<K, T>>) a((Callable) g.a.y0.j.m.asCallable(), (g.a.x0.b) g.a.y0.b.a.a((g.a.x0.o) oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> k0<Map<K, Collection<T>>> D(g.a.x0.o<? super T, ? extends K> oVar) {
        return (k0<Map<K, Collection<T>>>) a((g.a.x0.o) oVar, (g.a.x0.o) g.a.y0.b.a.e(), (Callable) g.a.y0.j.m.asCallable(), (g.a.x0.o) g.a.y0.j.b.asFunction());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> h() {
        return g.a.y0.e.d.r.a((b0) this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> b0<T> i(g.a.x0.o<? super T, K> oVar) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        return g.a.c1.a.a(new g.a.y0.e.d.j0(this, oVar, g.a.y0.b.b.a()));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c k(g.a.x0.o<? super T, ? extends i> oVar) {
        return c((g.a.x0.o) oVar, false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> m(g.a.x0.o<? super T, ? extends y<? extends R>> oVar) {
        return d((g.a.x0.o) oVar, false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> n() {
        return b(0L);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> b0<g.a.z0.b<K, T>> o(g.a.x0.o<? super T, ? extends K> oVar) {
        return (b0<g.a.z0.b<K, T>>) a((g.a.x0.o) oVar, (g.a.x0.o) g.a.y0.b.a.e(), false, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> s() {
        return g.a.c1.a.a(new s1(this, null));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<a0<T>> t() {
        return g.a.c1.a.a(new w1(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> w(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return f(oVar, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> x(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return g(oVar, L());
    }

    @g.a.t0.f
    @g.a.t0.e
    @g.a.t0.h("none")
    @g.a.t0.d
    public final <R> b0<R> y(@g.a.t0.f g.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        return m1.a(this, oVar);
    }

    @g.a.t0.f
    @g.a.t0.e
    @g.a.t0.h("none")
    @g.a.t0.d
    public final <R> b0<R> z(@g.a.t0.f g.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        return m1.b(this, oVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> b(Iterable<? extends g0<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar) {
        return a(iterable, oVar, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> c(Iterable<? extends g0<? extends T>> iterable) {
        g.a.y0.b.b.a(iterable, "sources is null");
        return f((Iterable) iterable).a(g.a.y0.b.a.e(), L(), false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> f(Iterable<? extends T> iterable) {
        g.a.y0.b.b.a(iterable, "source is null");
        return g.a.c1.a.a(new d1(iterable));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static b0<Long> p(long j2, TimeUnit timeUnit, j0 j0Var) {
        return d(j2, j2, timeUnit, j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static b0<Long> q(long j2, TimeUnit timeUnit) {
        return q(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> b0<T> h(g.a.x0.o<? super T, K> oVar) {
        return a((g.a.x0.o) oVar, (Callable) g.a.y0.b.a.c());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> k(T t) {
        g.a.y0.b.b.a((Object) t, "item is null");
        return b(l(t), this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> l() {
        return i((g.a.x0.o) g.a.y0.b.a.e());
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> m(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> n(g.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        return e((g.a.x0.o) oVar, false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> o() {
        return g.a.c1.a.a(new j1(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> r() {
        return g.a.c1.a.a(new r1(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> s(g.a.x0.o<? super b0<T>, ? extends g0<R>> oVar) {
        g.a.y0.b.b.a(oVar, "selector is null");
        return g.a.c1.a.a(new c2(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> t(g.a.x0.o<? super b0<Object>, ? extends g0<?>> oVar) {
        g.a.y0.b.b.a(oVar, "handler is null");
        return g.a.c1.a.a(new l2(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> b(g0<? extends T>[] g0VarArr, g.a.x0.o<? super Object[], ? extends R> oVar) {
        return a(g0VarArr, oVar, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> d(Callable<? extends g0<? extends T>> callable) {
        g.a.y0.b.b.a(callable, "supplier is null");
        return g.a.c1.a.a(new g.a.y0.e.d.d0(callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> e(g0<? extends T>... g0VarArr) {
        return b((Object[]) g0VarArr).d(g.a.y0.b.a.e(), g0VarArr.length);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static b0<Long> q(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new t3(Math.max(j2, 0L), timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c h(g.a.x0.g<? super T> gVar) {
        return i((g.a.x0.g) gVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> i(T t) {
        g.a.y0.b.b.a((Object) t, "item is null");
        return r(g.a.y0.b.a.c(t));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<U> l(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new z0(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> m(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> n(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, (g0) null, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<b0<T>> o(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.a(), h.q2.t.m0.f16408b, false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c p() {
        return g.a.c1.a.a(new l1(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> r(g.a.x0.o<? super Throwable, ? extends T> oVar) {
        g.a.y0.b.b.a(oVar, "valueSupplier is null");
        return g.a.c1.a.a(new a2(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> b(g.a.x0.o<? super Object[], ? extends R> oVar, int i2, g0<? extends T>... g0VarArr) {
        return b(g0VarArr, oVar, i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> c(g0<? extends g0<? extends T>> g0Var, int i2) {
        g.a.y0.b.b.a(g0Var, "sources is null");
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.d.v(g0Var, g.a.y0.b.a.e(), i2, g.a.y0.j.j.IMMEDIATE));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> e(g0<? extends g0<? extends T>> g0Var, int i2) {
        g.a.y0.b.b.a(g0Var, "sources is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        return g.a.c1.a.a(new u0(g0Var, g.a.y0.b.a.e(), true, i2, L()));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> f(g0<? extends T>... g0VarArr) {
        return b((Object[]) g0VarArr).a(g.a.y0.b.a.e(), true, g0VarArr.length);
    }

    @g.a.t0.h("none")
    public final void g() {
        g.a.y0.e.d.l.a(this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> h(T t) {
        g.a.y0.b.b.a((Object) t, "defaultItem is null");
        return g.a.c1.a.a(new s1(this, t));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T2> b0<T2> j() {
        return g.a.c1.a.a(new g.a.y0.e.d.g0(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> k(g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return g.a.c1.a.a(new g3(this, g0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> b0<b0<T>> m(g0<B> g0Var) {
        return b(g0Var, L());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> n(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, (g0) null, j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<b0<T>> o(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, h.q2.t.m0.f16408b, false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> p(g.a.x0.o<? super T, ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new u1(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.z0.a<T> v() {
        return b2.w(this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> a(g.a.x0.o<? super Object[], ? extends R> oVar, int i2, g0<? extends T>... g0VarArr) {
        return a(g0VarArr, oVar, i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> b(g0<? extends T>[] g0VarArr, g.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        g.a.y0.b.b.a(i2, "bufferSize");
        g.a.y0.b.b.a(oVar, "combiner is null");
        if (g0VarArr.length == 0) {
            return M();
        }
        return g.a.c1.a.a(new g.a.y0.e.d.u(g0VarArr, null, oVar, i2 << 1, true));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static b0<Long> d(long j2, long j3, TimeUnit timeUnit) {
        return d(j2, j3, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> f(g0<? extends g0<? extends T>> g0Var, int i2) {
        g.a.y0.b.b.a(g0Var, "sources is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new h3(g0Var, g.a.y0.b.a.e(), i2, false));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<T> g(g.a.x0.o<? super T, ? extends g0<U>> oVar) {
        g.a.y0.b.b.a(oVar, "itemDelay is null");
        return (b0<T>) j((g.a.x0.o) m1.c(oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<T> i(g0<U> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return g.a.c1.a.a(new d3(this, g0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> j(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return b((g.a.x0.o) oVar, false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<T> l(g0<U> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return g.a.c1.a.a(new m3(this, g0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> u() {
        return g.a.c1.a.a(new g.a.y0.e.d.h0(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> v(g.a.x0.o<? super b0<Throwable>, ? extends g0<?>> oVar) {
        g.a.y0.b.b.a(oVar, "handler is null");
        return g.a.c1.a.a(new p2(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> a(Iterable<? extends g0<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        g.a.y0.b.b.a(iterable, "sources is null");
        g.a.y0.b.b.a(oVar, "combiner is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new g.a.y0.e.d.u(null, iterable, oVar, i2 << 1, false));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static b0<Long> d(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new n1(Math.max(0L, j2), Math.max(0L, j3), timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<T> h(g0<U> g0Var) {
        g.a.y0.b.b.a(g0Var, "sampler is null");
        return g.a.c1.a.a(new r2(this, g0Var, false));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> j(T t) {
        g.a.y0.b.b.a((Object) t, "defaultItem is null");
        return g.a.c1.a.a(new z2(this, t));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> k(long j2, TimeUnit timeUnit) {
        return k(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> q() {
        return a((g.a.x0.r) g.a.y0.b.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> u(g.a.x0.o<? super b0<T>, ? extends g0<R>> oVar) {
        g.a.y0.b.b.a(oVar, "selector is null");
        return m2.a(m1.a(this), (g.a.x0.o) oVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> c(g0<? extends T>... g0VarArr) {
        if (g0VarArr.length == 0) {
            return M();
        }
        if (g0VarArr.length == 1) {
            return v(g0VarArr[0]);
        }
        return o(b((Object[]) g0VarArr));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> e(g0<? extends g0<? extends T>> g0Var, g.a.x0.o<? super Object[], ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "zipper is null");
        g.a.y0.b.b.a(g0Var, "sources is null");
        return g.a.c1.a.a(new u3(g0Var, 16).j((g.a.x0.o) m1.f(oVar)));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> g(g.a.x0.g<? super g.a.u0.c> gVar) {
        return a(gVar, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c i(g.a.x0.g<? super T> gVar) {
        return a((g.a.x0.g) gVar, (g.a.x0.g<? super Throwable>) g.a.y0.b.a.f13902f, g.a.y0.b.a.f13899c, g.a.y0.b.a.d());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> k(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new p3(this, j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> l(long j2, TimeUnit timeUnit) {
        return f(j2, timeUnit);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> q(g.a.x0.o<? super Throwable, ? extends g0<? extends T>> oVar) {
        g.a.y0.b.b.a(oVar, "resumeFunction is null");
        return g.a.c1.a.a(new z1(this, oVar, false));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final T f() {
        T tC = B().c();
        if (tC != null) {
            return tC;
        }
        throw new NoSuchElementException();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> g(T t) {
        return a(0L, (long) t);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13873m)
    public final b0<T> h(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.g(), false, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> i(long j2, TimeUnit timeUnit) {
        return l((g0) q(j2, timeUnit));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> j(g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return b(g0Var, this);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> l(long j2, TimeUnit timeUnit, j0 j0Var) {
        return f(j2, timeUnit, j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> d(g0<? extends g0<? extends T>> g0Var, int i2) {
        g.a.y0.b.b.a(g0Var, "sources is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        return g.a.c1.a.a(new u0(g0Var, g.a.y0.b.a.e(), false, i2, L()));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> g(g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "next is null");
        return g.a.c1.a.a(new z1(this, g.a.y0.b.a.c(g0Var), true));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> h(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false, L());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> i(long j2, TimeUnit timeUnit, j0 j0Var) {
        return l((g0) q(j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> a(g0<? extends T>[] g0VarArr, g.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        g.a.y0.b.b.a(g0VarArr, "sources is null");
        if (g0VarArr.length == 0) {
            return M();
        }
        g.a.y0.b.b.a(oVar, "combiner is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new g.a.y0.e.d.u(g0VarArr, null, oVar, i2 << 1, false));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> b(Iterable<? extends g0<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        g.a.y0.b.b.a(iterable, "sources is null");
        g.a.y0.b.b.a(oVar, "combiner is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new g.a.y0.e.d.u(null, iterable, oVar, i2 << 1, true));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<T> f(g.a.x0.o<? super T, ? extends g0<U>> oVar) {
        g.a.y0.b.b.a(oVar, "debounceSelector is null");
        return g.a.c1.a.a(new g.a.y0.e.d.b0(this, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> h(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new o3(this, rVar));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13873m)
    public final b0<T> j(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, g.a.e1.a.g(), false, L());
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> g(long j2, TimeUnit timeUnit) {
        return i((g0) q(j2, timeUnit));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> j(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var, false, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, S> b0<T> c(Callable<S> callable, g.a.x0.c<S, k<T>, S> cVar) {
        return a((Callable) callable, (g.a.x0.c) cVar, g.a.y0.b.a.d());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> d(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        return a(g0Var, g0Var2, g.a.y0.b.b.a(), L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final Iterable<T> e() {
        return new g.a.y0.e.d.e(this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> f(T t) {
        g.a.y0.b.b.a((Object) t, "defaultItem is null");
        return k((g0) l(t));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> g(long j2, TimeUnit timeUnit, j0 j0Var) {
        return i((g0) q(j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> h(int i2) {
        return a(g.a.y0.b.a.g(), i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> c(Iterable<? extends g0<? extends T>> iterable, int i2, int i3) {
        return f((Iterable) iterable).a(g.a.y0.b.a.e(), true, i2, i3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> d(Iterable<? extends g0<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "zipper is null");
        g.a.y0.b.b.a(iterable, "sources is null");
        return g.a.c1.a.a(new f4(null, iterable, oVar, L(), false));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<U> e(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new z0(this, oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> g(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        if (this instanceof g.a.y0.c.m) {
            Object objCall = ((g.a.y0.c.m) this).call();
            if (objCall == null) {
                return M();
            }
            return s2.a(objCall, oVar);
        }
        return g.a.c1.a.a(new h3(this, oVar, i2, true));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> b(g0<? extends T>... g0VarArr) {
        if (g0VarArr.length == 0) {
            return M();
        }
        if (g0VarArr.length == 1) {
            return v(g0VarArr[0]);
        }
        return g.a.c1.a.a(new g.a.y0.e.d.v(b((Object[]) g0VarArr), g.a.y0.b.a.e(), L(), g.a.y0.j.j.BOUNDARY));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> c(int i2, int i3, g0<? extends T>... g0VarArr) {
        return b((Object[]) g0VarArr).a(g.a.y0.b.a.e(), true, i2, i3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> f(g.a.x0.g<? super T> gVar) {
        g.a.x0.g<? super Throwable> gVarD = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return a((g.a.x0.g) gVar, gVarD, aVar, aVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> c(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2}).a(g.a.y0.b.a.e(), true, 2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> e(Object obj) {
        g.a.y0.b.b.a(obj, "element is null");
        return b((g.a.x0.r) g.a.y0.b.a.a(obj));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> b0<g.a.z0.b<K, T>> f(g.a.x0.o<? super T, ? extends K> oVar, boolean z) {
        return (b0<g.a.z0.b<K, T>>) a(oVar, g.a.y0.b.a.e(), z, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        return a(g.a.y0.b.a.a((g.a.x0.c) cVar), L(), g0Var, g0Var2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final Iterable<T> d() {
        return new g.a.y0.e.d.c(this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> f(g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "next is null");
        return q(g.a.y0.b.a.c(g0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final T d(T t) {
        return j((b0<T>) t).d();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> e(g.a.x0.g<? super Throwable> gVar) {
        g.a.x0.g<? super T> gVarD = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return a((g.a.x0.g) gVarD, gVar, aVar, aVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> c(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2, g0Var3}).a(g.a.y0.b.a.e(), true, 3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> d(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return a(oVar, Integer.MAX_VALUE, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> e(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onTerminate is null");
        return a((g.a.x0.g) g.a.y0.b.a.d(), g.a.y0.b.a.a(aVar), aVar, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> f(long j2, TimeUnit timeUnit) {
        return f(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        return a(g.a.y0.b.a.a((g.a.x0.h) hVar), L(), g0Var, g0Var2, g0Var3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> b(T... tArr) {
        g.a.y0.b.b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return M();
        }
        if (tArr.length == 1) {
            return l(tArr[0]);
        }
        return g.a.c1.a.a(new a1(tArr));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<T> d(g0<U> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return g.a.c1.a.a(new g.a.y0.e.d.f0(this, g0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> f(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new q2(this, j2, timeUnit, j0Var, false));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> g(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new n3(this, rVar));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> d(long j2, TimeUnit timeUnit) {
        return d(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> c(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3, g0<? extends T> g0Var4) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2, g0Var3, g0Var4}).a(g.a.y0.b.a.e(), true, 4);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> d(long j2, TimeUnit timeUnit, j0 j0Var) {
        return d((g0) q(j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> e(g.a.x0.o<? super T, ? extends q0<? extends R>> oVar, boolean z) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new y0(this, oVar, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> f(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new e3(this, rVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> g(int i2) {
        g.a.y0.b.b.a(i2, "capacityHint");
        return g.a.c1.a.a(new v3(this, i2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        return a(g.a.y0.b.a.a((g.a.x0.i) iVar), L(), g0Var, g0Var2, g0Var3, g0Var4);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> d(g.a.x0.a aVar) {
        return a(g.a.y0.b.a.d(), aVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> d(g.a.x0.g<? super a0<T>> gVar) {
        g.a.y0.b.b.a(gVar, "consumer is null");
        return a((g.a.x0.g) g.a.y0.b.a.c((g.a.x0.g) gVar), (g.a.x0.g<? super Throwable>) g.a.y0.b.a.b((g.a.x0.g) gVar), g.a.y0.b.a.a((g.a.x0.g) gVar), g.a.y0.b.a.f13899c);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> e(g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return b(this, g0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> f(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        if (this instanceof g.a.y0.c.m) {
            Object objCall = ((g.a.y0.c.m) this).call();
            if (objCall == null) {
                return M();
            }
            return s2.a(objCall, oVar);
        }
        return g.a.c1.a.a(new h3(this, oVar, i2, false));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<b0<T>> g(long j2) {
        return a(j2, j2, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, S> b0<T> b(Callable<S> callable, g.a.x0.b<S, k<T>> bVar) {
        g.a.y0.b.b.a(bVar, "generator  is null");
        return a((Callable) callable, m1.a(bVar), g.a.y0.b.a.d());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> e(g.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return m2.a(m1.a(this, i2), (g.a.x0.o) oVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> b(Iterable<? extends g0<? extends T>> iterable, int i2, int i3) {
        return f((Iterable) iterable).a(g.a.y0.b.a.e(), false, i2, i3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final T c() throws InterruptedException {
        g.a.y0.d.g gVar = new g.a.y0.d.g();
        subscribe(gVar);
        T tA = gVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        g.a.y0.b.b.a(g0Var5, "source5 is null");
        return a(g.a.y0.b.a.a((g.a.x0.j) jVar), L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> b(int i2, int i3, g0<? extends T>... g0VarArr) {
        return b((Object[]) g0VarArr).a(g.a.y0.b.a.e(), false, i2, i3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> b(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2}).a(g.a.y0.b.a.e(), false, 2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> d(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2) {
        return a((g.a.x0.o) oVar, false, i2, L());
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final g.a.z0.a<T> e(long j2, TimeUnit timeUnit) {
        return e(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> d(g.a.x0.o<? super T, ? extends y<? extends R>> oVar, boolean z) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new x0(this, oVar, z));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final g.a.z0.a<T> e(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a(this, j2, timeUnit, j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final Iterable<T> c(T t) {
        return new g.a.y0.e.d.d(this, t);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> f(long j2) {
        if (j2 >= 0) {
            return g.a.c1.a.a(new i3(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> b(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2, g0Var3}).a(g.a.y0.b.a.e(), false, 3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> c(int i2) {
        return g.a.y0.e.d.r.a((b0) this, i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c d(g.a.x0.r<? super T> rVar) {
        return a((g.a.x0.r) rVar, (g.a.x0.g<? super Throwable>) g.a.y0.b.a.f13902f, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> c(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return a((g.a.x0.o) oVar, L(), true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.z0.a<T> d(int i2) {
        g.a.y0.b.b.a(i2, "bufferSize");
        return m2.h(this, i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> e(g.a.x0.r<? super Throwable> rVar) {
        return a(h.q2.t.m0.f16408b, rVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> f(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        }
        if (i2 == 0) {
            return g.a.c1.a.a(new k1(this));
        }
        if (i2 == 1) {
            return g.a.c1.a.a(new k3(this));
        }
        return g.a.c1.a.a(new j3(this, i2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        g.a.y0.b.b.a(g0Var5, "source5 is null");
        g.a.y0.b.b.a(g0Var6, "source6 is null");
        return a(g.a.y0.b.a.a((g.a.x0.k) kVar), L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<U> c(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "prefetch");
        return (b0<U>) a(m1.b(oVar), i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> e(long j2) {
        if (j2 <= 0) {
            return g.a.c1.a.a(this);
        }
        return g.a.c1.a.a(new a3(this, j2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> d(long j2) {
        return a(j2, g.a.y0.b.a.b());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> b(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3, g0<? extends T> g0Var4) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2, g0Var3, g0Var4}).a(g.a.y0.b.a.e(), false, 4);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13873m)
    public final b0<T> d(long j2, TimeUnit timeUnit, boolean z) {
        return b(j2, timeUnit, g.a.e1.a.g(), z, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> e(int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return g.a.c1.a.a(this);
            }
            return g.a.c1.a.a(new b3(this, i2));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> c(g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return a((g0) this, (g0) g0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> d(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        return b(j2, timeUnit, j0Var, z, L());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> f(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new w3(this, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<g.a.e1.c<T>> d(j0 j0Var) {
        return a(TimeUnit.MILLISECONDS, j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> c(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.a(), false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> b0<b0<T>> d(g0<U> g0Var, g.a.x0.o<? super U, ? extends g0<V>> oVar) {
        return a(g0Var, oVar, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <E extends i0<? super T>> E e(E e2) {
        subscribe(e2);
        return e2;
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> c(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<g.a.e1.c<T>> e(j0 j0Var) {
        return b(TimeUnit.MILLISECONDS, j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        g.a.y0.b.b.a(g0Var5, "source5 is null");
        g.a.y0.b.b.a(g0Var6, "source6 is null");
        g.a.y0.b.b.a(g0Var7, "source7 is null");
        return a(g.a.y0.b.a.a((g.a.x0.l) lVar), L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> b(Iterable<? extends g0<? extends T>> iterable, int i2) {
        return f((Iterable) iterable).a(g.a.y0.b.a.e(), true, i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> c(g.a.x0.g<? super T> gVar) {
        g.a.y0.b.b.a(gVar, "onAfterNext is null");
        return g.a.c1.a.a(new g.a.y0.e.d.k0(this, gVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static b0<Integer> b(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i3);
        }
        if (i3 == 0) {
            return M();
        }
        if (i3 == 1) {
            return l(Integer.valueOf(i2));
        }
        if (i2 + (i3 - 1) <= 2147483647L) {
            return g.a.c1.a.a(new d2(i2, i3));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> c(g.a.x0.a aVar) {
        return a((g.a.x0.g) g.a.y0.b.a.d(), g.a.y0.b.a.d(), aVar, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> c(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new t0(this, rVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final c c(g.a.x0.o<? super T, ? extends i> oVar, boolean z) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return g.a.c1.a.a(new w0(this, oVar, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static b0<Long> b(long j2, long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return M();
        }
        if (j3 == 1) {
            return l(Long.valueOf(j2));
        }
        long j4 = (j3 - 1) + j2;
        if (j2 > 0 && j4 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        return g.a.c1.a.a(new e2(j2, j3));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> c(long j2) {
        if (j2 >= 0) {
            if (j2 == 0) {
                return M();
            }
            return g.a.c1.a.a(new j2(this, j2));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g0<? extends T8> g0Var8, g.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        g.a.y0.b.b.a(g0Var5, "source5 is null");
        g.a.y0.b.b.a(g0Var6, "source6 is null");
        g.a.y0.b.b.a(g0Var7, "source7 is null");
        g.a.y0.b.b.a(g0Var8, "source8 is null");
        return a(g.a.y0.b.a.a((g.a.x0.m) mVar), L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8);
    }

    @g.a.t0.h("none")
    public final void c(i0<? super T> i0Var) {
        g.a.y0.b.b.a(i0Var, "s is null");
        if (i0Var instanceof g.a.a1.l) {
            subscribe(i0Var);
        } else {
            subscribe(new g.a.a1.l(i0Var));
        }
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        return a(g.a.y0.b.a.a((g.a.x0.c) cVar), false, L(), g0Var, g0Var2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        return a(g.a.y0.b.a.a((g.a.x0.h) hVar), false, L(), g0Var, g0Var2, g0Var3);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13873m)
    public final b0<T> c(long j2, TimeUnit timeUnit, boolean z) {
        return a(j2, timeUnit, g.a.e1.a.g(), z, L());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> c(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        return a(j2, timeUnit, j0Var, z, L());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> c(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new f3(this, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g0<? extends T8> g0Var8, g0<? extends T9> g0Var9, g.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        g.a.y0.b.b.a(g0Var5, "source5 is null");
        g.a.y0.b.b.a(g0Var6, "source6 is null");
        g.a.y0.b.b.a(g0Var7, "source7 is null");
        g.a.y0.b.b.a(g0Var8, "source8 is null");
        g.a.y0.b.b.a(g0Var9, "source9 is null");
        return a(g.a.y0.b.a.a((g.a.x0.n) nVar), L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8, g0Var9);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        return a(g.a.y0.b.a.a((g.a.x0.i) iVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> b0<T> c(g0<U> g0Var, g.a.x0.o<? super T, ? extends g0<V>> oVar) {
        g.a.y0.b.b.a(g0Var, "firstTimeoutIndicator is null");
        return b(g0Var, oVar, (g0) null);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> c(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2) {
        return a((g.a.x0.o) oVar, (g.a.x0.o) oVar2, (Callable) g.a.y0.j.m.asCallable(), (g.a.x0.o) g.a.y0.j.b.asFunction());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        g.a.y0.b.b.a(g0Var5, "source5 is null");
        return a(g.a.y0.b.a.a((g.a.x0.j) jVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> c(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, Callable<Map<K, Collection<V>>> callable) {
        return a((g.a.x0.o) oVar, (g.a.x0.o) oVar2, (Callable) callable, (g.a.x0.o) g.a.y0.j.b.asFunction());
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<b0<T>> c(long j2, long j3, TimeUnit timeUnit) {
        return a(j2, j3, timeUnit, g.a.e1.a.a(), L());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<b0<T>> c(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, j3, timeUnit, j0Var, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> b0<b0<T>> c(Callable<? extends g0<B>> callable) {
        return a(callable, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        return b(g0Var, g0Var2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        g.a.y0.b.b.a(g0Var5, "source5 is null");
        g.a.y0.b.b.a(g0Var6, "source6 is null");
        return a(g.a.y0.b.a.a((g.a.x0.k) kVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        return b(g0Var, g0Var2, g0Var3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3, g0<? extends T> g0Var4) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        return b(g0Var, g0Var2, g0Var3, g0Var4);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        g.a.y0.b.b.a(g0Var5, "source5 is null");
        g.a.y0.b.b.a(g0Var6, "source6 is null");
        g.a.y0.b.b.a(g0Var7, "source7 is null");
        return a(g.a.y0.b.a.a((g.a.x0.l) lVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(int i2, int i3, g0<? extends T>... g0VarArr) {
        return b((Object[]) g0VarArr).a(g.a.y0.b.a.e(), i2, i3, false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends g0<? extends T>> g0Var, int i2, boolean z) {
        g.a.y0.b.b.a(g0Var, "sources is null");
        g.a.y0.b.b.a(i2, "prefetch is null");
        return g.a.c1.a.a(new g.a.y0.e.d.v(g0Var, g.a.y0.b.a.e(), i2, z ? g.a.y0.j.j.END : g.a.y0.j.j.BOUNDARY));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends g0<? extends T>> g0Var, int i2, int i3) {
        g.a.y0.b.b.a(Integer.valueOf(i2), "maxConcurrency is null");
        g.a.y0.b.b.a(Integer.valueOf(i3), "prefetch is null");
        return v(g0Var).a(g.a.y0.b.a.e(), i2, i3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g0<? extends T8> g0Var8, g.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        g.a.y0.b.b.a(g0Var5, "source5 is null");
        g.a.y0.b.b.a(g0Var6, "source6 is null");
        g.a.y0.b.b.a(g0Var7, "source7 is null");
        g.a.y0.b.b.a(g0Var8, "source8 is null");
        return a(g.a.y0.b.a.a((g.a.x0.m) mVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(Iterable<? extends g0<? extends T>> iterable, int i2, int i3) {
        g.a.y0.b.b.a(Integer.valueOf(i2), "maxConcurrency is null");
        g.a.y0.b.b.a(Integer.valueOf(i3), "prefetch is null");
        return f((Iterable) iterable).a(g.a.y0.b.a.e(), i2, i3, false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(e0<T> e0Var) {
        g.a.y0.b.b.a(e0Var, "source is null");
        return g.a.c1.a.a(new g.a.y0.e.d.a0(e0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(Throwable th) {
        g.a.y0.b.b.a(th, "e is null");
        return e((Callable<? extends Throwable>) g.a.y0.b.a.b(th));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(Future<? extends T> future) {
        g.a.y0.b.b.a(future, "future is null");
        return g.a.c1.a.a(new c1(future, 0L, null));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g0<? extends T8> g0Var8, g0<? extends T9> g0Var9, g.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(g0Var3, "source3 is null");
        g.a.y0.b.b.a(g0Var4, "source4 is null");
        g.a.y0.b.b.a(g0Var5, "source5 is null");
        g.a.y0.b.b.a(g0Var6, "source6 is null");
        g.a.y0.b.b.a(g0Var7, "source7 is null");
        g.a.y0.b.b.a(g0Var8, "source8 is null");
        g.a.y0.b.b.a(g0Var9, "source9 is null");
        return a(g.a.y0.b.a.a((g.a.x0.n) nVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8, g0Var9);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        g.a.y0.b.b.a(future, "future is null");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        return g.a.c1.a.a(new c1(future, j2, timeUnit));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static <T> b0<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return a(future, j2, timeUnit).c(j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static <T> b0<T> a(Future<? extends T> future, j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return a((Future) future).c(j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> b(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new g.a.y0.e.d.j(this, rVar));
    }

    @g.a.t0.b(g.a.t0.a.UNBOUNDED_IN)
    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(i.d.b<? extends T> bVar) {
        g.a.y0.b.b.a(bVar, "publisher is null");
        return g.a.c1.a.a(new e1(bVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final Iterable<T> b() {
        return a(L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, S> b0<T> a(Callable<S> callable, g.a.x0.b<S, k<T>> bVar, g.a.x0.g<? super S> gVar) {
        g.a.y0.b.b.a(bVar, "generator  is null");
        return a((Callable) callable, m1.a(bVar), (g.a.x0.g) gVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final T b(T t) throws InterruptedException {
        g.a.y0.d.g gVar = new g.a.y0.d.g();
        subscribe(gVar);
        T tA = gVar.a();
        return tA != null ? tA : t;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, S> b0<T> a(Callable<S> callable, g.a.x0.c<S, k<T>, S> cVar, g.a.x0.g<? super S> gVar) {
        g.a.y0.b.b.a(callable, "initialState is null");
        g.a.y0.b.b.a(cVar, "generator  is null");
        g.a.y0.b.b.a(gVar, "disposeState is null");
        return g.a.c1.a.a(new g1(callable, cVar, gVar));
    }

    @g.a.t0.h("none")
    public final void b(g.a.x0.g<? super T> gVar) {
        g.a.y0.e.d.l.a(this, gVar, g.a.y0.b.a.f13902f, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<List<T>> b(int i2) {
        return a(i2, i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> b0<List<T>> b(g0<B> g0Var) {
        return (b0<List<T>>) a((g0) g0Var, (Callable) g.a.y0.j.b.asCallable());
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public static b0<Long> a(long j2, long j3, long j4, long j5, TimeUnit timeUnit) {
        return a(j2, j3, j4, j5, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("none")
    public final c b(g.a.x0.o<? super T, ? extends i> oVar) {
        return b(oVar, 2);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public static b0<Long> a(long j2, long j3, long j4, long j5, TimeUnit timeUnit, j0 j0Var) {
        if (j3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return M().c(j4, timeUnit, j0Var);
        }
        long j6 = j2 + (j3 - 1);
        if (j2 > 0 && j6 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new o1(j2, j6, Math.max(0L, j4), Math.max(0L, j5), timeUnit, j0Var));
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("none")
    public final c b(g.a.x0.o<? super T, ? extends i> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "capacityHint");
        return g.a.c1.a.a(new g.a.y0.e.d.w(this, oVar, i2));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> b(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> b(long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.d.c0(this, j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        return b(t, t2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> b0<T> b(g0<U> g0Var, g.a.x0.o<? super T, ? extends g0<V>> oVar) {
        return d((g0) g0Var).g((g.a.x0.o) oVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> b(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onFinally is null");
        return g.a.c1.a.a(new g.a.y0.e.d.l0(this, aVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        return b(t, t2, t3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> b(i0<? super T> i0Var) {
        g.a.y0.b.b.a(i0Var, "observer is null");
        return a((g.a.x0.g) m1.c(i0Var), (g.a.x0.g<? super Throwable>) m1.b(i0Var), m1.a(i0Var), g.a.y0.b.a.f13899c);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        return b(t, t2, t3, t4);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> b(long j2) {
        if (j2 >= 0) {
            return g.a.c1.a.a(new g.a.y0.e.d.q0(this, j2, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> b(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, boolean z) {
        return a(oVar, z, Integer.MAX_VALUE);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        g.a.y0.b.b.a((Object) t5, "The fifth item is null");
        return b(t, t2, t3, t4, t5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> b0<V> b(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends V> cVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(cVar, "resultSelector is null");
        return (b0<V>) a((g.a.x0.o) m1.b(oVar), (g.a.x0.c) cVar, false, L(), L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <TRight, TLeftEnd, TRightEnd, R> b0<R> b(g0<? extends TRight> g0Var, g.a.x0.o<? super T, ? extends g0<TLeftEnd>> oVar, g.a.x0.o<? super TRight, ? extends g0<TRightEnd>> oVar2, g.a.x0.c<? super T, ? super TRight, ? extends R> cVar) {
        g.a.y0.b.b.a(g0Var, "other is null");
        g.a.y0.b.b.a(oVar, "leftEnd is null");
        g.a.y0.b.b.a(oVar2, "rightEnd is null");
        g.a.y0.b.b.a(cVar, "resultSelector is null");
        return g.a.c1.a.a(new p1(this, g0Var, oVar, oVar2, cVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5, T t6) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        g.a.y0.b.b.a((Object) t5, "The fifth item is null");
        g.a.y0.b.b.a((Object) t6, "The sixth item is null");
        return b(t, t2, t3, t4, t5, t6);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<U> b(Class<U> cls) {
        g.a.y0.b.b.a(cls, "clazz is null");
        return c((g.a.x0.r) g.a.y0.b.a.b((Class) cls)).a((Class) cls);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final g.a.z0.a<T> b(j0 j0Var) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a((g.a.z0.a) x(), j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> b(g.a.x0.d<? super Integer, ? super Throwable> dVar) {
        g.a.y0.b.b.a(dVar, "predicate is null");
        return g.a.c1.a.a(new n2(this, dVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        g.a.y0.b.b.a((Object) t5, "The fifth item is null");
        g.a.y0.b.b.a((Object) t6, "The sixth item is null");
        g.a.y0.b.b.a((Object) t7, "The seventh item is null");
        return b(t, t2, t3, t4, t5, t6, t7);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> b(g.a.x0.e eVar) {
        g.a.y0.b.b.a(eVar, "stop is null");
        return a(h.q2.t.m0.f16408b, g.a.y0.b.a.a(eVar));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> b(long j2, TimeUnit timeUnit, boolean z) {
        return b(j2, timeUnit, g.a.e1.a.a(), z);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> b(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new q2(this, j2, timeUnit, j0Var, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> b(g.a.x0.c<T, T, T> cVar) {
        g.a.y0.b.b.a(cVar, "accumulator is null");
        return g.a.c1.a.a(new t2(this, cVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
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

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> b(R r, g.a.x0.c<R, ? super T, R> cVar) {
        g.a.y0.b.b.a(r, "seed is null");
        return b((Callable) g.a.y0.b.a.b(r), (g.a.x0.c) cVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> b(Callable<R> callable, g.a.x0.c<R, ? super T, R> cVar) {
        g.a.y0.b.b.a(callable, "seedSupplier is null");
        g.a.y0.b.b.a(cVar, "accumulator is null");
        return g.a.c1.a.a(new u2(this, callable, cVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c b(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2) {
        return a((g.a.x0.g) gVar, gVar2, g.a.y0.b.a.f13899c, g.a.y0.b.a.d());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c b(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar) {
        return a((g.a.x0.g) gVar, gVar2, aVar, g.a.y0.b.a.d());
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13873m)
    public final b0<T> b(long j2, long j3, TimeUnit timeUnit) {
        return a(j2, j3, timeUnit, g.a.e1.a.g(), false, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        g.a.y0.b.b.a((Object) t, "The first item is null");
        g.a.y0.b.b.a((Object) t2, "The second item is null");
        g.a.y0.b.b.a((Object) t3, "The third item is null");
        g.a.y0.b.b.a((Object) t4, "The fourth item is null");
        g.a.y0.b.b.a((Object) t5, "The fifth item is null");
        g.a.y0.b.b.a((Object) t6, "The sixth item is null");
        g.a.y0.b.b.a((Object) t7, "The seventh item is null");
        g.a.y0.b.b.a((Object) t8, "The eighth item is null");
        g.a.y0.b.b.a((Object) t9, "The ninth item is null");
        return b(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> b(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, j3, timeUnit, j0Var, false, L());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> b(long j2, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        return a(h.q2.t.m0.f16408b, j2, timeUnit, j0Var, z, i2);
    }

    private <U, V> b0<T> b(g0<U> g0Var, g.a.x0.o<? super T, ? extends g0<V>> oVar, g0<? extends T> g0Var2) {
        g.a.y0.b.b.a(oVar, "itemTimeoutIndicator is null");
        return g.a.c1.a.a(new r3(this, g0Var, oVar, g0Var2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<g.a.e1.c<T>> b(TimeUnit timeUnit) {
        return b(timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<g.a.e1.c<T>> b(TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return (b0<g.a.e1.c<T>>) p(g.a.y0.b.a.a(timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U extends Collection<? super T>> k0<U> b(Callable<U> callable) {
        g.a.y0.b.b.a(callable, "collectionSupplier is null");
        return g.a.c1.a.a(new v3(this, callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
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

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> k0<Map<K, V>> b(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        g.a.y0.b.b.a(oVar2, "valueSelector is null");
        return (k0<Map<K, V>>) a((Callable) g.a.y0.j.m.asCallable(), (g.a.x0.b) g.a.y0.b.a.a(oVar, oVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> k0<Map<K, V>> b(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, V>> callable) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        g.a.y0.b.b.a(oVar2, "valueSelector is null");
        g.a.y0.b.b.a(callable, "mapSupplier is null");
        return (k0<Map<K, V>>) a((Callable) callable, (g.a.x0.b) g.a.y0.b.a.a(oVar, oVar2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> b(Comparator<? super T> comparator) {
        g.a.y0.b.b.a(comparator, "comparator is null");
        return (k0<List<T>>) J().h(g.a.y0.b.a.a((Comparator) comparator));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> b0<b0<T>> b(g0<B> g0Var, int i2) {
        g.a.y0.b.b.a(g0Var, "boundary is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new z3(this, g0Var, i2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> b0<T> a(Iterable<? extends g0<? extends T>> iterable, int i2) {
        return f((Iterable) iterable).d(g.a.y0.b.a.e(), i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> a(g0<? extends T> g0Var, g0<? extends T> g0Var2, g.a.x0.d<? super T, ? super T> dVar) {
        return a(g0Var, g0Var2, dVar, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> b0<R> b(g0<? extends U> g0Var, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return b(this, g0Var, cVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> a(g0<? extends T> g0Var, g0<? extends T> g0Var2, g.a.x0.d<? super T, ? super T> dVar, int i2) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        g.a.y0.b.b.a(dVar, "isEqual is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new w2(g0Var, g0Var2, dVar, i2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T> k0<Boolean> a(g0<? extends T> g0Var, g0<? extends T> g0Var2, int i2) {
        return a(g0Var, g0Var2, g.a.y0.b.b.a(), i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, D> b0<T> a(Callable<? extends D> callable, g.a.x0.o<? super D, ? extends g0<? extends T>> oVar, g.a.x0.g<? super D> gVar) {
        return a((Callable) callable, (g.a.x0.o) oVar, (g.a.x0.g) gVar, true);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, D> b0<T> a(Callable<? extends D> callable, g.a.x0.o<? super D, ? extends g0<? extends T>> oVar, g.a.x0.g<? super D> gVar, boolean z) {
        g.a.y0.b.b.a(callable, "resourceSupplier is null");
        g.a.y0.b.b.a(oVar, "sourceSupplier is null");
        g.a.y0.b.b.a(gVar, "disposer is null");
        return g.a.c1.a.a(new x3(callable, oVar, gVar, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g.a.x0.c<? super T1, ? super T2, ? extends R> cVar, boolean z) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        return a(g.a.y0.b.a.a((g.a.x0.c) cVar), z, L(), g0Var, g0Var2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T1, T2, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g.a.x0.c<? super T1, ? super T2, ? extends R> cVar, boolean z, int i2) {
        g.a.y0.b.b.a(g0Var, "source1 is null");
        g.a.y0.b.b.a(g0Var2, "source2 is null");
        return a(g.a.y0.b.a.a((g.a.x0.c) cVar), z, i2, g0Var, g0Var2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> a(g.a.x0.o<? super Object[], ? extends R> oVar, boolean z, int i2, g0<? extends T>... g0VarArr) {
        if (g0VarArr.length == 0) {
            return M();
        }
        g.a.y0.b.b.a(oVar, "zipper is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new f4(g0VarArr, null, oVar, i2, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public static <T, R> b0<R> a(Iterable<? extends g0<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar, boolean z, int i2) {
        g.a.y0.b.b.a(oVar, "zipper is null");
        g.a.y0.b.b.a(iterable, "sources is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new f4(null, iterable, oVar, i2, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<Boolean> a(g.a.x0.r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate is null");
        return g.a.c1.a.a(new g.a.y0.e.d.g(this, rVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> a(g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return a(this, g0Var);
    }

    @g.a.t0.e
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> R a(@g.a.t0.f c0<T, ? extends R> c0Var) {
        return (R) ((c0) g.a.y0.b.b.a(c0Var, "converter is null")).a(this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final T a() throws InterruptedException {
        g.a.y0.d.f fVar = new g.a.y0.d.f();
        subscribe(fVar);
        T tA = fVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final T a(T t) throws InterruptedException {
        g.a.y0.d.f fVar = new g.a.y0.d.f();
        subscribe(fVar);
        T tA = fVar.a();
        return tA != null ? tA : t;
    }

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

    @g.a.t0.d
    @g.a.t0.h("none")
    public final Iterable<T> a(int i2) {
        g.a.y0.b.b.a(i2, "bufferSize");
        return new g.a.y0.e.d.b(this, i2);
    }

    @g.a.t0.h("none")
    public final void a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2) {
        g.a.y0.e.d.l.a(this, gVar, gVar2, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.h("none")
    public final void a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar) {
        g.a.y0.e.d.l.a(this, gVar, gVar2, aVar);
    }

    @g.a.t0.h("none")
    public final void a(i0<? super T> i0Var) {
        g.a.y0.e.d.l.a(this, i0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<List<T>> a(int i2, int i3) {
        return (b0<List<T>>) a(i2, i3, g.a.y0.j.b.asCallable());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U extends Collection<? super T>> b0<U> a(int i2, int i3, Callable<U> callable) {
        g.a.y0.b.b.a(i2, "count");
        g.a.y0.b.b.a(i3, "skip");
        g.a.y0.b.b.a(callable, "bufferSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.d.m(this, i2, i3, callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U extends Collection<? super T>> b0<U> a(int i2, Callable<U> callable) {
        return a(i2, i2, callable);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<List<T>> a(long j2, long j3, TimeUnit timeUnit) {
        return (b0<List<T>>) a(j2, j3, timeUnit, g.a.e1.a.a(), g.a.y0.j.b.asCallable());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<List<T>> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return (b0<List<T>>) a(j2, j3, timeUnit, j0Var, g.a.y0.j.b.asCallable());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <U extends Collection<? super T>> b0<U> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, Callable<U> callable) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(callable, "bufferSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.d.q(this, j2, j3, timeUnit, j0Var, callable, Integer.MAX_VALUE, false));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<List<T>> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, g.a.e1.a.a(), Integer.MAX_VALUE);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<List<T>> a(long j2, TimeUnit timeUnit, int i2) {
        return a(j2, timeUnit, g.a.e1.a.a(), i2);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<List<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, int i2) {
        return (b0<List<T>>) a(j2, timeUnit, j0Var, i2, (Callable) g.a.y0.j.b.asCallable(), false);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <U extends Collection<? super T>> b0<U> a(long j2, TimeUnit timeUnit, j0 j0Var, int i2, Callable<U> callable, boolean z) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(callable, "bufferSupplier is null");
        g.a.y0.b.b.a(i2, "count");
        return g.a.c1.a.a(new g.a.y0.e.d.q(this, j2, j2, timeUnit, j0Var, callable, i2, z));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<List<T>> a(long j2, TimeUnit timeUnit, j0 j0Var) {
        return (b0<List<T>>) a(j2, timeUnit, j0Var, Integer.MAX_VALUE, (Callable) g.a.y0.j.b.asCallable(), false);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <TOpening, TClosing> b0<List<T>> a(g0<? extends TOpening> g0Var, g.a.x0.o<? super TOpening, ? extends g0<? extends TClosing>> oVar) {
        return (b0<List<T>>) a((g0) g0Var, (g.a.x0.o) oVar, (Callable) g.a.y0.j.b.asCallable());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <TOpening, TClosing, U extends Collection<? super T>> b0<U> a(g0<? extends TOpening> g0Var, g.a.x0.o<? super TOpening, ? extends g0<? extends TClosing>> oVar, Callable<U> callable) {
        g.a.y0.b.b.a(g0Var, "openingIndicator is null");
        g.a.y0.b.b.a(oVar, "closingIndicator is null");
        g.a.y0.b.b.a(callable, "bufferSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.d.n(this, g0Var, oVar, callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> b0<List<T>> a(g0<B> g0Var, int i2) {
        g.a.y0.b.b.a(i2, "initialCapacity");
        return (b0<List<T>>) a((g0) g0Var, (Callable) g.a.y0.b.a.a(i2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B, U extends Collection<? super T>> b0<U> a(g0<B> g0Var, Callable<U> callable) {
        g.a.y0.b.b.a(g0Var, "boundary is null");
        g.a.y0.b.b.a(callable, "bufferSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.d.p(this, g0Var, callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> b0<List<T>> a(Callable<? extends g0<B>> callable) {
        return (b0<List<T>>) a((Callable) callable, (Callable) g.a.y0.j.b.asCallable());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B, U extends Collection<? super T>> b0<U> a(Callable<? extends g0<B>> callable, Callable<U> callable2) {
        g.a.y0.b.b.a(callable, "boundarySupplier is null");
        g.a.y0.b.b.a(callable2, "bufferSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.d.o(this, callable, callable2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<U> a(Class<U> cls) {
        g.a.y0.b.b.a(cls, "clazz is null");
        return (b0<U>) p(g.a.y0.b.a.a((Class) cls));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> k0<U> a(Callable<? extends U> callable, g.a.x0.b<? super U, ? super T> bVar) {
        g.a.y0.b.b.a(callable, "initialValueSupplier is null");
        g.a.y0.b.b.a(bVar, "collector is null");
        return g.a.c1.a.a(new g.a.y0.e.d.t(this, callable, bVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> k0<U> a(U u, g.a.x0.b<? super U, ? super T> bVar) {
        g.a.y0.b.b.a(u, "initialValue is null");
        return a((Callable) g.a.y0.b.a.b(u), (g.a.x0.b) bVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(h0<? super T, ? extends R> h0Var) {
        return v(((h0) g.a.y0.b.b.a(h0Var, "composer is null")).a(this));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return a(oVar, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "prefetch");
        if (this instanceof g.a.y0.c.m) {
            Object objCall = ((g.a.y0.c.m) this).call();
            if (objCall == null) {
                return M();
            }
            return s2.a(objCall, oVar);
        }
        return g.a.c1.a.a(new g.a.y0.e.d.v(this, oVar, i2, g.a.y0.j.j.IMMEDIATE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2, boolean z) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "prefetch");
        if (this instanceof g.a.y0.c.m) {
            Object objCall = ((g.a.y0.c.m) this).call();
            if (objCall == null) {
                return M();
            }
            return s2.a(objCall, oVar);
        }
        return g.a.c1.a.a(new g.a.y0.e.d.v(this, oVar, i2, z ? g.a.y0.j.j.END : g.a.y0.j.j.BOUNDARY));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2, int i3) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.d.x(this, oVar, g.a.y0.j.j.IMMEDIATE, i2, i3));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, boolean z) {
        return a(oVar, Integer.MAX_VALUE, L(), z);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2, int i3, boolean z) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.d.x(this, oVar, z ? g.a.y0.j.j.END : g.a.y0.j.j.BOUNDARY, i2, i3));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> a(long j2, TimeUnit timeUnit, boolean z) {
        return a(j2, timeUnit, g.a.e1.a.a(), z);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new g.a.y0.e.d.e0(this, j2, timeUnit, j0Var, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K> b0<T> a(g.a.x0.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        g.a.y0.b.b.a(callable, "collectionSupplier is null");
        return g.a.c1.a.a(new g.a.y0.e.d.i0(this, oVar, callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> a(g.a.x0.d<? super T, ? super T> dVar) {
        g.a.y0.b.b.a(dVar, "comparer is null");
        return g.a.c1.a.a(new g.a.y0.e.d.j0(this, g.a.y0.b.a.e(), dVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> a(g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onFinally is null");
        return a((g.a.x0.g) g.a.y0.b.a.d(), g.a.y0.b.a.d(), g.a.y0.b.a.f13899c, aVar);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    private b0<T> a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.a aVar2) {
        g.a.y0.b.b.a(gVar, "onNext is null");
        g.a.y0.b.b.a(gVar2, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        g.a.y0.b.b.a(aVar2, "onAfterTerminate is null");
        return g.a.c1.a.a(new g.a.y0.e.d.m0(this, gVar, gVar2, aVar, aVar2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> a(g.a.x0.g<? super g.a.u0.c> gVar, g.a.x0.a aVar) {
        g.a.y0.b.b.a(gVar, "onSubscribe is null");
        g.a.y0.b.b.a(aVar, "onDispose is null");
        return g.a.c1.a.a(new g.a.y0.e.d.n0(this, gVar, aVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(long j2) {
        if (j2 >= 0) {
            return g.a.c1.a.a(new g.a.y0.e.d.p0(this, j2));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<T> a(long j2, T t) {
        if (j2 >= 0) {
            g.a.y0.b.b.a((Object) t, "defaultItem is null");
            return g.a.c1.a.a(new g.a.y0.e.d.q0(this, j2, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, boolean z, int i2) {
        return a(oVar, z, i2, L());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, boolean z, int i2, int i3) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "bufferSize");
        if (this instanceof g.a.y0.c.m) {
            Object objCall = ((g.a.y0.c.m) this).call();
            if (objCall == null) {
                return M();
            }
            return s2.a(objCall, oVar);
        }
        return g.a.c1.a.a(new u0(this, oVar, z, i2, i3));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, g.a.x0.o<? super Throwable, ? extends g0<? extends R>> oVar2, Callable<? extends g0<? extends R>> callable) {
        g.a.y0.b.b.a(oVar, "onNextMapper is null");
        g.a.y0.b.b.a(oVar2, "onErrorMapper is null");
        g.a.y0.b.b.a(callable, "onCompleteSupplier is null");
        return q(new v1(this, oVar, oVar2, callable));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends R>> oVar, g.a.x0.o<Throwable, ? extends g0<? extends R>> oVar2, Callable<? extends g0<? extends R>> callable, int i2) {
        g.a.y0.b.b.a(oVar, "onNextMapper is null");
        g.a.y0.b.b.a(oVar2, "onErrorMapper is null");
        g.a.y0.b.b.a(callable, "onCompleteSupplier is null");
        return d(new v1(this, oVar, oVar2, callable), i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        return a((g.a.x0.o) oVar, (g.a.x0.c) cVar, false, L(), L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return a(oVar, cVar, z, L(), L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return a(oVar, cVar, z, i2, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2, int i3) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(cVar, "combiner is null");
        return a(m1.a(oVar, cVar), z, i2, i3);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> b0<R> a(g.a.x0.o<? super T, ? extends g0<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, int i2) {
        return a((g.a.x0.o) oVar, (g.a.x0.c) cVar, false, i2, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c a(g.a.x0.r<? super T> rVar, g.a.x0.g<? super Throwable> gVar) {
        return a((g.a.x0.r) rVar, gVar, g.a.y0.b.a.f13899c);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c a(g.a.x0.r<? super T> rVar, g.a.x0.g<? super Throwable> gVar, g.a.x0.a aVar) {
        g.a.y0.b.b.a(rVar, "onNext is null");
        g.a.y0.b.b.a(gVar, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        g.a.y0.d.p pVar = new g.a.y0.d.p(rVar, gVar, aVar);
        subscribe(pVar);
        return pVar;
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> b0<g.a.z0.b<K, V>> a(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2) {
        return a((g.a.x0.o) oVar, (g.a.x0.o) oVar2, false, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> b0<g.a.z0.b<K, V>> a(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, boolean z) {
        return a(oVar, oVar2, z, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> b0<g.a.z0.b<K, V>> a(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, boolean z, int i2) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        g.a.y0.b.b.a(oVar2, "valueSelector is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new h1(this, oVar, oVar2, i2, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <TRight, TLeftEnd, TRightEnd, R> b0<R> a(g0<? extends TRight> g0Var, g.a.x0.o<? super T, ? extends g0<TLeftEnd>> oVar, g.a.x0.o<? super TRight, ? extends g0<TRightEnd>> oVar2, g.a.x0.c<? super T, ? super b0<TRight>, ? extends R> cVar) {
        g.a.y0.b.b.a(g0Var, "other is null");
        g.a.y0.b.b.a(oVar, "leftEnd is null");
        g.a.y0.b.b.a(oVar2, "rightEnd is null");
        g.a.y0.b.b.a(cVar, "resultSelector is null");
        return g.a.c1.a.a(new i1(this, g0Var, oVar, oVar2, cVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(f0<? extends R, ? super T> f0Var) {
        g.a.y0.b.b.a(f0Var, "onLift is null");
        return g.a.c1.a.a(new t1(this, f0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> a(j0 j0Var) {
        return a(j0Var, false, L());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> a(j0 j0Var, boolean z) {
        return a(j0Var, z, L());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> a(j0 j0Var, boolean z, int i2) {
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new y1(this, j0Var, z, i2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final s<T> a(g.a.x0.c<T, T, T> cVar) {
        g.a.y0.b.b.a(cVar, "reducer is null");
        return g.a.c1.a.a(new f2(this, cVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> k0<R> a(R r, g.a.x0.c<R, ? super T, R> cVar) {
        g.a.y0.b.b.a(r, "seed is null");
        g.a.y0.b.b.a(cVar, "reducer is null");
        return g.a.c1.a.a(new g2(this, r, cVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> k0<R> a(Callable<R> callable, g.a.x0.c<R, ? super T, R> cVar) {
        g.a.y0.b.b.a(callable, "seedSupplier is null");
        g.a.y0.b.b.a(cVar, "reducer is null");
        return g.a.c1.a.a(new h2(this, callable, cVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> a(g.a.x0.e eVar) {
        g.a.y0.b.b.a(eVar, "stop is null");
        return g.a.c1.a.a(new k2(this, eVar));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final <R> b0<R> a(g.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, int i2, long j2, TimeUnit timeUnit) {
        return a(oVar, i2, j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <R> b0<R> a(g.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a(m1.a(this, i2, j2, timeUnit, j0Var), (g.a.x0.o) oVar);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <R> b0<R> a(g.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, int i2, j0 j0Var) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return m2.a(m1.a(this, i2), m1.a(oVar, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final <R> b0<R> a(g.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, long j2, TimeUnit timeUnit) {
        return a(oVar, j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <R> b0<R> a(g.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a(m1.a(this, j2, timeUnit, j0Var), (g.a.x0.o) oVar);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final <R> b0<R> a(g.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, j0 j0Var) {
        g.a.y0.b.b.a(oVar, "selector is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a(m1.a(this), m1.a(oVar, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final g.a.z0.a<T> a(int i2, long j2, TimeUnit timeUnit) {
        return a(i2, j2, timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final g.a.z0.a<T> a(int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(i2, "bufferSize");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a(this, j2, timeUnit, j0Var, i2);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final g.a.z0.a<T> a(int i2, j0 j0Var) {
        g.a.y0.b.b.a(i2, "bufferSize");
        return m2.a((g.a.z0.a) d(i2), j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> a(long j2, g.a.x0.r<? super Throwable> rVar) {
        if (j2 >= 0) {
            g.a.y0.b.b.a(rVar, "predicate is null");
            return g.a.c1.a.a(new o2(this, j2, rVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U> b0<T> a(g0<U> g0Var, boolean z) {
        g.a.y0.b.b.a(g0Var, "sampler is null");
        return g.a.c1.a.a(new r2(this, g0Var, z));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new c3(this, j2, timeUnit, j0Var, i2 << 1, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> a(Comparator<? super T> comparator) {
        g.a.y0.b.b.a(comparator, "sortFunction is null");
        return J().p().p(g.a.y0.b.a.a((Comparator) comparator)).l((g.a.x0.o<? super R, ? extends Iterable<? extends U>>) g.a.y0.b.a.e());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> a(Iterable<? extends T> iterable) {
        return b(f((Iterable) iterable), this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<T> a(T... tArr) {
        b0 b0VarB = b((Object[]) tArr);
        if (b0VarB == M()) {
            return g.a.c1.a.a(this);
        }
        return b(b0VarB, this);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.u0.c a(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.g<? super g.a.u0.c> gVar3) {
        g.a.y0.b.b.a(gVar, "onNext is null");
        g.a.y0.b.b.a(gVar2, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        g.a.y0.b.b.a(gVar3, "onSubscribe is null");
        g.a.y0.d.v vVar = new g.a.y0.d.v(gVar, gVar2, aVar, gVar3);
        subscribe(vVar);
        return vVar;
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        if (j2 >= 0) {
            return g.a.c1.a.a(new l3(this, j2, j3, timeUnit, j0Var, i2, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<g.a.e1.c<T>> a(TimeUnit timeUnit) {
        return a(timeUnit, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<g.a.e1.c<T>> a(TimeUnit timeUnit, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new q3(this, timeUnit, j0Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <V> b0<T> a(g.a.x0.o<? super T, ? extends g0<V>> oVar, g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return b((g0) null, oVar, g0Var);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<T> a(long j2, TimeUnit timeUnit, g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return a(j2, timeUnit, g0Var, g.a.e1.a.a());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<T> a(long j2, TimeUnit timeUnit, j0 j0Var, g0<? extends T> g0Var) {
        g.a.y0.b.b.a(g0Var, "other is null");
        return a(j2, timeUnit, g0Var, j0Var);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> b0<T> a(g0<U> g0Var, g.a.x0.o<? super T, ? extends g0<V>> oVar, g0<? extends T> g0Var2) {
        g.a.y0.b.b.a(g0Var, "firstTimeoutIndicator is null");
        g.a.y0.b.b.a(g0Var2, "other is null");
        return b(g0Var, oVar, g0Var2);
    }

    private b0<T> a(long j2, TimeUnit timeUnit, g0<? extends T> g0Var, j0 j0Var) {
        g.a.y0.b.b.a(timeUnit, "timeUnit is null");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        return g.a.c1.a.a(new s3(this, j2, timeUnit, j0Var, g0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> a(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, Collection<V>>> callable, g.a.x0.o<? super K, ? extends Collection<? super V>> oVar3) {
        g.a.y0.b.b.a(oVar, "keySelector is null");
        g.a.y0.b.b.a(oVar2, "valueSelector is null");
        g.a.y0.b.b.a(callable, "mapSupplier is null");
        g.a.y0.b.b.a(oVar3, "collectionFactory is null");
        return (k0<Map<K, Collection<V>>>) a((Callable) callable, (g.a.x0.b) g.a.y0.b.a.a(oVar, oVar2, oVar3));
    }

    @g.a.t0.b(g.a.t0.a.SPECIAL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> a(b bVar) {
        g.a.y0.e.b.h1 h1Var = new g.a.y0.e.b.h1(this);
        int i2 = a.f13654a[bVar.ordinal()];
        if (i2 == 1) {
            return h1Var.v();
        }
        if (i2 == 2) {
            return h1Var.w();
        }
        if (i2 == 3) {
            return h1Var;
        }
        if (i2 != 4) {
            return h1Var.u();
        }
        return g.a.c1.a.a(new g.a.y0.e.b.h2(h1Var));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final k0<List<T>> a(Comparator<? super T> comparator, int i2) {
        g.a.y0.b.b.a(comparator, "comparator is null");
        return (k0<List<T>>) g(i2).h(g.a.y0.b.a.a((Comparator) comparator));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<b0<T>> a(long j2, long j3) {
        return a(j2, j3, L());
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final b0<b0<T>> a(long j2, long j3, int i2) {
        g.a.y0.b.b.a(j2, "count");
        g.a.y0.b.b.a(j3, "skip");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new y3(this, j2, j3, i2));
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<b0<T>> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, int i2) {
        g.a.y0.b.b.a(j2, "timespan");
        g.a.y0.b.b.a(j3, "timeskip");
        g.a.y0.b.b.a(i2, "bufferSize");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        return g.a.c1.a.a(new c4(this, j2, j3, timeUnit, j0Var, h.q2.t.m0.f16408b, i2, false));
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<b0<T>> a(long j2, TimeUnit timeUnit, long j3) {
        return a(j2, timeUnit, g.a.e1.a.a(), j3, false);
    }

    @g.a.t0.d
    @g.a.t0.h(g.a.t0.h.f13870j)
    public final b0<b0<T>> a(long j2, TimeUnit timeUnit, long j3, boolean z) {
        return a(j2, timeUnit, g.a.e1.a.a(), j3, z);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<b0<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3) {
        return a(j2, timeUnit, j0Var, j3, false);
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<b0<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3, boolean z) {
        return a(j2, timeUnit, j0Var, j3, z, L());
    }

    @g.a.t0.d
    @g.a.t0.h("custom")
    public final b0<b0<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3, boolean z, int i2) {
        g.a.y0.b.b.a(i2, "bufferSize");
        g.a.y0.b.b.a(j0Var, "scheduler is null");
        g.a.y0.b.b.a(timeUnit, "unit is null");
        g.a.y0.b.b.a(j3, "count");
        return g.a.c1.a.a(new c4(this, j2, j2, timeUnit, j0Var, j3, i2, z));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, V> b0<b0<T>> a(g0<U> g0Var, g.a.x0.o<? super U, ? extends g0<V>> oVar, int i2) {
        g.a.y0.b.b.a(g0Var, "openingIndicator is null");
        g.a.y0.b.b.a(oVar, "closingIndicator is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new a4(this, g0Var, oVar, i2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <B> b0<b0<T>> a(Callable<? extends g0<B>> callable, int i2) {
        g.a.y0.b.b.a(callable, "boundary is null");
        g.a.y0.b.b.a(i2, "bufferSize");
        return g.a.c1.a.a(new b4(this, callable, i2));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> b0<R> a(g0<? extends U> g0Var, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        g.a.y0.b.b.a(g0Var, "other is null");
        g.a.y0.b.b.a(cVar, "combiner is null");
        return g.a.c1.a.a(new d4(this, cVar, g0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T1, T2, R> b0<R> a(g0<T1> g0Var, g0<T2> g0Var2, g.a.x0.h<? super T, ? super T1, ? super T2, R> hVar) {
        g.a.y0.b.b.a(g0Var, "o1 is null");
        g.a.y0.b.b.a(g0Var2, "o2 is null");
        g.a.y0.b.b.a(hVar, "combiner is null");
        return a((g0<?>[]) new g0[]{g0Var, g0Var2}, g.a.y0.b.a.a((g.a.x0.h) hVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T1, T2, T3, R> b0<R> a(g0<T1> g0Var, g0<T2> g0Var2, g0<T3> g0Var3, g.a.x0.i<? super T, ? super T1, ? super T2, ? super T3, R> iVar) {
        g.a.y0.b.b.a(g0Var, "o1 is null");
        g.a.y0.b.b.a(g0Var2, "o2 is null");
        g.a.y0.b.b.a(g0Var3, "o3 is null");
        g.a.y0.b.b.a(iVar, "combiner is null");
        return a((g0<?>[]) new g0[]{g0Var, g0Var2, g0Var3}, g.a.y0.b.a.a((g.a.x0.i) iVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.a.t0.d
    @g.a.t0.h("none")
    public final <T1, T2, T3, T4, R> b0<R> a(g0<T1> g0Var, g0<T2> g0Var2, g0<T3> g0Var3, g0<T4> g0Var4, g.a.x0.j<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> jVar) {
        g.a.y0.b.b.a(g0Var, "o1 is null");
        g.a.y0.b.b.a(g0Var2, "o2 is null");
        g.a.y0.b.b.a(g0Var3, "o3 is null");
        g.a.y0.b.b.a(g0Var4, "o4 is null");
        g.a.y0.b.b.a(jVar, "combiner is null");
        return a((g0<?>[]) new g0[]{g0Var, g0Var2, g0Var3, g0Var4}, g.a.y0.b.a.a((g.a.x0.j) jVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(g0<?>[] g0VarArr, g.a.x0.o<? super Object[], R> oVar) {
        g.a.y0.b.b.a(g0VarArr, "others is null");
        g.a.y0.b.b.a(oVar, "combiner is null");
        return g.a.c1.a.a(new e4(this, g0VarArr, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <R> b0<R> a(Iterable<? extends g0<?>> iterable, g.a.x0.o<? super Object[], R> oVar) {
        g.a.y0.b.b.a(iterable, "others is null");
        g.a.y0.b.b.a(oVar, "combiner is null");
        return g.a.c1.a.a(new e4(this, iterable, oVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> b0<R> a(Iterable<U> iterable, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        g.a.y0.b.b.a(iterable, "other is null");
        g.a.y0.b.b.a(cVar, "zipper is null");
        return g.a.c1.a.a(new g4(this, iterable, cVar));
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> b0<R> a(g0<? extends U> g0Var, g.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return a(this, g0Var, cVar, z);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final <U, R> b0<R> a(g0<? extends U> g0Var, g.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return a(this, g0Var, cVar, z, i2);
    }

    @g.a.t0.d
    @g.a.t0.h("none")
    public final g.a.a1.n<T> a(boolean z) {
        g.a.a1.n<T> nVar = new g.a.a1.n<>();
        if (z) {
            nVar.dispose();
        }
        subscribe(nVar);
        return nVar;
    }
}
