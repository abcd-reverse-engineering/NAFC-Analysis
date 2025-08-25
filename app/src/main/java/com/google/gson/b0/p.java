package com.google.gson.b0;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f5546a = a();

    /* compiled from: UnsafeAllocator.java */
    class a extends p {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f5547b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f5548c;

        a(Method method, Object obj) {
            this.f5547b = method;
            this.f5548c = obj;
        }

        @Override // com.google.gson.b0.p
        public <T> T a(Class<T> cls) throws Exception {
            p.c(cls);
            return (T) this.f5547b.invoke(this.f5548c, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    class b extends p {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f5549b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f5550c;

        b(Method method, int i2) {
            this.f5549b = method;
            this.f5550c = i2;
        }

        @Override // com.google.gson.b0.p
        public <T> T a(Class<T> cls) throws Exception {
            p.c(cls);
            return (T) this.f5549b.invoke(null, cls, Integer.valueOf(this.f5550c));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    class c extends p {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f5551b;

        c(Method method) {
            this.f5551b = method;
        }

        @Override // com.google.gson.b0.p
        public <T> T a(Class<T> cls) throws Exception {
            p.c(cls);
            return (T) this.f5551b.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    class d extends p {
        d() {
        }

        @Override // com.google.gson.b0.p
        public <T> T a(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    private static p a() throws NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Class<?> cls) {
        String strA = com.google.gson.b0.c.a(cls);
        if (strA == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strA);
    }

    public abstract <T> T a(Class<T> cls) throws Exception;
}
