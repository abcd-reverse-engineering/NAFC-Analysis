package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static String f13228a = null;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f902a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f13229b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f13230c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f13231d;

    /* renamed from: e, reason: collision with root package name */
    private static String f13232e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f13233f = String.valueOf((char) 2);

    /* renamed from: a, reason: collision with other field name */
    private static final String[] f903a = {d.d.D, "a-", "u-", "v-", "o-", "g-", "d-"};

    /* renamed from: a, reason: collision with other field name */
    private static final Set<String> f901a = new HashSet();

    static {
        f901a.add("com.xiaomi.xmsf");
        f901a.add("com.xiaomi.finddevice");
        f901a.add("com.miui.securitycenter");
        f902a = true;
    }

    private static double a(double d2) {
        int i2 = 1;
        while (true) {
            double d3 = i2;
            if (d3 >= d2) {
                return d3;
            }
            i2 <<= 1;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m615a(int i2) {
        if (i2 > 0) {
            String[] strArr = f903a;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
        }
        return f903a[0];
    }

    @Deprecated
    public static String a(Context context) {
        return null;
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String strTrim = str.trim();
        return strTrim.length() == 0 || strTrim.equalsIgnoreCase(c.c.a.b.a.a.f3101h) || strTrim.equalsIgnoreCase("unknown");
    }

    public static String c() {
        return b() + "KB";
    }

    @Deprecated
    public static String c(Context context) {
        return null;
    }

    public static String d() {
        return (a(Environment.getDataDirectory()) / 1024) + "KB";
    }

    @Deprecated
    public static String d(Context context) {
        return null;
    }

    @Deprecated
    public static String e(Context context) {
        return null;
    }

    @Deprecated
    public static String f(Context context) {
        return "";
    }

    public static synchronized String g(Context context) {
        if (f13232e != null) {
            return f13232e;
        }
        f13232e = bb.b(b(context) + a(context));
        return f13232e;
    }

    public static synchronized String h(Context context) {
        return bb.b(b(context) + ((String) null));
    }

    public static String i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    @Deprecated
    private static String j(Context context) {
        return "";
    }

    private static String k(Context context) {
        String string = context.getSharedPreferences("device_info", 0).getString("default_id", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strL = l(context);
        a(context, strL);
        return strL;
    }

    private static String l(Context context) {
        return ay.a(Build.BRAND + c.c.a.b.a.a.s1 + k.a() + c.c.a.b.a.a.s1 + Build.VERSION.SDK_INT + c.c.a.b.a.a.s1 + Build.VERSION.RELEASE + c.c.a.b.a.a.s1 + Build.VERSION.INCREMENTAL + c.c.a.b.a.a.s1 + a() + c.c.a.b.a.a.s1 + context.getPackageName() + c.c.a.b.a.a.s1 + System.currentTimeMillis() + c.c.a.b.a.a.s1 + bb.a(16));
    }

    /* renamed from: c, reason: collision with other method in class */
    private static boolean m621c(Context context) throws PackageManager.NameNotFoundException {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
            if (packageInfo != null && packageInfo.applicationInfo != null && packageInfo.applicationInfo.metaData != null && packageInfo.applicationInfo.metaData.containsKey("supportGetAndroidID")) {
                boolean z = packageInfo.applicationInfo.metaData.getBoolean("supportGetAndroidID", true);
                com.xiaomi.channel.commonutils.logger.b.m55b("DeviceInfo", "Get supportGetAndroidID from app metaData: " + z);
                return z;
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.c("DeviceInfo", "Check supportGetAndroidID from app metaData error: " + e2.getMessage());
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
            intent.setComponent(componentName);
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(componentName, 128);
            if (serviceInfo != null && serviceInfo.metaData != null && serviceInfo.metaData.containsKey("supportGetAndroidID")) {
                com.xiaomi.channel.commonutils.logger.b.m55b("DeviceInfo", "The metaData of XMPushService contains key supportGetAndroidID,so return false.");
                return false;
            }
        } catch (Exception e3) {
            com.xiaomi.channel.commonutils.logger.b.c("DeviceInfo", "Check supportGetAndroidID from XMPushService metaData error: " + e3.getMessage());
        }
        com.xiaomi.channel.commonutils.logger.b.m55b("DeviceInfo", "Not configure the metaData key of supportGetAndroidID，return true by default.");
        return true;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = f903a;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i2++;
        }
    }

    public static String b(Context context) {
        if (f13229b == null && f902a) {
            f902a = m621c(context);
            if (!f902a) {
                return null;
            }
            try {
                f13229b = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m50a("failure to get androidId: " + th);
            }
            return f13229b;
        }
        return f13229b;
    }

    public static synchronized String a(Context context, boolean z) {
        if (f13231d == null) {
            String strB = b(context);
            int i2 = 1;
            switch (1) {
                case 1:
                    String strC = "";
                    if (!j.m632d()) {
                        strC = z ? c(context) : j(context);
                    }
                    String strA = a(context);
                    if ((Build.VERSION.SDK_INT < 26) || !b(strC) || !b(strA)) {
                        strB = strC + strB + strA;
                        break;
                    }
                    break;
                case 2:
                    String strB2 = an.a(context).b();
                    if (!TextUtils.isEmpty(strB2)) {
                        strB = strB2 + strB;
                        i2 = 2;
                        break;
                    }
                case 3:
                case 4:
                    String strMo136a = an.a(context).mo136a();
                    if (!TextUtils.isEmpty(strMo136a) && !strMo136a.startsWith("00000000-0000-0000-0000-000000000000")) {
                        i2 = 4;
                        strB = strMo136a;
                        break;
                    }
                    break;
                case 5:
                    if (!TextUtils.isEmpty(strB)) {
                        i2 = 5;
                        break;
                    }
                case 6:
                    strB = k(context);
                    i2 = 6;
                    break;
                default:
                    strB = "";
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + i2);
            if (i2 == 3) {
                f13231d = strB;
            } else {
                f13231d = m615a(i2) + bb.b(strB);
            }
        }
        return f13231d;
    }

    public static int b() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String[] strArrSplit;
        int i2 = 0;
        if (new File("/proc/meminfo").exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            } catch (Exception unused) {
                bufferedReader = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
            try {
                String line = bufferedReader.readLine();
                if (!TextUtils.isEmpty(line) && (strArrSplit = line.split("\\s+")) != null && strArrSplit.length >= 2 && TextUtils.isDigitsOnly(strArrSplit[1])) {
                    i2 = Integer.parseInt(strArrSplit[1]);
                }
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return i2;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused4) {
            }
        }
        return i2;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static String m619b() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    @TargetApi(17)
    public static int a() {
        Object objA = aw.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (objA == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(objA)).intValue();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m620b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m614a() {
        return a(b()) + "GB";
    }

    private static float a(int i2) {
        float f2 = ((((((i2 + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m617a(Context context) {
        Intent intentA = m.a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), (String) null, (Handler) null);
        if (intentA == null) {
            return false;
        }
        int intExtra = intentA.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m616a() {
        return a() <= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m618a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) aw.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        return packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 8388608) != 8388608;
    }

    private static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info", 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", null))) {
            sharedPreferences.edit().putString("default_id", str).apply();
        } else {
            com.xiaomi.channel.commonutils.logger.b.m50a("default_id exist,do not change it.");
        }
    }
}
