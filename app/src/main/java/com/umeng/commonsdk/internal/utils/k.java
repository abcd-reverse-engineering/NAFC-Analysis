package com.umeng.commonsdk.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: UMProbe.java */
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    public static final String f10827b = "_dsk_s";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10828c = "_thm_z";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10829d = "_gdf_r";

    /* renamed from: a, reason: collision with root package name */
    public static final String f10826a = at.b().b(at.s);

    /* renamed from: e, reason: collision with root package name */
    private static Object f10830e = new Object();

    public static void b(final Context context) {
        if (c(context)) {
            return;
        }
        final String[] strArr = {"unknown", "unknown", "unknown"};
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.k.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = k.c();
                    strArr[1] = k.a();
                    strArr[2] = k.b();
                    ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    k.b(context, strArr);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f10826a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f10827b, ""))) ? false : true;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f10826a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (f10830e) {
                jSONObject.put(f10827b, sharedPreferences.getString(f10827b, ""));
                jSONObject.put(f10828c, sharedPreferences.getString(f10828c, ""));
                jSONObject.put(f10829d, sharedPreferences.getString(f10829d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f10826a, 0)) == null) {
            return;
        }
        synchronized (f10830e) {
            sharedPreferences.edit().putString(f10827b, strArr[0]).putString(f10828c, strArr[1]).putString(f10829d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L33
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = "/proc/diskstats"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L33
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L33
        Ld:
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = "mtd"
            java.lang.String r3 = "sda"
            java.lang.String r4 = "mmcblk"
            if (r0 == 0) goto L30
            boolean r5 = r0.contains(r4)     // Catch: java.lang.Throwable -> L34
            if (r5 == 0) goto L21
            r2 = r4
            goto L36
        L21:
            boolean r4 = r0.contains(r3)     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L29
            r2 = r3
            goto L36
        L29:
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto Ld
            goto L36
        L30:
            java.lang.String r2 = "unknown"
            goto L36
        L33:
            r1 = r0
        L34:
            java.lang.String r2 = "noper"
        L36:
            if (r1 == 0) goto L3b
            r1.close()     // Catch: java.lang.Throwable -> L3b
        L3b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.k.c():java.lang.String");
    }

    public static String b() {
        int iA;
        try {
            iA = a("ls /", "goldfish");
        } catch (Throwable unused) {
            iA = -1;
        }
        return iA > 0 ? "goldfish" : iA < 0 ? "noper" : "unknown";
    }

    public static int a(String str, String str2) throws IOException {
        int i2;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process processExec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                i2 = -1;
                break;
            }
            if (line.contains(str2)) {
                i2 = 1;
                break;
            }
        }
        try {
            if (processExec.waitFor() != 0) {
                return -1;
            }
            return i2;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int iA;
        try {
            iA = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            iA = -1;
        }
        return iA > 0 ? "thermal_zone" : iA < 0 ? "noper" : "unknown";
    }
}
