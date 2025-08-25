package com.luck.picture.lib.tools;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DateUtils {
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd_HHmmssSS");

    public static String cdTime(long j2, long j3) {
        long j4 = j3 - j2;
        if (j4 > 1000) {
            return (j4 / 1000) + "秒";
        }
        return j4 + "毫秒";
    }

    public static int dateDiffer(long j2) {
        try {
            return (int) Math.abs(ValueOf.toLong(String.valueOf(System.currentTimeMillis()).substring(0, 10)) - j2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String formatDurationTime(long j2) {
        return String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j2)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j2) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j2))));
    }

    public static String getCreateFileName(String str) {
        return str + sf.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCreateFileName() {
        return sf.format(Long.valueOf(System.currentTimeMillis()));
    }
}
