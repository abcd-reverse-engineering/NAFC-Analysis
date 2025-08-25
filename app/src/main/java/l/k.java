package l;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import l.c;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: Platform.java */
/* loaded from: classes2.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    private static final k f17142a = b();

    /* compiled from: Platform.java */
    static class a extends k {

        /* compiled from: Platform.java */
        /* renamed from: l.k$a$a, reason: collision with other inner class name */
        static class ExecutorC0272a implements Executor {

            /* renamed from: a, reason: collision with root package name */
            private final Handler f17143a = new Handler(Looper.getMainLooper());

            ExecutorC0272a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f17143a.post(runnable);
            }
        }

        a() {
        }

        @Override // l.k
        public Executor a() {
            return new ExecutorC0272a();
        }

        @Override // l.k
        c.a a(@Nullable Executor executor) {
            if (executor != null) {
                return new g(executor);
            }
            throw new AssertionError();
        }
    }

    /* compiled from: Platform.java */
    @IgnoreJRERequirement
    static class b extends k {
        b() {
        }

        @Override // l.k
        boolean a(Method method) {
            return method.isDefault();
        }

        @Override // l.k
        Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    k() {
    }

    private static k b() throws ClassNotFoundException {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new k();
        }
    }

    static k c() {
        return f17142a;
    }

    @Nullable
    Executor a() {
        return null;
    }

    c.a a(@Nullable Executor executor) {
        return executor != null ? new g(executor) : f.f17088a;
    }

    boolean a(Method method) {
        return false;
    }

    @Nullable
    Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
