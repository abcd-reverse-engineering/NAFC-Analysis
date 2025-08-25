package g.a.y0.g;

/* compiled from: ScheduledDirectPeriodicTask.java */
/* loaded from: classes2.dex */
public final class l extends a implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public l(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
        } finally {
            try {
            } finally {
            }
        }
    }
}
