package anetwork.channel.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService[] f2202a = new ExecutorService[2];

    /* renamed from: b, reason: collision with root package name */
    private static AtomicInteger f2203b = new AtomicInteger(0);

    static {
        for (int i2 = 0; i2 < 2; i2++) {
            f2202a[i2] = Executors.newSingleThreadExecutor(new f());
        }
    }

    public static void a(int i2, Runnable runnable) {
        f2202a[Math.abs(i2 % 2)].submit(runnable);
    }
}
