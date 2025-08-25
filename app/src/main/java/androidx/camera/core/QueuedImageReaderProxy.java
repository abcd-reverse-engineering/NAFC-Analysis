package androidx.camera.core;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class QueuedImageReaderProxy implements ImageReaderProxy, ForwardingImageProxy.OnImageCloseListener {
    private final int mFormat;
    private final int mHeight;

    @GuardedBy("this")
    private final List<ImageProxy> mImages;
    private final int mMaxImages;

    @Nullable
    @GuardedBy("this")
    private Executor mOnImageAvailableExecutor;

    @Nullable
    @GuardedBy("this")
    private ImageReaderProxy.OnImageAvailableListener mOnImageAvailableListener;

    @GuardedBy("this")
    private final Surface mSurface;
    private final int mWidth;

    @GuardedBy("this")
    private final Set<ImageProxy> mAcquiredImages = new HashSet();

    @GuardedBy("this")
    private final Set<OnReaderCloseListener> mOnReaderCloseListeners = new HashSet();

    @GuardedBy("this")
    private int mCurrentPosition = 0;

    @GuardedBy("this")
    private boolean mClosed = false;

    interface OnReaderCloseListener {
        void onReaderClose(ImageReaderProxy imageReaderProxy);
    }

    QueuedImageReaderProxy(int i2, int i3, int i4, int i5, Surface surface) {
        this.mWidth = i2;
        this.mHeight = i3;
        this.mFormat = i4;
        this.mMaxImages = i5;
        this.mSurface = surface;
        this.mImages = new ArrayList(i5);
    }

    private synchronized void notifyOnReaderCloseListeners() {
        Iterator<OnReaderCloseListener> it = this.mOnReaderCloseListeners.iterator();
        while (it.hasNext()) {
            it.next().onReaderClose(this);
        }
    }

    private synchronized void throwExceptionIfClosed() {
        if (this.mClosed) {
            throw new IllegalStateException("This reader is already closed.");
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public synchronized ImageProxy acquireLatestImage() {
        throwExceptionIfClosed();
        if (this.mImages.isEmpty()) {
            return null;
        }
        if (this.mCurrentPosition >= this.mImages.size()) {
            throw new IllegalStateException("Max images have already been acquired without close.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.mImages.size() - 1; i2++) {
            if (!this.mAcquiredImages.contains(this.mImages.get(i2))) {
                arrayList.add(this.mImages.get(i2));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ImageProxy) it.next()).close();
        }
        this.mCurrentPosition = this.mImages.size() - 1;
        List<ImageProxy> list = this.mImages;
        int i3 = this.mCurrentPosition;
        this.mCurrentPosition = i3 + 1;
        ImageProxy imageProxy = list.get(i3);
        this.mAcquiredImages.add(imageProxy);
        return imageProxy;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public synchronized ImageProxy acquireNextImage() {
        throwExceptionIfClosed();
        if (this.mImages.isEmpty()) {
            return null;
        }
        if (this.mCurrentPosition >= this.mImages.size()) {
            throw new IllegalStateException("Max images have already been acquired without close.");
        }
        List<ImageProxy> list = this.mImages;
        int i2 = this.mCurrentPosition;
        this.mCurrentPosition = i2 + 1;
        ImageProxy imageProxy = list.get(i2);
        this.mAcquiredImages.add(imageProxy);
        return imageProxy;
    }

    synchronized void addOnReaderCloseListener(OnReaderCloseListener onReaderCloseListener) {
        this.mOnReaderCloseListeners.add(onReaderCloseListener);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public synchronized void close() {
        if (!this.mClosed) {
            this.mOnImageAvailableExecutor = null;
            this.mOnImageAvailableListener = null;
            Iterator it = new ArrayList(this.mImages).iterator();
            while (it.hasNext()) {
                ((ImageProxy) it.next()).close();
            }
            this.mImages.clear();
            this.mClosed = true;
            notifyOnReaderCloseListeners();
        }
    }

    synchronized void enqueueImage(ForwardingImageProxy forwardingImageProxy) {
        throwExceptionIfClosed();
        if (this.mImages.size() < this.mMaxImages) {
            this.mImages.add(forwardingImageProxy);
            forwardingImageProxy.addOnImageCloseListener(this);
            if (this.mOnImageAvailableListener != null && this.mOnImageAvailableExecutor != null) {
                final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener = this.mOnImageAvailableListener;
                this.mOnImageAvailableExecutor.execute(new Runnable() { // from class: androidx.camera.core.QueuedImageReaderProxy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QueuedImageReaderProxy.this.isClosed()) {
                            return;
                        }
                        onImageAvailableListener.onImageAvailable(QueuedImageReaderProxy.this);
                    }
                });
            }
        } else {
            forwardingImageProxy.close();
        }
    }

    synchronized int getCurrentImages() {
        throwExceptionIfClosed();
        return this.mImages.size();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        throwExceptionIfClosed();
        return this.mHeight;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        throwExceptionIfClosed();
        return this.mFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        throwExceptionIfClosed();
        return this.mMaxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @NonNull
    public synchronized Surface getSurface() {
        throwExceptionIfClosed();
        return this.mSurface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        throwExceptionIfClosed();
        return this.mWidth;
    }

    synchronized boolean isClosed() {
        return this.mClosed;
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public synchronized void onImageClose(ImageProxy imageProxy) {
        int iIndexOf = this.mImages.indexOf(imageProxy);
        if (iIndexOf >= 0) {
            this.mImages.remove(iIndexOf);
            if (iIndexOf <= this.mCurrentPosition) {
                this.mCurrentPosition--;
            }
        }
        this.mAcquiredImages.remove(imageProxy);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public synchronized void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @Nullable Handler handler) {
        setOnImageAvailableListener(onImageAvailableListener, handler == null ? null : CameraXExecutors.newHandlerExecutor(handler));
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public synchronized void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        throwExceptionIfClosed();
        this.mOnImageAvailableListener = onImageAvailableListener;
        this.mOnImageAvailableExecutor = executor;
    }
}
