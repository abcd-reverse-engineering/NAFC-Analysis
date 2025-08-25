package com.huawei.hms.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: RemoteService.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private ServiceConnection f7227a;

    /* renamed from: b, reason: collision with root package name */
    private Messenger f7228b = null;

    /* compiled from: RemoteService.java */
    class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f7229a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f7230b;

        a(Bundle bundle, Context context) {
            this.f7229a = bundle;
            this.f7230b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
            HMSLog.i("RemoteService", "remote service onConnected");
            r.this.f7228b = new Messenger(iBinder);
            Message messageObtain = Message.obtain();
            messageObtain.setData(this.f7229a);
            try {
                r.this.f7228b.send(messageObtain);
            } catch (RemoteException unused) {
                HMSLog.i("RemoteService", "remote service message send failed");
            }
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f7230b.unbindService(r.this.f7227a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            r.this.f7228b = null;
        }
    }

    public boolean a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f7227a = new a(bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f7227a, 1);
    }
}
