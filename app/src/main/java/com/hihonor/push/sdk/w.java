package com.hihonor.push.sdk;

import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public final String f6346a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6347b;

    public w(String str) {
        this.f6346a = str;
        this.f6347b = a(str);
    }

    public static w a(String str) {
        return new w(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f6346a, ((w) obj).f6346a);
    }

    public final int hashCode() {
        return this.f6347b;
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
