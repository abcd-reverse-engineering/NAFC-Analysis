package g.a.y0.e.b;

import java.util.Iterator;

/* compiled from: FlowableZipIterable.java */
/* loaded from: classes2.dex */
public final class t4<T, U, V> extends g.a.y0.e.b.a<T, V> {

    /* renamed from: c, reason: collision with root package name */
    final Iterable<U> f14635c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.c<? super T, ? super U, ? extends V> f14636d;

    /* compiled from: FlowableZipIterable.java */
    static final class a<T, U, V> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super V> f14637a;

        /* renamed from: b, reason: collision with root package name */
        final Iterator<U> f14638b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.c<? super T, ? super U, ? extends V> f14639c;

        /* renamed from: d, reason: collision with root package name */
        i.d.d f14640d;

        /* renamed from: e, reason: collision with root package name */
        boolean f14641e;

        a(i.d.c<? super V> cVar, Iterator<U> it, g.a.x0.c<? super T, ? super U, ? extends V> cVar2) {
            this.f14637a = cVar;
            this.f14638b = it;
            this.f14639c = cVar2;
        }

        void a(Throwable th) {
            g.a.v0.b.b(th);
            this.f14641e = true;
            this.f14640d.cancel();
            this.f14637a.onError(th);
        }

        @Override // i.d.d
        public void cancel() {
            this.f14640d.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14641e) {
                return;
            }
            this.f14641e = true;
            this.f14637a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14641e) {
                g.a.c1.a.b(th);
            } else {
                this.f14641e = true;
                this.f14637a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14641e) {
                return;
            }
            try {
                try {
                    this.f14637a.onNext(g.a.y0.b.b.a(this.f14639c.apply(t, g.a.y0.b.b.a(this.f14638b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f14638b.hasNext()) {
                            return;
                        }
                        this.f14641e = true;
                        this.f14640d.cancel();
                        this.f14637a.onComplete();
                    } catch (Throwable th) {
                        a(th);
                    }
                } catch (Throwable th2) {
                    a(th2);
                }
            } catch (Throwable th3) {
                a(th3);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14640d, dVar)) {
                this.f14640d = dVar;
                this.f14637a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14640d.request(j2);
        }
    }

    public t4(g.a.l<T> lVar, Iterable<U> iterable, g.a.x0.c<? super T, ? super U, ? extends V> cVar) {
        super(lVar);
        this.f14635c = iterable;
        this.f14636d = cVar;
    }

    @Override // g.a.l
    public void d(i.d.c<? super V> cVar) {
        try {
            Iterator it = (Iterator) g.a.y0.b.b.a(this.f14635c.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.f14110b.a((g.a.q) new a(cVar, it, this.f14636d));
                } else {
                    g.a.y0.i.g.complete(cVar);
                }
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
