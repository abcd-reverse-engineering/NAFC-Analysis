package g.a.f1;

import g.a.i0;
import g.a.j0;
import g.a.y0.j.q;
import h.q2.t.m0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReplaySubject.java */
/* loaded from: classes2.dex */
public final class f<T> extends i<T> {

    /* renamed from: d, reason: collision with root package name */
    static final c[] f13789d = new c[0];

    /* renamed from: e, reason: collision with root package name */
    static final c[] f13790e = new c[0];

    /* renamed from: f, reason: collision with root package name */
    private static final Object[] f13791f = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    final b<T> f13792a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<c<T>[]> f13793b = new AtomicReference<>(f13789d);

    /* renamed from: c, reason: collision with root package name */
    boolean f13794c;

    /* compiled from: ReplaySubject.java */
    static final class a<T> extends AtomicReference<a<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        a(T t) {
            this.value = t;
        }
    }

    /* compiled from: ReplaySubject.java */
    interface b<T> {
        void add(T t);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        Object get();

        T getValue();

        T[] getValues(T[] tArr);

        void replay(c<T> cVar);

        int size();
    }

    /* compiled from: ReplaySubject.java */
    static final class c<T> extends AtomicInteger implements g.a.u0.c {
        private static final long serialVersionUID = 466549804534799122L;
        final i0<? super T> actual;
        volatile boolean cancelled;
        Object index;
        final f<T> state;

        c(i0<? super T> i0Var, f<T> fVar) {
            this.actual = i0Var;
            this.state = fVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.b((c) this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* compiled from: ReplaySubject.java */
    static final class d<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile C0176f<Object> head;
        final long maxAge;
        final int maxSize;
        final j0 scheduler;
        int size;
        C0176f<Object> tail;
        final TimeUnit unit;

        d(int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
            this.maxSize = g.a.y0.b.b.a(i2, "maxSize");
            this.maxAge = g.a.y0.b.b.a(j2, "maxAge");
            this.unit = (TimeUnit) g.a.y0.b.b.a(timeUnit, "unit is null");
            this.scheduler = (j0) g.a.y0.b.b.a(j0Var, "scheduler is null");
            C0176f<Object> c0176f = new C0176f<>(null, 0L);
            this.tail = c0176f;
            this.head = c0176f;
        }

        @Override // g.a.f1.f.b
        public void add(T t) {
            C0176f<Object> c0176f = new C0176f<>(t, this.scheduler.a(this.unit));
            C0176f<Object> c0176f2 = this.tail;
            this.tail = c0176f;
            this.size++;
            c0176f2.set(c0176f);
            trim();
        }

        @Override // g.a.f1.f.b
        public void addFinal(Object obj) {
            C0176f<Object> c0176f = new C0176f<>(obj, m0.f16408b);
            C0176f<Object> c0176f2 = this.tail;
            this.tail = c0176f;
            this.size++;
            c0176f2.lazySet(c0176f);
            trimFinal();
            this.done = true;
        }

        C0176f<Object> getHead() {
            C0176f<Object> c0176f;
            C0176f<Object> c0176f2 = this.head;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            C0176f<T> c0176f3 = c0176f2.get();
            while (true) {
                C0176f<T> c0176f4 = c0176f3;
                c0176f = c0176f2;
                c0176f2 = c0176f4;
                if (c0176f2 == null || c0176f2.time > jA) {
                    break;
                }
                c0176f3 = c0176f2.get();
            }
            return c0176f;
        }

        @Override // g.a.f1.f.b
        public T getValue() {
            T t;
            C0176f<Object> c0176f = this.head;
            C0176f<Object> c0176f2 = null;
            while (true) {
                C0176f<T> c0176f3 = c0176f.get();
                if (c0176f3 == null) {
                    break;
                }
                c0176f2 = c0176f;
                c0176f = c0176f3;
            }
            if (c0176f.time >= this.scheduler.a(this.unit) - this.maxAge && (t = (T) c0176f.value) != null) {
                return (q.isComplete(t) || q.isError(t)) ? (T) c0176f2.value : t;
            }
            return null;
        }

        @Override // g.a.f1.f.b
        public T[] getValues(T[] tArr) {
            C0176f<T> head = getHead();
            int size = size(head);
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i2 = 0; i2 != size; i2++) {
                    head = head.get();
                    tArr[i2] = head.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // g.a.f1.f.b
        public void replay(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            i0<? super T> i0Var = cVar.actual;
            C0176f<Object> head = (C0176f) cVar.index;
            if (head == null) {
                head = getHead();
            }
            int iAddAndGet = 1;
            while (!cVar.cancelled) {
                while (!cVar.cancelled) {
                    C0176f<T> c0176f = head.get();
                    if (c0176f != null) {
                        T t = c0176f.value;
                        if (this.done && c0176f.get() == null) {
                            if (q.isComplete(t)) {
                                i0Var.onComplete();
                            } else {
                                i0Var.onError(q.getError(t));
                            }
                            cVar.index = null;
                            cVar.cancelled = true;
                            return;
                        }
                        i0Var.onNext(t);
                        head = c0176f;
                    } else if (head.get() == null) {
                        cVar.index = head;
                        iAddAndGet = cVar.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                }
                cVar.index = null;
                return;
            }
            cVar.index = null;
        }

        @Override // g.a.f1.f.b
        public int size() {
            return size(getHead());
        }

        void trim() {
            int i2 = this.size;
            if (i2 > this.maxSize) {
                this.size = i2 - 1;
                this.head = this.head.get();
            }
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            C0176f<Object> c0176f = this.head;
            while (true) {
                C0176f<T> c0176f2 = c0176f.get();
                if (c0176f2 == null) {
                    this.head = c0176f;
                    return;
                } else {
                    if (c0176f2.time > jA) {
                        this.head = c0176f;
                        return;
                    }
                    c0176f = c0176f2;
                }
            }
        }

        void trimFinal() {
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            C0176f<Object> c0176f = this.head;
            while (true) {
                C0176f<T> c0176f2 = c0176f.get();
                if (c0176f2.get() == null) {
                    this.head = c0176f;
                    return;
                } else {
                    if (c0176f2.time > jA) {
                        this.head = c0176f;
                        return;
                    }
                    c0176f = c0176f2;
                }
            }
        }

        int size(C0176f<Object> c0176f) {
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE) {
                C0176f<T> c0176f2 = c0176f.get();
                if (c0176f2 == null) {
                    Object obj = c0176f.value;
                    return (q.isComplete(obj) || q.isError(obj)) ? i2 - 1 : i2;
                }
                i2++;
                c0176f = c0176f2;
            }
            return i2;
        }
    }

    /* compiled from: ReplaySubject.java */
    static final class e<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile a<Object> head;
        final int maxSize;
        int size;
        a<Object> tail;

        e(int i2) {
            this.maxSize = g.a.y0.b.b.a(i2, "maxSize");
            a<Object> aVar = new a<>(null);
            this.tail = aVar;
            this.head = aVar;
        }

        @Override // g.a.f1.f.b
        public void add(T t) {
            a<Object> aVar = new a<>(t);
            a<Object> aVar2 = this.tail;
            this.tail = aVar;
            this.size++;
            aVar2.set(aVar);
            trim();
        }

        @Override // g.a.f1.f.b
        public void addFinal(Object obj) {
            a<Object> aVar = new a<>(obj);
            a<Object> aVar2 = this.tail;
            this.tail = aVar;
            this.size++;
            aVar2.lazySet(aVar);
            this.done = true;
        }

        @Override // g.a.f1.f.b
        public T getValue() {
            a<Object> aVar = this.head;
            a<Object> aVar2 = null;
            while (true) {
                a<T> aVar3 = aVar.get();
                if (aVar3 == null) {
                    break;
                }
                aVar2 = aVar;
                aVar = aVar3;
            }
            T t = (T) aVar.value;
            if (t == null) {
                return null;
            }
            return (q.isComplete(t) || q.isError(t)) ? (T) aVar2.value : t;
        }

        @Override // g.a.f1.f.b
        public T[] getValues(T[] tArr) {
            a<T> aVar = this.head;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i2 = 0; i2 != size; i2++) {
                    aVar = aVar.get();
                    tArr[i2] = aVar.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // g.a.f1.f.b
        public void replay(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            i0<? super T> i0Var = cVar.actual;
            a<Object> aVar = (a) cVar.index;
            if (aVar == null) {
                aVar = this.head;
            }
            int iAddAndGet = 1;
            while (!cVar.cancelled) {
                a<T> aVar2 = aVar.get();
                if (aVar2 != null) {
                    T t = aVar2.value;
                    if (this.done && aVar2.get() == null) {
                        if (q.isComplete(t)) {
                            i0Var.onComplete();
                        } else {
                            i0Var.onError(q.getError(t));
                        }
                        cVar.index = null;
                        cVar.cancelled = true;
                        return;
                    }
                    i0Var.onNext(t);
                    aVar = aVar2;
                } else if (aVar.get() != null) {
                    continue;
                } else {
                    cVar.index = aVar;
                    iAddAndGet = cVar.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            cVar.index = null;
        }

        @Override // g.a.f1.f.b
        public int size() {
            a<Object> aVar = this.head;
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null) {
                    Object obj = aVar.value;
                    return (q.isComplete(obj) || q.isError(obj)) ? i2 - 1 : i2;
                }
                i2++;
                aVar = aVar2;
            }
            return i2;
        }

        void trim() {
            int i2 = this.size;
            if (i2 > this.maxSize) {
                this.size = i2 - 1;
                this.head = this.head.get();
            }
        }
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: g.a.f1.f$f, reason: collision with other inner class name */
    static final class C0176f<T> extends AtomicReference<C0176f<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        C0176f(T t, long j2) {
            this.value = t;
            this.time = j2;
        }
    }

    /* compiled from: ReplaySubject.java */
    static final class g<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        g(int i2) {
            this.buffer = new ArrayList(g.a.y0.b.b.a(i2, "capacityHint"));
        }

        @Override // g.a.f1.f.b
        public void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        @Override // g.a.f1.f.b
        public void addFinal(Object obj) {
            this.buffer.add(obj);
            this.size++;
            this.done = true;
        }

        @Override // g.a.f1.f.b
        public T getValue() {
            int i2 = this.size;
            if (i2 == 0) {
                return null;
            }
            List<Object> list = this.buffer;
            T t = (T) list.get(i2 - 1);
            if (!q.isComplete(t) && !q.isError(t)) {
                return t;
            }
            if (i2 == 1) {
                return null;
            }
            return (T) list.get(i2 - 2);
        }

        @Override // g.a.f1.f.b
        public T[] getValues(T[] tArr) {
            int i2 = this.size;
            if (i2 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<Object> list = this.buffer;
            Object obj = list.get(i2 - 1);
            if ((q.isComplete(obj) || q.isError(obj)) && i2 - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i2) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
            }
            for (int i3 = 0; i3 < i2; i3++) {
                tArr[i3] = list.get(i3);
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        }

        @Override // g.a.f1.f.b
        public void replay(c<T> cVar) {
            int i2;
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            List<Object> list = this.buffer;
            i0<? super T> i0Var = cVar.actual;
            Integer num = (Integer) cVar.index;
            int iIntValue = 0;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                cVar.index = 0;
            }
            int iAddAndGet = 1;
            while (!cVar.cancelled) {
                int i3 = this.size;
                while (i3 != iIntValue) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    Object obj = list.get(iIntValue);
                    if (this.done && (i2 = iIntValue + 1) == i3 && i2 == (i3 = this.size)) {
                        if (q.isComplete(obj)) {
                            i0Var.onComplete();
                        } else {
                            i0Var.onError(q.getError(obj));
                        }
                        cVar.index = null;
                        cVar.cancelled = true;
                        return;
                    }
                    i0Var.onNext(obj);
                    iIntValue++;
                }
                if (iIntValue == this.size) {
                    cVar.index = Integer.valueOf(iIntValue);
                    iAddAndGet = cVar.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            cVar.index = null;
        }

        @Override // g.a.f1.f.b
        public int size() {
            int i2 = this.size;
            if (i2 == 0) {
                return 0;
            }
            int i3 = i2 - 1;
            Object obj = this.buffer.get(i3);
            return (q.isComplete(obj) || q.isError(obj)) ? i3 : i2;
        }
    }

    f(b<T> bVar) {
        this.f13792a = bVar;
    }

    @g.a.t0.d
    public static <T> f<T> Y() {
        return new f<>(new g(16));
    }

    static <T> f<T> Z() {
        return new f<>(new e(Integer.MAX_VALUE));
    }

    @g.a.t0.d
    public static <T> f<T> b(long j2, TimeUnit timeUnit, j0 j0Var, int i2) {
        return new f<>(new d(i2, j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    public static <T> f<T> i(int i2) {
        return new f<>(new g(i2));
    }

    @g.a.t0.d
    public static <T> f<T> j(int i2) {
        return new f<>(new e(i2));
    }

    @g.a.t0.d
    public static <T> f<T> r(long j2, TimeUnit timeUnit, j0 j0Var) {
        return new f<>(new d(Integer.MAX_VALUE, j2, timeUnit, j0Var));
    }

    @Override // g.a.f1.i
    public Throwable O() {
        Object obj = this.f13792a.get();
        if (q.isError(obj)) {
            return q.getError(obj);
        }
        return null;
    }

    @Override // g.a.f1.i
    public boolean P() {
        return q.isComplete(this.f13792a.get());
    }

    @Override // g.a.f1.i
    public boolean Q() {
        return this.f13793b.get().length != 0;
    }

    @Override // g.a.f1.i
    public boolean R() {
        return q.isError(this.f13792a.get());
    }

    public T T() {
        return this.f13792a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] U() {
        Object[] objArrC = c(f13791f);
        return objArrC == f13791f ? new Object[0] : objArrC;
    }

    public boolean V() {
        return this.f13792a.size() != 0;
    }

    int W() {
        return this.f13793b.get().length;
    }

    int X() {
        return this.f13792a.size();
    }

    boolean a(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f13793b.get();
            if (cVarArr == f13790e) {
                return false;
            }
            int length = cVarArr.length;
            cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
        } while (!this.f13793b.compareAndSet(cVarArr, cVarArr2));
        return true;
    }

    public T[] c(T[] tArr) {
        return this.f13792a.getValues(tArr);
    }

    @Override // g.a.b0
    protected void d(i0<? super T> i0Var) {
        c<T> cVar = new c<>(i0Var, this);
        i0Var.onSubscribe(cVar);
        if (cVar.cancelled) {
            return;
        }
        if (a((c) cVar) && cVar.cancelled) {
            b((c) cVar);
        } else {
            this.f13792a.replay(cVar);
        }
    }

    c<T>[] m(Object obj) {
        return this.f13792a.compareAndSet(null, obj) ? this.f13793b.getAndSet(f13790e) : f13790e;
    }

    @Override // g.a.i0
    public void onComplete() {
        if (this.f13794c) {
            return;
        }
        this.f13794c = true;
        Object objComplete = q.complete();
        b<T> bVar = this.f13792a;
        bVar.addFinal(objComplete);
        for (c<T> cVar : m(objComplete)) {
            bVar.replay(cVar);
        }
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.f13794c) {
            g.a.c1.a.b(th);
            return;
        }
        this.f13794c = true;
        Object objError = q.error(th);
        b<T> bVar = this.f13792a;
        bVar.addFinal(objError);
        for (c<T> cVar : m(objError)) {
            bVar.replay(cVar);
        }
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f13794c) {
            return;
        }
        b<T> bVar = this.f13792a;
        bVar.add(t);
        for (c<T> cVar : this.f13793b.get()) {
            bVar.replay(cVar);
        }
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        if (this.f13794c) {
            cVar.dispose();
        }
    }

    void b(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f13793b.get();
            if (cVarArr == f13790e || cVarArr == f13789d) {
                return;
            }
            int length = cVarArr.length;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (cVarArr[i3] == cVar) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                cVarArr2 = f13789d;
            } else {
                c<T>[] cVarArr3 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr3, 0, i2);
                System.arraycopy(cVarArr, i2 + 1, cVarArr3, i2, (length - i2) - 1);
                cVarArr2 = cVarArr3;
            }
        } while (!this.f13793b.compareAndSet(cVarArr, cVarArr2));
    }
}
