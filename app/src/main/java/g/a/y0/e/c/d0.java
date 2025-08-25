package g.a.y0.e.c;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeFlatMapNotification.java */
/* loaded from: classes2.dex */
public final class d0<T, R> extends g.a.y0.e.c.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.y<? extends R>> f14780b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends g.a.y<? extends R>> f14781c;

    /* renamed from: d, reason: collision with root package name */
    final Callable<? extends g.a.y<? extends R>> f14782d;

    /* compiled from: MaybeFlatMapNotification.java */
    static final class a<T, R> extends AtomicReference<g.a.u0.c> implements g.a.v<T>, g.a.u0.c {
        private static final long serialVersionUID = 4375739915521278546L;
        final g.a.v<? super R> actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f14783d;
        final Callable<? extends g.a.y<? extends R>> onCompleteSupplier;
        final g.a.x0.o<? super Throwable, ? extends g.a.y<? extends R>> onErrorMapper;
        final g.a.x0.o<? super T, ? extends g.a.y<? extends R>> onSuccessMapper;

        /* compiled from: MaybeFlatMapNotification.java */
        /* renamed from: g.a.y0.e.c.d0$a$a, reason: collision with other inner class name */
        final class C0200a implements g.a.v<R> {
            C0200a() {
            }

            @Override // g.a.v
            public void onComplete() {
                a.this.actual.onComplete();
            }

            @Override // g.a.v
            public void onError(Throwable th) {
                a.this.actual.onError(th);
            }

            @Override // g.a.v
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(a.this, cVar);
            }

            @Override // g.a.v, g.a.n0
            public void onSuccess(R r) {
                a.this.actual.onSuccess(r);
            }
        }

        a(g.a.v<? super R> vVar, g.a.x0.o<? super T, ? extends g.a.y<? extends R>> oVar, g.a.x0.o<? super Throwable, ? extends g.a.y<? extends R>> oVar2, Callable<? extends g.a.y<? extends R>> callable) {
            this.actual = vVar;
            this.onSuccessMapper = oVar;
            this.onErrorMapper = oVar2;
            this.onCompleteSupplier = callable;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
            this.f14783d.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.v
        public void onComplete() {
            try {
                ((g.a.y) g.a.y0.b.b.a(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource")).a(new C0200a());
            } catch (Exception e2) {
                g.a.v0.b.b(e2);
                this.actual.onError(e2);
            }
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            try {
                ((g.a.y) g.a.y0.b.b.a(this.onErrorMapper.apply(th), "The onErrorMapper returned a null MaybeSource")).a(new C0200a());
            } catch (Exception e2) {
                g.a.v0.b.b(e2);
                this.actual.onError(new g.a.v0.a(th, e2));
            }
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14783d, cVar)) {
                this.f14783d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            try {
                ((g.a.y) g.a.y0.b.b.a(this.onSuccessMapper.apply(t), "The onSuccessMapper returned a null MaybeSource")).a(new C0200a());
            } catch (Exception e2) {
                g.a.v0.b.b(e2);
                this.actual.onError(e2);
            }
        }
    }

    public d0(g.a.y<T> yVar, g.a.x0.o<? super T, ? extends g.a.y<? extends R>> oVar, g.a.x0.o<? super Throwable, ? extends g.a.y<? extends R>> oVar2, Callable<? extends g.a.y<? extends R>> callable) {
        super(yVar);
        this.f14780b = oVar;
        this.f14781c = oVar2;
        this.f14782d = callable;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super R> vVar) {
        this.f14742a.a(new a(vVar, this.f14780b, this.f14781c, this.f14782d));
    }
}
