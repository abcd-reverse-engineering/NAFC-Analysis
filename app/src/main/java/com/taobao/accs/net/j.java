package com.taobao.accs.net;

import anet.channel.strategy.StrategyCenter;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f8532a;

    j(i iVar) {
        this.f8532a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        StrategyCenter.getInstance().saveData();
    }
}
