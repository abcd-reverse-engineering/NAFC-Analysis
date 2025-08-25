package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: CoolpadDeviceIdSupplier.java */
/* loaded from: classes2.dex */
public class aw implements au {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10083a = "Coolpad";

    /* renamed from: b, reason: collision with root package name */
    private static final String f10084b = "com.coolpad.deviceidsupport";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10085c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d, reason: collision with root package name */
    private static a f10086d;

    /* renamed from: f, reason: collision with root package name */
    private CountDownLatch f10088f;

    /* renamed from: g, reason: collision with root package name */
    private Context f10089g;

    /* renamed from: e, reason: collision with root package name */
    private String f10087e = "";

    /* renamed from: h, reason: collision with root package name */
    private final ServiceConnection f10090h = new ServiceConnection() { // from class: com.umeng.analytics.pro.aw.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = aw.f10086d = a.b.a(iBinder);
                aw.this.f10087e = aw.f10086d.b(aw.this.f10089g.getPackageName());
                String str = "onServiceConnected: oaid = " + aw.this.f10087e;
            } catch (RemoteException | NullPointerException e2) {
                String str2 = "onServiceConnected failed e=" + e2.getMessage();
            }
            aw.this.f10088f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a unused = aw.f10086d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f10084b, f10085c));
            context.bindService(intent, this.f10090h, 1);
        } catch (Throwable th) {
            String str = "bindService failed. e=" + th.getMessage();
            this.f10088f.countDown();
        }
    }

    private void c(Context context) {
        try {
            context.unbindService(this.f10090h);
        } catch (Throwable th) {
            String str = "unbindService failed. e=" + th.getMessage();
        }
    }

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f10089g = context.getApplicationContext();
        this.f10088f = new CountDownLatch(1);
        try {
            b(context);
            this.f10088f.await(500L, TimeUnit.MILLISECONDS);
            return this.f10087e;
        } catch (InterruptedException e2) {
            String str = "getOAID interrupted. e=" + e2.getMessage();
            return null;
        } finally {
            c(context);
        }
    }
}
