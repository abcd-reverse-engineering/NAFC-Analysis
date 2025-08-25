package anet.channel.detect;

import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.l;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class j implements IConnStrategy {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l.e f1729a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ConnProtocol f1730b;

    j(l.e eVar, ConnProtocol connProtocol) {
        this.f1729a = eVar;
        this.f1730b = connProtocol;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.f1729a.f2020b.f1991c;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return 0;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.f1729a.f2019a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return 2;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return 1;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.f1729a.f2020b.f1989a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        return this.f1730b;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.f1729a.f2020b.f1992d;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return 0;
    }
}
