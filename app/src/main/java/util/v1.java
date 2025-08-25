package util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.usage.StorageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import ui.Hicore;

/* compiled from: SystemUtils.java */
/* loaded from: classes2.dex */
public class v1 {

    /* renamed from: a, reason: collision with root package name */
    private static long f21010a;

    /* compiled from: SystemUtils.java */
    public interface a {
        void a();
    }

    public static final String a() {
        return Build.VERSION.SDK_INT < 29 ? ContextCompat.checkSelfPermission(Hicore.getApp(), util.permissionutil.a.f20916j) == 0 ? ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getDeviceId() : "" : Settings.System.getString(Hicore.getApp().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
    }

    public static String b() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            str = Build.MANUFACTURER;
        }
        if (TextUtils.isEmpty(str)) {
            str = Build.PRODUCT;
        }
        if (TextUtils.isEmpty(str)) {
            str = Build.MODEL;
        }
        if (TextUtils.isEmpty(str)) {
            str = Build.BOARD;
        }
        return TextUtils.isEmpty(str) ? Build.DEVICE : str;
    }

    public static String c() {
        return Build.VERSION.RELEASE;
    }

    public static String d() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()));
    }

    public static final String e() {
        String deviceId = Build.VERSION.SDK_INT < 29 ? ContextCompat.checkSelfPermission(Hicore.getApp(), util.permissionutil.a.f20916j) == 0 ? ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getDeviceId() : "" : Settings.System.getString(Hicore.getApp().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        return TextUtils.isEmpty(deviceId) ? m() : deviceId;
    }

    public static final String f() {
        return (Build.VERSION.SDK_INT >= 29 || ContextCompat.checkSelfPermission(Hicore.getApp(), util.permissionutil.a.f20916j) != 0) ? "" : ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getDeviceId();
    }

    private static String g() {
        try {
            return new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String h() throws SocketException {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            String str = "all:" + list.size();
            for (NetworkInterface networkInterface : list) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    String str2 = "macBytes:" + hardwareAddress.length + Constants.ACCEPT_TIME_SEPARATOR_SP + networkInterface.getName();
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String i() {
        return "Android " + c();
    }

    public static String j() {
        try {
            return ContextCompat.checkSelfPermission(Hicore.getApp(), util.permissionutil.a.f20916j) == 0 ? ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getLine1Number() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String k() {
        return Build.MODEL;
    }

    public static String l() {
        String strA;
        String strA2;
        String strB;
        String strB2;
        String strB3 = "";
        try {
            if (ContextCompat.checkSelfPermission(Hicore.getApp(), util.permissionutil.a.A) == 0 && ContextCompat.checkSelfPermission(Hicore.getApp(), util.permissionutil.a.z) == 0) {
                strA = f1.c(d.d.u, d.d.v);
                if (TextUtils.isEmpty(strA)) {
                    strA = p1.a(p1.z);
                    n1.b("1 encrypt uuid-->" + strA);
                    if (TextUtils.isEmpty(strA)) {
                        String string = UUID.randomUUID().toString();
                        try {
                            strB2 = u0.b(string, d.d.w, d.d.x);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            strB2 = "";
                        }
                        if (!TextUtils.isEmpty(strB2)) {
                            f1.a(d.d.u, d.d.v, strB2);
                            p1.a(p1.z, strB2);
                        }
                        n1.b("1 uuid-->" + string);
                        return string;
                    }
                    f1.a(d.d.u, d.d.v, strA);
                    n1.b("2 encrypt uuid-->" + strA);
                }
            } else {
                strA = p1.a(p1.z);
                n1.b("3 encrypt uuid-->" + strA);
                if (TextUtils.isEmpty(strA)) {
                    String string2 = UUID.randomUUID().toString();
                    try {
                        strB = u0.b(string2, d.d.w, d.d.x);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        strB = "";
                    }
                    if (!TextUtils.isEmpty(strB)) {
                        p1.a(p1.z, strB);
                    }
                    n1.b("2 uuid-->" + string2);
                    return string2;
                }
            }
        } catch (Exception unused) {
            strA = p1.a(p1.z);
        }
        n1.b("encrypt uuid-->" + strA);
        if (TextUtils.isEmpty(strA)) {
            strA2 = "";
        } else {
            try {
                strA2 = u0.a(strA, d.d.w, d.d.x);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(strA) || !TextUtils.isEmpty(strA2)) {
            n1.b("decrypt uuid-->" + strA2);
            return strA2;
        }
        String string3 = UUID.randomUUID().toString();
        try {
            strB3 = u0.b(string3, d.d.w, d.d.x);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        if (!TextUtils.isEmpty(strB3)) {
            p1.a(p1.z, strB3);
            if (ContextCompat.checkSelfPermission(Hicore.getApp(), util.permissionutil.a.A) == 0) {
                f1.a(d.d.u, d.d.v, strB3);
            }
        }
        n1.b("3 uuid-->" + string3);
        return string3;
    }

    public static String m() {
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        try {
            return new UUID(str.hashCode(), Build.class.getField("SERIAL").get(null).toString().hashCode()).toString();
        } catch (Exception unused) {
            return new UUID(str.hashCode(), "serial".hashCode()).toString();
        }
    }

    public static int n() {
        return com.hicorenational.antifraud.a.f5936e;
    }

    public static String o() {
        return com.hicorenational.antifraud.a.f5937f;
    }

    public static boolean p() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean q() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean r() {
        PowerManager powerManager = (PowerManager) Hicore.getApp().getSystemService("power");
        if (powerManager == null || Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return powerManager.isIgnoringBatteryOptimizations(Hicore.getApp().getPackageName());
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static void i(Context context) {
        try {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + Hicore.getApp().getPackageName()));
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void k(Context context) {
        Intent intent = new Intent();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            context.startActivity(intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName()));
            return;
        }
        if (i2 <= 22) {
            j(context);
            return;
        }
        try {
            intent.addFlags(CommonNetImpl.FLAG_AUTH);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            j(context);
        }
    }

    public static String d(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        long j2;
        long usableSpace;
        Iterator it;
        long jLongValue;
        long j3;
        long j4;
        Context context2 = context;
        StorageManager storageManager = (StorageManager) context2.getSystemService("storage");
        int i2 = Build.VERSION.SDK_INT;
        float f2 = 1024.0f;
        if (i2 < 23) {
            try {
                StorageVolume[] storageVolumeArr = (StorageVolume[]) StorageManager.class.getDeclaredMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]);
                if (storageVolumeArr != null) {
                    Method declaredMethod = null;
                    long totalSpace = 0;
                    usableSpace = 0;
                    for (StorageVolume storageVolume : storageVolumeArr) {
                        if (declaredMethod == null) {
                            declaredMethod = storageVolume.getClass().getDeclaredMethod("getPathFile", new Class[0]);
                        }
                        File file = (File) declaredMethod.invoke(storageVolume, new Object[0]);
                        totalSpace += file.getTotalSpace();
                        usableSpace += file.getUsableSpace();
                    }
                    j2 = totalSpace;
                } else {
                    j2 = 0;
                    usableSpace = 0;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("totalSize = ");
                float f3 = j2;
                sb.append(a(f3, 1024.0f));
                sb.append(" ,availableSize = ");
                sb.append(a(usableSpace, 1024.0f));
                n1.a("hsc", sb.toString());
                return a(f3, 1024.0f);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        try {
            long totalSpace2 = 0;
            long totalSpace3 = 0;
            for (Iterator it2 = ((List) StorageManager.class.getDeclaredMethod("getVolumes", new Class[0]).invoke(storageManager, new Object[0])).iterator(); it2.hasNext(); it2 = it) {
                Object next = it2.next();
                int i3 = next.getClass().getField("type").getInt(next);
                if (i3 == 1) {
                    if (i2 >= 26) {
                        it = it2;
                        jLongValue = a(context2, (String) next.getClass().getDeclaredMethod("getFsUuid", new Class[0]).invoke(next, new Object[0]));
                        f2 = 1000.0f;
                    } else {
                        it = it2;
                        jLongValue = i2 >= 25 ? ((Long) StorageManager.class.getMethod("getPrimaryStorageSize", new Class[0]).invoke(storageManager, new Object[0])).longValue() : 0L;
                    }
                    if (((Boolean) next.getClass().getDeclaredMethod("isMountedReadable", new Class[0]).invoke(next, new Object[0])).booleanValue()) {
                        File file2 = (File) next.getClass().getDeclaredMethod("getPath", new Class[0]).invoke(next, new Object[0]);
                        if (jLongValue == 0) {
                            jLongValue = file2.getTotalSpace();
                        }
                        long totalSpace4 = jLongValue - file2.getTotalSpace();
                        totalSpace3 += jLongValue - file2.getFreeSpace();
                        j3 = totalSpace2 + jLongValue;
                        j4 = totalSpace4;
                    } else {
                        j3 = totalSpace2;
                        j4 = 0;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("设备内存大小：");
                    float f4 = jLongValue;
                    sb2.append(a(f4, f2));
                    sb2.append("系统大小：");
                    sb2.append(a(j4, f2));
                    n1.a("hsc", sb2.toString());
                    n1.a("hsc", "totalSize = " + a(f4, f2) + " ,used(with system) = " + a(totalSpace3, f2) + " ,free = " + a(r5 - totalSpace3, f2));
                    totalSpace2 = j3;
                } else {
                    it = it2;
                    if (i3 == 0 && ((Boolean) next.getClass().getDeclaredMethod("isMountedReadable", new Class[0]).invoke(next, new Object[0])).booleanValue()) {
                        File file3 = (File) next.getClass().getDeclaredMethod("getPath", new Class[0]).invoke(next, new Object[0]);
                        totalSpace3 += file3.getTotalSpace() - file3.getFreeSpace();
                        totalSpace2 += file3.getTotalSpace();
                    }
                    context2 = context;
                }
                context2 = context;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("总内存 total = ");
            float f5 = totalSpace2;
            sb3.append(a(f5, f2));
            sb3.append("已用 used(with system) = ");
            sb3.append(a(totalSpace3, 1000.0f));
            sb3.append("可用 available = ");
            sb3.append(a(totalSpace2 - totalSpace3, f2));
            n1.a("hsc", sb3.toString());
            return a(f5, f2);
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static void g(Context context) {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            char c2 = 65535;
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1206476313) {
                if (iHashCode != -759499589) {
                    if (iHashCode == 3620012 && lowerCase.equals("vivo")) {
                        c2 = 2;
                    }
                } else if (lowerCase.equals("xiaomi")) {
                    c2 = 1;
                }
            } else if (lowerCase.equals("huawei")) {
                c2 = 0;
            }
            if (c2 == 0 || c2 == 1) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addFlags(CommonNetImpl.FLAG_AUTH);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(ComponentName.unflattenFromString("com.android.settings/.Settings$HighPowerApplicationsActivity"));
                context.startActivity(intent);
                return;
            }
            if (c2 != 2) {
                context.startActivity(new Intent("android.settings.SETTINGS"));
            } else {
                if (k1.c(context)) {
                    return;
                }
                k1.e(context);
            }
        } catch (Exception unused) {
            context.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    public static void j(Context context) {
        try {
            context.startActivity(new Intent("android.settings.SETTINGS"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean f(Context context) throws ClassNotFoundException {
        context.getResources().getIdentifier("config_showNavigationBar", "bool", DispatchConstants.ANDROID);
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "沉浸式");
            if ("1".equals(str)) {
                return false;
            }
            return "0".equals(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static String a(long j2) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j2));
    }

    public static void c(Context context, String str) {
        context.startActivity(Hicore.getApp().getPackageManager().getLaunchIntentForPackage(str));
    }

    public static synchronized String a(Context context) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
        return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
    }

    public static boolean e(Context context) throws SecurityException {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        return (runningTasks.isEmpty() || runningTasks.get(0).topActivity.getPackageName().equals(context.getPackageName())) ? false : true;
    }

    public static String b(Activity activity) {
        String strH;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            String strB = b((Context) activity);
            if (strB != null) {
                String str = "android 5.0以前的方式获取mac" + strB;
                if (!strB.replaceAll(Constants.COLON_SEPARATOR, "").equalsIgnoreCase("020000000000")) {
                    return strB;
                }
            }
        } else if (i2 >= 23 && i2 < 24) {
            String strG = g();
            if (strG != null) {
                String str2 = "android 6~7 的方式获取的mac" + strG;
                if (!strG.replaceAll(Constants.COLON_SEPARATOR, "").equalsIgnoreCase("020000000000")) {
                    return strG;
                }
            }
        } else if (Build.VERSION.SDK_INT >= 24 && (strH = h()) != null) {
            String str3 = "android 7以后 的方式获取的mac" + strH;
            if (!strH.replaceAll(Constants.COLON_SEPARATOR, "").equalsIgnoreCase("020000000000")) {
                return strH;
            }
        }
        return "";
    }

    public static void h(Context context) {
        try {
            switch (Build.MANUFACTURER.toLowerCase()) {
                case "samsung":
                    try {
                        a(context, "com.samsung.android.sm_cn", "com.samsung.android.sm.app.dashboard.SmartManagerDashBoardActivity");
                        return;
                    } catch (Exception unused) {
                        c(context, "com.samsung.android.sm");
                        return;
                    }
                case "huawei":
                    try {
                        a(context, "com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
                        return;
                    } catch (Exception unused2) {
                        a(context, "com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
                        return;
                    }
                case "xiaomi":
                    a(context, "com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
                    return;
                case "vivo":
                    try {
                        a(context, "com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity");
                        return;
                    } catch (Exception unused3) {
                        c(context, "com.iqoo.secure");
                        return;
                    }
                case "oppo":
                    try {
                        try {
                            try {
                                a(context, "com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity");
                                return;
                            } catch (Exception unused4) {
                                c(context, "com.coloros.phonemanager");
                                return;
                            }
                        } catch (Exception unused5) {
                            c(context, "com.coloros.safecenter");
                            return;
                        }
                    } catch (Exception unused6) {
                        c(context, "com.oppo.safe");
                        return;
                    }
                case "yulong":
                case "360":
                    a(context, "com.yulong.android.coolsafe", "com.yulong.android.coolsafe.ui.activity.autorun.AutoRunListActivity");
                    return;
                case "meizu":
                    try {
                        a(context, "com.meizu.safe", "com.meizu.safe.permission.SmartBGActivity");
                        return;
                    } catch (Exception unused7) {
                        c(context, "com.meizu.safe");
                        return;
                    }
                case "oneplus":
                    a(context, "com.oneplus.security", "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity");
                    return;
                case "smartisan":
                    c(context, "com.smartisanos.security");
                    return;
                case "letv":
                    try {
                        a(context, "com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity");
                        return;
                    } catch (Exception unused8) {
                        Intent intent = new Intent();
                        intent.addFlags(CommonNetImpl.FLAG_AUTH);
                        intent.setAction("com.letv.android.permissionautoboot");
                        context.startActivity(intent);
                        return;
                    }
                default:
                    Intent intent2 = new Intent();
                    if (Build.VERSION.SDK_INT >= 9) {
                        intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent2.setData(Uri.fromParts("package", context.getPackageName(), null));
                    } else if (Build.VERSION.SDK_INT <= 8) {
                        intent2.setAction("android.intent.action.VIEW");
                        intent2.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                        intent2.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
                    }
                    context.startActivity(intent2);
                    return;
            }
        } catch (Exception unused9) {
            context.startActivity(new Intent("android.settings.SETTINGS"));
        }
        context.startActivity(new Intent("android.settings.SETTINGS"));
    }

    @RequiresApi(api = 26)
    public static long a(Context context, String str) {
        UUID uuidFromString;
        try {
            if (str == null) {
                uuidFromString = StorageManager.UUID_DEFAULT;
            } else {
                uuidFromString = UUID.fromString(str);
            }
            return ((StorageStatsManager) context.getSystemService(StorageStatsManager.class)).getTotalBytes(uuidFromString);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static String a(float f2) {
        String[] strArr = {"B", "KB", "MB", "GB", "TB"};
        int i2 = 0;
        while (f2 > 1024.0f && i2 < 4) {
            f2 /= 1024.0f;
            i2++;
        }
        return String.format(Locale.getDefault(), " %.2f %s", Float.valueOf(f2), strArr[i2]);
    }

    public static String a(float f2, float f3) {
        String[] strArr = {"B", "KB", "MB", "GB", "TB"};
        int i2 = 0;
        while (f2 > f3 && i2 < 4) {
            f2 /= f3;
            i2++;
        }
        return String.format(Locale.getDefault(), " %.2f %s", Float.valueOf(f2), strArr[i2]);
    }

    private static String b(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        if (context == null || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI)) == null) {
            return null;
        }
        try {
            connectionInfo = wifiManager.getConnectionInfo();
        } catch (Exception unused) {
            connectionInfo = null;
        }
        if (connectionInfo == null) {
            return null;
        }
        String macAddress = connectionInfo.getMacAddress();
        return !TextUtils.isEmpty(macAddress) ? macAddress.toUpperCase(Locale.ENGLISH) : macAddress;
    }

    public static void a(Activity activity) {
        Configuration configuration = activity.getResources().getConfiguration();
        if (configuration.fontScale > 1.0f) {
            configuration.fontScale = 0.9f;
            DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
            activity.getBaseContext().getResources().updateConfiguration(configuration, displayMetrics);
        }
    }

    public static boolean b(long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = jCurrentTimeMillis - f21010a;
        if (0 < j3 && j3 < j2) {
            return true;
        }
        f21010a = jCurrentTimeMillis;
        return false;
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.addFlags(CommonNetImpl.FLAG_AUTH);
        context.startActivity(intent);
    }

    public static boolean b(Context context, String str) throws SecurityException {
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            for (int i2 = 0; i2 < runningServices.size(); i2++) {
                if (str.equals(runningServices.get(i2).service.getClassName())) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void l(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String strC = c(context);
                if (context.getPackageName().equals(strC)) {
                    return;
                }
                WebView.setDataDirectorySuffix(strC);
            }
        } catch (Exception unused) {
        }
    }
}
