package com.taobao.accs.client;

import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GlobalClientInfo f8420a;

    c(GlobalClientInfo globalClientInfo) {
        this.f8420a = globalClientInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlobalClientInfo.f8394c = UtilityImpl.m(GlobalClientInfo.f8392a);
    }
}
