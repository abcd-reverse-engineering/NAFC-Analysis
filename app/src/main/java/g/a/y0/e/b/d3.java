package g.a.y0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableScalarXMap.java */
/* loaded from: classes2.dex */
public final class d3 {

    /* compiled from: FlowableScalarXMap.java */
    static final class a<T, R> extends g.a.l<R> {

        /* renamed from: b, reason: collision with root package name */
        final T f14174b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends i.d.b<? extends R>> f14175c;

        a(T t, g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar) {
            this.f14174b = t;
            this.f14175c = oVar;
        }

        @Override // g.a.l
        public void d(i.d.c<? super R> cVar) {
            try {
                i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.f14175c.apply(this.f14174b), "The mapper returned a null Publisher");
                if (!(bVar instanceof Callable)) {
                    bVar.subscribe(cVar);
                    return;
                }
                try {
                    Object objCall = ((Callable) bVar).call();
                    if (objCall == null) {
                        g.a.y0.i.g.complete(cVar);
                    } else {
                        cVar.onSubscribe(new g.a.y0.i.h(cVar, objCall));
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.y0.i.g.error(th, cVar);
                }
            } catch (Throwable th2) {
                g.a.y0.i.g.error(th2, cVar);
            }
        }
    }

    private d3() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean a(i.d.b<T> bVar, i.d.c<? super R> cVar, g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar) {
        if (!(bVar instanceof Callable)) {
            return false;
        }
        try {
            a.a.a aVar = (Object) ((Callable) bVar).call();
            if (aVar == null) {
                g.a.y0.i.g.complete(cVar);
                return true;
            }
            try {
                i.d.b bVar2 = (i.d.b) g.a.y0.b.b.a(oVar.apply(aVar), "The mapper returned a null Publisher");
                if (bVar2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) bVar2).call();
                        if (objCall == null) {
                            g.a.y0.i.g.complete(cVar);
                            return true;
                        }
                        cVar.onSubscribe(new g.a.y0.i.h(cVar, objCall));
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        g.a.y0.i.g.error(th, cVar);
                        return true;
                    }
                } else {
                    bVar2.subscribe(cVar);
                }
                return true;
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                g.a.y0.i.g.error(th2, cVar);
                return true;
            }
        } catch (Throwable th3) {
            g.a.v0.b.b(th3);
            g.a.y0.i.g.error(th3, cVar);
            return true;
        }
    }

    public static <T, U> g.a.l<U> a(T t, g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar) {
        return g.a.c1.a.a(new a(t, oVar));
    }
}
