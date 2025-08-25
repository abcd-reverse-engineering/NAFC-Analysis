package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class f implements g {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f6974a;

    /* renamed from: b, reason: collision with root package name */
    private String f6975b;

    /* renamed from: c, reason: collision with root package name */
    private String f6976c;

    /* renamed from: d, reason: collision with root package name */
    private String f6977d;

    /* renamed from: e, reason: collision with root package name */
    private String f6978e;

    /* renamed from: f, reason: collision with root package name */
    private List<b1> f6979f;

    public f(byte[] bArr, String str, String str2, String str3, String str4, List<b1> list) {
        this.f6974a = (byte[]) bArr.clone();
        this.f6975b = str;
        this.f6976c = str2;
        this.f6978e = str3;
        this.f6977d = str4;
        this.f6979f = list;
    }

    private n0 a(Map<String, String> map) {
        return w.a(this.f6975b, this.f6974a, map);
    }

    private Map<String, String> a() {
        return k.b(this.f6976c, this.f6978e, this.f6977d);
    }

    private void b() {
        b0.c().a(new d1(this.f6979f, this.f6976c, this.f6977d, this.f6978e));
    }

    @Override // java.lang.Runnable
    public void run() {
        v.c("hmsSdk", "send data running");
        int iB = a(a()).b();
        if (iB != 200) {
            b();
            return;
        }
        v.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f6977d, this.f6978e, this.f6976c, Integer.valueOf(iB));
    }
}
