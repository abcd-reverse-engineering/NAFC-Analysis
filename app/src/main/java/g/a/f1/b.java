package g.a.f1;

import g.a.i0;
import g.a.y0.j.a;
import g.a.y0.j.k;
import g.a.y0.j.q;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: BehaviorSubject.java */
/* loaded from: classes2.dex */
public final class b<T> extends i<T> {

    /* renamed from: h, reason: collision with root package name */
    private static final Object[] f13756h = new Object[0];

    /* renamed from: i, reason: collision with root package name */
    static final a[] f13757i = new a[0];

    /* renamed from: j, reason: collision with root package name */
    static final a[] f13758j = new a[0];

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<Object> f13759a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<a<T>[]> f13760b;

    /* renamed from: c, reason: collision with root package name */
    final ReadWriteLock f13761c;

    /* renamed from: d, reason: collision with root package name */
    final Lock f13762d;

    /* renamed from: e, reason: collision with root package name */
    final Lock f13763e;

    /* renamed from: f, reason: collision with root package name */
    final AtomicReference<Throwable> f13764f;

    /* renamed from: g, reason: collision with root package name */
    long f13765g;

    b() {
        this.f13761c = new ReentrantReadWriteLock();
        this.f13762d = this.f13761c.readLock();
        this.f13763e = this.f13761c.writeLock();
        this.f13760b = new AtomicReference<>(f13757i);
        this.f13759a = new AtomicReference<>();
        this.f13764f = new AtomicReference<>();
    }

    @g.a.t0.d
    public static <T> b<T> X() {
        return new b<>();
    }

    @g.a.t0.d
    public static <T> b<T> o(T t) {
        return new b<>(t);
    }

    @Override // g.a.f1.i
    public Throwable O() {
        Object obj = this.f13759a.get();
        if (q.isError(obj)) {
            return q.getError(obj);
        }
        return null;
    }

    @Override // g.a.f1.i
    public boolean P() {
        return q.isComplete(this.f13759a.get());
    }

    @Override // g.a.f1.i
    public boolean Q() {
        return this.f13760b.get().length != 0;
    }

    @Override // g.a.f1.i
    public boolean R() {
        return q.isError(this.f13759a.get());
    }

    public T T() {
        Object obj = this.f13759a.get();
        if (q.isComplete(obj) || q.isError(obj)) {
            return null;
        }
        return (T) q.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] U() {
        Object[] objArrC = c(f13756h);
        return objArrC == f13756h ? new Object[0] : objArrC;
    }

    public boolean V() {
        Object obj = this.f13759a.get();
        return (obj == null || q.isComplete(obj) || q.isError(obj)) ? false : true;
    }

    int W() {
        return this.f13760b.get().length;
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13760b.get();
            if (aVarArr == f13758j) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f13760b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13760b.get();
            if (aVarArr == f13758j || aVarArr == f13757i) {
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
                aVarArr2 = f13757i;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f13760b.compareAndSet(aVarArr, aVarArr2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] c(T[] tArr) {
        Object obj = this.f13759a.get();
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

    @Override // g.a.b0
    protected void d(i0<? super T> i0Var) {
        a<T> aVar = new a<>(i0Var, this);
        i0Var.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.f13772g) {
                b((a) aVar);
                return;
            } else {
                aVar.a();
                return;
            }
        }
        Throwable th = this.f13764f.get();
        if (th == k.f16046a) {
            i0Var.onComplete();
        } else {
            i0Var.onError(th);
        }
    }

    void m(Object obj) {
        this.f13763e.lock();
        try {
            this.f13765g++;
            this.f13759a.lazySet(obj);
        } finally {
            this.f13763e.unlock();
        }
    }

    a<T>[] n(Object obj) {
        a<T>[] andSet = this.f13760b.get();
        a<T>[] aVarArr = f13758j;
        if (andSet != aVarArr && (andSet = this.f13760b.getAndSet(aVarArr)) != f13758j) {
            m(obj);
        }
        return andSet;
    }

    @Override // g.a.i0
    public void onComplete() {
        if (this.f13764f.compareAndSet(null, k.f16046a)) {
            Object objComplete = q.complete();
            for (a<T> aVar : n(objComplete)) {
                aVar.a(objComplete, this.f13765g);
            }
        }
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (!this.f13764f.compareAndSet(null, th)) {
            g.a.c1.a.b(th);
            return;
        }
        Object objError = q.error(th);
        for (a<T> aVar : n(objError)) {
            aVar.a(objError, this.f13765g);
        }
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f13764f.get() != null) {
            return;
        }
        Object next = q.next(t);
        m(next);
        for (a<T> aVar : this.f13760b.get()) {
            aVar.a(next, this.f13765g);
        }
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        if (this.f13764f.get() != null) {
            cVar.dispose();
        }
    }

