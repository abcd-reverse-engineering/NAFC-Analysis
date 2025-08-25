package com.taobao.accs.data;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class k implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MsgDistributeService f8475a;

    k(MsgDistributeService msgDistributeService) {
        this.f8475a = msgDistributeService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
