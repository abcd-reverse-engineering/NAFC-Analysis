package com.tencent.bugly.beta.download;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public interface DownloadListener {
    void onCompleted(DownloadTask downloadTask);

    void onFailed(DownloadTask downloadTask, int i2, String str);

    void onReceive(DownloadTask downloadTask);
}
