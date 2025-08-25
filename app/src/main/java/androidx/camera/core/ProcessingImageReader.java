package androidx.camera.core;

import android.media.ImageReader;
import android.os.Handler;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class ProcessingImageReader implements ImageReaderProxy {
    private static final String TAG = "ProcessingImageReader";

    @NonNull
    CaptureProcessor mCaptureProcessor;

    @Nullable
    @GuardedBy("mLock")
    Executor mExecutor;

    @GuardedBy("mLock")
    private final ImageReaderProxy mInputImageReader;

    @Nullable
    @GuardedBy("mLock")
    ImageReaderProxy.OnImageAvailableListener mListener;

    @GuardedBy("mLock")
    private final ImageReaderProxy mOutputImageReader;
    private final Object mLock = new Object();
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.ProcessingImageReader.1
        @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
        public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
            ProcessingImageReader.this.imageIncoming(imageReaderProxy);
        }
    };
    private ImageReaderProxy.OnImageAvailableListener mImageProcessedListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.ProcessingImageReader.2
        @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
        public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
            ProcessingImageReader processingImageReader = ProcessingImageReader.this;
            Executor executor = processingImageReader.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: androidx.camera.core.ProcessingImageReader.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ProcessingImageReader processingImageReader2 = ProcessingImageReader.this;
                        processingImageReader2.mListener.onImageAvailable(processingImageReader2);
                    }
                });
            } else {
                processingImageReader.mListener.onImageAvailable(processingImageReader);
            }
            ProcessingImageReader.this.mSettableImageProxyBundle.reset();
            ProcessingImageReader.this.setupSettableImageProxyBundleCallbacks();
        }
    };
    private FutureCallback<List<ImageProxy>> mCaptureStageReadyCallback = new FutureCallback<List<ImageProxy>>() { // from class: androidx.camera.core.ProcessingImageReader.3
        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onFailure(Throwable th) {
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onSuccess(@Nullable List<ImageProxy> list) {
            ProcessingImageReader processingImageReader = ProcessingImageReader.this;
            processingImageReader.mCaptureProcessor.process(processingImageReader.mSettableImageProxyBundle);
        }
    };

    @GuardedBy("mLock")
    private boolean mClosed = false;

    @GuardedBy("mLock")
    SettableImageProxyBundle mSettableImageProxyBundle = null;
    private final List<Integer> mCaptureIdList = new ArrayList();

    ProcessingImageReader(int i2, int i3, int i4, int i5, @Nullable Handler handler, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor) {
        this.mInputImageReader = new MetadataImageReader(i2, i3, i4, i5, handler);
        this.mOutputImageReader = new AndroidImageReaderProxy(ImageReader.newInstance(i2, i3, i4, i5));
        init(CameraXExecutors.newHandlerExecutor(handler), captureBundle, captureProcessor);
    }

    private void init(@NonNull Executor executor, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor) {
        this.mExecutor = executor;
        this.mInputImageReader.setOnImageAvailableListener(this.mTransformedListener, executor);
        this.mOutputImageReader.setOnImageAvailableListener(this.mImageProcessedListener, executor);
        this.mCaptureProcessor = captureProcessor;
        this.mCaptureProcessor.onOutputSurface(this.mOutputImageReader.getSurface(), getImageFormat());
        this.mCaptureProcessor.onResolutionUpdate(new Size(this.mInputImageReader.getWidth(), this.mInputImageReader.getHeight()));
        setCaptureBundle(captureBundle);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireLatestImage() {
        ImageProxy imageProxyAcquireLatestImage;
        synchronized (this.mLock) {
            imageProxyAcquireLatestImage = this.mOutputImageReader.acquireLatestImage();
        }
        return imageProxyAcquireLatestImage;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireNextImage() {
        ImageProxy imageProxyAcquireNextImage;
        synchronized (this.mLock) {
            imageProxyAcquireNextImage = this.mOutputImageReader.acquireNextImage();
        }
        return imageProxyAcquireNextImage;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mInputImageReader.close();
            this.mOutputImageReader.close();
            this.mSettableImageProxyBundle.close();
            this.mClosed = true;
        }
    }

    @Nullable
    CameraCaptureCallback getCameraCaptureCallback() {
        ImageReaderProxy imageReaderProxy = this.mInputImageReader;
        if (imageReaderProxy instanceof MetadataImageReader) {
            return ((MetadataImageReader) imageReaderProxy).getCameraCaptureCallback();
        }
        return null;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mInputImageReader.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mInputImageReader.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mInputImageReader.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @NonNull
    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mInputImageReader.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mInputImageReader.getWidth();
        }
        return width;
    }

    void imageIncoming(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            try {
                ImageProxy imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
                if (imageProxyAcquireNextImage != null) {
                    Integer num = (Integer) imageProxyAcquireNextImage.getImageInfo().getTag();
                    if (this.mCaptureIdList.contains(num)) {
                        this.mSettableImageProxyBundle.addImageProxy(imageProxyAcquireNextImage);
                    } else {
                        String str = "ImageProxyBundle does not contain this id: " + num;
                        imageProxyAcquireNextImage.close();
                    }
                }
            } catch (IllegalStateException unused) {
            }
        }
    }

    public void setCaptureBundle(@NonNull CaptureBundle captureBundle) {
        synchronized (this.mLock) {
            if (captureBundle.getCaptureStages() != null) {
                if (this.mInputImageReader.getMaxImages() < captureBundle.getCaptureStages().size()) {
                    throw new IllegalArgumentException("CaptureBundle is lager than InputImageReader.");
                }
                this.mCaptureIdList.clear();
                for (CaptureStage captureStage : captureBundle.getCaptureStages()) {
                    if (captureStage != null) {
                        this.mCaptureIdList.add(Integer.valueOf(captureStage.getId()));
                    }
                }
            }
            this.mSettableImageProxyBundle = new SettableImageProxyBundle(this.mCaptureIdList);
            setupSettableImageProxyBundleCallbacks();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @Nullable Handler handler) {
        setOnImageAvailableListener(onImageAvailableListener, CameraXExecutors.newHandlerExecutor(handler));
    }

    void setupSettableImageProxyBundleCallbacks() {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.mCaptureIdList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.mSettableImageProxyBundle.getImageProxy(it.next().intValue()));
        }
        Futures.addCallback(Futures.allAsList(arrayList), this.mCaptureStageReadyCallback, CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mListener = onImageAvailableListener;
            this.mExecutor = executor;
            this.mInputImageReader.setOnImageAvailableListener(this.mTransformedListener, executor);
            this.mOutputImageReader.setOnImageAvailableListener(this.mImageProcessedListener, executor);
        }
    }

    ProcessingImageReader(ImageReaderProxy imageReaderProxy, @Nullable Handler handler, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor) {
        if (imageReaderProxy.getMaxImages() >= captureBundle.getCaptureStages().size()) {
            this.mInputImageReader = imageReaderProxy;
            this.mOutputImageReader = new AndroidImageReaderProxy(ImageReader.newInstance(imageReaderProxy.getWidth(), imageReaderProxy.getHeight(), imageReaderProxy.getImageFormat(), imageReaderProxy.getMaxImages()));
            init(CameraXExecutors.newHandlerExecutor(handler), captureBundle, captureProcessor);
            return;
        }
        throw new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
    }
}
