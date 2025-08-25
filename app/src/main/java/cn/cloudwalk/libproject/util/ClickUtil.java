package cn.cloudwalk.libproject.util;

/* loaded from: classes.dex */
public class ClickUtil {
    private static final int MIN_DELAY_TIME = 1000;
    private static long lastClickTime;

    public static boolean isFastClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - lastClickTime < 1000;
        lastClickTime = jCurrentTimeMillis;
        return z;
    }
}
