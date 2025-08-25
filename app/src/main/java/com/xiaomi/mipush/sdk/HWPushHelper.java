package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HWPushHelper {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f12339a = false;

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static boolean hasNetwork(Context context) {
        return f.m98a(context);
    }

    public static boolean isHmsTokenSynced(Context context) {
        String strA = f.a(context, d.ASSEMBLE_PUSH_HUAWEI, false);
        String strA2 = p.a(context).a(v.UPLOAD_HUAWEI_TOKEN);
        return (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2) || !"synced".equals(strA2)) ? false : true;
    }

    public static boolean isUserOpenHmsPush(Context context) {
        return MiPushClient.getOpenHmsPush(context);
    }

    public static boolean needConnect() {
        return f12339a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        r2 = r3.getString("pushMsg");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void notifyHmsNotificationMessageClicked(android.content.Context r5, java.lang.String r6) throws org.json.JSONException {
        /*
            java.lang.String r0 = "pushMsg"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r2 = ""
            if (r1 != 0) goto L37
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Exception -> L2f
            r1.<init>(r6)     // Catch: java.lang.Exception -> L2f
            int r6 = r1.length()     // Catch: java.lang.Exception -> L2f
            if (r6 <= 0) goto L37
            r6 = 0
        L16:
            int r3 = r1.length()     // Catch: java.lang.Exception -> L2f
            if (r6 >= r3) goto L37
            org.json.JSONObject r3 = r1.getJSONObject(r6)     // Catch: java.lang.Exception -> L2f
            boolean r4 = r3.has(r0)     // Catch: java.lang.Exception -> L2f
            if (r4 == 0) goto L2c
            java.lang.String r6 = r3.getString(r0)     // Catch: java.lang.Exception -> L2f
            r2 = r6
            goto L37
        L2c:
            int r6 = r6 + 1
            goto L16
        L2f:
            r6 = move-exception
            java.lang.String r6 = r6.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r6)
        L37:
            com.xiaomi.mipush.sdk.PushMessageReceiver r6 = com.xiaomi.mipush.sdk.f.a(r5)
            if (r6 == 0) goto L51
            com.xiaomi.mipush.sdk.MiPushMessage r0 = com.xiaomi.mipush.sdk.f.a(r2)
            java.util.Map r1 = r0.getExtra()
            java.lang.String r2 = "notify_effect"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L4e
            return
        L4e:
            r6.onNotificationMessageClicked(r5, r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.HWPushHelper.notifyHmsNotificationMessageClicked(android.content.Context, java.lang.String):void");
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) throws JSONException {
        String string = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("content")) {
                    string = jSONObject.getString("content");
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
        }
        PushMessageReceiver pushMessageReceiverA = f.a(context);
        if (pushMessageReceiverA != null) {
            pushMessageReceiverA.onReceivePassThroughMessage(context, f.a(string));
        }
    }

    public static void registerHuaWeiAssemblePush(Context context) {
        AbstractPushManager abstractPushManagerA = e.a(context).a(d.ASSEMBLE_PUSH_HUAWEI);
        if (abstractPushManagerA != null) {
            abstractPushManagerA.register();
        }
    }

    public static void reportError(String str, int i2) {
        f.a(str, i2);
    }

    public static synchronized void setConnectTime(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
    }

    public static synchronized void setGetTokenTime(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
    }

    public static void setNeedConnect(boolean z) {
        f12339a = z;
    }

    public static synchronized boolean shouldGetToken(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1L)) > 172800000;
    }

    public static synchronized boolean shouldTryConnect(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > com.heytap.mcssdk.constant.a.r;
    }

    public static void uploadToken(Context context, String str) {
        f.m97a(context, d.ASSEMBLE_PUSH_HUAWEI, str);
    }
}
