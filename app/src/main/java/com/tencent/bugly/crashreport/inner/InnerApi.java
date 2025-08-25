package com.tencent.bugly.crashreport.inner;

import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.proguard.an;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class InnerApi {
    public static void postCocos2dxCrashAsync(int i2, String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            an.e("post cocos2d-x fail args null", new Object[0]);
        } else if (i2 != 5 && i2 != 6) {
            an.e("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i2));
        } else {
            an.a("post cocos2d-x crash %s %s", str, str2);
            d.a(Thread.currentThread(), i2, str, str2, str3, null);
        }
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str == null || str2 == null || str3 == null) {
            an.e("post h5 fail args null", new Object[0]);
        } else {
            an.a("post h5 crash %s %s", str, str2);
            d.a(thread, 8, str, str2, str3, map);
        }
    }

    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            an.e("post u3d fail args null", new Object[0]);
        }
        an.a("post u3d crash %s %s", str, str2);
        d.a(Thread.currentThread(), 4, str, str2, str3, null);
    }
}
