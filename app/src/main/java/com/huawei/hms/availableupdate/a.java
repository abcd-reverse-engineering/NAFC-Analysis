package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AppSpoofResolveMgr.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6646c = new a();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f6647d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f6648a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final List<Activity> f6649b = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f6647d) {
            for (Activity activity2 : this.f6649b) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f6649b.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f6647d) {
            this.f6649b.remove(activity);
        }
    }

    public void a(boolean z) {
        this.f6648a.set(z);
    }

    public AtomicBoolean a() {
        return this.f6648a;
    }
}
