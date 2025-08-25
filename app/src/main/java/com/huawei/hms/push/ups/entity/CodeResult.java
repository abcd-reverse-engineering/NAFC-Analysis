package com.huawei.hms.push.ups.entity;

/* loaded from: classes.dex */
public class CodeResult {

    /* renamed from: a, reason: collision with root package name */
    private int f7243a;

    /* renamed from: b, reason: collision with root package name */
    private String f7244b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f7244b;
    }

    public int getReturnCode() {
        return this.f7243a;
    }

    public void setReason(String str) {
        this.f7244b = str;
    }

    public void setReturnCode(int i2) {
        this.f7243a = i2;
    }

    public CodeResult(int i2) {
        this.f7243a = i2;
    }

    public CodeResult(int i2, String str) {
        this.f7243a = i2;
        this.f7244b = str;
    }
}
