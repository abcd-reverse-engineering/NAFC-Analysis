package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: MacTracker.java */
/* loaded from: classes2.dex */
public class g extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10944a = "mac";

    /* renamed from: b, reason: collision with root package name */
    private Context f10945b;

    public g(Context context) {
        super("mac");
        this.f10945b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return DeviceConfig.getMac(this.f10945b);
        } catch (Exception e2) {
            if (AnalyticsConstants.UM_DEBUG) {
                e2.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f10945b, e2);
            return null;
        }
    }
}
