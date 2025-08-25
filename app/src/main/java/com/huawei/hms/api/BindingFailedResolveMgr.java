package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class BindingFailedResolveMgr {

    /* renamed from: b, reason: collision with root package name */
    static final BindingFailedResolveMgr f6608b = new BindingFailedResolveMgr();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f6609c = new Object();

    /* renamed from: a, reason: collision with root package name */
    List<Activity> f6610a = new ArrayList(1);

    BindingFailedResolveMgr() {
    }

    void a(Activity activity) {
        synchronized (f6609c) {
            for (Activity activity2 : this.f6610a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f6610a.add(activity);
        }
    }

    void b(Activity activity) {
        synchronized (f6609c) {
            this.f6610a.remove(activity);
        }
    }
}
