package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class f implements AppLifecycle.AppLifecycleListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f1720a;

    f(d dVar) {
        this.f1720a = dVar;
    }

    @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
    public void background() {
        ALog.i("anet.HorseRaceDetector", "background", null, new Object[0]);
        if (AwcnConfig.isHorseRaceEnable()) {
            ThreadPoolExecutorFactory.submitHRTask(new g(this));
        }
    }

    @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
    public void forground() {
    }
}
