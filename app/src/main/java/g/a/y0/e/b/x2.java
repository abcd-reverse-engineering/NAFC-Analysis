package g.a.y0.e.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableReplay.java */
/* loaded from: classes2.dex */
public final class x2<T> extends g.a.w0.a<T> implements g.a.y0.c.h<T>, g.a.u0.c {

    /* renamed from: f, reason: collision with root package name */
    static final Callable f14690f = new c();

    /* renamed from: b, reason: collision with root package name */
    final g.a.l<T> f14691b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<j<T>> f14692c;

    /* renamed from: d, reason: collision with root package name */
    final Callable<? extends g<T>> f14693d;

    /* renamed from: e, reason: collision with root package name */
    final i.d.b<T> f14694e;

    /* compiled from: FlowableReplay.java */
    static class a<T> extends AtomicReference<f> implements g<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        f tail;

        a() {
            f fVar = new f(null, 0L);
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

        @Override // g.a.y0.e.b.x2.g
        public final void complete() {
            Object objEnterTransform = enterTransform(g.a.y0.j.q.complete());
            long j2 = this.index + 1;
            this.index = j2;
            addLast(new f(objEnterTransform, j2));
            truncateFinal();
        }

        Object enterTransform(Object obj) {
            return obj;
        }

        @Override // g.a.y0.e.b.x2.g
        public final void error(Throwable th) {
            Object objEnterTransform = enterTransform(g.a.y0.j.q.error(th));
            long j2 = this.index + 1;
            this.index = j2;
            addLast(new f(objEnterTransform, j2));
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

        @Override // g.a.y0.e.b.x2.g
        public final void next(T t) {
            Object objEnterTransform = enterTransform(g.a.y0.j.q.next(t));
            long j2 = this.index + 1;
            this.index = j2;
            addLast(new f(objEnterTransform, j2));
            truncate();
        }

        final void removeFirst() {
            f fVar = get().get();
            if (fVar == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            setFirst(fVar);
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

        @Override // g.a.y0.e.b.x2.g
        public final void replay(d<T> dVar) {
            f fVar;
            synchronized (dVar) {
                if (dVar.emitting) {
                    dVar.missed = true;
                    return;
                }
                dVar.emitting = true;
                while (!dVar.isDisposed()) {
                    long j2 = dVar.get();
                    boolean z = j2 == h.q2.t.m0.f16408b;
                    f head = (f) dVar.index();
                    if (head == null) {
                        head = getHead();
                        dVar.index = head;
                        g.a.y0.j.d.a(dVar.totalRequested, head.index);
                    }
                    long j3 = 0;
                    while (j2 != 0 && (fVar = head.get()) != null) {
                        Object objLeaveTransform = leaveTransform(fVar.value);
                        try {
                            if (g.a.y0.j.q.accept(objLeaveTransform, dVar.child)) {
                                dVar.index = null;
                                return;
                            }
                            j3++;
                            j2--;
                            if (dVar.isDisposed()) {
                                return;
                            } else {
                                head = fVar;
                            }
                        } catch (Throwable th) {
                            g.a.v0.b.b(th);
                            dVar.index = null;
                            dVar.dispose();
                            if (g.a.y0.j.q.isError(objLeaveTransform) || g.a.y0.j.q.isComplete(objLeaveTransform)) {
                                return;
                            }
                            dVar.child.onError(th);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        dVar.index = head;
                        if (!z) {
                            dVar.produced(j3);
                        }
                    }
                    synchronized (dVar) {
                        if (!dVar.missed) {
                            dVar.emitting = false;
                            return;
                        }
                        dVar.missed = false;
                    }
                }
            }
        }

        final void setFirst(f fVar) {
            set(fVar);
        }

        void truncate() {
        }

        void truncateFinal() {
        }
    }

    /* compiled from: FlowableReplay.java */
    static final class b<T> extends g.a.w0.a<T> {

        /* renamed from: b, reason: collision with root package name */
        private final g.a.w0.a<T> f14695b;

        /* renamed from: c, reason: collision with root package name */
        private final g.a.l<T> f14696c;

        b(g.a.w0.a<T> aVar, g.a.l<T> lVar) {
            this.f14695b = aVar;
            this.f14696c = lVar;
        }

        @Override // g.a.l
        protected void d(i.d.c<? super T> cVar) {
            this.f14696c.subscribe(cVar);
        }

        @Override // g.a.w0.a
        public void l(g.a.x0.g<? super g.a.u0.c> gVar) {
            this.f14695b.l(gVar);
        }
    }

    /* compiled from: FlowableReplay.java */
    static final class c implements Callable<Object> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new n(16);
        }
    }

    /* compiled from: FlowableReplay.java */
    static final class d<T> extends AtomicLong implements i.d.d, g.a.u0.c {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final i.d.c<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final j<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        d(j<T> jVar, i.d.c<? super T> cVar) {
            this.parent = jVar;
            this.child = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            dispose();
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
            }
        }

        <U> U index() {
            return (U) this.index;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j2) {
            return g.a.y0.j.d.d(this, j2);
        }

        @Override // i.d.d
        public void request(long j2) {
            long j3;
            if (g.a.y0.i.j.validate(j2)) {
                do {
                    j3 = get();
                    if (j3 == Long.MIN_VALUE) {
                        return;
                    }
                    if (j3 >= 0 && j2 == 0) {
                        return;
                    }
                } while (!compareAndSet(j3, g.a.y0.j.d.a(j3, j2)));
                g.a.y0.j.d.a(this.totalRequested, j2);
                this.parent.manageRequests();
                this.parent.buffer.replay(this);
            }
        }
    }

    /* compiled from: FlowableReplay.java */
    static final class e<R, U> implements i.d.b<R> {

        /* renamed from: a, reason: collision with root package name */
        private final Callable<? extends g.a.w0.a<U>> f14697a;

        /* renamed from: b, reason: collision with root package name */
        private final g.a.x0.o<? super g.a.l<U>, ? extends i.d.b<R>> f14698b;

        /* compiled from: FlowableReplay.java */
        final class a implements g.a.x0.g<g.a.u0.c> {

            /* renamed from: a, reason: collision with root package name */
            private final g.a.y0.h.u<R> f14699a;

            a(g.a.y0.h.u<R> uVar) {
                this.f14699a = uVar;
            }

            @Override // g.a.x0.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(g.a.u0.c cVar) {
                this.f14699a.setResource(cVar);
            }
        }

        e(Callable<? extends g.a.w0.a<U>> callable, g.a.x0.o<? super g.a.l<U>, ? extends i.d.b<R>> oVar) {
            this.f14697a = callable;
            this.f14698b = oVar;
        }

        @Override // i.d.b
        public void subscribe(i.d.c<? super R> cVar) {
            try {
                g.a.w0.a aVar = (g.a.w0.a) g.a.y0.b.b.a(this.f14697a.call(), "The connectableFactory returned null");
                try {
                    i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.f14698b.apply(aVar), "The selector returned a null Publisher");
                    g.a.y0.h.u uVar = new g.a.y0.h.u(cVar);
                    bVar.subscribe(uVar);
                    aVar.l((g.a.x0.g<? super g.a.u0.c>) new a(uVar));
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.y0.i.g.error(th, cVar);
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                g.a.y0.i.g.error(th2, cVar);
            }
        }
    }

