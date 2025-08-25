package com.huawei.hms.utils;

import c.c.a.b.a.a;
import com.huawei.hms.framework.common.ExceptionCode;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class StringUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f7410a = Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)");

    private StringUtil() {
    }

    public static String addByteForNum(String str, int i2, char c2) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (length == i2) {
            return str;
        }
        if (length > i2) {
            return str.substring(length - i2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (length < i2) {
            stringBuffer.append(c2);
            length++;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static boolean checkVersion(String str) {
        return f7410a.matcher(str).find();
    }

    public static int convertVersion2Integer(String str) {
        if (!checkVersion(str)) {
            return 0;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length < 3) {
            return 0;
        }
        int i2 = (Integer.parseInt(strArrSplit[0]) * ExceptionCode.CRASH_EXCEPTION) + (Integer.parseInt(strArrSplit[1]) * 100000) + (Integer.parseInt(strArrSplit[2]) * 1000);
        return strArrSplit.length == 4 ? i2 + Integer.parseInt(strArrSplit[3]) : i2;
    }

    public static String objDesc(Object obj) {
        if (obj == null) {
            return a.f3101h;
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }
}
