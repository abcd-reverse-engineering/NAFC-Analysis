package g.a.b1;

import g.a.j0;
import g.a.l;
import g.a.t0.e;
import g.a.t0.f;
import g.a.x0.o;
import g.a.x0.q;
import g.a.x0.r;
import g.a.y0.e.e.h;
import g.a.y0.e.e.i;
import g.a.y0.e.e.j;
import g.a.y0.e.e.m;
import g.a.y0.e.e.n;
import g.a.y0.i.g;
import g.a.y0.j.k;
import g.a.y0.j.p;
import g.a.y0.j.w;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: ParallelFlowable.java */
@g.a.t0.c
/* loaded from: classes2.dex */
public abstract class b<T> {
    @g.a.t0.d
    public static <T> b<T> a(@f i.d.b<? extends T> bVar) {
        return a(bVar, Runtime.getRuntime().availableProcessors(), l.Q());
    }

    public abstract int a();

    public abstract void a(@f i.d.c<? super T>[] cVarArr);

    protected final boolean b(@f i.d.c<?>[] cVarArr) {
        int iA = a();
        if (cVarArr.length == iA) {
            return true;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + iA + ", subscribers = " + cVarArr.length);
        for (i.d.c<?> cVar : cVarArr) {
            g.error(illegalArgumentException, cVar);
        }
        return false;
    }

    @f
    @g.a.t0.d
    public final <R> b<R> c(@f o<? super T, ? extends R> oVar) {
        g.a.y0.b.b.a(oVar, "mapper");
        return g.a.c1.a.a(new j(this, oVar));
    }

