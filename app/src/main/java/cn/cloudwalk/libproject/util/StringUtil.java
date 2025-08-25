package cn.cloudwalk.libproject.util;

import c.c.a.b.a.a;

/* loaded from: classes.dex */
public class StringUtil {
    private static final int PAD_LIMIT = 8192;

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private static String padding(int i2, char c2) throws IndexOutOfBoundsException {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + i2);
        }
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < cArr.length; i3++) {
            cArr[i3] = c2;
        }
        return new String(cArr);
    }

    public static String rightPad(String str, int i2) {
        return rightPad(str, i2, ' ');
    }

    public static String rightPad(String str, int i2, char c2) {
        if (str == null) {
            return null;
        }
        int length = i2 - str.length();
        return length <= 0 ? str : length > 8192 ? rightPad(str, i2, String.valueOf(c2)) : str.concat(padding(length, c2));
    }

    public static String rightPad(String str, int i2, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = a.f3100g;
        }
        int length = str2.length();
        int length2 = i2 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i2, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i3 = 0; i3 < length2; i3++) {
            cArr[i3] = charArray[i3 % length];
        }
        return str.concat(new String(cArr));
    }
}
