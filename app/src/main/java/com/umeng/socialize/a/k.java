package com.umeng.socialize.a;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: UMReflectUtils.java */
/* loaded from: classes2.dex */
public class k {
    public static Method a(String str, String str2, Class<?>... clsArr) {
        Class<?> clsA;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (clsA = a(str)) == null) {
            return null;
        }
        try {
            return clsA.getDeclaredMethod(str2, clsArr);
        } catch (Throwable th) {
            m.d("", "getMethod failed, cls:", str, " method:", str2, " msg:", th.getMessage());
            return null;
        }
    }

    public static Object a(Method method, Object obj, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            m.d("", "invoke failed:", th.getMessage());
            return null;
        }
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object obj, Object[] objArr) {
        Method methodA = a(str, str2, clsArr);
        if (methodA != null) {
            return a(methodA, obj, objArr);
        }
        return null;
    }

    public static Field a(String str, String str2) {
        Class<?> clsA;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (clsA = a(str)) == null) {
            return null;
        }
        try {
            return clsA.getField(str2);
        } catch (Throwable th) {
            m.d("", "getFiled failed, cls:", str, " filed:", str2, " msg:", th.getMessage());
            return null;
        }
    }

    public static Object a(String str, String str2, Object obj) {
        return a(a(str, str2), obj);
    }

    public static Object a(Field field, Object obj) {
        if (field == null) {
            return null;
        }
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(obj);
        } catch (Throwable th) {
            m.d("", "getFiledValue failed:", th.getMessage());
            return null;
        }
    }

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> clsA = a(str);
        if (clsA == null) {
            return null;
        }
        try {
            return clsA.getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            m.d("", "newInstance failed, cls:", str, " msg:", th.getMessage());
            return null;
        }
    }

    public static Class<?> a(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = k.class.getClassLoader();
        }
        try {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return Class.forName(str, true, k.class.getClassLoader());
        }
    }
}
