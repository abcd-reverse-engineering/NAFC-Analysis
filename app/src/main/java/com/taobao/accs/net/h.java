package com.taobao.accs.net;

import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private int f8529a = 0;

    /* renamed from: b, reason: collision with root package name */
    private List<IConnStrategy> f8530b = new ArrayList();

    public h(String str) {
        HttpDispatcher.getInstance().addListener(new i(this));
        a(str);
    }

    public List<IConnStrategy> a(String str) {
        List<IConnStrategy> connStrategyListByHost;
        if ((this.f8529a == 0 || this.f8530b.isEmpty()) && (connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str)) != null && !connStrategyListByHost.isEmpty()) {
            this.f8530b.clear();
            for (IConnStrategy iConnStrategy : connStrategyListByHost) {
                ConnType connTypeValueOf = ConnType.valueOf(iConnStrategy.getProtocol());
                if (connTypeValueOf.getTypeLevel() == ConnType.TypeLevel.SPDY && connTypeValueOf.isSSL()) {
                    this.f8530b.add(iConnStrategy);
                }
            }
        }
        return this.f8530b;
    }

    public void b() {
        this.f8529a++;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("HttpDnsProvider", "updateStrategyPos StrategyPos:" + this.f8529a, new Object[0]);
        }
    }

    public int c() {
        return this.f8529a;
    }

    public void b(String str) {
        StrategyCenter.getInstance().forceRefreshStrategy(str);
    }

    public IConnStrategy a() {
        return a(this.f8530b);
    }

    public IConnStrategy a(List<IConnStrategy> list) {
        if (list != null && !list.isEmpty()) {
            int i2 = this.f8529a;
            if (i2 < 0 || i2 >= list.size()) {
                this.f8529a = 0;
            }
            return list.get(this.f8529a);
        }
        ALog.d("HttpDnsProvider", "strategys null or 0", new Object[0]);
        return null;
    }
}
