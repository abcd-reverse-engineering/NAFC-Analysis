package com.umeng.message.proguard;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.ut.device.UTDevice;
import java.io.Closeable;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name */
    private static String f11351d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f11352e;

    /* renamed from: f, reason: collision with root package name */
    private static Boolean f11353f;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f11350c = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public static boolean f11348a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f11349b = true;

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b(Context context) {
        Boolean bool = f11352e;
        if (bool != null) {
            return bool.booleanValue();
        }
        String packageName = context.getPackageName();
        Boolean boolValueOf = Boolean.valueOf(!TextUtils.isEmpty(packageName) && TextUtils.equals(a(context), packageName));
        f11352e = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static boolean c(Context context) {
        Boolean bool;
        try {
            bool = (Boolean) ba.a(ba.a(UTDevice.class.getName(), "isNewDid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
            bool = null;
        }
        return Boolean.TRUE.equals(bool);
    }

    public static String d(Context context) {
        try {
            return (String) ba.a(ba.a(UTDevice.class.getName(), "getTid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
            return null;
        }
    }

    public static void e(Context context) {
        try {
            ba.a(ba.a(UTDevice.class.getName(), "removeTid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
    }

    public static boolean f(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }

    public static File g(Context context) {
        File file = new File(context.getCacheDir(), "umeng_push");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return file;
    }

    public static void a(Context context, Class<?> cls) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && packageManager.getApplicationEnabledSetting(context.getPackageName()) >= 0) {
                ComponentName componentName = new ComponentName(context, cls);
                if (a(packageManager, componentName)) {
                    return;
                }
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
    }

    public static boolean b() {
        Boolean bool = f11353f;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean bool2 = null;
        try {
            bool2 = (Boolean) ba.a(ba.a(UMConfigure.class.getName(), "isSilentMode", (Class<?>[]) new Class[0]), (Object) null, (Object[]) null);
        } catch (Throwable unused) {
        }
        Boolean boolValueOf = Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false);
        f11353f = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static void c() {
        try {
            Method methodA = ba.a(UMConfigure.class.getName(), "registerActionInfo", (Class<?>[]) new Class[]{Class.forName("com.umeng.ccg.ActionInfo")});
            if (methodA != null) {
                ba.a(methodA, (Object) null, new Object[]{ba.a(r.class.getName(), (Class<?>[]) null, (Object[]) null)});
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(PackageManager packageManager, ComponentName componentName) {
        try {
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
            return componentEnabledSetting == 1 || componentEnabledSetting == 0;
        } catch (Throwable th) {
            UPLog.e("Helper", th);
            return false;
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f11351d)) {
            return f11351d;
        }
        String currentProcessName = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                currentProcessName = Application.getProcessName();
            }
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
        if (TextUtils.isEmpty(currentProcessName)) {
            currentProcessName = UMFrUtils.getCurrentProcessName(context);
        }
        f11351d = currentProcessName;
        return currentProcessName;
    }

    public static String a(Context context, String str) {
        String str2 = context.getCacheDir() + "/umeng_push_inapp/";
        if (str == null) {
            return str2;
        }
        return str2 + str + "/";
    }

    public static int a() {
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i2 = f11350c.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!f11350c.compareAndSet(i2, i3));
        return i2;
    }

    public static void a(Context context, String str, long j2) {
        try {
            ba.a(ba.a(UTDevice.class.getName(), "resetDid", (Class<?>[]) new Class[]{Context.class, String.class, Long.TYPE}), (Object) null, new Object[]{context, str, Long.valueOf(j2)});
        } catch (Throwable th) {
            UPLog.e("Helper", th);
        }
    }

    public static Object a(Object obj, String str) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(long j2) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(6);
        calendar.setTimeInMillis(j2);
        return i3 == calendar.get(6) && i2 == calendar.get(1);
    }

    public static Bitmap a(File file, int i2, int i3) {
        try {
            if (i3 != 0 && i2 != 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                float f2 = i2 >= i3 ? options.outWidth / i2 : options.outHeight / i3;
                float f3 = 1.0f;
                if (f2 >= 1.0f) {
                    f3 = f2;
                }
                options.inJustDecodeBounds = false;
                options.inSampleSize = (int) f3;
                return BitmapFactory.decodeFile(file.getPath(), options);
            }
            return BitmapFactory.decodeFile(file.getPath(), null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        switch (str) {
            case "HW_TOKEN":
                return "huawei";
            case "VIVO_TOKEN":
                return "vivo";
            case "MZ_TOKEN":
                return "meizu";
            case "OPPO_TOKEN":
                return "oppo";
            case "HONOR_TOKEN":
                return "honor";
            case "MI_TOKEN":
                return "xiaomi";
            case "gcm":
                return UPushThirdTokenCallback.TYPE_FCM;
            default:
                return str;
        }
    }
}
