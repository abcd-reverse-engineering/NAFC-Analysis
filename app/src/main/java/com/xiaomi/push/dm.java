package com.xiaomi.push;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class dm extends dl {
    public dm(Context context, int i2) {
        super(context, i2);
    }

    @Override // com.xiaomi.push.dl
    public gh a() {
        return gh.Storage;
    }

    @Override // com.xiaomi.push.ae.a
    /* renamed from: a */
    public String mo183a() {
        return "23";
    }

    @Override // com.xiaomi.push.dl
    public String b() {
        return "ram:" + i.m614a() + Constants.ACCEPT_TIME_SEPARATOR_SP + "rom:" + i.m619b() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "ramOriginal:" + i.c() + Constants.ACCEPT_TIME_SEPARATOR_SP + "romOriginal:" + i.d();
    }
}
