package org.tensorflow.lite;

/* loaded from: classes2.dex */
public final class TensorFlowLite {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17514a = "tensorflowlite_jni";

    /* renamed from: b, reason: collision with root package name */
    private static final String f17515b = "tensorflowlite_flex_jni";

    static {
        a();
    }

    private TensorFlowLite() {
    }

    static boolean a() {
        try {
            System.loadLibrary(f17514a);
            return true;
        } catch (UnsatisfiedLinkError e2) {
            try {
                System.loadLibrary(f17515b);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                System.err.println("TensorFlowLite: failed to load native library: " + e2.getMessage());
                return false;
            }
        }
    }

    @Deprecated
    public static String b() {
        return schemaVersion();
    }

    static native void initTensorFlow();

    public static native String runtimeVersion();

    public static native String schemaVersion();
}
