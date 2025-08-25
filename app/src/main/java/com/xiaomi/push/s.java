package com.xiaomi.push;

import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;

/* loaded from: classes2.dex */
public class s {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f13266a;

        /* renamed from: a, reason: collision with other field name */
        private final StringBuilder f921a;

        /* renamed from: b, reason: collision with root package name */
        private final String f13267b;

        public a() {
            this(Constants.COLON_SEPARATOR, Constants.ACCEPT_TIME_SEPARATOR_SP);
        }

        public a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f921a.length() > 0) {
                    this.f921a.append(this.f13267b);
                }
                StringBuilder sb = this.f921a;
                sb.append(str);
                sb.append(this.f13266a);
                sb.append(obj);
            }
            return this;
        }

        public String toString() {
            return this.f921a.toString();
        }

        public a(String str, String str2) {
            this.f921a = new StringBuilder();
            this.f13266a = str;
            this.f13267b = str2;
        }
    }

    public static int a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int b(String str, int i2) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i2 : i2;
    }

    public static long a(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            return j2;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j2;
        }
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
