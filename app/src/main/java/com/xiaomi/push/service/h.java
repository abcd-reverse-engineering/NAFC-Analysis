package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.er;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fq;
import com.xiaomi.push.service.am;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private u f13423a = new u();

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.service_started");
            if (com.xiaomi.push.j.m631c()) {
                intent.addFlags(16777216);
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
            intent.setPackage("com.android.mms");
            context.sendBroadcast(intent);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, am.b bVar, boolean z, int i2, String str) {
        if ("5".equalsIgnoreCase(bVar.f13350g)) {
            this.f13423a.a(context, bVar, z, i2, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f998a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i2);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f13350g);
        intent.putExtra(an.s, bVar.f1001b);
        intent.putExtra(an.J, bVar.f13352i);
        com.xiaomi.channel.commonutils.logger.b.m50a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.f13350g, bVar.f998a, Boolean.valueOf(z), Integer.valueOf(i2)));
        a(context, intent, bVar);
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, am.b bVar, int i2) {
        if ("5".equalsIgnoreCase(bVar.f13350g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f998a);
        intent.putExtra(an.v, bVar.f13350g);
        intent.putExtra("ext_reason", i2);
        intent.putExtra(an.s, bVar.f1001b);
        intent.putExtra(an.J, bVar.f13352i);
        if (bVar.f992a != null && "9".equals(bVar.f13350g)) {
            try {
                bVar.f992a.send(Message.obtain(null, 17, intent));
                return;
            } catch (RemoteException unused) {
                bVar.f992a = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str = bVar.f1001b;
                sb.append(str.substring(str.lastIndexOf(64)));
                com.xiaomi.channel.commonutils.logger.b.m50a(sb.toString());
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m50a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.f13350g, bVar.f998a, Integer.valueOf(i2)));
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, fo foVar) {
        String str2;
        am.b bVarA = a(foVar);
        if (bVarA == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f13423a.a(xMPushService, foVar, bVarA);
            return;
        }
        String str3 = bVarA.f998a;
        if (foVar instanceof fn) {
            str2 = "com.xiaomi.push.new_msg";
        } else if (foVar instanceof fm) {
            str2 = "com.xiaomi.push.new_iq";
        } else {
            if (!(foVar instanceof fq)) {
                com.xiaomi.channel.commonutils.logger.b.d("unknown packet type, drop it");
                return;
            }
            str2 = "com.xiaomi.push.new_pres";
        }
        Intent intent = new Intent();
        intent.setAction(str2);
        intent.setPackage(str3);
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_packet", foVar.a());
        intent.putExtra(an.J, bVarA.f13352i);
        intent.putExtra(an.B, bVarA.f13351h);
        com.xiaomi.channel.commonutils.logger.b.m50a(String.format("[Bcst] notify packet arrival. %s,%s,%s", bVarA.f13350g, bVarA.f998a, foVar.j()));
        if ("3".equalsIgnoreCase(str)) {
            intent.putExtra(an.w, foVar.f529a);
            intent.putExtra(an.x, System.currentTimeMillis());
        }
        a(xMPushService, intent, bVarA);
    }

    public void a(XMPushService xMPushService, String str, er erVar) throws RemoteException {
        am.b bVarA = a(erVar);
        if (bVarA == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f13423a.a(xMPushService, erVar, bVarA);
            return;
        }
        String str2 = bVarA.f998a;
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.new_msg");
        intent.setPackage(str2);
        intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_raw_packet", erVar.m395a(bVarA.f13351h));
        intent.putExtra(an.J, bVarA.f13352i);
        intent.putExtra(an.B, bVarA.f13351h);
        if (e.a(erVar)) {
            intent.putExtra("ext_downward_pkt_id", erVar.e());
        }
        if (bVarA.f992a != null) {
            try {
                bVarA.f992a.send(Message.obtain(null, 17, intent));
                com.xiaomi.channel.commonutils.logger.b.m50a("message was sent by messenger for chid=" + str);
                return;
            } catch (RemoteException unused) {
                bVarA.f992a = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str3 = bVarA.f1001b;
                sb.append(str3.substring(str3.lastIndexOf(64)));
                com.xiaomi.channel.commonutils.logger.b.m50a(sb.toString());
            }
        }
        if ("com.xiaomi.xmsf".equals(str2)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVarA.f13350g, bVarA.f998a, erVar.e()));
        if (e.a(erVar)) {
            at.a().a(erVar.e(), SystemClock.elapsedRealtime());
        }
        a(xMPushService, intent, bVarA);
    }

    am.b a(fo foVar) {
        Collection<am.b> collectionM693a = am.a().m693a(foVar.k());
        if (collectionM693a.isEmpty()) {
            return null;
        }
        Iterator<am.b> it = collectionM693a.iterator();
        if (collectionM693a.size() == 1) {
            return it.next();
        }
        String strM = foVar.m();
        String strL = foVar.l();
        while (it.hasNext()) {
            am.b next = it.next();
            if (TextUtils.equals(strM, next.f1001b) || TextUtils.equals(strL, next.f1001b)) {
                return next;
            }
        }
        return null;
    }

    am.b a(er erVar) {
        Collection<am.b> collectionM693a = am.a().m693a(Integer.toString(erVar.a()));
        if (collectionM693a.isEmpty()) {
            return null;
        }
        Iterator<am.b> it = collectionM693a.iterator();
        if (collectionM693a.size() == 1) {
            return it.next();
        }
        String strG = erVar.g();
        while (it.hasNext()) {
            am.b next = it.next();
            if (TextUtils.equals(strG, next.f1001b)) {
                return next;
            }
        }
        return null;
    }

    public void a(Context context, am.b bVar, String str, String str2) {
        if (bVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify kick by server!");
            return;
        }
        if ("5".equalsIgnoreCase(bVar.f13350g)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f998a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.f13350g);
        intent.putExtra(an.s, bVar.f1001b);
        intent.putExtra(an.J, bVar.f13352i);
        com.xiaomi.channel.commonutils.logger.b.m50a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.f13350g, bVar.f998a, str2));
        a(context, intent, bVar);
    }

    private static void a(Context context, Intent intent, am.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    public static String a(am.b bVar) {
        if (!"9".equals(bVar.f13350g)) {
            return bVar.f998a + ".permission.MIPUSH_RECEIVE";
        }
        return bVar.f998a + ".permission.MIMC_RECEIVE";
    }
}
