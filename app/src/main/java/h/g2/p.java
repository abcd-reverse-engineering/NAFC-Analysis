package h.g2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* compiled from: Arrays.kt */
/* loaded from: classes2.dex */
class p extends o {
    @i.c.a.d
    public static final <T, R> h.i0<List<T>, List<R>> a(@i.c.a.d h.i0<? extends T, ? extends R>[] i0VarArr) {
        h.q2.t.i0.f(i0VarArr, "$this$unzip");
        ArrayList arrayList = new ArrayList(i0VarArr.length);
        ArrayList arrayList2 = new ArrayList(i0VarArr.length);
        for (h.i0<? extends T, ? extends R> i0Var : i0VarArr) {
            arrayList.add(i0Var.getFirst());
            arrayList2.add(i0Var.getSecond());
        }
        return h.c1.a(arrayList, arrayList2);
    }

    @h.q2.e(name = "contentDeepToString")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static final <T> String c(@i.c.a.d T[] tArr) {
        h.q2.t.i0.f(tArr, "$this$contentDeepToStringImpl");
        StringBuilder sb = new StringBuilder((h.v2.q.b(tArr.length, 429496729) * 5) + 2);
        a(tArr, sb, new ArrayList());
        String string = sb.toString();
        h.q2.t.i0.a((Object) string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @h.m2.f
    @h.t0(version = "1.3")
    private static final boolean d(@i.c.a.e Object[] objArr) {
        if (objArr != null) {
            if (!(objArr.length == 0)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lh/q2/s/a<+TR;>;)TR; */
    @h.m2.f
    @h.t0(version = "1.3")
    private static final Object a(Object[] objArr, h.q2.s.a aVar) {
        return objArr.length == 0 ? aVar.invoke() : objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.q2.e(name = "contentDeepEquals")
    @h.t0(version = "1.3")
    @h.n0
    public static final <T> boolean a(@i.c.a.d T[] tArr, @i.c.a.d T[] tArr2) {
        h.q2.t.i0.f(tArr, "$this$contentDeepEqualsImpl");
        h.q2.t.i0.f(tArr2, DispatchConstants.OTHER);
        if (tArr == tArr2) {
            return true;
        }
        if (tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object[] objArr = tArr[i2];
            Object[] objArr2 = tArr2[i2];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!a(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof h.g1) && (objArr2 instanceof h.g1)) {
                    if (!h.g2.a2.c.a(((h.g1) objArr).c(), ((h.g1) objArr2).c())) {
                        return false;
                    }
                } else if ((objArr instanceof h.u1) && (objArr2 instanceof h.u1)) {
                    if (!h.g2.a2.c.a(((h.u1) objArr).c(), ((h.u1) objArr2).c())) {
                        return false;
                    }
                } else if ((objArr instanceof h.k1) && (objArr2 instanceof h.k1)) {
                    if (!h.g2.a2.c.a(((h.k1) objArr).c(), ((h.k1) objArr2).c())) {
                        return false;
                    }
                } else if ((objArr instanceof h.o1) && (objArr2 instanceof h.o1)) {
                    if (!h.g2.a2.c.a(((h.o1) objArr).c(), ((h.o1) objArr2).c())) {
                        return false;
                    }
                } else if (!h.q2.t.i0.a(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void a(@i.c.a.d T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(", ");
            }
            Object[] objArr = tArr[i2];
            if (objArr == 0) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else if (objArr instanceof Object[]) {
                a(objArr, sb, list);
            } else if (objArr instanceof byte[]) {
                String string = Arrays.toString((byte[]) objArr);
                h.q2.t.i0.a((Object) string, "java.util.Arrays.toString(this)");
                sb.append(string);
            } else if (objArr instanceof short[]) {
                String string2 = Arrays.toString((short[]) objArr);
                h.q2.t.i0.a((Object) string2, "java.util.Arrays.toString(this)");
                sb.append(string2);
            } else if (objArr instanceof int[]) {
                String string3 = Arrays.toString((int[]) objArr);
                h.q2.t.i0.a((Object) string3, "java.util.Arrays.toString(this)");
                sb.append(string3);
            } else if (objArr instanceof long[]) {
                String string4 = Arrays.toString((long[]) objArr);
                h.q2.t.i0.a((Object) string4, "java.util.Arrays.toString(this)");
                sb.append(string4);
            } else if (objArr instanceof float[]) {
                String string5 = Arrays.toString((float[]) objArr);
                h.q2.t.i0.a((Object) string5, "java.util.Arrays.toString(this)");
                sb.append(string5);
            } else if (objArr instanceof double[]) {
                String string6 = Arrays.toString((double[]) objArr);
                h.q2.t.i0.a((Object) string6, "java.util.Arrays.toString(this)");
                sb.append(string6);
            } else if (objArr instanceof char[]) {
                String string7 = Arrays.toString((char[]) objArr);
                h.q2.t.i0.a((Object) string7, "java.util.Arrays.toString(this)");
                sb.append(string7);
            } else if (objArr instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) objArr);
                h.q2.t.i0.a((Object) string8, "java.util.Arrays.toString(this)");
                sb.append(string8);
            } else if (objArr instanceof h.g1) {
                sb.append(h.g2.a2.c.k(((h.g1) objArr).c()));
            } else if (objArr instanceof h.u1) {
                sb.append(h.g2.a2.c.k(((h.u1) objArr).c()));
            } else if (objArr instanceof h.k1) {
                sb.append(h.g2.a2.c.k(((h.k1) objArr).c()));
            } else if (objArr instanceof h.o1) {
                sb.append(h.g2.a2.c.k(((h.o1) objArr).c()));
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(y.a((List) list));
    }

    @i.c.a.d
    public static final <T> List<T> a(@i.c.a.d T[][] tArr) {
        h.q2.t.i0.f(tArr, "$this$flatten");
        int length = 0;
        for (T[] tArr2 : tArr) {
            length += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(length);
        for (T[] tArr3 : tArr) {
            d0.a((Collection) arrayList, (Object[]) tArr3);
        }
        return arrayList;
    }
}
