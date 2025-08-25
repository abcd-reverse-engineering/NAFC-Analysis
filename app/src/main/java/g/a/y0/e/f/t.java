package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SingleEquals.java */
/* loaded from: classes2.dex */
public final class t<T> extends g.a.k0<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.q0<? extends T> f15848a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.q0<? extends T> f15849b;

    /* compiled from: SingleEquals.java */
    static class a<T> implements g.a.n0<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f15850a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.u0.b f15851b;

        /* renamed from: c, reason: collision with root package name */
        final Object[] f15852c;

        /* renamed from: d, reason: collision with root package name */
        final g.a.n0<? super Boolean> f15853d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicInteger f15854e;

        a(int i2, g.a.u0.b bVar, Object[] objArr, g.a.n0<? super Boolean> n0Var, AtomicInteger atomicInteger) {
            this.f15850a = i2;
            this.f15851b = bVar;
            this.f15852c = objArr;
            this.f15853d = n0Var;
            this.f15854e = atomicInteger;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            int i2;
            do {
                i2 = this.f15854e.get();
                if (i2 >= 2) {
                    g.a.c1.a.b(th);
                    return;
                }
            } while (!this.f15854e.compareAndSet(i2, 2));
            this.f15851b.dispose();
            this.f15853d.onError(th);
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            this.f15851b.b(cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            this.f15852c[this.f15850a] = t;
            if (this.f15854e.incrementAndGet() == 2) {
                g.a.n0<? super Boolean> n0Var = this.f15853d;
                Object[] objArr = this.f15852c;
                n0Var.onSuccess(Boolean.valueOf(g.a.y0.b.b.a(objArr[0], objArr[1])));
            }
        }
    }

    public t(g.a.q0<? extends T> q0Var, g.a.q0<? extends T> q0Var2) {
        this.f15848a = q0Var;
        this.f15849b = q0Var2;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super Boolean> n0Var) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        g.a.u0.b bVar = new g.a.u0.b();
        n0Var.onSubscribe(bVar);
        this.f15848a.a(new a(0, bVar, objArr, n0Var, atomicInteger));
        this.f15849b.a(new a(1, bVar, objArr, n0Var, atomicInteger));
    }
}
