package g.a.y0.e.c;

import g.a.y0.e.c.r1;
import g.a.y0.e.c.u0;
import java.util.Arrays;

/* compiled from: MaybeZipIterable.java */
/* loaded from: classes2.dex */
public final class s1<T, R> extends g.a.s<R> {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends g.a.y<? extends T>> f14896a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Object[], ? extends R> f14897b;

    /* compiled from: MaybeZipIterable.java */
    final class a implements g.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // g.a.x0.o
        public R apply(T t) throws Exception {
            return (R) g.a.y0.b.b.a(s1.this.f14897b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public s1(Iterable<? extends g.a.y<? extends T>> iterable, g.a.x0.o<? super Object[], ? extends R> oVar) {
        this.f14896a = iterable;
        this.f14897b = oVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super R> vVar) {
        g.a.y[] yVarArr = new g.a.y[8];
        try {
            g.a.y[] yVarArr2 = yVarArr;
            int i2 = 0;
            for (g.a.y<? extends T> yVar : this.f14896a) {
                if (yVar == null) {
                    g.a.y0.a.e.error(new NullPointerException("One of the sources is null"), vVar);
                    return;
                }
                if (i2 == yVarArr2.length) {
                    yVarArr2 = (g.a.y[]) Arrays.copyOf(yVarArr2, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                yVarArr2[i2] = yVar;
                i2 = i3;
            }
            if (i2 == 0) {
                g.a.y0.a.e.complete(vVar);
                return;
            }
            if (i2 == 1) {
                yVarArr2[0].a(new u0.a(vVar, new a()));
                return;
            }
            r1.b bVar = new r1.b(vVar, i2, this.f14897b);
            vVar.onSubscribe(bVar);
            for (int i4 = 0; i4 < i2 && !bVar.isDisposed(); i4++) {
                yVarArr2[i4].a(bVar.observers[i4]);
            }
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.a.e.error(th, vVar);
        }
    }
}
