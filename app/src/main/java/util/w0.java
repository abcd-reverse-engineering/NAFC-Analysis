package util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: AntiHijackingUtil.java */
/* loaded from: classes2.dex */
public class w0 {

    /* renamed from: b, reason: collision with root package name */
    public static final String f21013b = "AntiHijackingUtil";

    /* renamed from: c, reason: collision with root package name */
    private static List<String> f21014c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    static List<ApplicationInfo> f21015d;

    /* renamed from: e, reason: collision with root package name */
    private static PackageManager f21016e;

    /* renamed from: a, reason: collision with root package name */
    private List<ApplicationInfo> f21017a;

    public static void a(List<String> list) {
    }

    @SuppressLint({"NewApi"})
    public static boolean a(Context context) {
        int iIntValue;
        boolean zEquals = false;
        if (context == null) {
            return false;
        }
        try {
            f21016e = context.getPackageManager();
            if (f21015d == null || f21015d.size() == 0) {
                List<ApplicationInfo> installedApplications = f21016e.getInstalledApplications(8192);
                Collections.sort(installedApplications, new ApplicationInfo.DisplayNameComparator(f21016e));
                f21015d = installedApplications;
            }
            for (ApplicationInfo applicationInfo : f21015d) {
                if ((1 & applicationInfo.flags) != 0) {
                    f21014c.add(applicationInfo.packageName);
                }
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            try {
                iIntValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            } catch (NumberFormatException unused) {
                iIntValue = 0;
            }
            String strB = iIntValue >= 21 ? b(context) : activityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
            if (strB != null) {
                zEquals = strB.equals(context.getPackageName());
                Iterator<String> it = f21014c.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(strB)) {
                        zEquals = true;
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return zEquals;
    }

    public static String b(Context context) throws NoSuchFieldException {
        Field declaredField;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        Integer numValueOf;
        try {
            declaredField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
        } catch (Exception e2) {
            e2.printStackTrace();
            declaredField = null;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        int i2 = 0;
        while (true) {
            if (i2 >= runningAppProcesses.size()) {
                runningAppProcessInfo = null;
                break;
            }
            runningAppProcessInfo = runningAppProcesses.get(i2);
            if (runningAppProcessInfo.importance == 100) {
                try {
                    numValueOf = Integer.valueOf(declaredField.getInt(runningAppProcessInfo));
                } catch (Exception e3) {
                    e3.printStackTrace();
                    numValueOf = null;
                }
                if (numValueOf != null && numValueOf.intValue() == 2) {
                    break;
                }
            }
            i2++;
        }
        if (runningAppProcessInfo != null) {
            return runningAppProcessInfo.processName;
        }
        return null;
    }
}
