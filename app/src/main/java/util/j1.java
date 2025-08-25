package util;

import ui.Hicore;

/* compiled from: InstallUtil.java */
/* loaded from: classes2.dex */
public class j1 {
    public static long a() {
        try {
            return Hicore.getApp().getPackageManager().getPackageInfo(Hicore.getApp().getPackageName(), 0).firstInstallTime;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static long b() {
        try {
            return Hicore.getApp().getPackageManager().getPackageInfo(Hicore.getApp().getPackageName(), 0).lastUpdateTime;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static long c() {
        try {
            return u1.a(u1.r, 0L);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static boolean d() {
        return a() == b();
    }

    public static boolean e() {
        return c() != b();
    }
}
