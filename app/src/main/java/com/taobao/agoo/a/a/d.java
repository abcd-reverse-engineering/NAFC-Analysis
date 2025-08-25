package com.taobao.agoo.a.a;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.p;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class d extends b {
    public static final String JSON_CMD_DISABLEPUSH = "disablePush";
    public static final String JSON_CMD_ENABLEPUSH = "enablePush";

    /* renamed from: a, reason: collision with root package name */
    public String f8725a;

    /* renamed from: b, reason: collision with root package name */
    public String f8726b;

    /* renamed from: c, reason: collision with root package name */
    public String f8727c;

    public byte[] a() {
        try {
            p.a aVar = new p.a();
            aVar.a(b.JSON_CMD, this.f8712e).a("appKey", this.f8725a);
            if (TextUtils.isEmpty(this.f8726b)) {
                aVar.a("utdid", this.f8727c);
            } else {
                aVar.a("deviceId", this.f8726b);
            }
            String string = aVar.a().toString();
            ALog.i("SwitchDO", "buildData", "data", string);
            return string.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("SwitchDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3, boolean z) {
        d dVar = new d();
        dVar.f8725a = str;
        dVar.f8726b = str2;
        dVar.f8727c = str3;
        if (z) {
            dVar.f8712e = JSON_CMD_ENABLEPUSH;
        } else {
            dVar.f8712e = JSON_CMD_DISABLEPUSH;
        }
        return dVar.a();
    }
}
