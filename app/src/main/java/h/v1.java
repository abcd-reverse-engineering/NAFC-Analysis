package h;

/* compiled from: UShortArray.kt */
/* loaded from: classes2.dex */
public final class v1 {
    @h.m2.f
    @t0(version = "1.3")
    @k
    private static final short[] a(int i2, h.q2.s.l<? super Integer, t1> lVar) {
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr[i3] = lVar.invoke(Integer.valueOf(i3)).a();
        }
        return u1.b(sArr);
    }

    @h.m2.f
    @t0(version = "1.3")
    @k
    private static final short[] a(short... sArr) {
        return sArr;
    }
}
