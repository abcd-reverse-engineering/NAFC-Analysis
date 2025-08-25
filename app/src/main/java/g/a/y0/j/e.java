package g.a.y0.j;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingHelper.java */
/* loaded from: classes2.dex */
public final class e {
    private e() {
        throw new IllegalStateException("No instances!");
    }

    public static void a(CountDownLatch countDownLatch, g.a.u0.c cVar) throws InterruptedException {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            a();
            countDownLatch.await();
        } catch (InterruptedException e2) {
            cVar.dispose();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e2);
        }
    }

    public static void a() {
        if (g.a.c1.a.y()) {
            if ((Thread.currentThread() instanceof g.a.y0.g.j) || g.a.c1.a.B()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
