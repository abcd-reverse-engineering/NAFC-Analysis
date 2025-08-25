package com.google.gson.b0.s;

import com.google.gson.l;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: ReflectionHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final b f5665a;

    /* compiled from: ReflectionHelper.java */
    private static abstract class b {
        private b() {
        }

        abstract <T> Constructor<T> a(Class<T> cls);

        public abstract Method a(Class<?> cls, Field field);

        abstract String[] b(Class<?> cls);

        abstract boolean c(Class<?> cls);
    }

    /* compiled from: ReflectionHelper.java */
    private static class c extends b {
        private c() {
            super();
        }

        @Override // com.google.gson.b0.s.a.b
        <T> Constructor<T> a(Class<T> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.b0.s.a.b
        String[] b(Class<?> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.b0.s.a.b
        boolean c(Class<?> cls) {
            return false;
        }

        @Override // com.google.gson.b0.s.a.b
        public Method a(Class<?> cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }
    }

    /* compiled from: ReflectionHelper.java */
    private static class d extends b {

        /* renamed from: a, reason: collision with root package name */
        private final Method f5666a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f5667b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f5668c;

        /* renamed from: d, reason: collision with root package name */
        private final Method f5669d;

        @Override // com.google.gson.b0.s.a.b
        public <T> Constructor<T> a(Class<T> cls) {
            try {
                Object[] objArr = (Object[]) this.f5667b.invoke(cls, new Object[0]);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    clsArr[i2] = (Class) this.f5669d.invoke(objArr[i2], new Object[0]);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e2) {
                throw a.b(e2);
            }
        }

        @Override // com.google.gson.b0.s.a.b
        String[] b(Class<?> cls) {
            try {
                Object[] objArr = (Object[]) this.f5667b.invoke(cls, new Object[0]);
                String[] strArr = new String[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    strArr[i2] = (String) this.f5668c.invoke(objArr[i2], new Object[0]);
                }
                return strArr;
            } catch (ReflectiveOperationException e2) {
                throw a.b(e2);
            }
        }

        @Override // com.google.gson.b0.s.a.b
        boolean c(Class<?> cls) {
            try {
                return ((Boolean) this.f5666a.invoke(cls, new Object[0])).booleanValue();
            } catch (ReflectiveOperationException e2) {
                throw a.b(e2);
            }
        }

        private d() throws NoSuchMethodException {
            super();
            this.f5666a = Class.class.getMethod("isRecord", new Class[0]);
            this.f5667b = Class.class.getMethod("getRecordComponents", new Class[0]);
            Class<?> componentType = this.f5667b.getReturnType().getComponentType();
            this.f5668c = componentType.getMethod("getName", new Class[0]);
            this.f5669d = componentType.getMethod("getType", new Class[0]);
        }

        @Override // com.google.gson.b0.s.a.b
        public Method a(Class<?> cls, Field field) {
            try {
                return cls.getMethod(field.getName(), new Class[0]);
            } catch (ReflectiveOperationException e2) {
                throw a.b(e2);
            }
        }
    }

    static {
        b cVar;
        try {
            cVar = new d();
        } catch (NoSuchMethodException unused) {
            cVar = new c();
        }
        f5665a = cVar;
    }

    private a() {
    }

    public static String b(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e2) {
            return "Failed making constructor '" + a(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e2.getMessage();
        }
    }

    public static boolean c(Class<?> cls) {
        return f5665a.c(cls);
    }

    public static void a(AccessibleObject accessibleObject) throws SecurityException, l {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e2) {
            throw new l("Failed making " + a(accessibleObject, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e2);
        }
    }

    public static String[] b(Class<?> cls) {
        return f5665a.b(cls);
    }

    public static String a(AccessibleObject accessibleObject, boolean z) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + a((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            a(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + a((Constructor<?>) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RuntimeException b(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static String a(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String a(Constructor<?> constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        a(constructor, sb);
        return sb.toString();
    }

    private static void a(AccessibleObject accessibleObject, StringBuilder sb) {
        Class<?>[] parameterTypes;
        sb.append('(');
        if (accessibleObject instanceof Method) {
            parameterTypes = ((Method) accessibleObject).getParameterTypes();
        } else {
            parameterTypes = ((Constructor) accessibleObject).getParameterTypes();
        }
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i2].getSimpleName());
        }
        sb.append(')');
    }

    public static Method a(Class<?> cls, Field field) {
        return f5665a.a(cls, field);
    }

    public static <T> Constructor<T> a(Class<T> cls) {
        return f5665a.a(cls);
    }

    public static RuntimeException a(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }
}
