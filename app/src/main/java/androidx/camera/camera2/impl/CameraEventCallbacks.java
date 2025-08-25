package androidx.camera.camera2.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.MultiValueSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class CameraEventCallbacks extends MultiValueSet<CameraEventCallback> {

    public static final class ComboCameraEventCallback {
        private final List<CameraEventCallback> mCallbacks = new ArrayList();

        ComboCameraEventCallback(List<CameraEventCallback> list) {
            Iterator<CameraEventCallback> it = list.iterator();
            while (it.hasNext()) {
                this.mCallbacks.add(it.next());
            }
        }

        @NonNull
        public List<CameraEventCallback> getCallbacks() {
            return this.mCallbacks;
        }

        @NonNull
        public List<CaptureConfig> onDisableSession() {
            LinkedList linkedList = new LinkedList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig captureConfigOnDisableSession = it.next().onDisableSession();
                if (captureConfigOnDisableSession != null) {
                    linkedList.add(captureConfigOnDisableSession);
                }
            }
            return linkedList;
        }

        @NonNull
        public List<CaptureConfig> onEnableSession() {
            LinkedList linkedList = new LinkedList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig captureConfigOnEnableSession = it.next().onEnableSession();
                if (captureConfigOnEnableSession != null) {
                    linkedList.add(captureConfigOnEnableSession);
                }
            }
            return linkedList;
        }

        @NonNull
        public List<CaptureConfig> onPresetSession() {
            LinkedList linkedList = new LinkedList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig captureConfigOnPresetSession = it.next().onPresetSession();
                if (captureConfigOnPresetSession != null) {
                    linkedList.add(captureConfigOnPresetSession);
                }
            }
            return linkedList;
        }

        @NonNull
        public List<CaptureConfig> onRepeating() {
            LinkedList linkedList = new LinkedList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig captureConfigOnRepeating = it.next().onRepeating();
                if (captureConfigOnRepeating != null) {
                    linkedList.add(captureConfigOnRepeating);
                }
            }
            return linkedList;
        }
    }

    public CameraEventCallbacks(@NonNull CameraEventCallback... cameraEventCallbackArr) {
        addAll(Arrays.asList(cameraEventCallbackArr));
    }

    @NonNull
    public static CameraEventCallbacks createEmptyCallback() {
        return new CameraEventCallbacks(new CameraEventCallback[0]);
    }

    @NonNull
    public ComboCameraEventCallback createComboCallback() {
        return new ComboCameraEventCallback(getAllItems());
    }

    @Override // androidx.camera.core.impl.MultiValueSet
    @NonNull
    /* renamed from: clone */
    public MultiValueSet<CameraEventCallback> mo0clone() {
        CameraEventCallbacks cameraEventCallbacksCreateEmptyCallback = createEmptyCallback();
        cameraEventCallbacksCreateEmptyCallback.addAll(getAllItems());
        return cameraEventCallbacksCreateEmptyCallback;
    }
}
