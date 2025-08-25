package com.huawei.hms.opendevice;

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
public class k {

    /* renamed from: a, reason: collision with root package name */
    private ServiceConnection f7137a;

    /* renamed from: b, reason: collision with root package name */
    private Messenger f7138b = null;

    /* compiled from: RemoteService.java */
    class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f7139a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f7140b;

        a(Bundle bundle, Context context) {
            this.f7139a = bundle;
            this.f7140b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
            HMSLog.i("RemoteService", "remote service onConnected");
            k.this.f7138b = new Messenger(iBinder);
            Message messageObtain = Message.obtain();
            messageObtain.setData(this.f7139a);
            try {
                k.this.f7138b.send(messageObtain);
            } catch (RemoteException unused) {
                HMSLog.i("RemoteService", "remote service message send failed");
            }
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f7140b.unbindService(k.this.f7137a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            k.this.f7138b = null;
        }
    }

    public boolean a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f7137a = new a(bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f7137a, 1);
    }
}
