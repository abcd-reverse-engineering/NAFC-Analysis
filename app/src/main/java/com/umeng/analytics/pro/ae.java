package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* compiled from: IntervalPeriodCondition.java */
/* loaded from: classes2.dex */
public class ae implements aa {

    /* renamed from: a, reason: collision with root package name */
    private String f10023a;

    /* renamed from: b, reason: collision with root package name */
    private long f10024b;

    public ae(String str, long j2) {
        this.f10023a = "";
        this.f10024b = 0L;
        this.f10023a = str;
        this.f10024b = j2;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        try {
            String str = aq.f10056b + this.f10023a;
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA == null) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - sharedPreferencesA.getLong(str, 0L);
            if (jCurrentTimeMillis > this.f10024b * 1000) {
                return true;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + jCurrentTimeMillis + "; config: " + (this.f10024b * 1000));
            return false;
        } catch (Throwable unused) {
            return false;
        }
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
