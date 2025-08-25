package anet.channel.strategy;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f1983a;

    i(g gVar) {
        this.f1983a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1983a.a()) {
            return;
        }
        this.f1983a.f1978b.c();
    }
}
