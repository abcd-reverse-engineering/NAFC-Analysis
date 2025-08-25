package com.huawei.hms.hatool;

import android.content.Context;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private static m f7048b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f7049c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Context f7050a;

    private m() {
    }

    public static m a() {
        if (f7048b == null) {
            b();
        }
        return f7048b;
    }

    private static synchronized void b() {
        if (f7048b == null) {
            f7048b = new m();
        }
    }

    public void a(Context context) {
        synchronized (f7049c) {
            if (this.f7050a != null) {
                v.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f7050a = context;
            s.c().b().a(this.f7050a);
            s.c().b().j(context.getPackageName());
            j.a().a(context);
        }
    }

    public void a(String str) {
        v.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f7050a;
        if (context == null) {
            v.e("hmsSdk", "sdk is not init");
        } else {
            s.c().b().i(e1.a(com.heytap.mcssdk.constant.b.u, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
