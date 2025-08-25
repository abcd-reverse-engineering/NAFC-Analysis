package h.g2;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;

/* compiled from: ArraysJVM.kt */
/* loaded from: classes2.dex */
class o {
    @h.m2.f
    private static final String a(@i.c.a.d byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @i.c.a.d
    public static final /* synthetic */ <T> T[] b(@i.c.a.e T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        h.q2.t.i0.a(0, "T?");
        return (T[]) new Object[0];
    }

    @i.c.a.d
    public static final /* synthetic */ <T> T[] a(@i.c.a.d Collection<? extends T> collection) {
        h.q2.t.i0.f(collection, "$this$toTypedArray");
        h.q2.t.i0.a(0, "T?");
        T[] tArr = (T[]) collection.toArray(new Object[0]);
        if (tArr != null) {
            return tArr;
        }
        throw new h.e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @i.c.a.d
    public static final <T> T[] a(@i.c.a.d T[] tArr, int i2) throws NegativeArraySizeException {
        h.q2.t.i0.f(tArr, "reference");
        Object objNewInstance = Array.newInstance(tArr.getClass().getComponentType(), i2);
        if (objNewInstance != null) {
            return (T[]) ((Object[]) objNewInstance);
        }
        throw new h.e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @h.t0(version = "1.3")
    public static final void a(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }

    @h.q2.e(name = "contentDeepHashCode")
    @h.t0(version = "1.3")
    @h.n0
    public static final <T> int a(@i.c.a.d T[] tArr) {
        h.q2.t.i0.f(tArr, "$this$contentDeepHashCodeImpl");
        return Arrays.deepHashCode(tArr);
    }
}
