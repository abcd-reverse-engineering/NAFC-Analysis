package com.xiaomi.push.service;

import com.xiaomi.push.eo;
import com.xiaomi.push.service.XMPushService.e;

/* loaded from: classes2.dex */
class as {

    /* renamed from: d, reason: collision with root package name */
    private static int f13385d = 300000;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f1012a;

    /* renamed from: b, reason: collision with root package name */
    private int f13387b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f13388c = 0;

    /* renamed from: a, reason: collision with root package name */
    private int f13386a = 500;

    /* renamed from: a, reason: collision with other field name */
    private long f1011a = 0;

    public as(XMPushService xMPushService) {
        this.f1012a = xMPushService;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m703a() {
        this.f1011a = System.currentTimeMillis();
        this.f1012a.a(1);
        this.f13387b = 0;
    }

    public void a(boolean z) {
        if (!this.f1012a.m663a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
            return;
        }
        if (z) {
            if (!this.f1012a.m664a(1)) {
                this.f13387b++;
            }
            this.f1012a.a(1);
            com.xiaomi.channel.commonutils.logger.b.m51a("ReconnectionManager", "-->tryReconnect(): exec ConnectJob");
            XMPushService xMPushService = this.f1012a;
            xMPushService.getClass();
            xMPushService.a(xMPushService.new e());
            return;
        }
        if (this.f1012a.m664a(1)) {
            return;
        }
        int iA = a();
        this.f13387b++;
        com.xiaomi.channel.commonutils.logger.b.m50a("schedule reconnect in " + iA + "ms");
        XMPushService xMPushService2 = this.f1012a;
        xMPushService2.getClass();
        xMPushService2.a(xMPushService2.new e(), (long) iA);
        if (this.f13387b == 2 && eo.m382a().m387a()) {
            z.b();
        }
        if (this.f13387b == 3) {
            z.a();
        }
    }

    private int a() {
        if (this.f13387b > 8) {
            return 300000;
        }
        double dRandom = (Math.random() * 2.0d) + 1.0d;
        int i2 = this.f13387b;
        if (i2 > 4) {
            return (int) (dRandom * 60000.0d);
        }
        if (i2 > 1) {
            return (int) (dRandom * 10000.0d);
        }
        if (this.f1011a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f1011a < 310000) {
            int i3 = this.f13386a;
            int i4 = f13385d;
            if (i3 >= i4) {
                return i3;
            }
            this.f13388c++;
            if (this.f13388c >= 4) {
                return i4;
            }
            this.f13386a = (int) (i3 * 1.5d);
            return i3;
        }
        this.f13386a = 1000;
        this.f13388c = 0;
        return 0;
    }
}
