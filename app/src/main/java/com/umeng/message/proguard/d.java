package com.umeng.message.proguard;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f11340a;

    /* renamed from: b, reason: collision with root package name */
    public static String f11341b;

    /* renamed from: c, reason: collision with root package name */
    public static String f11342c;

    /* renamed from: d, reason: collision with root package name */
    private static String f11343d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f11344e;

    /* renamed from: f, reason: collision with root package name */
    private static Boolean f11345f;

    /* renamed from: g, reason: collision with root package name */
    private static String f11346g;

    /* renamed from: h, reason: collision with root package name */
    private static Boolean f11347h;

    public static String a(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String b(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static String c() {
        return "02:00:00:00:00:00";
    }

    public static String c(Context context) {
        String imeiNew;
        try {
            imeiNew = DeviceConfig.getImeiNew(context);
            try {
                if (TextUtils.isEmpty(imeiNew)) {
                    return "";
                }
                String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
                return (messageAppkey == null || messageAppkey.length() < 16) ? imeiNew : ax.a(imeiNew, messageAppkey.substring(0, 16), as.a("bm1ldWcuZjkvT20rTDgyMw=="));
            } catch (Exception e2) {
                e = e2;
                UPLog.e("DeviceConfig", e);
                return imeiNew;
            }
        } catch (Exception e3) {
            e = e3;
            imeiNew = "";
        }
    }

    public static String d(Context context) {
        String strS;
        try {
            strS = s(context);
            try {
                if (TextUtils.isEmpty(strS)) {
                    return "";
                }
                String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
                return (messageAppkey == null || messageAppkey.length() < 16) ? strS : ax.a(strS, messageAppkey.substring(0, 16), as.a("bm1ldWcuZjkvT20rTDgyMw=="));
            } catch (Exception e2) {
                e = e2;
                UPLog.e("DeviceConfig", e);
                return strS;
            }
        } catch (Exception e3) {
            e = e3;
            strS = "";
        }
    }

    public static String e(Context context) {
        return DeviceConfig.getAndroidId(context);
    }

    public static String f(Context context) {
        return UMUtils.MD5(s(context));
    }

    public static String[] g(Context context) {
        return UMUtils.getNetworkAccessMode(context);
    }

    public static boolean h(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return true;
        } catch (Throwable th) {
            UPLog.e("DeviceConfig", th);
            return true;
        }
    }

    public static int i(Context context) {
        try {
            return Calendar.getInstance(t(context)).getTimeZone().getRawOffset() / 3600000;
        } catch (Exception e2) {
            UPLog.e("DeviceConfig", e2);
            return 8;
        }
    }

    public static String[] j(Context context) {
        String[] strArr = new String[2];
        try {
            Locale localeT = t(context);
            strArr[0] = localeT.getCountry();
            strArr[1] = localeT.getLanguage();
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Exception e2) {
            UPLog.e("DeviceConfig", e2);
            return strArr;
        }
    }

    public static String k(Context context) {
        String uMId = UMUtils.getUMId(context);
        return uMId == null ? "" : uMId;
    }

    public static String l(Context context) {
        int iA;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int iA2 = 0;
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                iA = a(displayMetrics, "noncompatWidthPixels");
                iA2 = a(displayMetrics, "noncompatHeightPixels");
            } else {
                iA = -1;
            }
            if (iA == -1 || iA2 == -1) {
                iA = displayMetrics.widthPixels;
                iA2 = displayMetrics.heightPixels;
            }
            return iA + "*" + iA2;
        } catch (Exception e2) {
            UPLog.e("DeviceConfig", e2);
            return "Unknown";
        }
    }

    public static String m(Context context) {
        try {
            return UMUtils.getOperator(context);
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    public static String n(Context context) {
        String channelByXML = UMUtils.getChannelByXML(context);
        return !TextUtils.isEmpty(channelByXML) ? channelByXML : "Unknown";
    }

    public static String o(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Throwable th) {
            UPLog.e("DeviceConfig", "utdid failed! " + th.getMessage());
            return "";
        }
    }

    public static String p(Context context) throws ClassNotFoundException {
        int iQ = q(context);
        return iQ == 0 ? Boolean.toString(false) : iQ == 1 ? Boolean.toString(true) : "unknown";
    }

    public static int q(Context context) throws ClassNotFoundException {
        if (f.b()) {
            UPLog.d("DeviceConfig", "silent mode disabled");
            return -1;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            try {
                return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled() ? 1 : 0;
            } catch (Throwable th) {
                UPLog.e("DeviceConfig", th);
                return -1;
            }
        }
        if (i2 < 19) {
            return 1;
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i3 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0 ? 1 : 0;
        } catch (Exception e2) {
            UPLog.e("DeviceConfig", e2);
            return -1;
        }
    }

    public static boolean r(Context context) {
        if (f.b()) {
            UPLog.d("DeviceConfig", "silent mode disabled");
            return false;
        }
        try {
            Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                intent.putExtra("android.provider.extra.CHANNEL_ID", context.getApplicationInfo().uid);
            } else if (Build.VERSION.SDK_INT >= 21) {
                intent.putExtra("app_package", context.getPackageName());
                intent.putExtra("app_uid", context.getApplicationInfo().uid);
            }
            intent.setFlags(CommonNetImpl.FLAG_AUTH);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            UPLog.e("DeviceConfig", th);
            try {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", context.getPackageName(), null));
                intent2.setFlags(CommonNetImpl.FLAG_AUTH);
                context.startActivity(intent2);
                return true;
            } catch (Throwable th2) {
                UPLog.e("DeviceConfig", th2);
                return false;
            }
        }
    }

    private static String s(Context context) {
        if (!TextUtils.isEmpty(f11343d)) {
            return f11343d;
        }
        String imeiNew = DeviceConfig.getImeiNew(context);
        f11343d = imeiNew;
        if (!TextUtils.isEmpty(imeiNew)) {
            return f11343d;
        }
        String androidId = DeviceConfig.getAndroidId(context);
        f11343d = androidId;
        if (!TextUtils.isEmpty(androidId)) {
            return f11343d;
        }
        String serial = DeviceConfig.getSerial();
        f11343d = serial;
        if (TextUtils.isEmpty(serial)) {
            f11343d = "";
        }
        return f11343d;
    }

    private static Locale t(Context context) {
        Locale locale;
        try {
            Configuration configuration = new Configuration();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Exception e2) {
            UPLog.e("DeviceConfig", e2);
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String a() {
        return UMUtils.getCPU();
    }

    public static String b() {
        return DeviceConfig.getSerial();
    }

    public static String e() {
        if (TextUtils.isEmpty(f11342c)) {
            f11342c = Build.BOARD;
        }
        return f11342c;
    }

    public static String f() {
        if (TextUtils.isEmpty(f11341b)) {
            String str = Build.BRAND;
            f11341b = str;
            if (TextUtils.isEmpty(str)) {
                f11341b = Build.MANUFACTURER;
            }
        }
        return f11341b;
    }

    public static boolean g() {
        String strF;
        Boolean bool = f11344e;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            strF = f();
        } catch (Throwable unused) {
        }
        if ("huawei".equalsIgnoreCase(strF)) {
            f11344e = Boolean.TRUE;
            return true;
        }
        if ("honor".equalsIgnoreCase(strF)) {
            f11344e = Boolean.TRUE;
            return true;
        }
        f11344e = Boolean.FALSE;
        return false;
    }

    private static String k() {
        String str = f11346g;
        if (str != null) {
            return str;
        }
        if (!"vivo".equalsIgnoreCase(f())) {
            f11346g = "";
            return "";
        }
        String strA = a("ro.vivo.os.build.display.id");
        f11346g = strA;
        if (!TextUtils.isEmpty(strA)) {
            return f11346g;
        }
        String strA2 = a("ro.iqoo.os.build.display.id");
        f11346g = strA2;
        if (!TextUtils.isEmpty(strA2)) {
            return f11346g;
        }
        f11346g = "";
        return "";
    }

    public static String a(Context context, String str) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
            if (string != null) {
                return string.trim();
            }
        } catch (Exception e2) {
            UPLog.e("DeviceConfig", e2);
        }
        UPLog.w("DeviceConfig", String.format("Could not read meta-data %s from AndroidManifest.xml.", str));
        return null;
    }

    public static boolean h() {
        Boolean bool = f11345f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if ("vivo".equalsIgnoreCase(f())) {
            f11345f = Boolean.TRUE;
            return true;
        }
        String strK = k();
        if (TextUtils.isEmpty(strK)) {
            f11345f = Boolean.FALSE;
            return false;
        }
        if (strK.startsWith("OriginOS") || strK.startsWith("Funtouch")) {
            f11345f = Boolean.TRUE;
            return true;
        }
        f11345f = Boolean.FALSE;
        return false;
    }

    public static boolean i() {
        Boolean bool = f11347h;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Boolean boolValueOf = Boolean.valueOf("harmony".equalsIgnoreCase((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            f11347h = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Throwable unused) {
            f11347h = Boolean.FALSE;
            return false;
        }
    }

    public static String j() {
        return a("hw_sc.build.platform.version");
    }

    public static String d() {
        if (TextUtils.isEmpty(f11340a)) {
            f11340a = Build.MODEL;
        }
        return f11340a;
    }

    private static int a(Object obj, String str) throws NoSuchFieldException {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception e2) {
            UPLog.e("DeviceConfig", e2);
            return -1;
        }
    }

    private static String a(String str) {
        try {
            return (String) ba.a("android.os.SystemProperties", "get", new Class[]{String.class}, null, new Object[]{str});
        } catch (Throwable unused) {
            return "";
        }
    }
}
