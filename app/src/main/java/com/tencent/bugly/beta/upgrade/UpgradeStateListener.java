package com.tencent.bugly.beta.upgrade;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public interface UpgradeStateListener {
    void onDownloadCompleted(boolean z);

    void onUpgradeFailed(boolean z);

    void onUpgradeNoVersion(boolean z);

    void onUpgradeSuccess(boolean z);

    void onUpgrading(boolean z);
}
