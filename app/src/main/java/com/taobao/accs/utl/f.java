package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NetPerformanceMonitor f8658a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8659b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f8660c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f8661d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f8662e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Intent f8663f;

    f(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i2, Intent intent) {
        this.f8658a = netPerformanceMonitor;
        this.f8659b = str;
        this.f8660c = str2;
        this.f8661d = accsDataListener;
        this.f8662e = i2;
        this.f8663f = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetPerformanceMonitor netPerformanceMonitor = this.f8658a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f8659b)) {
            ALog.e(a.TAG, "onSendData start dataId:" + this.f8660c + " serviceId:" + this.f8659b, new Object[0]);
        }
        this.f8661d.onSendData(this.f8659b, this.f8660c, this.f8662e, a.c(this.f8663f));
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f8659b)) {
            ALog.e(a.TAG, "onSendData end dataId:" + this.f8660c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.f8658a);
    }
}
