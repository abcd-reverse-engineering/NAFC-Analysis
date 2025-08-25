package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.analytics.pro.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: SamsungDeviceIdSupplier.java */
/* loaded from: classes2.dex */
public class bd implements au {

    /* compiled from: SamsungDeviceIdSupplier.java */
    private static final class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f10112a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f10113b;

        public IBinder a() throws InterruptedException {
            if (this.f10112a) {
                throw new IllegalStateException();
            }
            this.f10112a = true;
            return this.f10113b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                this.f10113b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f10112a = false;
            this.f10113b = new LinkedBlockingQueue<>();
        }
    }

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return b.AbstractBinderC0136b.a(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
