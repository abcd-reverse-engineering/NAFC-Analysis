package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* loaded from: classes.dex */
public class g0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public Messenger f6283a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f6284b;

    /* renamed from: c, reason: collision with root package name */
    public Context f6285c;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
        this.f6283a = new Messenger(iBinder);
        Message messageObtain = Message.obtain();
        messageObtain.setData(this.f6284b);
        try {
            this.f6283a.send(messageObtain);
        } catch (Exception e2) {
            String str = "message sending failed. " + e2.getMessage();
        }
        try {
            this.f6285c.unbindService(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f6283a = null;
        this.f6284b = null;
        this.f6285c = null;
    }
}
