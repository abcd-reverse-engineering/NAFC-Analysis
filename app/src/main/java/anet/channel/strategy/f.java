package anet.channel.strategy;

import anet.channel.statist.StrategyStatObject;
import anet.channel.strategy.StrategyInfoHolder;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f1975a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrategyInfoHolder.LruStrategyMap f1976b;

    f(StrategyInfoHolder.LruStrategyMap lruStrategyMap, Map.Entry entry) {
        this.f1976b = lruStrategyMap;
        this.f1975a = entry;
    }

    @Override // java.lang.Runnable
    public void run() {
        StrategyTable strategyTable = (StrategyTable) this.f1975a.getValue();
        if (strategyTable.f1945d) {
            StrategyStatObject strategyStatObject = new StrategyStatObject(1);
            strategyStatObject.writeStrategyFileId = strategyTable.f1942a;
            m.a((Serializable) this.f1975a.getValue(), strategyTable.f1942a, strategyStatObject);
            strategyTable.f1945d = false;
        }
    }
}
