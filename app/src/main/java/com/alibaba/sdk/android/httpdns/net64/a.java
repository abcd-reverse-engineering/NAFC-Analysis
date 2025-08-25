package com.alibaba.sdk.android.httpdns.net64;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class a implements Net64Service {

    /* renamed from: a, reason: collision with root package name */
    private b f4076a;

    /* renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, List<String>> f33a;
    private boolean o;
    private volatile boolean p;

    /* renamed from: com.alibaba.sdk.android.httpdns.net64.a$a, reason: collision with other inner class name */
    private static final class C0055a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f4077a = new a();
    }

    private a() {
        this.f4076a = new b();
        this.f33a = new ConcurrentHashMap<>();
    }

    public static a a() {
        return C0055a.f4077a;
    }

    public List<String> a(String str) {
        return this.f33a.get(str);
    }

    public void a(String str, List<String> list) {
        this.f33a.put(str, list);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m28a() {
        return this.o;
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public void enableIPv6(boolean z) {
        this.o = z;
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public String getIPv6ByHostAsync(String str) {
        List<String> list;
        if (this.o && (list = this.f33a.get(str)) != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public boolean i() {
        return this.p;
    }
}
