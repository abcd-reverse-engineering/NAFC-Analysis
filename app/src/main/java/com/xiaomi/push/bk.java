package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;

/* loaded from: classes2.dex */
public class bk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f12504a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f215a;

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f215a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f215a != null) {
                this.f215a.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            if (this.f215a instanceof IEventProcessor) {
                bm.a(this.f12504a).m187a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (this.f215a instanceof IPerfProcessor) {
                bm.a(this.f12504a).m187a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(Context context) {
        this.f12504a = context;
    }
}
