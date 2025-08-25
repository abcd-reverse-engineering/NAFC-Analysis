package androidx.camera.core;

import androidx.annotation.GuardedBy;

/* loaded from: classes.dex */
final class SingleCloseImageProxy extends ForwardingImageProxy {

    @GuardedBy("this")
    private boolean mClosed;

    SingleCloseImageProxy(ImageProxy imageProxy) {
        super(imageProxy);
        this.mClosed = false;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.mClosed) {
            this.mClosed = true;
            super.close();
        }
    }
}
