package cn.cloudwalk.util;

/* loaded from: classes.dex */
public class LogUtils {
    public static final String LOG_EXCEPTION = "Exception";
    private static final String LOG_PREFIX = "cw_";
    private static final int LOG_PREFIX_LENGTH = 3;
    private static final int MAX_LOG_LENGTH = 23;
    private static boolean isLOGD = false;
    private static boolean isLOGE = false;
    private static boolean isLOGI = false;
    private static boolean isLOGV = false;
    private static boolean isLOGW = false;

    private LogUtils() {
    }

    public static void LOGD(String str, String str2) {
        boolean z = isLOGD;
    }

    public static void LOGE(String str, String str2) {
        boolean z = isLOGE;
    }

    public static void LOGI(String str, String str2) {
        boolean z = isLOGI;
    }

    public static void LOGV(String str, String str2) {
        boolean z = isLOGV;
    }

    public static void LOGW(String str, String str2) {
        boolean z = isLOGW;
    }

    public static String makeLogTag(String str) {
        if (str.length() > 23 - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + str.substring(0, (23 - LOG_PREFIX_LENGTH) - 1);
        }
        return LOG_PREFIX + str;
    }

    public static void setLogD(boolean z) {
        isLOGD = z;
    }

    public static void setLogE(boolean z) {
        isLOGE = z;
    }

    public static void setLogI(boolean z) {
        isLOGI = z;
    }

    public static void setLogV(boolean z) {
        isLOGV = z;
    }

    public static void setLogW(boolean z) {
        isLOGW = z;
    }

    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }
}
