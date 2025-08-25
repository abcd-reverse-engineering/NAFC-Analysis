package com.google.gson.b0.q.p;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: ISO8601Utils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5663a = "UTC";

    /* renamed from: b, reason: collision with root package name */
    private static final TimeZone f5664b = TimeZone.getTimeZone(f5663a);

    public static String a(Date date) {
        return a(date, false, f5664b);
    }

    public static String a(Date date, boolean z) {
        return a(date, z, f5664b);
    }

    public static String a(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        a(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        a(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        a(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        a(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        a(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        a(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            a(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i2 = offset / 60000;
            int iAbs = Math.abs(i2 / 60);
            int iAbs2 = Math.abs(i2 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            a(sb, iAbs, 2);
            sb.append(':');
            a(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, NumberFormatException -> 0x01bd, IndexOutOfBoundsException -> 0x01bf, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:17:0x0054, B:19:0x0064, B:20:0x0066, B:22:0x0072, B:23:0x0074, B:25:0x007a, B:29:0x0084, B:34:0x0094, B:36:0x009c, B:47:0x00c8, B:49:0x00ce, B:51:0x00d5, B:75:0x0182, B:55:0x00df, B:56:0x00fa, B:57:0x00fb, B:61:0x0117, B:63:0x0124, B:66:0x012d, B:68:0x014c, B:71:0x015b, B:72:0x017d, B:74:0x0180, B:60:0x0106, B:77:0x01b3, B:78:0x01ba, B:40:0x00b6, B:41:0x00b9), top: B:94:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b3 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, NumberFormatException -> 0x01bd, IndexOutOfBoundsException -> 0x01bf, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:17:0x0054, B:19:0x0064, B:20:0x0066, B:22:0x0072, B:23:0x0074, B:25:0x007a, B:29:0x0084, B:34:0x0094, B:36:0x009c, B:47:0x00c8, B:49:0x00ce, B:51:0x00d5, B:75:0x0182, B:55:0x00df, B:56:0x00fa, B:57:0x00fb, B:61:0x0117, B:63:0x0124, B:66:0x012d, B:68:0x014c, B:71:0x015b, B:72:0x017d, B:74:0x0180, B:60:0x0106, B:77:0x01b3, B:78:0x01ba, B:40:0x00b6, B:41:0x00b9), top: B:94:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date a(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.b0.q.p.a.a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    private static int a(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i4 = i2 + 1;
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = -iDigit;
        } else {
            i4 = i2;
            i5 = 0;
        }
        while (i4 < i3) {
            int i6 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = (i5 * 10) - iDigit2;
            i4 = i6;
        }
        return -i5;
    }

    private static void a(StringBuilder sb, int i2, int i3) {
        String string = Integer.toString(i2);
        for (int length = i3 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    private static int a(String str, int i2) {
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }
}
