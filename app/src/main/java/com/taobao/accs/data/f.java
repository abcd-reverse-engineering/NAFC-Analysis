package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f8465a;

    f(d dVar) {
        this.f8465a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TrafficsMonitor trafficsMonitor = this.f8465a.f8452c;
        if (trafficsMonitor != null) {
            trafficsMonitor.a();
        }
    }
}
