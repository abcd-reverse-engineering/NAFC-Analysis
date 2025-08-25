package com.alibaba.sdk.android.httpdns.probe;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static IPProbeService f4089a;

    public static synchronized IPProbeService a(b bVar) {
        if (f4089a == null) {
            f4089a = new e();
            f4089a.setIPListUpdateCallback(bVar);
        }
        return f4089a;
    }
}