    /* compiled from: FlowableReplay.java */
    static final class f extends AtomicReference<f> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        f(Object obj, long j2) {
            this.value = obj;
            this.index = j2;
        }
    }

    /* compiled from: FlowableReplay.java */
    interface g<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(d<T> dVar);
    }

    /* compiled from: FlowableReplay.java */
    static final class h<T> implements Callable<g<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final int f14701a;

        h(int i2) {
            this.f14701a = i2;
        }

        @Override // java.util.concurrent.Callable
        public g<T> call() {
            return new m(this.f14701a);
        }
    }

    /* compiled from: FlowableReplay.java */
    static final class i<T> implements i.d.b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicReference<j<T>> f14702a;

        /* renamed from: b, reason: collision with root package name */
        private final Callable<? extends g<T>> f14703b;

        i(AtomicReference<j<T>> atomicReference, Callable<? extends g<T>> callable) {
            this.f14702a = atomicReference;
            this.f14703b = callable;
        }

        @Override // i.d.b
        public void subscribe(i.d.c<? super T> cVar) {
            j<T> jVar;
            while (true) {
                jVar = this.f14702a.get();
                if (jVar != null) {
                    break;
                }
                try {
                    j<T> jVar2 = new j<>(this.f14703b.call());
                    if (this.f14702a.compareAndSet(null, jVar2)) {
                        jVar = jVar2;
                        break;
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    throw g.a.y0.j.k.c(th);
                }
            }
            d<T> dVar = new d<>(jVar, cVar);
            cVar.onSubscribe(dVar);
            jVar.add(dVar);
            if (dVar.isDisposed()) {
                jVar.remove(dVar);
            } else {
                jVar.manageRequests();
                jVar.buffer.replay(dVar);
            }
        }
    }

    /* compiled from: FlowableReplay.java */
    static final class j<T> extends AtomicReference<i.d.d> implements g.a.q<T>, g.a.u0.c {
        static final d[] EMPTY = new d[0];
        static final d[] TERMINATED = new d[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final g<T> buffer;
        boolean done;
        long maxChildRequested;
        long maxUpstreamRequested;
        final AtomicInteger management = new AtomicInteger();
        final AtomicReference<d<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        j(g<T> gVar) {
            this.buffer = gVar;
        }

        boolean add(d<T> dVar) {
            d<T>[] dVarArr;
            d<T>[] dVarArr2;
            if (dVar == null) {
                throw new NullPointerException();
            }
            do {
                dVarArr = this.subscribers.get();
                if (dVarArr == TERMINATED) {
                    return false;
                }
                int length = dVarArr.length;
                dVarArr2 = new d[length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
            } while (!this.subscribers.compareAndSet(dVarArr, dVarArr2));
            return true;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.subscribers.set(TERMINATED);
            g.a.y0.i.j.cancel(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        void manageRequests() {
            if (this.management.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            while (!isDisposed()) {
                d<T>[] dVarArr = this.subscribers.get();
                long j2 = this.maxChildRequested;
                long jMax = j2;
                for (d<T> dVar : dVarArr) {
                    jMax = Math.max(jMax, dVar.totalRequested.get());
                }
                long j3 = this.maxUpstreamRequested;
                i.d.d dVar2 = get();
                long j4 = jMax - j2;
                if (j4 != 0) {
                    this.maxChildRequested = jMax;
                    if (dVar2 == null) {
                        long j5 = j3 + j4;
                        if (j5 < 0) {
                            j5 = h.q2.t.m0.f16408b;
                        }
                        this.maxUpstreamRequested = j5;
                    } else if (j3 != 0) {
                        this.maxUpstreamRequested = 0L;
                        dVar2.request(j3 + j4);
                    } else {
                        dVar2.request(j4);
                    }
                } else if (j3 != 0 && dVar2 != null) {
                    this.maxUpstreamRequested = 0L;
                    dVar2.request(j3);
                }
                iAddAndGet = this.management.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            for (d<T> dVar : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(dVar);
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            for (d<T> dVar : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(dVar);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            for (d<T> dVar : this.subscribers.get()) {
                this.buffer.replay(dVar);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                manageRequests();
                for (d<T> dVar2 : this.subscribers.get()) {
                    this.buffer.replay(dVar2);
                }
            }
        }

        void remove(d<T> dVar) {
            d<T>[] dVarArr;
            d<T>[] dVarArr2;
            do {
                dVarArr = this.subscribers.get();
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
                    d<T>[] dVarArr3 = new d[length - 1];
                    System.arraycopy(dVarArr, 0, dVarArr3, 0, i2);
                    System.arraycopy(dVarArr, i2 + 1, dVarArr3, i2, (length - i2) - 1);
                    dVarArr2 = dVarArr3;
                }
            } while (!this.subscribers.compareAndSet(dVarArr, dVarArr2));
        }
    }

    /* compiled from: FlowableReplay.java */
    static final class k<T> implements Callable<g<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final int f14704a;

        /* renamed from: b, reason: collision with root package name */
        private final long f14705b;

        /* renamed from: c, reason: collision with root package name */
        private final TimeUnit f14706c;

        /* renamed from: d, reason: collision with root package name */
        private final g.a.j0 f14707d;

        k(int i2, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.f14704a = i2;
            this.f14705b = j2;
            this.f14706c = timeUnit;
            this.f14707d = j0Var;
        }

        @Override // java.util.concurrent.Callable
        public g<T> call() {
            return new l(this.f14704a, this.f14705b, this.f14706c, this.f14707d);
        }
    }

    /* compiled from: FlowableReplay.java */
    static final class l<T> extends a<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final g.a.j0 scheduler;
        final TimeUnit unit;

        l(int i2, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.scheduler = j0Var;
            this.limit = i2;
            this.maxAge = j2;
            this.unit = timeUnit;
        }

        @Override // g.a.y0.e.b.x2.a
        Object enterTransform(Object obj) {
            return new g.a.e1.c(obj, this.scheduler.a(this.unit), this.unit);
        }

        @Override // g.a.y0.e.b.x2.a
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

        @Override // g.a.y0.e.b.x2.a
        Object leaveTransform(Object obj) {
            return ((g.a.e1.c) obj).c();
        }

        @Override // g.a.y0.e.b.x2.a
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

        @Override // g.a.y0.e.b.x2.a
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

    /* compiled from: FlowableReplay.java */
    static final class m<T> extends a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        m(int i2) {
            this.limit = i2;
        }

        @Override // g.a.y0.e.b.x2.a
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* compiled from: FlowableReplay.java */
    static final class n<T> extends ArrayList<Object> implements g<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        n(int i2) {
            super(i2);
        }

        @Override // g.a.y0.e.b.x2.g
        public void complete() {
            add(g.a.y0.j.q.complete());
            this.size++;
        }

        @Override // g.a.y0.e.b.x2.g
        public void error(Throwable th) {
            add(g.a.y0.j.q.error(th));
            this.size++;
        }

        @Override // g.a.y0.e.b.x2.g
        public void next(T t) {
            add(g.a.y0.j.q.next(t));
            this.size++;
        }

        @Override // g.a.y0.e.b.x2.g
        public void replay(d<T> dVar) {
            synchronized (dVar) {
                if (dVar.emitting) {
                    dVar.missed = true;
                    return;
                }
                dVar.emitting = true;
                i.d.c<? super T> cVar = dVar.child;
                while (!dVar.isDisposed()) {
                    int i2 = this.size;
                    Integer num = (Integer) dVar.index();
                    int iIntValue = num != null ? num.intValue() : 0;
                    long j2 = dVar.get();
                    long j3 = j2;
                    long j4 = 0;
                    while (j3 != 0 && iIntValue < i2) {
                        Object obj = get(iIntValue);
                        try {
                            if (g.a.y0.j.q.accept(obj, cVar) || dVar.isDisposed()) {
                                return;
                            }
                            iIntValue++;
                            j3--;
                            j4++;
                        } catch (Throwable th) {
                            g.a.v0.b.b(th);
                            dVar.dispose();
                            if (g.a.y0.j.q.isError(obj) || g.a.y0.j.q.isComplete(obj)) {
                                return;
                            }
                            cVar.onError(th);
                            return;
                        }
                    }
                    if (j4 != 0) {
                        dVar.index = Integer.valueOf(iIntValue);
                        if (j2 != h.q2.t.m0.f16408b) {
                            dVar.produced(j4);
                        }
                    }
                    synchronized (dVar) {
                        if (!dVar.missed) {
                            dVar.emitting = false;
                            return;
                        }
                        dVar.missed = false;
                    }
                }
            }
        }
    }

    private x2(i.d.b<T> bVar, g.a.l<T> lVar, AtomicReference<j<T>> atomicReference, Callable<? extends g<T>> callable) {
        this.f14694e = bVar;
        this.f14691b = lVar;
        this.f14692c = atomicReference;
        this.f14693d = callable;
    }

    public static <U, R> g.a.l<R> a(Callable<? extends g.a.w0.a<U>> callable, g.a.x0.o<? super g.a.l<U>, ? extends i.d.b<R>> oVar) {
        return g.a.l.v(new e(callable, oVar));
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14694e.subscribe(cVar);
    }

    @Override // g.a.u0.c
    public void dispose() {
        this.f14692c.lazySet(null);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        j<T> jVar = this.f14692c.get();
        return jVar == null || jVar.isDisposed();
    }

    @Override // g.a.w0.a
    public void l(g.a.x0.g<? super g.a.u0.c> gVar) {
        j<T> jVar;
        while (true) {
            jVar = this.f14692c.get();
            if (jVar != null && !jVar.isDisposed()) {
                break;
            }
            try {
                j<T> jVar2 = new j<>(this.f14693d.call());
                if (this.f14692c.compareAndSet(jVar, jVar2)) {
                    jVar = jVar2;
                    break;
                }
            } finally {
                g.a.v0.b.b(th);
                RuntimeException runtimeExceptionC = g.a.y0.j.k.c(th);
            }
        }
        boolean z = !jVar.shouldConnect.get() && jVar.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(jVar);
            if (z) {
                this.f14691b.a((g.a.q) jVar);
            }
        } catch (Throwable th) {
            if (z) {
                jVar.shouldConnect.compareAndSet(true, false);
            }
            throw g.a.y0.j.k.c(th);
        }
    }

    @Override // g.a.y0.c.h
    public i.d.b<T> source() {
        return this.f14691b;
    }

    public static <T> g.a.w0.a<T> a(g.a.w0.a<T> aVar, g.a.j0 j0Var) {
        return g.a.c1.a.a((g.a.w0.a) new b(aVar, aVar.a(j0Var)));
    }

    public static <T> g.a.w0.a<T> a(g.a.l<? extends T> lVar) {
        return a((g.a.l) lVar, f14690f);
    }

    public static <T> g.a.w0.a<T> a(g.a.l<T> lVar, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return a((g.a.l) lVar);
        }
        return a((g.a.l) lVar, (Callable) new h(i2));
    }

    public static <T> g.a.w0.a<T> a(g.a.l<T> lVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        return a(lVar, j2, timeUnit, j0Var, Integer.MAX_VALUE);
    }

    public static <T> g.a.w0.a<T> a(g.a.l<T> lVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var, int i2) {
        return a((g.a.l) lVar, (Callable) new k(i2, j2, timeUnit, j0Var));
    }

    static <T> g.a.w0.a<T> a(g.a.l<T> lVar, Callable<? extends g<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return g.a.c1.a.a((g.a.w0.a) new x2(new i(atomicReference, callable), lVar, atomicReference, callable));
    }
}
