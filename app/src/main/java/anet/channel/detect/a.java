package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class a implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExceptionDetector f1713a;

    a(ExceptionDetector exceptionDetector) {
        this.f1713a = exceptionDetector;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        ThreadPoolExecutorFactory.submitDetectTask(new b(this));
    }
}
