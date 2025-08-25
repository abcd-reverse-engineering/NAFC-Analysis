package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Request f1889a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f1890b;

    e(d dVar, Request request) {
        this.f1890b = dVar;
        this.f1889a = request;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = b.a(this.f1889a, (RequestCb) null).f1883a;
        if (i2 > 0) {
            this.f1890b.notifyStatus(4, new anet.channel.entity.b(1));
        } else {
            this.f1890b.handleCallbacks(256, new anet.channel.entity.b(256, i2, "Http connect fail"));
        }
    }
}
