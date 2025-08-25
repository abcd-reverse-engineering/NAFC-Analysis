package androidx.camera.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.SingleImageProxyBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;

/* loaded from: classes.dex */
final class ProcessingSurface extends DeferrableSurface {
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "ProcessingSurfaceTextur";
    private final CameraCaptureCallback mCameraCaptureCallback;

    @NonNull
    @GuardedBy("mLock")
    final CaptureProcessor mCaptureProcessor;
    final CaptureStage mCaptureStage;
    private final Handler mImageReaderHandler;

    @GuardedBy("mLock")
    final MetadataImageReader mInputImageReader;

    @GuardedBy("mLock")
    final Surface mInputSurface;
    private final DeferrableSurface mOutputDeferrableSurface;

    @NonNull
    private final Size mResolution;
    final Object mLock = new Object();
    private final ImageReaderProxy.OnImageAvailableListener mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.ProcessingSurface.1
        @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
        public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
            synchronized (ProcessingSurface.this.mLock) {
                ProcessingSurface.this.imageIncoming(imageReaderProxy);
            }
        }
    };

    @GuardedBy("mLock")
    boolean mReleased = false;

    ProcessingSurface(int i2, int i3, int i4, @Nullable Handler handler, @NonNull CaptureStage captureStage, @NonNull CaptureProcessor captureProcessor, @NonNull DeferrableSurface deferrableSurface) {
        this.mResolution = new Size(i2, i3);
        if (handler != null) {
            this.mImageReaderHandler = handler;
        } else {
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                throw new IllegalStateException("Creating a ProcessingSurface requires a non-null Handler, or be created  on a thread with a Looper.");
            }
            this.mImageReaderHandler = new Handler(looperMyLooper);
        }
        this.mInputImageReader = new MetadataImageReader(i2, i3, i4, 2, this.mImageReaderHandler);
        this.mInputImageReader.setOnImageAvailableListener(this.mTransformedListener, this.mImageReaderHandler);
        this.mInputSurface = this.mInputImageReader.getSurface();
        this.mCameraCaptureCallback = this.mInputImageReader.getCameraCaptureCallback();
        this.mCaptureProcessor = captureProcessor;
        this.mCaptureProcessor.onResolutionUpdate(this.mResolution);
        this.mCaptureStage = captureStage;
        this.mOutputDeferrableSurface = deferrableSurface;
        Futures.addCallback(deferrableSurface.getSurface(), new FutureCallback<Surface>() { // from class: androidx.camera.core.ProcessingSurface.2
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Surface surface) {
                synchronized (ProcessingSurface.this.mLock) {
                    ProcessingSurface.this.mCaptureProcessor.onOutputSurface(surface, 1);
                }
            }
        }, CameraXExecutors.directExecutor());
        getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.core.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1480a.release();
            }
        }, CameraXExecutors.directExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        synchronized (this.mLock) {
            if (this.mReleased) {
                return;
            }
            this.mInputImageReader.close();
            this.mInputSurface.release();
            this.mOutputDeferrableSurface.close();
            this.mReleased = true;
        }
    }

    @Nullable
    CameraCaptureCallback getCameraCaptureCallback() {
        CameraCaptureCallback cameraCaptureCallback;
        synchronized (this.mLock) {
            if (this.mReleased) {
                throw new IllegalStateException("ProcessingSurface already released!");
            }
            cameraCaptureCallback = this.mCameraCaptureCallback;
        }
        return cameraCaptureCallback;
    }

    @GuardedBy("mLock")
    void imageIncoming(ImageReaderProxy imageReaderProxy) {
        if (this.mReleased) {
            return;
        }
        ImageProxy imageProxyAcquireNextImage = null;
        try {
            imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
        } catch (IllegalStateException unused) {
        }
        if (imageProxyAcquireNextImage == null) {
            return;
        }
        ImageInfo imageInfo = imageProxyAcquireNextImage.getImageInfo();
        if (imageInfo == null) {
            imageProxyAcquireNextImage.close();
            return;
        }
        Object tag = imageInfo.getTag();
        if (tag == null) {
            imageProxyAcquireNextImage.close();
            return;
        }
        if (!(tag instanceof Integer)) {
            imageProxyAcquireNextImage.close();
            return;
        }
        Integer num = (Integer) tag;
        if (this.mCaptureStage.getId() == num.intValue()) {
            SingleImageProxyBundle singleImageProxyBundle = new SingleImageProxyBundle(imageProxyAcquireNextImage);
            this.mCaptureProcessor.process(singleImageProxyBundle);
            singleImageProxyBundle.close();
        } else {
            String str = "ImageProxyBundle does not contain this id: " + num;
            imageProxyAcquireNextImage.close();
        }
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    @NonNull
    public c.b.b.a.a.a<Surface> provideSurface() {
        return Futures.immediateFuture(this.mInputSurface);
    }
}
