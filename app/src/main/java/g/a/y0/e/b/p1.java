package g.a.y0.e.b;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: FlowableInternalHelper.java */
/* loaded from: classes2.dex */
public final class p1 {

    /* compiled from: FlowableInternalHelper.java */
    static final class a<T> implements Callable<g.a.w0.a<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.l<T> f14473a;

        /* renamed from: b, reason: collision with root package name */
        private final int f14474b;

        a(g.a.l<T> lVar, int i2) {
            this.f14473a = lVar;
            this.f14474b = i2;
        }

        @Override // java.util.concurrent.Callable
        public g.a.w0.a<T> call() {
            return this.f14473a.h(this.f14474b);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class b<T> implements Callable<g.a.w0.a<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.l<T> f14475a;

        /* renamed from: b, reason: collision with root package name */
        private final int f14476b;

        /* renamed from: c, reason: collision with root package name */
        private final long f14477c;

        /* renamed from: d, reason: collision with root package name */
        private final TimeUnit f14478d;

        /* renamed from: e, reason: collision with root package name */
        private final g.a.j0 f14479e;

        b(g.a.l<T> lVar, int i2, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.f14475a = lVar;
            this.f14476b = i2;
            this.f14477c = j2;
            this.f14478d = timeUnit;
            this.f14479e = j0Var;
        }

        @Override // java.util.concurrent.Callable
        public g.a.w0.a<T> call() {
            return this.f14475a.a(this.f14476b, this.f14477c, this.f14478d, this.f14479e);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class c<T, U> implements g.a.x0.o<T, i.d.b<U>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super T, ? extends Iterable<? extends U>> f14480a;

        c(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
            this.f14480a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((c<T, U>) obj);
        }

        @Override // g.a.x0.o
        public i.d.b<U> apply(T t) throws Exception {
            return new g1((Iterable) g.a.y0.b.b.a(this.f14480a.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class d<U, R, T> implements g.a.x0.o<U, R> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.c<? super T, ? super U, ? extends R> f14481a;

        /* renamed from: b, reason: collision with root package name */
        private final T f14482b;

        d(g.a.x0.c<? super T, ? super U, ? extends R> cVar, T t) {
            this.f14481a = cVar;
            this.f14482b = t;
        }

        @Override // g.a.x0.o
        public R apply(U u) throws Exception {
            return this.f14481a.apply(this.f14482b, u);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class e<T, R, U> implements g.a.x0.o<T, i.d.b<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.c<? super T, ? super U, ? extends R> f14483a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.x0.o<? super T, ? extends i.d.b<? extends U>> f14484b;

        e(g.a.x0.c<? super T, ? super U, ? extends R> cVar, g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar) {
            this.f14483a = cVar;
            this.f14484b = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((e<T, R, U>) obj);
        }

        @Override // g.a.x0.o
        public i.d.b<R> apply(T t) throws Exception {
            return new a2((i.d.b) g.a.y0.b.b.a(this.f14484b.apply(t), "The mapper returned a null Publisher"), new d(this.f14483a, t));
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class f<T, U> implements g.a.x0.o<T, i.d.b<T>> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends i.d.b<U>> f14485a;

        f(g.a.x0.o<? super T, ? extends i.d.b<U>> oVar) {
            this.f14485a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((f<T, U>) obj);
        }

        @Override // g.a.x0.o
        public i.d.b<T> apply(T t) throws Exception {
            return new y3((i.d.b) g.a.y0.b.b.a(this.f14485a.apply(t), "The itemDelay returned a null Publisher"), 1L).o(g.a.y0.b.a.c(t)).f((g.a.l<R>) t);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class g<T> implements Callable<g.a.w0.a<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.l<T> f14486a;

        g(g.a.l<T> lVar) {
            this.f14486a = lVar;
        }

        @Override // java.util.concurrent.Callable
        public g.a.w0.a<T> call() {
            return this.f14486a.B();
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class h<T, R> implements g.a.x0.o<g.a.l<T>, i.d.b<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super g.a.l<T>, ? extends i.d.b<R>> f14487a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.j0 f14488b;

        h(g.a.x0.o<? super g.a.l<T>, ? extends i.d.b<R>> oVar, g.a.j0 j0Var) {
            this.f14487a = oVar;
            this.f14488b = j0Var;
        }

        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i.d.b<R> apply(g.a.l<T> lVar) throws Exception {
            return g.a.l.q((i.d.b) g.a.y0.b.b.a(this.f14487a.apply(lVar), "The selector returned a null Publisher")).a(this.f14488b);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    public enum i implements g.a.x0.g<i.d.d> {
        INSTANCE;

        @Override // g.a.x0.g
        public void accept(i.d.d dVar) throws Exception {
            dVar.request(h.q2.t.m0.f16408b);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class j<T, S> implements g.a.x0.c<S, g.a.k<T>, S> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.b<S, g.a.k<T>> f14490a;

        j(g.a.x0.b<S, g.a.k<T>> bVar) {
            this.f14490a = bVar;
        }

        @Override // g.a.x0.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, g.a.k<T> kVar) throws Exception {
            this.f14490a.a(s, kVar);
            return s;
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class k<T, S> implements g.a.x0.c<S, g.a.k<T>, S> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.g<g.a.k<T>> f14491a;

        k(g.a.x0.g<g.a.k<T>> gVar) {
            this.f14491a = gVar;
        }

        @Override // g.a.x0.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, g.a.k<T> kVar) throws Exception {
            this.f14491a.accept(kVar);
            return s;
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class l<T> implements g.a.x0.a {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<T> f14492a;

        l(i.d.c<T> cVar) {
            this.f14492a = cVar;
        }

        @Override // g.a.x0.a
        public void run() throws Exception {
            this.f14492a.onComplete();
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class m<T> implements g.a.x0.g<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<T> f14493a;

        m(i.d.c<T> cVar) {
            this.f14493a = cVar;
        }

        @Override // g.a.x0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f14493a.onError(th);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class n<T> implements g.a.x0.g<T> {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<T> f14494a;

        n(i.d.c<T> cVar) {
            this.f14494a = cVar;
        }

        @Override // g.a.x0.g
        public void accept(T t) throws Exception {
            this.f14494a.onNext(t);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class o<T> implements Callable<g.a.w0.a<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.l<T> f14495a;

        /* renamed from: b, reason: collision with root package name */
        private final long f14496b;

        /* renamed from: c, reason: collision with root package name */
        private final TimeUnit f14497c;

        /* renamed from: d, reason: collision with root package name */
        private final g.a.j0 f14498d;

        o(g.a.l<T> lVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.f14495a = lVar;
            this.f14496b = j2;
            this.f14497c = timeUnit;
            this.f14498d = j0Var;
        }

        @Override // java.util.concurrent.Callable
        public g.a.w0.a<T> call() {
            return this.f14495a.e(this.f14496b, this.f14497c, this.f14498d);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    static final class p<T, R> implements g.a.x0.o<List<i.d.b<? extends T>>, i.d.b<? extends R>> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super Object[], ? extends R> f14499a;

        p(g.a.x0.o<? super Object[], ? extends R> oVar) {
            this.f14499a = oVar;
        }

        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i.d.b<? extends R> apply(List<i.d.b<? extends T>> list) {
            return g.a.l.a((Iterable) list, (g.a.x0.o) this.f14499a, false, g.a.l.Q());
        }
    }

    private p1() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, S> g.a.x0.c<S, g.a.k<T>, S> a(g.a.x0.g<g.a.k<T>> gVar) {
        return new k(gVar);
    }

    public static <T, U> g.a.x0.o<T, i.d.b<T>> b(g.a.x0.o<? super T, ? extends i.d.b<U>> oVar) {
        return new f(oVar);
    }

    public static <T> g.a.x0.g<T> c(i.d.c<T> cVar) {
        return new n(cVar);
    }

    public static <T, S> g.a.x0.c<S, g.a.k<T>, S> a(g.a.x0.b<S, g.a.k<T>> bVar) {
        return new j(bVar);
    }

    public static <T> g.a.x0.g<Throwable> b(i.d.c<T> cVar) {
        return new m(cVar);
    }

    public static <T, R> g.a.x0.o<List<i.d.b<? extends T>>, i.d.b<? extends R>> c(g.a.x0.o<? super Object[], ? extends R> oVar) {
        return new p(oVar);
    }

    public static <T> g.a.x0.a a(i.d.c<T> cVar) {
        return new l(cVar);
    }

    public static <T, U, R> g.a.x0.o<T, i.d.b<R>> a(g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        return new e(cVar, oVar);
    }

    public static <T, U> g.a.x0.o<T, i.d.b<U>> a(g.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return new c(oVar);
    }

    public static <T> Callable<g.a.w0.a<T>> a(g.a.l<T> lVar) {
        return new g(lVar);
    }

    public static <T> Callable<g.a.w0.a<T>> a(g.a.l<T> lVar, int i2) {
        return new a(lVar, i2);
    }

    public static <T> Callable<g.a.w0.a<T>> a(g.a.l<T> lVar, int i2, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        return new b(lVar, i2, j2, timeUnit, j0Var);
    }

    public static <T> Callable<g.a.w0.a<T>> a(g.a.l<T> lVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        return new o(lVar, j2, timeUnit, j0Var);
    }

    public static <T, R> g.a.x0.o<g.a.l<T>, i.d.b<R>> a(g.a.x0.o<? super g.a.l<T>, ? extends i.d.b<R>> oVar, g.a.j0 j0Var) {
        return new h(oVar, j0Var);
    }
}
