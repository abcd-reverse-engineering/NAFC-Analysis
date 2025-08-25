package cn.cloudwalk.libproject.callback;

/* loaded from: classes.dex */
public interface FrontDetectCallback {
    void onLivenessCancel();

    void onLivenessFail(int i2);

    void onLivenessSuccess(byte[] bArr, String str, byte[] bArr2, String str2, byte[] bArr3);
}
