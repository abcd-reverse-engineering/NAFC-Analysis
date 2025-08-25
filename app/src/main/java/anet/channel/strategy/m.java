package anet.channel.strategy;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.StrategyStatObject;
import anet.channel.util.ALog;
import anet.channel.util.SerializeHelper;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    private static File f2022a = null;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f2023b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Comparator<File> f2024c = new n();

    m() {
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                f2022a = new File(context.getFilesDir(), "awcn_strategy");
                if (!a(f2022a)) {
                    ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", f2022a.getAbsolutePath());
                }
                if (!GlobalAppRuntimeInfo.isTargetProcess()) {
                    String currentProcess = GlobalAppRuntimeInfo.getCurrentProcess();
                    f2022a = new File(f2022a, currentProcess.substring(currentProcess.indexOf(58) + 1));
                    if (!a(f2022a)) {
                        ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", f2022a.getAbsolutePath());
                    }
                }
                ALog.i("awcn.StrategySerializeHelper", "StrateyFolder", null, "path", f2022a.getAbsolutePath());
                if (!f2023b) {
                    c();
                } else {
                    a();
                    f2023b = false;
                }
            } catch (Throwable th) {
                ALog.e("awcn.StrategySerializeHelper", "StrategySerializeHelper initialize failed!!!", null, th, new Object[0]);
            }
        }
    }

    static synchronized File[] b() {
        if (f2022a == null) {
            return null;
        }
        File[] fileArrListFiles = f2022a.listFiles();
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, f2024c);
        }
        return fileArrListFiles;
    }

    static synchronized void c() {
        File[] fileArrB = b();
        if (fileArrB == null) {
            return;
        }
        int i2 = 0;
        for (File file : fileArrB) {
            if (!file.isDirectory()) {
                if (System.currentTimeMillis() - file.lastModified() > 172800000) {
                    file.delete();
                } else if (file.getName().startsWith("WIFI")) {
                    int i3 = i2 + 1;
                    if (i2 > 10) {
                        file.delete();
                    }
                    i2 = i3;
                }
            }
        }
    }

    private static boolean a(File file) {
        if (file == null || file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    public static File a(String str) {
        a(f2022a);
        return new File(f2022a, str);
    }

    static synchronized void a() {
        ALog.i("awcn.StrategySerializeHelper", "clear start.", null, new Object[0]);
        if (f2022a == null) {
            ALog.w("awcn.StrategySerializeHelper", "folder path not initialized, wait to clear", null, new Object[0]);
            f2023b = true;
            return;
        }
        File[] fileArrListFiles = f2022a.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.isFile()) {
                file.delete();
            }
        }
        ALog.i("awcn.StrategySerializeHelper", "clear end.", null, new Object[0]);
    }

    static synchronized void a(Serializable serializable, String str, StrategyStatObject strategyStatObject) {
        SerializeHelper.persist(serializable, a(str), strategyStatObject);
    }

    static synchronized <T> T a(String str, StrategyStatObject strategyStatObject) {
        return (T) SerializeHelper.restore(a(str), strategyStatObject);
    }
}
