package com.alibaba.sdk.android.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AlicloudTracker {

    /* renamed from: a, reason: collision with root package name */
    private a f4124a;

    /* renamed from: a, reason: collision with other field name */
    private String f40a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, String> f41a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private String f4125b;

    AlicloudTracker(a aVar, String str, String str2) {
        this.f4124a = aVar;
        this.f40a = str;
        this.f4125b = str2;
    }

    public void removeGlobalProperty(String str) {
        if (TextUtils.isEmpty(str) || !this.f41a.containsKey(str)) {
            return;
        }
        this.f41a.remove(str);
    }

    public void sendCustomHit(String str, long j2, Map<String, String> map) {
        try {
            if (this.f4124a == null) {
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.putAll(this.f41a);
            map.put("sdkId", this.f40a);
            map.put("sdkVersion", this.f4125b);
            this.f4124a.sendCustomHit(this.f40a + c.c.a.b.a.a.s1 + str, j2, map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (this.f41a.containsKey(str)) {
            this.f41a.remove(str);
        }
        this.f41a.put(str, str2);
    }

    public void sendCustomHit(String str, Map<String, String> map) {
        sendCustomHit(str, 0L, map);
    }
}
