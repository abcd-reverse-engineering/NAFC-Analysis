package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* loaded from: classes2.dex */
public class ga implements XMPushService.n {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f12916a = false;

    /* renamed from: a, reason: collision with other field name */
    private int f554a;

    /* renamed from: a, reason: collision with other field name */
    private Context f555a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f12917b;

    public ga(Context context) {
        this.f555a = context;
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a, reason: collision with other method in class */
    public void mo458a() {
        a(this.f555a);
        if (this.f12917b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            ge geVarA = gd.a(this.f555a).a();
            if (a(geVarA)) {
                f12916a = true;
                gb.a(this.f555a, geVarA);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m50a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            }
        }
    }

    private void a(Context context) {
        this.f12917b = com.xiaomi.push.service.ah.a(context).a(gk.TinyDataUploadSwitch.a(), true);
        this.f554a = com.xiaomi.push.service.ah.a(context).a(gk.TinyDataUploadFrequency.a(), 7200);
        this.f554a = Math.max(60, this.f554a);
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f555a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f554a);
    }

    private boolean a(ge geVar) {
        if (!au.m151a(this.f555a) || geVar == null || TextUtils.isEmpty(a(this.f555a.getPackageName())) || !new File(this.f555a.getFilesDir(), "tiny_data.data").exists() || f12916a) {
            return false;
        }
        return !com.xiaomi.push.service.ah.a(this.f555a).a(gk.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m617a(this.f555a) || i.m620b(this.f555a);
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f555a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    public static void a(boolean z) {
        f12916a = z;
    }
}
