package anet.channel.status;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f1899a;

    a(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f1899a = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Iterator<NetworkStatusHelper.INetworkStatusChangeListener> it = NetworkStatusHelper.listeners.iterator();
            while (it.hasNext()) {
                NetworkStatusHelper.INetworkStatusChangeListener next = it.next();
                long jCurrentTimeMillis = System.currentTimeMillis();
                next.onNetworkStatusChanged(this.f1899a);
                if (System.currentTimeMillis() - jCurrentTimeMillis > 500) {
                    ALog.e("awcn.NetworkStatusHelper", "call back cost too much time", null, "listener", next);
                }
            }
        } catch (Exception unused) {
        }
    }
}
