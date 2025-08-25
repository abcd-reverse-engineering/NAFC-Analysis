package com.alibaba.sdk.android.utils;

import java.util.Map;

/* loaded from: classes.dex */
public class SdkInfo {

    /* renamed from: a, reason: collision with root package name */
    String f4128a;

    /* renamed from: b, reason: collision with root package name */
    String f4129b;

    /* renamed from: c, reason: collision with root package name */
    String f4130c;

    /* renamed from: c, reason: collision with other field name */
    Map<String, String> f44c;

    public SdkInfo setAppKey(String str) {
        this.f4130c = str;
        return this;
    }

    public SdkInfo setExt(Map<String, String> map) {
        this.f44c = map;
        return this;
    }

    public SdkInfo setSdkId(String str) {
        this.f4128a = str;
        return this;
    }

    public SdkInfo setSdkVersion(String str) {
        this.f4129b = str;
        return this;
    }
}
