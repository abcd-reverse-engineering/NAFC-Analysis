package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* compiled from: OppoDeviceIdSupplier.java */
/* loaded from: classes2.dex */
public class bc implements au {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10111a = false;

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        try {
            if (!this.f10111a) {
                i.e.b.a.a.a.a.a(context);
                this.f10111a = true;
            }
            if (i.e.b.a.a.a.a.a()) {
                return i.e.b.a.a.a.a.c(context);
            }
            UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            return null;
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
