package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: EncryptHelper.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f10638a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f10639b = "umeng+";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10640c = "ek__id";

    /* renamed from: d, reason: collision with root package name */
    private static final String f10641d = "ek_key";

    /* renamed from: e, reason: collision with root package name */
    private static String f10642e = "";

    /* renamed from: f, reason: collision with root package name */
    private static final String f10643f = at.b().b(at.n);

    /* renamed from: g, reason: collision with root package name */
    private static String f10644g = "";

    /* renamed from: h, reason: collision with root package name */
    private static a f10645h;

    private a() {
    }

    public static a a() {
        if (f10645h == null) {
            synchronized (a.class) {
                if (f10645h == null) {
                    f10645h = new a();
                }
            }
        }
        return f10645h;
    }

    private String c(String str) {
        String string = "";
        try {
            String strSubstring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < strSubstring.length(); i2++) {
                char cCharAt = strSubstring.charAt(i2);
                if (!Character.isDigit(cCharAt)) {
                    sb.append(cCharAt);
                } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                }
            }
            string = sb.toString();
            return string + new StringBuilder(string).reverse().toString();
        } catch (Throwable unused) {
            return string;
        }
    }

    public String b(String str) {
        String str2;
        String str3 = null;
        try {
            return TextUtils.isEmpty(f10638a) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f10638a.getBytes()));
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f10642e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f10642e.getBytes()));
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f10644g.getBytes()));
                    } catch (Throwable unused3) {
                    }
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str2;
                    } catch (Throwable unused4) {
                        str3 = str2;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f10638a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f10640c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f10642e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f10642e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f10643f, 0);
                if (sharedPreferences != null) {
                    f10644g = sharedPreferences.getString(f10640c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f10644g);
                }
                f10638a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f10638a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f10638a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f10638a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
