package anet.channel.strategy;

import anet.channel.strategy.StrategyList;
import anet.channel.strategy.l;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class j implements StrategyList.Predicate<IPConnStrategy> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l.a f1984a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1985b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ConnProtocol f1986c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrategyList f1987d;

    j(StrategyList strategyList, l.a aVar, String str, ConnProtocol connProtocol) {
        this.f1987d = strategyList;
        this.f1984a = aVar;
        this.f1985b = str;
        this.f1986c = connProtocol;
    }

    @Override // anet.channel.strategy.StrategyList.Predicate
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(IPConnStrategy iPConnStrategy) {
        return iPConnStrategy.getPort() == this.f1984a.f1989a && iPConnStrategy.getIp().equals(this.f1985b) && iPConnStrategy.protocol.equals(this.f1986c);
    }
}
