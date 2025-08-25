package com.huawei.hms.hatool;

/* loaded from: classes.dex */
public class j1 implements g {

    /* renamed from: a, reason: collision with root package name */
    private String f7024a;

    /* renamed from: b, reason: collision with root package name */
    private String f7025b;

    public j1(String str, String str2) {
        this.f7024a = str;
        this.f7025b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        w0.b(this.f7024a, this.f7025b);
    }
}
