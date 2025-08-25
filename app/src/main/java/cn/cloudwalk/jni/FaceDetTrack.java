package cn.cloudwalk.jni;

/* loaded from: classes.dex */
public class FaceDetTrack {
    public FaceInfo[] faceInfos;
    public int mFaceNum;
    public long mNativeDet;

    static {
        loadLibrarys();
    }

    private static void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    private static void loadLibrarys() {
        loadLibrary("cwlive");
    }

    public native int cwCreateDetectorFromFile(String str, String str2, String str3, String str4, String str5, String str6, int i2);

    public native int cwFaceDetectTrack(byte[] bArr, int i2, long j2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public native FaceLivingImg[] cwGetLivingImage();

    public native int cwGetParam(FaceParam faceParam);

    public native String cwGetVersionInfo();

    public native int cwReleaseDetector();

    public native int cwResetLivenessTarget();

    public native int cwSetParam(FaceParam faceParam);

    public native int cwVerifyBestImg();

    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            cwReleaseDetector();
        }
    }

    public native int getLogInfo();

    public native int setLog(boolean z);

    public native int setLogAndSaveImage(boolean z, String str, boolean z2);
}
