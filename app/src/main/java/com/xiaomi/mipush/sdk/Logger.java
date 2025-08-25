package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.dc;
import com.xiaomi.push.dd;
import java.io.File;

/* loaded from: classes2.dex */
public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    @Deprecated
    public static File getLogFile(String str) {
        return null;
    }

    protected static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    public static void setPushLog(Context context) {
        boolean z = sUserLogger != null;
        boolean z2 = sDisablePushLog;
        if (z2) {
            z = false;
        }
        com.xiaomi.channel.commonutils.logger.b.a(new dc(z ? sUserLogger : null, true ^ z2 ? dd.a(context) : null));
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z) {
    }
}
