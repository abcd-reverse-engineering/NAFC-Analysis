package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* compiled from: LaunchTimesCondition.java */
/* loaded from: classes2.dex */
public class af implements aa {

    /* renamed from: a, reason: collision with root package name */
    private int f10025a;

    public af(int i2) {
        this.f10025a = 0;
        this.f10025a = i2;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        long j2 = 0;
        try {
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                j2 = sharedPreferencesA.getLong(aq.f10055a, 0L);
                if (j2 >= this.f10025a) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "launch times skipped. times: " + j2 + " ; config: " + this.f10025a);
        return false;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return 0L;
    }
}
