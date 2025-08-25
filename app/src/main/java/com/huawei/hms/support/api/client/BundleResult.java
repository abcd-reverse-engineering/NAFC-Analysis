package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* loaded from: classes.dex */
public class BundleResult {

    /* renamed from: a, reason: collision with root package name */
    private int f7276a;

    /* renamed from: b, reason: collision with root package name */
    private Bundle f7277b;

    public BundleResult(int i2, Bundle bundle) {
        this.f7276a = i2;
        this.f7277b = bundle;
    }

    public int getResultCode() {
        return this.f7276a;
    }

    public Bundle getRspBody() {
        return this.f7277b;
    }

    public void setResultCode(int i2) {
        this.f7276a = i2;
    }

    public void setRspBody(Bundle bundle) {
        this.f7277b = bundle;
    }
}
