package g.a.s0.e;

import android.os.Handler;
import android.os.Message;
import g.a.j0;
import g.a.u0.c;
import g.a.u0.d;
import java.util.concurrent.TimeUnit;

/* compiled from: HandlerScheduler.java */
/* loaded from: classes2.dex */
final class b extends j0 {

    /* renamed from: b, reason: collision with root package name */
    private final Handler f13861b;

    /* compiled from: HandlerScheduler.java */
    private static final class a extends j0.c {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f13862a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f13863b;

        a(Handler handler) {
            this.f13862a = handler;
        }

        @Override // g.a.j0.c
        public c a(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f13863b) {
                return d.a();
            }
            RunnableC0178b runnableC0178b = new RunnableC0178b(this.f13862a, g.a.c1.a.a(runnable));
            Message messageObtain = Message.obtain(this.f13862a, runnableC0178b);
            messageObtain.obj = this;
            this.f13862a.sendMessageDelayed(messageObtain, Math.max(0L, timeUnit.toMillis(j2)));
            if (!this.f13863b) {
                return runnableC0178b;
            }
            this.f13862a.removeCallbacks(runnableC0178b);
            return d.a();
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f13863b = true;
            this.f13862a.removeCallbacksAndMessages(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f13863b;
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: g.a.s0.e.b$b, reason: collision with other inner class name */
    private static final class RunnableC0178b implements Runnable, c {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f13864a;

        /* renamed from: b, reason: collision with root package name */
        private final Runnable f13865b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f13866c;

        RunnableC0178b(Handler handler, Runnable runnable) {
            this.f13864a = handler;
            this.f13865b = runnable;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f13866c = true;
            this.f13864a.removeCallbacks(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f13866c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f13865b.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                g.a.c1.a.b(illegalStateException);
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
            }
        }
    }

    b(Handler handler) {
        this.f13861b = handler;
    }

    @Override // g.a.j0
    public c a(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        RunnableC0178b runnableC0178b = new RunnableC0178b(this.f13861b, g.a.c1.a.a(runnable));
        this.f13861b.postDelayed(runnableC0178b, Math.max(0L, timeUnit.toMillis(j2)));
        return runnableC0178b;
    }

    @Override // g.a.j0
    public j0.c a() {
        return new a(this.f13861b);
    }
}
