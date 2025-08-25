package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* compiled from: XiaomiDeviceIdSupplier.java */
/* loaded from: classes2.dex */
class bf implements au {
    bf() {
    }

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        String strB = null;
        try {
            if (i.e.b.c.a.b.a()) {
                strB = i.e.b.c.a.b.b(context);
            } else {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return strB;
    }
}
