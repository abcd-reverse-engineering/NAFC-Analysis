package g.a.y0.e.e;

/* compiled from: ParallelFromArray.java */
/* loaded from: classes2.dex */
public final class g<T> extends g.a.b1.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<T>[] f15667a;

    public g(i.d.b<T>[] bVarArr) {
        this.f15667a = bVarArr;
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15667a.length;
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f15667a[i2].subscribe(cVarArr[i2]);
            }
        }
    }
}