    @f
    @g.a.t0.d
    public final b<T> d(@f g.a.x0.g<? super i.d.d> gVar) {
        g.a.y0.b.b.a(gVar, "onSubscribe is null");
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.g gVarD3 = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new g.a.y0.e.e.l(this, gVarD, gVarD2, gVarD3, aVar, aVar, gVar, g.a.y0.b.a.f13903g, g.a.y0.b.a.f13899c));
    }

    @g.a.t0.d
    public static <T> b<T> a(@f i.d.b<? extends T> bVar, int i2) {
        return a(bVar, i2, l.Q());
    }

    @f
    @g.a.t0.d
    public static <T> b<T> a(@f i.d.b<? extends T> bVar, int i2, int i3) {
        g.a.y0.b.b.a(bVar, "source");
        g.a.y0.b.b.a(i2, "parallelism");
        g.a.y0.b.b.a(i3, "prefetch");
        return g.a.c1.a.a(new h(bVar, i2, i3));
    }

    @f
    @e
    @g.a.t0.h("none")
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    public final l<T> c() {
        return b(l.Q());
    }

    @f
    @g.a.t0.d
    public final b<T> c(@f g.a.x0.g<? super T> gVar) {
        g.a.y0.b.b.a(gVar, "onNext is null");
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new g.a.y0.e.e.l(this, gVar, gVarD, gVarD2, aVar, aVar, g.a.y0.b.a.d(), g.a.y0.b.a.f13903g, g.a.y0.b.a.f13899c));
    }

    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    @g.a.t0.h("none")
    public final l<T> b() {
        return a(l.Q());
    }

    @f
    @e
    @g.a.t0.d
    public final <R> R a(@f c<T, R> cVar) {
        return (R) ((c) g.a.y0.b.b.a(cVar, "converter is null")).a(this);
    }

    @f
    @g.a.t0.h("none")
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    public final l<T> b(int i2) {
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new i(this, i2, true));
    }

    @f
    @g.a.t0.d
    public final <U> U d(@f o<? super b<T>, U> oVar) {
        try {
            return (U) ((o) g.a.y0.b.b.a(oVar, "converter is null")).apply(this);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            throw k.c(th);
        }
    }

    @f
    @e
    @g.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends R> oVar, @f a aVar) {
        g.a.y0.b.b.a(oVar, "mapper");
        g.a.y0.b.b.a(aVar, "errorHandler is null");
        return g.a.c1.a.a(new g.a.y0.e.e.k(this, oVar, aVar));
    }

    @f
    @g.a.t0.d
    public final l<List<T>> b(@f Comparator<? super T> comparator) {
        return b(comparator, 16);
    }

    @f
    @g.a.t0.d
    public final l<List<T>> b(@f Comparator<? super T> comparator, int i2) {
        g.a.y0.b.b.a(comparator, "comparator is null");
        g.a.y0.b.b.a(i2, "capacityHint");
        return g.a.c1.a.a(a(g.a.y0.b.a.a((i2 / a()) + 1), g.a.y0.j.o.instance()).c(new w(comparator)).a(new p(comparator)));
    }

    @f
    @g.a.t0.d
    public final b<T> c(@f g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onComplete is null");
        return g.a.c1.a.a(new g.a.y0.e.e.l(this, g.a.y0.b.a.d(), g.a.y0.b.a.d(), g.a.y0.b.a.d(), aVar, g.a.y0.b.a.f13899c, g.a.y0.b.a.d(), g.a.y0.b.a.f13903g, g.a.y0.b.a.f13899c));
    }

    @f
    @e
    @g.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends R> oVar, @f g.a.x0.c<? super Long, ? super Throwable, a> cVar) {
        g.a.y0.b.b.a(oVar, "mapper");
        g.a.y0.b.b.a(cVar, "errorHandler is null");
        return g.a.c1.a.a(new g.a.y0.e.e.k(this, oVar, cVar));
    }

    @g.a.t0.d
    public final b<T> a(@f r<? super T> rVar) {
        g.a.y0.b.b.a(rVar, "predicate");
        return g.a.c1.a.a(new g.a.y0.e.e.d(this, rVar));
    }

    @e
    @g.a.t0.d
    public final b<T> a(@f r<? super T> rVar, @f a aVar) {
        g.a.y0.b.b.a(rVar, "predicate");
        g.a.y0.b.b.a(aVar, "errorHandler is null");
        return g.a.c1.a.a(new g.a.y0.e.e.e(this, rVar, aVar));
    }

    @f
    @g.a.t0.d
    public final b<T> b(@f g.a.x0.g<Throwable> gVar) {
        g.a.y0.b.b.a(gVar, "onError is null");
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new g.a.y0.e.e.l(this, gVarD, gVarD2, gVar, aVar, aVar, g.a.y0.b.a.d(), g.a.y0.b.a.f13903g, g.a.y0.b.a.f13899c));
    }

    @e
    @g.a.t0.d
    public final b<T> a(@f r<? super T> rVar, @f g.a.x0.c<? super Long, ? super Throwable, a> cVar) {
        g.a.y0.b.b.a(rVar, "predicate");
        g.a.y0.b.b.a(cVar, "errorHandler is null");
        return g.a.c1.a.a(new g.a.y0.e.e.e(this, rVar, cVar));
    }

    @f
    @g.a.t0.d
    public final b<T> a(@f j0 j0Var) {
        return a(j0Var, l.Q());
    }

    @f
    @g.a.t0.d
    public final b<T> a(@f j0 j0Var, int i2) {
        g.a.y0.b.b.a(j0Var, "scheduler");
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.e.o(this, j0Var, i2));
    }

    @f
    @g.a.t0.d
    public final b<T> b(@f g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onCancel is null");
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.g gVarD3 = g.a.y0.b.a.d();
        g.a.x0.a aVar2 = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new g.a.y0.e.e.l(this, gVarD, gVarD2, gVarD3, aVar2, aVar2, g.a.y0.b.a.d(), g.a.y0.b.a.f13903g, aVar));
    }

    @f
    @g.a.t0.d
    public final l<T> a(@f g.a.x0.c<T, T, T> cVar) {
        g.a.y0.b.b.a(cVar, "reducer");
        return g.a.c1.a.a(new n(this, cVar));
    }

    @f
    @g.a.t0.d
    public final <R> b<R> a(@f Callable<R> callable, @f g.a.x0.c<R, ? super T, R> cVar) {
        g.a.y0.b.b.a(callable, "initialSupplier");
        g.a.y0.b.b.a(cVar, "reducer");
        return g.a.c1.a.a(new m(this, callable, cVar));
    }

    @f
    @g.a.t0.d
    public final <R> b<R> b(@f o<? super T, ? extends i.d.b<? extends R>> oVar) {
        return a(oVar, false, Integer.MAX_VALUE, l.Q());
    }

    @f
    @g.a.t0.h("none")
    @g.a.t0.b(g.a.t0.a.FULL)
    @g.a.t0.d
    public final l<T> a(int i2) {
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new i(this, i2, false));
    }

    @f
    @g.a.t0.d
    public final <R> b<R> b(@f o<? super T, ? extends i.d.b<? extends R>> oVar, boolean z) {
        return a(oVar, z, Integer.MAX_VALUE, l.Q());
    }

    @f
    @g.a.t0.d
    public final l<T> a(@f Comparator<? super T> comparator) {
        return a(comparator, 16);
    }

    @f
    @g.a.t0.d
    public final l<T> a(@f Comparator<? super T> comparator, int i2) {
        g.a.y0.b.b.a(comparator, "comparator is null");
        g.a.y0.b.b.a(i2, "capacityHint");
        return g.a.c1.a.a(new g.a.y0.e.e.p(a(g.a.y0.b.a.a((i2 / a()) + 1), g.a.y0.j.o.instance()).c(new w(comparator)), comparator));
    }

    @f
    @e
    @g.a.t0.d
    public final b<T> a(@f g.a.x0.g<? super T> gVar, @f a aVar) {
        g.a.y0.b.b.a(gVar, "onNext is null");
        g.a.y0.b.b.a(aVar, "errorHandler is null");
        return g.a.c1.a.a(new g.a.y0.e.e.c(this, gVar, aVar));
    }

    @f
    @e
    @g.a.t0.d
    public final b<T> a(@f g.a.x0.g<? super T> gVar, @f g.a.x0.c<? super Long, ? super Throwable, a> cVar) {
        g.a.y0.b.b.a(gVar, "onNext is null");
        g.a.y0.b.b.a(cVar, "errorHandler is null");
        return g.a.c1.a.a(new g.a.y0.e.e.c(this, gVar, cVar));
    }

    @f
    @g.a.t0.d
    public final b<T> a(@f g.a.x0.g<? super T> gVar) {
        g.a.y0.b.b.a(gVar, "onAfterNext is null");
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new g.a.y0.e.e.l(this, gVarD, gVar, gVarD2, aVar, aVar, g.a.y0.b.a.d(), g.a.y0.b.a.f13903g, g.a.y0.b.a.f13899c));
    }

    @f
    @g.a.t0.d
    public final b<T> a(@f g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "onAfterTerminate is null");
        return g.a.c1.a.a(new g.a.y0.e.e.l(this, g.a.y0.b.a.d(), g.a.y0.b.a.d(), g.a.y0.b.a.d(), g.a.y0.b.a.f13899c, aVar, g.a.y0.b.a.d(), g.a.y0.b.a.f13903g, g.a.y0.b.a.f13899c));
    }

    @f
    @g.a.t0.d
    public final b<T> a(@f q qVar) {
        g.a.y0.b.b.a(qVar, "onRequest is null");
        g.a.x0.g gVarD = g.a.y0.b.a.d();
        g.a.x0.g gVarD2 = g.a.y0.b.a.d();
        g.a.x0.g gVarD3 = g.a.y0.b.a.d();
        g.a.x0.a aVar = g.a.y0.b.a.f13899c;
        return g.a.c1.a.a(new g.a.y0.e.e.l(this, gVarD, gVarD2, gVarD3, aVar, aVar, g.a.y0.b.a.d(), qVar, g.a.y0.b.a.f13899c));
    }

    @f
    @g.a.t0.d
    public final <C> b<C> a(@f Callable<? extends C> callable, @f g.a.x0.b<? super C, ? super T> bVar) {
        g.a.y0.b.b.a(callable, "collectionSupplier is null");
        g.a.y0.b.b.a(bVar, "collector is null");
        return g.a.c1.a.a(new g.a.y0.e.e.a(this, callable, bVar));
    }

    @f
    @g.a.t0.d
    public static <T> b<T> a(@f i.d.b<T>... bVarArr) {
        if (bVarArr.length != 0) {
            return g.a.c1.a.a(new g.a.y0.e.e.g(bVarArr));
        }
        throw new IllegalArgumentException("Zero publishers not supported");
    }

    @f
    @g.a.t0.d
    public final <U> b<U> a(@f d<T, U> dVar) {
        return g.a.c1.a.a(((d) g.a.y0.b.b.a(dVar, "composer is null")).a(this));
    }

    @f
    @g.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends i.d.b<? extends R>> oVar, boolean z, int i2) {
        return a(oVar, z, i2, l.Q());
    }

    @f
    @g.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends i.d.b<? extends R>> oVar, boolean z, int i2, int i3) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "maxConcurrency");
        g.a.y0.b.b.a(i3, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.e.f(this, oVar, z, i2, i3));
    }

    @f
    @g.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends i.d.b<? extends R>> oVar) {
        return a(oVar, 2);
    }

    @f
    @g.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends i.d.b<? extends R>> oVar, int i2) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.e.b(this, oVar, i2, g.a.y0.j.j.IMMEDIATE));
    }

    @f
    @g.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends i.d.b<? extends R>> oVar, boolean z) {
        return a(oVar, 2, z);
    }

    @f
    @g.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, boolean z) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        g.a.y0.b.b.a(i2, "prefetch");
        return g.a.c1.a.a(new g.a.y0.e.e.b(this, oVar, i2, z ? g.a.y0.j.j.END : g.a.y0.j.j.BOUNDARY));
    }
}
