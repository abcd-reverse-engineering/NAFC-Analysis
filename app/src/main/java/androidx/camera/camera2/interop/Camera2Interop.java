package androidx.camera.camera2.interop;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.ExtendableBuilder;

@ExperimentalCamera2Interop
/* loaded from: classes.dex */
public final class Camera2Interop {

    public static final class Extender<T> {
        ExtendableBuilder<T> mBaseBuilder;

        public Extender(@NonNull ExtendableBuilder<T> extendableBuilder) {
            this.mBaseBuilder = extendableBuilder;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public <ValueT> Extender<T> setCaptureRequestOption(@NonNull CaptureRequest.Key<ValueT> key, @NonNull ValueT valuet) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.createCaptureRequestOption(key), valuet);
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Extender<T> setCaptureRequestTemplate(int i2) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.TEMPLATE_TYPE_OPTION, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Extender<T> setDeviceStateCallback(@NonNull CameraDevice.StateCallback stateCallback) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.DEVICE_STATE_CALLBACK_OPTION, stateCallback);
            return this;
        }

        @NonNull
        public Extender<T> setSessionCaptureCallback(@NonNull CameraCaptureSession.CaptureCallback captureCallback) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.SESSION_CAPTURE_CALLBACK_OPTION, captureCallback);
            return this;
        }

        @NonNull
        public Extender<T> setSessionStateCallback(@NonNull CameraCaptureSession.StateCallback stateCallback) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.SESSION_STATE_CALLBACK_OPTION, stateCallback);
            return this;
        }
    }

    private Camera2Interop() {
    }
}
