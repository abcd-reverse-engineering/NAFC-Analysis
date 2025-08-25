package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class b implements ThreadFactory {
    b() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AMDC" + a.f2026a.incrementAndGet());
        ALog.i(anet.channel.strategy.dispatch.a.TAG, "thread created!", null, CommonNetImpl.NAME, thread.getName());
        thread.setPriority(5);
        return thread;
    }
}
