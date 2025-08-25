package org.greenrobot.eventbus;

import h.z2.h0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SubscriberMethodFinder.java */
/* loaded from: classes2.dex */
class p {

    /* renamed from: d, reason: collision with root package name */
    private static final int f17428d = 64;

    /* renamed from: e, reason: collision with root package name */
    private static final int f17429e = 4096;

    /* renamed from: f, reason: collision with root package name */
    private static final int f17430f = 5192;

    /* renamed from: h, reason: collision with root package name */
    private static final int f17432h = 4;

    /* renamed from: a, reason: collision with root package name */
    private List<org.greenrobot.eventbus.r.d> f17434a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f17435b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f17436c;

    /* renamed from: g, reason: collision with root package name */
    private static final Map<Class<?>, List<o>> f17431g = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    private static final a[] f17433i = new a[4];

    p(List<org.greenrobot.eventbus.r.d> list, boolean z, boolean z2) {
        this.f17434a = list;
        this.f17435b = z;
        this.f17436c = z2;
    }

    private List<o> b(Class<?> cls) throws SecurityException {
        a aVarB = b();
        aVarB.a(cls);
        while (aVarB.f17442f != null) {
            aVarB.f17444h = c(aVarB);
            org.greenrobot.eventbus.r.c cVar = aVarB.f17444h;
            if (cVar != null) {
                for (o oVar : cVar.a()) {
                    if (aVarB.a(oVar.f17422a, oVar.f17424c)) {
                        aVarB.f17437a.add(oVar);
                    }
                }
            } else {
                a(aVarB);
            }
            aVarB.a();
        }
        return b(aVarB);
    }

    private org.greenrobot.eventbus.r.c c(a aVar) {
        org.greenrobot.eventbus.r.c cVar = aVar.f17444h;
        if (cVar != null && cVar.b() != null) {
            org.greenrobot.eventbus.r.c cVarB = aVar.f17444h.b();
            if (aVar.f17442f == cVarB.d()) {
                return cVarB;
            }
        }
        List<org.greenrobot.eventbus.r.d> list = this.f17434a;
        if (list == null) {
            return null;
        }
        Iterator<org.greenrobot.eventbus.r.d> it = list.iterator();
        while (it.hasNext()) {
            org.greenrobot.eventbus.r.c cVarA = it.next().a(aVar.f17442f);
            if (cVarA != null) {
                return cVarA;
            }
        }
        return null;
    }

    List<o> a(Class<?> cls) {
        List<o> list = f17431g.get(cls);
        if (list != null) {
            return list;
        }
        List<o> listC = this.f17436c ? c(cls) : b(cls);
        if (!listC.isEmpty()) {
            f17431g.put(cls, listC);
            return listC;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    /* compiled from: SubscriberMethodFinder.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final List<o> f17437a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        final Map<Class, Object> f17438b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        final Map<String, Class> f17439c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        final StringBuilder f17440d = new StringBuilder(128);

        /* renamed from: e, reason: collision with root package name */
        Class<?> f17441e;

        /* renamed from: f, reason: collision with root package name */
        Class<?> f17442f;

        /* renamed from: g, reason: collision with root package name */
        boolean f17443g;

        /* renamed from: h, reason: collision with root package name */
        org.greenrobot.eventbus.r.c f17444h;

        a() {
        }

        void a(Class<?> cls) {
            this.f17442f = cls;
            this.f17441e = cls;
            this.f17443g = false;
            this.f17444h = null;
        }

        void b() {
            this.f17437a.clear();
            this.f17438b.clear();
            this.f17439c.clear();
            this.f17440d.setLength(0);
            this.f17441e = null;
            this.f17442f = null;
            this.f17443g = false;
            this.f17444h = null;
        }

        boolean a(Method method, Class<?> cls) {
            Object objPut = this.f17438b.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (b((Method) objPut, cls)) {
                    this.f17438b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        private boolean b(Method method, Class<?> cls) {
            this.f17440d.setLength(0);
            this.f17440d.append(method.getName());
            StringBuilder sb = this.f17440d;
            sb.append(h0.f16708e);
            sb.append(cls.getName());
            String string = this.f17440d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class clsPut = this.f17439c.put(string, declaringClass);
            if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f17439c.put(string, clsPut);
            return false;
        }

        void a() {
            if (this.f17443g) {
                this.f17442f = null;
                return;
            }
            this.f17442f = this.f17442f.getSuperclass();
            String name = this.f17442f.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f17442f = null;
            }
        }
    }

    private List<o> c(Class<?> cls) throws SecurityException {
        a aVarB = b();
        aVarB.a(cls);
        while (aVarB.f17442f != null) {
            a(aVarB);
            aVarB.a();
        }
        return b(aVarB);
    }

    private void a(a aVar) throws SecurityException {
        Method[] methods;
        try {
            methods = aVar.f17442f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f17442f.getMethods();
            aVar.f17443g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & f17430f) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    m mVar = (m) method.getAnnotation(m.class);
                    if (mVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f17437a.add(new o(method, cls, mVar.threadMode(), mVar.priority(), mVar.sticky()));
                        }
                    }
                } else if (this.f17435b && method.isAnnotationPresent(m.class)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f17435b && method.isAnnotationPresent(m.class)) {
                throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    private List<o> b(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f17437a);
        aVar.b();
        synchronized (f17433i) {
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    break;
                }
                if (f17433i[i2] == null) {
                    f17433i[i2] = aVar;
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    private a b() {
        synchronized (f17433i) {
            for (int i2 = 0; i2 < 4; i2++) {
                a aVar = f17433i[i2];
                if (aVar != null) {
                    f17433i[i2] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    static void a() {
        f17431g.clear();
    }
}
