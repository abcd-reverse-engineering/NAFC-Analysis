package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f8666a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8667b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f8668c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f8669d;

    h(AccsDataListener accsDataListener, String str, boolean z, boolean z2) {
        this.f8666a = accsDataListener;
        this.f8667b = str;
        this.f8668c = z;
        this.f8669d = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8666a.onConnected(new TaoBaseService.ConnectInfo(this.f8667b, this.f8668c, this.f8669d));
    }
}
