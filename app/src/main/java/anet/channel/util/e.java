package anet.channel.util;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f2054a;

    e(d dVar) {
        this.f2054a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVarK;
        try {
            if (this.f2054a.f2052a.equals(c.b(NetworkStatusHelper.getStatus()))) {
                ALog.e("awcn.Inet64Util", "startIpStackDetect double check", null, new Object[0]);
                int iJ = c.j();
                if (this.f2054a.f2053b.ipStackType != iJ) {
                    c.f2051e.put(this.f2054a.f2052a, Integer.valueOf(iJ));
                    this.f2054a.f2053b.lastIpStackType = this.f2054a.f2053b.ipStackType;
                    this.f2054a.f2053b.ipStackType = iJ;
                }
                if ((iJ == 2 || iJ == 3) && (fVarK = c.k()) != null) {
                    c.f2050d.put(this.f2054a.f2052a, fVarK);
                    this.f2054a.f2053b.nat64Prefix = fVarK.toString();
                }
                if (GlobalAppRuntimeInfo.isTargetProcess()) {
                    AppMonitor.getInstance().commitStat(this.f2054a.f2053b);
                }
            }
        } catch (Exception unused) {
        }
    }
}
