package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f1733a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f1734b;

    m(l lVar, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f1734b = lVar;
        this.f1733a = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f1733a != NetworkStatusHelper.NetworkStatus.NO && this.f1733a != NetworkStatusHelper.NetworkStatus.NONE) {
                this.f1734b.f1732a.a(NetworkStatusHelper.getUniqueId(this.f1733a));
            }
        } catch (Throwable th) {
            ALog.e("anet.MTUDetector", "MTU detecet fail.", null, th, new Object[0]);
        }
    }
}
