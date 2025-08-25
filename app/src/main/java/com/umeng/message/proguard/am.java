package com.umeng.message.proguard;

import android.os.Build;

/* loaded from: classes2.dex */
public final class am {
    public static void a(ac acVar) {
        if (Build.VERSION.SDK_INT < 23 || acVar == null || acVar.f11223b == null) {
            return;
        }
        Object obj = acVar.f11224c;
        if (obj instanceof c) {
            ((c) obj).c();
        }
        acVar.f11224c = null;
    }
}
