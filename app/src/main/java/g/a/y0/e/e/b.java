package g.a.y0.e.e;

import g.a.y0.e.b.w;

/* compiled from: ParallelConcatMap.java */
/* loaded from: classes2.dex */
public final class b<T, R> extends g.a.b1.b<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<T> f15627a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends i.d.b<? extends R>> f15628b;

    /* renamed from: c, reason: collision with root package name */
    final int f15629c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.y0.j.j f15630d;

    public b(g.a.b1.b<T> bVar, g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, g.a.y0.j.j jVar) {
        this.f15627a = bVar;
        this.f15628b = (g.a.x0.o) g.a.y0.b.b.a(oVar, "mapper");
        this.f15629c = i2;
        this.f15630d = (g.a.y0.j.j) g.a.y0.b.b.a(jVar, "errorMode");
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15627a.a();
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super R>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super T>[] cVarArr2 = new i.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                cVarArr2[i2] = w.a(cVarArr[i2], this.f15628b, this.f15629c, this.f15630d);
            }
            this.f15627a.a(cVarArr2);
        }
    }
}
