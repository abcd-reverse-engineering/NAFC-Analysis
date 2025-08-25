package b.a.a.g;

import android.text.format.DateUtils;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: DateUtils.java */
/* loaded from: classes.dex */
public class c extends DateUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2309a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f2310b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f2311c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f2312d = 3;

    /* compiled from: DateUtils.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static long a(long j2, long j3) {
        return a(j2, j3, 3);
    }

    public static long b(Date date, Date date2) {
        return a(date, date2, 3);
    }

    public static long c(Date date, Date date2) {
        return a(date, date2, 2);
    }

    public static long d(Date date, Date date2) {
        return a(date, date2, 1);
    }

    public static long e(Date date, Date date2) {
        return a(date, date2, 0);
    }

    public static long a(long j2, long j3, int i2) {
        return a(new Date(j2), new Date(j3), i2);
    }

    public static long b(long j2, long j3) {
        return a(j2, j3, 2);
    }

    public static long c(long j2, long j3) {
        return a(j2, j3, 1);
    }

    public static long d(long j2, long j3) {
        return a(j2, j3, 0);
    }

    public static long a(Date date, Date date2, int i2) {
        long[] jArrA = a(date, date2);
        if (i2 == 1) {
            return jArrA[2];
        }
        if (i2 == 2) {
            return jArrA[1];
        }
        if (i2 == 3) {
            return jArrA[0];
        }
        return jArrA[3];
    }

    @NonNull
    public static String b(int i2) {
        StringBuilder sb;
        String str;
        if (i2 < 10) {
            sb = new StringBuilder();
            str = "0";
        } else {
            sb = new StringBuilder();
            str = "";
        }
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static int c(@NonNull String str) {
        try {
            if (str.startsWith("0")) {
                str = str.substring(1);
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            d.c(e2);
            return 0;
        }
    }

    public static Date b(String str) {
        return a(str, "yyyy-MM-dd HH:mm:ss");
    }

    private static long[] a(Date date, Date date2) {
        return a(date2.getTime() - date.getTime());
    }

    private static long[] a(long j2) {
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        long j5 = j4 / com.heytap.mcssdk.constant.a.f5801e;
        long j6 = j4 % com.heytap.mcssdk.constant.a.f5801e;
        long j7 = j6 / com.heytap.mcssdk.constant.a.f5800d;
        long j8 = j6 % com.heytap.mcssdk.constant.a.f5800d;
        long j9 = j8 / 1000;
        d.e(String.format(Locale.CHINA, "different: %d ms, %d days, %d hours, %d minutes, %d seconds", Long.valueOf(j8), Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j7), Long.valueOf(j9)));
        return new long[]{j3, j5, j7, j9};
    }

    public static int a(int i2) {
        return a(0, i2);
    }

    public static int a(int i2, int i3) {
        List listAsList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        List listAsList2 = Arrays.asList("4", "6", "9", "11");
        if (listAsList.contains(String.valueOf(i3))) {
            return 31;
        }
        if (listAsList2.contains(String.valueOf(i3))) {
            return 30;
        }
        if (i2 <= 0) {
            return 29;
        }
        return ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) ? 28 : 29;
    }

    public static boolean a(Date date) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        throw new IllegalArgumentException("date is null");
    }

    public static Date a(String str, String str2) {
        try {
            return new Date(new SimpleDateFormat(str2, Locale.PRC).parse(str).getTime());
        } catch (ParseException e2) {
            d.c(e2);
            return null;
        }
    }

    public static String a(Date date, String str) {
        return new SimpleDateFormat(str, Locale.PRC).format(date);
    }

    public static String a(String str) {
        return a(Calendar.getInstance(Locale.CHINA).getTime(), str);
    }
}
