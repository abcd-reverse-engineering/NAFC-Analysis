package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class ImageAnalysisNonBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    private static final String TAG = "NonBlockingCallback";
    final Executor mBackgroundExecutor;

    @GuardedBy("this")
    private ImageProxy mCachedImage;
    private final AtomicReference<CacheAnalyzingImageProxy> mPostedImage = new AtomicReference<>();
    private final AtomicLong mPostedImageTimestamp = new AtomicLong();

    static class CacheAnalyzingImageProxy extends ForwardingImageProxy {
        private boolean mClosed;
        WeakReference<ImageAnalysisNonBlockingAnalyzer> mNonBlockingAnalyzerWeakReference;

        CacheAnalyzingImageProxy(ImageProxy imageProxy, ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
            super(imageProxy);
            this.mClosed = false;
            this.mNonBlockingAnalyzerWeakReference = new WeakReference<>(imageAnalysisNonBlockingAnalyzer);
            addOnImageCloseListener(new ForwardingImageProxy.OnImageCloseListener() { // from class: androidx.camera.core.l
                @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
                public final void onImageClose(ImageProxy imageProxy2) {
                    this.f1514a.a(imageProxy2);
                }
            });
        }

        public /* synthetic */ void a(ImageProxy imageProxy) {
            this.mClosed = true;
            final ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer = this.mNonBlockingAnalyzerWeakReference.get();
            if (imageAnalysisNonBlockingAnalyzer != null) {
                Executor executor = imageAnalysisNonBlockingAnalyzer.mBackgroundExecutor;
                imageAnalysisNonBlockingAnalyzer.getClass();
                executor.execute(new Runnable() { // from class: androidx.camera.core.r0
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageAnalysisNonBlockingAnalyzer.analyzeCachedImage();
                    }
                });
            }
        }

        boolean isClosed() {
            return this.mClosed;
        }
    }

    ImageAnalysisNonBlockingAnalyzer(Executor executor) {
        this.mBackgroundExecutor = executor;
        open();
    }

    private synchronized void analyze(@NonNull final ImageProxy imageProxy) {
        if (isClosed()) {
            imageProxy.close();
            return;
        }
        CacheAnalyzingImageProxy cacheAnalyzingImageProxy = this.mPostedImage.get();
        if (cacheAnalyzingImageProxy != null && imageProxy.getImageInfo().getTimestamp() <= this.mPostedImageTimestamp.get()) {
            imageProxy.close();
            return;
        }
        if (cacheAnalyzingImageProxy != null && !cacheAnalyzingImageProxy.isClosed()) {
            if (this.mCachedImage != null) {
                this.mCachedImage.close();
            }
            this.mCachedImage = imageProxy;
        } else {
            CacheAnalyzingImageProxy cacheAnalyzingImageProxy2 = new CacheAnalyzingImageProxy(imageProxy, this);
            this.mPostedImage.set(cacheAnalyzingImageProxy2);
            this.mPostedImageTimestamp.set(cacheAnalyzingImageProxy2.getImageInfo().getTimestamp());
            Futures.addCallback(analyzeImage(cacheAnalyzingImageProxy2), new FutureCallback<Void>() { // from class: androidx.camera.core.ImageAnalysisNonBlockingAnalyzer.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    imageProxy.close();
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Void r1) {
                }
            }, CameraXExecutors.directExecutor());
        }
    }

    synchronized void analyzeCachedImage() {
        if (this.mCachedImage != null) {
            ImageProxy imageProxy = this.mCachedImage;
            this.mCachedImage = null;
            analyze(imageProxy);
        }
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    synchronized void close() {
        super.close();
        if (this.mCachedImage != null) {
            this.mCachedImage.close();
            this.mCachedImage = null;
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
        ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (imageProxyAcquireLatestImage == null) {
            return;
        }
        analyze(imageProxyAcquireLatestImage);
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    synchronized void open() {
        super.open();
        this.mCachedImage = null;
        this.mPostedImageTimestamp.set(-1L);
        this.mPostedImage.set(null);
    }
}
