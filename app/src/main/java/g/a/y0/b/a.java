package g.a.y0.b;

import h.q2.t.m0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Functions.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static final g.a.x0.o<Object, Object> f13897a = new w();

    /* renamed from: b, reason: collision with root package name */
    public static final Runnable f13898b = new q();

    /* renamed from: c, reason: collision with root package name */
    public static final g.a.x0.a f13899c = new n();

    /* renamed from: d, reason: collision with root package name */
    static final g.a.x0.g<Object> f13900d = new o();

    /* renamed from: e, reason: collision with root package name */
    public static final g.a.x0.g<Throwable> f13901e = new s();

    /* renamed from: f, reason: collision with root package name */
    public static final g.a.x0.g<Throwable> f13902f = new g0();

    /* renamed from: g, reason: collision with root package name */
    public static final g.a.x0.q f13903g = new p();

    /* renamed from: h, reason: collision with root package name */
    static final g.a.x0.r<Object> f13904h = new l0();

    /* renamed from: i, reason: collision with root package name */
    static final g.a.x0.r<Object> f13905i = new t();

    /* renamed from: j, reason: collision with root package name */
    static final Callable<Object> f13906j = new f0();

    /* renamed from: k, reason: collision with root package name */
    static final Comparator<Object> f13907k = new b0();

    /* renamed from: l, reason: collision with root package name */
    public static final g.a.x0.g<i.d.d> f13908l = new z();

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$a, reason: collision with other inner class name */
    static final class C0180a<T> implements g.a.x0.g<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.a f13909a;

        C0180a(g.a.x0.a aVar) {
            this.f13909a = aVar;
        }

        @Override // g.a.x0.g
        public void accept(T t) throws Exception {
            this.f13909a.run();
        }
    }

    /* compiled from: Functions.java */
    enum a0 implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    static final class b<T1, T2, R> implements g.a.x0.o<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.c<? super T1, ? super T2, ? extends R> f13911a;

        b(g.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
            this.f13911a = cVar;
        }

        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f13911a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    static final class b0 implements Comparator<Object> {
        b0() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    static final class c<T1, T2, T3, R> implements g.a.x0.o<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.h<T1, T2, T3, R> f13912a;

        c(g.a.x0.h<T1, T2, T3, R> hVar) {
            this.f13912a = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return (R) this.f13912a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    static final class c0<T> implements g.a.x0.a {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.g<? super g.a.a0<T>> f13913a;

        c0(g.a.x0.g<? super g.a.a0<T>> gVar) {
            this.f13913a = gVar;
        }

        @Override // g.a.x0.a
        public void run() throws Exception {
            this.f13913a.accept(g.a.a0.f());
        }
    }

    /* compiled from: Functions.java */
    static final class d<T1, T2, T3, T4, R> implements g.a.x0.o<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.i<T1, T2, T3, T4, R> f13914a;

        d(g.a.x0.i<T1, T2, T3, T4, R> iVar) {
            this.f13914a = iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return (R) this.f13914a.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    static final class d0<T> implements g.a.x0.g<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.g<? super g.a.a0<T>> f13915a;

        d0(g.a.x0.g<? super g.a.a0<T>> gVar) {
            this.f13915a = gVar;
        }

        @Override // g.a.x0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f13915a.accept(g.a.a0.a(th));
        }
    }

    /* compiled from: Functions.java */
    static final class e<T1, T2, T3, T4, T5, R> implements g.a.x0.o<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.j<T1, T2, T3, T4, T5, R> f13916a;

        e(g.a.x0.j<T1, T2, T3, T4, T5, R> jVar) {
            this.f13916a = jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 5) {
                return (R) this.f13916a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    static final class e0<T> implements g.a.x0.g<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.g<? super g.a.a0<T>> f13917a;

        e0(g.a.x0.g<? super g.a.a0<T>> gVar) {
            this.f13917a = gVar;
        }

        @Override // g.a.x0.g
        public void accept(T t) throws Exception {
            this.f13917a.accept(g.a.a0.a(t));
        }
    }

    /* compiled from: Functions.java */
    static final class f<T1, T2, T3, T4, T5, T6, R> implements g.a.x0.o<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.k<T1, T2, T3, T4, T5, T6, R> f13918a;

        f(g.a.x0.k<T1, T2, T3, T4, T5, T6, R> kVar) {
            this.f13918a = kVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 6) {
                return (R) this.f13918a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    static final class f0 implements Callable<Object> {
        f0() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements g.a.x0.o<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.l<T1, T2, T3, T4, T5, T6, T7, R> f13919a;

        g(g.a.x0.l<T1, T2, T3, T4, T5, T6, T7, R> lVar) {
            this.f13919a = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 7) {
                return (R) this.f13919a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    static final class g0 implements g.a.x0.g<Throwable> {
        g0() {
        }

        @Override // g.a.x0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            g.a.c1.a.b(new g.a.v0.d(th));
        }
    }

    /* compiled from: Functions.java */
    static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements g.a.x0.o<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.m<T1, T2, T3, T4, T5, T6, T7, T8, R> f13920a;

        h(g.a.x0.m<T1, T2, T3, T4, T5, T6, T7, T8, R> mVar) {
            this.f13920a = mVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 8) {
                return (R) this.f13920a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    static final class h0<T> implements g.a.x0.o<T, g.a.e1.c<T>> {

        /* renamed from: a, reason: collision with root package name */
        final TimeUnit f13921a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.j0 f13922b;

        h0(TimeUnit timeUnit, g.a.j0 j0Var) {
            this.f13921a = timeUnit;
            this.f13922b = j0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((h0<T>) obj);
        }

        @Override // g.a.x0.o
        public g.a.e1.c<T> apply(T t) throws Exception {
            return new g.a.e1.c<>(t, this.f13922b.a(this.f13921a), this.f13921a);
        }
    }

    /* compiled from: Functions.java */
    static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements g.a.x0.o<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f13923a;

        i(g.a.x0.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> nVar) {
            this.f13923a = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return (R) this.f13923a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    static final class i0<K, T> implements g.a.x0.b<Map<K, T>, T> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super T, ? extends K> f13924a;

        i0(g.a.x0.o<? super T, ? extends K> oVar) {
            this.f13924a = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.b
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) throws Exception {
            a((Map<K, Map<K, T>>) obj, (Map<K, T>) obj2);
        }

        public void a(Map<K, T> map, T t) throws Exception {
            map.put(this.f13924a.apply(t), t);
        }
    }

    /* compiled from: Functions.java */
    static final class j<T> implements Callable<List<T>> {

        /* renamed from: a, reason: collision with root package name */
        final int f13925a;

        j(int i2) {
            this.f13925a = i2;
        }

        @Override // java.util.concurrent.Callable
        public List<T> call() throws Exception {
            return new ArrayList(this.f13925a);
        }
    }

    /* compiled from: Functions.java */
    static final class j0<K, V, T> implements g.a.x0.b<Map<K, V>, T> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super T, ? extends V> f13926a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.x0.o<? super T, ? extends K> f13927b;

        j0(g.a.x0.o<? super T, ? extends V> oVar, g.a.x0.o<? super T, ? extends K> oVar2) {
            this.f13926a = oVar;
            this.f13927b = oVar2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.b
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) throws Exception {
            a((Map) obj, (Map<K, V>) obj2);
        }

        public void a(Map<K, V> map, T t) throws Exception {
            map.put(this.f13927b.apply(t), this.f13926a.apply(t));
        }
    }

    /* compiled from: Functions.java */
    static final class k<T> implements g.a.x0.r<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.x0.e f13928a;

        k(g.a.x0.e eVar) {
            this.f13928a = eVar;
        }

        @Override // g.a.x0.r
        public boolean test(T t) throws Exception {
            return !this.f13928a.getAsBoolean();
        }
    }

    /* compiled from: Functions.java */
    static final class k0<K, V, T> implements g.a.x0.b<Map<K, Collection<V>>, T> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.x0.o<? super K, ? extends Collection<? super V>> f13929a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.x0.o<? super T, ? extends V> f13930b;

        /* renamed from: c, reason: collision with root package name */
        private final g.a.x0.o<? super T, ? extends K> f13931c;

        k0(g.a.x0.o<? super K, ? extends Collection<? super V>> oVar, g.a.x0.o<? super T, ? extends V> oVar2, g.a.x0.o<? super T, ? extends K> oVar3) {
            this.f13929a = oVar;
            this.f13930b = oVar2;
            this.f13931c = oVar3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.x0.b
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) throws Exception {
            a((Map) obj, (Map<K, Collection<V>>) obj2);
        }

        public void a(Map<K, Collection<V>> map, T t) throws Exception {
            K kApply = this.f13931c.apply(t);
            Collection<? super V> collectionApply = (Collection) map.get(kApply);
            if (collectionApply == null) {
                collectionApply = this.f13929a.apply(kApply);
                map.put(kApply, collectionApply);
            }
            collectionApply.add(this.f13930b.apply(t));
        }
    }

    /* compiled from: Functions.java */
    static final class l<T, U> implements g.a.x0.o<T, U> {

        /* renamed from: a, reason: collision with root package name */
        final Class<U> f13932a;

        l(Class<U> cls) {
            this.f13932a = cls;
        }

        @Override // g.a.x0.o
        public U apply(T t) throws Exception {
            return this.f13932a.cast(t);
        }
    }

    /* compiled from: Functions.java */
    static final class l0 implements g.a.x0.r<Object> {
        l0() {
        }

        @Override // g.a.x0.r
        public boolean test(Object obj) {
            return true;
        }
    }

    /* compiled from: Functions.java */
    static final class m<T, U> implements g.a.x0.r<T> {

        /* renamed from: a, reason: collision with root package name */
        final Class<U> f13933a;

        m(Class<U> cls) {
            this.f13933a = cls;
        }

        @Override // g.a.x0.r
        public boolean test(T t) throws Exception {
            return this.f13933a.isInstance(t);
        }
    }

    /* compiled from: Functions.java */
    static final class n implements g.a.x0.a {
        n() {
        }

        @Override // g.a.x0.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    static final class o implements g.a.x0.g<Object> {
        o() {
        }

        @Override // g.a.x0.g
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    static final class p implements g.a.x0.q {
        p() {
        }

        @Override // g.a.x0.q
        public void a(long j2) {
        }
    }

    /* compiled from: Functions.java */
    static final class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    static final class r<T> implements g.a.x0.r<T> {

        /* renamed from: a, reason: collision with root package name */
        final T f13934a;

        r(T t) {
            this.f13934a = t;
        }

        @Override // g.a.x0.r
        public boolean test(T t) throws Exception {
            return g.a.y0.b.b.a(t, this.f13934a);
        }
    }

    /* compiled from: Functions.java */
    static final class s implements g.a.x0.g<Throwable> {
        s() {
        }

        @Override // g.a.x0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            g.a.c1.a.b(th);
        }
    }

    /* compiled from: Functions.java */
    static final class t implements g.a.x0.r<Object> {
        t() {
        }

        @Override // g.a.x0.r
        public boolean test(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    static final class u implements g.a.x0.a {

        /* renamed from: a, reason: collision with root package name */
        final Future<?> f13935a;

        u(Future<?> future) {
            this.f13935a = future;
        }

        @Override // g.a.x0.a
        public void run() throws Exception {
            this.f13935a.get();
        }
    }

    /* compiled from: Functions.java */
    enum v implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* compiled from: Functions.java */
    static final class w implements g.a.x0.o<Object, Object> {
        w() {
        }

        @Override // g.a.x0.o
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    static final class x<T, U> implements Callable<U>, g.a.x0.o<T, U> {

        /* renamed from: a, reason: collision with root package name */
        final U f13937a;

        x(U u) {
            this.f13937a = u;
        }

        @Override // g.a.x0.o
        public U apply(T t) throws Exception {
            return this.f13937a;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f13937a;
        }
    }

    /* compiled from: Functions.java */
    static final class y<T> implements g.a.x0.o<List<T>, List<T>> {

        /* renamed from: a, reason: collision with root package name */
        final Comparator<? super T> f13938a;

        y(Comparator<? super T> comparator) {
            this.f13938a = comparator;
        }

        @Override // g.a.x0.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f13938a);
            return list;
        }
    }

    /* compiled from: Functions.java */
    static final class z implements g.a.x0.g<i.d.d> {
        z() {
        }

        @Override // g.a.x0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(i.d.d dVar) throws Exception {
            dVar.request(m0.f16408b);
        }
    }

    private a() {
        throw new IllegalStateException("No instances!");
    }

    public static <T1, T2, R> g.a.x0.o<Object[], R> a(g.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        g.a.y0.b.b.a(cVar, "f is null");
        return new b(cVar);
    }

    public static <T> g.a.x0.r<T> b() {
        return (g.a.x0.r<T>) f13904h;
    }

    public static <T, U> g.a.x0.o<T, U> c(U u2) {
        return new x(u2);
    }

    public static <T> g.a.x0.g<T> d() {
        return (g.a.x0.g<T>) f13900d;
    }

    public static <T> g.a.x0.o<T, T> e() {
        return (g.a.x0.o<T, T>) f13897a;
    }

    public static <T> Comparator<T> f() {
        return a0.INSTANCE;
    }

    public static <T> Comparator<T> g() {
        return (Comparator<T>) f13907k;
    }

    public static <T> Callable<T> h() {
        return (Callable<T>) f13906j;
    }

    public static <T> Callable<T> b(T t2) {
        return new x(t2);
    }

    public static <T> Callable<Set<T>> c() {
        return v.INSTANCE;
    }

    public static <T1, T2, T3, R> g.a.x0.o<Object[], R> a(g.a.x0.h<T1, T2, T3, R> hVar) {
        g.a.y0.b.b.a(hVar, "f is null");
        return new c(hVar);
    }

    public static <T> g.a.x0.g<Throwable> b(g.a.x0.g<? super g.a.a0<T>> gVar) {
        return new d0(gVar);
    }

    public static <T> g.a.x0.g<T> c(g.a.x0.g<? super g.a.a0<T>> gVar) {
        return new e0(gVar);
    }

    public static <T, U> g.a.x0.r<T> b(Class<U> cls) {
        return new m(cls);
    }

    public static <T1, T2, T3, T4, R> g.a.x0.o<Object[], R> a(g.a.x0.i<T1, T2, T3, T4, R> iVar) {
        g.a.y0.b.b.a(iVar, "f is null");
        return new d(iVar);
    }

    public static <T1, T2, T3, T4, T5, R> g.a.x0.o<Object[], R> a(g.a.x0.j<T1, T2, T3, T4, T5, R> jVar) {
        g.a.y0.b.b.a(jVar, "f is null");
        return new e(jVar);
    }

    public static <T1, T2, T3, T4, T5, T6, R> g.a.x0.o<Object[], R> a(g.a.x0.k<T1, T2, T3, T4, T5, T6, R> kVar) {
        g.a.y0.b.b.a(kVar, "f is null");
        return new f(kVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> g.a.x0.o<Object[], R> a(g.a.x0.l<T1, T2, T3, T4, T5, T6, T7, R> lVar) {
        g.a.y0.b.b.a(lVar, "f is null");
        return new g(lVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> g.a.x0.o<Object[], R> a(g.a.x0.m<T1, T2, T3, T4, T5, T6, T7, T8, R> mVar) {
        g.a.y0.b.b.a(mVar, "f is null");
        return new h(mVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> g.a.x0.o<Object[], R> a(g.a.x0.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> nVar) {
        g.a.y0.b.b.a(nVar, "f is null");
        return new i(nVar);
    }

    public static <T> g.a.x0.r<T> a() {
        return (g.a.x0.r<T>) f13905i;
    }

    public static g.a.x0.a a(Future<?> future) {
        return new u(future);
    }

    public static <T, U> g.a.x0.o<T, U> a(Class<U> cls) {
        return new l(cls);
    }

    public static <T> Callable<List<T>> a(int i2) {
        return new j(i2);
    }

    public static <T> g.a.x0.r<T> a(T t2) {
        return new r(t2);
    }

    public static <T> g.a.x0.a a(g.a.x0.g<? super g.a.a0<T>> gVar) {
        return new c0(gVar);
    }

    public static <T> g.a.x0.g<T> a(g.a.x0.a aVar) {
        return new C0180a(aVar);
    }

    public static <T> g.a.x0.r<T> a(g.a.x0.e eVar) {
        return new k(eVar);
    }

    public static <T> g.a.x0.o<T, g.a.e1.c<T>> a(TimeUnit timeUnit, g.a.j0 j0Var) {
        return new h0(timeUnit, j0Var);
    }

    public static <T, K> g.a.x0.b<Map<K, T>, T> a(g.a.x0.o<? super T, ? extends K> oVar) {
        return new i0(oVar);
    }

    public static <T, K, V> g.a.x0.b<Map<K, V>, T> a(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2) {
        return new j0(oVar2, oVar);
    }

    public static <T, K, V> g.a.x0.b<Map<K, Collection<V>>, T> a(g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, g.a.x0.o<? super K, ? extends Collection<? super V>> oVar3) {
        return new k0(oVar3, oVar2, oVar);
    }

    public static <T> g.a.x0.o<List<T>, List<T>> a(Comparator<? super T> comparator) {
        return new y(comparator);
    }
}
