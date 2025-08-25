package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: LogCatNode.java */
/* loaded from: classes.dex */
public class c implements d {

    /* renamed from: a, reason: collision with root package name */
    private d f6660a;

    @Override // com.huawei.hms.base.log.d
    public void a(Context context, String str) {
        d dVar = this.f6660a;
        if (dVar != null) {
            dVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.d
    public void a(d dVar) {
        this.f6660a = dVar;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(String str, int i2, String str2, String str3) {
        Log.println(i2, "HMSSDK_" + str2, str3);
        d dVar = this.f6660a;
        if (dVar != null) {
            dVar.a(str, i2, str2, str3);
        }
    }
}
