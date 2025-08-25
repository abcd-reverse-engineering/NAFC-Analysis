package com.google.gson.b0;

import com.google.gson.v;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* compiled from: ReflectionAccessFilterHelper.java */
/* loaded from: classes.dex */
public class n {

    /* compiled from: ReflectionAccessFilterHelper.java */
    private static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5540a;

        /* compiled from: ReflectionAccessFilterHelper.java */
        class a extends b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Method f5541b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.f5541b = method;
            }

            @Override // com.google.gson.b0.n.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f5541b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e2) {
                    throw new RuntimeException("Failed invoking canAccess", e2);
                }
            }
        }

        /* compiled from: ReflectionAccessFilterHelper.java */
        /* renamed from: com.google.gson.b0.n$b$b, reason: collision with other inner class name */
        class C0085b extends b {
            C0085b() {
                super();
            }

            @Override // com.google.gson.b0.n.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        static {
            b aVar;
            if (f.c()) {
                try {
                    aVar = new a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new C0085b();
            }
            f5540a = aVar;
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    private n() {
    }

    public static boolean a(Class<?> cls) {
        return a(cls.getName());
    }

    private static boolean b(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }

    public static boolean c(Class<?> cls) {
        return b(cls.getName());
    }

    private static boolean a(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || b(str);
    }

    public static boolean b(Class<?> cls) {
        String name = cls.getName();
        return a(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static v.e a(List<v> list, Class<?> cls) {
        Iterator<v> it = list.iterator();
        while (it.hasNext()) {
            v.e eVarA = it.next().a(cls);
            if (eVarA != v.e.INDECISIVE) {
                return eVarA;
            }
        }
        return v.e.ALLOW;
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f5540a.a(accessibleObject, obj);
    }
}
