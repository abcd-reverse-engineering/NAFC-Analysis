package g.a.y0.e.e;

import g.a.y0.e.b.w0;

/* compiled from: ParallelFlatMap.java */
/* loaded from: classes2.dex */
public final class f<T, R> extends g.a.b1.b<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<T> f15662a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends i.d.b<? extends R>> f15663b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f15664c;

    /* renamed from: d, reason: collision with root package name */
    final int f15665d;

    /* renamed from: e, reason: collision with root package name */
    final int f15666e;

    public f(g.a.b1.b<T> bVar, g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, boolean z, int i2, int i3) {
        this.f15662a = bVar;
        this.f15663b = oVar;
        this.f15664c = z;
        this.f15665d = i2;
        this.f15666e = i3;
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15662a.a();
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super R>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super T>[] cVarArr2 = new i.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                cVarArr2[i2] = w0.a(cVarArr[i2], this.f15663b, this.f15664c, this.f15665d, this.f15666e);
            }
            this.f15662a.a(cVarArr2);
        }
    }
}
