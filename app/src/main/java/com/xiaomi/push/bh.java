package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes2.dex */
public class bh implements Runnable {
    private bh() {
    }

    public static void a(Context context) {
        if (context == null || !"com.xiaomi.xmsf".equals(context.getPackageName())) {
            return;
        }
        a aVar = new a(context);
        if (aVar.m182a()) {
            new Thread(new bh()).start();
            aVar.m181a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0191  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bh.run():void");
    }

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public SharedPreferences f12501a;

        /* renamed from: a, reason: collision with other field name */
        private final String f214a = "dc_job_result_time_26";

        public a(Context context) {
            this.f12501a = context.getSharedPreferences("mipush_extra", 0);
            long j2 = this.f12501a.getLong("dc_job_result_time_26", 0L);
            if (j2 <= 0 || j2 - System.currentTimeMillis() > 259200000) {
                this.f12501a.edit().putLong("dc_job_result_time_26", a()).apply();
            }
        }

        private long a() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Random random = new Random(jCurrentTimeMillis);
            return (((jCurrentTimeMillis / 86400000) + 1) * 86400000) + (random.nextInt(3) * 86400000) + random.nextInt(46800000);
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m182a() {
            return System.currentTimeMillis() - this.f12501a.getLong("dc_job_result_time_26", 0L) > 0;
        }

        private a() {
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m181a() {
            long j2 = this.f12501a.getLong("dc_job_result_time_26", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis() - j2;
            if (jCurrentTimeMillis >= 0) {
                this.f12501a.edit().putLong("dc_job_result_time_26", j2 + (((jCurrentTimeMillis / 259200000) + 1) * 259200000)).apply();
            }
        }
    }

    private void a(bd bdVar, bc bcVar, Exception exc) {
        HashMap map = new HashMap();
        String strM742a = com.xiaomi.push.service.q.m742a(C0343r.m636a());
        if (!TextUtils.isEmpty(strM742a)) {
            map.put("uuid", strM742a);
        }
        map.put("appCount", Long.valueOf(bdVar.m179a()));
        map.put("channels", Long.valueOf(bdVar.b()));
        map.put("packCount", Long.valueOf(bdVar.c()));
        map.put("totalSize", Long.valueOf(bdVar.d()));
        map.put("isBatch", Integer.valueOf(bdVar.a()));
        map.put("maxCallTime", Long.valueOf(bcVar.a()));
        map.put("minCallTime", Long.valueOf(bcVar.b()));
        map.put("callAvg", Long.valueOf(bcVar.c()));
        map.put("duration", Long.valueOf(bcVar.d()));
        if (exc != null) {
            map.put("exception", exc.toString());
        }
        eh.a().a("app_switch_upload", map);
    }

    private void a(Context context, bg bgVar, bd bdVar) {
        gj gjVar = new gj();
        gjVar.d("category_app_channel_info");
        gjVar.c("app_channel_info");
        gjVar.b(bgVar.toString());
        gjVar.a(false);
        gjVar.a(1L);
        gjVar.a("xmsf_channel");
        gjVar.b(System.currentTimeMillis());
        gjVar.g("com.xiaomi.xmsf");
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f(com.xiaomi.push.service.az.a());
        com.xiaomi.push.service.ba.a(context, gjVar);
    }
}
