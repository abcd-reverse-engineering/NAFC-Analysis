package g.a.y0.e.f;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SingleAmb.java */
/* loaded from: classes2.dex */
public final class a<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    private final g.a.q0<? extends T>[] f15724a;

    /* renamed from: b, reason: collision with root package name */
    private final Iterable<? extends g.a.q0<? extends T>> f15725b;

    /* compiled from: SingleAmb.java */
    /* renamed from: g.a.y0.e.f.a$a, reason: collision with other inner class name */
    static final class C0225a<T> extends AtomicBoolean implements g.a.n0<T> {
        private static final long serialVersionUID = -1944085461036028108L;
        final g.a.n0<? super T> s;
        final g.a.u0.b set;

        C0225a(g.a.n0<? super T> n0Var, g.a.u0.b bVar) {
            this.s = n0Var;
            this.set = bVar;
        }

        @Override // g.a.n0
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                g.a.c1.a.b(th);
            } else {
                this.set.dispose();
                this.s.onError(th);
            }
        }

        @Override // g.a.n0
        public void onSubscribe(g.a.u0.c cVar) {
            this.set.b(cVar);
        }

        @Override // g.a.n0
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onSuccess(t);
            }
        }
    }

    public a(g.a.q0<? extends T>[] q0VarArr, Iterable<? extends g.a.q0<? extends T>> iterable) {
        this.f15724a = q0VarArr;
        this.f15725b = iterable;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        int length;
        g.a.q0<? extends T>[] q0VarArr = this.f15724a;
        if (q0VarArr == null) {
            q0VarArr = new g.a.q0[8];
            try {
                length = 0;
                for (g.a.q0<? extends T> q0Var : this.f15725b) {
                    if (q0Var == null) {
                        g.a.y0.a.e.error(new NullPointerException("One of the sources is null"), n0Var);
                        return;
                    }
                    if (length == q0VarArr.length) {
                        g.a.q0<? extends T>[] q0VarArr2 = new g.a.q0[(length >> 2) + length];
                        System.arraycopy(q0VarArr, 0, q0VarArr2, 0, length);
                        q0VarArr = q0VarArr2;
                    }
                    int i2 = length + 1;
                    q0VarArr[length] = q0Var;
                    length = i2;
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.y0.a.e.error(th, n0Var);
                return;
            }
        } else {
            length = q0VarArr.length;
        }
        g.a.u0.b bVar = new g.a.u0.b();
        C0225a c0225a = new C0225a(n0Var, bVar);
        n0Var.onSubscribe(bVar);
        for (int i3 = 0; i3 < length; i3++) {
            g.a.q0<? extends T> q0Var2 = q0VarArr[i3];
            if (c0225a.get()) {
                return;
            }
            if (q0Var2 == null) {
                bVar.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (c0225a.compareAndSet(false, true)) {
                    n0Var.onError(nullPointerException);
                    return;
                } else {
                    g.a.c1.a.b(nullPointerException);
                    return;
                }
            }
            q0Var2.a(c0225a);
        }
    }
}
