package androidx.camera.core;

import android.annotation.SuppressLint;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SurfaceRequest {
    private DeferrableSurface mInternalDeferrableSurface;
    private final CallbackToFutureAdapter.Completer<Void> mRequestCancellationCompleter;
    private final Size mResolution;
    private final c.b.b.a.a.a<Void> mSessionStatusFuture;
    private final CallbackToFutureAdapter.Completer<Surface> mSurfaceCompleter;
    final c.b.b.a.a.a<Surface> mSurfaceFuture;

    private static final class RequestCancelledException extends RuntimeException {
        RequestCancelledException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @c.b.a.a.c
    public static abstract class Result {
        public static final int RESULT_INVALID_SURFACE = 2;
        public static final int RESULT_REQUEST_CANCELLED = 1;
        public static final int RESULT_SURFACE_ALREADY_PROVIDED = 3;
        public static final int RESULT_SURFACE_USED_SUCCESSFULLY = 0;
        public static final int RESULT_WILL_NOT_PROVIDE_SURFACE = 4;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ResultCode {
        }

        Result() {
        }

        @NonNull
        static Result of(int i2, @NonNull Surface surface) {
            return new AutoValue_SurfaceRequest_Result(i2, surface);
        }

        public abstract int getResultCode();

        @NonNull
        public abstract Surface getSurface();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SurfaceRequest(@NonNull Size size) {
        this.mResolution = size;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        final AtomicReference atomicReference = new AtomicReference(null);
        final c.b.b.a.a.a future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.m0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return SurfaceRequest.a(atomicReference, str, completer);
            }
        });
        final CallbackToFutureAdapter.Completer<Void> completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull(atomicReference.get());
        this.mRequestCancellationCompleter = completer;
        final AtomicReference atomicReference2 = new AtomicReference(null);
        this.mSessionStatusFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.n0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer2) {
                return SurfaceRequest.b(atomicReference2, str, completer2);
            }
        });
        Futures.addCallback(this.mSessionStatusFuture, new FutureCallback<Void>() { // from class: androidx.camera.core.SurfaceRequest.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                if (th instanceof RequestCancelledException) {
                    Preconditions.checkState(future.cancel(false));
                } else {
                    Preconditions.checkState(completer.set(null));
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r2) {
                Preconditions.checkState(completer.set(null));
            }
        }, CameraXExecutors.directExecutor());
        final CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull(atomicReference2.get());
        final AtomicReference atomicReference3 = new AtomicReference(null);
        this.mSurfaceFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.k0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer3) {
                return SurfaceRequest.c(atomicReference3, str, completer3);
            }
        });
        this.mSurfaceCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull(atomicReference3.get());
        this.mInternalDeferrableSurface = new DeferrableSurface() { // from class: androidx.camera.core.SurfaceRequest.2
            @Override // androidx.camera.core.impl.DeferrableSurface
            @NonNull
            protected c.b.b.a.a.a<Surface> provideSurface() {
                return SurfaceRequest.this.mSurfaceFuture;
            }
        };
        final c.b.b.a.a.a<Void> terminationFuture = this.mInternalDeferrableSurface.getTerminationFuture();
        Futures.addCallback(this.mSurfaceFuture, new FutureCallback<Surface>() { // from class: androidx.camera.core.SurfaceRequest.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                if (!(th instanceof CancellationException)) {
                    completer2.set(null);
                    return;
                }
                Preconditions.checkState(completer2.setException(new RequestCancelledException(str + " cancelled.", th)));
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Surface surface) {
                Futures.propagate(terminationFuture, completer2);
            }
        }, CameraXExecutors.directExecutor());
        terminationFuture.addListener(new Runnable() { // from class: androidx.camera.core.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1515a.a();
            }
        }, CameraXExecutors.directExecutor());
    }

    static /* synthetic */ Object a(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-cancellation";
    }

    static /* synthetic */ Object b(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-status";
    }

    static /* synthetic */ Object c(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-Surface";
    }

    @SuppressLint({"PairedRegistration"})
    public void addRequestCancellationListener(@NonNull Executor executor, @NonNull Runnable runnable) {
        this.mRequestCancellationCompleter.addCancellationListener(runnable, executor);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DeferrableSurface getDeferrableSurface() {
        return this.mInternalDeferrableSurface;
    }

    @NonNull
    public Size getResolution() {
        return this.mResolution;
    }

    public void provideSurface(@NonNull final Surface surface, @NonNull Executor executor, @NonNull final Consumer<Result> consumer) throws ExecutionException, InterruptedException {
        if (this.mSurfaceCompleter.set(surface) || this.mSurfaceFuture.isCancelled()) {
            Futures.addCallback(this.mSessionStatusFuture, new FutureCallback<Void>() { // from class: androidx.camera.core.SurfaceRequest.4
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    Preconditions.checkState(th instanceof RequestCancelledException, "Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th);
                    consumer.accept(Result.of(1, surface));
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r3) {
                    consumer.accept(Result.of(0, surface));
                }
            }, executor);
            return;
        }
        Preconditions.checkState(this.mSurfaceFuture.isDone());
        try {
            this.mSurfaceFuture.get();
            executor.execute(new Runnable() { // from class: androidx.camera.core.j0
                @Override // java.lang.Runnable
                public final void run() {
                    consumer.accept(SurfaceRequest.Result.of(3, surface));
                }
            });
        } catch (InterruptedException | ExecutionException unused) {
            executor.execute(new Runnable() { // from class: androidx.camera.core.i0
                @Override // java.lang.Runnable
                public final void run() {
                    consumer.accept(SurfaceRequest.Result.of(4, surface));
                }
            });
        }
    }

    public boolean willNotProvideSurface() {
        return this.mSurfaceCompleter.setException(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }

    public /* synthetic */ void a() {
        this.mSurfaceFuture.cancel(true);
    }
}
