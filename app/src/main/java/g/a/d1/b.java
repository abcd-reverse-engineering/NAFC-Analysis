package g.a.d1;

import g.a.y0.i.j;
import g.a.y0.j.a;
import g.a.y0.j.k;
import g.a.y0.j.q;
import h.q2.t.m0;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: BehaviorProcessor.java */
/* loaded from: classes2.dex */
public final class b<T> extends c<T> {

    /* renamed from: i, reason: collision with root package name */
    static final Object[] f13674i = new Object[0];

    /* renamed from: j, reason: collision with root package name */
    static final a[] f13675j = new a[0];

    /* renamed from: k, reason: collision with root package name */
    static final a[] f13676k = new a[0];

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<a<T>[]> f13677b;

    /* renamed from: c, reason: collision with root package name */
    final ReadWriteLock f13678c;

    /* renamed from: d, reason: collision with root package name */
    final Lock f13679d;

    /* renamed from: e, reason: collision with root package name */
    final Lock f13680e;

    /* renamed from: f, reason: collision with root package name */
    final AtomicReference<Object> f13681f;

    /* renamed from: g, reason: collision with root package name */
    final AtomicReference<Throwable> f13682g;

    /* renamed from: h, reason: collision with root package name */
    long f13683h;

    /* compiled from: BehaviorProcessor.java */
    static final class a<T> extends AtomicLong implements i.d.d, a.InterfaceC0232a<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        g.a.y0.j.a<Object> queue;
        final b<T> state;

        a(i.d.c<? super T> cVar, b<T> bVar) {
            this.actual = cVar;
            this.state = bVar;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.b((a) this);
        }

        void emitFirst() {
            if (this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                b<T> bVar = this.state;
                Lock lock = bVar.f13679d;
                lock.lock();
                this.index = bVar.f13683h;
                Object obj = bVar.f13681f.get();
                lock.unlock();
                this.emitting = obj != null;
                this.next = true;
                if (obj == null || test(obj)) {
                    return;
                }
                emitLoop();
            }
        }

