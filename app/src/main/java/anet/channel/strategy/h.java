package anet.channel.strategy;

import anet.channel.AwcnConfig;
import anet.channel.entity.ConnType;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class h implements IStrategyFilter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f1982a;

    h(g gVar) {
        this.f1982a = gVar;
    }

    @Override // anet.channel.strategy.IStrategyFilter
    public boolean accept(IConnStrategy iConnStrategy) {
        String str = iConnStrategy.getProtocol().protocol;
        if (ConnType.QUIC.equals(str) || ConnType.QUIC_PLAIN.equals(str)) {
            ALog.i("awcn.StrategyCenter", "gquic strategy disabled", null, Constants.KEY_STRATEGY, iConnStrategy);
            return false;
        }
        boolean zIsHttp3Enable = AwcnConfig.isHttp3Enable();
        boolean zB = anet.channel.e.a.b();
        if ((zIsHttp3Enable && zB) || (!ConnType.HTTP3.equals(str) && !ConnType.HTTP3_PLAIN.equals(str))) {
            return true;
        }
        ALog.i("awcn.StrategyCenter", "http3 strategy disabled", null, Constants.KEY_STRATEGY, iConnStrategy);
        return false;
    }
}
