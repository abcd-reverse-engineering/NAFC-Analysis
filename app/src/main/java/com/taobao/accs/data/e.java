package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TrafficsMonitor.a f8463a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f8464b;

    e(d dVar, TrafficsMonitor.a aVar) {
        this.f8464b = dVar;
        this.f8463a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TrafficsMonitor trafficsMonitor = this.f8464b.f8452c;
        if (trafficsMonitor != null) {
            trafficsMonitor.a(this.f8463a);
        }
    }
}
