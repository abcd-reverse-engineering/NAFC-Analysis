package com.taobao.accs.net;

import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ConnectInfo f8539a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccsConnectStateListener f8540b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f8541c;

    n(m mVar, TaoBaseService.ConnectInfo connectInfo, AccsConnectStateListener accsConnectStateListener) {
        this.f8541c = mVar;
        this.f8539a = connectInfo;
        this.f8540b = accsConnectStateListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ConnectInfo connectInfo = this.f8539a;
        if (connectInfo.connected) {
            this.f8540b.onConnected(connectInfo);
        } else {
            this.f8540b.onDisconnected(connectInfo);
        }
    }
}
