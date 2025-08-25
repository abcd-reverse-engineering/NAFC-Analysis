package org.android.agoo.control;

import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseIntentService f17343a;

    j(BaseIntentService baseIntentService) {
        this.f17343a = baseIntentService;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.taobao.accs.client.a.f8410f.incrementAndGet();
        this.f17343a.notifyManager = new NotifManager();
        this.f17343a.notifyManager.init(this.f17343a.getApplicationContext());
        this.f17343a.messageService = new MessageService();
        this.f17343a.messageService.a(this.f17343a.getApplicationContext());
        this.f17343a.agooFactory = new AgooFactory();
        this.f17343a.agooFactory.init(this.f17343a.getApplicationContext(), this.f17343a.notifyManager, this.f17343a.messageService);
    }
}
