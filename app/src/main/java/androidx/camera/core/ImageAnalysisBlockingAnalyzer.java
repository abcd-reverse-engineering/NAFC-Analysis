package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;

/* loaded from: classes.dex */
final class ImageAnalysisBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    ImageAnalysisBlockingAnalyzer() {
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
        final ImageProxy imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
        if (imageProxyAcquireNextImage == null) {
            return;
        }
        Futures.addCallback(analyzeImage(imageProxyAcquireNextImage), new FutureCallback<Void>() { // from class: androidx.camera.core.ImageAnalysisBlockingAnalyzer.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                imageProxyAcquireNextImage.close();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r1) {
            }
        }, CameraXExecutors.directExecutor());
    }
}
