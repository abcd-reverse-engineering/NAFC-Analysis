package h.q2.t;

import java.util.NoSuchElementException;

/* compiled from: ArrayIterators.kt */
/* loaded from: classes2.dex */
final class c extends h.g2.v {

    /* renamed from: a, reason: collision with root package name */
    private int f16374a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f16375b;

    public c(@i.c.a.d char[] cArr) {
        i0.f(cArr, "array");
        this.f16375b = cArr;
    }

    @Override // h.g2.v
    public char b() {
        try {
            char[] cArr = this.f16375b;
            int i2 = this.f16374a;
            this.f16374a = i2 + 1;
            return cArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f16374a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16374a < this.f16375b.length;
    }
}
