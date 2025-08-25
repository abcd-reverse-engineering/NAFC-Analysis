package h.q2.t;

import h.x1;
import java.util.Arrays;

/* compiled from: Intrinsics.java */
/* loaded from: classes2.dex */
public class i0 {
    private i0() {
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static int a(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    public static String a(String str, Object obj) {
        return str + obj;
    }

    public static void b() {
        throw ((AssertionError) a(new AssertionError()));
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            f(str);
        }
    }

    public static void d(String str) {
        throw ((IllegalArgumentException) a(new IllegalArgumentException(str)));
    }

    @h.t0(version = "1.4")
    public static void e() {
        throw ((NullPointerException) a(new NullPointerException()));
    }

    public static void f() {
        throw ((h.p) a(new h.p()));
    }

    public static void g(String str) {
        throw ((h.p) a(new h.p(str)));
    }

    private static void h(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        throw ((IllegalArgumentException) a(new IllegalArgumentException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static void i(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void j(String str) {
        throw ((x1) a(new x1(str)));
    }

    public static void k(String str) {
        j("lateinit property " + str + " has not been initialized");
    }

    public static void a(Object obj) {
        if (obj == null) {
            e();
        }
    }

    public static void b(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) a(new IllegalStateException("Method specified as non-null returned null: " + str + "." + str2)));
    }

    public static void c(String str) {
        throw ((AssertionError) a(new AssertionError(str)));
    }

    public static void d() {
        throw ((IllegalStateException) a(new IllegalStateException()));
    }

    public static void e(String str) {
        throw ((IllegalStateException) a(new IllegalStateException(str)));
    }

    @h.t0(version = "1.4")
    public static void f(String str) {
        throw ((NullPointerException) a(new NullPointerException(str)));
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) a(new IllegalStateException(str)));
        }
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) a(new IllegalStateException(str + " must not be null")));
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) a(new IllegalStateException(str)));
        }
    }

    public static void c() {
        throw ((IllegalArgumentException) a(new IllegalArgumentException()));
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) a(new NullPointerException(str + " must not be null")));
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) a(new NullPointerException(str)));
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            h(str);
        }
    }

    public static void g() {
        i("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void a(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) a(new IllegalStateException("Field specified as non-null is null: " + str + "." + str2)));
    }

    public static void b(String str) {
        i(str);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @h.t0(version = "1.1")
    public static boolean a(Double d2, Double d3) {
        if (d2 == null) {
            if (d3 == null) {
                return true;
            }
        } else if (d3 != null && d2.doubleValue() == d3.doubleValue()) {
            return true;
        }
        return false;
    }

    @h.t0(version = "1.1")
    public static boolean a(Double d2, double d3) {
        return d2 != null && d2.doubleValue() == d3;
    }

    @h.t0(version = "1.1")
    public static boolean a(double d2, Double d3) {
        return d3 != null && d2 == d3.doubleValue();
    }

    @h.t0(version = "1.1")
    public static boolean a(Float f2, Float f3) {
        if (f2 == null) {
            if (f3 == null) {
                return true;
            }
        } else if (f3 != null && f2.floatValue() == f3.floatValue()) {
            return true;
        }
        return false;
    }

    @h.t0(version = "1.1")
    public static boolean a(Float f2, float f3) {
        return f2 != null && f2.floatValue() == f3;
    }

    @h.t0(version = "1.1")
    public static boolean a(float f2, Float f3) {
        return f3 != null && f2 == f3.floatValue();
    }

    public static void a(int i2, String str) {
        g();
    }

    public static void a(int i2, String str, String str2) {
        i(str2);
    }

    public static void a() {
        g();
    }

    public static void a(String str) throws ClassNotFoundException {
        String strReplace = str.replace('/', '.');
        try {
            Class.forName(strReplace);
        } catch (ClassNotFoundException e2) {
            throw ((ClassNotFoundException) a(new ClassNotFoundException("Class " + strReplace + " is not found. Please update the Kotlin runtime to the latest version", e2)));
        }
    }

    public static void a(String str, String str2) throws ClassNotFoundException {
        String strReplace = str.replace('/', '.');
        try {
            Class.forName(strReplace);
        } catch (ClassNotFoundException e2) {
            throw ((ClassNotFoundException) a(new ClassNotFoundException("Class " + strReplace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e2)));
        }
    }

    private static <T extends Throwable> T a(T t) {
        return (T) a((Throwable) t, i0.class.getName());
    }

    static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }
}
