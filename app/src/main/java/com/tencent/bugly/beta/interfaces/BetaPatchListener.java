package com.tencent.bugly.beta.interfaces;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public interface BetaPatchListener {
    void onApplyFailure(String str);

    void onApplySuccess(String str);

    void onDownloadFailure(String str);

    void onDownloadReceived(long j2, long j3);

    void onDownloadSuccess(String str);

    void onPatchReceived(String str);

    void onPatchRollback();
}
