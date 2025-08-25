package com.tencent.tauth;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class UiError {
    public int errorCode;
    public String errorDetail;
    public String errorMessage;

    public UiError(int i2, String str, String str2) {
        this.errorMessage = str;
        this.errorCode = i2;
        this.errorDetail = str2;
    }

    public String toString() {
        return "errorCode: " + this.errorCode + ", errorMsg: " + this.errorMessage + ", errorDetail: " + this.errorDetail;
    }
}
