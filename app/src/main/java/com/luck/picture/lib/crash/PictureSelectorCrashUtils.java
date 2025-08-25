package com.luck.picture.lib.crash;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.luck.picture.lib.app.PictureAppMaster;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class PictureSelectorCrashUtils {
    private static final String CRASH_HEAD;
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final Format FORMAT = new SimpleDateFormat("MM-dd HH-mm-ss", Locale.getDefault());
    private static final Thread.UncaughtExceptionHandler UNCAUGHT_EXCEPTION_HANDLER;
    private static String defaultDir;
    private static String dir;
    private static CrashAppListener mFinishAppListener;
    private static boolean mInitialized;
    private static int versionCode;
    private static String versionName;

    public interface CrashAppListener {
        void onFinishApp(Thread thread, Throwable th);
    }

    static {
        try {
            PackageInfo packageInfo = PictureAppMaster.getInstance().getAppContext().getPackageManager().getPackageInfo(PictureAppMaster.getInstance().getAppContext().getPackageName(), 0);
            if (packageInfo != null) {
                versionName = packageInfo.versionName;
                versionCode = packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        CRASH_HEAD = "\n************* Crash Log Head ****************\nDevice Manufacturer: " + Build.MANUFACTURER + "\nDevice Model       : " + Build.MODEL + "\nAndroid Version    : " + Build.VERSION.RELEASE + "\nAndroid SDK        : " + Build.VERSION.SDK_INT + "\nApp VersionName    : " + versionName + "\nApp VersionCode    : " + versionCode + "\n************* Crash Log Head ****************\n\n";
        UNCAUGHT_EXCEPTION_HANDLER = new Thread.UncaughtExceptionHandler() { // from class: com.luck.picture.lib.crash.PictureSelectorCrashUtils.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) throws Throwable {
                PrintWriter printWriter;
                if (PictureSelectorCrashUtils.mFinishAppListener != null) {
                    PictureSelectorCrashUtils.mFinishAppListener.onFinishApp(thread, th);
                }
                String str = PictureSelectorCrashUtils.FORMAT.format(new Date(System.currentTimeMillis())) + ".txt";
                StringBuilder sb = new StringBuilder();
                sb.append(PictureSelectorCrashUtils.dir == null ? PictureSelectorCrashUtils.defaultDir : PictureSelectorCrashUtils.dir);
                sb.append(str);
                String string = sb.toString();
                if (PictureSelectorCrashUtils.createOrExistsFile(string)) {
                    PrintWriter printWriter2 = null;
                    try {
                        try {
                            printWriter = new PrintWriter(new FileWriter(string, false));
                            try {
                                printWriter.write(PictureSelectorCrashUtils.CRASH_HEAD);
                                th.printStackTrace(printWriter);
                                for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                                    cause.printStackTrace(printWriter);
                                }
                                printWriter.close();
                            } catch (IOException e3) {
                                e = e3;
                                printWriter2 = printWriter;
                                e.printStackTrace();
                                if (printWriter2 != null) {
                                    printWriter2.close();
                                }
                                Process.killProcess(Process.myPid());
                                System.exit(0);
                            } catch (Throwable th2) {
                                th = th2;
                                if (printWriter != null) {
                                    printWriter.close();
                                }
                                throw th;
                            }
                        } catch (IOException e4) {
                            e = e4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        printWriter = printWriter2;
                    }
                }
                Process.killProcess(Process.myPid());
                System.exit(0);
            }
        };
        mFinishAppListener = null;
    }

    private PictureSelectorCrashUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean createOrExistsFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean init() {
        return init("", null);
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static void setCrashListener(CrashAppListener crashAppListener) {
        mFinishAppListener = crashAppListener;
    }

    public static boolean init(CrashAppListener crashAppListener) {
        return init("", crashAppListener);
    }

    public static boolean init(@NonNull File file) {
        return init(file.getAbsolutePath() + FILE_SEP, null);
    }

    public static boolean init(String str, CrashAppListener crashAppListener) {
        String str2;
        mFinishAppListener = crashAppListener;
        if (isSpace(str)) {
            dir = null;
        } else {
            if (str.endsWith(FILE_SEP)) {
                str2 = dir;
            } else {
                str2 = dir + FILE_SEP;
            }
            dir = str2;
        }
        if (mInitialized) {
            return true;
        }
        if ("mounted".equals(Environment.getExternalStorageState()) && PictureAppMaster.getInstance().getAppContext().getExternalCacheDir() != null) {
            defaultDir = PictureAppMaster.getInstance().getAppContext().getExternalCacheDir() + FILE_SEP + CrashHianalyticsData.EVENT_ID_CRASH + FILE_SEP;
        } else {
            defaultDir = PictureAppMaster.getInstance().getAppContext().getCacheDir() + FILE_SEP + CrashHianalyticsData.EVENT_ID_CRASH + FILE_SEP;
        }
        Thread.setDefaultUncaughtExceptionHandler(UNCAUGHT_EXCEPTION_HANDLER);
        mInitialized = true;
        return true;
    }
}
