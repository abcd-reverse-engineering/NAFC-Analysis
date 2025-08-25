package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxyDownsampler;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class ForwardingImageReaderListener implements ImageReaderProxy.OnImageAvailableListener {

    @GuardedBy("this")
    private final List<QueuedImageReaderProxy> mImageReaders;

    ForwardingImageReaderListener(List<QueuedImageReaderProxy> list) {
        this.mImageReaders = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public synchronized void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
        ImageProxy imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
        if (imageProxyAcquireNextImage == null) {
            return;
        }
        ReferenceCountedImageProxy referenceCountedImageProxy = new ReferenceCountedImageProxy(imageProxyAcquireNextImage);
        for (QueuedImageReaderProxy queuedImageReaderProxy : this.mImageReaders) {
            synchronized (queuedImageReaderProxy) {
                if (!queuedImageReaderProxy.isClosed()) {
                    queuedImageReaderProxy.enqueueImage(ImageProxyDownsampler.downsample(referenceCountedImageProxy.fork(), queuedImageReaderProxy.getWidth(), queuedImageReaderProxy.getHeight(), ImageProxyDownsampler.DownsamplingMethod.AVERAGING));
                }
            }
        }
        referenceCountedImageProxy.close();
    }
}
