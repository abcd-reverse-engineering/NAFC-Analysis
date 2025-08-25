package com.taobao.accs.net;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.taobao.accs.internal.AccsJobService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class f extends g {

    /* renamed from: c, reason: collision with root package name */
    private JobScheduler f8520c;

    f(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.g
    @SuppressLint({"NewApi"})
    protected void a(int i2) {
        if (this.f8520c == null) {
            this.f8520c = (JobScheduler) this.f8523a.getSystemService("jobscheduler");
        }
        this.f8520c.cancel(com.umeng.analytics.pro.i.f10405b);
        long j2 = i2 * 1000;
        this.f8520c.schedule(new JobInfo.Builder(com.umeng.analytics.pro.i.f10405b, new ComponentName(this.f8523a.getPackageName(), AccsJobService.class.getName())).setMinimumLatency(j2).setOverrideDeadline(j2).setRequiredNetworkType(1).build());
    }
}
