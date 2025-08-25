package anetwork.channel.aidl.j;

import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class k implements Runnable {
    k() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (i.f2180c) {
            i.f2180c = false;
            ALog.e("anet.RemoteGetter", "binding service timeout. reset status!", null, new Object[0]);
        }
    }
}
