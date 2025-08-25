package h.g2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
/* loaded from: classes2.dex */
public class x {
    @i.c.a.d
    public static <T> List<T> a(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        h.q2.t.i0.a((Object) listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    @h.m2.f
    @h.t0(version = "1.3")
    @h.n0
    private static final int b(int i2) {
        if (i2 < 0) {
            if (!h.m2.l.a(1, 3, 0)) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            y.f();
        }
        return i2;
    }

    @h.m2.f
    private static final <T> List<T> a(@i.c.a.d Enumeration<T> enumeration) {
        ArrayList list = Collections.list(enumeration);
        h.q2.t.i0.a((Object) list, "java.util.Collections.list(this)");
        return list;
    }

    @h.m2.f
    private static final Object[] a(Collection<?> collection) {
        return h.q2.t.u.a(collection);
    }

    @h.m2.f
    private static final <T> T[] a(Collection<?> collection, T[] tArr) {
        if (tArr == null) {
            throw new h.e1("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        T[] tArr2 = (T[]) h.q2.t.u.a(collection, tArr);
        if (tArr2 != null) {
            return tArr2;
        }
        throw new h.e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @i.c.a.d
    public static final <T> Object[] a(@i.c.a.d T[] tArr, boolean z) {
        h.q2.t.i0.f(tArr, "$this$copyToArrayOfAny");
        if (z && h.q2.t.i0.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        h.q2.t.i0.a((Object) objArrCopyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    @h.m2.f
    @h.t0(version = "1.3")
    @h.n0
    private static final int a(int i2) {
        if (i2 < 0) {
            if (h.m2.l.a(1, 3, 0)) {
                y.e();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i2;
    }
}
