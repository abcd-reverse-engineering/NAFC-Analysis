package com.huawei.hms.activity.internal;

import android.content.Intent;

/* loaded from: classes.dex */
public class BusResponseResult {

    /* renamed from: a, reason: collision with root package name */
    private Intent f6532a;

    /* renamed from: b, reason: collision with root package name */
    private int f6533b;

    public int getCode() {
        return this.f6533b;
    }

    public Intent getIntent() {
        return this.f6532a;
    }

    public void setCode(int i2) {
        this.f6533b = i2;
    }

    public void setIntent(Intent intent) {
        this.f6532a = intent;
    }
}
