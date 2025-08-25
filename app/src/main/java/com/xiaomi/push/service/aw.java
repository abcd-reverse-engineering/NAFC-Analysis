package com.xiaomi.push.service;

import com.xiaomi.push.er;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes2.dex */
public class aw extends XMPushService.j {

    /* renamed from: a, reason: collision with root package name */
    private er f13396a;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f1014a;

    public aw(XMPushService xMPushService, er erVar) {
        super(4);
        this.f1014a = null;
        this.f1014a = xMPushService;
        this.f13396a = erVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo379a() {
        try {
            if (this.f13396a != null) {
                if (e.a(this.f13396a)) {
                    this.f13396a.c(System.currentTimeMillis() - this.f13396a.m389a());
                }
                this.f1014a.a(this.f13396a);
            }
        } catch (fi e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f1014a.a(10, e2);
        }
    }
}
