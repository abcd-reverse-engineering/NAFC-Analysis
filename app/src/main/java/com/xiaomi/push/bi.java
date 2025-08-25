package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ae;

/* loaded from: classes2.dex */
public class bi extends ae.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f12502a;

    public bi(Context context) {
        this.f12502a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f12502a).m59a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ae.a
    /* renamed from: a, reason: collision with other method in class */
    public String mo183a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f12502a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.f12502a).m61b();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }
}