        void emitLoop() {
            g.a.y0.j.a<Object> aVar;
            while (!this.cancelled) {
                synchronized (this) {
                    aVar = this.queue;
                    if (aVar == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                aVar.a((a.InterfaceC0232a<? super Object>) this);
            }
        }

        void emitNext(Object obj, long j2) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j2) {
                        return;
                    }
                    if (this.emitting) {
                        g.a.y0.j.a<Object> aVar = this.queue;
                        if (aVar == null) {
                            aVar = new g.a.y0.j.a<>(4);
                            this.queue = aVar;
                        }
                        aVar.a((g.a.y0.j.a<Object>) obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(obj);
        }

        public boolean isFull() {
            return get() == 0;
        }

        @Override // i.d.d
        public void request(long j2) {
            if (j.validate(j2)) {
                g.a.y0.j.d.a(this, j2);
            }
        }

        @Override // g.a.y0.j.a.InterfaceC0232a, g.a.x0.r
        public boolean test(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (q.isComplete(obj)) {
                this.actual.onComplete();
                return true;
            }
            if (q.isError(obj)) {
                this.actual.onError(q.getError(obj));
                return true;
            }
            long j2 = get();
            if (j2 == 0) {
                cancel();
                this.actual.onError(new g.a.v0.c("Could not deliver value due to lack of requests"));
                return true;
            }
            this.actual.onNext((Object) q.getValue(obj));
            if (j2 == m0.f16408b) {
                return false;
            }
            decrementAndGet();
            return false;
        }
    }

    b() {
        this.f13681f = new AtomicReference<>();
        this.f13678c = new ReentrantReadWriteLock();
        this.f13679d = this.f13678c.readLock();
        this.f13680e = this.f13678c.writeLock();
        this.f13677b = new AtomicReference<>(f13675j);
        this.f13682g = new AtomicReference<>();
    }

    @g.a.t0.d
    public static <T> b<T> c0() {
        return new b<>();
    }

    @g.a.t0.d
    public static <T> b<T> p(T t) {
        g.a.y0.b.b.a((Object) t, "defaultValue is null");
        return new b<>(t);
    }

    @Override // g.a.d1.c
    public Throwable T() {
        Object obj = this.f13681f.get();
        if (q.isError(obj)) {
            return q.getError(obj);
        }
        return null;
    }

    @Override // g.a.d1.c
    public boolean U() {
        return q.isComplete(this.f13681f.get());
    }

    @Override // g.a.d1.c
    public boolean V() {
        return this.f13677b.get().length != 0;
    }

    @Override // g.a.d1.c
    public boolean W() {
        return q.isError(this.f13681f.get());
    }

    public T Y() {
        Object obj = this.f13681f.get();
        if (q.isComplete(obj) || q.isError(obj)) {
            return null;
        }
        return (T) q.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] Z() {
        Object[] objArrC = c(f13674i);
        return objArrC == f13674i ? new Object[0] : objArrC;
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13677b.get();
            if (aVarArr == f13676k) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f13677b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    public boolean a0() {
        Object obj = this.f13681f.get();
        return (obj == null || q.isComplete(obj) || q.isError(obj)) ? false : true;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13677b.get();
            if (aVarArr == f13676k || aVarArr == f13675j) {
                return;
            }
            int length = aVarArr.length;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (aVarArr[i3] == aVar) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = f13675j;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f13677b.compareAndSet(aVarArr, aVarArr2));
    }

    int b0() {
        return this.f13677b.get().length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] c(T[] tArr) {
        Object obj = this.f13681f.get();
        if (obj == null || q.isComplete(obj) || q.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = 0;
            }
            return tArr;
        }
        Object value = q.getValue(obj);
        if (tArr.length == 0) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            tArr2[0] = value;
            return tArr2;
        }
        tArr[0] = value;
        if (tArr.length == 1) {
            return tArr;
        }
        tArr[1] = 0;
        return tArr;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        a<T> aVar = new a<>(cVar, this);
        cVar.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.cancelled) {
                b((a) aVar);
                return;
            } else {
                aVar.emitFirst();
                return;
            }
        }
        Throwable th = this.f13682g.get();
        if (th == k.f16046a) {
            cVar.onComplete();
        } else {
            cVar.onError(th);
        }
    }

    @g.a.t0.e
    public boolean m(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        a<T>[] aVarArr = this.f13677b.get();
        for (a<T> aVar : aVarArr) {
            if (aVar.isFull()) {
                return false;
            }
        }
        Object next = q.next(t);
        n(next);
        for (a<T> aVar2 : aVarArr) {
            aVar2.emitNext(next, this.f13683h);
        }
        return true;
    }

    void n(Object obj) {
        Lock lock = this.f13680e;
        lock.lock();
        this.f13683h++;
        this.f13681f.lazySet(obj);
        lock.unlock();
    }

    a<T>[] o(Object obj) {
        a<T>[] andSet = this.f13677b.get();
        a<T>[] aVarArr = f13676k;
        if (andSet != aVarArr && (andSet = this.f13677b.getAndSet(aVarArr)) != f13676k) {
            n(obj);
        }
        return andSet;
    }

    @Override // i.d.c
    public void onComplete() {
        if (this.f13682g.compareAndSet(null, k.f16046a)) {
            Object objComplete = q.complete();
            for (a<T> aVar : o(objComplete)) {
                aVar.emitNext(objComplete, this.f13683h);
            }
        }
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (!this.f13682g.compareAndSet(null, th)) {
            g.a.c1.a.b(th);
            return;
        }
        Object objError = q.error(th);
        for (a<T> aVar : o(objError)) {
            aVar.emitNext(objError, this.f13683h);
        }
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f13682g.get() != null) {
            return;
        }
        Object next = q.next(t);
        n(next);
        for (a<T> aVar : this.f13677b.get()) {
            aVar.emitNext(next, this.f13683h);
        }
    }

    @Override // i.d.c, g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (this.f13682g.get() != null) {
            dVar.cancel();
        } else {
            dVar.request(m0.f16408b);
        }
    }

    b(T t) {
        this();
        this.f13681f.lazySet(g.a.y0.b.b.a((Object) t, "defaultValue is null"));
    }
}
