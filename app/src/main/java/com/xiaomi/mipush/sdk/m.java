package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class m {

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f12381a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f123a;

        /* renamed from: b, reason: collision with root package name */
        public String f12382b;

        /* renamed from: b, reason: collision with other field name */
        public boolean f124b;

        public b(String str, boolean z, boolean z2, String str2) {
            this.f12381a = str;
            this.f123a = z;
            this.f124b = z2;
            this.f12382b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, PackageInfo packageInfo) {
        boolean z;
        HashSet hashSet = new HashSet();
        String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
        hashSet.addAll(Arrays.asList("android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", str, "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE"));
        PermissionInfo[] permissionInfoArr = packageInfo.permissions;
        if (permissionInfoArr != null) {
            for (PermissionInfo permissionInfo : permissionInfoArr) {
                if (str.equals(permissionInfo.name)) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (!z) {
            throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", str));
        }
        String[] strArr = packageInfo.requestedPermissions;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && hashSet.contains(str2)) {
                    hashSet.remove(str2);
                    if (hashSet.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", hashSet.iterator().next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, PackageInfo packageInfo) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put(PushMessageHandler.class.getCanonicalName(), new b(PushMessageHandler.class.getCanonicalName(), true, true, ""));
        map2.put(MessageHandleService.class.getCanonicalName(), new b(MessageHandleService.class.getCanonicalName(), true, false, ""));
        if (!MiPushClient.shouldUseMIUIPush(context) || a(packageInfo, new String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"})) {
            map2.put("com.xiaomi.push.service.XMJobService", new b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
            map2.put("com.xiaomi.push.service.XMPushService", new b("com.xiaomi.push.service.XMPushService", true, false, ""));
        }
        if (MiPushClient.getOpenFCMPush(context)) {
            map2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new b("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", true, false, ""));
            map2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new b("com.xiaomi.assemble.control.MiFirebaseMessagingService", true, false, ""));
        }
        if (MiPushClient.getOpenOPPOPush(context)) {
            map2.put("com.xiaomi.assemble.control.COSPushMessageService", new b("com.xiaomi.assemble.control.COSPushMessageService", true, true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.name) && map2.containsKey(serviceInfo.name)) {
                    b bVar = (b) map2.remove(serviceInfo.name);
                    boolean z = bVar.f123a;
                    boolean z2 = bVar.f124b;
                    String str = bVar.f12382b;
                    if (z != serviceInfo.enabled) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", serviceInfo.name, Boolean.valueOf(z)));
                    }
                    if (z2 != serviceInfo.exported) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", serviceInfo.name, Boolean.valueOf(z2)));
                    }
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, serviceInfo.permission)) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", serviceInfo.name, str));
                    }
                    map.put(serviceInfo.name, serviceInfo.processName);
                    if (map2.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!map2.isEmpty()) {
            throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", map2.keySet().iterator().next()));
        }
        if (!TextUtils.equals((CharSequence) map.get(PushMessageHandler.class.getCanonicalName()), (CharSequence) map.get(MessageHandleService.class.getCanonicalName()))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName()));
        }
        if (map.containsKey("com.xiaomi.push.service.XMJobService") && map.containsKey("com.xiaomi.push.service.XMPushService") && !TextUtils.equals((CharSequence) map.get("com.xiaomi.push.service.XMJobService"), (CharSequence) map.get("com.xiaomi.push.service.XMPushService"))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"));
        }
    }

    public static void a(final Context context) {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.m.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4612);
                    m.c(context);
                    m.d(context, packageInfo);
                    m.c(context, packageInfo);
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    private static boolean a(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (a(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String[] strArr, String str) {
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ActivityInfo a(PackageManager packageManager, Intent intent, Class<?> cls) {
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    private static void a(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() == activityInfo.enabled) {
            if (boolArr[1].booleanValue() != activityInfo.exported) {
                throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", activityInfo.name, boolArr[1]));
            }
            return;
        }
        throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", activityInfo.name, boolArr[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00aa A[EDGE_INSN: B:44:0x00aa->B:30:0x00aa BREAK  A[LOOP:0: B:15:0x0076->B:47:0x0076], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0076 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r8) {
        /*
            java.lang.String r0 = "com.xiaomi.push.service.receivers.PingReceiver"
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = r8.getPackageName()
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = com.xiaomi.push.service.an.q
            r3.<init>(r4)
            r3.setPackage(r2)
            r4 = 1
            r5 = 0
            java.lang.Class r6 = com.xiaomi.push.C0343r.a(r8, r0)     // Catch: java.lang.ClassNotFoundException -> L5d
            android.content.pm.ActivityInfo r3 = a(r1, r3, r6)     // Catch: java.lang.ClassNotFoundException -> L5d
            boolean r6 = com.xiaomi.mipush.sdk.MiPushClient.shouldUseMIUIPush(r8)     // Catch: java.lang.ClassNotFoundException -> L5d
            r7 = 2
            if (r6 != 0) goto L49
            if (r3 == 0) goto L39
            java.lang.Boolean[] r0 = new java.lang.Boolean[r7]     // Catch: java.lang.ClassNotFoundException -> L5d
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.ClassNotFoundException -> L5d
            r0[r5] = r6     // Catch: java.lang.ClassNotFoundException -> L5d
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.ClassNotFoundException -> L5d
            r0[r4] = r6     // Catch: java.lang.ClassNotFoundException -> L5d
            a(r3, r0)     // Catch: java.lang.ClassNotFoundException -> L5d
            goto L61
        L39:
            com.xiaomi.mipush.sdk.m$a r3 = new com.xiaomi.mipush.sdk.m$a     // Catch: java.lang.ClassNotFoundException -> L5d
            java.lang.String r6 = "<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest."
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch: java.lang.ClassNotFoundException -> L5d
            r7[r5] = r0     // Catch: java.lang.ClassNotFoundException -> L5d
            java.lang.String r0 = java.lang.String.format(r6, r7)     // Catch: java.lang.ClassNotFoundException -> L5d
            r3.<init>(r0)     // Catch: java.lang.ClassNotFoundException -> L5d
            throw r3     // Catch: java.lang.ClassNotFoundException -> L5d
        L49:
            if (r3 == 0) goto L61
            java.lang.Boolean[] r0 = new java.lang.Boolean[r7]     // Catch: java.lang.ClassNotFoundException -> L5d
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.ClassNotFoundException -> L5d
            r0[r5] = r6     // Catch: java.lang.ClassNotFoundException -> L5d
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.ClassNotFoundException -> L5d
            r0[r4] = r6     // Catch: java.lang.ClassNotFoundException -> L5d
            a(r3, r0)     // Catch: java.lang.ClassNotFoundException -> L5d
            goto L61
        L5d:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)
        L61:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r3 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r0.<init>(r3)
            r0.setPackage(r2)
            r2 = 16384(0x4000, float:2.2959E-41)
            java.util.List r0 = r1.queryBroadcastReceivers(r0, r2)
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L76:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Laa
            java.lang.Object r2 = r0.next()
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            android.content.pm.ActivityInfo r2 = r2.activityInfo
            if (r2 == 0) goto La7
            java.lang.String r3 = r2.name     // Catch: java.lang.ClassNotFoundException -> La2
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.ClassNotFoundException -> La2
            if (r3 != 0) goto La7
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageReceiver> r3 = com.xiaomi.mipush.sdk.PushMessageReceiver.class
            java.lang.String r6 = r2.name     // Catch: java.lang.ClassNotFoundException -> La2
            java.lang.Class r6 = com.xiaomi.push.C0343r.a(r8, r6)     // Catch: java.lang.ClassNotFoundException -> La2
            boolean r3 = r3.isAssignableFrom(r6)     // Catch: java.lang.ClassNotFoundException -> La2
            if (r3 == 0) goto La7
            boolean r1 = r2.enabled     // Catch: java.lang.ClassNotFoundException -> La2
            if (r1 == 0) goto La7
            r1 = 1
            goto La8
        La2:
            r2 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r2)
            goto L76
        La7:
            r1 = 0
        La8:
            if (r1 == 0) goto L76
        Laa:
            if (r1 == 0) goto Lce
            boolean r0 = com.xiaomi.mipush.sdk.MiPushClient.getOpenHmsPush(r8)
            if (r0 == 0) goto Lc0
            java.lang.String r0 = "com.huawei.android.push.intent.RECEIVE"
            java.lang.String r1 = "com.xiaomi.assemble.control.HmsPushReceiver"
            a(r8, r0, r1)
            java.lang.String r0 = "com.huawei.intent.action.PUSH"
            java.lang.String r1 = "com.huawei.hms.support.api.push.PushEventReceiver"
            a(r8, r0, r1)
        Lc0:
            boolean r0 = com.xiaomi.mipush.sdk.MiPushClient.getOpenVIVOPush(r8)
            if (r0 == 0) goto Lcd
            java.lang.String r0 = "com.vivo.pushclient.action.RECEIVE"
            java.lang.String r1 = "com.xiaomi.assemble.control.FTOSPushMessageReceiver"
            a(r8, r0, r1)
        Lcd:
            return
        Lce:
            com.xiaomi.mipush.sdk.m$a r8 = new com.xiaomi.mipush.sdk.m$a
            java.lang.String r0 = "Receiver: none of the subclasses of PushMessageReceiver is enabled or defined."
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.m.c(android.content.Context):void");
    }

    private static void a(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        boolean z = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            z = (activityInfo == null || TextUtils.isEmpty(activityInfo.name) || !activityInfo.name.equals(str2)) ? false : true;
            if (z) {
                break;
            }
        }
        if (!z) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", str2));
        }
    }
}
