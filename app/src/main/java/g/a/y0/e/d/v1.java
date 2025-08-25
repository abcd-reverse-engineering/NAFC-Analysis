package g.a.y0.e.d;

import java.util.concurrent.Callable;

/* compiled from: ObservableMapNotification.java */
/* loaded from: classes2.dex */
public final class v1<T, R> extends g.a.y0.e.d.a<T, g.a.g0<? extends R>> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> f15525b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends g.a.g0<? extends R>> f15526c;

    /* renamed from: d, reason: collision with root package name */
    final Callable<? extends g.a.g0<? extends R>> f15527d;

    /* compiled from: ObservableMapNotification.java */
    static final class a<T, R> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super g.a.g0<? extends R>> f15528a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> f15529b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.o<? super Throwable, ? extends g.a.g0<? extends R>> f15530c;

        /* renamed from: d, reason: collision with root package name */
        final Callable<? extends g.a.g0<? extends R>> f15531d;

        /* renamed from: e, reason: collision with root package name */
        g.a.u0.c f15532e;

        a(g.a.i0<? super g.a.g0<? extends R>> i0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> oVar, g.a.x0.o<? super Throwable, ? extends g.a.g0<? extends R>> oVar2, Callable<? extends g.a.g0<? extends R>> callable) {
            this.f15528a = i0Var;
            this.f15529b = oVar;
            this.f15530c = oVar2;
            this.f15531d = callable;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15532e.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15532e.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            try {
                this.f15528a.onNext((g.a.g0) g.a.y0.b.b.a(this.f15531d.call(), "The onComplete ObservableSource returned is null"));
                this.f15528a.onComplete();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15528a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            try {
                this.f15528a.onNext((g.a.g0) g.a.y0.b.b.a(this.f15530c.apply(th), "The onError ObservableSource returned is null"));
                this.f15528a.onComplete();
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f15528a.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            try {
                this.f15528a.onNext((g.a.g0) g.a.y0.b.b.a(this.f15529b.apply(t), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15528a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15532e, cVar)) {
                this.f15532e = cVar;
                this.f15528a.onSubscribe(this);
            }
        }
    }

    public v1(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends R>> oVar, g.a.x0.o<? super Throwable, ? extends g.a.g0<? extends R>> oVar2, Callable<? extends g.a.g0<? extends R>> callable) {
        super(g0Var);
        this.f15525b = oVar;
        this.f15526c = oVar2;
        this.f15527d = callable;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super g.a.g0<? extends R>> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15525b, this.f15526c, this.f15527d));
    }
}
