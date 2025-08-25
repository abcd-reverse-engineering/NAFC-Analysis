package g.a.y0.e.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableReplay.java */
/* loaded from: classes2.dex */
public final class m2<T> extends g.a.z0.a<T> implements g.a.y0.c.g<T>, g.a.u0.c {

    /* renamed from: e, reason: collision with root package name */
    static final b f15309e = new o();

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15310a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<j<T>> f15311b;

    /* renamed from: c, reason: collision with root package name */
    final b<T> f15312c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.g0<T> f15313d;

    /* compiled from: ObservableReplay.java */
    static abstract class a<T> extends AtomicReference<f> implements h<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        f tail;

        a() {
            f fVar = new f(null);
            this.tail = fVar;
            set(fVar);
        }

        final void addLast(f fVar) {
            this.tail.set(fVar);
            this.tail = fVar;
            this.size++;
        }

        final void collect(Collection<? super T> collection) {
            f head = getHead();
            while (true) {
                head = head.get();
                if (head == null) {
                    return;
                }
                Object objLeaveTransform = leaveTransform(head.value);
                if (g.a.y0.j.q.isComplete(objLeaveTransform) || g.a.y0.j.q.isError(objLeaveTransform)) {
                    return;
                } else {
                    collection.add((Object) g.a.y0.j.q.getValue(objLeaveTransform));
                }
            }
        }

        @Override // g.a.y0.e.d.m2.h
        public final void complete() {
            addLast(new f(enterTransform(g.a.y0.j.q.complete())));
            truncateFinal();
        }

        Object enterTransform(Object obj) {
            return obj;
        }

        @Override // g.a.y0.e.d.m2.h
        public final void error(Throwable th) {
            addLast(new f(enterTransform(g.a.y0.j.q.error(th))));
            truncateFinal();
        }

        f getHead() {
            return get();
        }

        boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && g.a.y0.j.q.isComplete(leaveTransform(obj));
        }

        boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && g.a.y0.j.q.isError(leaveTransform(obj));
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        @Override // g.a.y0.e.d.m2.h
        public final void next(T t) {
            addLast(new f(enterTransform(g.a.y0.j.q.next(t))));
            truncate();
        }

        final void removeFirst() {
            this.size--;
            setFirst(get().get());
        }

        final void removeSome(int i2) {
            f fVar = get();
            while (i2 > 0) {
                fVar = fVar.get();
                i2--;
                this.size--;
            }
            setFirst(fVar);
        }

        @Override // g.a.y0.e.d.m2.h
        public final void replay(d<T> dVar) {
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                f head = (f) dVar.index();
                if (head == null) {
                    head = getHead();
                    dVar.index = head;
                }
                while (!dVar.isDisposed()) {
                    f fVar = head.get();
                    if (fVar == null) {
                        dVar.index = head;
                        iAddAndGet = dVar.addAndGet(-iAddAndGet);
                    } else {
                        if (g.a.y0.j.q.accept(leaveTransform(fVar.value), dVar.child)) {
                            dVar.index = null;
                            return;
                        }
                        head = fVar;
                    }
                }
                return;
            } while (iAddAndGet != 0);
        }

        final void setFirst(f fVar) {
            set(fVar);
        }

        abstract void truncate();

        void truncateFinal() {
        }
    }

    /* compiled from: ObservableReplay.java */
    interface b<T> {
        h<T> call();
    }

    /* compiled from: ObservableReplay.java */
    static final class c<R> implements g.a.x0.g<g.a.u0.c> {

        /* renamed from: a, reason: collision with root package name */
        private final h4<R> f15314a;

        c(h4<R> h4Var) {
            this.f15314a = h4Var;
        }

        @Override // g.a.x0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(g.a.u0.c cVar) {
            this.f15314a.setResource(cVar);
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class d<T> extends AtomicInteger implements g.a.u0.c {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final g.a.i0<? super T> child;
        Object index;
        final j<T> parent;

        d(j<T> jVar, g.a.i0<? super T> i0Var) {
            this.parent = jVar;
            this.child = i0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.parent.remove(this);
        }

        <U> U index() {
            return (U) this.index;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class e<R, U> extends g.a.b0<R> {

        /* renamed from: a, reason: collision with root package name */
        private final Callable<? extends g.a.z0.a<U>> f15315a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.x0.o<? super g.a.b0<U>, ? extends g.a.g0<R>> f15316b;

        e(Callable<? extends g.a.z0.a<U>> callable, g.a.x0.o<? super g.a.b0<U>, ? extends g.a.g0<R>> oVar) {
            this.f15315a = callable;
            this.f15316b = oVar;
        }

        @Override // g.a.b0
        protected void d(g.a.i0<? super R> i0Var) {
            try {
                g.a.z0.a aVar = (g.a.z0.a) g.a.y0.b.b.a(this.f15315a.call(), "The connectableFactory returned a null ConnectableObservable");
                g.a.g0 g0Var = (g.a.g0) g.a.y0.b.b.a(this.f15316b.apply(aVar), "The selector returned a null ObservableSource");
                h4 h4Var = new h4(i0Var);
                g0Var.subscribe(h4Var);
                aVar.k((g.a.x0.g<? super g.a.u0.c>) new c(h4Var));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.y0.a.e.error(th, i0Var);
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class f extends AtomicReference<f> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        f(Object obj) {
            this.value = obj;
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class g<T> extends g.a.z0.a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.z0.a<T> f15317a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.b0<T> f15318b;

        g(g.a.z0.a<T> aVar, g.a.b0<T> b0Var) {
            this.f15317a = aVar;
            this.f15318b = b0Var;
        }

        @Override // g.a.b0
        protected void d(g.a.i0<? super T> i0Var) {
            this.f15318b.subscribe(i0Var);
        }

        @Override // g.a.z0.a
        public void k(g.a.x0.g<? super g.a.u0.c> gVar) {
            this.f15317a.k(gVar);
        }
    }

    /* compiled from: ObservableReplay.java */
    interface h<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(d<T> dVar);
    }

    /* compiled from: ObservableReplay.java */
    static final class i<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f15319a;

        i(int i2) {
            this.f15319a = i2;
        }

        @Override // g.a.y0.e.d.m2.b
        public h<T> call() {
            return new n(this.f15319a);
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class j<T> extends AtomicReference<g.a.u0.c> implements g.a.i0<T>, g.a.u0.c {
        static final d[] EMPTY = new d[0];
        static final d[] TERMINATED = new d[0];
        private static final long serialVersionUID = -533785617179540163L;
        final h<T> buffer;
        boolean done;
        final AtomicReference<d[]> observers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        j(h<T> hVar) {
            this.buffer = hVar;
        }

        boolean add(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.observers.get();
                if (dVarArr == TERMINATED) {
                    return false;
                }
                int length = dVarArr.length;
                dVarArr2 = new d[length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
            } while (!this.observers.compareAndSet(dVarArr, dVarArr2));
            return true;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.observers.set(TERMINATED);
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            replayFinal();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            replayFinal();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            replay();
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                replay();
            }
        }

        void remove(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.observers.get();
                int length = dVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (dVarArr[i3].equals(dVar)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    dVarArr2 = EMPTY;
                } else {
                    d[] dVarArr3 = new d[length - 1];
                    System.arraycopy(dVarArr, 0, dVarArr3, 0, i2);
                    System.arraycopy(dVarArr, i2 + 1, dVarArr3, i2, (length - i2) - 1);
                    dVarArr2 = dVarArr3;
                }
            } while (!this.observers.compareAndSet(dVarArr, dVarArr2));
        }

        void replay() {
            for (d<T> dVar : this.observers.get()) {
                this.buffer.replay(dVar);
            }
        }

        void replayFinal() {
            for (d<T> dVar : this.observers.getAndSet(TERMINATED)) {
                this.buffer.replay(dVar);
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class k<T> implements g.a.g0<T> {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicReference<j<T>> f15320a;

        /* renamed from: b, reason: collision with root package name */
        private final b<T> f15321b;

        k(AtomicReference<j<T>> atomicReference, b<T> bVar) {
            this.f15320a = atomicReference;
            this.f15321b = bVar;
        }

        @Override // g.a.g0
        public void subscribe(g.a.i0<? super T> i0Var) {
            j<T> jVar;
            while (true) {
                jVar = this.f15320a.get();
                if (jVar != null) {
                    break;
                }
                j<T> jVar2 = new j<>(this.f15321b.call());
                if (this.f15320a.compareAndSet(null, jVar2)) {
                    jVar = jVar2;
                    break;
                }
            }
            d<T> dVar = new d<>(jVar, i0Var);
            i0Var.onSubscribe(dVar);
            jVar.add(dVar);
            if (dVar.isDisposed()) {
                jVar.remove(dVar);
            } else {
                jVar.buffer.replay(dVar);
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class l<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f15322a;

        /* renamed from: b, reason: collision with root package name */
        private final long f15323b;

        /* renamed from: c, reason: collision with root package name */
        private final TimeUnit f15324c;

        /* renamed from: d, reason: collision with root package name */
        private final g.a.j0 f15325d;

        l(int i2, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.f15322a = i2;
            this.f15323b = j2;
            this.f15324c = timeUnit;
            this.f15325d = j0Var;
        }

        @Override // g.a.y0.e.d.m2.b
        public h<T> call() {
            return new m(this.f15322a, this.f15323b, this.f15324c, this.f15325d);
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class m<T> extends a<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final g.a.j0 scheduler;
        final TimeUnit unit;

        m(int i2, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.scheduler = j0Var;
            this.limit = i2;
            this.maxAge = j2;
            this.unit = timeUnit;
        }

        @Override // g.a.y0.e.d.m2.a
        Object enterTransform(Object obj) {
            return new g.a.e1.c(obj, this.scheduler.a(this.unit), this.unit);
        }

        @Override // g.a.y0.e.d.m2.a
        f getHead() {
            f fVar;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 == null) {
                    break;
                }
                g.a.e1.c cVar = (g.a.e1.c) fVar2.value;
                if (g.a.y0.j.q.isComplete(cVar.c()) || g.a.y0.j.q.isError(cVar.c()) || cVar.a() > jA) {
                    break;
                }
                fVar3 = fVar2.get();
            }
            return fVar;
        }

        @Override // g.a.y0.e.d.m2.a
        Object leaveTransform(Object obj) {
            return ((g.a.e1.c) obj).c();
        }

        @Override // g.a.y0.e.d.m2.a
        void truncate() {
            f fVar;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            int i2 = 0;
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 != null) {
                    int i3 = this.size;
                    if (i3 <= this.limit) {
                        if (((g.a.e1.c) fVar2.value).a() > jA) {
                            break;
                        }
                        i2++;
                        this.size--;
                        fVar3 = fVar2.get();
                    } else {
                        i2++;
                        this.size = i3 - 1;
                        fVar3 = fVar2.get();
                    }
                } else {
                    break;
                }
            }
            if (i2 != 0) {
                setFirst(fVar);
            }
        }

        @Override // g.a.y0.e.d.m2.a
        void truncateFinal() {
            f fVar;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            int i2 = 0;
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 == null || this.size <= 1 || ((g.a.e1.c) fVar2.value).a() > jA) {
                    break;
                }
                i2++;
                this.size--;
                fVar3 = fVar2.get();
            }
            if (i2 != 0) {
                setFirst(fVar);
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class n<T> extends a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        n(int i2) {
            this.limit = i2;
        }

        @Override // g.a.y0.e.d.m2.a
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class o implements b<Object> {
        o() {
        }

        @Override // g.a.y0.e.d.m2.b
        public h<Object> call() {
            return new p(16);
        }
    }

    /* compiled from: ObservableReplay.java */
    static final class p<T> extends ArrayList<Object> implements h<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        p(int i2) {
            super(i2);
        }

        @Override // g.a.y0.e.d.m2.h
        public void complete() {
            add(g.a.y0.j.q.complete());
            this.size++;
        }

        @Override // g.a.y0.e.d.m2.h
        public void error(Throwable th) {
            add(g.a.y0.j.q.error(th));
            this.size++;
        }

        @Override // g.a.y0.e.d.m2.h
        public void next(T t) {
            add(g.a.y0.j.q.next(t));
            this.size++;
        }

        @Override // g.a.y0.e.d.m2.h
        public void replay(d<T> dVar) {
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            g.a.i0<? super T> i0Var = dVar.child;
            int iAddAndGet = 1;
            while (!dVar.isDisposed()) {
                int i2 = this.size;
                Integer num = (Integer) dVar.index();
                int iIntValue = num != null ? num.intValue() : 0;
                while (iIntValue < i2) {
                    if (g.a.y0.j.q.accept(get(iIntValue), i0Var) || dVar.isDisposed()) {
                        return;
                    } else {
                        iIntValue++;
                    }
                }
                dVar.index = Integer.valueOf(iIntValue);
                iAddAndGet = dVar.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    private m2(g.a.g0<T> g0Var, g.a.g0<T> g0Var2, AtomicReference<j<T>> atomicReference, b<T> bVar) {
        this.f15313d = g0Var;
        this.f15310a = g0Var2;
        this.f15311b = atomicReference;
        this.f15312c = bVar;
    }

    public static <U, R> g.a.b0<R> a(Callable<? extends g.a.z0.a<U>> callable, g.a.x0.o<? super g.a.b0<U>, ? extends g.a.g0<R>> oVar) {
        return g.a.c1.a.a(new e(callable, oVar));
    }

    public static <T> g.a.z0.a<T> h(g.a.g0<T> g0Var, int i2) {
        return i2 == Integer.MAX_VALUE ? w(g0Var) : a((g.a.g0) g0Var, (b) new i(i2));
    }

    public static <T> g.a.z0.a<T> w(g.a.g0<? extends T> g0Var) {
        return a((g.a.g0) g0Var, f15309e);
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f15313d.subscribe(i0Var);
    }

    @Override // g.a.u0.c
    public void dispose() {
        this.f15311b.lazySet(null);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        j<T> jVar = this.f15311b.get();
        return jVar == null || jVar.isDisposed();
    }

    @Override // g.a.z0.a
    public void k(g.a.x0.g<? super g.a.u0.c> gVar) {
        j<T> jVar;
        while (true) {
            jVar = this.f15311b.get();
            if (jVar != null && !jVar.isDisposed()) {
                break;
            }
            j<T> jVar2 = new j<>(this.f15312c.call());
            if (this.f15311b.compareAndSet(jVar, jVar2)) {
                jVar = jVar2;
                break;
            }
        }
        boolean z = !jVar.shouldConnect.get() && jVar.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(jVar);
            if (z) {
                this.f15310a.subscribe(jVar);
            }
        } catch (Throwable th) {
            if (z) {
                jVar.shouldConnect.compareAndSet(true, false);
            }
            g.a.v0.b.b(th);
            throw g.a.y0.j.k.c(th);
        }
    }

    @Override // g.a.y0.c.g
    public g.a.g0<T> source() {
        return this.f15310a;
    }

    public static <T> g.a.z0.a<T> a(g.a.z0.a<T> aVar, g.a.j0 j0Var) {
        return g.a.c1.a.a((g.a.z0.a) new g(aVar, aVar.a(j0Var)));
    }

    public static <T> g.a.z0.a<T> a(g.a.g0<T> g0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        return a(g0Var, j2, timeUnit, j0Var, Integer.MAX_VALUE);
    }

    public static <T> g.a.z0.a<T> a(g.a.g0<T> g0Var, long j2, TimeUnit timeUnit, g.a.j0 j0Var, int i2) {
        return a((g.a.g0) g0Var, (b) new l(i2, j2, timeUnit, j0Var));
    }

    static <T> g.a.z0.a<T> a(g.a.g0<T> g0Var, b<T> bVar) {
        AtomicReference atomicReference = new AtomicReference();
        return g.a.c1.a.a((g.a.z0.a) new m2(new k(atomicReference, bVar), g0Var, atomicReference, bVar));
    }
}
