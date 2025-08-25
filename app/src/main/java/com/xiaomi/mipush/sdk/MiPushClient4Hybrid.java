package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.bb;
import com.xiaomi.push.ed;
import com.xiaomi.push.g;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.gv;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes2.dex */
public class MiPushClient4Hybrid {
    private static MiPushCallback sCallback;
    private static Map<String, b.a> dataMap = new HashMap();
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int iIntValue = TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue();
        if (!z) {
            iIntValue = (iIntValue & (-4)) + g.b.NOT_ALLOWED.a();
        }
        return (short) iIntValue;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.m75a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, hg hgVar) {
        b.a aVar;
        String strC = hgVar.c();
        if (hgVar.a() == 0 && (aVar = dataMap.get(strC)) != null) {
            aVar.a(hgVar.f792e, hgVar.f793f);
            b.m75a(context).a(strC, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(hgVar.f792e)) {
            arrayList = new ArrayList();
            arrayList.add(hgVar.f792e);
        }
        MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ed.COMMAND_REGISTER.f424a, arrayList, hgVar.f780a, hgVar.f791d, null, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(strC, miPushCommandMessageGenerateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, hm hmVar) {
        MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ed.COMMAND_UNREGISTER.f424a, null, hmVar.f858a, hmVar.f866d, null, null);
        String strA = hmVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(strA, miPushCommandMessageGenerateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m75a(context).m80a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a aVarA = b.m75a(context).a(str);
            if (aVarA != null) {
                arrayList.add(aVarA.f12358c);
                MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ed.COMMAND_REGISTER.f424a, arrayList, 0L, null, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, miPushCommandMessageGenerateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                he heVar = new he();
                heVar.b(str2);
                heVar.c(gp.PullOfflineMessage.f597a);
                heVar.a(aj.a());
                heVar.a(false);
                u.a(context).a(heVar, gf.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < com.heytap.mcssdk.constant.a.r) {
            com.xiaomi.channel.commonutils.logger.b.m50a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(jCurrentTimeMillis));
        String strA = bb.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, strA);
        dataMap.put(str, aVar);
        hf hfVar = new hf();
        hfVar.a(aj.a());
        hfVar.b(str2);
        hfVar.e(str3);
        hfVar.d(str);
        hfVar.f(strA);
        hfVar.c(com.xiaomi.push.g.m451a(context, context.getPackageName()));
        hfVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        hfVar.h(BuildConfig.VERSION_NAME);
        hfVar.a(BuildConfig.VERSION_CODE);
        hfVar.a(gt.Init);
        if (!com.xiaomi.push.j.m632d()) {
            String strD = com.xiaomi.push.i.d(context);
            if (!TextUtils.isEmpty(strD)) {
                hfVar.i(bb.a(strD));
            }
        }
        int iA = com.xiaomi.push.i.a();
        if (iA >= 0) {
            hfVar.c(iA);
        }
        he heVar2 = new he();
        heVar2.c(gp.HybridRegister.f597a);
        heVar2.b(b.m75a(context).m76a());
        heVar2.d(context.getPackageName());
        heVar2.a(hp.a(hfVar));
        heVar2.a(aj.a());
        u.a(context).a((u) heVar2, gf.Notification, (gs) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String messageId = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(messageId)) {
            messageId = miPushMessage.getMessageId();
        }
        t.a(context, messageId);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("do not ack message, message is null");
            return;
        }
        try {
            gv gvVar = new gv();
            gvVar.b(b.m75a(context).m76a());
            gvVar.a(miPushMessage.getMessageId());
            gvVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            gvVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                gvVar.c(miPushMessage.getTopic());
            }
            u.a(context).a((u) gvVar, gf.AckMessage, false, au.a(PushMessageHelper.generateMessage(miPushMessage)));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("last_pull_notification_");
        sb.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1L)) > 300000;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        b.a aVarA = b.m75a(context).a(str);
        if (aVarA == null) {
            return;
        }
        hl hlVar = new hl();
        hlVar.a(aj.a());
        hlVar.d(str);
        hlVar.b(aVarA.f111a);
        hlVar.c(aVarA.f12358c);
        hlVar.e(aVarA.f12357b);
        he heVar = new he();
        heVar.c(gp.HybridUnregister.f597a);
        heVar.b(b.m75a(context).m76a());
        heVar.d(context.getPackageName());
        heVar.a(hp.a(hlVar));
        heVar.a(aj.a());
        u.a(context).a((u) heVar, gf.Notification, (gs) null);
        b.m75a(context).b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        x.a(context, linkedList);
    }
}
