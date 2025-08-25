package anetwork.channel.entity;

import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class f implements ThreadFactory {
    f() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, String.format("RepeaterThread:%d", Integer.valueOf(e.f2203b.getAndIncrement())));
    }
}
