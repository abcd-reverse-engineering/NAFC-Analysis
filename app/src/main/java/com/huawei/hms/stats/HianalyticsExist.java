package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public class HianalyticsExist {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f7249a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f7250b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f7251c = false;

    public static boolean isHianalyticsExist() {
        boolean z;
        synchronized (f7249a) {
            if (!f7250b) {
                boolean z2 = false;
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                    z = true;
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                    z = false;
                }
                try {
                    Class.forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");
                    z2 = true;
                } catch (ClassNotFoundException unused2) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");
                }
                if (z && !z2) {
                    f7251c = true;
                }
                f7250b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + f7251c);
            }
        }
        return f7251c;
    }
}
