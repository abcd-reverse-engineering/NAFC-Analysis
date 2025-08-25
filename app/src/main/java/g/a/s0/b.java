package g.a.s0;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MainThreadDisposable.java */
/* loaded from: classes2.dex */
public abstract class b implements g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f13855a = new AtomicBoolean();

    /* compiled from: MainThreadDisposable.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a();
        }
    }

    public static void b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }

    protected abstract void a();

    @Override // g.a.u0.c
    public final void dispose() {
        if (this.f13855a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                g.a.s0.e.a.a().a(new a());
            }
        }
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return this.f13855a.get();
    }
}
