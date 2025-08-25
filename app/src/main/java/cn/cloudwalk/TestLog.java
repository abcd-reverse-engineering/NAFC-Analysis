package cn.cloudwalk;

/* loaded from: classes.dex */
public class TestLog {
    public static int frame = 0;
    public static boolean isDebug = false;
    public static int sfFrame;
    private static long startTime;

    public static void LogE(String str, String str2) {
        boolean z = isDebug;
    }

    protected static void logSf() {
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - startTime >= 1000) {
            startTime = System.currentTimeMillis();
            netE("TestLog", "每秒:" + frame + "算法:" + sfFrame);
            frame = 0;
            sfFrame = 0;
        }
    }

    protected static void netE(String str, String str2) {
    }

    protected static void netd(String str, String str2) {
    }

    public static void setIsDebug(boolean z) {
        isDebug = z;
    }
}