    b(T t) {
        this();
        this.f13759a.lazySet(g.a.y0.b.b.a((Object) t, "defaultValue is null"));
    }

    /* compiled from: BehaviorSubject.java */
    static final class a<T> implements g.a.u0.c, a.InterfaceC0232a<Object> {

        /* renamed from: a, reason: collision with root package name */
        final i0<? super T> f13766a;

        /* renamed from: b, reason: collision with root package name */
        final b<T> f13767b;

        /* renamed from: c, reason: collision with root package name */
        boolean f13768c;

        /* renamed from: d, reason: collision with root package name */
        boolean f13769d;

        /* renamed from: e, reason: collision with root package name */
        g.a.y0.j.a<Object> f13770e;

        /* renamed from: f, reason: collision with root package name */
        boolean f13771f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f13772g;

        /* renamed from: h, reason: collision with root package name */
        long f13773h;

        a(i0<? super T> i0Var, b<T> bVar) {
            this.f13766a = i0Var;
            this.f13767b = bVar;
        }

        void a() {
            if (this.f13772g) {
                return;
            }
            synchronized (this) {
                if (this.f13772g) {
                    return;
                }
                if (this.f13768c) {
                    return;
                }
                b<T> bVar = this.f13767b;
                Lock lock = bVar.f13762d;
                lock.lock();
                this.f13773h = bVar.f13765g;
                Object obj = bVar.f13759a.get();
                lock.unlock();
                this.f13769d = obj != null;
                this.f13768c = true;
                if (obj == null || test(obj)) {
                    return;
                }
                b();
            }
        }

        void b() {
            g.a.y0.j.a<Object> aVar;
            while (!this.f13772g) {
                synchronized (this) {
                    aVar = this.f13770e;
                    if (aVar == null) {
                        this.f13769d = false;
                        return;
                    }
                    this.f13770e = null;
                }
                aVar.a((a.InterfaceC0232a<? super Object>) this);
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.f13772g) {
                return;
            }
            this.f13772g = true;
            this.f13767b.b((a) this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f13772g;
        }

        @Override // g.a.y0.j.a.InterfaceC0232a, g.a.x0.r
        public boolean test(Object obj) {
            return this.f13772g || q.accept(obj, this.f13766a);
        }

        void a(Object obj, long j2) {
            if (this.f13772g) {
                return;
            }
            if (!this.f13771f) {
                synchronized (this) {
                    if (this.f13772g) {
                        return;
                    }
                    if (this.f13773h == j2) {
                        return;
                    }
                    if (this.f13769d) {
                        g.a.y0.j.a<Object> aVar = this.f13770e;
                        if (aVar == null) {
                            aVar = new g.a.y0.j.a<>(4);
                            this.f13770e = aVar;
                        }
                        aVar.a((g.a.y0.j.a<Object>) obj);
                        return;
                    }
                    this.f13768c = true;
                    this.f13771f = true;
                }
            }
            test(obj);
        }
    }
}
