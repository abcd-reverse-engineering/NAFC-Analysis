package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ae;

/* loaded from: classes2.dex */
public class bj extends ae.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f12503a;

    public bj(Context context) {
        this.f12503a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f12503a).m59a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ae.a
    /* renamed from: a */
    public String mo183a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.f12503a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.f12503a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. " + e2);
        }
    }
}
