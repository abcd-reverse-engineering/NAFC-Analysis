package com.xiaomi.push;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class aw {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f12468a = new HashMap();

    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends T> f12469a;

        /* renamed from: a, reason: collision with other field name */
        public final T f200a;
    }

    static {
        f12468a.put(Boolean.class, Boolean.TYPE);
        f12468a.put(Byte.class, Byte.TYPE);
        f12468a.put(Character.class, Character.TYPE);
        f12468a.put(Short.class, Short.TYPE);
        f12468a.put(Integer.class, Integer.TYPE);
        f12468a.put(Float.class, Float.TYPE);
        f12468a.put(Long.class, Long.TYPE);
        f12468a.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = f12468a;
        Class<?> cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = f12468a;
        Class<?> cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = f12468a;
        Class<?> cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = f12468a;
        Class<?> cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = f12468a;
        Class<?> cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = f12468a;
        Class<?> cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = f12468a;
        Class<?> cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = f12468a;
        Class<?> cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    public static <T> T a(Object obj, String str) {
        try {
            return (T) a((Class<? extends Object>) obj.getClass(), obj, str);
        } catch (Exception e2) {
            String str2 = "Meet exception when call getField '" + str + "' in " + obj + ", " + e2;
            return null;
        }
    }

    public static void b(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Class<?> superclass = obj.getClass();
        Field declaredField = null;
        while (declaredField == null) {
            try {
                declaredField = superclass.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            }
            if (superclass == null) {
                throw new NoSuchFieldException();
            }
        }
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static <T> T a(Class<? extends Object> cls, String str) {
        try {
            return (T) a(cls, (Object) null, str);
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Meet exception when call getStaticField '");
            sb.append(str);
            sb.append("' in ");
            sb.append(cls != null ? cls.getSimpleName() : "");
            sb.append(", ");
            sb.append(e2);
            sb.toString();
            return null;
        }
    }

    public static <T> T a(String str, String str2) {
        try {
            return (T) a((Class<? extends Object>) C0343r.a(null, str), (Object) null, str2);
        } catch (Exception e2) {
            String str3 = "Meet exception when call getStaticField '" + str2 + "' in " + str + ", " + e2;
            return null;
        }
    }

    public static <T> T b(Object obj, String str, Object... objArr) {
        return (T) a(obj.getClass(), str, a(objArr)).invoke(obj, m157a(objArr));
    }

    public static <T> T a(Class<? extends Object> cls, Object obj, String str) throws NoSuchFieldException {
        Field declaredField = null;
        while (declaredField == null) {
            try {
                declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        declaredField.setAccessible(true);
        return (T) declaredField.get(obj);
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Exception e2) {
            String str2 = "Meet exception when call setField '" + str + "' in " + obj + ", " + e2;
        }
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        try {
            return (T) b(obj, str, objArr);
        } catch (Exception e2) {
            String str2 = "Meet exception when call Method '" + str + "' in " + obj + ", " + e2;
            return null;
        }
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) a(C0343r.a(null, str), str2, objArr);
        } catch (Exception e2) {
            String str3 = "Meet exception when call Method '" + str2 + "' in " + str + ", " + e2;
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method methodA = a(cls.getDeclaredMethods(), str, clsArr);
        if (methodA == null) {
            if (cls.getSuperclass() != null) {
                return a((Class<?>) cls.getSuperclass(), str, clsArr);
            }
            throw new NoSuchMethodException();
        }
        methodA.setAccessible(true);
        return methodA;
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (clsArr2[i2] != null && !clsArr[i2].isAssignableFrom(clsArr2[i2]) && (!f12468a.containsKey(clsArr[i2]) || !f12468a.get(clsArr[i2]).equals(f12468a.get(clsArr2[i2])))) {
                return false;
            }
        }
        return true;
    }

    public static <T> T a(Class<?> cls, String str, Object... objArr) {
        return (T) a(cls, str, a(objArr)).invoke(null, m157a(objArr));
    }

    private static Class<?>[] a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj != null && (obj instanceof a)) {
                clsArr[i2] = ((a) obj).f12469a;
            } else {
                clsArr[i2] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static Object[] m157a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj != null && (obj instanceof a)) {
                objArr2[i2] = ((a) obj).f200a;
            } else {
                objArr2[i2] = obj;
            }
        }
        return objArr2;
    }
}
