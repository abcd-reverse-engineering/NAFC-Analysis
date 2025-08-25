package com.vivo.push.model;

import android.content.Intent;

/* loaded from: classes2.dex */
public class NotifyArriveCallbackByUser {
    private Intent mIntent;
    private boolean mIsIntercept;

    public NotifyArriveCallbackByUser(Intent intent, boolean z) {
        this.mIsIntercept = false;
        this.mIntent = intent;
        this.mIsIntercept = z;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public boolean isIntercept() {
        return this.mIsIntercept;
    }
}
