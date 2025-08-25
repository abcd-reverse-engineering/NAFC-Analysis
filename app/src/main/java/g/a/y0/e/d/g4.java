package g.a.y0.e.d;

import java.util.Iterator;

/* compiled from: ObservableZipIterable.java */
/* loaded from: classes2.dex */
public final class g4<T, U, V> extends g.a.b0<V> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b0<? extends T> f15163a;

    /* renamed from: b, reason: collision with root package name */
    final Iterable<U> f15164b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<? super T, ? super U, ? extends V> f15165c;

    /* compiled from: ObservableZipIterable.java */
    static final class a<T, U, V> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super V> f15166a;

        /* renamed from: b, reason: collision with root package name */
        final Iterator<U> f15167b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.c<? super T, ? super U, ? extends V> f15168c;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15169d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15170e;

        a(g.a.i0<? super V> i0Var, Iterator<U> it, g.a.x0.c<? super T, ? super U, ? extends V> cVar) {
            this.f15166a = i0Var;
            this.f15167b = it;
            this.f15168c = cVar;
        }

        void a(Throwable th) {
            this.f15170e = true;
            this.f15169d.dispose();
            this.f15166a.onError(th);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15169d.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15169d.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15170e) {
                return;
            }
            this.f15170e = true;
            this.f15166a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15170e) {
                g.a.c1.a.b(th);
            } else {
                this.f15170e = true;
                this.f15166a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15170e) {
                return;
            }
            try {
                try {
                    this.f15166a.onNext(g.a.y0.b.b.a(this.f15168c.apply(t, g.a.y0.b.b.a(this.f15167b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f15167b.hasNext()) {
                            return;
                        }
                        this.f15170e = true;
                        this.f15169d.dispose();
                        this.f15166a.onComplete();
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        a(th);
                    }
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    a(th2);
                }
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                a(th3);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15169d, cVar)) {
                this.f15169d = cVar;
                this.f15166a.onSubscribe(this);
            }
        }
    }

    public g4(g.a.b0<? extends T> b0Var, Iterable<U> iterable, g.a.x0.c<? super T, ? super U, ? extends V> cVar) {
        this.f15163a = b0Var;
        this.f15164b = iterable;
        this.f15165c = cVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super V> i0Var) {
        try {
            Iterator it = (Iterator) g.a.y0.b.b.a(this.f15164b.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.f15163a.subscribe(new a(i0Var, it, this.f15165c));
                } else {
                    g.a.y0.a.e.complete(i0Var);
                }
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
