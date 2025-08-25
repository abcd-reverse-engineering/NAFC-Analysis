package c.b.c.f0.c;

/* compiled from: ErrorCorrectionLevel.java */
/* loaded from: classes.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: a, reason: collision with root package name */
    private static final f[] f2754a;
    private final int bits;

    static {
        f fVar = L;
        f fVar2 = M;
        f fVar3 = Q;
        f2754a = new f[]{fVar2, fVar, H, fVar3};
    }

    f(int i2) {
        this.bits = i2;
    }

    public static f forBits(int i2) {
        if (i2 >= 0) {
            f[] fVarArr = f2754a;
            if (i2 < fVarArr.length) {
                return fVarArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }

    public int getBits() {
        return this.bits;
    }
}
