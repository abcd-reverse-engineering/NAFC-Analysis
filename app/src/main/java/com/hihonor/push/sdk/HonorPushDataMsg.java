package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class HonorPushDataMsg {

    /* renamed from: a, reason: collision with root package name */
    public int f6244a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f6245b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f6246c;

    /* renamed from: d, reason: collision with root package name */
    public String f6247d;

    public String getData() {
        return this.f6247d;
    }

    public long getMsgId() {
        return this.f6246c;
    }

    public int getType() {
        return this.f6245b;
    }

    public int getVersion() {
        return this.f6244a;
    }

    public void setData(String str) {
        this.f6247d = str;
    }

    public void setMsgId(long j2) {
        this.f6246c = j2;
    }

    public void setType(int i2) {
        this.f6245b = i2;
    }

    public void setVersion(int i2) {
        this.f6244a = i2;
    }
}
