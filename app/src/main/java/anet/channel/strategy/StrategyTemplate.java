package anet.channel.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StrategyTemplate {
    Map<String, ConnProtocol> templateMap = new ConcurrentHashMap();

    /* compiled from: Taobao */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        static StrategyTemplate f1948a = new StrategyTemplate();

        a() {
        }
    }

    public static StrategyTemplate getInstance() {
        return a.f1948a;
    }

    public ConnProtocol getConnProtocol(String str) {
        return this.templateMap.get(str);
    }

    public void registerConnProtocol(String str, ConnProtocol connProtocol) {
        if (connProtocol != null) {
            this.templateMap.put(str, connProtocol);
            try {
                IStrategyInstance strategyCenter = StrategyCenter.getInstance();
                if (strategyCenter instanceof g) {
                    ((g) strategyCenter).f1978b.f1933c.a(str, connProtocol);
                }
            } catch (Exception unused) {
            }
        }
    }
}
