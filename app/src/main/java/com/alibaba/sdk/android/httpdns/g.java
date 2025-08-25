package com.alibaba.sdk.android.httpdns;

import org.json.JSONObject;

/* loaded from: classes.dex */
class g {

    /* renamed from: b, reason: collision with root package name */
    private int f4055b;

    /* renamed from: e, reason: collision with root package name */
    private String f4056e;

    g(int i2, String str) {
        this.f4055b = i2;
        this.f4056e = new JSONObject(str).getString("code");
    }

    public String b() {
        return this.f4056e;
    }

    public int getErrorCode() {
        return this.f4055b;
    }
}
