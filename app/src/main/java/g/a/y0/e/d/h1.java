package g.a.y0.e.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableGroupBy.java */
/* loaded from: classes2.dex */
public final class h1<T, K, V> extends g.a.y0.e.d.a<T, g.a.z0.b<K, V>> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends K> f15178b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends V> f15179c;

    /* renamed from: d, reason: collision with root package name */
    final int f15180d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f15181e;

    /* compiled from: ObservableGroupBy.java */
    public static final class a<T, K, V> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final g.a.i0<? super g.a.z0.b<K, V>> actual;
        final int bufferSize;
        final boolean delayError;
        final g.a.x0.o<? super T, ? extends K> keySelector;
        g.a.u0.c s;
        final g.a.x0.o<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final Map<Object, b<K, V>> groups = new ConcurrentHashMap();

        public a(g.a.i0<? super g.a.z0.b<K, V>> i0Var, g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, int i2, boolean z) {
            this.actual = i0Var;
            this.keySelector = oVar;
            this.valueSelector = oVar2;
            this.bufferSize = i2;
            this.delayError = z;
            lazySet(1);
        }

        public void cancel(K k2) {
            if (k2 == null) {
                k2 = (K) NULL_KEY;
            }
            this.groups.remove(k2);
            if (decrementAndGet() == 0) {
                this.s.dispose();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.s.dispose();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // g.a.i0
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onComplete();
            }
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onError(th);
            }
            this.actual.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map, java.util.Map<java.lang.Object, g.a.y0.e.d.h1$b<K, V>>] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v3, types: [g.a.y0.e.d.h1$b] */
        @Override // g.a.i0
        public void onNext(T t) {
            try {
                K kApply = this.keySelector.apply(t);
                Object obj = kApply != null ? kApply : NULL_KEY;
                b<K, V> bVar = this.groups.get(obj);
                ?? r2 = bVar;
                if (bVar == false) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    Object objA = b.a(kApply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, objA);
                    getAndIncrement();
                    this.actual.onNext(objA);
                    r2 = objA;
                }
                try {
                    r2.onNext(g.a.y0.b.b.a(this.valueSelector.apply(t), "The value supplied is null"));
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.s.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.s.dispose();
                onError(th2);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableGroupBy.java */
    static final class b<K, T> extends g.a.z0.b<K, T> {

        /* renamed from: b, reason: collision with root package name */
        final c<T, K> f15182b;

        protected b(K k2, c<T, K> cVar) {
            super(k2);
            this.f15182b = cVar;
        }

        public static <T, K> b<K, T> a(K k2, int i2, a<?, K, T> aVar, boolean z) {
            return new b<>(k2, new c(i2, aVar, k2, z));
        }

        @Override // g.a.b0
        protected void d(g.a.i0<? super T> i0Var) {
            this.f15182b.subscribe(i0Var);
        }

        public void onComplete() {
            this.f15182b.onComplete();
        }

        public void onError(Throwable th) {
            this.f15182b.onError(th);
        }

        public void onNext(T t) {
            this.f15182b.onNext(t);
        }
    }

    /* compiled from: ObservableGroupBy.java */
    static final class c<T, K> extends AtomicInteger implements g.a.u0.c, g.a.g0<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final a<?, K, T> parent;
        final g.a.y0.f.c<T> queue;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicReference<g.a.i0<? super T>> actual = new AtomicReference<>();

        c(int i2, a<?, K, T> aVar, K k2, boolean z) {
            this.queue = new g.a.y0.f.c<>(i2);
            this.parent = aVar;
            this.key = k2;
            this.delayError = z;
        }

        boolean checkTerminated(boolean z, boolean z2, g.a.i0<? super T> i0Var, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                this.actual.lazySet(null);
                if (th != null) {
                    i0Var.onError(th);
                } else {
                    i0Var.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                this.actual.lazySet(null);
                i0Var.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.actual.lazySet(null);
            i0Var.onComplete();
            return true;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            g.a.y0.f.c<T> cVar = this.queue;
            boolean z = this.delayError;
            g.a.i0<? super T> i0Var = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (i0Var != null) {
                    while (true) {
                        boolean z2 = this.done;
                        T tPoll = cVar.poll();
                        boolean z3 = tPoll == null;
                        if (checkTerminated(z2, z3, i0Var, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        } else {
                            i0Var.onNext(tPoll);
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (i0Var == null) {
                    i0Var = this.actual.get();
                }
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // g.a.g0
        public void subscribe(g.a.i0<? super T> i0Var) {
            if (!this.once.compareAndSet(false, true)) {
                g.a.y0.a.e.error(new IllegalStateException("Only one Observer allowed!"), i0Var);
                return;
            }
            i0Var.onSubscribe(this);
            this.actual.lazySet(i0Var);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
            } else {
                drain();
            }
        }
    }

    public h1(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, int i2, boolean z) {
        super(g0Var);
        this.f15178b = oVar;
        this.f15179c = oVar2;
        this.f15180d = i2;
        this.f15181e = z;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super g.a.z0.b<K, V>> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15178b, this.f15179c, this.f15180d, this.f15181e));
    }
}
