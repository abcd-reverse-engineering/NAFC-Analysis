package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.aq;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class Bugly {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f8738a = false;
    public static Context applicationContext = null;
    public static boolean enable = true;

    public static synchronized String getAppChannel() {
        byte[] bArr;
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        if (aVarB == null) {
            return null;
        }
        if (TextUtils.isEmpty(aVarB.s)) {
            ae aeVarA = ae.a();
            if (aeVarA == null) {
                return aVarB.s;
            }
            Map<String, byte[]> mapA = aeVarA.a(556, (ad) null, true);
            if (mapA != null && (bArr = mapA.get("app_channel")) != null) {
                return new String(bArr);
            }
        }
        return aVarB.s;
    }

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static void putUserData(Context context, String str, String str2) {
        CrashReport.putUserData(context, str, str2);
    }

    public static void setAppChannel(Context context, String str) {
        CrashReport.setAppChannel(context, str);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        CrashReport.setIsDevelopmentDevice(context, z);
    }

    public static void setUserId(Context context, String str) {
        CrashReport.setUserId(context, str);
    }

    public static void setUserTag(Context context, int i2) {
        CrashReport.setUserSceneTag(context, i2);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        if (f8738a) {
            return;
        }
        f8738a = true;
        applicationContext = aq.a(context);
        if (applicationContext == null) {
            return;
        }
        b.a(CrashModule.getInstance());
        b.a(Beta.getInstance());
        b.f8757a = enable;
        b.a(applicationContext, str, z, buglyStrategy);
    }
}
