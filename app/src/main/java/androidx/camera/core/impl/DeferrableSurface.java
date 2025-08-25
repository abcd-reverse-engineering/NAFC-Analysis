package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class DeferrableSurface {
    private static final boolean DEBUG = false;
    protected static final String TAG = "DeferrableSurface";

    @GuardedBy("mLock")
    private CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private static AtomicInteger sUsedCount = new AtomicInteger(0);
    private static AtomicInteger sTotalCount = new AtomicInteger(0);
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private int mUseCount = 0;

    @GuardedBy("mLock")
    private boolean mClosed = false;
    private final c.b.b.a.a.a<Void> mTerminationFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.c
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            return this.f1487a.a(completer);
        }
    });

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SurfaceClosedException extends Exception {
        DeferrableSurface mDeferrableSurface;

        public SurfaceClosedException(@NonNull String str, @NonNull DeferrableSurface deferrableSurface) {
            super(str);
            this.mDeferrableSurface = deferrableSurface;
        }

        @NonNull
        public DeferrableSurface getDeferrableSurface() {
            return this.mDeferrableSurface;
        }
    }

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(@NonNull String str) {
            super(str);
        }
    }

    private /* synthetic */ void lambda$new$1(String str) throws ExecutionException, InterruptedException {
        try {
            this.mTerminationFuture.get();
            printGlobalDebugCounts("Surface terminated", sTotalCount.decrementAndGet(), sUsedCount.get());
        } catch (Exception e2) {
            String str2 = "Unexpected surface termination for " + this + "\nStack Trace:\n" + str;
            throw new IllegalArgumentException("DeferrableSurface terminated with unexpected exception.", e2);
        }
    }

    private void printGlobalDebugCounts(@NonNull String str, int i2, int i3) {
        String str2 = str + "[total_surfaces=" + i2 + ", used_surfaces=" + i3 + "](" + this + "}";
    }

    public /* synthetic */ Object a(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mTerminationCompleter = completer;
        }
        return "DeferrableSurface-termination(" + this + ")";
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            boolean r1 = r3.mClosed     // Catch: java.lang.Throwable -> L1c
            r2 = 0
            if (r1 != 0) goto L14
            r1 = 1
            r3.mClosed = r1     // Catch: java.lang.Throwable -> L1c
            int r1 = r3.mUseCount     // Catch: java.lang.Throwable -> L1c
            if (r1 != 0) goto L14
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r1 = r3.mTerminationCompleter     // Catch: java.lang.Throwable -> L1c
            r3.mTerminationCompleter = r2     // Catch: java.lang.Throwable -> L1c
            goto L15
        L14:
            r1 = r2
        L15:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L1b
            r1.set(r2)
        L1b:
            return
        L1c:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.DeferrableSurface.close():void");
    }

    public void decrementUseCount() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            if (this.mUseCount == 0) {
                throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
            }
            this.mUseCount--;
            if (this.mUseCount == 0 && this.mClosed) {
                completer = this.mTerminationCompleter;
                this.mTerminationCompleter = null;
            } else {
                completer = null;
            }
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    @NonNull
    public final c.b.b.a.a.a<Surface> getSurface() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return Futures.immediateFailedFuture(new SurfaceClosedException("DeferrableSurface already closed.", this));
            }
            return provideSurface();
        }
    }

    @NonNull
    public c.b.b.a.a.a<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public int getUseCount() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mUseCount;
        }
        return i2;
    }

    public void incrementUseCount() throws SurfaceClosedException {
        synchronized (this.mLock) {
            if (this.mUseCount == 0 && this.mClosed) {
                throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
            }
            this.mUseCount++;
        }
    }

    @NonNull
    protected abstract c.b.b.a.a.a<Surface> provideSurface();
}
