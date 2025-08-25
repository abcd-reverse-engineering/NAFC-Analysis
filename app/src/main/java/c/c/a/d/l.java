package c.c.a.d;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: TaskExecutors.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: d, reason: collision with root package name */
    private static final l f3137d = new l();

    /* renamed from: a, reason: collision with root package name */
    private final Executor f3138a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f3139b = com.hihonor.cloudservice.tasks.q.g.b();

    /* renamed from: c, reason: collision with root package name */
    private final Executor f3140c = com.hihonor.cloudservice.tasks.q.g.a();

    /* compiled from: TaskExecutors.java */
    static final class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private l() {
    }

    static ExecutorService a() {
        return f3137d.f3139b;
    }

    public static Executor b() {
        return f3137d.f3138a;
    }

    public static Executor c() {
        return f3137d.f3140c;
    }
}
