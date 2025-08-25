package g.a.y0.g;

import java.util.concurrent.Callable;

/* compiled from: ScheduledDirectTask.java */
/* loaded from: classes2.dex */
public final class m extends a implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public m(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            return null;
        } finally {
            lazySet(a.FINISHED);
            this.runner = null;
        }
    }
}
