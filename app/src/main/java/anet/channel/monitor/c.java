package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class c implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f1821a;

    c(b bVar) {
        this.f1821a = bVar;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f1821a.n.a();
        b.f1812f = 0L;
        this.f1821a.d();
    }
}
