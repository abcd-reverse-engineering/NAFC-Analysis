package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.xiaomi.mipush.sdk.Constants;
import d.d;
import java.io.File;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.a {

    /* renamed from: a, reason: collision with root package name */
    private static NativeCrashHandler f9141a = null;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f9142l = false;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f9143m = false;
    private static boolean o = true;

    /* renamed from: b, reason: collision with root package name */
    private final Context f9144b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f9145c;

    /* renamed from: d, reason: collision with root package name */
    private final am f9146d;

    /* renamed from: e, reason: collision with root package name */
    private NativeExceptionHandler f9147e;

    /* renamed from: f, reason: collision with root package name */
    private String f9148f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f9149g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9150h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f9151i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9152j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9153k = false;
    private com.tencent.bugly.crashreport.crash.b n;

    @SuppressLint({"SdCardPath"})
    protected NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, am amVar, boolean z, String str) {
        this.f9144b = aq.a(context);
        try {
            if (aq.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).f8977d + "/app_bugly";
        }
        this.n = bVar;
        this.f9148f = str;
        this.f9145c = aVar;
        this.f9146d = amVar;
        this.f9149g = z;
        this.f9147e = new a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, am amVar, boolean z, String str) {
        if (f9141a == null) {
            f9141a = new NativeCrashHandler(context, aVar, bVar, aVar2, amVar, z, str);
        }
        return f9141a;
    }

    public static boolean isShouldHandleInJava() {
        return o;
    }

    public static void setShouldHandleInJava(boolean z) {
        o = z;
        NativeCrashHandler nativeCrashHandler = f9141a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, "" + z);
        }
    }

    @Override // com.tencent.bugly.crashreport.a
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f9150h || this.f9151i) && f9142l && str != null && str2 != null && str3 != null) {
            try {
                if (this.f9151i) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) aq.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f9142l = false;
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f9146d.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (!aq.a(NativeCrashHandler.this.f9144b, "native_record_lock", com.heytap.mcssdk.constant.a.q)) {
                    an.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.o) {
                    NativeCrashHandler.this.a(999, a.a.u.a.f1254k);
                }
                CrashDetailBean crashDetailBeanA = b.a(NativeCrashHandler.this.f9144b, NativeCrashHandler.this.f9148f, NativeCrashHandler.this.f9147e);
                if (crashDetailBeanA != null) {
                    an.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.n.a(crashDetailBeanA)) {
                        NativeCrashHandler.this.n.a(crashDetailBeanA, 3000L, false);
                    }
                    b.a(false, NativeCrashHandler.this.f9148f);
                }
                NativeCrashHandler.this.b();
                aq.c(NativeCrashHandler.this.f9144b, "native_record_lock");
            }
        });
    }

    public boolean filterSigabrtSysLog() {
        return a(d.f13552h, a.a.u.a.f1253j);
    }

    public synchronized String getDumpFilePath() {
        return this.f9148f;
    }

    @Override // com.tencent.bugly.crashreport.a
    public String getLogFromNative() {
        if ((!this.f9150h && !this.f9151i) || !f9142l) {
            return null;
        }
        try {
            return this.f9151i ? getNativeLog() : (String) aq.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            f9142l = false;
            return null;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f9147e;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public synchronized boolean isUserOpened() {
        return this.f9153k;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:8:0x001a, B:10:0x0026, B:14:0x002d, B:16:0x0031), top: B:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void onStrategyChanged(com.tencent.bugly.crashreport.common.strategy.StrategyBean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L1a
            boolean r2 = r5.f8998g     // Catch: java.lang.Throwable -> L43
            boolean r3 = r4.f9152j     // Catch: java.lang.Throwable -> L43
            if (r2 == r3) goto L1a
            java.lang.String r2 = "server native changed to %b"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L43
            boolean r5 = r5.f8998g     // Catch: java.lang.Throwable -> L43
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L43
            r3[r1] = r5     // Catch: java.lang.Throwable -> L43
            com.tencent.bugly.proguard.an.d(r2, r3)     // Catch: java.lang.Throwable -> L43
        L1a:
            com.tencent.bugly.crashreport.common.strategy.a r5 = com.tencent.bugly.crashreport.common.strategy.a.a()     // Catch: java.lang.Throwable -> L43
            com.tencent.bugly.crashreport.common.strategy.StrategyBean r5 = r5.c()     // Catch: java.lang.Throwable -> L43
            boolean r5 = r5.f8998g     // Catch: java.lang.Throwable -> L43
            if (r5 == 0) goto L2c
            boolean r5 = r4.f9153k     // Catch: java.lang.Throwable -> L43
            if (r5 == 0) goto L2c
            r5 = 1
            goto L2d
        L2c:
            r5 = 0
        L2d:
            boolean r2 = r4.f9152j     // Catch: java.lang.Throwable -> L43
            if (r5 == r2) goto L41
            java.lang.String r2 = "native changed to %b"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L43
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L43
            r0[r1] = r3     // Catch: java.lang.Throwable -> L43
            com.tencent.bugly.proguard.an.a(r2, r0)     // Catch: java.lang.Throwable -> L43
            r4.b(r5)     // Catch: java.lang.Throwable -> L43
        L41:
            monitor-exit(r4)
            return
        L43:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.onStrategyChanged(com.tencent.bugly.crashreport.common.strategy.StrategyBean):void");
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f9150h || this.f9151i) && f9142l && str != null && str2 != null) {
            try {
                if (this.f9151i) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) aq.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f9142l = false;
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i2);

    public void removeEmptyNativeRecordFiles() {
        b.d(this.f9148f);
    }

    protected native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f9148f = str;
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    protected native void setNativeInfo(int i2, String str);

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? a.a.u.a.f1253j : a.a.u.a.f1254k);
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return a(15, String.valueOf(j2));
        } catch (NumberFormatException e2) {
            if (an.a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean zIsUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (aVarA != null) {
            zIsUserOpened = zIsUserOpened && aVarA.c().f8998g;
        }
        if (zIsUserOpened != this.f9152j) {
            an.a("native changed to %b", Boolean.valueOf(zIsUserOpened));
            b(zIsUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        String str;
        if (!this.f9151i && !this.f9150h) {
            String str2 = "Bugly";
            boolean z = !aq.a(this.f9145c.t);
            if (c.f9081b) {
                if (z) {
                    str = this.f9145c.t;
                } else {
                    str = "Bugly-rqd";
                }
                this.f9151i = a(str, z);
                if (!this.f9151i && !z) {
                    this.f9150h = a("NativeRQD", false);
                }
            } else {
                String str3 = this.f9145c.t;
                if (z) {
                    str2 = str3;
                } else {
                    this.f9145c.getClass();
                }
                this.f9151i = a(str2, z);
            }
            if (this.f9151i || this.f9150h) {
                a(this.f9149g);
                if (f9142l) {
                    setNativeAppVersion(this.f9145c.p);
                    setNativeAppChannel(this.f9145c.s);
                    setNativeAppPackage(this.f9145c.f8977d);
                    setNativeUserId(this.f9145c.g());
                    setNativeIsAppForeground(this.f9145c.a());
                    setNativeLaunchTime(this.f9145c.f8974a);
                }
                return;
            }
            return;
        }
        a(this.f9149g);
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (this.f9151i) {
            testCrash();
        } else {
            an.d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    protected native String unregist();

    protected void b() {
        long jB = aq.b() - c.f9086g;
        long jB2 = aq.b() + 86400000;
        File file = new File(this.f9148f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : fileArrListFiles) {
                        long jLastModified = file2.lastModified();
                        if (jLastModified < jB || jLastModified >= jB2) {
                            an.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    an.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                an.a(th);
            }
        }
    }

    private static void a(String str) {
        an.c("[Native] Check extra jni for Bugly NDK v%s", str);
        String strReplace = "2.1.1".replace(".", "");
        String strReplace2 = "2.3.0".replace(".", "");
        String strReplace3 = str.replace(".", "");
        if (strReplace3.length() == 2) {
            strReplace3 = strReplace3 + "0";
        } else if (strReplace3.length() == 1) {
            strReplace3 = strReplace3 + "00";
        }
        try {
            if (Integer.parseInt(strReplace3) >= Integer.parseInt(strReplace)) {
                f9142l = true;
            }
            if (Integer.parseInt(strReplace3) >= Integer.parseInt(strReplace2)) {
                f9143m = true;
            }
        } catch (Throwable unused) {
        }
        if (f9143m) {
            an.a("[Native] Info setting jni can be accessed.", new Object[0]);
        } else {
            an.d("[Native] Info setting jni can not be accessed.", new Object[0]);
        }
        if (f9142l) {
            an.a("[Native] Extra jni can be accessed.", new Object[0]);
        } else {
            an.d("[Native] Extra jni can not be accessed.", new Object[0]);
        }
    }

    private synchronized void c(boolean z) {
        if (this.f9153k != z) {
            an.a("user change native %b", Boolean.valueOf(z));
            this.f9153k = z;
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        return f9141a;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        a(16, "" + z);
        a(17, "" + z2);
        a(18, "" + z3);
        testNativeCrash();
    }

    protected synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            a();
        }
    }

    protected synchronized void a(boolean z) {
        if (this.f9152j) {
            an.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f9151i) {
            try {
                String strRegist = regist(this.f9148f, z, 1);
                if (strRegist != null) {
                    an.a("[Native] Native Crash Report enable.", new Object[0]);
                    a(strRegist);
                    this.f9145c.u = strRegist;
                    String strConcat = Constants.ACCEPT_TIME_SEPARATOR_SERVER.concat(this.f9145c.u);
                    if (!c.f9081b && !this.f9145c.f8983j.contains(strConcat)) {
                        this.f9145c.f8983j = this.f9145c.f8983j.concat(Constants.ACCEPT_TIME_SEPARATOR_SERVER).concat(this.f9145c.u);
                    }
                    an.a("comInfo.sdkVersion %s", this.f9145c.f8983j);
                    ap.a(f9142l);
                    this.f9152j = true;
                    return;
                }
            } catch (Throwable unused) {
                an.c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f9150h) {
            try {
                Class[] clsArr = {String.class, String.class, Integer.TYPE, Integer.TYPE};
                Object[] objArr = new Object[4];
                objArr[0] = this.f9148f;
                objArr[1] = com.tencent.bugly.crashreport.common.info.b.a(this.f9144b, false);
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str = (String) aq.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str == null) {
                    str = (String) aq.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{this.f9148f, com.tencent.bugly.crashreport.common.info.b.a(this.f9144b, false), Integer.valueOf(com.tencent.bugly.crashreport.common.info.a.b().K())});
                }
                if (str != null) {
                    this.f9152j = true;
                    this.f9145c.u = str;
                    Boolean bool = (Boolean) aq.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str});
                    if (bool != null) {
                        f9142l = bool.booleanValue();
                        ap.a(f9142l);
                    }
                    aq.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{true});
                    aq.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(z ? 1 : 5)});
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.f9151i = false;
        this.f9150h = false;
    }

    private boolean a(String str, boolean z) {
        boolean z2;
        try {
            an.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                an.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                an.d(th.getMessage(), new Object[0]);
                an.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    protected synchronized void a() {
        if (!this.f9152j) {
            an.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
        } catch (Throwable unused) {
            an.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        if (unregist() != null) {
            an.a("[Native] Successfully closed native crash report.", new Object[0]);
            this.f9152j = false;
            return;
        }
        try {
            aq.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
            this.f9152j = false;
            an.a("[Native] Successfully closed native crash report.", new Object[0]);
            return;
        } catch (Throwable unused2) {
            an.c("[Native] Failed to close native crash report.", new Object[0]);
            this.f9151i = false;
            this.f9150h = false;
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, String str) {
        if (this.f9151i && f9143m) {
            try {
                setNativeInfo(i2, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                f9143m = false;
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
