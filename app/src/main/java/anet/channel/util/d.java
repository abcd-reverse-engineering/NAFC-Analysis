package anet.channel.util;

import anet.channel.statist.NetTypeStat;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2052a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NetTypeStat f2053b;

    d(String str, NetTypeStat netTypeStat) {
        this.f2052a = str;
        this.f2053b = netTypeStat;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(new e(this), ThreadPoolExecutorFactory.Priority.LOW);
    }
}
