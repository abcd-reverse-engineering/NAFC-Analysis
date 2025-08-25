package util;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.webkit.WebView;
import com.bumptech.glide.load.p.b0.a;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.LollipopFixedWebView;
import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

/* compiled from: DataCleanManager.java */
/* loaded from: classes2.dex */
public class a1 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f20713a = "DataCleanManager";

    /* compiled from: DataCleanManager.java */
    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f20714a;

        a(File file) {
            this.f20714a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArrListFiles;
            File file = this.f20714a;
            if (file == null || !file.exists() || !this.f20714a.isDirectory() || (fileArrListFiles = this.f20714a.listFiles()) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file2 : this.f20714a.listFiles()) {
                if (file2.isDirectory()) {
                    a1.b(file2);
                    file2.delete();
                } else if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
    }

    public static void b(Context context) {
        b(context.getFilesDir());
    }

    public static long c(File file) {
        long jC = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                jC += fileArrListFiles[i2].isDirectory() ? c(fileArrListFiles[i2]) : fileArrListFiles[i2].length();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jC;
    }

    public static void d(Context context) {
        c(context);
        a(context);
        e(context);
        f(context);
    }

    public static void e(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.bumptech.glide.b.a(context).b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void f(Context context) {
        try {
            a(context, new LollipopFixedWebView(context.getApplicationContext()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static long g(Context context) {
        try {
            return c(new File(context.getCacheDir() + "/" + a.InterfaceC0059a.f4394b));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String h(Context context) {
        long jC = c(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            jC += c(context.getExternalCacheDir());
        }
        String str = "cacheSize==" + jC;
        return a(jC);
    }

    public static void a(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            b(context.getExternalCacheDir());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(File file) {
        new Thread(new a(file)).start();
    }

    public static void a(Context context, WebView webView) {
        try {
            AgentWebConfig.removeAllCookies(null);
            webView.getSettings().setCacheMode(2);
            context.deleteDatabase("webviewCache.db");
            context.deleteDatabase("webview.db");
            webView.clearCache(true);
            webView.clearHistory();
            webView.clearFormData();
            a(new File(AgentWebConfig.getCachePath(context)), 0);
        } catch (Exception e2) {
            if (AgentWebConfig.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(Context context) {
        b(context.getCacheDir());
    }

    public static int a(File file, int i2) {
        int iA;
        if (file != null) {
            String str = "dir:" + file.getAbsolutePath();
        }
        if (file == null || !file.isDirectory()) {
            return 0;
        }
        try {
            iA = 0;
            for (File file2 : file.listFiles()) {
                try {
                    if (file2.isDirectory()) {
                        iA += a(file2, i2);
                    }
                    if (file2.lastModified() < new Date().getTime() - (i2 * 86400000)) {
                        String str2 = "file name:" + file2.getName();
                        if (file2.delete()) {
                            iA++;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    String.format("Failed to clean the cache, result %s", e.getMessage());
                    return iA;
                }
            }
            return iA;
        } catch (Exception e3) {
            e = e3;
            iA = 0;
        }
    }

    public static String a(long j2) {
        String str = "size==" + j2;
        long j3 = j2 / 1024;
        double d2 = j3;
        if (d2 < 1.0d) {
            return j3 + "kB";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            return new BigDecimal(Double.toString(d2)).setScale(1, 4).toPlainString() + "KB";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            return new BigDecimal(Double.toString(d3)).setScale(1, 4).toPlainString() + "MB";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            return new BigDecimal(Double.toString(d4)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d5).setScale(2, 4).toPlainString() + "TB";
    }
}
