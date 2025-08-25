package h.g2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* compiled from: UArraysKt.kt */
@h.c(level = h.d.HIDDEN, message = "Provided for binary compatibility")
/* loaded from: classes2.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    public static final t1 f16197a = new t1();

    private t1() {
    }

    @h.k
    @h.q2.h
    public static final int a(@i.c.a.d int[] iArr, @i.c.a.d h.u2.f fVar) {
        h.q2.t.i0.f(iArr, "$this$random");
        h.q2.t.i0.f(fVar, "random");
        if (h.k1.e(iArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return h.k1.b(iArr, fVar.c(h.k1.c(iArr)));
    }

    @h.k
    @h.q2.h
    @i.c.a.d
    public static final String b(@i.c.a.d int[] iArr) {
        h.q2.t.i0.f(iArr, "$this$contentToString");
        return g0.a(h.k1.a(iArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @h.k
    @h.q2.h
    @i.c.a.d
    public static final h.j1[] c(@i.c.a.d int[] iArr) {
        h.q2.t.i0.f(iArr, "$this$toTypedArray");
        int iC = h.k1.c(iArr);
        h.j1[] j1VarArr = new h.j1[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            j1VarArr[i2] = h.j1.a(h.k1.b(iArr, i2));
        }
        return j1VarArr;
    }

    @h.k
    @h.q2.h
    @i.c.a.d
    public static final String b(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "$this$contentToString");
        return g0.a(h.o1.a(jArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @h.k
    @h.q2.h
    @i.c.a.d
    public static final h.n1[] c(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "$this$toTypedArray");
        int iC = h.o1.c(jArr);
        h.n1[] n1VarArr = new h.n1[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            n1VarArr[i2] = h.n1.a(h.o1.a(jArr, i2));
        }
        return n1VarArr;
    }

    @h.k
    @h.q2.h
    @i.c.a.d
    public static final String b(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "$this$contentToString");
        return g0.a(h.g1.a(bArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @h.k
    @h.q2.h
    @i.c.a.d
    public static final h.f1[] c(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "$this$toTypedArray");
        int iC = h.g1.c(bArr);
        h.f1[] f1VarArr = new h.f1[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            f1VarArr[i2] = h.f1.a(h.g1.a(bArr, i2));
        }
        return f1VarArr;
    }

    @h.k
    @h.q2.h
    public static final long a(@i.c.a.d long[] jArr, @i.c.a.d h.u2.f fVar) {
        h.q2.t.i0.f(jArr, "$this$random");
        h.q2.t.i0.f(fVar, "random");
        if (!h.o1.e(jArr)) {
            return h.o1.a(jArr, fVar.c(h.o1.c(jArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @h.k
    @h.q2.h
    @i.c.a.d
    public static final String b(@i.c.a.d short[] sArr) {
        h.q2.t.i0.f(sArr, "$this$contentToString");
        return g0.a(h.u1.a(sArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @h.k
    @h.q2.h
    @i.c.a.d
    public static final h.t1[] c(@i.c.a.d short[] sArr) {
        h.q2.t.i0.f(sArr, "$this$toTypedArray");
        int iC = h.u1.c(sArr);
        h.t1[] t1VarArr = new h.t1[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            t1VarArr[i2] = h.t1.a(h.u1.a(sArr, i2));
        }
        return t1VarArr;
    }

    @h.k
    @h.q2.h
    public static final byte a(@i.c.a.d byte[] bArr, @i.c.a.d h.u2.f fVar) {
        h.q2.t.i0.f(bArr, "$this$random");
        h.q2.t.i0.f(fVar, "random");
        if (!h.g1.e(bArr)) {
            return h.g1.a(bArr, fVar.c(h.g1.c(bArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @h.k
    @h.q2.h
    public static final short a(@i.c.a.d short[] sArr, @i.c.a.d h.u2.f fVar) {
        h.q2.t.i0.f(sArr, "$this$random");
        h.q2.t.i0.f(fVar, "random");
        if (!h.u1.e(sArr)) {
            return h.u1.a(sArr, fVar.c(h.u1.c(sArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @h.k
    @h.q2.h
    public static final boolean a(@i.c.a.d int[] iArr, @i.c.a.d int[] iArr2) {
        h.q2.t.i0.f(iArr, "$this$contentEquals");
        h.q2.t.i0.f(iArr2, DispatchConstants.OTHER);
        return Arrays.equals(iArr, iArr2);
    }

    @h.k
    @h.q2.h
    public static final boolean a(@i.c.a.d long[] jArr, @i.c.a.d long[] jArr2) {
        h.q2.t.i0.f(jArr, "$this$contentEquals");
        h.q2.t.i0.f(jArr2, DispatchConstants.OTHER);
        return Arrays.equals(jArr, jArr2);
    }

    @h.k
    @h.q2.h
    public static final boolean a(@i.c.a.d byte[] bArr, @i.c.a.d byte[] bArr2) {
        h.q2.t.i0.f(bArr, "$this$contentEquals");
        h.q2.t.i0.f(bArr2, DispatchConstants.OTHER);
        return Arrays.equals(bArr, bArr2);
    }

    @h.k
    @h.q2.h
    public static final boolean a(@i.c.a.d short[] sArr, @i.c.a.d short[] sArr2) {
        h.q2.t.i0.f(sArr, "$this$contentEquals");
        h.q2.t.i0.f(sArr2, DispatchConstants.OTHER);
        return Arrays.equals(sArr, sArr2);
    }

    @h.k
    @h.q2.h
    public static final int a(@i.c.a.d int[] iArr) {
        h.q2.t.i0.f(iArr, "$this$contentHashCode");
        return Arrays.hashCode(iArr);
    }

    @h.k
    @h.q2.h
    public static final int a(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "$this$contentHashCode");
        return Arrays.hashCode(jArr);
    }

    @h.k
    @h.q2.h
    public static final int a(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "$this$contentHashCode");
        return Arrays.hashCode(bArr);
    }

    @h.k
    @h.q2.h
    public static final int a(@i.c.a.d short[] sArr) {
        h.q2.t.i0.f(sArr, "$this$contentHashCode");
        return Arrays.hashCode(sArr);
    }
}
