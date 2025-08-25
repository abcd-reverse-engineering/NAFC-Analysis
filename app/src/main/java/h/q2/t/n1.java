package h.q2.t;

import h.q2.t.q1.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* compiled from: TypeIntrinsics.java */
/* loaded from: classes2.dex */
public class n1 {
    private static <T extends Throwable> T a(T t) {
        return (T) i0.a((Throwable) t, n1.class.getName());
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.c)) {
            i(obj, "kotlin.collections.MutableIterable");
        }
        return j(obj);
    }

    public static Iterator c(Object obj) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.d)) {
            i(obj, "kotlin.collections.MutableIterator");
        }
        return k(obj);
    }

    public static List d(Object obj) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.e)) {
            i(obj, "kotlin.collections.MutableList");
        }
        return l(obj);
    }

    public static ListIterator e(Object obj) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.f)) {
            i(obj, "kotlin.collections.MutableListIterator");
        }
        return m(obj);
    }

    public static Map f(Object obj) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.g)) {
            i(obj, "kotlin.collections.MutableMap");
        }
        return n(obj);
    }

    public static Map.Entry g(Object obj) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof g.a)) {
            i(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return o(obj);
    }

    public static Set h(Object obj) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.h)) {
            i(obj, "kotlin.collections.MutableSet");
        }
        return p(obj);
    }

    public static void i(Object obj, String str) {
        a((obj == null ? c.c.a.b.a.a.f3101h : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static Iterable j(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e2) {
            throw a(e2);
        }
    }

    public static Iterator k(Object obj) {
        try {
            return (Iterator) obj;
        } catch (ClassCastException e2) {
            throw a(e2);
        }
    }

    public static List l(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            throw a(e2);
        }
    }

    public static ListIterator m(Object obj) {
        try {
            return (ListIterator) obj;
        } catch (ClassCastException e2) {
            throw a(e2);
        }
    }

    public static Map n(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e2) {
            throw a(e2);
        }
    }

    public static Map.Entry o(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e2) {
            throw a(e2);
        }
    }

    public static Set p(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e2) {
            throw a(e2);
        }
    }

    public static int q(Object obj) {
        if (obj instanceof b0) {
            return ((b0) obj).getArity();
        }
        if (obj instanceof h.q2.s.a) {
            return 0;
        }
        if (obj instanceof h.q2.s.l) {
            return 1;
        }
        if (obj instanceof h.q2.s.p) {
            return 2;
        }
        if (obj instanceof h.q2.s.q) {
            return 3;
        }
        if (obj instanceof h.q2.s.r) {
            return 4;
        }
        if (obj instanceof h.q2.s.s) {
            return 5;
        }
        if (obj instanceof h.q2.s.t) {
            return 6;
        }
        if (obj instanceof h.q2.s.u) {
            return 7;
        }
        if (obj instanceof h.q2.s.v) {
            return 8;
        }
        if (obj instanceof h.q2.s.w) {
            return 9;
        }
        if (obj instanceof h.q2.s.b) {
            return 10;
        }
        if (obj instanceof h.q2.s.c) {
            return 11;
        }
        if (obj instanceof h.q2.s.d) {
            return 12;
        }
        if (obj instanceof h.q2.s.e) {
            return 13;
        }
        if (obj instanceof h.q2.s.f) {
            return 14;
        }
        if (obj instanceof h.q2.s.g) {
            return 15;
        }
        if (obj instanceof h.q2.s.h) {
            return 16;
        }
        if (obj instanceof h.q2.s.i) {
            return 17;
        }
        if (obj instanceof h.q2.s.j) {
            return 18;
        }
        if (obj instanceof h.q2.s.k) {
            return 19;
        }
        if (obj instanceof h.q2.s.m) {
            return 20;
        }
        if (obj instanceof h.q2.s.n) {
            return 21;
        }
        return obj instanceof h.q2.s.o ? 22 : -1;
    }

    public static boolean r(Object obj) {
        return (obj instanceof Collection) && (!(obj instanceof h.q2.t.q1.a) || (obj instanceof h.q2.t.q1.b));
    }

    public static boolean s(Object obj) {
        return (obj instanceof Iterable) && (!(obj instanceof h.q2.t.q1.a) || (obj instanceof h.q2.t.q1.c));
    }

    public static boolean t(Object obj) {
        return (obj instanceof Iterator) && (!(obj instanceof h.q2.t.q1.a) || (obj instanceof h.q2.t.q1.d));
    }

    public static boolean u(Object obj) {
        return (obj instanceof List) && (!(obj instanceof h.q2.t.q1.a) || (obj instanceof h.q2.t.q1.e));
    }

    public static boolean v(Object obj) {
        return (obj instanceof ListIterator) && (!(obj instanceof h.q2.t.q1.a) || (obj instanceof h.q2.t.q1.f));
    }

    public static boolean w(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof h.q2.t.q1.a) || (obj instanceof h.q2.t.q1.g));
    }

    public static boolean x(Object obj) {
        return (obj instanceof Map.Entry) && (!(obj instanceof h.q2.t.q1.a) || (obj instanceof g.a));
    }

    public static boolean y(Object obj) {
        return (obj instanceof Set) && (!(obj instanceof h.q2.t.q1.a) || (obj instanceof h.q2.t.q1.h));
    }

    public static void a(String str) {
        throw a(new ClassCastException(str));
    }

    public static ClassCastException a(ClassCastException classCastException) {
        throw ((ClassCastException) a(classCastException));
    }

    public static Collection i(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            throw a(e2);
        }
    }

    public static Collection a(Object obj) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.b)) {
            i(obj, "kotlin.collections.MutableCollection");
        }
        return i(obj);
    }

    public static Iterable b(Object obj, String str) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.c)) {
            a(str);
        }
        return j(obj);
    }

    public static Iterator c(Object obj, String str) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.d)) {
            a(str);
        }
        return k(obj);
    }

    public static List d(Object obj, String str) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.e)) {
            a(str);
        }
        return l(obj);
    }

    public static ListIterator e(Object obj, String str) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.f)) {
            a(str);
        }
        return m(obj);
    }

    public static Map f(Object obj, String str) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.g)) {
            a(str);
        }
        return n(obj);
    }

    public static Map.Entry g(Object obj, String str) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof g.a)) {
            a(str);
        }
        return o(obj);
    }

    public static Set h(Object obj, String str) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.h)) {
            a(str);
        }
        return p(obj);
    }

    public static Collection a(Object obj, String str) {
        if ((obj instanceof h.q2.t.q1.a) && !(obj instanceof h.q2.t.q1.b)) {
            a(str);
        }
        return i(obj);
    }

    public static boolean b(Object obj, int i2) {
        return (obj instanceof h.m) && q(obj) == i2;
    }

    public static Object a(Object obj, int i2) {
        if (obj != null && !b(obj, i2)) {
            i(obj, "kotlin.jvm.functions.Function" + i2);
        }
        return obj;
    }

    public static Object a(Object obj, int i2, String str) {
        if (obj != null && !b(obj, i2)) {
            a(str);
        }
        return obj;
    }
}
