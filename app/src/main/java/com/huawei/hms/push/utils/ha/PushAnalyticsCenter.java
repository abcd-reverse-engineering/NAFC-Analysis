package com.huawei.hms.push.utils.ha;

/* loaded from: classes.dex */
public class PushAnalyticsCenter {

    /* renamed from: a, reason: collision with root package name */
    private PushBaseAnalytics f7246a;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static PushAnalyticsCenter f7247a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.f7247a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f7246a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f7246a = pushBaseAnalytics;
    }
}
