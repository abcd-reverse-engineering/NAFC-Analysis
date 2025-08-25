package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f8670a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8671b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f8672c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f8673d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f8674e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f8675f;

    i(AccsDataListener accsDataListener, String str, boolean z, boolean z2, int i2, String str2) {
        this.f8670a = accsDataListener;
        this.f8671b = str;
        this.f8672c = z;
        this.f8673d = z2;
        this.f8674e = i2;
        this.f8675f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8670a.onDisconnected(new TaoBaseService.ConnectInfo(this.f8671b, this.f8672c, this.f8673d, this.f8674e, this.f8675f));
    }
}
