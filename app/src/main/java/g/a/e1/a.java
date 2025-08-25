package g.a.e1;

import g.a.j0;
import g.a.y0.g.o;
import g.a.y0.g.q;
import g.a.y0.g.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Schedulers.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @g.a.t0.f
    static final j0 f13728a = g.a.c1.a.e(new h());

    /* renamed from: b, reason: collision with root package name */
    @g.a.t0.f
    static final j0 f13729b = g.a.c1.a.b(new b());

    /* renamed from: c, reason: collision with root package name */
    @g.a.t0.f
    static final j0 f13730c = g.a.c1.a.c(new c());

    /* renamed from: d, reason: collision with root package name */
    @g.a.t0.f
    static final j0 f13731d = r.e();

    /* renamed from: e, reason: collision with root package name */
    @g.a.t0.f
    static final j0 f13732e = g.a.c1.a.d(new f());

    /* compiled from: Schedulers.java */
    /* renamed from: g.a.e1.a$a, reason: collision with other inner class name */
    static final class C0172a {

        /* renamed from: a, reason: collision with root package name */
        static final j0 f13733a = new g.a.y0.g.b();

        C0172a() {
        }
    }

    /* compiled from: Schedulers.java */
    static final class b implements Callable<j0> {
        b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public j0 call() throws Exception {
            return C0172a.f13733a;
        }
    }

    /* compiled from: Schedulers.java */
    static final class c implements Callable<j0> {
        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public j0 call() throws Exception {
            return d.f13734a;
        }
    }

    /* compiled from: Schedulers.java */
    static final class d {

        /* renamed from: a, reason: collision with root package name */
        static final j0 f13734a = new g.a.y0.g.g();

        d() {
        }
    }

    /* compiled from: Schedulers.java */
    static final class e {

        /* renamed from: a, reason: collision with root package name */
        static final j0 f13735a = new g.a.y0.g.h();

        e() {
        }
    }

    /* compiled from: Schedulers.java */
    static final class f implements Callable<j0> {
        f() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public j0 call() throws Exception {
            return e.f13735a;
        }
    }

    /* compiled from: Schedulers.java */
    static final class g {

        /* renamed from: a, reason: collision with root package name */
        static final j0 f13736a = new q();

        g() {
        }
    }

    /* compiled from: Schedulers.java */
    static final class h implements Callable<j0> {
        h() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public j0 call() throws Exception {
            return g.f13736a;
        }
    }

    private a() {
        throw new IllegalStateException("No instances!");
    }

    @g.a.t0.f
    public static j0 a() {
        return g.a.c1.a.a(f13729b);
    }

    @g.a.t0.f
    public static j0 b() {
        return g.a.c1.a.b(f13730c);
    }

    @g.a.t0.f
    public static j0 c() {
        return g.a.c1.a.c(f13732e);
    }

    public static void d() {
        a().b();
        b().b();
        c().b();
        e().b();
        g().b();
        o.a();
    }

    @g.a.t0.f
    public static j0 e() {
        return g.a.c1.a.d(f13728a);
    }

    public static void f() {
        a().c();
        b().c();
        c().c();
        e().c();
        g().c();
        o.b();
    }

    @g.a.t0.f
    public static j0 g() {
        return f13731d;
    }

    @g.a.t0.f
    public static j0 a(@g.a.t0.f Executor executor) {
        return new g.a.y0.g.d(executor);
    }
}
