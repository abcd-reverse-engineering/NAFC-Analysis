package g.a.d1;

import g.a.j0;
import g.a.y0.i.j;
import h.q2.t.m0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReplayProcessor.java */
/* loaded from: classes2.dex */
public final class e<T> extends g.a.d1.c<T> {

    /* renamed from: e, reason: collision with root package name */
    private static final Object[] f13688e = new Object[0];

    /* renamed from: f, reason: collision with root package name */
    static final c[] f13689f = new c[0];

    /* renamed from: g, reason: collision with root package name */
    static final c[] f13690g = new c[0];

    /* renamed from: b, reason: collision with root package name */
    final b<T> f13691b;

    /* renamed from: c, reason: collision with root package name */
    boolean f13692c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicReference<c<T>[]> f13693d = new AtomicReference<>(f13689f);

    /* compiled from: ReplayProcessor.java */
    static final class a<T> extends AtomicReference<a<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        a(T t) {
            this.value = t;
        }
    }

    /* compiled from: ReplayProcessor.java */
    interface b<T> {
        void a(c<T> cVar);

        void complete();

        void error(Throwable th);

        Throwable g();

        T getValue();

        T[] getValues(T[] tArr);

        boolean isDone();

        void next(T t);

        int size();
    }

    /* compiled from: ReplayProcessor.java */
    static final class c<T> extends AtomicInteger implements i.d.d {
        private static final long serialVersionUID = 466549804534799122L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        long emitted;
        Object index;
        final AtomicLong requested = new AtomicLong();
        final e<T> state;

        c(i.d.c<? super T> cVar, e<T> eVar) {
            this.actual = cVar;
            this.state = eVar;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.b((c) this);
        }

        @Override // i.d.d
        public void request(long j2) {
            if (j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                this.state.f13691b.a(this);
            }
        }
    }

    /* compiled from: ReplayProcessor.java */
    static final class f<T> extends AtomicReference<f<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        f(T t, long j2) {
            this.value = t;
            this.time = j2;
        }
    }

    /* compiled from: ReplayProcessor.java */
    static final class g<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        final List<T> f13709a;

        /* renamed from: b, reason: collision with root package name */
        Throwable f13710b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f13711c;

        /* renamed from: d, reason: collision with root package name */
        volatile int f13712d;

        g(int i2) {
            this.f13709a = new ArrayList(g.a.y0.b.b.a(i2, "capacityHint"));
        }

        @Override // g.a.d1.e.b
        public void a(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            List<T> list = this.f13709a;
            i.d.c<? super T> cVar2 = cVar.actual;
            Integer num = (Integer) cVar.index;
            int iIntValue = 0;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                cVar.index = 0;
            }
            long j2 = cVar.emitted;
            int iAddAndGet = 1;
            do {
                long j3 = cVar.requested.get();
                while (j2 != j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z = this.f13711c;
                    int i2 = this.f13712d;
                    if (z && iIntValue == i2) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th = this.f13710b;
                        if (th == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th);
                            return;
                        }
                    }
                    if (iIntValue == i2) {
                        break;
                    }
                    cVar2.onNext(list.get(iIntValue));
                    iIntValue++;
                    j2++;
                }
                if (j2 == j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z2 = this.f13711c;
                    int i3 = this.f13712d;
                    if (z2 && iIntValue == i3) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th2 = this.f13710b;
                        if (th2 == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th2);
                            return;
                        }
                    }
                }
                cVar.index = Integer.valueOf(iIntValue);
                cVar.emitted = j2;
                iAddAndGet = cVar.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // g.a.d1.e.b
        public void complete() {
            this.f13711c = true;
        }

        @Override // g.a.d1.e.b
        public void error(Throwable th) {
            this.f13710b = th;
            this.f13711c = true;
        }

        @Override // g.a.d1.e.b
        public Throwable g() {
            return this.f13710b;
        }

        @Override // g.a.d1.e.b
        public T getValue() {
            int i2 = this.f13712d;
            if (i2 == 0) {
                return null;
            }
            return this.f13709a.get(i2 - 1);
        }

        @Override // g.a.d1.e.b
        public T[] getValues(T[] tArr) {
            int i2 = this.f13712d;
            if (i2 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.f13709a;
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

        @Override // g.a.d1.e.b
        public boolean isDone() {
            return this.f13711c;
        }

        @Override // g.a.d1.e.b
        public void next(T t) {
            this.f13709a.add(t);
            this.f13712d++;
        }

        @Override // g.a.d1.e.b
        public int size() {
            return this.f13712d;
        }
    }

    e(b<T> bVar) {
        this.f13691b = bVar;
    }

    @g.a.t0.d
    public static <T> e<T> b(long j2, TimeUnit timeUnit, j0 j0Var, int i2) {
        return new e<>(new d(i2, j2, timeUnit, j0Var));
    }

    @g.a.t0.d
    public static <T> e<T> d0() {
        return new e<>(new g(16));
    }

    static <T> e<T> e0() {
        return new e<>(new C0171e(Integer.MAX_VALUE));
    }

    @g.a.t0.d
    public static <T> e<T> m(int i2) {
        return new e<>(new g(i2));
    }

    @g.a.t0.d
    public static <T> e<T> n(int i2) {
        return new e<>(new C0171e(i2));
    }

    @g.a.t0.d
    public static <T> e<T> r(long j2, TimeUnit timeUnit, j0 j0Var) {
        return new e<>(new d(Integer.MAX_VALUE, j2, timeUnit, j0Var));
    }

    @Override // g.a.d1.c
    public Throwable T() {
        b<T> bVar = this.f13691b;
        if (bVar.isDone()) {
            return bVar.g();
        }
        return null;
    }

    @Override // g.a.d1.c
    public boolean U() {
        b<T> bVar = this.f13691b;
        return bVar.isDone() && bVar.g() == null;
    }

    @Override // g.a.d1.c
    public boolean V() {
        return this.f13693d.get().length != 0;
    }

    @Override // g.a.d1.c
    public boolean W() {
        b<T> bVar = this.f13691b;
        return bVar.isDone() && bVar.g() != null;
    }

    public T Y() {
        return this.f13691b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] Z() {
        Object[] objArrC = c(f13688e);
        return objArrC == f13688e ? new Object[0] : objArrC;
    }

    boolean a(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f13693d.get();
            if (cVarArr == f13690g) {
                return false;
            }
            int length = cVarArr.length;
            cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
        } while (!this.f13693d.compareAndSet(cVarArr, cVarArr2));
        return true;
    }

    public boolean a0() {
        return this.f13691b.size() != 0;
    }

    int b0() {
        return this.f13691b.size();
    }

    public T[] c(T[] tArr) {
        return this.f13691b.getValues(tArr);
    }

    int c0() {
        return this.f13693d.get().length;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        c<T> cVar2 = new c<>(cVar, this);
        cVar.onSubscribe(cVar2);
        if (a((c) cVar2) && cVar2.cancelled) {
            b((c) cVar2);
        } else {
            this.f13691b.a(cVar2);
        }
    }

    @Override // i.d.c
    public void onComplete() {
        if (this.f13692c) {
            return;
        }
        this.f13692c = true;
        b<T> bVar = this.f13691b;
        bVar.complete();
        for (c<T> cVar : this.f13693d.getAndSet(f13690g)) {
            bVar.a(cVar);
        }
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.f13692c) {
            g.a.c1.a.b(th);
            return;
        }
        this.f13692c = true;
        b<T> bVar = this.f13691b;
        bVar.error(th);
        for (c<T> cVar : this.f13693d.getAndSet(f13690g)) {
            bVar.a(cVar);
        }
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f13692c) {
            return;
        }
        b<T> bVar = this.f13691b;
        bVar.next(t);
        for (c<T> cVar : this.f13693d.get()) {
            bVar.a(cVar);
        }
    }

    @Override // i.d.c, g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (this.f13692c) {
            dVar.cancel();
        } else {
            dVar.request(m0.f16408b);
        }
    }

    void b(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f13693d.get();
            if (cVarArr == f13690g || cVarArr == f13689f) {
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
                cVarArr2 = f13689f;
            } else {
                c<T>[] cVarArr3 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr3, 0, i2);
                System.arraycopy(cVarArr, i2 + 1, cVarArr3, i2, (length - i2) - 1);
                cVarArr2 = cVarArr3;
            }
        } while (!this.f13693d.compareAndSet(cVarArr, cVarArr2));
    }

    /* compiled from: ReplayProcessor.java */
    /* renamed from: g.a.d1.e$e, reason: collision with other inner class name */
    static final class C0171e<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f13703a;

        /* renamed from: b, reason: collision with root package name */
        int f13704b;

        /* renamed from: c, reason: collision with root package name */
        volatile a<T> f13705c;

        /* renamed from: d, reason: collision with root package name */
        a<T> f13706d;

        /* renamed from: e, reason: collision with root package name */
        Throwable f13707e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f13708f;

        C0171e(int i2) {
            this.f13703a = g.a.y0.b.b.a(i2, "maxSize");
            a<T> aVar = new a<>(null);
            this.f13706d = aVar;
            this.f13705c = aVar;
        }

        void a() {
            int i2 = this.f13704b;
            if (i2 > this.f13703a) {
                this.f13704b = i2 - 1;
                this.f13705c = this.f13705c.get();
            }
        }

        @Override // g.a.d1.e.b
        public void complete() {
            this.f13708f = true;
        }

        @Override // g.a.d1.e.b
        public void error(Throwable th) {
            this.f13707e = th;
            this.f13708f = true;
        }

        @Override // g.a.d1.e.b
        public Throwable g() {
            return this.f13707e;
        }

        @Override // g.a.d1.e.b
        public T getValue() {
            a<T> aVar = this.f13705c;
            while (true) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null) {
                    return aVar.value;
                }
                aVar = aVar2;
            }
        }

        @Override // g.a.d1.e.b
        public T[] getValues(T[] tArr) {
            a<T> aVar = this.f13705c;
            a<T> aVar2 = aVar;
            int i2 = 0;
            while (true) {
                aVar2 = aVar2.get();
                if (aVar2 == null) {
                    break;
                }
                i2++;
            }
            if (tArr.length < i2) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
            }
            for (int i3 = 0; i3 < i2; i3++) {
                aVar = aVar.get();
                tArr[i3] = aVar.value;
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        }

        @Override // g.a.d1.e.b
        public boolean isDone() {
            return this.f13708f;
        }

        @Override // g.a.d1.e.b
        public void next(T t) {
            a<T> aVar = new a<>(t);
            a<T> aVar2 = this.f13706d;
            this.f13706d = aVar;
            this.f13704b++;
            aVar2.set(aVar);
            a();
        }

        @Override // g.a.d1.e.b
        public int size() {
            a<T> aVar = this.f13705c;
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE && (aVar = aVar.get()) != null) {
                i2++;
            }
            return i2;
        }

        @Override // g.a.d1.e.b
        public void a(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super T> cVar2 = cVar.actual;
            a<T> aVar = (a) cVar.index;
            if (aVar == null) {
                aVar = this.f13705c;
            }
            long j2 = cVar.emitted;
            int iAddAndGet = 1;
            do {
                long j3 = cVar.requested.get();
                while (j2 != j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z = this.f13708f;
                    a<T> aVar2 = aVar.get();
                    boolean z2 = aVar2 == null;
                    if (z && z2) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th = this.f13707e;
                        if (th == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    cVar2.onNext(aVar2.value);
                    j2++;
                    aVar = aVar2;
                }
                if (j2 == j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    if (this.f13708f && aVar.get() == null) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th2 = this.f13707e;
                        if (th2 == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th2);
                            return;
                        }
                    }
                }
                cVar.index = aVar;
                cVar.emitted = j2;
                iAddAndGet = cVar.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    /* compiled from: ReplayProcessor.java */
    static final class d<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f13694a;

        /* renamed from: b, reason: collision with root package name */
        final long f13695b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f13696c;

        /* renamed from: d, reason: collision with root package name */
        final j0 f13697d;

        /* renamed from: e, reason: collision with root package name */
        int f13698e;

        /* renamed from: f, reason: collision with root package name */
        volatile f<T> f13699f;

        /* renamed from: g, reason: collision with root package name */
        f<T> f13700g;

        /* renamed from: h, reason: collision with root package name */
        Throwable f13701h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f13702i;

        d(int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
            this.f13694a = g.a.y0.b.b.a(i2, "maxSize");
            this.f13695b = g.a.y0.b.b.a(j2, "maxAge");
            this.f13696c = (TimeUnit) g.a.y0.b.b.a(timeUnit, "unit is null");
            this.f13697d = (j0) g.a.y0.b.b.a(j0Var, "scheduler is null");
            f<T> fVar = new f<>(null, 0L);
            this.f13700g = fVar;
            this.f13699f = fVar;
        }

        f<T> a() {
            f<T> fVar;
            f<T> fVar2 = this.f13699f;
            long jA = this.f13697d.a(this.f13696c) - this.f13695b;
            f<T> fVar3 = fVar2.get();
            while (true) {
                f<T> fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 == null || fVar2.time > jA) {
                    break;
                }
                fVar3 = fVar2.get();
            }
            return fVar;
        }

        void b() {
            int i2 = this.f13698e;
            if (i2 > this.f13694a) {
                this.f13698e = i2 - 1;
                this.f13699f = this.f13699f.get();
            }
            long jA = this.f13697d.a(this.f13696c) - this.f13695b;
            f<T> fVar = this.f13699f;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    this.f13699f = fVar;
                    return;
                } else {
                    if (fVar2.time > jA) {
                        this.f13699f = fVar;
                        return;
                    }
                    fVar = fVar2;
                }
            }
        }

        void c() {
            long jA = this.f13697d.a(this.f13696c) - this.f13695b;
            f<T> fVar = this.f13699f;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    this.f13699f = fVar;
                    return;
                } else {
                    if (fVar2.time > jA) {
                        this.f13699f = fVar;
                        return;
                    }
                    fVar = fVar2;
                }
            }
        }

        @Override // g.a.d1.e.b
        public void complete() {
            c();
            this.f13702i = true;
        }

        @Override // g.a.d1.e.b
        public void error(Throwable th) {
            c();
            this.f13701h = th;
            this.f13702i = true;
        }

        @Override // g.a.d1.e.b
        public Throwable g() {
            return this.f13701h;
        }

        @Override // g.a.d1.e.b
        public T getValue() {
            f<T> fVar = this.f13699f;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    break;
                }
                fVar = fVar2;
            }
            if (fVar.time < this.f13697d.a(this.f13696c) - this.f13695b) {
                return null;
            }
            return fVar.value;
        }

        @Override // g.a.d1.e.b
        public T[] getValues(T[] tArr) {
            f<T> fVarA = a();
            int iA = a(fVarA);
            if (iA != 0) {
                if (tArr.length < iA) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iA));
                }
                for (int i2 = 0; i2 != iA; i2++) {
                    fVarA = fVarA.get();
                    tArr[i2] = fVarA.value;
                }
                if (tArr.length > iA) {
                    tArr[iA] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // g.a.d1.e.b
        public boolean isDone() {
            return this.f13702i;
        }

        @Override // g.a.d1.e.b
        public void next(T t) {
            f<T> fVar = new f<>(t, this.f13697d.a(this.f13696c));
            f<T> fVar2 = this.f13700g;
            this.f13700g = fVar;
            this.f13698e++;
            fVar2.set(fVar);
            b();
        }

        @Override // g.a.d1.e.b
        public int size() {
            return a(a());
        }

        @Override // g.a.d1.e.b
        public void a(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super T> cVar2 = cVar.actual;
            f<T> fVarA = (f) cVar.index;
            if (fVarA == null) {
                fVarA = a();
            }
            long j2 = cVar.emitted;
            int iAddAndGet = 1;
            do {
                long j3 = cVar.requested.get();
                while (j2 != j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z = this.f13702i;
                    f<T> fVar = fVarA.get();
                    boolean z2 = fVar == null;
                    if (z && z2) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th = this.f13701h;
                        if (th == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    cVar2.onNext(fVar.value);
                    j2++;
                    fVarA = fVar;
                }
                if (j2 == j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    if (this.f13702i && fVarA.get() == null) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th2 = this.f13701h;
                        if (th2 == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th2);
                            return;
                        }
                    }
                }
                cVar.index = fVarA;
                cVar.emitted = j2;
                iAddAndGet = cVar.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        int a(f<T> fVar) {
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE && (fVar = fVar.get()) != null) {
                i2++;
            }
            return i2;
        }
    }
}
