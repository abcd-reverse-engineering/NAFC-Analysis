package g.a.y0.h;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LambdaSubscriber.java */
/* loaded from: classes2.dex */
public final class l<T> extends AtomicReference<i.d.d> implements g.a.q<T>, i.d.d, g.a.u0.c, g.a.a1.g {
    private static final long serialVersionUID = -7251123623727029452L;
    final g.a.x0.a onComplete;
    final g.a.x0.g<? super Throwable> onError;
    final g.a.x0.g<? super T> onNext;
    final g.a.x0.g<? super i.d.d> onSubscribe;

    public l(g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.g<? super i.d.d> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    @Override // i.d.d
    public void cancel() {
        g.a.y0.i.j.cancel(this);
    }

    @Override // g.a.u0.c
    public void dispose() {
        cancel();
    }

    @Override // g.a.a1.g
    public boolean hasCustomOnError() {
        return this.onError != g.a.y0.b.a.f13902f;
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return get() == g.a.y0.i.j.CANCELLED;
    }

    @Override // i.d.c
    public void onComplete() {
        i.d.d dVar = get();
        g.a.y0.i.j jVar = g.a.y0.i.j.CANCELLED;
        if (dVar != jVar) {
            lazySet(jVar);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
        }
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        i.d.d dVar = get();
        g.a.y0.i.j jVar = g.a.y0.i.j.CANCELLED;
        if (dVar == jVar) {
            g.a.c1.a.b(th);
            return;
        }
        lazySet(jVar);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.c1.a.b(new g.a.v0.a(th, th2));
        }
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (g.a.y0.i.j.setOnce(this, dVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                dVar.cancel();
                onError(th);
            }
        }
    }

    @Override // i.d.d
    public void request(long j2) {
        get().request(j2);
    }
}
