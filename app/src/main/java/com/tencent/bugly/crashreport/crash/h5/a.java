package com.tencent.bugly.crashreport.crash.h5;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f9128a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f9129b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f9130c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f9131d = null;

    /* renamed from: e, reason: collision with root package name */
    public String f9132e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f9133f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f9134g = null;

    /* renamed from: h, reason: collision with root package name */
    public String f9135h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f9136i = null;

    /* renamed from: j, reason: collision with root package name */
    public long f9137j = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f9138k = 0;

    public Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.f9128a;
        if (str != null) {
            linkedHashMap.put("[JS] projectRoot", str);
        }
        String str2 = this.f9129b;
        if (str2 != null) {
            linkedHashMap.put("[JS] context", str2);
        }
        String str3 = this.f9130c;
        if (str3 != null) {
            linkedHashMap.put("[JS] url", str3);
        }
        String str4 = this.f9131d;
        if (str4 != null) {
            linkedHashMap.put("[JS] userAgent", str4);
        }
        String str5 = this.f9136i;
        if (str5 != null) {
            linkedHashMap.put("[JS] file", str5);
        }
        long j2 = this.f9137j;
        if (j2 != 0) {
            linkedHashMap.put("[JS] lineNumber", Long.toString(j2));
        }
        return linkedHashMap;
    }
}
