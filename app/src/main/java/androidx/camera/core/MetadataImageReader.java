package androidx.camera.core;

import android.media.ImageReader;
import android.os.Handler;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class MetadataImageReader implements ImageReaderProxy, ForwardingImageProxy.OnImageCloseListener {
    private static final String TAG = "MetadataImageReader";

    @Nullable
    @GuardedBy("mLock")
    private Executor mExecutor;

    @GuardedBy("mLock")
    private int mImageProxiesIndex;

    @GuardedBy("mLock")
    private final ImageReaderProxy mImageReaderProxy;

    @Nullable
    @GuardedBy("mLock")
    ImageReaderProxy.OnImageAvailableListener mListener;

    @GuardedBy("mLock")
    private List<ImageProxy> mMatchedImageProxies;
    private final Object mLock = new Object();
    private CameraCaptureCallback mCameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.core.MetadataImageReader.1
        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
            super.onCaptureCompleted(cameraCaptureResult);
            MetadataImageReader.this.resultIncoming(cameraCaptureResult);
        }
    };
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.MetadataImageReader.2
        @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
        public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
            MetadataImageReader.this.imageIncoming(imageReaderProxy);
        }
    };

    @GuardedBy("mLock")
    private boolean mClosed = false;

    @GuardedBy("mLock")
    private final LongSparseArray<ImageInfo> mPendingImageInfos = new LongSparseArray<>();

    @GuardedBy("mLock")
    private final LongSparseArray<ImageProxy> mPendingImages = new LongSparseArray<>();

    @GuardedBy("mLock")
    private final List<ImageProxy> mAcquiredImageProxies = new ArrayList();

    MetadataImageReader(int i2, int i3, int i4, int i5, @Nullable Handler handler) {
        this.mImageReaderProxy = new AndroidImageReaderProxy(ImageReader.newInstance(i2, i3, i4, i5));
        init(CameraXExecutors.newHandlerExecutor(handler));
    }

    private void dequeImageProxy(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            int iIndexOf = this.mMatchedImageProxies.indexOf(imageProxy);
            if (iIndexOf >= 0) {
                this.mMatchedImageProxies.remove(iIndexOf);
                if (iIndexOf <= this.mImageProxiesIndex) {
                    this.mImageProxiesIndex--;
                }
            }
            this.mAcquiredImageProxies.remove(imageProxy);
        }
    }

    private void enqueueImageProxy(SettableImageProxy settableImageProxy) {
        synchronized (this.mLock) {
            if (this.mMatchedImageProxies.size() < getMaxImages()) {
                settableImageProxy.addOnImageCloseListener(this);
                this.mMatchedImageProxies.add(settableImageProxy);
                if (this.mListener != null) {
                    if (this.mExecutor != null) {
                        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.MetadataImageReader.3
                            @Override // java.lang.Runnable
                            public void run() {
                                MetadataImageReader metadataImageReader = MetadataImageReader.this;
                                metadataImageReader.mListener.onImageAvailable(metadataImageReader);
                            }
                        });
                    } else {
                        this.mListener.onImageAvailable(this);
                    }
                }
            } else {
                settableImageProxy.close();
            }
        }
    }

    private void init(Executor executor) {
        this.mExecutor = executor;
        this.mImageReaderProxy.setOnImageAvailableListener(this.mTransformedListener, executor);
        this.mImageProxiesIndex = 0;
        this.mMatchedImageProxies = new ArrayList(getMaxImages());
    }

    private void matchImages() {
        synchronized (this.mLock) {
            for (int size = this.mPendingImageInfos.size() - 1; size >= 0; size--) {
                ImageInfo imageInfoValueAt = this.mPendingImageInfos.valueAt(size);
                long timestamp = imageInfoValueAt.getTimestamp();
                ImageProxy imageProxy = this.mPendingImages.get(timestamp);
                if (imageProxy != null) {
                    this.mPendingImages.remove(timestamp);
                    this.mPendingImageInfos.removeAt(size);
                    enqueueImageProxy(new SettableImageProxy(imageProxy, imageInfoValueAt));
                }
            }
            removeStaleData();
        }
    }

    private void removeStaleData() {
        synchronized (this.mLock) {
            if (this.mPendingImages.size() != 0 && this.mPendingImageInfos.size() != 0) {
                Long lValueOf = Long.valueOf(this.mPendingImages.keyAt(0));
                Long lValueOf2 = Long.valueOf(this.mPendingImageInfos.keyAt(0));
                Preconditions.checkArgument(lValueOf2.equals(lValueOf) ? false : true);
                if (lValueOf2.longValue() > lValueOf.longValue()) {
                    for (int size = this.mPendingImages.size() - 1; size >= 0; size--) {
                        if (this.mPendingImages.keyAt(size) < lValueOf2.longValue()) {
                            this.mPendingImages.valueAt(size).close();
                            this.mPendingImages.removeAt(size);
                        }
                    }
                } else {
                    for (int size2 = this.mPendingImageInfos.size() - 1; size2 >= 0; size2--) {
                        if (this.mPendingImageInfos.keyAt(size2) < lValueOf.longValue()) {
                            this.mPendingImageInfos.removeAt(size2);
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireLatestImage() {
        synchronized (this.mLock) {
            if (this.mMatchedImageProxies.isEmpty()) {
                return null;
            }
            if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) {
                throw new IllegalStateException("Maximum image number reached.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.mMatchedImageProxies.size() - 1; i2++) {
                if (!this.mAcquiredImageProxies.contains(this.mMatchedImageProxies.get(i2))) {
                    arrayList.add(this.mMatchedImageProxies.get(i2));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ImageProxy) it.next()).close();
            }
            this.mImageProxiesIndex = this.mMatchedImageProxies.size() - 1;
            List<ImageProxy> list = this.mMatchedImageProxies;
            int i3 = this.mImageProxiesIndex;
            this.mImageProxiesIndex = i3 + 1;
            ImageProxy imageProxy = list.get(i3);
            this.mAcquiredImageProxies.add(imageProxy);
            return imageProxy;
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireNextImage() {
        synchronized (this.mLock) {
            if (this.mMatchedImageProxies.isEmpty()) {
                return null;
            }
            if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) {
                throw new IllegalStateException("Maximum image number reached.");
            }
            List<ImageProxy> list = this.mMatchedImageProxies;
            int i2 = this.mImageProxiesIndex;
            this.mImageProxiesIndex = i2 + 1;
            ImageProxy imageProxy = list.get(i2);
            this.mAcquiredImageProxies.add(imageProxy);
            return imageProxy;
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            Iterator it = new ArrayList(this.mMatchedImageProxies).iterator();
            while (it.hasNext()) {
                ((ImageProxy) it.next()).close();
            }
            this.mMatchedImageProxies.clear();
            this.mImageReaderProxy.close();
            this.mClosed = true;
        }
    }

    CameraCaptureCallback getCameraCaptureCallback() {
        return this.mCameraCaptureCallback;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mImageReaderProxy.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mImageReaderProxy.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mImageReaderProxy.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @NonNull
    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mImageReaderProxy.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mImageReaderProxy.getWidth();
        }
        return width;
    }

    void imageIncoming(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            int i2 = 0;
            do {
                ImageProxy imageProxyAcquireNextImage = null;
                try {
                    imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
                    if (imageProxyAcquireNextImage != null) {
                        i2++;
                        this.mPendingImages.put(imageProxyAcquireNextImage.getImageInfo().getTimestamp(), imageProxyAcquireNextImage);
                        matchImages();
                    }
                } catch (IllegalStateException unused) {
                }
                if (imageProxyAcquireNextImage == null) {
                    break;
                }
            } while (i2 < imageReaderProxy.getMaxImages());
        }
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void onImageClose(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            dequeImageProxy(imageProxy);
        }
    }

    void resultIncoming(CameraCaptureResult cameraCaptureResult) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mPendingImageInfos.put(cameraCaptureResult.getTimestamp(), new CameraCaptureResultImageInfo(cameraCaptureResult));
            matchImages();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @Nullable Handler handler) {
        setOnImageAvailableListener(onImageAvailableListener, CameraXExecutors.newHandlerExecutor(handler));
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mListener = onImageAvailableListener;
            this.mExecutor = executor;
            this.mImageReaderProxy.setOnImageAvailableListener(this.mTransformedListener, executor);
        }
    }

    MetadataImageReader(ImageReaderProxy imageReaderProxy, @Nullable Handler handler) {
        this.mImageReaderProxy = imageReaderProxy;
        init(CameraXExecutors.newHandlerExecutor(handler));
    }
}
