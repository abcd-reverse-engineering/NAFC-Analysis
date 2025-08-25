package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.umeng.analytics.pro.at;

/* loaded from: classes.dex */
public class q1 {

    /* renamed from: c, reason: collision with root package name */
    private static q1 f7076c = new q1();

    /* renamed from: a, reason: collision with root package name */
    private boolean f7077a = false;

    /* renamed from: b, reason: collision with root package name */
    private Context f7078b = q0.i();

    private q1() {
    }

    public static q1 b() {
        return f7076c;
    }

    @TargetApi(24)
    public boolean a() {
        boolean zIsUserUnlocked;
        if (!this.f7077a) {
            Context context = this.f7078b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService(at.f10079m);
                if (userManager != null) {
                    zIsUserUnlocked = userManager.isUserUnlocked();
                } else {
                    this.f7077a = false;
                }
            } else {
                zIsUserUnlocked = true;
            }
            this.f7077a = zIsUserUnlocked;
        }
        return this.f7077a;
    }
}
