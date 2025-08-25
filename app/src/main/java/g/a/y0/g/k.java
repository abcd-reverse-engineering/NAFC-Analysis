package g.a.y0.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: RxThreadFactory.java */
/* loaded from: classes2.dex */
public final class k extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    /* compiled from: RxThreadFactory.java */
    static final class a extends Thread implements j {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public k(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.prefix + '-' + incrementAndGet();
        Thread aVar = this.nonBlocking ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.priority);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }

    public k(String str, int i2) {
        this(str, i2, false);
    }

    public k(String str, int i2, boolean z) {
        this.prefix = str;
        this.priority = i2;
        this.nonBlocking = z;
    }
}
