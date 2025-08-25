package com.alibaba.sdk.android.utils.crashdefend;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashDefendUtils.java */
/* loaded from: classes.dex */
class e {
    static void a(Context context, a aVar, List<c> list) {
        if (context == null) {
            return;
        }
        synchronized (list) {
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (aVar != null) {
                        jSONObject.put("startSerialNumber", aVar.f4133a);
                    }
                    if (list != null) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            for (c cVar : list) {
                                if (cVar != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("sdkId", cVar.f52a);
                                    jSONObject2.put("sdkVersion", cVar.f54b);
                                    jSONObject2.put("crashLimit", cVar.f4139a);
                                    jSONObject2.put("crashCount", cVar.crashCount);
                                    jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, cVar.f4140b);
                                    jSONObject2.put("registerSerialNumber", cVar.f53b);
                                    jSONObject2.put("startSerialNumber", cVar.f50a);
                                    jSONObject2.put("restoreCount", cVar.f4141c);
                                    jSONArray.put(jSONObject2);
                                }
                            }
                            jSONObject.put("sdkList", jSONArray);
                        } catch (JSONException unused) {
                        }
                    }
                    String string = jSONObject.toString();
                    fileOutputStreamOpenFileOutput = m34a(context) ? context.openFileOutput("com_alibaba_aliyun_crash_defend_sdk_info", 0) : context.openFileOutput("com_alibaba_aliyun_crash_defend_sdk_info_" + a(context), 0);
                    fileOutputStreamOpenFileOutput.write(string.getBytes());
                } catch (IOException unused2) {
                    if (fileOutputStreamOpenFileOutput != null) {
                    }
                } catch (Exception unused3) {
                    if (fileOutputStreamOpenFileOutput != null) {
                    }
                } catch (Throwable th) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused5) {
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        int iMyPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    private static String c(Context context) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e2) {
            String str = "getProcessNameByActivityThread error: " + e2;
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    static boolean m35a(Context context, a aVar, List<c> list) {
        if (context == null) {
            return false;
        }
        FileInputStream fileInputStreamOpenFileInput = null;
        StringBuilder sb = new StringBuilder();
        synchronized (list) {
            try {
                try {
                    fileInputStreamOpenFileInput = m34a(context) ? context.openFileInput("com_alibaba_aliyun_crash_defend_sdk_info") : context.openFileInput("com_alibaba_aliyun_crash_defend_sdk_info_" + a(context));
                    byte[] bArr = new byte[512];
                    while (true) {
                        int i2 = fileInputStreamOpenFileInput.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, i2));
                    }
                } catch (FileNotFoundException e2) {
                    String str = "load sdk file fail:" + e2.getMessage();
                    if (fileInputStreamOpenFileInput != null) {
                    }
                } catch (IOException unused) {
                    if (fileInputStreamOpenFileInput != null) {
                    }
                } catch (Exception unused2) {
                    if (fileInputStreamOpenFileInput != null) {
                    }
                }
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused3) {
                    }
                }
                if (sb.length() == 0) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    aVar.f4133a = jSONObject.optLong("startSerialNumber", 1L);
                    JSONArray jSONArray = jSONObject.getJSONArray("sdkList");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        if (jSONObject2 != null) {
                            c cVar = new c();
                            cVar.f52a = jSONObject2.optString("sdkId", "");
                            cVar.f54b = jSONObject2.optString("sdkVersion", "");
                            cVar.f4139a = jSONObject2.optInt("crashLimit", -1);
                            cVar.crashCount = jSONObject2.optInt("crashCount", 0);
                            cVar.f4140b = jSONObject2.optInt(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, 0);
                            cVar.f53b = jSONObject2.optLong("registerSerialNumber", 0L);
                            cVar.f50a = jSONObject2.optLong("startSerialNumber", 0L);
                            cVar.f4141c = jSONObject2.optInt("restoreCount", 0);
                            if (!TextUtils.isEmpty(cVar.f52a)) {
                                list.add(cVar);
                            }
                        }
                    }
                } catch (JSONException | Exception unused4) {
                }
                return true;
            } catch (Throwable th) {
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m34a(Context context) {
        return context.getPackageName().equalsIgnoreCase(a(context));
    }

    private static String a(Context context) throws Throwable {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        String strC = c(context);
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strA = a();
        return !TextUtils.isEmpty(strA) ? strA : b(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a() throws java.lang.Throwable {
        /*
            int r0 = android.os.Process.myPid()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r3.<init>()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r3.append(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r0 = "/cmdline"
            r3.append(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r0 == 0) goto L3b
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L61
            java.lang.String r1 = r2.trim()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L61
            goto L3c
        L39:
            r2 = move-exception
            goto L4b
        L3b:
            r0 = r1
        L3c:
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.io.IOException -> L42
            goto L60
        L42:
            r0 = move-exception
            r0.printStackTrace()
            goto L60
        L47:
            r0 = move-exception
            goto L65
        L49:
            r2 = move-exception
            r0 = r1
        L4b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L61
            java.lang.String r4 = "getProcessNameByPid error: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L61
            r3.append(r2)     // Catch: java.lang.Throwable -> L61
            r3.toString()     // Catch: java.lang.Throwable -> L61
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.io.IOException -> L42
        L60:
            return r1
        L61:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L65:
            if (r1 == 0) goto L6f
            r1.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r1 = move-exception
            r1.printStackTrace()
        L6f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.e.a():java.lang.String");
    }
}
