package com.bumptech.glide.load.p.c0;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: GlideExecutor.java */
/* loaded from: classes.dex */
public final class a implements ExecutorService {

    /* renamed from: b, reason: collision with root package name */
    private static final String f4458b = "source";

    /* renamed from: c, reason: collision with root package name */
    private static final String f4459c = "disk-cache";

    /* renamed from: d, reason: collision with root package name */
    private static final int f4460d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final String f4461e = "GlideExecutor";

    /* renamed from: f, reason: collision with root package name */
    private static final String f4462f = "source-unlimited";

    /* renamed from: g, reason: collision with root package name */
    private static final String f4463g = "animation";

    /* renamed from: h, reason: collision with root package name */
    private static final long f4464h = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: i, reason: collision with root package name */
    private static final int f4465i = 4;

    /* renamed from: j, reason: collision with root package name */
    private static volatile int f4466j;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f4467a;

    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.p.c0.a$a, reason: collision with other inner class name */
    public static final class C0060a {

        /* renamed from: g, reason: collision with root package name */
        public static final long f4468g = 0;

        /* renamed from: a, reason: collision with root package name */
        private final boolean f4469a;

        /* renamed from: b, reason: collision with root package name */
        private int f4470b;

        /* renamed from: c, reason: collision with root package name */
        private int f4471c;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        private c f4472d = c.f4484d;

        /* renamed from: e, reason: collision with root package name */
        private String f4473e;

        /* renamed from: f, reason: collision with root package name */
        private long f4474f;

        C0060a(boolean z) {
            this.f4469a = z;
        }

        public C0060a a(long j2) {
            this.f4474f = j2;
            return this;
        }

        public C0060a a(@IntRange(from = 1) int i2) {
            this.f4470b = i2;
            this.f4471c = i2;
            return this;
        }

        public C0060a a(@NonNull c cVar) {
            this.f4472d = cVar;
            return this;
        }

        public C0060a a(String str) {
            this.f4473e = str;
            return this;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f4473e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f4470b, this.f4471c, this.f4474f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f4473e, this.f4472d, this.f4469a));
                if (this.f4474f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f4473e);
        }
    }

    /* compiled from: GlideExecutor.java */
    private static final class b implements ThreadFactory {

        /* renamed from: e, reason: collision with root package name */
        private static final int f4475e = 9;

        /* renamed from: a, reason: collision with root package name */
        private final String f4476a;

        /* renamed from: b, reason: collision with root package name */
        final c f4477b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f4478c;

        /* renamed from: d, reason: collision with root package name */
        private int f4479d;

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.p.c0.a$b$a, reason: collision with other inner class name */
        class C0061a extends Thread {
            C0061a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(9);
                if (b.this.f4478c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    b.this.f4477b.a(th);
                }
            }
        }

        b(String str, c cVar, boolean z) {
            this.f4476a = str;
            this.f4477b = cVar;
            this.f4478c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0061a c0061a;
            c0061a = new C0061a(runnable, "glide-" + this.f4476a + "-thread-" + this.f4479d);
            this.f4479d = this.f4479d + 1;
            return c0061a;
        }
    }

    /* compiled from: GlideExecutor.java */
    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f4481a = new C0062a();

        /* renamed from: b, reason: collision with root package name */
        public static final c f4482b = new b();

        /* renamed from: c, reason: collision with root package name */
        public static final c f4483c = new C0063c();

        /* renamed from: d, reason: collision with root package name */
        public static final c f4484d = f4482b;

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.p.c0.a$c$a, reason: collision with other inner class name */
        class C0062a implements c {
            C0062a() {
            }

            @Override // com.bumptech.glide.load.p.c0.a.c
            public void a(Throwable th) {
            }
        }

        /* compiled from: GlideExecutor.java */
        class b implements c {
            b() {
            }

            @Override // com.bumptech.glide.load.p.c0.a.c
            public void a(Throwable th) {
                if (th != null) {
                    Log.isLoggable(a.f4461e, 6);
                }
            }
        }

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.p.c0.a$c$c, reason: collision with other inner class name */
        class C0063c implements c {
            C0063c() {
            }

            @Override // com.bumptech.glide.load.p.c0.a.c
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        void a(Throwable th);
    }

    @VisibleForTesting
    a(ExecutorService executorService) {
        this.f4467a = executorService;
    }

    @Deprecated
    public static a a(c cVar) {
        return d().a(cVar).a();
    }

    @Deprecated
    public static a b(c cVar) {
        return f().a(cVar).a();
    }

    public static a c() {
        return b().a();
    }

    public static C0060a d() {
        return new C0060a(true).a(1).a(f4459c);
    }

    public static a e() {
        return d().a();
    }

    public static C0060a f() {
        return new C0060a(false).a(a()).a("source");
    }

    public static a g() {
        return f().a();
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f4464h, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b(f4462f, c.f4484d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f4467a.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f4467a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f4467a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f4467a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f4467a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f4467a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f4467a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f4467a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f4467a.submit(runnable);
    }

    public String toString() {
        return this.f4467a.toString();
    }

    @Deprecated
    public static a a(int i2, String str, c cVar) {
        return d().a(i2).a(str).a(cVar).a();
    }

    @Deprecated
    public static a b(int i2, String str, c cVar) {
        return f().a(i2).a(str).a(cVar).a();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f4467a.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f4467a.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f4467a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f4467a.submit(callable);
    }

    @Deprecated
    public static a a(int i2, c cVar) {
        return b().a(i2).a(cVar).a();
    }

    public static C0060a b() {
        return new C0060a(true).a(a() >= 4 ? 2 : 1).a(f4463g);
    }

    public static int a() {
        if (f4466j == 0) {
            f4466j = Math.min(4, com.bumptech.glide.load.p.c0.b.a());
        }
        return f4466j;
    }
}
