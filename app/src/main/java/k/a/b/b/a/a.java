package k.a.b.b.a;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: BundleCompat.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: BundleCompat.java */
    /* renamed from: k.a.b.b.a.a$a, reason: collision with other inner class name */
    static class C0267a {

        /* renamed from: a, reason: collision with root package name */
        private static Method f17081a;

        /* renamed from: b, reason: collision with root package name */
        private static boolean f17082b;

        public static void a(Bundle bundle, String str, IBinder iBinder) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!f17082b) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    f17081a = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f17082b = true;
            }
            Method method2 = f17081a;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    f17081a = null;
                }
            }
        }
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            C0267a.a(bundle, str, iBinder);
        }
    }
}
