package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotInstalledHmsResolveMgr.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f6650b = new b();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f6651c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final List<Activity> f6652a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f6651c) {
            for (Activity activity2 : this.f6652a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f6652a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f6651c) {
            this.f6652a.remove(activity);
        }
    }
}
