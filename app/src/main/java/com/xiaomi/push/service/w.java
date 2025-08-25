package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.cs;
import com.xiaomi.push.er;
import com.xiaomi.push.fa;
import com.xiaomi.push.fi;
import com.xiaomi.push.fo;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gu;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.ay;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class w {
    static void a(XMPushService xMPushService) {
        p pVarM741a = q.m741a(xMPushService.getApplicationContext());
        if (pVarM741a != null) {
            am.b bVarA = q.m741a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.channel.commonutils.logger.b.m50a("prepare account. " + bVarA.f998a);
            a(xMPushService, bVarA);
            am.a().a(bVarA);
            a(xMPushService, pVarM741a, 172800);
        }
    }

    static <T extends hq<T, ?>> hb b(String str, String str2, T t, gf gfVar) {
        return a(str, str2, t, gfVar, false);
    }

    static hb b(String str, String str2) {
        he heVar = new he();
        heVar.b(str2);
        heVar.c(gp.AppDataCleared.f597a);
        heVar.a(aj.a());
        heVar.a(false);
        return a(str, str2, heVar, gf.Notification);
    }

    private static void a(final XMPushService xMPushService, final p pVar, int i2) {
        ay.a(xMPushService).a(new ay.a("MSAID", i2) { // from class: com.xiaomi.push.service.w.1
            @Override // com.xiaomi.push.service.ay.a
            void a(ay ayVar) {
                com.xiaomi.push.an anVarA = com.xiaomi.push.an.a(xMPushService);
                String strA = ayVar.a("MSAID", "msaid");
                String strMo136a = anVarA.mo136a();
                if (TextUtils.isEmpty(strMo136a) || TextUtils.equals(strA, strMo136a)) {
                    return;
                }
                ayVar.a("MSAID", "msaid", strMo136a);
                he heVar = new he();
                heVar.b(pVar.f13448d);
                heVar.c(gp.ClientInfoUpdate.f597a);
                heVar.a(aj.a());
                heVar.a(new HashMap());
                anVarA.a(heVar.m545a());
                byte[] bArrA = hp.a(w.a(xMPushService.getPackageName(), pVar.f13448d, heVar, gf.Notification));
                XMPushService xMPushService2 = xMPushService;
                xMPushService2.a(xMPushService2.getPackageName(), bArrA, true);
            }
        });
    }

    private static String a(hb hbVar) {
        Map<String, String> map;
        gs gsVar = hbVar.f718a;
        if (gsVar != null && (map = gsVar.f636b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hbVar.f724b;
    }

    static er a(p pVar, Context context, hb hbVar) throws NumberFormatException {
        try {
            er erVar = new er();
            erVar.a(5);
            erVar.c(pVar.f1067a);
            erVar.b(a(hbVar));
            erVar.a("SECMSG", "message");
            String str = pVar.f1067a;
            hbVar.f719a.f646a = str.substring(0, str.indexOf("@"));
            hbVar.f719a.f650c = str.substring(str.indexOf("/") + 1);
            erVar.a(hp.a(hbVar), pVar.f13447c);
            erVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m50a("try send mi push message. packagename:" + hbVar.f724b + " action:" + hbVar.f717a);
            return erVar;
        } catch (NullPointerException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    static er a(XMPushService xMPushService, byte[] bArr) {
        hb hbVar = new hb();
        try {
            hp.a(hbVar, bArr);
            return a(q.m741a((Context) xMPushService), xMPushService, hbVar);
        } catch (hu e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    static <T extends hq<T, ?>> hb a(String str, String str2, T t, gf gfVar) {
        return a(str, str2, t, gfVar, true);
    }

    private static <T extends hq<T, ?>> hb a(String str, String str2, T t, gf gfVar, boolean z) {
        byte[] bArrA = hp.a(t);
        hb hbVar = new hb();
        gu guVar = new gu();
        guVar.f645a = 5L;
        guVar.f646a = "fakeid";
        hbVar.a(guVar);
        hbVar.a(ByteBuffer.wrap(bArrA));
        hbVar.a(gfVar);
        hbVar.b(z);
        hbVar.b(str);
        hbVar.a(false);
        hbVar.a(str2);
        return hbVar;
    }

    static hb a(String str, String str2) {
        he heVar = new he();
        heVar.b(str2);
        heVar.c("package uninstalled");
        heVar.a(fo.i());
        heVar.a(false);
        return a(str, str2, heVar, gf.Notification);
    }

    static void a(final XMPushService xMPushService, am.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new am.b.a() { // from class: com.xiaomi.push.service.w.2
            @Override // com.xiaomi.push.service.am.b.a
            public void a(am.c cVar, am.c cVar2, int i2) throws InterruptedException {
                if (cVar2 == am.c.binded) {
                    t.a(xMPushService, true);
                    t.a(xMPushService);
                } else if (cVar2 == am.c.unbind) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("onChange unbind");
                    t.a(xMPushService, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
                }
            }
        });
    }

    static void a(XMPushService xMPushService, String str, byte[] bArr) {
        cs.a(str, xMPushService.getApplicationContext(), bArr);
        fa faVarM660a = xMPushService.m660a();
        if (faVarM660a != null) {
            if (faVarM660a.mo407a()) {
                er erVarA = a(xMPushService, bArr);
                if (erVarA != null) {
                    faVarM660a.b(erVarA);
                    return;
                } else {
                    t.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
                    return;
                }
            }
            throw new fi("Don't support XMPP connection.");
        }
        throw new fi("try send msg while connection is null.");
    }

    static void a(XMPushService xMPushService, hb hbVar) {
        cs.a(hbVar.b(), xMPushService.getApplicationContext(), hbVar, -1);
        fa faVarM660a = xMPushService.m660a();
        if (faVarM660a != null) {
            if (faVarM660a.mo407a()) {
                er erVarA = a(q.m741a((Context) xMPushService), xMPushService, hbVar);
                if (erVarA != null) {
                    faVarM660a.b(erVarA);
                    return;
                }
                return;
            }
            throw new fi("Don't support XMPP connection.");
        }
        throw new fi("try send msg while connection is null.");
    }

    static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }
}
