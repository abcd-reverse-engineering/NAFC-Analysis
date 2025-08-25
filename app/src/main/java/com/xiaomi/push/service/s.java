package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.b;
import com.xiaomi.push.service.am;
import java.util.Collection;

/* loaded from: classes2.dex */
public class s extends XMPushService.j {

    /* renamed from: a, reason: collision with root package name */
    private XMPushService f13458a;

    /* renamed from: a, reason: collision with other field name */
    private String f1072a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f1073a;

    /* renamed from: b, reason: collision with root package name */
    private String f13459b;

    /* renamed from: c, reason: collision with root package name */
    private String f13460c;

    public s(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f13458a = xMPushService;
        this.f1072a = str;
        this.f1073a = bArr;
        this.f13459b = str2;
        this.f13460c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo379a() {
        am.b next;
        p pVarM741a = q.m741a((Context) this.f13458a);
        if (pVarM741a == null) {
            try {
                pVarM741a = q.a(this.f13458a, this.f1072a, this.f13459b, this.f13460c);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e2);
            }
        }
        if (pVarM741a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            t.a(this.f13458a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("do registration now.");
        Collection<am.b> collectionM693a = am.a().m693a("5");
        if (collectionM693a.isEmpty()) {
            next = pVarM741a.a(this.f13458a);
            w.a(this.f13458a, next);
            am.a().a(next);
        } else {
            next = collectionM693a.iterator().next();
        }
        if (!this.f13458a.m668c()) {
            t.a(this.f1072a, this.f1073a);
            this.f13458a.a(true);
            return;
        }
        try {
            if (next.f996a == am.c.binded) {
                w.a(this.f13458a, this.f1072a, this.f1073a);
            } else if (next.f996a == am.c.unbind) {
                t.a(this.f1072a, this.f1073a);
                XMPushService xMPushService = this.f13458a;
                XMPushService xMPushService2 = this.f13458a;
                xMPushService2.getClass();
                xMPushService.a(xMPushService2.new b(next));
            }
        } catch (fi e3) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e3);
            this.f13458a.a(10, e3);
        }
    }
}
