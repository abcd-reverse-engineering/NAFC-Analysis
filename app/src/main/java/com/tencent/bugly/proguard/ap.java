package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9256a = true;

    /* renamed from: b, reason: collision with root package name */
    private static SimpleDateFormat f9257b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f9258c = 5120;

    /* renamed from: d, reason: collision with root package name */
    private static StringBuilder f9259d = null;

    /* renamed from: e, reason: collision with root package name */
    private static StringBuilder f9260e = null;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f9261f = false;

    /* renamed from: g, reason: collision with root package name */
    private static a f9262g = null;

    /* renamed from: h, reason: collision with root package name */
    private static String f9263h = null;

    /* renamed from: i, reason: collision with root package name */
    private static String f9264i = null;

    /* renamed from: j, reason: collision with root package name */
    private static Context f9265j = null;

    /* renamed from: k, reason: collision with root package name */
    private static String f9266k = null;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f9267l = false;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f9268m = false;
    private static ExecutorService n;
    private static int o;
    private static final Object p = new Object();

    /* compiled from: BUGLY */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f9275a;

        /* renamed from: b, reason: collision with root package name */
        private File f9276b;

        /* renamed from: c, reason: collision with root package name */
        private String f9277c;

        /* renamed from: d, reason: collision with root package name */
        private long f9278d;

        /* renamed from: e, reason: collision with root package name */
        private long f9279e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f9277c = str;
            this.f9275a = a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                this.f9276b = new File(this.f9277c);
                if (this.f9276b.exists() && !this.f9276b.delete()) {
                    this.f9275a = false;
                    return false;
                }
                if (this.f9276b.createNewFile()) {
                    return true;
                }
                this.f9275a = false;
                return false;
            } catch (Throwable th) {
                an.a(th);
                this.f9275a = false;
                return false;
            }
        }

        public boolean a(String str) throws IOException {
            FileOutputStream fileOutputStream;
            if (!this.f9275a) {
                return false;
            }
            try {
                fileOutputStream = new FileOutputStream(this.f9276b, true);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f9278d += r10.length;
                this.f9275a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                try {
                    an.a(th);
                    this.f9275a = false;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    static {
        try {
            f9257b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(Context context) {
        if (f9267l || context == null || !f9256a) {
            return;
        }
        try {
            n = Executors.newSingleThreadExecutor();
            f9260e = new StringBuilder(0);
            f9259d = new StringBuilder(0);
            f9265j = context;
            com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
            f9263h = aVarA.f8978e;
            aVarA.getClass();
            f9264i = "";
            f9266k = f9265j.getFilesDir().getPath() + "/buglylog_" + f9263h + c.c.a.b.a.a.s1 + f9264i + ".txt";
            o = Process.myPid();
        } catch (Throwable unused) {
        }
        f9267l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str, String str2, String str3) {
        try {
            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
            if (aVarB == null || aVarB.O == null) {
                return false;
            }
            return aVarB.O.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (an.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void e(String str, String str2, String str3) {
        String strA = a(str, str2, str3, Process.myTid());
        synchronized (p) {
            try {
                f9260e.append(strA);
            } catch (Throwable unused) {
            }
            if (f9260e.length() <= f9258c) {
                return;
            }
            if (f9261f) {
                return;
            }
            f9261f = true;
            if (f9262g == null) {
                f9262g = new a(f9266k);
            } else if (f9262g.f9276b == null || f9262g.f9276b.length() + f9260e.length() > f9262g.f9279e) {
                f9262g.a();
            }
            if (f9262g.a(f9260e.toString())) {
                f9260e.setLength(0);
                f9261f = false;
            }
        }
    }

    private static String b() {
        try {
            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
            if (aVarB == null || aVarB.O == null) {
                return null;
            }
            return aVarB.O.getLogFromNative();
        } catch (Throwable th) {
            if (an.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static void a(int i2) {
        synchronized (p) {
            f9258c = i2;
            if (i2 < 0) {
                f9258c = 0;
            } else if (i2 > 10240) {
                f9258c = 10240;
            }
        }
    }

    public static void a(boolean z) {
        an.a("[LogUtil] Whether can record user log into native: " + z, new Object[0]);
        f9268m = z;
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + aq.b(th));
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        if (f9267l && f9256a) {
            try {
                if (f9268m) {
                    n.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ap.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ap.d(str, str2, str3)) {
                            }
                        }
                    });
                } else {
                    n.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ap.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ap.e(str, str2, str3);
                        }
                    });
                }
            } catch (Exception e2) {
                an.b(e2);
            }
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        String string;
        f9259d.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f9257b;
        if (simpleDateFormat != null) {
            string = simpleDateFormat.format(date);
        } else {
            string = date.toString();
        }
        StringBuilder sb = f9259d;
        sb.append(string);
        sb.append(c.c.a.b.a.a.f3100g);
        sb.append(o);
        sb.append(c.c.a.b.a.a.f3100g);
        sb.append(j2);
        sb.append(c.c.a.b.a.a.f3100g);
        sb.append(str);
        sb.append(c.c.a.b.a.a.f3100g);
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f9259d.toString();
    }

    public static byte[] a() {
        if (!f9256a) {
            return null;
        }
        if (f9268m) {
            an.a("[LogUtil] Get user log from native.", new Object[0]);
            String strB = b();
            if (strB != null) {
                an.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(strB.length()));
                return aq.a((File) null, strB, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (p) {
            if (f9262g != null && f9262g.f9275a && f9262g.f9276b != null && f9262g.f9276b.length() > 0) {
                sb.append(aq.a(f9262g.f9276b, 30720, true));
            }
            if (f9260e != null && f9260e.length() > 0) {
                sb.append(f9260e.toString());
            }
        }
        return aq.a((File) null, sb.toString(), "BuglyLog.txt");
    }
}
