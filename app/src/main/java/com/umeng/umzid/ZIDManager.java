package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

/* loaded from: classes2.dex */
public class ZIDManager {

    /* renamed from: d, reason: collision with root package name */
    public static ZIDManager f11876d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11877a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11878b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11879c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f11880a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IZIDCompletionCallback f11881b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f11880a = context;
            this.f11881b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = ZIDManager.a(ZIDManager.this, this.f11880a);
            if (TextUtils.isEmpty(strA)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f11881b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f11881b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(strA);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f11883a;

        public b(Context context) {
            this.f11883a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.b(this.f11883a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f11885a;

        public c(Context context) {
            this.f11885a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f11885a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056 A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:6:0x0010, B:21:0x0056, B:22:0x005b, B:26:0x006b, B:28:0x008a, B:30:0x009f, B:32:0x00b4, B:33:0x00b7, B:35:0x00c3, B:36:0x00c6, B:38:0x00d2, B:39:0x00d5, B:19:0x0051), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:6:0x0010, B:21:0x0056, B:22:0x005b, B:26:0x006b, B:28:0x008a, B:30:0x009f, B:32:0x00b4, B:33:0x00b7, B:35:0x00c3, B:36:0x00c6, B:38:0x00d2, B:39:0x00d5, B:19:0x0051), top: B:50:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.String a(com.umeng.umzid.ZIDManager r10, android.content.Context r11) {
        /*
            boolean r0 = r10.f11877a
            r1 = 0
            if (r0 == 0) goto L7
            goto Ldf
        L7:
            r0 = 1
            r10.f11877a = r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r3 = 0
            java.lang.String r4 = com.umeng.umzid.Spy.getID()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "z"
            r2.put(r5, r4)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = com.umeng.umzid.d.e(r11)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r6 = "mc"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r6 = com.umeng.umzid.d.f(r11)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = "o"
            r2.put(r7, r6)     // Catch: java.lang.Throwable -> Ld9
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            r7.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r8 = "vpn_pxy"
            boolean r9 = com.umeng.umzid.d.i(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r8 = "wifi_pxy"
            boolean r9 = com.umeng.umzid.d.j(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r8 = "double"
            boolean r9 = com.umeng.umzid.d.g(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            goto L54
        L4c:
            r8 = move-exception
            goto L51
        L4e:
            r7 = move-exception
            r8 = r7
            r7 = r1
        L51:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> Ld9
        L54:
            if (r7 == 0) goto L5b
            java.lang.String r8 = "anti"
            r2.put(r8, r7)     // Catch: java.lang.Throwable -> Ld9
        L5b:
            r10.a(r11, r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = com.umeng.umzid.d.b(r11)     // Catch: java.lang.Throwable -> Ld9
            int r8 = r7.length()     // Catch: java.lang.Throwable -> Ld9
            if (r8 <= 0) goto L69
            goto L6b
        L69:
            java.lang.String r7 = "https://utoken.umeng.com"
        L6b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld9
            r8.<init>()     // Catch: java.lang.Throwable -> Ld9
            r8.append(r7)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = "/anti/postZdata"
            r8.append(r7)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = r8.toString()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = com.umeng.umzid.a.a(r7, r2)     // Catch: java.lang.Throwable -> Ld9
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Ld9
            if (r7 != 0) goto Ld5
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Ld9
            r7.<init>(r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = "suc"
            boolean r2 = r7.optBoolean(r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> Ld9
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> Ld9
            if (r2 != r0) goto Ld5
            com.umeng.umzid.d.f(r11, r4)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.umzid.d.a(r11, r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.umzid.d.b(r11, r6)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r0 = "aaid"
            java.lang.String r1 = r7.optString(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Ld9
            if (r0 != 0) goto Lb7
            com.umeng.umzid.d.e(r11, r1)     // Catch: java.lang.Throwable -> Ld9
        Lb7:
            java.lang.String r0 = "uabc"
            java.lang.String r0 = r7.optString(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r2 != 0) goto Lc6
            com.umeng.umzid.d.d(r11, r0)     // Catch: java.lang.Throwable -> Ld9
        Lc6:
            java.lang.String r0 = "resetToken"
            java.lang.String r0 = r7.optString(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r2 != 0) goto Ld5
            com.umeng.umzid.d.c(r11, r0)     // Catch: java.lang.Throwable -> Ld9
        Ld5:
            r10.a(r11)     // Catch: java.lang.Throwable -> Ld9
            goto Ldd
        Ld9:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> Le0
        Ldd:
            r10.f11877a = r3
        Ldf:
            return r1
        Le0:
            r11 = move-exception
            r10.f11877a = r3
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(com.umeng.umzid.ZIDManager, android.content.Context):java.lang.String");
    }

    public static void configureDomain(Context context, String str) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        String strB = d.b(str);
        if (context == null || strB == null || TextUtils.isEmpty(strB) || (sharedPreferencesA = com.umeng.umzid.a.a(context)) == null || (editorEdit = sharedPreferencesA.edit()) == null) {
            return;
        }
        editorEdit.putString("inputDomain", strB).commit();
    }

    public static synchronized ZIDManager getInstance() {
        if (f11876d == null) {
            f11876d = new ZIDManager();
        }
        return f11876d;
    }

    public static String getSDKVersion() {
        return "1.8.0";
    }

    public final void a(Context context) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod;
        Object objInvoke;
        Method declaredMethod2;
        try {
            Class<?> cls = Class.forName("com.uyumao.sdk.UYMManager");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0])) == null || (objInvoke = declaredMethod.invoke(cls, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("init", Context.class)) == null) {
                return;
            }
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(objInvoke, context);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f9 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:18:0x0038, B:20:0x003e, B:22:0x0046, B:24:0x0056, B:26:0x005c, B:28:0x0068, B:30:0x006e, B:32:0x007e, B:34:0x0084, B:36:0x0090, B:38:0x0096, B:41:0x00b9, B:43:0x00bf, B:44:0x00c3, B:46:0x00c9, B:61:0x00f9, B:62:0x00fe, B:66:0x010b, B:68:0x012a, B:70:0x013f, B:72:0x0152, B:73:0x0155, B:75:0x015f, B:76:0x0162, B:78:0x016c, B:79:0x016f, B:59:0x00f4), top: B:85:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012a A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:18:0x0038, B:20:0x003e, B:22:0x0046, B:24:0x0056, B:26:0x005c, B:28:0x0068, B:30:0x006e, B:32:0x007e, B:34:0x0084, B:36:0x0090, B:38:0x0096, B:41:0x00b9, B:43:0x00bf, B:44:0x00c3, B:46:0x00c9, B:61:0x00f9, B:62:0x00fe, B:66:0x010b, B:68:0x012a, B:70:0x013f, B:72:0x0152, B:73:0x0155, B:75:0x015f, B:76:0x0162, B:78:0x016c, B:79:0x016f, B:59:0x00f4), top: B:85:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.b(android.content.Context):java.lang.String");
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String strD = d.d(applicationContext);
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        com.umeng.umzid.c.a(new c(applicationContext));
        return "";
    }

    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        this.f11879c = d.h(context);
        if (this.f11879c) {
            if (context == null) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1001", "传入参数Context为null");
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1003", "传入参数appkey为空");
                }
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null && str != null && !TextUtils.isEmpty(str) && (sharedPreferencesA = com.umeng.umzid.a.a(applicationContext)) != null && (editorEdit = sharedPreferencesA.edit()) != null) {
                editorEdit.putString("appkey", str).commit();
            }
            String strD = d.d(applicationContext);
            if (strD == null || TextUtils.isEmpty(strD)) {
                com.umeng.umzid.c.a(new a(applicationContext, iZIDCompletionCallback));
            } else {
                com.umeng.umzid.c.a(new b(applicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(strD);
                }
            }
            SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
            if (TextUtils.isEmpty(sharedPreferencesA2 != null ? sharedPreferencesA2.getString("uuid", "") : "")) {
                String string = "";
                SharedPreferences sharedPreferencesA3 = com.umeng.umzid.a.a(context);
                try {
                    string = UUID.randomUUID().toString();
                } catch (Throwable unused) {
                }
                if (sharedPreferencesA3 != null) {
                    sharedPreferencesA3.edit().putString("uuid", string).commit();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject a(android.content.Context r9, org.json.JSONObject r10) throws org.json.JSONException, java.lang.NoSuchMethodException, android.content.res.Resources.NotFoundException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }
}
