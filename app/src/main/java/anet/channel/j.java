package anet.channel;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class j implements Runnable {
    j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            anet.channel.b.a aVar = new anet.channel.b.a();
            aVar.a();
            a.a.j.b.a(aVar, new k(this), 1);
        } catch (Exception unused) {
        }
    }
}
