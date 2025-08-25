package com.alibaba.sdk.android.httpdns.probe;

/* loaded from: classes.dex */
class c {
    private String hostName;
    private String[] ips;

    /* renamed from: k, reason: collision with root package name */
    private long f4087k;

    /* renamed from: l, reason: collision with root package name */
    private long f4088l;
    private String r;
    private String s;

    c(String str, String[] strArr, String str2, String str3, long j2, long j3) {
        this.hostName = str;
        this.ips = strArr;
        this.r = str2;
        this.s = str3;
        this.f4087k = j2;
        this.f4088l = j3;
    }

    public long c() {
        return this.f4087k;
    }

    public long d() {
        return this.f4088l;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String[] getIps() {
        return this.ips;
    }

    public String j() {
        return this.r;
    }

    public String k() {
        return this.s;
    }
}
