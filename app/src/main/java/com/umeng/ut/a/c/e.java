package com.umeng.ut.a.c;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f11904b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f11905c = false;

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m45a() {
        return f11904b;
    }

    public static void b(String str, Object... objArr) {
        if (f11905c) {
            d();
            a(str, objArr);
        }
    }

    public static void c() {
        if (f11904b) {
            d();
            a((String) null, new Object[0]);
        }
    }

    private static String d() {
        String methodName;
        String strSubstring;
        StackTraceElement stackTraceElementA = a();
        if (stackTraceElementA != null) {
            String className = stackTraceElementA.getClassName();
            strSubstring = !TextUtils.isEmpty(className) ? className.substring(className.lastIndexOf(46) + 1) : "";
            methodName = stackTraceElementA.getMethodName();
        } else {
            methodName = "";
            strSubstring = methodName;
        }
        return "Utdid." + strSubstring + "." + methodName + "." + String.valueOf(Process.myPid()) + "." + (Thread.currentThread().getId() + "");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m44a(String str, Object... objArr) {
        if (f11904b) {
            d();
            a(str, objArr);
        }
    }

    public static void b(String str, Throwable th, Object... objArr) {
        if (f11905c) {
            d();
            a(str, objArr);
        }
    }

    public static void a(String str, Throwable th, Object... objArr) {
        if (f11904b) {
            d();
            a(str, objArr);
        }
    }

    private static String a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }

    private static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        int i2 = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i2], objArr[i3]));
                if (i3 < length - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                i2 = i3 + 1;
            }
            if (i2 == objArr.length - 1) {
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    private static StackTraceElement a() {
        try {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(e.class.getName())) {
                    return stackTraceElement;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
