package i.e.b.c.a;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: IdentifierManager.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16925a = "IdentifierManager";

    /* renamed from: b, reason: collision with root package name */
    private static Object f16926b;

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f16927c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f16928d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f16929e;

    /* renamed from: f, reason: collision with root package name */
    private static Method f16930f;

    /* renamed from: g, reason: collision with root package name */
    private static Method f16931g;

    static {
        try {
            f16927c = Class.forName("com.android.id.impl.IdProviderImpl");
            f16926b = f16927c.newInstance();
            f16928d = f16927c.getMethod("getUDID", Context.class);
            f16929e = f16927c.getMethod("getOAID", Context.class);
            f16930f = f16927c.getMethod("getVAID", Context.class);
            f16931g = f16927c.getMethod("getAAID", Context.class);
        } catch (Exception unused) {
        }
    }

    public static boolean a() {
        return (f16927c == null || f16926b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f16929e);
    }

    public static String c(Context context) {
        return a(context, f16930f);
    }

    public static String d(Context context) {
        return a(context, f16931g);
    }

    public static String a(Context context) {
        return a(context, f16928d);
    }

    private static String a(Context context, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = f16926b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
