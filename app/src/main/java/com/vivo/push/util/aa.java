package com.vivo.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import h.f1;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: PushPackageUtils.java */
/* loaded from: classes2.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f12235a;

    /* renamed from: b, reason: collision with root package name */
    private static String f12236b;

    public static com.vivo.push.model.b a(Context context, o oVar) throws PackageManager.NameNotFoundException {
        com.vivo.push.model.b bVarF;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.b bVarC = c(applicationContext);
        if (bVarC != null) {
            u.d("PushPackageUtils", "get system push info :".concat(String.valueOf(bVarC)));
            return bVarC;
        }
        List<String> listA = oVar.a(applicationContext);
        com.vivo.push.model.b bVarF2 = f(applicationContext, applicationContext.getPackageName());
        if (listA == null || listA.size() <= 0) {
            if (bVarF2 != null && bVarF2.d()) {
                bVarC = bVarF2;
            }
            u.a("PushPackageUtils", "findAllPushPackages error: find no package!");
        } else {
            com.vivo.push.model.b bVar = null;
            String strA = af.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(strA) || !a(applicationContext, strA, "com.vivo.pushservice.action.METHOD") || (bVarC = f(applicationContext, strA)) == null || !bVarC.d()) {
                bVarC = null;
            }
            if (bVarF2 == null || !bVarF2.d()) {
                bVarF2 = null;
            }
            if (bVarC == null) {
                bVarC = null;
            }
            if (bVarF2 != null && (bVarC == null || (!bVarF2.c() ? bVarC.c() || bVarF2.b() > bVarC.b() : bVarC.c() && bVarF2.b() > bVarC.b()))) {
                bVarC = bVarF2;
            }
            HashMap map = new HashMap();
            if (bVarC == null) {
                bVarC = null;
            } else if (bVarC.c()) {
                bVar = bVarC;
                bVarC = null;
            }
            int size = listA.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = listA.get(i2);
                if (!TextUtils.isEmpty(str) && (bVarF = f(applicationContext, str)) != null) {
                    map.put(str, bVarF);
                    if (bVarF.d()) {
                        if (bVarF.c()) {
                            if (bVar == null || bVarF.b() > bVar.b()) {
                                bVar = bVarF;
                            }
                        } else if (bVarC == null || bVarF.b() > bVarC.b()) {
                            bVarC = bVarF;
                        }
                    }
                }
            }
            if (bVarC == null) {
                u.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                bVarC = bVar;
            }
        }
        if (bVarC == null) {
            u.b(applicationContext, "查找最优包为空!");
            u.d("PushPackageUtils", "finSuitablePushPackage is null");
        } else if (bVarC.c()) {
            u.a(applicationContext, "查找最优包为:" + bVarC.a() + "(" + bVarC.b() + ", Black)");
            u.d("PushPackageUtils", "finSuitablePushPackage" + bVarC.a() + "(" + bVarC.b() + ", Black)");
        } else {
            u.a(applicationContext, "查找最优包为:" + bVarC.a() + "(" + bVarC.b() + ")");
            u.d("PushPackageUtils", "finSuitablePushPackage" + bVarC.a() + "(" + bVarC.b() + ")");
        }
        return bVarC;
    }

    public static boolean b(Context context) {
        ProviderInfo providerInfoResolveContentProvider;
        Boolean bool = f12235a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = providerInfoResolveContentProvider.packageName;
        }
        Boolean boolValueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
        f12235a = boolValueOf;
        return boolValueOf.booleanValue();
    }

    private static com.vivo.push.model.b c(Context context) throws PackageManager.NameNotFoundException {
        String strA = a(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        com.vivo.push.model.b bVar = new com.vivo.push.model.b(strA);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(strA, 128);
            if (packageInfo != null) {
                bVar.a(packageInfo.versionCode);
                bVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                bVar.a(ag.a(context, strA));
            }
            bVar.a(a(context, bVar.b()));
            bVar.b(a(context, strA));
            return bVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e2);
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    public static boolean e(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    private static com.vivo.push.model.b f(Context context, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                com.vivo.push.model.b bVar = new com.vivo.push.model.b(str);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                    if (packageInfo != null) {
                        bVar.a(packageInfo.versionCode);
                        bVar.a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        bVar.a(ag.a(context, str));
                    }
                    bVar.b(a(context, str));
                    bVar.a(a(context, bVar.b()));
                    return bVar;
                } catch (Exception e2) {
                    u.a("PushPackageUtils", "getPushPackageInfo exception: ", e2);
                }
            }
        }
        return null;
    }

    private static String g(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                byte[] bArrDigest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : bArrDigest) {
                    String upperCase = Integer.toHexString(b2 & f1.f16099c).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e2) {
                u.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e2)));
            }
        }
        return null;
    }

    public static int b(Context context, String str) {
        int i2 = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i2;
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0139 A[Catch: Exception -> 0x0135, TryCatch #4 {Exception -> 0x0135, blocks: (B:104:0x0131, B:108:0x0139, B:110:0x013d), top: B:121:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.aa.a(android.content.Context):java.lang.String");
    }

    public static boolean a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                int size = listQueryIntentServices.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    ResolveInfo resolveInfo = listQueryIntentServices.get(i2);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z2 = resolveInfo.serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                            boolean z3 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            boolean z4 = true;
                            if (componentEnabledSetting != 1 && (componentEnabledSetting != 0 || !z3)) {
                                z4 = false;
                            }
                            z = z4;
                        }
                    }
                }
                return z;
            }
            u.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static boolean a(Context context, long j2) throws NoSuchMethodException, SecurityException {
        com.vivo.push.cache.d dVarA = com.vivo.push.cache.b.a().a(context);
        if (dVarA != null) {
            return dVarA.isInBlackList(j2);
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> listQueryBroadcastReceivers;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            listQueryBroadcastReceivers = null;
        }
        return listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0;
    }
}
