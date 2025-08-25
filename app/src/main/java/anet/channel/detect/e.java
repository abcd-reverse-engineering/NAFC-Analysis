package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class e implements IStrategyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f1719a;

    e(d dVar) {
        this.f1719a = dVar;
    }

    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(l.d dVar) {
        l.c[] cVarArr;
        ALog.i("anet.HorseRaceDetector", "onStrategyUpdated", null, new Object[0]);
        if (!AwcnConfig.isHorseRaceEnable() || (cVarArr = dVar.f2013c) == null || cVarArr.length == 0) {
            return;
        }
        synchronized (this.f1719a.f1717a) {
            for (int i2 = 0; i2 < dVar.f2013c.length; i2++) {
                l.c cVar = dVar.f2013c[i2];
                this.f1719a.f1717a.put(cVar.f2009a, cVar);
            }
        }
    }
}
