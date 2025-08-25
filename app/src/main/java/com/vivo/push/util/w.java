package com.vivo.push.util;

import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* compiled from: MultiUserManager.java */
/* loaded from: classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static int f12302a = -1;

    public static int a() throws NoSuchMethodException, SecurityException {
        if (Build.VERSION.SDK_INT < 17) {
            return 0;
        }
        int i2 = f12302a;
        if (i2 != -1) {
            return i2;
        }
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            f12302a = ((Integer) declaredMethod.invoke(null, null)).intValue();
            u.d("MultiUserManager", "getMyUserId = " + f12302a);
            return f12302a;
        } catch (Exception e2) {
            u.a("MultiUserManager", "getMyUserId error " + e2.getMessage());
            return 0;
        }
    }
}
