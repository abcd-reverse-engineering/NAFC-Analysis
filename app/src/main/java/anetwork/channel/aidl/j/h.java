package anetwork.channel.aidl.j;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f2175a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f2176b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f2177c;

    h(e eVar, byte b2, Object obj) {
        this.f2177c = eVar;
        this.f2175a = b2;
        this.f2176b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2177c.b(this.f2175a, this.f2176b);
    }
}
