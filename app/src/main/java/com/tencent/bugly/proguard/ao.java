package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    private static Proxy f9255a;

    public static void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            f9255a = null;
        } else {
            f9255a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        }
    }

    public static void a(InetAddress inetAddress, int i2) {
        if (inetAddress == null) {
            f9255a = null;
        } else {
            f9255a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i2));
        }
    }

    public static Proxy a() {
        return f9255a;
    }
}
