package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.xiaomi.push.gf;
import com.xiaomi.push.hb;
import com.xiaomi.push.hi;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.x;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class FCMPushHelper {
    private static void a(Context context, hb hbVar) {
        try {
            MiPushMessage miPushMessageGenerateMessage = PushMessageHelper.generateMessage((hi) r.a(context, hbVar), hbVar.m529a(), false);
            PushMessageReceiver pushMessageReceiverA = f.a(context);
            if (pushMessageReceiverA != null) {
                pushMessageReceiverA.onNotificationMessageArrived(context, miPushMessageGenerateMessage);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("fcm broadcast notification come error ", th);
        }
    }

    private static boolean b(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static void clearToken(Context context) {
        f.m96a(context, d.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return f.m99a(context, d.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver pushMessageReceiverA;
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (pushMessageReceiverA = f.a(context)) == null) {
            return;
        }
        pushMessageReceiverA.onNotificationMessageArrived(context, f.a(str));
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver pushMessageReceiverA;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (pushMessageReceiverA = f.a(context)) != null) {
            pushMessageReceiverA.onReceivePassThroughMessage(context, f.a(str));
        }
        String str2 = map.get("mipushContainer");
        if (TextUtils.isEmpty(str2)) {
            return new HashMap();
        }
        try {
            byte[] bArrDecode = Base64.decode(str2, 2);
            a(context, com.xiaomi.push.service.u.a(bArrDecode));
            a(context, bArrDecode);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("fcm notify notification error ", th);
        }
        return a(context);
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putBoolean("is_xmsf_sup_decrypt", ((long) com.xiaomi.push.j.b(context)) >= 50002000).apply();
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(f.c(d.ASSEMBLE_PUSH_FCM), UPushThirdTokenCallback.TYPE_FCM, 1L, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        f.m97a(context, d.ASSEMBLE_PUSH_FCM, str);
    }

    private static Map<String, String> a(Context context) {
        HashMap map = new HashMap();
        map.put("actionType", String.valueOf(gf.AckMessage.a()));
        map.put("deviceStatus", String.valueOf((int) hp.a(context, context.getPackageName())));
        map.put("mat", Long.toString(System.currentTimeMillis()));
        return map;
    }

    private static void a(Context context, byte[] bArr) {
        boolean zM120a = u.a(context).m120a();
        boolean z = !"com.xiaomi.xmsf".equals(context.getPackageName());
        boolean zM67a = m67a(context);
        boolean z2 = false;
        if (zM120a && z && zM67a) {
            bArr = com.xiaomi.push.service.l.a(bArr, b.m75a(context).d());
            if (bArr == null) {
                com.xiaomi.channel.commonutils.logger.b.m50a("fcm message encrypt failed");
            } else {
                String strEncodeToString = Base64.encodeToString(bArr, 2);
                if (TextUtils.isEmpty(strEncodeToString)) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("fcm message buf base64 encode failed");
                } else {
                    Intent intent = new Intent(an.n);
                    intent.setPackage("com.xiaomi.xmsf");
                    intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.push.service.XMPushService");
                    intent.putExtra("ext_fcm_container_buffer", strEncodeToString);
                    intent.putExtra("mipush_app_package", context.getPackageName());
                    context.startService(intent);
                    com.xiaomi.channel.commonutils.logger.b.m50a("fcm message reroute to xmsf");
                    z2 = true;
                }
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m50a(String.format("xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s", Boolean.valueOf(zM120a), Boolean.valueOf(z), Boolean.valueOf(zM67a)));
        }
        if (z2) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.b("fcm message post local");
        x.m753a(context, com.xiaomi.push.service.u.a(bArr), bArr);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m67a(Context context) {
        return ((long) com.xiaomi.push.j.b(context)) >= 50002000 && b(context);
    }
}
