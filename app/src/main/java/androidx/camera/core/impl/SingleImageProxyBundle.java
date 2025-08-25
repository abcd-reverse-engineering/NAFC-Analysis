package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class SingleImageProxyBundle implements ImageProxyBundle {
    private final int mCaptureId;
    private final ImageProxy mImageProxy;

    public SingleImageProxyBundle(@NonNull ImageProxy imageProxy) {
        ImageInfo imageInfo = imageProxy.getImageInfo();
        if (imageInfo == null) {
            throw new IllegalArgumentException("ImageProxy has no associated ImageInfo");
        }
        Object tag = imageInfo.getTag();
        if (tag == null) {
            throw new IllegalArgumentException("ImageProxy has no associated tag");
        }
        if (!(tag instanceof Integer)) {
            throw new IllegalArgumentException("ImageProxy has tag that isn't an integer");
        }
        this.mCaptureId = ((Integer) tag).intValue();
        this.mImageProxy = imageProxy;
    }

    public void close() {
        this.mImageProxy.close();
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public List<Integer> getCaptureIds() {
        return Collections.singletonList(Integer.valueOf(this.mCaptureId));
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public c.b.b.a.a.a<ImageProxy> getImageProxy(int i2) {
        return i2 != this.mCaptureId ? Futures.immediateFailedFuture(new IllegalArgumentException("Capture id does not exist in the bundle")) : Futures.immediateFuture(this.mImageProxy);
    }

    SingleImageProxyBundle(@NonNull ImageProxy imageProxy, int i2) {
        this.mCaptureId = i2;
        this.mImageProxy = imageProxy;
    }
}
