package g.a.y0.e.d;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableBuffer.java */
/* loaded from: classes2.dex */
public final class m<T, U extends Collection<? super T>> extends g.a.y0.e.d.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final int f15258b;

    /* renamed from: c, reason: collision with root package name */
    final int f15259c;

    /* renamed from: d, reason: collision with root package name */
    final Callable<U> f15260d;

    /* compiled from: ObservableBuffer.java */
    static final class a<T, U extends Collection<? super T>> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super U> f15261a;

        /* renamed from: b, reason: collision with root package name */
        final int f15262b;

        /* renamed from: c, reason: collision with root package name */
        final Callable<U> f15263c;

        /* renamed from: d, reason: collision with root package name */
        U f15264d;

        /* renamed from: e, reason: collision with root package name */
        int f15265e;

        /* renamed from: f, reason: collision with root package name */
        g.a.u0.c f15266f;

        a(g.a.i0<? super U> i0Var, int i2, Callable<U> callable) {
            this.f15261a = i0Var;
            this.f15262b = i2;
            this.f15263c = callable;
        }

        boolean a() {
            try {
                this.f15264d = (U) g.a.y0.b.b.a(this.f15263c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15264d = null;
                g.a.u0.c cVar = this.f15266f;
                if (cVar == null) {
                    g.a.y0.a.e.error(th, this.f15261a);
                    return false;
                }
                cVar.dispose();
                this.f15261a.onError(th);
                return false;
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15266f.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15266f.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            U u = this.f15264d;
            this.f15264d = null;
            if (u != null && !u.isEmpty()) {
                this.f15261a.onNext(u);
            }
            this.f15261a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.f15264d = null;
            this.f15261a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            U u = this.f15264d;
            if (u != null) {
                u.add(t);
                int i2 = this.f15265e + 1;
                this.f15265e = i2;
                if (i2 >= this.f15262b) {
                    this.f15261a.onNext(u);
                    this.f15265e = 0;
                    a();
                }
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15266f, cVar)) {
                this.f15266f = cVar;
                this.f15261a.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableBuffer.java */
    static final class b<T, U extends Collection<? super T>> extends AtomicBoolean implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = -8223395059921494546L;
        final g.a.i0<? super U> actual;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        long index;
        g.a.u0.c s;
        final int skip;

        b(g.a.i0<? super U> i0Var, int i2, int i3, Callable<U> callable) {
            this.actual = i0Var;
            this.count = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.s.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.actual.onNext(this.buffers.poll());
            }
            this.actual.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            long j2 = this.index;
            this.index = 1 + j2;
            if (j2 % this.skip == 0) {
                try {
                    this.buffers.offer((Collection) g.a.y0.b.b.a(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.s.dispose();
                    this.actual.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.count <= next.size()) {
                    it.remove();
                    this.actual.onNext(next);
                }
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

    public m(g.a.g0<T> g0Var, int i2, int i3, Callable<U> callable) {
        super(g0Var);
        this.f15258b = i2;
        this.f15259c = i3;
        this.f15260d = callable;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super U> i0Var) {
        int i2 = this.f15259c;
        int i3 = this.f15258b;
        if (i2 != i3) {
            this.f14934a.subscribe(new b(i0Var, i3, i2, this.f15260d));
            return;
        }
        a aVar = new a(i0Var, i3, this.f15260d);
        if (aVar.a()) {
            this.f14934a.subscribe(aVar);
        }
    }
}
