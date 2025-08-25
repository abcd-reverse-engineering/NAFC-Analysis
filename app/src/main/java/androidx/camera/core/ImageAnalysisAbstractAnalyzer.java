package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private final Object mAnalyzerLock = new Object();
    private AtomicBoolean mIsClosed = new AtomicBoolean(false);
    private volatile int mRelativeRotation;

    @GuardedBy("mAnalyzerLock")
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;

    @GuardedBy("mAnalyzerLock")
    private Executor mUserExecutor;

    ImageAnalysisAbstractAnalyzer() {
    }

    public /* synthetic */ Object a(Executor executor, final ImageProxy imageProxy, final ImageAnalysis.Analyzer analyzer, final CallbackToFutureAdapter.Completer completer) throws Exception {
        executor.execute(new Runnable() { // from class: androidx.camera.core.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f1508a.a(imageProxy, analyzer, completer);
            }
        });
        return "analyzeImage";
    }

    c.b.b.a.a.a<Void> analyzeImage(final ImageProxy imageProxy) {
        final Executor executor;
        final ImageAnalysis.Analyzer analyzer;
        synchronized (this.mAnalyzerLock) {
            executor = this.mUserExecutor;
            analyzer = this.mSubscribedAnalyzer;
        }
        return (analyzer == null || executor == null) ? Futures.immediateFailedFuture(new OperationCanceledException("No analyzer or executor currently set.")) : CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.j
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f1502a.a(executor, imageProxy, analyzer, completer);
            }
        });
    }

    void close() {
        this.mIsClosed.set(true);
    }

    boolean isClosed() {
        return this.mIsClosed.get();
    }

    void open() {
        this.mIsClosed.set(false);
    }

    void setAnalyzer(@Nullable Executor executor, @Nullable ImageAnalysis.Analyzer analyzer) {
        synchronized (this.mAnalyzerLock) {
            this.mSubscribedAnalyzer = analyzer;
            this.mUserExecutor = executor;
        }
    }

    void setRelativeRotation(int i2) {
        this.mRelativeRotation = i2;
    }

    public /* synthetic */ void a(ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        if (isClosed()) {
            completer.setException(new OperationCanceledException("Closed before analysis"));
        } else {
            analyzer.analyze(new SettableImageProxy(imageProxy, ImmutableImageInfo.create(imageProxy.getImageInfo().getTag(), imageProxy.getImageInfo().getTimestamp(), this.mRelativeRotation)));
            completer.set(null);
        }
    }
}
