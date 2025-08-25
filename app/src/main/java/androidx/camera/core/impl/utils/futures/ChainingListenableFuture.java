package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
class ChainingListenableFuture<I, O> extends FutureChain<O> implements Runnable {

    @Nullable
    private AsyncFunction<? super I, ? extends O> mFunction;

    @Nullable
    private c.b.b.a.a.a<? extends I> mInputFuture;
    private final BlockingQueue<Boolean> mMayInterruptIfRunningChannel = new LinkedBlockingQueue(1);
    private final CountDownLatch mOutputCreated = new CountDownLatch(1);

    @Nullable
    volatile c.b.b.a.a.a<? extends O> mOutputFuture;

    ChainingListenableFuture(@NonNull AsyncFunction<? super I, ? extends O> asyncFunction, @NonNull c.b.b.a.a.a<? extends I> aVar) {
        this.mFunction = (AsyncFunction) Preconditions.checkNotNull(asyncFunction);
        this.mInputFuture = (c.b.b.a.a.a) Preconditions.checkNotNull(aVar);
    }

    private <E> void putUninterruptibly(@NonNull BlockingQueue<E> blockingQueue, @NonNull E e2) {
        boolean z = false;
        while (true) {
            try {
                blockingQueue.put(e2);
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private <E> E takeUninterruptibly(@NonNull BlockingQueue<E> blockingQueue) {
        E eTake;
        boolean z = false;
        while (true) {
            try {
                eTake = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return eTake;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!super.cancel(z)) {
            return false;
        }
        putUninterruptibly(this.mMayInterruptIfRunningChannel, Boolean.valueOf(z));
        cancel(this.mInputFuture, z);
        cancel(this.mOutputFuture, z);
        return true;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    @Nullable
    public O get() throws ExecutionException, InterruptedException {
        if (!isDone()) {
            c.b.b.a.a.a<? extends I> aVar = this.mInputFuture;
            if (aVar != null) {
                aVar.get();
            }
            this.mOutputCreated.await();
            c.b.b.a.a.a<? extends O> aVar2 = this.mOutputFuture;
            if (aVar2 != null) {
                aVar2.get();
            }
        }
        return (O) super.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        final c.b.b.a.a.a<? extends O> aVarApply;
        try {
        } catch (Exception e2) {
            setException(e2);
        }
        try {
            try {
                try {
                    aVarApply = this.mFunction.apply(Futures.getUninterruptibly(this.mInputFuture));
                    this.mOutputFuture = aVarApply;
                } catch (Error e3) {
                    setException(e3);
                } catch (UndeclaredThrowableException e4) {
                    setException(e4.getCause());
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e5) {
                setException(e5.getCause());
            }
            if (!isCancelled()) {
                aVarApply.addListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ChainingListenableFuture.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            try {
                                ChainingListenableFuture.this.set(Futures.getUninterruptibly(aVarApply));
                            } catch (CancellationException unused2) {
                                ChainingListenableFuture.this.cancel(false);
                                ChainingListenableFuture.this.mOutputFuture = null;
                                return;
                            } catch (ExecutionException e6) {
                                ChainingListenableFuture.this.setException(e6.getCause());
                            }
                            ChainingListenableFuture.this.mOutputFuture = null;
                        } catch (Throwable th) {
                            ChainingListenableFuture.this.mOutputFuture = null;
                            throw th;
                        }
                    }
                }, CameraXExecutors.directExecutor());
                this.mFunction = null;
                this.mInputFuture = null;
                this.mOutputCreated.countDown();
                return;
            }
            aVarApply.cancel(((Boolean) takeUninterruptibly(this.mMayInterruptIfRunningChannel)).booleanValue());
            this.mOutputFuture = null;
            this.mFunction = null;
            this.mInputFuture = null;
            this.mOutputCreated.countDown();
        } catch (Throwable th) {
            this.mFunction = null;
            this.mInputFuture = null;
            this.mOutputCreated.countDown();
            throw th;
        }
    }

    private void cancel(@Nullable Future<?> future, boolean z) {
        if (future != null) {
            future.cancel(z);
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    @Nullable
    public O get(long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (!isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j2 = timeUnit2.convert(j2, timeUnit);
                timeUnit = TimeUnit.NANOSECONDS;
            }
            c.b.b.a.a.a<? extends I> aVar = this.mInputFuture;
            if (aVar != null) {
                long jNanoTime = System.nanoTime();
                aVar.get(j2, timeUnit);
                j2 -= Math.max(0L, System.nanoTime() - jNanoTime);
            }
            long jNanoTime2 = System.nanoTime();
            if (this.mOutputCreated.await(j2, timeUnit)) {
                j2 -= Math.max(0L, System.nanoTime() - jNanoTime2);
                c.b.b.a.a.a<? extends O> aVar2 = this.mOutputFuture;
                if (aVar2 != null) {
                    aVar2.get(j2, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return (O) super.get(j2, timeUnit);
    }
}
