package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f8664a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f8665b;

    g(AccsDataListener accsDataListener, boolean z) {
        this.f8664a = accsDataListener;
        this.f8665b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8664a.onAntiBrush(this.f8665b, null);
    }
}
