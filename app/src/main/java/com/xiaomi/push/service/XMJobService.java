package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.push.dz;

/* loaded from: classes2.dex */
public class XMJobService extends Service {

    /* renamed from: a, reason: collision with root package name */
    static Service f13272a;

    /* renamed from: a, reason: collision with other field name */
    private IBinder f931a = null;

    @TargetApi(21)
    static class a extends JobService {

        /* renamed from: a, reason: collision with root package name */
        Binder f13273a;

        /* renamed from: a, reason: collision with other field name */
        private Handler f932a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a, reason: collision with other inner class name */
        private static class HandlerC0164a extends Handler {

            /* renamed from: a, reason: collision with root package name */
            JobService f13274a;

            HandlerC0164a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f13274a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                com.xiaomi.channel.commonutils.logger.b.m50a("Job finished " + jobParameters.getJobId());
                this.f13274a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    dz.a(false);
                }
            }
        }

        a(Service service2) {
            this.f13273a = null;
            this.f13273a = (Binder) com.xiaomi.push.aw.a((Object) this, "onBind", new Intent());
            com.xiaomi.push.aw.a((Object) this, "attachBaseContext", service2);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, (Class<?>) XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f932a == null) {
                this.f932a = new HandlerC0164a(this);
            }
            Handler handler = this.f932a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f931a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f931a = new a(this).f13273a;
        }
        f13272a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f13272a = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        int iOnStartCommand = super.onStartCommand(intent, i2, i3);
        if (com.xiaomi.push.j.m627a((Context) this)) {
            return iOnStartCommand;
        }
        return 2;
    }
}
