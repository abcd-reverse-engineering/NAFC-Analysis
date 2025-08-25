package g.a.y0.e.b;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableBuffer.java */
/* loaded from: classes2.dex */
public final class m<T, C extends Collection<? super T>> extends g.a.y0.e.b.a<T, C> {

    /* renamed from: c, reason: collision with root package name */
    final int f14367c;

    /* renamed from: d, reason: collision with root package name */
    final int f14368d;

    /* renamed from: e, reason: collision with root package name */
    final Callable<C> f14369e;

    /* compiled from: FlowableBuffer.java */
    static final class a<T, C extends Collection<? super T>> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super C> f14370a;

        /* renamed from: b, reason: collision with root package name */
        final Callable<C> f14371b;

        /* renamed from: c, reason: collision with root package name */
        final int f14372c;

        /* renamed from: d, reason: collision with root package name */
        C f14373d;

        /* renamed from: e, reason: collision with root package name */
        i.d.d f14374e;

        /* renamed from: f, reason: collision with root package name */
        boolean f14375f;

        /* renamed from: g, reason: collision with root package name */
        int f14376g;

        a(i.d.c<? super C> cVar, int i2, Callable<C> callable) {
            this.f14370a = cVar;
            this.f14372c = i2;
            this.f14371b = callable;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14374e.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14375f) {
                return;
            }
            this.f14375f = true;
            C c2 = this.f14373d;
            if (c2 != null && !c2.isEmpty()) {
                this.f14370a.onNext(c2);
            }
            this.f14370a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14375f) {
                g.a.c1.a.b(th);
            } else {
                this.f14375f = true;
                this.f14370a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14375f) {
                return;
            }
            C c2 = this.f14373d;
            if (c2 == null) {
                try {
                    c2 = (C) g.a.y0.b.b.a(this.f14371b.call(), "The bufferSupplier returned a null buffer");
                    this.f14373d = c2;
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c2.add(t);
            int i2 = this.f14376g + 1;
            if (i2 != this.f14372c) {
                this.f14376g = i2;
                return;
            }
            this.f14376g = 0;
            this.f14373d = null;
            this.f14370a.onNext(c2);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14374e, dVar)) {
                this.f14374e = dVar;
                this.f14370a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                this.f14374e.request(g.a.y0.j.d.b(j2, this.f14372c));
            }
        }
    }

    /* compiled from: FlowableBuffer.java */
    static final class b<T, C extends Collection<? super T>> extends AtomicLong implements g.a.q<T>, i.d.d, g.a.x0.e {
        private static final long serialVersionUID = -7370244972039324525L;
        final i.d.c<? super C> actual;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        boolean done;
        int index;
        long produced;
        i.d.d s;
        final int size;
        final int skip;
        final AtomicBoolean once = new AtomicBoolean();
        final ArrayDeque<C> buffers = new ArrayDeque<>();

        b(i.d.c<? super C> cVar, int i2, int i3, Callable<C> callable) {
            this.actual = cVar;
            this.size = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // i.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
        }

        @Override // g.a.x0.e
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j2 = this.produced;
            if (j2 != 0) {
                g.a.y0.j.d.c(this, j2);
            }
            g.a.y0.j.v.a(this.actual, this.buffers, this, this);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.buffers;
            int i2 = this.index;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    arrayDeque.offer((Collection) g.a.y0.b.b.a(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.size) {
                arrayDeque.poll();
                collection.add(t);
                this.produced++;
                this.actual.onNext(collection);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t);
            }
            if (i3 == this.skip) {
                i3 = 0;
            }
            this.index = i3;
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (!g.a.y0.i.j.validate(j2) || g.a.y0.j.v.b(j2, this.actual, this.buffers, this, this)) {
                return;
            }
            if (this.once.get() || !this.once.compareAndSet(false, true)) {
                this.s.request(g.a.y0.j.d.b(this.skip, j2));
            } else {
                this.s.request(g.a.y0.j.d.a(this.size, g.a.y0.j.d.b(this.skip, j2 - 1)));
            }
        }
    }

    /* compiled from: FlowableBuffer.java */
    static final class c<T, C extends Collection<? super T>> extends AtomicInteger implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -5616169793639412593L;
        final i.d.c<? super C> actual;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        int index;
        i.d.d s;
        final int size;
        final int skip;

        c(i.d.c<? super C> cVar, int i2, int i3, Callable<C> callable) {
            this.actual = cVar;
            this.size = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // i.d.d
        public void cancel() {
            this.s.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c2 = this.buffer;
            this.buffer = null;
            if (c2 != null) {
                this.actual.onNext(c2);
            }
            this.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            C c2 = this.buffer;
            int i2 = this.index;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    c2 = (C) g.a.y0.b.b.a(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c2;
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c2 != null) {
                c2.add(t);
                if (c2.size() == this.size) {
                    this.buffer = null;
                    this.actual.onNext(c2);
                }
            }
            if (i3 == this.skip) {
                i3 = 0;
            }
            this.index = i3;
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                if (get() != 0 || !compareAndSet(0, 1)) {
                    this.s.request(g.a.y0.j.d.b(this.skip, j2));
                    return;
                }
                this.s.request(g.a.y0.j.d.a(g.a.y0.j.d.b(j2, this.size), g.a.y0.j.d.b(this.skip - this.size, j2 - 1)));
            }
        }
    }

    public m(g.a.l<T> lVar, int i2, int i3, Callable<C> callable) {
        super(lVar);
        this.f14367c = i2;
        this.f14368d = i3;
        this.f14369e = callable;
    }

    @Override // g.a.l
    public void d(i.d.c<? super C> cVar) {
        int i2 = this.f14367c;
        int i3 = this.f14368d;
        if (i2 == i3) {
            this.f14110b.a((g.a.q) new a(cVar, i2, this.f14369e));
        } else if (i3 > i2) {
            this.f14110b.a((g.a.q) new c(cVar, i2, i3, this.f14369e));
        } else {
            this.f14110b.a((g.a.q) new b(cVar, i2, i3, this.f14369e));
        }
    }
}
