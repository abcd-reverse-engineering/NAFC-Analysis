package com.taobao.accs.data;

import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f8470a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8471b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Intent f8472c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f8473d;

    i(g gVar, String str, String str2, Intent intent) {
        this.f8473d = gVar;
        this.f8470a = str;
        this.f8471b = str2;
        this.f8472c = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (g.f8466a == null || !g.f8466a.contains(this.f8470a)) {
            return;
        }
        ALog.e("MsgDistribute", "routing msg time out, try election", Constants.KEY_DATA_ID, this.f8470a, Constants.KEY_SERVICE_ID, this.f8471b);
        g.f8466a.remove(this.f8470a);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "timeout", "pkg:" + this.f8472c.getPackage());
    }
}
