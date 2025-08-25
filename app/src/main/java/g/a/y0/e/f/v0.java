package g.a.y0.e.f;

import g.a.y0.e.f.h0;
import g.a.y0.e.f.u0;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* compiled from: SingleZipIterable.java */
/* loaded from: classes2.dex */
public final class v0<T, R> extends g.a.k0<R> {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends g.a.q0<? extends T>> f15868a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Object[], ? extends R> f15869b;

    /* compiled from: SingleZipIterable.java */
    final class a implements g.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // g.a.x0.o
        public R apply(T t) throws Exception {
            return (R) g.a.y0.b.b.a(v0.this.f15869b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public v0(Iterable<? extends g.a.q0<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar) {
        this.f15868a = iterable;
        this.f15869b = oVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super R> n0Var) {
        g.a.q0[] q0VarArr = new g.a.q0[8];
        try {
            g.a.q0[] q0VarArr2 = q0VarArr;
            int i2 = 0;
            for (g.a.q0<? extends T> q0Var : this.f15868a) {
                if (q0Var == null) {
                    g.a.y0.a.e.error(new NullPointerException("One of the sources is null"), n0Var);
                    return;
                }
                if (i2 == q0VarArr2.length) {
                    q0VarArr2 = (g.a.q0[]) Arrays.copyOf(q0VarArr2, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                q0VarArr2[i2] = q0Var;
                i2 = i3;
            }
            if (i2 == 0) {
                g.a.y0.a.e.error(new NoSuchElementException(), n0Var);
                return;
            }
            if (i2 == 1) {
                q0VarArr2[0].a(new h0.a(n0Var, new a()));
                return;
            }
            u0.b bVar = new u0.b(n0Var, i2, this.f15869b);
            n0Var.onSubscribe(bVar);
            for (int i4 = 0; i4 < i2 && !bVar.isDisposed(); i4++) {
                q0VarArr2[i4].a(bVar.observers[i4]);
            }
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, n0Var);
        }
    }
}
