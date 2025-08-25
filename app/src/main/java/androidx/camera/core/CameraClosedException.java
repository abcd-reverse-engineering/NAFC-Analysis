package androidx.camera.core;

import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
final class CameraClosedException extends RuntimeException {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CameraClosedException(String str, Throwable th) {
        super(str, th);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CameraClosedException(String str) {
        super(str);
    }
}
