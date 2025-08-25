package g.a.y0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableMapNotification.java */
/* loaded from: classes2.dex */
public final class z1<T, R> extends g.a.y0.e.b.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends R> f14736c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends R> f14737d;

    /* renamed from: e, reason: collision with root package name */
    final Callable<? extends R> f14738e;

    /* compiled from: FlowableMapNotification.java */
    static final class a<T, R> extends g.a.y0.h.s<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final Callable<? extends R> onCompleteSupplier;
        final g.a.x0.o<? super Throwable, ? extends R> onErrorMapper;
        final g.a.x0.o<? super T, ? extends R> onNextMapper;

        a(i.d.c<? super R> cVar, g.a.x0.o<? super T, ? extends R> oVar, g.a.x0.o<? super Throwable, ? extends R> oVar2, Callable<? extends R> callable) {
            super(cVar);
            this.onNextMapper = oVar;
            this.onErrorMapper = oVar2;
            this.onCompleteSupplier = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.d.c
        public void onComplete() {
            try {
                complete(g.a.y0.b.b.a(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.actual.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.d.c
        public void onError(Throwable th) {
            try {
                complete(g.a.y0.b.b.a(this.onErrorMapper.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.actual.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            try {
                Object objA = g.a.y0.b.b.a(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.actual.onNext(objA);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.actual.onError(th);
            }
        }
    }

    public z1(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends R> oVar, g.a.x0.o<? super Throwable, ? extends R> oVar2, Callable<? extends R> callable) {
        super(lVar);
        this.f14736c = oVar;
        this.f14737d = oVar2;
        this.f14738e = callable;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14736c, this.f14737d, this.f14738e));
    }
}
