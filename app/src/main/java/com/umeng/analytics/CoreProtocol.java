package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* renamed from: a, reason: collision with root package name */
    private static Context f9970a;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final CoreProtocol f9971a = new CoreProtocol();

        private a() {
        }
    }

    public static CoreProtocol getInstance(Context context) {
        if (f9970a == null && context != null) {
            f9970a = context.getApplicationContext();
        }
        return a.f9971a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        o.a(f9970a).a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        o.a(f9970a).b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        o.a(f9970a).a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return o.a(f9970a).a(j2);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i2) {
        o.a(f9970a).a(obj, i2);
    }

    private CoreProtocol() {
    }
}
