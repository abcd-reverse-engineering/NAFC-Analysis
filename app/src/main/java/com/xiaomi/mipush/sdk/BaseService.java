package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public abstract class BaseService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private a f12335a;

    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<BaseService> f12336a;

        public a(WeakReference<BaseService> weakReference) {
            this.f12336a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what != 1001 || (weakReference = this.f12336a) == null || (baseService = weakReference.get()) == null) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler " + baseService.toString() + " kill self");
            if (!baseService.mo74a()) {
                baseService.stopSelf();
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler has job");
                sendEmptyMessageDelayed(1001, 1000L);
            }
        }
    }

    /* renamed from: a */
    protected abstract boolean mo74a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        if (this.f12335a == null) {
            this.f12335a = new a(new WeakReference(this));
        }
        this.f12335a.a();
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
