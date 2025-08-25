package com.umeng.socialize;

import com.tencent.bugly.BuglyStrategy;

/* loaded from: classes2.dex */
public class Config {
    public static String EntityKey = "-1";
    public static String EntityName = "share";
    public static final boolean Google = false;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;

    @Deprecated
    public static boolean OpenEditor = true;

    @Deprecated
    public static String appName = null;
    public static final boolean mEncrypt = false;
    public static Boolean isUmengSina = true;
    public static Boolean isUmengWx = true;
    public static Boolean isUmengQQ = true;
    public static Boolean isUmengDY = true;
    public static String Descriptor = "com.umeng.share";
    public static String SessionId = null;

    @Deprecated
    public static int QQWITHQZONE = 2;

    @Deprecated
    public static String QQAPPNAME = "";
    public static String shareType = "native";

    @Deprecated
    public static int KaKaoLoginType = 0;
    public static String MORE_TITLE = "分享";

    @Deprecated
    public static int LinkedInProfileScope = 0;

    @Deprecated
    public static int LinkedInShareCode = 0;
    public static int connectionTimeOut = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
    public static int readSocketTimeOut = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;

    @Deprecated
    public static boolean isNeedAuth = false;
    public static boolean isJumptoAppStore = false;
    public static boolean isFacebookRead = false;

    /* renamed from: a, reason: collision with root package name */
    private static int f11496a = 0;

    public static int getMINITYPE() {
        return f11496a;
    }

    public static void setMini() {
        f11496a = 0;
    }

    public static void setMiniPreView() {
        f11496a = 2;
    }

    public static void setMiniTest() {
        f11496a = 1;
    }
}
