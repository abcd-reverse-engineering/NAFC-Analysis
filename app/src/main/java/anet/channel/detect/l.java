package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class l implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f1732a;

    l(k kVar) {
        this.f1732a = kVar;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        ThreadPoolExecutorFactory.submitDetectTask(new m(this, networkStatus));
    }
}
