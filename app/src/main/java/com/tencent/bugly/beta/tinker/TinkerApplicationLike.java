package com.tencent.bugly.beta.tinker;

import android.app.Application;
import android.content.Intent;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.entry.DefaultApplicationLike;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TinkerApplicationLike extends DefaultApplicationLike {
    public static final String TAG = "Tinker.TinkerApplicationLike";
    private static ApplicationLike tinkerPatchApplicationLike;

    public TinkerApplicationLike(Application application, int i2, boolean z, long j2, long j3, Intent intent) {
        super(application, i2, z, j2, j3, intent);
        setTinkerPatchApplicationLike(this);
    }

    public static ApplicationLike getTinkerPatchApplicationLike() {
        return tinkerPatchApplicationLike;
    }

    private static void setTinkerPatchApplicationLike(ApplicationLike applicationLike) {
        tinkerPatchApplicationLike = applicationLike;
    }
}
