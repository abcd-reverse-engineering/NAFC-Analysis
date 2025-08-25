package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* compiled from: VivoDeviceIdSupplier.java */
/* loaded from: classes2.dex */
public class be implements au {
    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        String strB = null;
        try {
            if (i.e.b.d.a.e.a(context)) {
                strB = i.e.b.d.a.e.b(context);
            } else {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return strB;
    }
}
