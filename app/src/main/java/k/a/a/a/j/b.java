package k.a.a.a.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import cn.cloudwalk.util.LogUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: ILogX.java */
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f17035a = "";

    public static String a() {
        return f17035a;
    }

    abstract void a(String str, String str2);

    abstract void b(String str, String str2);

    abstract void c(String str, String str2);

    /* compiled from: ILogX.java */
    static class a {
        private static boolean a() {
            return "mounted".equals(Environment.getExternalStorageState()) || !b();
        }

        static String b(Context context) {
            String str = c(context) + "/Log/";
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return str;
            }
            return null;
        }

        private static String c(Context context) {
            try {
                return context.getFilesDir().getCanonicalPath();
            } catch (IOException unused) {
                e.b("ILogX", "getCanonicalPath is IOException", true);
                return null;
            }
        }

        static String d(Context context) {
            String str = e(context) + "/Log/";
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return str;
            }
            return null;
        }

        private static String e(Context context) {
            File externalFilesDir;
            if (a() && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                try {
                    return externalFilesDir.getCanonicalPath();
                } catch (IOException unused) {
                    e.b("ILogX", LogUtils.LOG_EXCEPTION, true);
                }
            }
            return null;
        }

        public static void a(Context context) {
            String strD = d(context);
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            e.b("ILogX", "deleteOldLogFiles File", true);
            File file = new File(strD);
            if (file.exists() && file.isDirectory()) {
                a(file);
            }
        }

        @TargetApi(9)
        private static boolean b() {
            if (Build.VERSION.SDK_INT >= 9) {
                return Environment.isExternalStorageRemovable();
            }
            return true;
        }

        private static void a(File file) {
            if (file == null) {
                e.b("ILogX", "deleteDirInnerPicFileDir == null", true);
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.getName().contains("apphnid.txt") || file2.getName().contains("apphnid.txt.bak") || file2.getName().contains("honorid_advanced_log.txt")) {
                    file2.delete();
                }
            }
        }
    }

    static String a(Context context) throws PackageManager.NameNotFoundException {
        String str;
        if (context == null || !k.a.a.a.e.a(context).a().equals(context.getPackageName())) {
            str = "";
        } else {
            try {
                str = "HONORID_APK_log[" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName + "]:";
            } catch (PackageManager.NameNotFoundException e2) {
                String str2 = "getVersionTag error" + e2.getClass().getSimpleName();
            }
        }
        return TextUtils.isEmpty(str) ? "HonorID_openSDK_log[6.0.3.004]" : str;
    }
}
