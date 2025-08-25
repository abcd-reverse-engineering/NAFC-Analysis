package anet.channel.e;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class d implements NetworkStatusHelper.INetworkStatusChangeListener {
    d() {
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        a.a(networkStatus);
    }
}
