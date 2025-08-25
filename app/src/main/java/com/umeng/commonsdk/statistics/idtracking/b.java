package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: AndroidIdTracker.java */
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10924a = "android_id";

    /* renamed from: b, reason: collision with root package name */
    private Context f10925b;

    public b(Context context) {
        super("android_id");
        this.f10925b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getAndroidId(this.f10925b);
    }
}
