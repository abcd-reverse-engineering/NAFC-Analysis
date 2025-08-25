package g.a.y0.e.d;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableInternalHelper.java */
/* loaded from: classes2.dex */
public final class m1 {

    /* compiled from: ObservableInternalHelper.java */
    static final class a<T> implements Callable<g.a.z0.a<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.b0<T> f15278a;

        /* renamed from: b, reason: collision with root package name */
        private final int f15279b;

        a(g.a.b0<T> b0Var, int i2) {
            this.f15278a = b0Var;
            this.f15279b = i2;
        }

        @Override // java.util.concurrent.Callable
        public g.a.z0.a<T> call() {
            return this.f15278a.d(this.f15279b);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class b<T> implements Callable<g.a.z0.a<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.b0<T> f15280a;

        /* renamed from: b, reason: collision with root package name */
        private final int f15281b;

        /* renamed from: c, reason: collision with root package name */
        private final long f15282c;

        /* renamed from: d, reason: collision with root package name */
        private final TimeUnit f15283d;

        /* renamed from: e, reason: collision with root package name */
        private final g.a.j0 f15284e;

        b(g.a.b0<T> b0Var, int i2, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.f15280a = b0Var;
            this.f15281b = i2;
            this.f15282c = j2;
            this.f15283d = timeUnit;
            this.f15284e = j0Var;
        }

        @Override // java.util.concurrent.Callable
        public g.a.z0.a<T> call() {
            return this.f15280a.a(this.f15281b, this.f15282c, this.f15283d, this.f15284e);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    enum c implements g.a.x0.o<g.a.a0<Object>, Throwable>, g.a.x0.r<g.a.a0<Object>> {
        INSTANCE;

        @Override // g.a.x0.o
        public Throwable apply(g.a.a0<Object> a0Var) throws Exception {
            return a0Var.a();
        }

        @Override // g.a.x0.r
        public boolean test(g.a.a0<Object> a0Var) throws Exception {
            return a0Var.d();
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class d<T, U> implements g.a.x0.o<T, g.a.g0<U>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super T, ? extends Iterable<? extends U>> f15286a;

        d(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
            this.f15286a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((d<T, U>) obj);
        }

        @Override // g.a.x0.o
        public g.a.g0<U> apply(T t) throws Exception {
            return new d1((Iterable) g.a.y0.b.b.a(this.f15286a.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class e<U, R, T> implements g.a.x0.o<U, R> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.c<? super T, ? super U, ? extends R> f15287a;

        /* renamed from: b, reason: collision with root package name */
        private final T f15288b;

        e(g.a.x0.c<? super T, ? super U, ? extends R> cVar, T t) {
            this.f15287a = cVar;
            this.f15288b = t;
        }

        @Override // g.a.x0.o
        public R apply(U u) throws Exception {
            return this.f15287a.apply(this.f15288b, u);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class f<T, R, U> implements g.a.x0.o<T, g.a.g0<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.c<? super T, ? super U, ? extends R> f15289a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> f15290b;

        f(g.a.x0.c<? super T, ? super U, ? extends R> cVar, g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> oVar) {
            this.f15289a = cVar;
            this.f15290b = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((f<T, R, U>) obj);
        }

        @Override // g.a.x0.o
        public g.a.g0<R> apply(T t) throws Exception {
            return new u1((g.a.g0) g.a.y0.b.b.a(this.f15290b.apply(t), "The mapper returned a null ObservableSource"), new e(this.f15289a, t));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class g<T, U> implements g.a.x0.o<T, g.a.g0<T>> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends g.a.g0<U>> f15291a;

        g(g.a.x0.o<? super T, ? extends g.a.g0<U>> oVar) {
            this.f15291a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((g<T, U>) obj);
        }

        @Override // g.a.x0.o
        public g.a.g0<T> apply(T t) throws Exception {
            return new i3((g.a.g0) g.a.y0.b.b.a(this.f15291a.apply(t), "The itemDelay returned a null ObservableSource"), 1L).p(g.a.y0.b.a.c(t)).f((g.a.b0<R>) t);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    enum h implements g.a.x0.o<Object, Object> {
        INSTANCE;

        @Override // g.a.x0.o
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class i<T, R> implements g.a.x0.o<T, g.a.b0<R>> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> f15293a;

        i(g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar) {
            this.f15293a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((i<T, R>) obj);
        }

        @Override // g.a.x0.o
        public g.a.b0<R> apply(T t) throws Exception {
            return g.a.c1.a.a(new g.a.y0.e.f.r0((g.a.q0) g.a.y0.b.b.a(this.f15293a.apply(t), "The mapper returned a null SingleSource")));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class j<T> implements g.a.x0.a {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<T> f15294a;

        j(g.a.i0<T> i0Var) {
            this.f15294a = i0Var;
        }

        @Override // g.a.x0.a
        public void run() throws Exception {
            this.f15294a.onComplete();
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class k<T> implements g.a.x0.g<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<T> f15295a;

        k(g.a.i0<T> i0Var) {
            this.f15295a = i0Var;
        }

        @Override // g.a.x0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f15295a.onError(th);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class l<T> implements g.a.x0.g<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<T> f15296a;

        l(g.a.i0<T> i0Var) {
            this.f15296a = i0Var;
        }

        @Override // g.a.x0.g
        public void accept(T t) throws Exception {
            this.f15296a.onNext(t);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class m implements g.a.x0.o<g.a.b0<g.a.a0<Object>>, g.a.g0<?>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super g.a.b0<Object>, ? extends g.a.g0<?>> f15297a;

        m(g.a.x0.o<? super g.a.b0<Object>, ? extends g.a.g0<?>> oVar) {
            this.f15297a = oVar;
        }

        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g.a.g0<?> apply(g.a.b0<g.a.a0<Object>> b0Var) throws Exception {
            return this.f15297a.apply(b0Var.p(h.INSTANCE));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class n<T> implements Callable<g.a.z0.a<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.b0<T> f15298a;

        n(g.a.b0<T> b0Var) {
            this.f15298a = b0Var;
        }

        @Override // java.util.concurrent.Callable
        public g.a.z0.a<T> call() {
            return this.f15298a.x();
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class o<T, R> implements g.a.x0.o<g.a.b0<T>, g.a.g0<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super g.a.b0<T>, ? extends g.a.g0<R>> f15299a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.j0 f15300b;

        o(g.a.x0.o<? super g.a.b0<T>, ? extends g.a.g0<R>> oVar, g.a.j0 j0Var) {
            this.f15299a = oVar;
            this.f15300b = j0Var;
        }

        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g.a.g0<R> apply(g.a.b0<T> b0Var) throws Exception {
            return g.a.b0.v((g.a.g0) g.a.y0.b.b.a(this.f15299a.apply(b0Var), "The selector returned a null ObservableSource")).a(this.f15300b);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class p implements g.a.x0.o<g.a.b0<g.a.a0<Object>>, g.a.g0<?>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super g.a.b0<Throwable>, ? extends g.a.g0<?>> f15301a;

        p(g.a.x0.o<? super g.a.b0<Throwable>, ? extends g.a.g0<?>> oVar) {
            this.f15301a = oVar;
        }

        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g.a.g0<?> apply(g.a.b0<g.a.a0<Object>> b0Var) throws Exception {
            return this.f15301a.apply(b0Var.h((g.a.x0.r<? super g.a.a0<Object>>) c.INSTANCE).p(c.INSTANCE));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class q<T, S> implements g.a.x0.c<S, g.a.k<T>, S> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.b<S, g.a.k<T>> f15302a;

        q(g.a.x0.b<S, g.a.k<T>> bVar) {
            this.f15302a = bVar;
        }

        @Override // g.a.x0.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, g.a.k<T> kVar) throws Exception {
            this.f15302a.a(s, kVar);
            return s;
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class r<T, S> implements g.a.x0.c<S, g.a.k<T>, S> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.g<g.a.k<T>> f15303a;

        r(g.a.x0.g<g.a.k<T>> gVar) {
            this.f15303a = gVar;
        }

        @Override // g.a.x0.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, g.a.k<T> kVar) throws Exception {
            this.f15303a.accept(kVar);
            return s;
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class s<T> implements Callable<g.a.z0.a<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.b0<T> f15304a;

        /* renamed from: b, reason: collision with root package name */
        private final long f15305b;

        /* renamed from: c, reason: collision with root package name */
        private final TimeUnit f15306c;

        /* renamed from: d, reason: collision with root package name */
        private final g.a.j0 f15307d;

        s(g.a.b0<T> b0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.f15304a = b0Var;
            this.f15305b = j2;
            this.f15306c = timeUnit;
            this.f15307d = j0Var;
        }

        @Override // java.util.concurrent.Callable
        public g.a.z0.a<T> call() {
            return this.f15304a.e(this.f15305b, this.f15306c, this.f15307d);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    static final class t<T, R> implements g.a.x0.o<List<g.a.g0<? extends T>>, g.a.g0<? extends R>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super Object[], ? extends R> f15308a;

        t(g.a.x0.o<? super Object[], ? extends R> oVar) {
            this.f15308a = oVar;
        }

        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g.a.g0<? extends R> apply(List<g.a.g0<? extends T>> list) {
            return g.a.b0.a((Iterable) list, (g.a.x0.o) this.f15308a, false, g.a.b0.L());
        }
    }

    private m1() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, S> g.a.x0.c<S, g.a.k<T>, S> a(g.a.x0.g<g.a.k<T>> gVar) {
        return new r(gVar);
    }

    public static <T> g.a.x0.g<Throwable> b(g.a.i0<T> i0Var) {
        return new k(i0Var);
    }

    public static <T, U> g.a.x0.o<T, g.a.g0<T>> c(g.a.x0.o<? super T, ? extends g.a.g0<U>> oVar) {
        return new g(oVar);
    }

    public static g.a.x0.o<g.a.b0<g.a.a0<Object>>, g.a.g0<?>> d(g.a.x0.o<? super g.a.b0<Object>, ? extends g.a.g0<?>> oVar) {
        return new m(oVar);
    }

    public static <T> g.a.x0.o<g.a.b0<g.a.a0<Object>>, g.a.g0<?>> e(g.a.x0.o<? super g.a.b0<Throwable>, ? extends g.a.g0<?>> oVar) {
        return new p(oVar);
    }

    public static <T, R> g.a.x0.o<List<g.a.g0<? extends T>>, g.a.g0<? extends R>> f(g.a.x0.o<? super Object[], ? extends R> oVar) {
        return new t(oVar);
    }

    public static <T, S> g.a.x0.c<S, g.a.k<T>, S> a(g.a.x0.b<S, g.a.k<T>> bVar) {
        return new q(bVar);
    }

    public static <T, U> g.a.x0.o<T, g.a.g0<U>> b(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return new d(oVar);
    }

    public static <T> g.a.x0.g<T> c(g.a.i0<T> i0Var) {
        return new l(i0Var);
    }

    public static <T> g.a.x0.a a(g.a.i0<T> i0Var) {
        return new j(i0Var);
    }

    public static <T, R> g.a.b0<R> b(g.a.b0<T> b0Var, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar) {
        return b0Var.g(a(oVar), 1);
    }

    public static <T, U, R> g.a.x0.o<T, g.a.g0<R>> a(g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        return new f(cVar, oVar);
    }

    public static <T> Callable<g.a.z0.a<T>> a(g.a.b0<T> b0Var) {
        return new n(b0Var);
    }

    public static <T> Callable<g.a.z0.a<T>> a(g.a.b0<T> b0Var, int i2) {
        return new a(b0Var, i2);
    }

    public static <T> Callable<g.a.z0.a<T>> a(g.a.b0<T> b0Var, int i2, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        return new b(b0Var, i2, j2, timeUnit, j0Var);
    }

    public static <T> Callable<g.a.z0.a<T>> a(g.a.b0<T> b0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        return new s(b0Var, j2, timeUnit, j0Var);
    }

    public static <T, R> g.a.x0.o<g.a.b0<T>, g.a.g0<R>> a(g.a.x0.o<? super g.a.b0<T>, ? extends g.a.g0<R>> oVar, g.a.j0 j0Var) {
        return new o(oVar, j0Var);
    }

    public static <T, R> g.a.b0<R> a(g.a.b0<T> b0Var, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar) {
        return b0Var.f(a(oVar), 1);
    }

    private static <T, R> g.a.x0.o<T, g.a.b0<R>> a(g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar) {
        g.a.y0.b.b.a(oVar, "mapper is null");
        return new i(oVar);
    }
}
