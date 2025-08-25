package com.xiaomi.push.service;

import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.push.cc;
import com.xiaomi.push.cg;
import com.xiaomi.push.db;
import com.xiaomi.push.dp;
import com.xiaomi.push.ei;
import com.xiaomi.push.ep;
import com.xiaomi.push.er;
import com.xiaomi.push.fb;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fz;
import com.xiaomi.push.service.am;
import java.util.Date;

/* loaded from: classes2.dex */
public class ak {

    /* renamed from: a, reason: collision with root package name */
    private XMPushService f13341a;

    ak(XMPushService xMPushService) {
        this.f13341a = xMPushService;
    }

    private void c(er erVar) {
        am.b bVarA;
        String strG = erVar.g();
        String string = Integer.toString(erVar.a());
        if (TextUtils.isEmpty(strG) || TextUtils.isEmpty(string) || (bVarA = am.a().a(string, strG)) == null) {
            return;
        }
        fz.a(this.f13341a, bVarA.f998a, erVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fo foVar) {
        if (!"5".equals(foVar.k())) {
            b(foVar);
        }
        String strK = foVar.k();
        if (TextUtils.isEmpty(strK)) {
            strK = "1";
            foVar.l("1");
        }
        if (strK.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Received wrong packet with chid = 0 : " + foVar.mo431a());
        }
        if (foVar instanceof fm) {
            fl flVarA = foVar.a("kick");
            if (flVarA != null) {
                String strL = foVar.l();
                String strA = flVarA.a("type");
                String strA2 = flVarA.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m50a("kicked by server, chid=" + strK + " res=" + am.b.a(strL) + " type=" + strA + " reason=" + strA2);
                if (!"wait".equals(strA)) {
                    this.f13341a.a(strK, strL, 3, strA2, strA);
                    am.a().m697a(strK, strL);
                    return;
                }
                am.b bVarA = am.a().a(strK, strL);
                if (bVarA != null) {
                    this.f13341a.a(bVarA);
                    bVarA.a(am.c.unbind, 3, 0, strA2, strA);
                    return;
                }
                return;
            }
        } else if (foVar instanceof fn) {
            fn fnVar = (fn) foVar;
            if ("redir".equals(fnVar.b())) {
                fl flVarA2 = fnVar.a(DispatchConstants.HOSTS);
                if (flVarA2 != null) {
                    a(flVarA2);
                    return;
                }
                return;
            }
        }
        this.f13341a.m665b().a(this.f13341a, strK, foVar);
    }

    public void b(er erVar) throws RemoteException {
        String strM390a = erVar.m390a();
        if (erVar.a() == 0) {
            if ("PING".equals(strM390a)) {
                byte[] bArrM394a = erVar.m394a();
                if (bArrM394a != null && bArrM394a.length > 0) {
                    dp.j jVarA = dp.j.a(bArrM394a);
                    if (jVarA.m348b()) {
                        ax.a().a(jVarA.m346a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.f13341a.getPackageName())) {
                    this.f13341a.m662a();
                }
                if ("1".equals(erVar.e())) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("received a server ping");
                } else {
                    ep.b();
                }
                this.f13341a.m666b();
                return;
            }
            if (!"SYNC".equals(strM390a)) {
                if ("NOTIFY".equals(erVar.m390a())) {
                    dp.h hVarA = dp.h.a(erVar.m394a());
                    com.xiaomi.channel.commonutils.logger.b.m50a("notify by server err = " + hVarA.c() + " desc = " + hVarA.m340a());
                    return;
                }
                return;
            }
            if ("CONF".equals(erVar.m397b())) {
                ax.a().a(dp.b.a(erVar.m394a()));
                return;
            }
            if (TextUtils.equals("U", erVar.m397b())) {
                dp.k kVarA = dp.k.a(erVar.m394a());
                db.a(this.f13341a).a(kVarA.m350a(), kVarA.m353b(), new Date(kVarA.m349a()), new Date(kVarA.m352b()), kVarA.c() * 1024, kVarA.e());
                er erVar2 = new er();
                erVar2.a(0);
                erVar2.a(erVar.m390a(), "UCA");
                erVar2.a(erVar.e());
                XMPushService xMPushService = this.f13341a;
                xMPushService.a(new aw(xMPushService, erVar2));
                return;
            }
            if (TextUtils.equals("P", erVar.m397b())) {
                dp.i iVarA = dp.i.a(erVar.m394a());
                er erVar3 = new er();
                erVar3.a(0);
                erVar3.a(erVar.m390a(), "PCA");
                erVar3.a(erVar.e());
                dp.i iVar = new dp.i();
                if (iVarA.m344a()) {
                    iVar.a(iVarA.m343a());
                }
                erVar3.a(iVar.m374a(), (String) null);
                XMPushService xMPushService2 = this.f13341a;
                xMPushService2.a(new aw(xMPushService2, erVar3));
                com.xiaomi.channel.commonutils.logger.b.m50a("ACK msgP: id = " + erVar.e());
                return;
            }
            return;
        }
        String string = Integer.toString(erVar.a());
        if ("SECMSG".equals(erVar.m390a())) {
            if (!erVar.m393a()) {
                this.f13341a.m665b().a(this.f13341a, string, erVar);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("Recv SECMSG errCode = " + erVar.b() + " errStr = " + erVar.m400c());
            return;
        }
        if (!"BIND".equals(strM390a)) {
            if ("KICK".equals(strM390a)) {
                dp.g gVarA = dp.g.a(erVar.m394a());
                String strG = erVar.g();
                String strM335a = gVarA.m335a();
                String strM337b = gVarA.m337b();
                com.xiaomi.channel.commonutils.logger.b.m50a("kicked by server, chid=" + string + " res= " + am.b.a(strG) + " type=" + strM335a + " reason=" + strM337b);
                if (!"wait".equals(strM335a)) {
                    this.f13341a.a(string, strG, 3, strM337b, strM335a);
                    am.a().m697a(string, strG);
                    return;
                }
                am.b bVarA = am.a().a(string, strG);
                if (bVarA != null) {
                    this.f13341a.a(bVarA);
                    bVarA.a(am.c.unbind, 3, 0, strM337b, strM335a);
                    return;
                }
                return;
            }
            return;
        }
        dp.d dVarA = dp.d.a(erVar.m394a());
        String strG2 = erVar.g();
        am.b bVarA2 = am.a().a(string, strG2);
        if (bVarA2 == null) {
            return;
        }
        if (dVarA.m311a()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("SMACK: channel bind succeeded, chid=" + erVar.a());
            bVarA2.a(am.c.binded, 1, 0, (String) null, (String) null);
            return;
        }
        String strM310a = dVarA.m310a();
        if ("auth".equals(strM310a)) {
            if ("invalid-sig".equals(dVarA.m312b())) {
                com.xiaomi.channel.commonutils.logger.b.m50a("SMACK: bind error invalid-sig token = " + bVarA2.f13346c + " sec = " + bVarA2.f13351h);
                ep.a(0, ei.BIND_INVALID_SIG.a(), 1, null, 0);
            }
            bVarA2.a(am.c.unbind, 1, 5, dVarA.m312b(), strM310a);
            am.a().m697a(string, strG2);
        } else if (CommonNetImpl.CANCEL.equals(strM310a)) {
            bVarA2.a(am.c.unbind, 1, 7, dVarA.m312b(), strM310a);
            am.a().m697a(string, strG2);
        } else if ("wait".equals(strM310a)) {
            this.f13341a.a(bVarA2);
            bVarA2.a(am.c.unbind, 1, 7, dVarA.m312b(), strM310a);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("SMACK: channel bind failed, chid=" + string + " reason=" + dVarA.m312b());
    }

    public void a(er erVar) {
        if (5 != erVar.a()) {
            c(erVar);
        }
        try {
            b(erVar);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + erVar.a() + " cmd = " + erVar.m390a() + " packetid = " + erVar.e() + " failure ", e2);
        }
    }

    private void a(fl flVar) {
        String strC = flVar.c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        String[] strArrSplit = strC.split(";");
        cc ccVarA = cg.a().a(fb.a(), false);
        if (ccVarA == null || strArrSplit.length <= 0) {
            return;
        }
        ccVarA.a(strArrSplit);
        this.f13341a.a(20, (Exception) null);
        this.f13341a.a(true);
    }

    private void b(fo foVar) {
        am.b bVarA;
        String strL = foVar.l();
        String strK = foVar.k();
        if (TextUtils.isEmpty(strL) || TextUtils.isEmpty(strK) || (bVarA = am.a().a(strK, strL)) == null) {
            return;
        }
        fz.a(this.f13341a, bVarA.f998a, fz.a(foVar.mo431a()), true, true, System.currentTimeMillis());
    }
}
