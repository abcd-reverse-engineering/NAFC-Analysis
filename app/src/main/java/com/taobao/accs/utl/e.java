package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NetPerformanceMonitor f8651a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8652b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f8653c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f8654d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f8655e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f8656f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Intent f8657g;

    e(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i2, byte[] bArr, Intent intent) {
        this.f8651a = netPerformanceMonitor;
        this.f8652b = str;
        this.f8653c = str2;
        this.f8654d = accsDataListener;
        this.f8655e = i2;
        this.f8656f = bArr;
        this.f8657g = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetPerformanceMonitor netPerformanceMonitor = this.f8651a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f8652b)) {
            ALog.e(a.TAG, "onResponse start dataId:" + this.f8653c + " serviceId:" + this.f8652b, new Object[0]);
        }
        this.f8654d.onResponse(this.f8652b, this.f8653c, this.f8655e, this.f8656f, a.c(this.f8657g));
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f8652b)) {
            ALog.e(a.TAG, "onResponse end dataId:" + this.f8653c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.f8651a);
    }
}
