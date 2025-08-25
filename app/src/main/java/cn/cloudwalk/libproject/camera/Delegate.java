package cn.cloudwalk.libproject.camera;

/* loaded from: classes.dex */
public interface Delegate {
    void onFocus(float f2, float f3);

    void onFocused();

    void onOpenCameraError();

    void startPreview();
}
