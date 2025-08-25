package com.alibaba.sdk.android.httpdns;

/* loaded from: classes.dex */
public class h extends Exception {

    /* renamed from: b, reason: collision with root package name */
    private int f4057b;

    public h(int i2, String str) {
        super(str);
        this.f4057b = i2;
    }

    public int getErrorCode() {
        return this.f4057b;
    }
}
