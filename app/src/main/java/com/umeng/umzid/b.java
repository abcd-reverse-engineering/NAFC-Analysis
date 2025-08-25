package com.umeng.umzid;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes2.dex */
public final class b implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11887a;

    public b(String str) {
        this.f11887a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f11887a.equalsIgnoreCase(str) || "pre-aaid.umeng.com".equalsIgnoreCase(str);
    }
}
