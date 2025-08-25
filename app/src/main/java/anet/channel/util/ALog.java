package anet.channel.util;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ALog {
    public static Logcat logcat = new Logcat();
    private static volatile ILog log = logcat;
    private static Object LOG_BREAK = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
    private static boolean isPrintLog = true;
    private static boolean canUseTlog = true;

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
    public static class Level {
        public static final int D = 1;
        public static final int E = 4;
        public static final int I = 2;
        public static final int N = 5;
        public static final int V = 0;
        public static final int W = 3;
    }

    /* compiled from: Taobao */
    public static class Logcat implements ILog {
        int defaultLevel = 1;

        @Override // anet.channel.util.ALog.ILog
        public void d(String str, String str2) {
        }

        @Override // anet.channel.util.ALog.ILog
        public void e(String str, String str2) {
        }

        @Override // anet.channel.util.ALog.ILog
        public void e(String str, String str2, Throwable th) {
        }

        @Override // anet.channel.util.ALog.ILog
        public void i(String str, String str2) {
        }

        @Override // anet.channel.util.ALog.ILog
        public boolean isPrintLog(int i2) {
            return i2 >= this.defaultLevel;
        }

        @Override // anet.channel.util.ALog.ILog
        public boolean isValid() {
            return true;
        }

        @Override // anet.channel.util.ALog.ILog
        public void setLogLevel(int i2) {
            if (i2 < 0 || i2 > 5) {
                this.defaultLevel = 5;
            } else {
                this.defaultLevel = i2;
            }
        }

        @Override // anet.channel.util.ALog.ILog
        public void w(String str, String str2) {
        }

        @Override // anet.channel.util.ALog.ILog
        public void w(String str, String str2, Throwable th) {
        }
    }

    private static String buildLogMsg(String str, String str2, Object... objArr) {
        if (str == null && str2 == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(LOG_BREAK);
            sb.append("[seq:");
            sb.append(str2);
            sb.append("]");
        }
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
                sb.append(objArr[i2] != null ? objArr[i2] : "");
                sb.append(Constants.COLON_SEPARATOR);
                sb.append(objArr[i3] != null ? objArr[i3] : "");
                i2 += 2;
            }
            if (i2 < objArr.length) {
                sb.append(c.c.a.b.a.a.f3100g);
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    private static String buildLogTag(String str) {
        return str;
    }

    public static void d(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(1) || log == null) {
            return;
        }
        log.d(buildLogTag(str), buildLogMsg(str2, str3, objArr));
    }

    public static void e(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(4) || log == null) {
            return;
        }
        log.e(buildLogTag(str), buildLogMsg(str2, str3, objArr));
    }

    public static ILog getLog() {
        return log;
    }

    public static void i(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(2) || log == null) {
            return;
        }
        log.i(buildLogTag(str), buildLogMsg(str2, str3, objArr));
    }

    public static boolean isPrintLog(int i2) {
        if (isPrintLog && log != null) {
            return log.isPrintLog(i2);
        }
        return false;
    }

    public static void setLevel(int i2) {
        if (log != null) {
            log.setLogLevel(i2);
        }
    }

    public static void setLog(ILog iLog) {
        if (iLog == null) {
            return;
        }
        if ((canUseTlog || !iLog.getClass().getSimpleName().toLowerCase().contains("tlog")) && iLog.isValid()) {
            log = iLog;
        }
    }

    public static void setPrintLog(boolean z) {
        isPrintLog = z;
    }

    @Deprecated
    public static void setUseTlog(boolean z) {
        if (z) {
            canUseTlog = true;
        } else {
            canUseTlog = false;
            log = logcat;
        }
    }

    public static void w(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(3) || log == null) {
            return;
        }
        log.w(buildLogTag(str), buildLogMsg(str2, str3, objArr));
    }

    public static void e(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (!isPrintLog(4) || log == null) {
            return;
        }
        log.e(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
    }

    public static void w(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (!isPrintLog(3) || log == null) {
            return;
        }
        log.w(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
    }
}
