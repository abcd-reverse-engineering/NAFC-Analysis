package androidx.camera.core.impl;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ImageProxy;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface ImageReaderProxy {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnImageAvailableListener {
        void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy);
    }

    @Nullable
    ImageProxy acquireLatestImage();

    @Nullable
    ImageProxy acquireNextImage();

    void close();

    int getHeight();

    int getImageFormat();

    int getMaxImages();

    @NonNull
    Surface getSurface();

    int getWidth();

    void setOnImageAvailableListener(@NonNull OnImageAvailableListener onImageAvailableListener, @Nullable Handler handler);

    void setOnImageAvailableListener(@NonNull OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor);
}
