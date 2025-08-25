package com.taobao.accs.data;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8449a;

    c(a aVar) {
        this.f8449a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f8449a) {
            if (this.f8449a.f8445f == 0) {
                ALog.e("AssembleMessage", "timeout", Constants.KEY_DATA_ID, this.f8449a.f8441b);
                this.f8449a.f8445f = 1;
                this.f8449a.f8447h.clear();
                AppMonitor.getInstance().commitStat(new AssembleMonitor(this.f8449a.f8441b, String.valueOf(this.f8449a.f8445f)));
            }
        }
    }
}
