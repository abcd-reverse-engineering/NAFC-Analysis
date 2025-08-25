package g.a.y0.e.b;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableGroupBy.java */
/* loaded from: classes2.dex */
public final class k1<T, K, V> extends g.a.y0.e.b.a<T, g.a.w0.b<K, V>> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends K> f14321c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends V> f14322d;

    /* renamed from: e, reason: collision with root package name */
    final int f14323e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f14324f;

    /* compiled from: FlowableGroupBy.java */
    public static final class a<T, K, V> extends g.a.y0.i.c<g.a.w0.b<K, V>> implements g.a.q<T> {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final i.d.c<? super g.a.w0.b<K, V>> actual;
        final int bufferSize;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final g.a.x0.o<? super T, ? extends K> keySelector;
        boolean outputFused;
        final g.a.y0.f.c<g.a.w0.b<K, V>> queue;
        i.d.d s;
        final g.a.x0.o<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger groupCount = new AtomicInteger(1);
        final Map<Object, b<K, V>> groups = new ConcurrentHashMap();

        public a(i.d.c<? super g.a.w0.b<K, V>> cVar, g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, int i2, boolean z) {
            this.actual = cVar;
            this.keySelector = oVar;
            this.valueSelector = oVar2;
            this.bufferSize = i2;
            this.delayError = z;
            this.queue = new g.a.y0.f.c<>(i2);
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                this.s.cancel();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, i.d.c<?> cVar, g.a.y0.f.c<?> cVar2) {
            if (this.cancelled.get()) {
                cVar2.clear();
                return true;
            }
            if (this.delayError) {
                if (!z || !z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                cVar2.clear();
                cVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void drainFused() {
            Throwable th;
            g.a.y0.f.c<g.a.w0.b<K, V>> cVar = this.queue;
            i.d.c<? super g.a.w0.b<K, V>> cVar2 = this.actual;
            int iAddAndGet = 1;
            while (!this.cancelled.get()) {
                boolean z = this.done;
                if (z && !this.delayError && (th = this.error) != null) {
                    cVar.clear();
                    cVar2.onError(th);
                    return;
                }
                cVar2.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        cVar2.onError(th2);
                        return;
                    } else {
                        cVar2.onComplete();
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            cVar.clear();
        }

        void drainNormal() {
            g.a.y0.f.c<g.a.w0.b<K, V>> cVar = this.queue;
            i.d.c<? super g.a.w0.b<K, V>> cVar2 = this.actual;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z = this.done;
                    g.a.w0.b<K, V> bVarPoll = cVar.poll();
                    boolean z2 = bVarPoll == null;
                    if (checkTerminated(z, z2, cVar2, cVar)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    cVar2.onNext(bVarPoll);
                    j3++;
                }
                if (j3 == j2 && checkTerminated(this.done, cVar.isEmpty(), cVar2, cVar)) {
                    return;
                }
                if (j3 != 0) {
                    if (j2 != h.q2.t.m0.f16408b) {
                        this.requested.addAndGet(-j3);
                    }
                    this.s.request(j3);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<b<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.groups.clear();
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            Iterator<b<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.groups.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            g.a.y0.f.c<g.a.w0.b<K, V>> cVar = this.queue;
            try {
                K kApply = this.keySelector.apply(t);
                boolean z = false;
                Object obj = kApply != null ? kApply : NULL_KEY;
                b<K, V> bVar = this.groups.get(obj);
                b bVar2 = bVar;
                if (bVar == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    b bVarA = b.a(kApply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, bVarA);
                    this.groupCount.getAndIncrement();
                    z = true;
                    bVar2 = bVarA;
                }
                try {
                    bVar2.onNext(g.a.y0.b.b.a(this.valueSelector.apply(t), "The valueSelector returned null"));
                    if (z) {
                        cVar.offer(bVar2);
                        drain();
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    this.s.cancel();
                    onError(th);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.s.cancel();
                onError(th2);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.bufferSize);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public g.a.w0.b<K, V> poll() {
            return this.queue.poll();
        }

        public void cancel(K k2) {
            if (k2 == null) {
                k2 = (K) NULL_KEY;
            }
            this.groups.remove(k2);
            if (this.groupCount.decrementAndGet() == 0) {
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }
    }

    /* compiled from: FlowableGroupBy.java */
    static final class b<K, T> extends g.a.w0.b<K, T> {

        /* renamed from: c, reason: collision with root package name */
        final c<T, K> f14325c;

        protected b(K k2, c<T, K> cVar) {
            super(k2);
            this.f14325c = cVar;
        }

        public static <T, K> b<K, T> a(K k2, int i2, a<?, K, T> aVar, boolean z) {
            return new b<>(k2, new c(i2, aVar, k2, z));
        }

        @Override // g.a.l
        protected void d(i.d.c<? super T> cVar) {
            this.f14325c.subscribe(cVar);
        }

        public void onComplete() {
            this.f14325c.onComplete();
        }

        public void onError(Throwable th) {
            this.f14325c.onError(th);
        }

        public void onNext(T t) {
            this.f14325c.onNext(t);
        }
    }

    /* compiled from: FlowableGroupBy.java */
    static final class c<T, K> extends g.a.y0.i.c<T> implements i.d.b<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        boolean outputFused;
        final a<?, K, T> parent;
        int produced;
        final g.a.y0.f.c<T> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicReference<i.d.c<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean once = new AtomicBoolean();

        c(int i2, a<?, K, T> aVar, K k2, boolean z) {
            this.queue = new g.a.y0.f.c<>(i2);
            this.parent = aVar;
            this.key = k2;
            this.delayError = z;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
            }
        }

        boolean checkTerminated(boolean z, boolean z2, i.d.c<? super T> cVar, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
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
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                cVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void drainFused() {
            Throwable th;
            g.a.y0.f.c<T> cVar = this.queue;
            i.d.c<? super T> cVar2 = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (cVar2 != null) {
                    if (this.cancelled.get()) {
                        cVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && !this.delayError && (th = this.error) != null) {
                        cVar.clear();
                        cVar2.onError(th);
                        return;
                    }
                    cVar2.onNext(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            cVar2.onError(th2);
                            return;
                        } else {
                            cVar2.onComplete();
                            return;
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (cVar2 == null) {
                    cVar2 = this.actual.get();
                }
            }
        }

        void drainNormal() {
            g.a.y0.f.c<T> cVar = this.queue;
            boolean z = this.delayError;
            i.d.c<? super T> cVar2 = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (cVar2 != null) {
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (j3 != j2) {
                        boolean z2 = this.done;
                        T tPoll = cVar.poll();
                        boolean z3 = tPoll == null;
                        if (checkTerminated(z2, z3, cVar2, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        cVar2.onNext(tPoll);
                        j3++;
                    }
                    if (j3 == j2 && checkTerminated(this.done, cVar.isEmpty(), cVar2, z)) {
                        return;
                    }
                    if (j3 != 0) {
                        if (j2 != h.q2.t.m0.f16408b) {
                            this.requested.addAndGet(-j3);
                        }
                        this.parent.s.request(j3);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (cVar2 == null) {
                    cVar2 = this.actual.get();
                }
            }
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
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

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() {
            T tPoll = this.queue.poll();
            if (tPoll != null) {
                this.produced++;
                return tPoll;
            }
            int i2 = this.produced;
            if (i2 == 0) {
                return null;
            }
            this.produced = 0;
            this.parent.s.request(i2);
            return null;
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // i.d.b
        public void subscribe(i.d.c<? super T> cVar) {
            if (!this.once.compareAndSet(false, true)) {
                g.a.y0.i.g.error(new IllegalStateException("Only one Subscriber allowed!"), cVar);
                return;
            }
            cVar.onSubscribe(this);
            this.actual.lazySet(cVar);
            drain();
        }
    }

    public k1(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends K> oVar, g.a.x0.o<? super T, ? extends V> oVar2, int i2, boolean z) {
        super(lVar);
        this.f14321c = oVar;
        this.f14322d = oVar2;
        this.f14323e = i2;
        this.f14324f = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super g.a.w0.b<K, V>> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14321c, this.f14322d, this.f14323e, this.f14324f));
    }
}
