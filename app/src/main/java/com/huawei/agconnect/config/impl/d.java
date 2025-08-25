package com.huawei.agconnect.config.impl;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f6392a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6393b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6394c;

    /* renamed from: d, reason: collision with root package name */
    private final String f6395d;

    /* renamed from: e, reason: collision with root package name */
    private final String f6396e;

    /* renamed from: f, reason: collision with root package name */
    private final int f6397f;

    /* renamed from: g, reason: collision with root package name */
    private int f6398g;

    public d(String str, String str2, String str3, String str4, String str5, int i2) {
        this.f6398g = 0;
        this.f6392a = str;
        this.f6393b = str2;
        this.f6394c = str3;
        this.f6395d = str4;
        this.f6396e = str5;
        this.f6397f = i2;
        if (str != null) {
            this.f6398g = str.length() / 2;
        }
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f6392a) || TextUtils.isEmpty(this.f6393b) || TextUtils.isEmpty(this.f6394c) || TextUtils.isEmpty(this.f6395d) || this.f6392a.length() != this.f6393b.length() || this.f6393b.length() != this.f6394c.length() || this.f6394c.length() != this.f6398g * 2 || this.f6397f < 0 || TextUtils.isEmpty(this.f6396e)) ? false : true;
    }

    public String b() {
        return this.f6392a;
    }

    public String c() {
        return this.f6393b;
    }

    public String d() {
        return this.f6394c;
    }

    public String e() {
        return this.f6395d;
    }

    public String f() {
        return this.f6396e;
    }

    public int g() {
        return this.f6397f;
    }

    public int h() {
        return this.f6398g;
    }
}
