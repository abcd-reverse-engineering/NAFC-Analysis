package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;

/* compiled from: AsyncExecutor.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f17476a;

    /* renamed from: b, reason: collision with root package name */
    private final Constructor<?> f17477b;

    /* renamed from: c, reason: collision with root package name */
    private final org.greenrobot.eventbus.c f17478c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f17479d;

    /* compiled from: AsyncExecutor.java */
    /* renamed from: org.greenrobot.eventbus.util.a$a, reason: collision with other inner class name */
    class RunnableC0278a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f17480a;

        RunnableC0278a(c cVar) {
            this.f17480a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            try {
                this.f17480a.run();
            } catch (Exception e2) {
                try {
                    Object objNewInstance = a.this.f17477b.newInstance(e2);
                    if (objNewInstance instanceof e) {
                        ((e) objNewInstance).a(a.this.f17479d);
                    }
                    a.this.f17478c.c(objNewInstance);
                } catch (Exception e3) {
                    a.this.f17478c.b().a(Level.SEVERE, "Original exception:", e2);
                    throw new RuntimeException("Could not create failure event", e3);
                }
            }
        }
    }

    /* compiled from: AsyncExecutor.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Executor f17482a;

        /* renamed from: b, reason: collision with root package name */
        private Class<?> f17483b;

        /* renamed from: c, reason: collision with root package name */
        private org.greenrobot.eventbus.c f17484c;

        /* synthetic */ b(RunnableC0278a runnableC0278a) {
            this();
        }

        public b a(Executor executor) {
            this.f17482a = executor;
            return this;
        }

        private b() {
        }

        public b a(Class<?> cls) {
            this.f17483b = cls;
            return this;
        }

        public b a(org.greenrobot.eventbus.c cVar) {
            this.f17484c = cVar;
            return this;
        }

        public a a() {
            return a((Object) null);
        }

        public a a(Object obj) {
            if (this.f17484c == null) {
                this.f17484c = org.greenrobot.eventbus.c.f();
            }
            if (this.f17482a == null) {
                this.f17482a = Executors.newCachedThreadPool();
            }
            if (this.f17483b == null) {
                this.f17483b = f.class;
            }
            return new a(this.f17482a, this.f17484c, this.f17483b, obj, null);
        }
    }

    /* compiled from: AsyncExecutor.java */
    public interface c {
        void run() throws Exception;
    }

    /* synthetic */ a(Executor executor, org.greenrobot.eventbus.c cVar, Class cls, Object obj, RunnableC0278a runnableC0278a) {
        this(executor, cVar, cls, obj);
    }

    private a(Executor executor, org.greenrobot.eventbus.c cVar, Class<?> cls, Object obj) {
        this.f17476a = executor;
        this.f17478c = cVar;
        this.f17479d = obj;
        try {
            this.f17477b = cls.getConstructor(Throwable.class);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e2);
        }
    }

    public static b a() {
        return new b(null);
    }

    public static a b() {
        return new b(null).a();
    }

    public void a(c cVar) {
        this.f17476a.execute(new RunnableC0278a(cVar));
    }
}
