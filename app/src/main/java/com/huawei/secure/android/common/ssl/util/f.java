package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7665a = "f";

    public static String a(String str) {
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            return "";
        }
        try {
            return contextUtil.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e.b(f7665a, "getVersion NameNotFoundException : " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            e.b(f7665a, "getVersion: " + e3.getMessage());
            return "";
        } catch (Throwable unused) {
            e.b(f7665a, "throwable");
            return "";
        }
    }

    public static int b(String str) {
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            return 0;
        }
        try {
            return contextUtil.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            e.b(f7665a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e2) {
            e.b(f7665a, "getVersion: " + e2.getMessage());
            return 0;
        }
    }
}
