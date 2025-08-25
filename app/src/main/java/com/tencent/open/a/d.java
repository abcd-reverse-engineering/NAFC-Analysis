package com.tencent.open.a;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
class d implements g {

    /* renamed from: a, reason: collision with root package name */
    private Response f9764a;

    /* renamed from: b, reason: collision with root package name */
    private String f9765b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f9766c;

    /* renamed from: d, reason: collision with root package name */
    private int f9767d;

    /* renamed from: e, reason: collision with root package name */
    private int f9768e;

    d(Response response, int i2) {
        this.f9764a = response;
        this.f9767d = i2;
        this.f9766c = response.code();
        ResponseBody responseBodyBody = this.f9764a.body();
        if (responseBodyBody != null) {
            this.f9768e = (int) responseBodyBody.contentLength();
        } else {
            this.f9768e = 0;
        }
    }

    @Override // com.tencent.open.a.g
    public String a() throws IOException {
        if (this.f9765b == null) {
            ResponseBody responseBodyBody = this.f9764a.body();
            if (responseBodyBody != null) {
                this.f9765b = responseBodyBody.string();
            }
            if (this.f9765b == null) {
                this.f9765b = "";
            }
        }
        return this.f9765b;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f9768e;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f9767d;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f9766c;
    }

    public String toString() {
        return d.class.getSimpleName() + '@' + hashCode() + this.f9765b + this.f9766c + this.f9767d + this.f9768e;
    }
}
