package g.a.y0.e.d;

import java.util.Iterator;

/* compiled from: ObservableFromIterable.java */
/* loaded from: classes2.dex */
public final class d1<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends T> f15035a;

    /* compiled from: ObservableFromIterable.java */
    static final class a<T> extends g.a.y0.d.c<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15036a;

        /* renamed from: b, reason: collision with root package name */
        final Iterator<? extends T> f15037b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f15038c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15039d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15040e;

        /* renamed from: f, reason: collision with root package name */
        boolean f15041f;

        a(g.a.i0<? super T> i0Var, Iterator<? extends T> it) {
            this.f15036a = i0Var;
            this.f15037b = it;
        }

        void a() {
            while (!isDisposed()) {
                try {
                    this.f15036a.onNext(g.a.y0.b.b.a((Object) this.f15037b.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f15037b.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.f15036a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.f15036a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    this.f15036a.onError(th2);
                    return;
                }
            }
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.f15040e = true;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15038c = true;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15038c;
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.f15040e;
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() {
            if (this.f15040e) {
                return null;
            }
            if (!this.f15041f) {
                this.f15041f = true;
            } else if (!this.f15037b.hasNext()) {
                this.f15040e = true;
                return null;
            }
            return (T) g.a.y0.b.b.a((Object) this.f15037b.next(), "The iterator returned a null value");
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f15039d = true;
            return 1;
        }
    }

    public d1(Iterable<? extends T> iterable) {
        this.f15035a = iterable;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        try {
            Iterator<? extends T> it = this.f15035a.iterator();
            try {
                if (!it.hasNext()) {
                    g.a.y0.a.e.complete(i0Var);
                    return;
                }
                a aVar = new a(i0Var, it);
                i0Var.onSubscribe(aVar);
                if (aVar.f15039d) {
                    return;
                }
                aVar.a();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.y0.a.e.error(th, i0Var);
            }
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.y0.a.e.error(th2, i0Var);
        }
    }
}
