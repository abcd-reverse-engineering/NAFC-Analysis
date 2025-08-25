package com.taobao.accs.utl;

import com.xiaomi.mipush.sdk.Constants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ALog {
    public static volatile boolean isPrintLog = true;
    private static final String preTag = "NAccs.";
    private static volatile ILog sLog;

    /* compiled from: Taobao */
    public interface ILog {
        void d(String str, String str2);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th);

        void i(String str, String str2);

        boolean isPrintLog(int i2);

        boolean isValid();

        void setLogLevel(int i2);

        void w(String str, String str2);

        void w(String str, String str2, Throwable th);
    }

    /* compiled from: Taobao */
    public enum Level {
        V,
        D,
        I,
        W,
        E,
        L
    }

    private static String buildLogMsg(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append(str);
        }
        if (objArr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                sb.append(c.c.a.b.a.a.f3100g);
                sb.append(formatKv(objArr[i2], objArr[i3]));
                i2 = i3 + 1;
            }
            if (i2 == objArr.length - 1) {
                sb.append(c.c.a.b.a.a.f3100g);
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    private static String buildLogTag(String str) {
        return preTag + str;
    }

    public static void d(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String strBuildLogTag = buildLogTag(str);
            String strBuildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.d(strBuildLogTag, strBuildLogMsg);
            }
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String strBuildLogTag = buildLogTag(str);
            String strBuildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.e(strBuildLogTag, strBuildLogMsg);
            }
        }
    }

    private static String formatKv(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(Constants.COLON_SEPARATOR);
        if (obj2 == null) {
            obj2 = "";
        }
        sb.append(obj2);
        return sb.toString();
    }

    public static void i(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String strBuildLogTag = buildLogTag(str);
            String strBuildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.i(strBuildLogTag, strBuildLogMsg);
            }
        }
    }

    public static boolean isPrintLog() {
        ILog iLog = sLog;
        return iLog != null ? iLog.isPrintLog(4) : isPrintLog;
    }

    public static void setLog(ILog iLog) {
        if (iLog == null || !iLog.isValid()) {
            return;
        }
        sLog = iLog;
    }

    public static void setPrintLog(boolean z) {
        isPrintLog = z;
    }

    public static void v(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            buildLogTag(str);
            buildLogMsg(str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String strBuildLogTag = buildLogTag(str);
            String strBuildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.w(strBuildLogTag, strBuildLogMsg);
            }
        }
    }

    public static boolean isPrintLog(Level level) {
        ILog iLog = sLog;
        if (iLog != null) {
            return iLog.isPrintLog(4);
        }
        return isPrintLog;
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        if (isPrintLog()) {
            String strBuildLogTag = buildLogTag(str);
            String strBuildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.e(strBuildLogTag, strBuildLogMsg, th);
            }
        }
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        if (isPrintLog()) {
            String strBuildLogTag = buildLogTag(str);
            String strBuildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.w(strBuildLogTag, strBuildLogMsg, th);
            }
        }
    }
}
