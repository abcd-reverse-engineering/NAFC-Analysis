package com.vivo.push.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Utility.java */
/* loaded from: classes2.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f12250a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: b, reason: collision with root package name */
    private static String[] f12251b = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};

    /* renamed from: c, reason: collision with root package name */
    private static String[] f12252c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: d, reason: collision with root package name */
    private static String[] f12253d = {"com.vivo.push.sdk.RegistrationReceiver"};

    /* renamed from: e, reason: collision with root package name */
    private static String[] f12254e = new String[0];

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, Bundle> f12255f = new ConcurrentHashMap();

    public static long a(Context context) {
        String strA = aa.a(context);
        if (!TextUtils.isEmpty(strA)) {
            return a(context, strA);
        }
        u.a("Utility", "systemPushPkgName is null");
        return -1L;
    }

    public static String b(Context context, String str) throws PackageManager.NameNotFoundException {
        Object objA = a(context, str, "verification_status");
        return objA != null ? objA.toString() : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00af A[Catch: Exception -> 0x00cd, PHI: r2
  0x00af: PHI (r2v5 android.content.ContentProviderClient) = (r2v4 android.content.ContentProviderClient), (r2v8 android.content.ContentProviderClient) binds: [B:62:0x00ca, B:48:0x00ad] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {Exception -> 0x00cd, blocks: (B:45:0x00a6, B:47:0x00ab, B:49:0x00af, B:59:0x00c3, B:61:0x00c8), top: B:79:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c3 A[Catch: Exception -> 0x00cd, TRY_ENTER, TryCatch #1 {Exception -> 0x00cd, blocks: (B:45:0x00a6, B:47:0x00ab, B:49:0x00af, B:59:0x00c3, B:61:0x00c8), top: B:79:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c8 A[Catch: Exception -> 0x00cd, TRY_LEAVE, TryCatch #1 {Exception -> 0x00cd, blocks: (B:45:0x00a6, B:47:0x00ab, B:49:0x00af, B:59:0x00c3, B:61:0x00c8), top: B:79:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6 A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:67:0x00d1, B:69:0x00d6, B:71:0x00da), top: B:77:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.PublicKey c(android.content.Context r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.c(android.content.Context):java.security.PublicKey");
    }

    private static void d(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                throw new VivoPushException("serviceInfos is null");
            }
            for (String str2 : f12252c) {
                a(str2, serviceInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void e(Context context, String str) throws VivoPushException {
        if (f12254e.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr == null) {
                throw new VivoPushException("activityInfos is null");
            }
            for (String str2 : f12254e) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void f(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
            if (activityInfoArr == null) {
                throw new VivoPushException("receivers is null");
            }
            for (String str2 : f12253d) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int g(android.content.Context r3, java.lang.String r4) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            java.lang.String r0 = "Utility"
            r1 = 0
            if (r3 == 0) goto L46
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto Lc
            goto L46
        Lc:
            java.lang.String r2 = "sdk_version_vivo"
            java.lang.Object r3 = a(r3, r4, r2)
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L1b
            java.lang.String r3 = (java.lang.String) r3
        L18:
            r4 = r3
            r3 = 0
            goto L2f
        L1b:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L28
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r4 = ""
            goto L2f
        L28:
            if (r3 == 0) goto L45
            java.lang.String r3 = r3.toString()
            goto L18
        L2f:
            if (r3 <= 0) goto L32
            return r3
        L32:
            int r1 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Exception -> L37
            goto L45
        L37:
            r3 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "getClientSdkVersion: "
            java.lang.String r3 = r4.concat(r3)
            com.vivo.push.util.u.a(r0, r3)
        L45:
            return r1
        L46:
            java.lang.String r3 = "getClientSdkVersion() error, context is null or pkgName is empty"
            com.vivo.push.util.u.a(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.g(android.content.Context, java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fd, code lost:
    
        r12 = r12 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r20) throws android.content.pm.PackageManager.NameNotFoundException, com.vivo.push.util.VivoPushException {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.b(android.content.Context):void");
    }

    public static long a(Context context, String str) throws PackageManager.NameNotFoundException {
        Object objA = a(context, str, "com.vivo.push.sdk_version");
        if (objA == null) {
            objA = a(context, str, "sdk_version");
        }
        if (objA != null) {
            try {
                return Long.parseLong(objA.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                u.a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        u.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(android.content.Context r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.d(android.content.Context):boolean");
    }

    public static Object a(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Object obj = (f12255f == null || f12255f.size() <= 0 || (bundle = f12255f.get(str)) == null) ? null : bundle.get(str2);
            if (obj != null) {
                return obj;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                bundle = applicationInfo != null ? applicationInfo.metaData : null;
                Object obj2 = bundle != null ? bundle.get(str2) : obj;
                try {
                    if (f12255f.size() > 300) {
                        return obj2;
                    }
                    f12255f.put(str, bundle);
                    return obj2;
                } catch (Exception e2) {
                    bundle = obj2;
                    e = e2;
                    u.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                    return bundle;
                }
            } catch (Exception e3) {
                e = e3;
                bundle = obj;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    public static int c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int iA = (int) a(context, str);
            return iA <= 0 ? g(context, str) : iA;
        }
        u.a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
        return 0;
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f12250a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    private static void a(Context context, String str, String str2, boolean z) throws VivoPushException {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            if (z) {
                List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
                if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
                    Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
                    while (it.hasNext()) {
                        if (str2.equals(it.next().activityInfo.name)) {
                            return;
                        }
                    }
                    throw new VivoPushException(str2 + " is missing");
                }
                throw new VivoPushException("checkModule " + intent + " has no receivers");
            }
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                for (ResolveInfo resolveInfo : listQueryIntentServices) {
                    if (str2.equals(resolveInfo.serviceInfo.name)) {
                        if (resolveInfo.serviceInfo.exported) {
                            return;
                        }
                        throw new VivoPushException(resolveInfo.serviceInfo.name + " exported is false");
                    }
                }
                throw new VivoPushException(str2 + " is missing");
            }
            throw new VivoPushException("checkModule " + intent + " has no services");
        } catch (Exception e2) {
            u.a("Utility", "error  " + e2.getMessage());
            throw new VivoPushException("checkModule error" + e2.getMessage());
        }
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static void a(Context context, Intent intent) {
        String strA = aa.a(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(strA)) {
            u.a("Utility", "illegality abe adapter : push pkg is null");
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            u.a("Utility", "illegality abe adapter : src pkg is null");
            return;
        }
        if (strA.equals(context.getPackageName())) {
            u.a("Utility", "illegality abe adapter : abe is not pushservice");
            return;
        }
        if (!strA.equals(stringExtra)) {
            u.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + strA);
            intent.setPackage(strA);
            intent.setClassName(strA, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
            return;
        }
        u.a("Utility", "illegality abe adapter : pushPkg = " + strA + " ; srcPkg = " + stringExtra);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r17, java.lang.String r18, java.lang.String r19, long r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.a(android.content.Context, java.lang.String, java.lang.String, long):boolean");
    }

    public static boolean a(Context context, String str, boolean z) {
        Cursor cursorA;
        Cursor cursor = null;
        try {
        } catch (Exception e2) {
            u.a("Utility", "close", e2);
        }
        try {
            try {
                Uri uri = com.vivo.push.x.f12310e;
                String[] strArr = new String[2];
                strArr[0] = str;
                strArr[1] = z ? "1" : "0";
                cursorA = a(uri, "appPkgName = ? and agreePrivacyStatement = ? ", strArr, context);
            } catch (Exception e3) {
                u.a("Utility", "syncAgreePrivacyStatement", e3);
                if (0 != 0) {
                    cursor.close();
                }
            }
            if (cursorA == null) {
                u.a("Utility", "cursor is null");
                if (cursorA != null) {
                    try {
                        cursorA.close();
                    } catch (Exception e4) {
                        u.a("Utility", "close", e4);
                    }
                }
                return false;
            }
            if (!cursorA.moveToFirst()) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return false;
            }
            boolean z2 = Boolean.parseBoolean(cursorA.getString(cursorA.getColumnIndex("agreePrivacyStatement")));
            if (cursorA != null) {
                try {
                    cursorA.close();
                } catch (Exception e5) {
                    u.a("Utility", "close", e5);
                }
            }
            return z2;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e6) {
                    u.a("Utility", "close", e6);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.database.Cursor a(android.net.Uri r12, java.lang.String r13, java.lang.String[] r14, android.content.Context r15) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "close"
            r1 = 24
            r2 = 0
            java.lang.String r3 = "Utility"
            if (r15 != 0) goto Lf
            java.lang.String r12 = "context is null"
            com.vivo.push.util.u.a(r3, r12)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            return r2
        Lf:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r4 < r1) goto L2f
            android.content.ContentResolver r4 = r15.getContentResolver()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            android.content.ContentProviderClient r4 = r4.acquireUnstableContentProviderClient(r12)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r4 == 0) goto L2d
            java.lang.String r5 = "client is null"
            com.vivo.push.util.u.a(r3, r5)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L81
            r7 = 0
            r10 = 0
            r5 = r4
            r6 = r12
            r8 = r13
            r9 = r14
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L81
            goto L31
        L2d:
            r5 = r2
            goto L31
        L2f:
            r4 = r2
            r5 = r4
        L31:
            if (r5 != 0) goto L43
            android.content.ContentResolver r6 = r15.getContentResolver()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L81
            r8 = 0
            r11 = 0
            r7 = r12
            r9 = r13
            r10 = r14
            android.database.Cursor r5 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L81
            goto L43
        L41:
            r12 = move-exception
            goto L6d
        L43:
            if (r5 != 0) goto L59
            java.lang.String r12 = "cursor is null"
            com.vivo.push.util.u.a(r3, r12)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L81
            if (r4 == 0) goto L58
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L54
            if (r12 < r1) goto L58
            r4.close()     // Catch: java.lang.Exception -> L54
            goto L58
        L54:
            r12 = move-exception
            com.vivo.push.util.u.a(r3, r0, r12)
        L58:
            return r2
        L59:
            if (r4 == 0) goto L67
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L63
            if (r12 < r1) goto L67
            r4.close()     // Catch: java.lang.Exception -> L63
            goto L67
        L63:
            r12 = move-exception
            com.vivo.push.util.u.a(r3, r0, r12)
        L67:
            return r5
        L68:
            r12 = move-exception
            r4 = r2
            goto L82
        L6b:
            r12 = move-exception
            r4 = r2
        L6d:
            java.lang.String r13 = "queryContentResolver"
            com.vivo.push.util.u.a(r3, r13, r12)     // Catch: java.lang.Throwable -> L81
            if (r4 == 0) goto L80
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7c
            if (r12 < r1) goto L80
            r4.close()     // Catch: java.lang.Exception -> L7c
            goto L80
        L7c:
            r12 = move-exception
            com.vivo.push.util.u.a(r3, r0, r12)
        L80:
            return r2
        L81:
            r12 = move-exception
        L82:
            if (r4 == 0) goto L90
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L8c
            if (r13 < r1) goto L90
            r4.close()     // Catch: java.lang.Exception -> L8c
            goto L90
        L8c:
            r13 = move-exception
            com.vivo.push.util.u.a(r3, r0, r13)
        L90:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.a(android.net.Uri, java.lang.String, java.lang.String[], android.content.Context):android.database.Cursor");
    }
}
