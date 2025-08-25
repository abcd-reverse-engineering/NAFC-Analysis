package a.a.t;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class f implements Future<a.a.i> {

    /* renamed from: a, reason: collision with root package name */
    private m f1195a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1196b;

    public f(m mVar) {
        this.f1195a = mVar;
    }

    @Override // java.util.concurrent.Future
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a.a.i get() throws ExecutionException, InterruptedException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public a.a.i b() throws ExecutionException, InterruptedException, TimeoutException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!this.f1196b) {
            this.f1195a.b();
            this.f1196b = true;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f1196b;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public /* synthetic */ a.a.i get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return b();
    }
}
