package com.huawei.secure.android.common.util;

/* loaded from: classes.dex */
public class SecurityCommonException extends Exception {

    /* renamed from: c, reason: collision with root package name */
    private static final long f7703c = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f7704a;

    /* renamed from: b, reason: collision with root package name */
    private String f7705b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.f7705b;
    }

    public String getRetCd() {
        return this.f7704a;
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.f7705b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f7704a = str;
        this.f7705b = str2;
    }
}
