package anet.channel.strategy;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StrategyCenter {
    private static volatile IStrategyInstance instance;

    private StrategyCenter() {
    }

    public static IStrategyInstance getInstance() {
        if (instance == null) {
            synchronized (StrategyCenter.class) {
                if (instance == null) {
                    instance = new g();
                }
            }
        }
        return instance;
    }

    public static void setInstance(IStrategyInstance iStrategyInstance) {
        instance = iStrategyInstance;
    }
}
