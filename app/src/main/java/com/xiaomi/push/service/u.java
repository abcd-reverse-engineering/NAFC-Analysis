package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import com.xiaomi.push.dt;
import com.xiaomi.push.er;
import com.xiaomi.push.fi;
import com.xiaomi.push.fl;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fz;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class u {
    private static void b(Context context, hb hbVar, byte[] bArr) {
        if (x.m757a(hbVar)) {
            return;
        }
        String strA = x.a(hbVar);
        if (TextUtils.isEmpty(strA) || a(context, strA, bArr)) {
            return;
        }
        dt.a(context).b(strA, x.b(hbVar), hbVar.m529a().m495a(), "1");
    }

    private static boolean c(hb hbVar) {
        if (hbVar.m529a() == null || hbVar.m529a().m496a() == null) {
            return false;
        }
        return "1".equals(hbVar.m529a().m496a().get("obslete_ads_message"));
    }

    private static void d(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for unrecognized new miui message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.m529a().a("miui_message_unrecognized", "1");
                    w.a(xMPushService, hbVarA);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public void a(Context context, am.b bVar, boolean z, int i2, String str) {
        p pVarM741a;
        if (z || (pVarM741a = q.m741a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        q.a(context, pVarM741a.f13450f, pVarM741a.f13448d, pVarM741a.f13449e);
    }

    private static void c(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.3
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for obsleted message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.m529a().a("message_obsleted", "1");
                    w.a(xMPushService, hbVarA);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public void a(XMPushService xMPushService, fo foVar, am.b bVar) {
        if (foVar instanceof fn) {
            fn fnVar = (fn) foVar;
            fl flVarA = fnVar.a(bh.aE);
            if (flVarA != null) {
                try {
                    a(xMPushService, ar.a(ar.a(bVar.f13351h, fnVar.j()), flVarA.c()), fz.a(foVar.mo431a()));
                    return;
                } catch (IllegalArgumentException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    return;
                }
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("not a mipush message");
    }

    private static boolean b(hb hbVar) {
        Map<String, String> mapM496a = hbVar.m529a().m496a();
        return mapM496a != null && mapM496a.containsKey("notify_effect");
    }

    private static void b(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.2
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                Map<String, String> mapA = null;
                try {
                    if (com.xiaomi.push.j.m627a((Context) xMPushService)) {
                        try {
                            mapA = v.a((Context) xMPushService, hbVar);
                        } catch (Throwable th) {
                            com.xiaomi.channel.commonutils.logger.b.d("error creating params for ack message :" + th);
                        }
                    }
                    w.a(xMPushService, u.a(xMPushService, hbVar, mapA));
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("error sending ack message :" + e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public void a(XMPushService xMPushService, er erVar, am.b bVar) {
        try {
            byte[] bArrM395a = erVar.m395a(bVar.f13351h);
            HashMap map = null;
            if (e.b(erVar)) {
                map = new HashMap();
                map.put("t_im", String.valueOf(erVar.m396b()));
                map.put("t_rt", String.valueOf(erVar.m389a()));
            }
            a(xMPushService, bArrM395a, erVar.c(), map);
        } catch (IllegalArgumentException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j2) throws NumberFormatException {
        a(xMPushService, bArr, j2, (Map<String, String>) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.xiaomi.push.service.XMPushService r19, byte[] r20, long r21, java.util.Map<java.lang.String, java.lang.String> r23) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(com.xiaomi.push.service.XMPushService, byte[], long, java.util.Map):void");
    }

    public static Intent a(byte[] bArr, long j2) {
        hb hbVarA = a(bArr);
        if (hbVarA == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j2));
        intent.setPackage(hbVarA.f724b);
        return intent;
    }

    public static hb a(byte[] bArr) {
        hb hbVar = new hb();
        try {
            hp.a(hbVar, bArr);
            return hbVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x044b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.xiaomi.push.service.XMPushService r19, java.lang.String r20, byte[] r21, android.content.Intent r22) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent):void");
    }

    public static void a(Context context, hb hbVar, byte[] bArr) {
        try {
            x.c cVarM753a = x.m753a(context, hbVar, bArr);
            if (cVarM753a.f13477a > 0 && !TextUtils.isEmpty(cVarM753a.f1095a)) {
                fz.a(context, cVarM753a.f1095a, cVarM753a.f13477a, true, false, System.currentTimeMillis());
            }
            if (com.xiaomi.push.j.m627a(context) && v.a(context, hbVar, cVarM753a.f1096a)) {
                v.m748a(context, hbVar);
                com.xiaomi.channel.commonutils.logger.b.m50a("consume this broadcast by tts");
            } else {
                b(context, hbVar, bArr);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m50a("notify push msg error " + e2);
            e2.printStackTrace();
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (!com.xiaomi.push.g.m454a(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("broadcast message arrived.");
            context.sendBroadcast(intent, w.a(str));
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m50a("meet error when broadcast message arrived. " + e2);
            return false;
        }
    }

    private static boolean a(XMPushService xMPushService, String str, hb hbVar, gs gsVar) {
        boolean z = true;
        if (gsVar != null && gsVar.m496a() != null && gsVar.m496a().containsKey("__check_alive") && gsVar.m496a().containsKey("__awake")) {
            he heVar = new he();
            heVar.b(hbVar.m530a());
            heVar.d(str);
            heVar.c(gp.AwakeSystemApp.f597a);
            heVar.a(gsVar.m495a());
            heVar.f736a = new HashMap();
            boolean zM454a = com.xiaomi.push.g.m454a(xMPushService.getApplicationContext(), str);
            heVar.f736a.put("app_running", Boolean.toString(zM454a));
            if (!zM454a) {
                boolean z2 = Boolean.parseBoolean(gsVar.m496a().get("__awake"));
                heVar.f736a.put("awaked", Boolean.toString(z2));
                if (!z2) {
                    z = false;
                }
            }
            try {
                w.a(xMPushService, w.a(hbVar.b(), hbVar.m530a(), heVar, gf.Notification));
            } catch (fi e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
        return z;
    }

    private static void a(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send app absent message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                try {
                    w.a(xMPushService, w.a(hbVar.b(), hbVar.m530a()));
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    private static boolean a(hb hbVar) {
        return "com.xiaomi.xmsf".equals(hbVar.f724b) && hbVar.m529a() != null && hbVar.m529a().m496a() != null && hbVar.m529a().m496a().containsKey("miui_package_name");
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (listQueryBroadcastReceivers.isEmpty()) {
                if (listQueryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    private static void a(final XMPushService xMPushService, final hb hbVar, final String str) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.5
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send app absent ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.m529a().a("absent_target_package", str);
                    w.a(xMPushService, hbVarA);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final hb hbVar, final String str, final String str2) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.6
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send wrong message ack for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.f718a.a("error", str);
                    hbVarA.f718a.a("reason", str2);
                    w.a(xMPushService, hbVarA);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final hb hbVar, final he heVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.7
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for clear push message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() {
                try {
                    gw gwVar = new gw();
                    gwVar.c(gp.CancelPushMessageACK.f597a);
                    gwVar.a(heVar.m544a());
                    gwVar.a(heVar.a());
                    gwVar.b(heVar.b());
                    gwVar.e(heVar.d());
                    gwVar.a(0L);
                    gwVar.d("success clear push message.");
                    w.a(xMPushService, w.b(hbVar.b(), hbVar.m530a(), gwVar, gf.Notification));
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public static hb a(Context context, hb hbVar) {
        return a(context, hbVar, (Map<String, String>) null);
    }

    public static hb a(Context context, hb hbVar, Map<String, String> map) {
        gv gvVar = new gv();
        gvVar.b(hbVar.m530a());
        gs gsVarM529a = hbVar.m529a();
        if (gsVarM529a != null) {
            gvVar.a(gsVarM529a.m495a());
            gvVar.a(gsVarM529a.m493a());
            if (!TextUtils.isEmpty(gsVarM529a.m500b())) {
                gvVar.c(gsVarM529a.m500b());
            }
        }
        gvVar.a(hp.a(context, hbVar));
        hb hbVarA = w.a(hbVar.b(), hbVar.m530a(), gvVar, gf.AckMessage);
        gs gsVarM529a2 = hbVar.m529a();
        if (gsVarM529a2 != null) {
            gsVarM529a2 = au.a(gsVarM529a2.m494a());
            Map<String, String> mapM496a = gsVarM529a2.m496a();
            String str = mapM496a != null ? mapM496a.get("channel_id") : null;
            gsVarM529a2.a("mat", Long.toString(System.currentTimeMillis()));
            gsVarM529a2.a("cs", String.valueOf(f.a(context, hbVar.f724b, str)));
        }
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str2 : map.keySet()) {
                        gsVarM529a2.a(str2, map.get(str2));
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("error adding params to ack message :" + th);
            }
        }
        hbVarA.a(gsVarM529a2);
        return hbVarA;
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (listQueryBroadcastReceivers != null) {
                if (!listQueryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
