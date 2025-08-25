package g.a.y0.j;

/* compiled from: OpenHashSet.java */
/* loaded from: classes2.dex */
public final class s<T> {

    /* renamed from: f, reason: collision with root package name */
    private static final int f16058f = -1640531527;

    /* renamed from: a, reason: collision with root package name */
    final float f16059a;

    /* renamed from: b, reason: collision with root package name */
    int f16060b;

    /* renamed from: c, reason: collision with root package name */
    int f16061c;

    /* renamed from: d, reason: collision with root package name */
    int f16062d;

    /* renamed from: e, reason: collision with root package name */
    T[] f16063e;

    public s() {
        this(16, 0.75f);
    }

    static int a(int i2) {
        int i3 = i2 * f16058f;
        return i3 ^ (i3 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f16063e;
        int i2 = this.f16060b;
        int iA = a(t.hashCode()) & i2;
        T t3 = tArr[iA];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                iA = (iA + 1) & i2;
                t2 = tArr[iA];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[iA] = t;
        int i3 = this.f16061c + 1;
        this.f16061c = i3;
        if (i3 >= this.f16062d) {
            b();
        }
        return true;
    }

    public boolean b(T t) {
        T t2;
        T[] tArr = this.f16063e;
        int i2 = this.f16060b;
        int iA = a(t.hashCode()) & i2;
        T t3 = tArr[iA];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(iA, tArr, i2);
        }
        do {
            iA = (iA + 1) & i2;
            t2 = tArr[iA];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(iA, tArr, i2);
    }

    public int c() {
        return this.f16061c;
    }

    public s(int i2) {
        this(i2, 0.75f);
    }

    public s(int i2, float f2) {
        this.f16059a = f2;
        int iB = t.b(i2);
        this.f16060b = iB - 1;
        this.f16062d = (int) (f2 * iB);
        this.f16063e = (T[]) new Object[iB];
    }

    void b() {
        T[] tArr = this.f16063e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = (T[]) new Object[i2];
        int i4 = this.f16061c;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int iA = a(tArr[length].hashCode()) & i3;
                if (tArr2[iA] != null) {
                    do {
                        iA = (iA + 1) & i3;
                    } while (tArr2[iA] != null);
                }
                tArr2[iA] = tArr[length];
                i4 = i5;
            } else {
                this.f16060b = i3;
                this.f16062d = (int) (i2 * this.f16059a);
                this.f16063e = tArr2;
                return;
            }
        }
    }

    boolean a(int i2, T[] tArr, int i3) {
        int i4;
        T t;
        this.f16061c--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t = tArr[i4];
                if (t == null) {
                    tArr[i2] = null;
                    return true;
                }
                int iA = a(t.hashCode()) & i3;
                if (i2 <= i4) {
                    if (i2 >= iA || iA > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else if (i2 < iA || iA <= i4) {
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t;
            i2 = i4;
        }
    }

    public Object[] a() {
        return this.f16063e;
    }
}
