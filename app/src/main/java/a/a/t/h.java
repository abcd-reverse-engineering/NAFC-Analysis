package a.a.t;

import anet.channel.thread.ThreadPoolExecutorFactory;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f1213a;

    h(g gVar) {
        this.f1213a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(this.f1213a, ThreadPoolExecutorFactory.Priority.HIGH);
    }
}
