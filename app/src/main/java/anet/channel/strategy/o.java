package anet.channel.strategy;

import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class o implements Comparator<StrategyCollection> {
    o() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(StrategyCollection strategyCollection, StrategyCollection strategyCollection2) {
        return strategyCollection.f1921b != strategyCollection2.f1921b ? (int) (strategyCollection.f1921b - strategyCollection2.f1921b) : strategyCollection.f1920a.compareTo(strategyCollection2.f1920a);
    }
}
