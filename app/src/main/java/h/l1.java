package h;

/* compiled from: UIntArray.kt */
/* loaded from: classes2.dex */
public final class l1 {
    @h.m2.f
    @t0(version = "1.3")
    @k
    private static final int[] a(int i2, h.q2.s.l<? super Integer, j1> lVar) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = lVar.invoke(Integer.valueOf(i3)).a();
        }
        return k1.b(iArr);
    }

    @h.m2.f
    @t0(version = "1.3")
    @k
    private static final int[] a(int... iArr) {
        return iArr;
    }
}
