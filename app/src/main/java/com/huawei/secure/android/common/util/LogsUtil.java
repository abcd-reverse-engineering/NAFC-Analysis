package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class LogsUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f7685a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: b, reason: collision with root package name */
    private static final char f7686b = '*';

    /* renamed from: c, reason: collision with root package name */
    private static final int f7687c = 2;

    private static class a extends Throwable {

        /* renamed from: d, reason: collision with root package name */
        private static final long f7688d = 7129050843360571879L;

        /* renamed from: a, reason: collision with root package name */
        private String f7689a;

        /* renamed from: b, reason: collision with root package name */
        private Throwable f7690b;

        /* renamed from: c, reason: collision with root package name */
        private Throwable f7691c;

        public a(Throwable th) {
            this.f7691c = th;
        }

        public void a(Throwable th) {
            this.f7690b = th;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            Throwable th;
            th = this.f7690b;
            if (th == this) {
                th = null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f7689a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.f7691c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f7689a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f7689a.startsWith(str)) {
                return this.f7689a;
            }
            return str + this.f7689a;
        }

        public void a(String str) {
            this.f7689a = str;
        }
    }

    private static String a(String str, boolean z) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                sb.append(a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (i2 % 2 == 0) {
                charArray[i2] = f7686b;
            }
        }
        return new String(charArray);
    }

    public static void d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, z);
    }

    public static void e(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, z);
    }

    public static Throwable getNewThrowable(Throwable th) {
        if (th == null) {
            return null;
        }
        a aVar = new a(th);
        aVar.setStackTrace(th.getStackTrace());
        aVar.a(b(th.getMessage()));
        Throwable cause = th.getCause();
        a aVar2 = aVar;
        while (cause != null) {
            a aVar3 = new a(cause);
            aVar3.setStackTrace(cause.getStackTrace());
            aVar3.a(b(cause.getMessage()));
            aVar2.a(aVar3);
            cause = cause.getCause();
            aVar2 = aVar3;
        }
        return aVar;
    }

    public static void i(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, z);
    }

    public static void w(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, z);
    }

    public static void d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        a(str2, str3);
    }

    public static void e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        a(str2, str3);
    }

    public static void i(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        a(str2, str3);
    }

    public static void w(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        a(str2, str3);
    }

    public static void d(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        a(str2, str3);
        getNewThrowable(th);
    }

    public static void e(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        a(str2, str3);
        getNewThrowable(th);
    }

    public static void i(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        a(str2, str3);
        getNewThrowable(th);
    }

    public static void w(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        a(str2, str3);
        getNewThrowable(th);
    }

    private static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(a(str2));
        }
        return sb.toString();
    }

    public static void d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, false);
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, false);
    }

    public static void i(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, false);
    }

    public static void w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, false);
    }

    public static void d(String str, String str2, Throwable th, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, z);
        getNewThrowable(th);
    }

    public static void e(String str, String str2, Throwable th, boolean z) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        a(str2, z);
        getNewThrowable(th);
    }

    public static void i(String str, String str2, Throwable th, boolean z) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        a(str2, z);
        getNewThrowable(th);
    }

    public static void w(String str, String str2, Throwable th, boolean z) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        a(str2, z);
        getNewThrowable(th);
    }

    public static void d(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        a(str2, false);
        getNewThrowable(th);
    }

    public static void e(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        a(str2, false);
        getNewThrowable(th);
    }

    public static void i(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        a(str2, false);
        getNewThrowable(th);
    }

    public static void w(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        a(str2, false);
        getNewThrowable(th);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i2 = 1;
        if (1 == length) {
            return String.valueOf(f7686b);
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (f7685a.matcher(String.valueOf(cCharAt)).matches()) {
                if (i2 % 2 == 0) {
                    cCharAt = f7686b;
                }
                i2++;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }
}
