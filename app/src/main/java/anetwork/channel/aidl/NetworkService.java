package anetwork.channel.aidl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import anet.channel.util.ALog;
import anetwork.channel.aidl.b;
import anetwork.channel.aidl.h;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NetworkService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private Context f2083a;

    /* renamed from: b, reason: collision with root package name */
    private h.a f2084b = null;

    /* renamed from: c, reason: collision with root package name */
    private h.a f2085c = null;

    /* renamed from: d, reason: collision with root package name */
    b.a f2086d = new c(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f2083a = getApplicationContext();
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkService", "onBind:" + intent.getAction(), null, new Object[0]);
        }
        this.f2084b = new a.a.m.b(this.f2083a);
        this.f2085c = new a.a.o.b(this.f2083a);
        if (b.class.getName().equals(intent.getAction())) {
            return this.f2086d;
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }
}
