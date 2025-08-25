package com.tencent.open.a;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
class c implements g {

    /* renamed from: a, reason: collision with root package name */
    private String f9758a;

    /* renamed from: b, reason: collision with root package name */
    private int f9759b;

    /* renamed from: c, reason: collision with root package name */
    private int f9760c;

    /* renamed from: d, reason: collision with root package name */
    private int f9761d;

    /* renamed from: e, reason: collision with root package name */
    private String f9762e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, List<String>> f9763f = new HashMap();

    public c(HttpURLConnection httpURLConnection, String str, int i2, int i3, int i4, String str2) {
        Map<String, List<String>> headerFields;
        this.f9758a = "";
        this.f9759b = 0;
        this.f9760c = 0;
        this.f9761d = 0;
        this.f9762e = "";
        this.f9758a = str;
        this.f9759b = i2;
        this.f9760c = i3;
        this.f9761d = i4;
        this.f9762e = str2;
        if (httpURLConnection == null || (headerFields = httpURLConnection.getHeaderFields()) == null) {
            return;
        }
        this.f9763f.putAll(headerFields);
    }

    @Override // com.tencent.open.a.g
    public String a() {
        return this.f9758a;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f9759b;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f9760c;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f9761d;
    }

    public String toString() {
        return c.class.getSimpleName() + '@' + hashCode() + "\ncontent = [" + this.f9758a + "]\nresponseSize = " + this.f9759b + "\nrequestSize = " + this.f9760c + "\nresultCode = " + this.f9761d + "\nerrorMsg = " + this.f9762e;
    }
}
