package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Intent;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.common.UPLog;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class aj implements UPushMessageNotifyApi {

    /* renamed from: c, reason: collision with root package name */
    private static volatile aj f11272c;

    /* renamed from: a, reason: collision with root package name */
    public final ak f11273a = new ak();

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f11274b;

    private aj() {
    }

    public static aj a() {
        if (f11272c == null) {
            synchronized (aj.class) {
                if (f11272c == null) {
                    f11272c = new aj();
                }
            }
        }
        return f11272c;
    }

    public final void b() {
        if (this.f11274b) {
            return;
        }
        this.f11274b = true;
        this.f11273a.a();
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public boolean isEnabled() {
        return this.f11273a.f11276b.a();
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public void setCallback(UPushMessageNotifyApi.Callback callback) {
        ak akVar = this.f11273a;
        akVar.f11275a = callback;
        if (callback == null || !akVar.f11277c) {
            return;
        }
        try {
            callback.onNotified();
            akVar.f11277c = false;
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public void setEnable(final boolean z) {
        final ak akVar = this.f11273a;
        if (akVar.f11276b.a() != z) {
            akVar.f11276b.f11287a.a("e_u", z);
            b.b(new Runnable() { // from class: com.umeng.message.proguard.ak.4
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.f11276b.b(true);
                    boolean zA = false;
                    try {
                        if (d.h(x.a())) {
                            zA = ak.a(z);
                        }
                    } catch (Throwable th) {
                        UPLog.e("Notify", th);
                    }
                    ak.this.f11276b.b(!zA);
                }
            });
        }
    }

    public final void a(JSONObject jSONObject) {
        this.f11273a.a(jSONObject);
    }

    public final void a(Activity activity, Intent intent) {
        this.f11273a.a(activity, intent);
    }
}
