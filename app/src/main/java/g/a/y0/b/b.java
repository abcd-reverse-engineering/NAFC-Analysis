package g.a.y0.b;

import g.a.x0.d;

/* compiled from: ObjectHelper.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final d<Object, Object> f13939a = new a();

    /* compiled from: ObjectHelper.java */
    static final class a implements d<Object, Object> {
        a() {
        }

        @Override // g.a.x0.d
        public boolean a(Object obj, Object obj2) {
            return b.a(obj, obj2);
        }
    }

    private b() {
        throw new IllegalStateException("No instances!");
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int a(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 > j3 ? 1 : 0;
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static <T> d<T, T> a() {
        return (d<T, T>) f13939a;
    }

    public static int a(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }

    public static long a(long j2, String str) {
        if (j2 > 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j2);
    }
}
