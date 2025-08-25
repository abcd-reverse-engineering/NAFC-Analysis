package com.tencent.bugly.beta.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<Integer, b> f8844a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Integer, com.tencent.bugly.beta.global.d> f8845b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Integer, com.tencent.bugly.beta.global.d> f8846c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private static com.tencent.bugly.beta.global.d f8847d;

    public static synchronized void a(b bVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            a(bVar, z, false, com.heytap.mcssdk.constant.a.r);
        } else {
            try {
                ActivityManager activityManager = (ActivityManager) com.tencent.bugly.beta.global.e.G.u.getSystemService("activity");
                if (activityManager != null) {
                    activityManager.getRunningTasks(1);
                    a(bVar, z, false, com.heytap.mcssdk.constant.a.r);
                }
            } catch (SecurityException unused) {
                if (z) {
                    a(bVar, z, true, 0L);
                    return;
                }
                an.e("无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
                if (com.tencent.bugly.beta.upgrade.c.f8860a.f8861b != null && com.tencent.bugly.beta.upgrade.c.f8860a.f8861b.f8848a != null) {
                    c.f8829a.a(com.tencent.bugly.beta.upgrade.c.f8860a.f8861b.f8848a, bVar);
                }
            }
        }
    }

    public static synchronized boolean b() {
        String strA = a();
        if (strA == null || strA.equals("background") || strA.equals("unknown")) {
            return false;
        }
        Class<?> cls = null;
        try {
            cls = Class.forName(strA);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        if (!com.tencent.bugly.beta.global.e.G.o.isEmpty()) {
            for (Class<? extends Activity> cls2 : com.tencent.bugly.beta.global.e.G.o) {
                if (TextUtils.equals(cls2.getName(), strA) || (cls != null && cls2.isAssignableFrom(cls))) {
                    return true;
                }
            }
            return false;
        }
        if (com.tencent.bugly.beta.global.e.G.p.isEmpty()) {
            return true;
        }
        for (Class<? extends Activity> cls3 : com.tencent.bugly.beta.global.e.G.p) {
            if (TextUtils.equals(cls3.getName(), strA) || (cls != null && cls3.isAssignableFrom(cls))) {
                return false;
            }
        }
        return true;
    }

    public static synchronized void a(b bVar, boolean z, boolean z2, long j2) {
        if (bVar != null) {
            if (!bVar.b()) {
                int iHashCode = bVar.hashCode();
                if (bVar instanceof h) {
                    com.tencent.bugly.beta.utils.e.b(f8847d);
                    if (((h) bVar).p.f9481g == 2) {
                        f8847d = new com.tencent.bugly.beta.global.d(15, bVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                        com.tencent.bugly.beta.utils.e.a(f8847d, 3000L);
                    }
                    if (!z && !b()) {
                        com.tencent.bugly.beta.global.d dVar = f8845b.get(Integer.valueOf(iHashCode));
                        if (dVar == null) {
                            dVar = new com.tencent.bugly.beta.global.d(11, bVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                            f8845b.put(Integer.valueOf(iHashCode), dVar);
                        }
                        com.tencent.bugly.beta.utils.e.b(dVar);
                        com.tencent.bugly.beta.utils.e.a(dVar, j2);
                        return;
                    }
                    com.tencent.bugly.beta.utils.e.b(f8845b.remove(Integer.valueOf(iHashCode)));
                }
                if (!z2 && !aq.b(com.tencent.bugly.beta.global.e.G.u)) {
                    com.tencent.bugly.beta.global.d dVar2 = f8846c.get(Integer.valueOf(iHashCode));
                    if (dVar2 == null) {
                        dVar2 = new com.tencent.bugly.beta.global.d(11, bVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                        f8846c.put(Integer.valueOf(iHashCode), dVar2);
                    }
                    com.tencent.bugly.beta.utils.e.b(dVar2);
                    com.tencent.bugly.beta.utils.e.a(dVar2, j2);
                    return;
                }
                com.tencent.bugly.beta.utils.e.b(f8846c.remove(Integer.valueOf(iHashCode)));
                com.tencent.bugly.beta.global.d dVar3 = new com.tencent.bugly.beta.global.d(17, f8844a, Integer.valueOf(iHashCode), bVar);
                FragmentActivity activity = bVar.getActivity();
                if (activity != null) {
                    if (activity instanceof BetaActivity) {
                        ((BetaActivity) activity).onDestroyRunnable = dVar3;
                    } else {
                        com.tencent.bugly.beta.utils.e.a(dVar3, 400L);
                    }
                    activity.finish();
                } else {
                    dVar3.run();
                }
            }
        }
    }

    public static String a() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                return com.tencent.bugly.crashreport.common.info.a.b().w;
            }
            ActivityManager activityManager = (ActivityManager) com.tencent.bugly.beta.global.e.G.u.getSystemService("activity");
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty()) {
                return null;
            }
            return runningTasks.get(0).topActivity.getClassName();
        } catch (SecurityException unused) {
            an.e("无法获取Activity信息，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
            return null;
        } catch (Exception e2) {
            if (an.b(e2)) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }
}
