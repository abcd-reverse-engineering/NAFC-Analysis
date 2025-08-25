package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* compiled from: EventBus.java */
/* loaded from: classes2.dex */
public class c {
    public static String s = "EventBus";
    static volatile c t;
    private static final org.greenrobot.eventbus.d u = new org.greenrobot.eventbus.d();
    private static final Map<Class<?>, List<Class<?>>> v = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<q>> f17368a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f17369b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, Object> f17370c;

    /* renamed from: d, reason: collision with root package name */
    private final ThreadLocal<d> f17371d;

    /* renamed from: e, reason: collision with root package name */
    private final h f17372e;

    /* renamed from: f, reason: collision with root package name */
    private final l f17373f;

    /* renamed from: g, reason: collision with root package name */
    private final org.greenrobot.eventbus.b f17374g;

    /* renamed from: h, reason: collision with root package name */
    private final org.greenrobot.eventbus.a f17375h;

    /* renamed from: i, reason: collision with root package name */
    private final p f17376i;

    /* renamed from: j, reason: collision with root package name */
    private final ExecutorService f17377j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f17378k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f17379l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f17380m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final int q;
    private final g r;

    /* compiled from: EventBus.java */
    class a extends ThreadLocal<d> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public d initialValue() {
            return new d();
        }
    }

    /* compiled from: EventBus.java */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17382a = new int[ThreadMode.values().length];

        static {
            try {
                f17382a[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17382a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17382a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17382a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17382a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: EventBus.java */
    /* renamed from: org.greenrobot.eventbus.c$c, reason: collision with other inner class name */
    interface InterfaceC0277c {
        void a(List<n> list);
    }

    /* compiled from: EventBus.java */
    static final class d {

        /* renamed from: a, reason: collision with root package name */
        final List<Object> f17383a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        boolean f17384b;

        /* renamed from: c, reason: collision with root package name */
        boolean f17385c;

        /* renamed from: d, reason: collision with root package name */
        q f17386d;

        /* renamed from: e, reason: collision with root package name */
        Object f17387e;

        /* renamed from: f, reason: collision with root package name */
        boolean f17388f;

        d() {
        }
    }

    public c() {
        this(u);
    }

    private void a(Object obj, o oVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = oVar.f17424c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.f17368a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f17368a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || oVar.f17425d > copyOnWriteArrayList.get(i2).f17446b.f17425d) {
                copyOnWriteArrayList.add(i2, qVar);
                break;
            }
        }
        List<Class<?>> arrayList = this.f17369b.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f17369b.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (oVar.f17426e) {
            if (!this.p) {
                b(qVar, this.f17370c.get(cls));
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.f17370c.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    b(qVar, entry.getValue());
                }
            }
        }
    }

    private void b(q qVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (obj != null) {
            a(qVar, obj, g());
        }
    }

    public static org.greenrobot.eventbus.d d() {
        return new org.greenrobot.eventbus.d();
    }

    public static void e() {
        p.a();
        v.clear();
    }

    public static c f() {
        if (t == null) {
            synchronized (c.class) {
                if (t == null) {
                    t = new c();
                }
            }
        }
        return t;
    }

    private boolean g() {
        h hVar = this.f17372e;
        if (hVar != null) {
            return hVar.a();
        }
        return true;
    }

    public void c(Object obj) {
        d dVar = this.f17371d.get();
        List<Object> list = dVar.f17383a;
        list.add(obj);
        if (dVar.f17384b) {
            return;
        }
        dVar.f17385c = g();
        dVar.f17384b = true;
        if (dVar.f17388f) {
            throw new e("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    a(list.remove(0), dVar);
                }
            } finally {
                dVar.f17384b = false;
                dVar.f17385c = false;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.q + ", eventInheritance=" + this.p + "]";
    }

    c(org.greenrobot.eventbus.d dVar) {
        this.f17371d = new a();
        this.r = dVar.c();
        this.f17368a = new HashMap();
        this.f17369b = new HashMap();
        this.f17370c = new ConcurrentHashMap();
        this.f17372e = dVar.d();
        h hVar = this.f17372e;
        this.f17373f = hVar != null ? hVar.a(this) : null;
        this.f17374g = new org.greenrobot.eventbus.b(this);
        this.f17375h = new org.greenrobot.eventbus.a(this);
        List<org.greenrobot.eventbus.r.d> list = dVar.f17399k;
        this.q = list != null ? list.size() : 0;
        this.f17376i = new p(dVar.f17399k, dVar.f17396h, dVar.f17395g);
        this.f17379l = dVar.f17389a;
        this.f17380m = dVar.f17390b;
        this.n = dVar.f17391c;
        this.o = dVar.f17392d;
        this.f17378k = dVar.f17393e;
        this.p = dVar.f17394f;
        this.f17377j = dVar.f17397i;
    }

    public synchronized boolean b(Object obj) {
        return this.f17369b.containsKey(obj);
    }

    public void d(Object obj) {
        synchronized (this.f17370c) {
            this.f17370c.put(obj.getClass(), obj);
        }
        c(obj);
    }

    public synchronized void g(Object obj) {
        List<Class<?>> list = this.f17369b.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                a(obj, it.next());
            }
            this.f17369b.remove(obj);
        } else {
            this.r.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public boolean b(Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList;
        List<Class<?>> listD = d(cls);
        if (listD != null) {
            int size = listD.size();
            for (int i2 = 0; i2 < size; i2++) {
                Class<?> cls2 = listD.get(i2);
                synchronized (this) {
                    copyOnWriteArrayList = this.f17368a.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void e(Object obj) {
        List<o> listA = this.f17376i.a(obj.getClass());
        synchronized (this) {
            Iterator<o> it = listA.iterator();
            while (it.hasNext()) {
                a(obj, it.next());
            }
        }
    }

    private static List<Class<?>> d(Class<?> cls) {
        List<Class<?>> arrayList;
        synchronized (v) {
            arrayList = v.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    a(arrayList, superclass.getInterfaces());
                }
                v.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    public boolean f(Object obj) {
        synchronized (this.f17370c) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f17370c.get(cls))) {
                return false;
            }
            this.f17370c.remove(cls);
            return true;
        }
    }

    public g b() {
        return this.r;
    }

    public <T> T c(Class<T> cls) {
        T tCast;
        synchronized (this.f17370c) {
            tCast = cls.cast(this.f17370c.remove(cls));
        }
        return tCast;
    }

    public void c() {
        synchronized (this.f17370c) {
            this.f17370c.clear();
        }
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.f17368a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = copyOnWriteArrayList.get(i2);
                if (qVar.f17445a == obj) {
                    qVar.f17447c = false;
                    copyOnWriteArrayList.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public void a(Object obj) {
        d dVar = this.f17371d.get();
        if (!dVar.f17384b) {
            throw new e("This method may only be called from inside event handling methods on the posting thread");
        }
        if (obj != null) {
            if (dVar.f17387e == obj) {
                if (dVar.f17386d.f17446b.f17423b == ThreadMode.POSTING) {
                    dVar.f17388f = true;
                    return;
                }
                throw new e(" event handlers may only abort the incoming event");
            }
            throw new e("Only the currently handled event may be aborted");
        }
        throw new e("Event may not be null");
    }

    public <T> T a(Class<T> cls) {
        T tCast;
        synchronized (this.f17370c) {
            tCast = cls.cast(this.f17370c.get(cls));
        }
        return tCast;
    }

    private void a(Object obj, d dVar) throws Error {
        boolean zA;
        Class<?> cls = obj.getClass();
        if (this.p) {
            List<Class<?>> listD = d(cls);
            int size = listD.size();
            zA = false;
            for (int i2 = 0; i2 < size; i2++) {
                zA |= a(obj, dVar, listD.get(i2));
            }
        } else {
            zA = a(obj, dVar, cls);
        }
        if (zA) {
            return;
        }
        if (this.f17380m) {
            this.r.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.o || cls == i.class || cls == n.class) {
            return;
        }
        c(new i(this, obj));
    }

    private boolean a(Object obj, d dVar, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f17368a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<q> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            dVar.f17387e = obj;
            dVar.f17386d = next;
            try {
                a(next, obj, dVar.f17385c);
                if (dVar.f17388f) {
                    return true;
                }
            } finally {
                dVar.f17387e = null;
                dVar.f17386d = null;
                dVar.f17388f = false;
            }
        }
        return true;
    }

    private void a(q qVar, Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i2 = b.f17382a[qVar.f17446b.f17423b.ordinal()];
        if (i2 == 1) {
            a(qVar, obj);
            return;
        }
        if (i2 == 2) {
            if (z) {
                a(qVar, obj);
                return;
            } else {
                this.f17373f.a(qVar, obj);
                return;
            }
        }
        if (i2 == 3) {
            l lVar = this.f17373f;
            if (lVar != null) {
                lVar.a(qVar, obj);
                return;
            } else {
                a(qVar, obj);
                return;
            }
        }
        if (i2 == 4) {
            if (z) {
                this.f17374g.a(qVar, obj);
                return;
            } else {
                a(qVar, obj);
                return;
            }
        }
        if (i2 == 5) {
            this.f17375h.a(qVar, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + qVar.f17446b.f17423b);
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    void a(j jVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = jVar.f17413a;
        q qVar = jVar.f17414b;
        j.a(jVar);
        if (qVar.f17447c) {
            a(qVar, obj);
        }
    }

    void a(q qVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            qVar.f17446b.f17422a.invoke(qVar.f17445a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            a(qVar, obj, e3.getCause());
        }
    }

    private void a(q qVar, Object obj, Throwable th) {
        if (obj instanceof n) {
            if (this.f17379l) {
                this.r.a(Level.SEVERE, "SubscriberExceptionEvent subscriber " + qVar.f17445a.getClass() + " threw an exception", th);
                n nVar = (n) obj;
                this.r.a(Level.SEVERE, "Initial event " + nVar.f17420c + " caused exception in " + nVar.f17421d, nVar.f17419b);
                return;
            }
            return;
        }
        if (!this.f17378k) {
            if (this.f17379l) {
                this.r.a(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + qVar.f17445a.getClass(), th);
            }
            if (this.n) {
                c(new n(this, th, obj, qVar.f17445a));
                return;
            }
            return;
        }
        throw new e("Invoking subscriber failed", th);
    }

    ExecutorService a() {
        return this.f17377j;
    }
}
