package cn.cloudwalk.callback;

/* loaded from: classes.dex */
public interface LivessCallBack {
    @Deprecated
    void detectFinished();

    void detectInfo(int i2);

    void detectLivess(int i2, byte[] bArr);

    void detectReady();

    void onActionNotStandard(int i2);
}
