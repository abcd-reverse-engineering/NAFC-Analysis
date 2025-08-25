package g.a.u0;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureDisposable.java */
/* loaded from: classes2.dex */
final class e extends AtomicReference<Future<?>> implements c {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    e(Future<?> future, boolean z) {
        super(future);
        this.allowInterrupt = z;
    }

    @Override // g.a.u0.c
    public void dispose() {
        Future<?> andSet = getAndSet(null);
        if (andSet != null) {
            andSet.cancel(this.allowInterrupt);
        }
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        Future<?> future = get();
        return future == null || future.isDone();
    }
}
