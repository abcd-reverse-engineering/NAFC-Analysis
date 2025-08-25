package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
final class ReferenceCountedImageProxy extends ForwardingImageProxy {

    @GuardedBy("this")
    private int mReferenceCount;

    ReferenceCountedImageProxy(ImageProxy imageProxy) {
        super(imageProxy);
        this.mReferenceCount = 1;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.mReferenceCount > 0) {
            this.mReferenceCount--;
            if (this.mReferenceCount <= 0) {
                super.close();
            }
        }
    }

    @Nullable
    synchronized ImageProxy fork() {
        if (this.mReferenceCount <= 0) {
            return null;
        }
        this.mReferenceCount++;
        return new SingleCloseImageProxy(this);
    }

    synchronized int getReferenceCount() {
        return this.mReferenceCount;
    }
}
