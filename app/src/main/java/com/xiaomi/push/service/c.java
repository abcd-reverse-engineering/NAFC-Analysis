package com.xiaomi.push.service;

import com.xiaomi.push.er;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes2.dex */
class c extends XMPushService.j {

    /* renamed from: a, reason: collision with root package name */
    private XMPushService f13416a;

    /* renamed from: a, reason: collision with other field name */
    private er[] f1038a;

    public c(XMPushService xMPushService, er[] erVarArr) {
        super(4);
        this.f13416a = null;
        this.f13416a = xMPushService;
        this.f1038a = erVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo379a() {
        try {
            if (this.f1038a != null) {
                this.f13416a.a(this.f1038a);
            }
        } catch (fi e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f13416a.a(10, e2);
        }
    }
}
