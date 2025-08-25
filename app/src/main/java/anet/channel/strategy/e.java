package anet.channel.strategy;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1973a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrategyInfoHolder f1974b;

    e(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f1974b = strategyInfoHolder;
        this.f1973a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1974b.a(this.f1973a, true);
    }
}
