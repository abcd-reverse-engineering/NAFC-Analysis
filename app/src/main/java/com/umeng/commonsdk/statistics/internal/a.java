package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: HeaderHelper.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f10955a;

    /* renamed from: b, reason: collision with root package name */
    private String f10956b;

    /* renamed from: c, reason: collision with root package name */
    private String f10957c;

    /* compiled from: HeaderHelper.java */
    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    private static class C0144a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f10958a = new a();

        private C0144a() {
        }
    }

    public static a a(Context context) {
        if (f10955a == null && context != null) {
            f10955a = context.getApplicationContext();
        }
        return C0144a.f10958a;
    }

    private void f(String str) {
        try {
            this.f10956b = str.replaceAll("&=", c.c.a.b.a.a.f3100g).replaceAll("&&", c.c.a.b.a.a.f3100g).replaceAll("==", "/") + "/Android" + c.c.a.b.a.a.f3100g + HelperUtils.getUmengMD5(UMUtils.getAppkey(f10955a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f10955a, th);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] strArrSplit = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(bh.aT);
            for (String str3 : strArrSplit) {
                if (!TextUtils.isEmpty(str3)) {
                    String strSubstring = str3.substring(0, 2);
                    if (strSubstring.endsWith(ContainerUtils.KEY_VALUE_DELIMITER)) {
                        strSubstring = strSubstring.replace(ContainerUtils.KEY_VALUE_DELIMITER, "");
                    }
                    sb.append(strSubstring);
                }
            }
            this.f10957c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f10955a, th);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("t");
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bh.aG);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bh.aJ);
    }

    public void e(String str) {
        String strSubstring = str.substring(0, str.indexOf(95));
        g(strSubstring);
        f(strSubstring);
    }

    private a() {
        this.f10956b = null;
        this.f10957c = null;
    }

    public String b() {
        return this.f10956b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bh.ay);
    }

    public String a() {
        return this.f10957c;
    }
}
