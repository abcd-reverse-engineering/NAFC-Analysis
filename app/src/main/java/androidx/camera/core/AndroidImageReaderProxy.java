package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class AndroidImageReaderProxy implements ImageReaderProxy {

    @GuardedBy("this")
    private final ImageReader mImageReader;

    AndroidImageReaderProxy(ImageReader imageReader) {
        this.mImageReader = imageReader;
    }

    private boolean isImageReaderContextNotInitializedException(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public synchronized ImageProxy acquireLatestImage() {
        Image imageAcquireLatestImage;
        try {
            imageAcquireLatestImage = this.mImageReader.acquireLatestImage();
        } catch (RuntimeException e2) {
            if (!isImageReaderContextNotInitializedException(e2)) {
                throw e2;
            }
            imageAcquireLatestImage = null;
        }
        if (imageAcquireLatestImage == null) {
            return null;
        }
        return new AndroidImageProxy(imageAcquireLatestImage);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public synchronized ImageProxy acquireNextImage() {
        Image imageAcquireNextImage;
        try {
            imageAcquireNextImage = this.mImageReader.acquireNextImage();
        } catch (RuntimeException e2) {
            if (!isImageReaderContextNotInitializedException(e2)) {
                throw e2;
            }
            imageAcquireNextImage = null;
        }
        if (imageAcquireNextImage == null) {
            return null;
        }
        return new AndroidImageProxy(imageAcquireNextImage);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public synchronized void close() {
        this.mImageReader.close();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public synchronized int getHeight() {
        return this.mImageReader.getHeight();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public synchronized int getImageFormat() {
        return this.mImageReader.getImageFormat();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public synchronized int getMaxImages() {
        return this.mImageReader.getMaxImages();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @NonNull
    public synchronized Surface getSurface() {
        return this.mImageReader.getSurface();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public synchronized int getWidth() {
        return this.mImageReader.getWidth();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public synchronized void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @Nullable Handler handler) {
        setOnImageAvailableListener(onImageAvailableListener, handler == null ? null : CameraXExecutors.newHandlerExecutor(handler));
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public synchronized void setOnImageAvailableListener(@NonNull final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull final Executor executor) {
        this.mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: androidx.camera.core.AndroidImageReaderProxy.1
            @Override // android.media.ImageReader.OnImageAvailableListener
            public void onImageAvailable(ImageReader imageReader) {
                executor.execute(new Runnable() { // from class: androidx.camera.core.AndroidImageReaderProxy.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        onImageAvailableListener.onImageAvailable(AndroidImageReaderProxy.this);
                    }
                });
            }
        }, MainThreadAsyncHandler.getInstance());
    }
}
