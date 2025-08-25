package com.umeng.commonsdk.statistics.idtracking;

import android.annotation.TargetApi;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: SerialTracker.java */
/* loaded from: classes2.dex */
public class i extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10951a = "serial";

    public i() {
        super(f10951a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    @TargetApi(9)
    public String f() {
        return DeviceConfig.getSerial();
    }
}
