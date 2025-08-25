package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f9494a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Class<?> f9495b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Method f9496c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Method f9497d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Method f9498e = null;

    /* renamed from: f, reason: collision with root package name */
    private static Method f9499f = null;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f9500g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return i.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (a(context, qQToken)) {
                f9499f.invoke(f9494a, true);
            } else {
                f9499f.invoke(f9494a, false);
            }
        } catch (Exception e2) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e2.toString());
        }
    }

    public static void c(Context context, QQToken qQToken) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f9494a = Class.forName("com.tencent.stat.StatConfig");
            f9495b = Class.forName("com.tencent.stat.StatService");
            f9496c = f9495b.getMethod("reportQQ", Context.class, String.class);
            f9497d = f9495b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f9498e = f9495b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f9499f = f9494a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f9494a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f9494a, false);
            f9494a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f9494a, true);
            f9494a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f9494a, 1440);
            Class<?> cls = Class.forName("com.tencent.stat.StatReportStrategy");
            f9494a.getMethod("setStatSendStrategy", cls).invoke(f9494a, cls.getField("PERIOD").get(null));
            Method method = f9495b.getMethod("startStatService", Context.class, String.class, String.class);
            Class<?> cls2 = f9495b;
            Object[] objArr = new Object[3];
            objArr[0] = context;
            objArr[1] = str;
            objArr[2] = Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null);
            method.invoke(cls2, objArr);
            f9500g = true;
        } catch (Exception e2) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            e.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", "11", "0", "0", "0");
        }
        if (f9500g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f9496c.invoke(f9495b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f9500g) {
            b(context, qQToken);
            try {
                f9497d.invoke(f9495b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
