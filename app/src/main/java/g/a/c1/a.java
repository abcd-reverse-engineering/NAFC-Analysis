package g.a.c1;

import g.a.b0;
import g.a.b1.b;
import g.a.c;
import g.a.f;
import g.a.i0;
import g.a.j0;
import g.a.k0;
import g.a.l;
import g.a.n0;
import g.a.s;
import g.a.t0.g;
import g.a.v;
import g.a.v0.d;
import g.a.x0.e;
import g.a.x0.o;
import g.a.y0.g.h;
import g.a.y0.g.q;
import g.a.y0.j.k;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;

/* compiled from: RxJavaPlugins.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @g
    static volatile g.a.x0.g<? super Throwable> f13656a;

    /* renamed from: b, reason: collision with root package name */
    @g
    static volatile o<? super Runnable, ? extends Runnable> f13657b;

    /* renamed from: c, reason: collision with root package name */
    @g
    static volatile o<? super Callable<j0>, ? extends j0> f13658c;

    /* renamed from: d, reason: collision with root package name */
    @g
    static volatile o<? super Callable<j0>, ? extends j0> f13659d;

    /* renamed from: e, reason: collision with root package name */
    @g
    static volatile o<? super Callable<j0>, ? extends j0> f13660e;

    /* renamed from: f, reason: collision with root package name */
    @g
    static volatile o<? super Callable<j0>, ? extends j0> f13661f;

    /* renamed from: g, reason: collision with root package name */
    @g
    static volatile o<? super j0, ? extends j0> f13662g;

    /* renamed from: h, reason: collision with root package name */
    @g
    static volatile o<? super j0, ? extends j0> f13663h;

    /* renamed from: i, reason: collision with root package name */
    @g
    static volatile o<? super j0, ? extends j0> f13664i;

    /* renamed from: j, reason: collision with root package name */
    @g
    static volatile o<? super j0, ? extends j0> f13665j;

    /* renamed from: k, reason: collision with root package name */
    @g
    static volatile o<? super l, ? extends l> f13666k;

    /* renamed from: l, reason: collision with root package name */
    @g
    static volatile o<? super g.a.w0.a, ? extends g.a.w0.a> f13667l;

    /* renamed from: m, reason: collision with root package name */
    @g
    static volatile o<? super b0, ? extends b0> f13668m;

    @g
    static volatile o<? super g.a.z0.a, ? extends g.a.z0.a> n;

    @g
    static volatile o<? super s, ? extends s> o;

    @g
    static volatile o<? super k0, ? extends k0> p;
    static volatile o<? super c, ? extends c> q;

    @g
    static volatile o<? super b, ? extends b> r;

    @g
    static volatile g.a.x0.c<? super l, ? super i.d.c, ? extends i.d.c> s;

    @g
    static volatile g.a.x0.c<? super s, ? super v, ? extends v> t;

    @g
    static volatile g.a.x0.c<? super b0, ? super i0, ? extends i0> u;

    @g
    static volatile g.a.x0.c<? super k0, ? super n0, ? extends n0> v;

    @g
    static volatile g.a.x0.c<? super c, ? super f, ? extends f> w;

    @g
    static volatile e x;
    static volatile boolean y;
    static volatile boolean z;

    private a() {
        throw new IllegalStateException("No instances!");
    }

    public static void A() {
        y = true;
    }

    public static boolean B() {
        e eVar = x;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.getAsBoolean();
        } catch (Throwable th) {
            throw k.c(th);
        }
    }

    public static void C() {
        a((g.a.x0.g<? super Throwable>) null);
        p(null);
        a((o<? super j0, ? extends j0>) null);
        b((o<? super Callable<j0>, ? extends j0>) null);
        f(null);
        c((o<? super Callable<j0>, ? extends j0>) null);
        q(null);
        e((o<? super Callable<j0>, ? extends j0>) null);
        g(null);
        d((o<? super Callable<j0>, ? extends j0>) null);
        k(null);
        b((g.a.x0.c<? super l, ? super i.d.c, ? extends i.d.c>) null);
        m(null);
        d((g.a.x0.c<? super b0, ? super i0, ? extends i0>) null);
        o(null);
        e((g.a.x0.c<? super k0, ? super n0, ? extends n0>) null);
        h(null);
        a((g.a.x0.c<? super c, ? super f, ? extends f>) null);
        i(null);
        j(null);
        l(null);
        c((g.a.x0.c<? super s, v, ? extends v>) null);
        n(null);
        a(false);
        a((e) null);
    }

    static void D() {
        y = false;
    }

    public static void a(boolean z2) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        z = z2;
    }

    @g
    public static g.a.x0.g<? super Throwable> b() {
        return f13656a;
    }

    @g
    public static o<? super Callable<j0>, ? extends j0> c() {
        return f13658c;
    }

    @g
    public static o<? super Callable<j0>, ? extends j0> d() {
        return f13660e;
    }

    @g
    public static o<? super Callable<j0>, ? extends j0> e() {
        return f13661f;
    }

    @g
    public static o<? super Callable<j0>, ? extends j0> f() {
        return f13659d;
    }

    @g
    public static o<? super j0, ? extends j0> g() {
        return f13664i;
    }

    @g
    public static o<? super j0, ? extends j0> h() {
        return f13665j;
    }

    public static void i(@g o<? super g.a.w0.a, ? extends g.a.w0.a> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f13667l = oVar;
    }

    @g
    public static o<? super c, ? extends c> j() {
        return q;
    }

    @g
    public static g.a.x0.c<? super c, ? super f, ? extends f> k() {
        return w;
    }

    @g
    public static o<? super g.a.w0.a, ? extends g.a.w0.a> l() {
        return f13667l;
    }

    @g
    public static o<? super g.a.z0.a, ? extends g.a.z0.a> m() {
        return n;
    }

    @g
    public static o<? super l, ? extends l> n() {
        return f13666k;
    }

    @g
    public static g.a.x0.c<? super l, ? super i.d.c, ? extends i.d.c> o() {
        return s;
    }

    public static void p(@g o<? super Runnable, ? extends Runnable> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f13657b = oVar;
    }

    public static void q(@g o<? super j0, ? extends j0> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f13663h = oVar;
    }

    @g
    public static o<? super b0, ? extends b0> r() {
        return f13668m;
    }

    @g
    public static g.a.x0.c<? super b0, ? super i0, ? extends i0> s() {
        return u;
    }

    @g.a.t0.c
    @g
    public static o<? super b, ? extends b> t() {
        return r;
    }

    @g
    public static o<? super k0, ? extends k0> u() {
        return p;
    }

    @g
    public static g.a.x0.c<? super k0, ? super n0, ? extends n0> v() {
        return v;
    }

    @g
    public static o<? super Runnable, ? extends Runnable> w() {
        return f13657b;
    }

    @g
    public static o<? super j0, ? extends j0> x() {
        return f13663h;
    }

    public static boolean y() {
        return z;
    }

    public static boolean z() {
        return y;
    }

    @g.a.t0.f
    public static j0 b(@g.a.t0.f Callable<j0> callable) {
        g.a.y0.b.b.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<j0>, ? extends j0> oVar = f13658c;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    @g.a.t0.f
    public static j0 c(@g.a.t0.f Callable<j0> callable) {
        g.a.y0.b.b.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<j0>, ? extends j0> oVar = f13660e;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    @g.a.t0.f
    public static j0 d(@g.a.t0.f Callable<j0> callable) {
        g.a.y0.b.b.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<j0>, ? extends j0> oVar = f13661f;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    @g.a.t0.f
    public static j0 e(@g.a.t0.f Callable<j0> callable) {
        g.a.y0.b.b.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<j0>, ? extends j0> oVar = f13659d;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    public static void f(@g o<? super j0, ? extends j0> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f13664i = oVar;
    }

    public static void g(@g o<? super j0, ? extends j0> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f13665j = oVar;
    }

    public static void h(@g o<? super c, ? extends c> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        q = oVar;
    }

    public static void j(@g o<? super g.a.z0.a, ? extends g.a.z0.a> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        n = oVar;
    }

    public static void k(@g o<? super l, ? extends l> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f13666k = oVar;
    }

    public static void l(@g o<? super s, ? extends s> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        o = oVar;
    }

    public static void m(@g o<? super b0, ? extends b0> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f13668m = oVar;
    }

    @g.a.t0.c
    public static void n(@g o<? super b, ? extends b> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        r = oVar;
    }

    public static void o(@g o<? super k0, ? extends k0> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        p = oVar;
    }

    @g
    public static o<? super j0, ? extends j0> a() {
        return f13662g;
    }

    @g
    public static e i() {
        return x;
    }

    @g
    public static o<? super s, ? extends s> p() {
        return o;
    }

    @g
    public static g.a.x0.c<? super s, ? super v, ? extends v> q() {
        return t;
    }

    @g.a.t0.f
    public static j0 a(@g.a.t0.f j0 j0Var) {
        o<? super j0, ? extends j0> oVar = f13662g;
        return oVar == null ? j0Var : (j0) a((o<j0, R>) oVar, j0Var);
    }

    public static void b(@g.a.t0.f Throwable th) {
        g.a.x0.g<? super Throwable> gVar = f13656a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!a(th)) {
            th = new g.a.v0.f(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static void c(@g.a.t0.f Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    @g.a.t0.f
    public static j0 d(@g.a.t0.f j0 j0Var) {
        o<? super j0, ? extends j0> oVar = f13663h;
        return oVar == null ? j0Var : (j0) a((o<j0, R>) oVar, j0Var);
    }

    public static void e(@g o<? super Callable<j0>, ? extends j0> oVar) {
        if (!y) {
            f13659d = oVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static boolean a(Throwable th) {
        return (th instanceof d) || (th instanceof g.a.v0.c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof g.a.v0.a);
    }

    public static void d(@g o<? super Callable<j0>, ? extends j0> oVar) {
        if (!y) {
            f13661f = oVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @g.a.t0.f
    public static j0 c(@g.a.t0.f j0 j0Var) {
        o<? super j0, ? extends j0> oVar = f13665j;
        return oVar == null ? j0Var : (j0) a((o<j0, R>) oVar, j0Var);
    }

    public static void e(@g g.a.x0.c<? super k0, ? super n0, ? extends n0> cVar) {
        if (!y) {
            v = cVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void c(@g o<? super Callable<j0>, ? extends j0> oVar) {
        if (!y) {
            f13660e = oVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void d(@g g.a.x0.c<? super b0, ? super i0, ? extends i0> cVar) {
        if (!y) {
            u = cVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @g.a.t0.f
    public static Runnable a(@g.a.t0.f Runnable runnable) {
        o<? super Runnable, ? extends Runnable> oVar = f13657b;
        return oVar == null ? runnable : (Runnable) a((o<Runnable, R>) oVar, runnable);
    }

    public static void c(@g g.a.x0.c<? super s, v, ? extends v> cVar) {
        if (!y) {
            t = cVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @g.a.t0.f
    public static j0 d(@g.a.t0.f ThreadFactory threadFactory) {
        return new q((ThreadFactory) g.a.y0.b.b.a(threadFactory, "threadFactory is null"));
    }

    public static void a(@g o<? super j0, ? extends j0> oVar) {
        if (!y) {
            f13662g = oVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @g.a.t0.f
    public static j0 b(@g.a.t0.f j0 j0Var) {
        o<? super j0, ? extends j0> oVar = f13664i;
        return oVar == null ? j0Var : (j0) a((o<j0, R>) oVar, j0Var);
    }

    public static void b(@g o<? super Callable<j0>, ? extends j0> oVar) {
        if (!y) {
            f13658c = oVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @g.a.t0.f
    public static j0 c(@g.a.t0.f ThreadFactory threadFactory) {
        return new h((ThreadFactory) g.a.y0.b.b.a(threadFactory, "threadFactory is null"));
    }

    public static void a(@g g.a.x0.g<? super Throwable> gVar) {
        if (!y) {
            f13656a = gVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void b(@g g.a.x0.c<? super l, ? super i.d.c, ? extends i.d.c> cVar) {
        if (!y) {
            s = cVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void a(@g g.a.x0.c<? super c, ? super f, ? extends f> cVar) {
        if (!y) {
            w = cVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @g.a.t0.f
    public static j0 b(@g.a.t0.f ThreadFactory threadFactory) {
        return new g.a.y0.g.g((ThreadFactory) g.a.y0.b.b.a(threadFactory, "threadFactory is null"));
    }

    @g.a.t0.f
    public static <T> i.d.c<? super T> a(@g.a.t0.f l<T> lVar, @g.a.t0.f i.d.c<? super T> cVar) {
        g.a.x0.c<? super l, ? super i.d.c, ? extends i.d.c> cVar2 = s;
        return cVar2 != null ? (i.d.c) a(cVar2, lVar, cVar) : cVar;
    }

    @g.a.t0.f
    public static <T> i0<? super T> a(@g.a.t0.f b0<T> b0Var, @g.a.t0.f i0<? super T> i0Var) {
        g.a.x0.c<? super b0, ? super i0, ? extends i0> cVar = u;
        return cVar != null ? (i0) a(cVar, b0Var, i0Var) : i0Var;
    }

    @g.a.t0.f
    public static <T> n0<? super T> a(@g.a.t0.f k0<T> k0Var, @g.a.t0.f n0<? super T> n0Var) {
        g.a.x0.c<? super k0, ? super n0, ? extends n0> cVar = v;
        return cVar != null ? (n0) a(cVar, k0Var, n0Var) : n0Var;
    }

    @g.a.t0.f
    public static f a(@g.a.t0.f c cVar, @g.a.t0.f f fVar) {
        g.a.x0.c<? super c, ? super f, ? extends f> cVar2 = w;
        return cVar2 != null ? (f) a(cVar2, cVar, fVar) : fVar;
    }

    @g.a.t0.f
    public static <T> v<? super T> a(@g.a.t0.f s<T> sVar, @g.a.t0.f v<? super T> vVar) {
        g.a.x0.c<? super s, ? super v, ? extends v> cVar = t;
        return cVar != null ? (v) a(cVar, sVar, vVar) : vVar;
    }

    @g.a.t0.f
    public static <T> s<T> a(@g.a.t0.f s<T> sVar) {
        o<? super s, ? extends s> oVar = o;
        return oVar != null ? (s) a((o<s<T>, R>) oVar, sVar) : sVar;
    }

    @g.a.t0.f
    public static <T> l<T> a(@g.a.t0.f l<T> lVar) {
        o<? super l, ? extends l> oVar = f13666k;
        return oVar != null ? (l) a((o<l<T>, R>) oVar, lVar) : lVar;
    }

    @g.a.t0.f
    public static <T> g.a.w0.a<T> a(@g.a.t0.f g.a.w0.a<T> aVar) {
        o<? super g.a.w0.a, ? extends g.a.w0.a> oVar = f13667l;
        return oVar != null ? (g.a.w0.a) a((o<g.a.w0.a<T>, R>) oVar, aVar) : aVar;
    }

    @g.a.t0.f
    public static <T> b0<T> a(@g.a.t0.f b0<T> b0Var) {
        o<? super b0, ? extends b0> oVar = f13668m;
        return oVar != null ? (b0) a((o<b0<T>, R>) oVar, b0Var) : b0Var;
    }

    @g.a.t0.f
    public static <T> g.a.z0.a<T> a(@g.a.t0.f g.a.z0.a<T> aVar) {
        o<? super g.a.z0.a, ? extends g.a.z0.a> oVar = n;
        return oVar != null ? (g.a.z0.a) a((o<g.a.z0.a<T>, R>) oVar, aVar) : aVar;
    }

    @g.a.t0.f
    public static <T> k0<T> a(@g.a.t0.f k0<T> k0Var) {
        o<? super k0, ? extends k0> oVar = p;
        return oVar != null ? (k0) a((o<k0<T>, R>) oVar, k0Var) : k0Var;
    }

    @g.a.t0.f
    public static c a(@g.a.t0.f c cVar) {
        o<? super c, ? extends c> oVar = q;
        return oVar != null ? (c) a((o<c, R>) oVar, cVar) : cVar;
    }

    @g.a.t0.f
    @g.a.t0.c
    public static <T> b<T> a(@g.a.t0.f b<T> bVar) {
        o<? super b, ? extends b> oVar = r;
        return oVar != null ? (b) a((o<b<T>, R>) oVar, bVar) : bVar;
    }

    public static void a(@g e eVar) {
        if (!y) {
            x = eVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @g.a.t0.f
    public static j0 a(@g.a.t0.f ThreadFactory threadFactory) {
        return new g.a.y0.g.b((ThreadFactory) g.a.y0.b.b.a(threadFactory, "threadFactory is null"));
    }

    @g.a.t0.f
    static <T, R> R a(@g.a.t0.f o<T, R> oVar, @g.a.t0.f T t2) {
        try {
            return oVar.apply(t2);
        } catch (Throwable th) {
            throw k.c(th);
        }
    }

    @g.a.t0.f
    static <T, U, R> R a(@g.a.t0.f g.a.x0.c<T, U, R> cVar, @g.a.t0.f T t2, @g.a.t0.f U u2) {
        try {
            return cVar.apply(t2, u2);
        } catch (Throwable th) {
            throw k.c(th);
        }
    }

    @g.a.t0.f
    static j0 a(@g.a.t0.f Callable<j0> callable) {
        try {
            return (j0) g.a.y0.b.b.a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw k.c(th);
        }
    }

    @g.a.t0.f
    static j0 a(@g.a.t0.f o<? super Callable<j0>, ? extends j0> oVar, Callable<j0> callable) {
        return (j0) g.a.y0.b.b.a(a((o<Callable<j0>, R>) oVar, callable), "Scheduler Callable result can't be null");
    }
}
