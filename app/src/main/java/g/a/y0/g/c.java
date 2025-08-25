package g.a.y0.g;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: DisposeOnCancel.java */
/* loaded from: classes2.dex */
final class c implements Future<Object> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.u0.c f15913a;

    c(g.a.u0.c cVar) {
        this.f15913a = cVar;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.f15913a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }
}
